package net.rodofire.mushrooomsmod.entity.client.model;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.custom.BoleteCowEntity;
import net.rodofire.mushrooomsmod.entity.custom.PlotiEntity;
import software.bernie.geckolib.constant.DataTickets;
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

    @Override
    public void setCustomAnimations(BoleteCowEntity animatable, long instanceId, AnimationState<BoleteCowEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }


}
