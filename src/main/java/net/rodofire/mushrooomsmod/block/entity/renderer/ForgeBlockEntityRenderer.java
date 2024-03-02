package net.rodofire.mushrooomsmod.block.entity.renderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.block.entity.ForgeBlockEntity;

import java.util.ArrayList;

public class ForgeBlockEntityRenderer implements BlockEntityRenderer<ForgeBlockEntity> {
    public ForgeBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }
    @Override
    public void render(ForgeBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack stack;
        ArrayList<ItemStack>  stackList = entity.getRenderStack();
        System.out.println(stackList);
        if (stackList.size()<=1||stackList.get(0).getCount()==0) {
            stack = stackList.get(0);
            if (stack.getCount()!=0){
                if (stack.getCount()==1) {
                    renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.5f,1f,0.5f,0.35f,0.35f,0.35f);
                } else if (stack.getCount()<=10) {
                    renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.5f,1f,0.5f,0.35f,0.35f,0.35f);
                    renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.55f,1.02f,0.55f,0.35f,0.35f,0.35f);
                }else if(stack.getCount()>10) {
                    renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.45f, 1f, 0.45f, 0.35f, 0.35f, 0.35f);
                    renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.5f, 1.02f, 0.5f, 0.35f, 0.35f, 0.35f);
                    renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.55f, 1.04f, 0.55f, 0.35f, 0.35f, 0.35f);
                }
            }else if (stackList.size()==2){
                stack = stackList.get(1);
                if (stack.getCount()==1) {
                    renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.5f,1f,0.5f,0.35f,0.35f,0.35f);
                } else if (stack.getCount()<=10) {
                    renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.5f,1f,0.5f,0.35f,0.35f,0.35f);
                    renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.55f,1.02f,0.55f,0.35f,0.35f,0.35f);
                }else if(stack.getCount()>10) {
                    renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.45f,1f,0.45f,0.35f,0.35f,0.35f);
                    renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.5f,1.02f,0.5f,0.35f,0.35f,0.35f);
                    renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.55f,1.04f,0.55f,0.35f,0.35f,0.35f);
                }
            }


        }else {
            stack = stackList.get(0);
            if (stack.getCount()<=1) {
                renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.6f,1f,0.6f,0.35f,0.35f,0.35f);
            } else if (stack.getCount()<=10) {
                renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.6f,1f,0.6f,0.35f,0.35f,0.35f);
                renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.65f,1.02f,0.65f,0.35f,0.35f,0.35f);
            }else {
                renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.6f,1f,0.6f,0.35f,0.35f,0.35f);
                renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.65f,1.02f,0.65f,0.35f,0.35f,0.35f);
                renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.7f,1.04f,0.7f,0.35f,0.35f,0.35f);
            }

            stack = stackList.get(1);
            if (stack.getCount()<=1) {
                renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.4f,1f,0.4f,0.35f,0.35f,0.35f);
            } else if (stack.getCount()<=10) {
                renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.4f,1f,0.4f,0.35f,0.35f,0.35f);
                renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.35f,1.02f,0.35f,0.35f,0.35f,0.35f);
            }else {
                renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.4f,1f,0.4f,0.4f,0.35f,0.35f);
                renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.35f,1.02f,0.35f,0.35f,0.35f,0.35f);
                renderMatrix(matrices,itemRenderer,stack,entity,vertexConsumers,0.3f,1.04f,0.3f,0.35f,0.35f,0.35f);
            }
        }

    }
    public void renderMatrix(MatrixStack matrices, ItemRenderer itemRenderer,ItemStack stack,ForgeBlockEntity entity, VertexConsumerProvider vertexConsumers, float x, float y, float z,float x2, float y2, float z2){
        matrices.push();
        matrices.translate(x, y, z);
        matrices.scale(x2, y2, z2);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(270));
        itemRenderer.renderItem(stack, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
    }


    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }

}
