package net.rodofire.mushrooomsmod.entity.client.model;

import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.custom.BoleteCowEntity;
import net.rodofire.mushrooomsmod.entity.custom.CrystalGolemEntity;
import software.bernie.geckolib.model.GeoModel;

public class CrystalGolemModel extends GeoModel<CrystalGolemEntity> {
    @Override
    public Identifier getModelResource(CrystalGolemEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "geo/crystal_golem.geo.json");
    }

    @Override
    public Identifier getTextureResource(CrystalGolemEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "textures/entity/crystal_golem");
    }

    @Override
    public Identifier getAnimationResource(CrystalGolemEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "animations/crystal_golem.animation.json");
    }
}
