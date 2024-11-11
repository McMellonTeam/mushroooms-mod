package net.rodofire.mushrooomsmod.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class ForgeRecipe implements Recipe<SingleStackRecipeInput> {
    @NotNull
    private final ItemStack output;
    @NotNull
    private final Ingredient recipeItem;

    public ForgeRecipe(Ingredient recipeItem, ItemStack output) {
        this.output = output;
        this.recipeItem = recipeItem;
    }

    @Override
    public boolean matches(SingleStackRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }

        return recipeItem.test(input.item());
    }

    @Override
    public ItemStack craft(SingleStackRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<SingleStackRecipeInput>> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<? extends Recipe<SingleStackRecipeInput>> getType() {
        return Type.INSTANCE;
    }


    @Override
    public IngredientPlacement getIngredientPlacement() {
        return IngredientPlacement.forSingleSlot(recipeItem);
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return null;
    }

    public Ingredient getRecipeItem() {
        return recipeItem;
    }

    public ItemStack getOutput() {
        return output;
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

        private static final PacketCodec<RegistryByteBuf, ForgeRecipe> PACKET_CODEC = PacketCodec.ofStatic(Serializer::write, Serializer::read);
        /*
        private static final MapCodec<ForgeRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group((Ingredient.ENTRIES_CODEC.fieldOf("ingredients")).flatXmap(ingredients ->
            DataResult.success(Ingredient.EMPTY, ingredients)
        , DataResult.success(Ingredient.ofItem(i))).forGetter(ForgeRecipe::getRecipeItems), (ItemStack.VALIDATED_CODEC.fieldOf("result")).forGetter(recipe -> recipe.output)).apply(instance, ForgeRecipe::new));
*/
        private static final MapCodec<ForgeRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(recipe -> recipe.recipeItem),
                ItemStack.CODEC.fieldOf("output").forGetter(recipe -> recipe.output)
        ).apply(instance, ForgeRecipe::new));

        @Override
        public MapCodec<ForgeRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, ForgeRecipe> packetCodec() {
            return PACKET_CODEC;
        }

        public static ForgeRecipe read(RegistryByteBuf buf) {
            Ingredient inputs;

            inputs = Ingredient.PACKET_CODEC.decode(buf);

            ItemStack output = ItemStack.PACKET_CODEC.decode(buf);

            return new ForgeRecipe(inputs, output);
        }

        public static void write(RegistryByteBuf buf, ForgeRecipe recipe) {
            buf.writeInt(1);

            Ingredient.PACKET_CODEC.encode(buf, recipe.getRecipeItem());
            ItemStack.PACKET_CODEC.encode(buf, recipe.getOutput());
        }
    }
}

