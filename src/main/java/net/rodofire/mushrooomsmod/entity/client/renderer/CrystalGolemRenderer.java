package net.rodofire.mushrooomsmod.entity.client.renderer;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.client.model.CrystalGolemModel;
import net.rodofire.mushrooomsmod.entity.custom.CrystalGolemEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CrystalGolemRenderer extends GeoEntityRenderer<CrystalGolemEntity> {
    public CrystalGolemRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new CrystalGolemModel());
    }

    @Override
    public Identifier getTextureLocation(CrystalGolemEntity animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "textures/entity/crystal_golem.png");
    }

    @Override
    public void render(CrystalGolemEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
