package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class PinkCrystal extends Block implements GeoRenderer {
    public PinkCrystal(Settings settings) {
        super(settings);
    }


    @Override
    public GeoModel getGeoModel() {
        return null;
    }

    @Override
    public GeoAnimatable getAnimatable() {
        return null;
    }

    @Override
    public void fireCompileRenderLayersEvent() {

    }


    @Override
    public boolean firePreRenderEvent(MatrixStack poseStack, BakedGeoModel model, VertexConsumerProvider bufferSource, float partialTick, int packedLight) {
        return false;
    }

    @Override
    public void firePostRenderEvent(MatrixStack poseStack, BakedGeoModel model, VertexConsumerProvider bufferSource, float partialTick, int packedLight) {

    }

    @Override
    public void updateAnimatedTextureFrame(GeoAnimatable animatable) {

    }
}
