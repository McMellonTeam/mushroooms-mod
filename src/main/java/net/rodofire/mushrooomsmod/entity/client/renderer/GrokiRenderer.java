package net.rodofire.mushrooomsmod.entity.client.renderer;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.client.model.GrokiModel;
import net.rodofire.mushrooomsmod.entity.custom.GrokiEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GrokiRenderer extends GeoEntityRenderer<GrokiEntity> {
    public GrokiRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new GrokiModel());
    }

    @Override
    public Identifier getTextureLocation(GrokiEntity animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "textures/entity/groki.png");
    }

    @Override
    public void renderFinal(MatrixStack poseStack, GrokiEntity animatable, BakedGeoModel model, VertexConsumerProvider bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay, int renderColor) {
        if (animatable.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }
        super.renderFinal(poseStack, animatable, model, bufferSource, buffer, partialTick, packedLight, packedOverlay, renderColor);
    }
}
