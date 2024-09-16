package net.rodofire.mushrooomsmod.recipe;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.List;

public class ForgeRecipe implements Recipe<SingleStackRecipeInput> {
    private final ItemStack output;
    private final List<Ingredient> recipeItems;

    public ForgeRecipe(List<Ingredient> recipeItems, ItemStack output) {
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SingleStackRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }

        return recipeItems.get(0).test(input.item());
    }

    @Override
    public ItemStack craft(SingleStackRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.ofSize(this.recipeItems.size());
        list.addAll(recipeItems);
        return list;
    }


    public static class Type implements RecipeType<ForgeRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "forge_crafting";

        private Type() {
        }
    }


    public static class Serializer implements RecipeSerializer<ForgeRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "forge_crafting";

        /*public static final MapCodec<ForgeRecipe> CODEC = RecordCodecBuilder.mapCodec(in -> in.group(
                validateAmount(Ingredient.DISALLOW_EMPTY_CODEC, 9).fieldOf("ingredients").forGetter(ForgeRecipe::getIngredients),
                ItemStack.CODEC.fieldOf("output").forGetter(r -> r.output)
        ).apply(in, ForgeRecipe::new));
*/
        private static final PacketCodec<RegistryByteBuf, ForgeRecipe> PACKET_CODEC = PacketCodec.ofStatic(Serializer::write, Serializer::read);

        /*private static Codec<List<Ingredient>> validateAmount(Codec<Ingredient> delegate, int max) {
            return Codecs.validate(Codecs.validate(
                    delegate.listOf(), list -> list.size() > max ? DataResult.error(() -> "Recipe has too many ingredients!") : DataResult.success(list)
            ), list -> list.isEmpty() ? DataResult.error(() -> "Recipe has no ingredients!") : DataResult.success(list));
        }*/


        private static final MapCodec<ForgeRecipe> CODEC = RecordCodecBuilder.mapCodec( instance -> instance.group( (Ingredient.DISALLOW_EMPTY_CODEC.listOf().fieldOf("ingredients")).flatXmap(ingredients -> {
            Ingredient[] ingredients2 = (Ingredient[])ingredients.stream().filter(ingredient -> !ingredient.isEmpty()).toArray(Ingredient[]::new);
            if (ingredients2.length == 0) {
                return DataResult.error(() -> "No ingredients for shapeless recipe");
            }
            if (ingredients2.length > 9) {
                return DataResult.error(() -> "Too many ingredients for shapeless recipe");
            }
            return DataResult.success(DefaultedList.copyOf(Ingredient.EMPTY, ingredients2));
        }, DataResult::success).forGetter(recipe -> recipe.getIngredients()),(ItemStack.VALIDATED_CODEC.fieldOf("result")).forGetter(recipe -> recipe.output)).apply(instance, ForgeRecipe::new));

        @Override
        public MapCodec<ForgeRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, ForgeRecipe> packetCodec() {
            return PACKET_CODEC;
        }

        public static ForgeRecipe read(RegistryByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for(int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.PACKET_CODEC.decode(buf));
            }

            ItemStack output = ItemStack.PACKET_CODEC.decode(buf);

            return new ForgeRecipe(inputs, output);
        }

        public static void write(RegistryByteBuf buf, ForgeRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ingredient : recipe.getIngredients()) {
                Ingredient.PACKET_CODEC.encode(buf, ingredient);
            }
            ItemStack.PACKET_CODEC.encode(buf, recipe.getResult(null));
        }
    }
}

