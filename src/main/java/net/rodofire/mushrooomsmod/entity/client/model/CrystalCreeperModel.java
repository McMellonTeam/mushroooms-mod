package net.rodofire.mushrooomsmod.entity.client.model;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.custom.CrystalCreeperEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CrystalCreeperModel extends GeoModel<CrystalCreeperEntity> {
    @Override
    public Identifier getModelResource(CrystalCreeperEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "geo/crystal_creeper.geo.json");
    }

    @Override
    public Identifier getTextureResource(CrystalCreeperEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "textures/entity/crystal_creeper.png");
    }

    @Override
    public Identifier getAnimationResource(CrystalCreeperEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "animations/crystal_creeper.animation.json");
    }
    @Override
    public void setCustomAnimations(CrystalCreeperEntity animatable, long instanceId, AnimationState<CrystalCreeperEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
