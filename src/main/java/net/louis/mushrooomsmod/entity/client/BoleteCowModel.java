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


    /*public final void handleAnimations(BoleteCowEntity animatable, long instanceId, AnimationState<BoleteCowEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }*/

}
