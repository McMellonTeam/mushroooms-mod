package net.rodofire.mushrooomsmod.block.entity.client.model;

import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.entity.RapangeFlowersBE;
import software.bernie.geckolib.model.GeoModel;

public class RapangeFlowerModel extends GeoModel<RapangeFlowersBE> {
    @Override
    public Identifier getModelResource(RapangeFlowersBE animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "geo/rapange_flower.geo.json");
    }

    @Override
    public Identifier getTextureResource(RapangeFlowersBE animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "textures/block/rapange_flowers.png");
    }

    @Override
    public Identifier getAnimationResource(RapangeFlowersBE animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "animations/rapange_flower.animation.json");
    }
}
