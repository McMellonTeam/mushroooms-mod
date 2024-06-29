package net.rodofire.mushrooomsmod.entity.client.renderer;

import blue.endless.jankson.annotation.Nullable;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.rodofire.mushrooomsmod.entity.client.model.InventoryArmorStandModel;
import net.rodofire.mushrooomsmod.entity.custom.InventoryArmorStandEntity;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.DynamicGeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.ItemArmorGeoLayer;

public class InventoryArmorStandRenderer extends DynamicGeoEntityRenderer<InventoryArmorStandEntity> {
    private static final String LEFT_BOOT = "left_foot";
    private static final String RIGHT_BOOT = "right_foot";
    private static final String LEFT_ARMOR_LEG = "left_leg";
    private static final String RIGHT_ARMOR_LEG = "right_leg";
    private static final String CHESTPLATE = "armor_body";
    private static final String RIGHT_SLEEVE = "right_arm";
    private static final String LEFT_SLEEVE = "left_arm";
    private static final String HELMET = "head";

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
    }
}
