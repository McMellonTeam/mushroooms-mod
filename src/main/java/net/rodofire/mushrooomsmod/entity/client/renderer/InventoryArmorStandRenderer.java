package net.rodofire.mushrooomsmod.entity.client.renderer;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;
import net.rodofire.mushrooomsmod.entity.client.model.InventoryArmorStandModel;
import net.rodofire.mushrooomsmod.entity.custom.InventoryArmorStandEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;
import software.bernie.geckolib.renderer.layer.ItemArmorGeoLayer;
import software.bernie.geckolib.renderer.specialty.DynamicGeoEntityRenderer;


public class InventoryArmorStandRenderer extends DynamicGeoEntityRenderer<InventoryArmorStandEntity> {
    private static final String LEFT_BOOT = "left_foot";
    private static final String RIGHT_BOOT = "right_foot";
    private static final String LEFT_ARMOR_LEG = "left_leg";
    private static final String RIGHT_ARMOR_LEG = "right_leg";
    private static final String CHESTPLATE = "armor_body";
    private static final String RIGHT_SLEEVE = "right_arm";
    private static final String LEFT_SLEEVE = "left_arm";
    private static final String HELMET = "head";


    private static final String LEFT_HAND = "item1";
    private static final String RIGHT_HAND = "item2";

    public static ItemStack offhandItem;
    public static ItemStack mainHandItem;

    public InventoryArmorStandRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new InventoryArmorStandModel());
        addRenderLayer(new ItemArmorGeoLayer<>(this) {
            @Nullable
            @Override
            protected ItemStack getArmorItemForBone(GeoBone bone, InventoryArmorStandEntity animatable) {
                // Return the items relevant to the bones being rendered for additional rendering
                return switch (bone.getName()) {
                    case LEFT_BOOT, RIGHT_BOOT -> this.bootsStack;
                    case LEFT_ARMOR_LEG, RIGHT_ARMOR_LEG -> this.leggingsStack;
                    case CHESTPLATE, RIGHT_SLEEVE, LEFT_SLEEVE -> this.chestplateStack;
                    case HELMET -> this.helmetStack;
                    default -> null;
                };
            }

            // Return the equipment slot relevant to the bone we're using

            @Override
            protected @NotNull EquipmentSlot getEquipmentSlotForBone(GeoBone bone, ItemStack stack, InventoryArmorStandEntity animatable) {
                return switch (bone.getName()) {
                    case LEFT_BOOT, RIGHT_BOOT -> EquipmentSlot.FEET;
                    case LEFT_ARMOR_LEG, RIGHT_ARMOR_LEG -> EquipmentSlot.LEGS;
                    case CHESTPLATE -> EquipmentSlot.CHEST;
                    case HELMET -> EquipmentSlot.HEAD;
                    default -> super.getEquipmentSlotForBone(bone, stack, animatable);
                };
            }

            // Return the ModelPart responsible for the armor pieces we want to render

            @Override
            protected @NotNull ModelPart getModelPartForBone(GeoBone bone, EquipmentSlot slot, ItemStack stack, InventoryArmorStandEntity animatable, BipedEntityModel<?> baseModel) {
                return switch (bone.getName()) {
                    case LEFT_BOOT, LEFT_ARMOR_LEG -> baseModel.leftLeg;
                    case RIGHT_BOOT, RIGHT_ARMOR_LEG -> baseModel.rightLeg;
                    case RIGHT_SLEEVE -> baseModel.rightArm;
                    case LEFT_SLEEVE -> baseModel.leftArm;
                    case CHESTPLATE -> baseModel.body;
                    case HELMET -> baseModel.head;
                    default -> super.getModelPartForBone(bone, slot, stack, animatable, baseModel);
                };
            }
        });

        // Add some held item rendering
        addRenderLayer(new BlockAndItemGeoLayer<>(this) {
            @Nullable
            @Override
            protected ItemStack getStackForBone(GeoBone bone, InventoryArmorStandEntity animatable) {
                // Retrieve the items in the entity's hands for the relevant bone
                return switch (bone.getName()) {
                    case LEFT_HAND -> mainHandItem;
                    case RIGHT_HAND -> offhandItem;
                    default -> null;
                };
            }

            @Override
            protected ModelTransformationMode getTransformTypeForStack(GeoBone bone, ItemStack stack, InventoryArmorStandEntity animatable) {
                // Apply the camera transform for the given hand
                return switch (bone.getName()) {
                    case LEFT_HAND, RIGHT_HAND -> ModelTransformationMode.THIRD_PERSON_RIGHT_HAND;
                    default -> ModelTransformationMode.NONE;
                };
            }

            // Do some quick render modifications depending on what the item is
            @Override
            protected void renderStackForBone(MatrixStack poseStack, GeoBone bone, ItemStack stack, InventoryArmorStandEntity animatable,
                                              VertexConsumerProvider bufferSource, float partialTick, int packedLight, int packedOverlay) {
                if (stack == mainHandItem) {
                    poseStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90f));
                    poseStack.scale(0.7f, 0.7f, 0.7f);

                } else if (stack == offhandItem) {
                    poseStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90f));
                    poseStack.scale(0.7f, 0.7f, 0.7f);
                }

                super.renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick, packedLight, packedOverlay);
            }
        });
    }

    @Override
    public void preRender(MatrixStack poseStack, InventoryArmorStandEntity animatable, BakedGeoModel model, @Nullable VertexConsumerProvider bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        /*super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);

        mainHandItem = animatable.getMainHandStack();
        offhandItem = animatable.getOffHandStack();*/
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
