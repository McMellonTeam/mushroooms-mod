package net.rodofire.mushrooomsmod.entity.client.model;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.custom.GrokiEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class GrokiModel extends GeoModel<GrokiEntity> {
    @Override
    public Identifier getModelResource(GrokiEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "geo/groki.geo.json");
    }

    @Override
    public Identifier getTextureResource(GrokiEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "textures/entity/groki");
    }

    @Override
    public Identifier getAnimationResource(GrokiEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "animations/groki.animation.json");
    }

    @Override
    public void setCustomAnimations(GrokiEntity animatable, long instanceId, AnimationState<GrokiEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
