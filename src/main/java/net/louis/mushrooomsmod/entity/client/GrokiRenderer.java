package net.louis.mushrooomsmod.entity.client;

import net.louis.mushrooomsmod.MushrooomsMod;
import net.louis.mushrooomsmod.entity.custom.GrokiEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GrokiRenderer extends GeoEntityRenderer<GrokiEntity> {
    public GrokiRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new GrokiModel());
    }
    @Override
    public Identifier getTextureLocation(GrokiEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "textures/entity/groki.png");
    }

    @Override
    public void render(GrokiEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
