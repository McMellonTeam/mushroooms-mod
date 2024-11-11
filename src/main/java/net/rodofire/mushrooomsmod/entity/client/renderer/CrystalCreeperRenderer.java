package net.rodofire.mushrooomsmod.entity.client.renderer;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.client.model.CrystalCreeperModel;
import net.rodofire.mushrooomsmod.entity.custom.CrystalCreeperEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CrystalCreeperRenderer extends GeoEntityRenderer<CrystalCreeperEntity> {
    CrystalCreeperEntity entity;
    public CrystalCreeperRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new CrystalCreeperModel());
    }

    @Override
    public Identifier getTextureLocation(CrystalCreeperEntity animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "textures/entity/crystal_creeper.png");
    }

    @Override
    public void renderFinal(MatrixStack poseStack, CrystalCreeperEntity animatable, BakedGeoModel model, VertexConsumerProvider bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay, int renderColor) {
        float g = animatable.getClientFuseTime(partialTick);
        float h = 1.0f + MathHelper.sin(g * 100.0f) * g * 0.01f;
        g = MathHelper.clamp(g, 0.0f, 1.0f);
        g *= g;
        g *= g;
        float i = (1.0f + g * 0.4f) * h;
        float j = (1.0f + g * 0.1f) / h;

        poseStack.scale(i, j, i);
        super.renderFinal(poseStack, animatable, model, bufferSource, buffer, partialTick, packedLight, packedOverlay, renderColor);
    }

    @Override
    public int getPackedOverlay(CrystalCreeperEntity animatable, float u, float partialTick) {
        return super.getPackedOverlay(animatable, getSwellOverlay(animatable, u), partialTick);
    }

    protected float getSwellOverlay(CrystalCreeperEntity entity, float u) {
        float swell = entity.getClientFuseTime(u);

        return (int) (swell * 10.0F) % 2 == 0 ? 0.0F : MathHelper.clamp(swell, 0.5F, 1.0F);
    }

}
