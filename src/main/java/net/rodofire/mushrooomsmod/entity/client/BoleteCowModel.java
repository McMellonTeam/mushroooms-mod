package net.rodofire.mushrooomsmod.entity.client;

import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.custom.BoleteCowEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class BoleteCowModel extends GeoModel<BoleteCowEntity> {

    @Override
    public Identifier getModelResource(BoleteCowEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "geo/bolete_cow.geo.json");
    }

    @Override
    public Identifier getTextureResource(BoleteCowEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "textures/entity/bolete_cow");
    }

    @Override
    public Identifier getAnimationResource(BoleteCowEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "animations/bolete_cow.animation.json");
    }




}
