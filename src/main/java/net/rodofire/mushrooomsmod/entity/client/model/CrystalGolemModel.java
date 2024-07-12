package net.rodofire.mushrooomsmod.entity.client.model;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.custom.CrystalGolemEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CrystalGolemModel extends GeoModel<CrystalGolemEntity> {
    @Override
    public Identifier getModelResource(CrystalGolemEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "geo/crystal_golem.geo.json");
    }

    @Override
    public Identifier getTextureResource(CrystalGolemEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "textures/entity/crystal_golem.png");
    }

    @Override
    public Identifier getAnimationResource(CrystalGolemEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "animations/crystal_golem.animation.json");
    }

    @Override
    public void setCustomAnimations(CrystalGolemEntity animatable, long instanceId, AnimationState<CrystalGolemEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
