package net.rodofire.mushrooomsmod.entity.client.model;

import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.custom.SchroomStickEntity;
import software.bernie.geckolib.model.GeoModel;

public class SchroomStickModel extends GeoModel<SchroomStickEntity> {
    @Override
    public Identifier getModelResource(SchroomStickEntity animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "geo/schroom_stick.geo.json");
    }

    @Override
    public Identifier getTextureResource(SchroomStickEntity animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "textures/entity/schroom_stick.png");
    }

    @Override
    public Identifier getAnimationResource(SchroomStickEntity animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "animations/schroom_stick.animation.json");
    }
}
