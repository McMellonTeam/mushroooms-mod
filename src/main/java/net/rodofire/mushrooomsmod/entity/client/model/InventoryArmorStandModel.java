package net.rodofire.mushrooomsmod.entity.client.model;

import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.custom.InventoryArmorStandEntity;
import software.bernie.geckolib.model.GeoModel;

public class InventoryArmorStandModel extends GeoModel<InventoryArmorStandEntity> {
    @Override
    public Identifier getModelResource(InventoryArmorStandEntity animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "geo/inventory_armor_stand.geo.json");
    }

    @Override
    public Identifier getTextureResource(InventoryArmorStandEntity animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "textures/entity/inventory_armor_stand.png");
    }

    @Override
    public Identifier getAnimationResource(InventoryArmorStandEntity animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "animations/inventory_armor_stand.animation.json");
    }
}
