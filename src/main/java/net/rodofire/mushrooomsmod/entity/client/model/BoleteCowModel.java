package net.rodofire.mushrooomsmod.entity.client.model;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.custom.BoleteCowEntity;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class BoleteCowModel extends GeoModel<BoleteCowEntity> {

    @Override
    public Identifier getModelResource(BoleteCowEntity animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "geo/bolete_cow.geo.json");
    }

    @Override
    public Identifier getTextureResource(BoleteCowEntity animatable) {

        return Identifier.of(MushrooomsMod.MOD_ID, "textures/entity/bolete_cow.png");

    }

    @Override
    public Identifier getAnimationResource(BoleteCowEntity animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "animations/bolete_cow.animation.json");
    }

    @Override
    public void setCustomAnimations(BoleteCowEntity animatable, long instanceId, AnimationState<BoleteCowEntity> animationState) {
        GeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }


}
