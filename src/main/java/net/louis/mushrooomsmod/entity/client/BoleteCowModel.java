package net.louis.mushrooomsmod.entity.client;

import net.louis.mushrooomsmod.MushrooomsMod;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

public class BoleteCowModel extends GeoModel {
    @Override
    public Identifier getModelResource(GeoAnimatable animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "geo/bolete_cow.geo.json");
    }

    @Override
    public Identifier getTextureResource(GeoAnimatable animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "textures/entity/bolete_cow");
    }

    @Override
    public Identifier getAnimationResource(GeoAnimatable animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "animations/bolete_cow.animation.json");
    }
}
