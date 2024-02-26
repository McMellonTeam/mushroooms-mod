package net.louis.mushrooomsmod.entity.client;

import net.louis.mushrooomsmod.MushrooomsMod;
import net.louis.mushrooomsmod.entity.custom.BoleteCowEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

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
