package net.rodofire.mushrooomsmod.recipe;

import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.*;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.village.TradedItem;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.util.ModTags;

import java.util.ArrayList;
import java.util.List;

public class ForgeRecipe implements Recipe<SingleStackRecipeInput> {
    private final ItemStack output;
    private final List<Ingredient> recipeItems;
    private String group;

    public ForgeRecipe(List<Ingredient> recipeItems, ItemStack output, String group) {
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
        return /*Serializer.INSTANCE;*/ null;
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

    public static interface RecipeFactory<T extends ForgeRecipe> {
        public T create(String var1, Ingredient var2, ItemStack var3);
    }
}

    /*public static class Serializer <T extends ForgeRecipe> implements RecipeSerializer<T> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "forge_crafting";

       //public final MapCodec<ForgeRecipe> CODEC = RecordCodecBuilder.create(in -> in.group(
       //        validateAmount(Ingredient.DISALLOW_EMPTY_CODEC, 9).fieldOf("ingredients").forGetter(ForgeRecipe::getIngredients),
       //        ItemStack.ITEM_CODEC.fieldOf("output").forGetter(r -> r.output.getRegistryEntry())
       //).apply(in, ForgeRecipe::new));

       //private Codec<List<Ingredient>> validateAmount(Codec<Ingredient> delegate, int max) {
       //    return MapCodec.validate(Codecs.validate(
       //            delegate.listOf(), list -> list.size() > max ? DataResult.error(() -> "Recipe has too many ingredients!") : DataResult.success(list)
       //    ), list -> list.isEmpty() ? DataResult.error(() -> "Recipe has no ingredients!") : DataResult.success(list));
       //}


        //final CuttingRecipe.RecipeFactory<T> recipeFactory;
        //private final MapCodec<T> codec;
        //private final PacketCodec<RegistryByteBuf, T> packetCodec;


        protected Serializer(ForgeRecipe.RecipeFactory<T> recipeFactory) {


            //this.packetCodec = PacketCodec.tuple(PacketCodecs.STRING, recipe -> recipe.group, Ingredient.PACKET_CODEC, recipe -> recipe.ingredient, ItemStack.PACKET_CODEC, recipe -> recipe.result, recipeFactory::create);
        }

        //@Override
        //public MapCodec<T> codec() {
        //    return this.codec;
        //}
//
        //@Override
        //public PacketCodec<RegistryByteBuf, T> packetCodec() {
        //    return this.packetCodec;
        //}



        /*@Override
        public ForgeRecipe read(PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new ForgeRecipe(inputs, output);
        }

        @Override
        public void write(PacketByteBuf buf, ForgeRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            buf.writeItemStack(recipe.getResult(null));
        }
    }
}*/

/*public class ForgeRecipe implements Recipe<SingleStackRecipeInput> {

    final ItemStack output;
    final List<Ingredient> recipeItems;

    public ForgeRecipe(List<Ingredient> recipeItems, ItemStack output) {
        this.recipeItems = recipeItems;
        this.output = output;
    }

    public ForgeRecipe(String s, Ingredient ingredient, ItemStack itemStack) {
        this.recipeItems = new ArrayList<Ingredient>();
        this.recipeItems.add(ingredient);

        this.output = itemStack;
    }

    @Override
    public boolean matches(SingleStackRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }

        return recipeItems.get(0).test(inventory.getStack(0));
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

    public static interface RecipeFactory<T extends ForgeRecipe> {
        public T create(String var1, Ingredient var2, ItemStack var3);
    }

    public static class Serializer <T extends ForgeRecipe> implements RecipeSerializer<T> {

        private final MapCodec<T> codec;
        private final PacketCodec<RegistryByteBuf, T> packetCodec;

        public static final Serializer INSTANCE = new Serializer(ForgeRecipe::new);
        public static final String ID = "forge_crafting";

        ForgeRecipe.RecipeFactory<T> recipeFactory;

        protected Serializer(ForgeRecipe.RecipeFactory<T> recipeFactory) {
            this.recipeFactory = recipeFactory;

            this.codec = RecordCodecBuilder.mapCodec(instance -> instance.group(((MapCodec)Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient")).forGetter(ForgeRecipe::getIngredients), ((MapCodec)ItemStack.VALIDATED_CODEC.fieldOf("result")).forGetter(recipe -> recipe.output)).apply((Applicative<ForgeRecipe, ?>)instance, recipeFactory::create));

            this.packetCodec = PacketCodec.tuple(Ingredient.PACKET_CODEC, recipe -> recipe.recipeItems, ItemStack.PACKET_CODEC, recipe -> recipe.output, recipeFactory::create);

            new TradedItem(Items.LEVER,5);

        }




        @Override
        public MapCodec<T> codec() {
            return this.codec;
        }

        @Override
        public PacketCodec<RegistryByteBuf, T> packetCodec() {
            return this.packetCodec;
        }
    }
}*/

//public class ForgeRecipe
//        implements Recipe<SingleStackRecipeInput> {
//    protected final Ingredient ingredient;
//    protected final ItemStack result;
//    private final RecipeType<?> type;
//    private final RecipeSerializer<?> serializer;
//    protected final String group;
//
//    public ForgeRecipe(RecipeType<?> type, RecipeSerializer<?> serializer, String group, Ingredient ingredient, ItemStack result) {
//        this.type = type;
//        this.serializer = serializer;
//        this.group = group;
//        this.ingredient = ingredient;
//        this.result = result;
//    }
//
//
//    @Override
//    public RecipeType<?> getType() {
//        return this.type;
//    }
//
//    @Override
//    public RecipeSerializer<?> getSerializer() {
//        return this.serializer;
//    }
//
//    @Override
//    public String getGroup() {
//        return this.group;
//    }
//
//    @Override
//    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
//        return this.result;
//    }
//
//    @Override
//    public DefaultedList<Ingredient> getIngredients() {
//        DefaultedList<Ingredient> defaultedList = DefaultedList.of();
//        defaultedList.add(this.ingredient);
//        return defaultedList;
//    }
//
//    @Override
//    public boolean fits(int width, int height) {
//        return true;
//    }
//
//    @Override
//    public boolean matches(SingleStackRecipeInput input, World world) {
//        return this.ingredient.test(input.item());
//    }
//
//    @Override
//    public ItemStack craft(SingleStackRecipeInput singleStackRecipeInput, RegistryWrapper.WrapperLookup wrapperLookup) {
//        return this.result.copy();
//    }
//
//    public static interface RecipeFactory<T extends ForgeRecipe> {
//        public T create(String var1, Ingredient var2, ItemStack var3);
//
//        Object create(Object o, Object o1, Object o2);
//    }
//
//    public static class Serializer<T extends ForgeRecipe>
//            implements RecipeSerializer<T> {
//        final ForgeRecipe.RecipeFactory<T> recipeFactory;
//        private final MapCodec<T> codec;
//        private final PacketCodec<RegistryByteBuf, T> packetCodec;
//
//        protected Serializer(ForgeRecipe.RecipeFactory<T> recipeFactory) {
//            this.recipeFactory = recipeFactory;
//            this.codec = RecordCodecBuilder.mapCodec(instance -> instance.group(Codec.STRING.optionalFieldOf("group", "").forGetter(recipe -> recipe.group), ((MapCodec)Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient")).forGetter(recipe -> recipe.ingredient), ((MapCodec)ItemStack.VALIDATED_CODEC.fieldOf("result")).forGetter(recipe -> recipe.result)).apply(instance, recipeFactory::create));
//            this.packetCodec = PacketCodec.tuple(PacketCodecs.STRING, recipe -> recipe.group, Ingredient.PACKET_CODEC, recipe -> recipe.ingredient, ItemStack.PACKET_CODEC, recipe -> recipe.result, recipeFactory::create);
//        }
//
//        @Override
//        public MapCodec<T> codec() {
//            return this.codec;
//        }
//
//        @Override
//        public PacketCodec<RegistryByteBuf, T> packetCodec() {
//            return this.packetCodec;
//        }
//    }
//}