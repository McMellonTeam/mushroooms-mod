package net.rodofire.mushrooomsmod.entity.client.renderer;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.client.model.PlotiModel;
import net.rodofire.mushrooomsmod.entity.custom.PlotiEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PlotiRenderer extends GeoEntityRenderer<PlotiEntity> {

    public PlotiRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new PlotiModel());
    }

    @Override
    public Identifier getTextureLocation(PlotiEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "textures/entity/ploti.png");
    }

    @Override
    public void render(PlotiEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if (entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
