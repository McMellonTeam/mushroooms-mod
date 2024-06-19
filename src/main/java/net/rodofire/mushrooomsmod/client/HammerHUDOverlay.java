package net.rodofire.mushrooomsmod.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.item.Custom.HammerItem;

public class HammerHUDOverlay implements HudRenderCallback {

    private static final Identifier HAMMER = new Identifier(MushrooomsMod.MOD_ID,
            "textures/mushrooomsmodhud/hammeruse.png");
    private static final Identifier HAMMER_FULL = new Identifier(MushrooomsMod.MOD_ID, "textures/mushrooomsmodhud/hammeruse_full.png");


    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        PlayerEntity player = client.player;
        if (player != null) {

            ItemStack item = player.getMainHandStack();
            HitResult hit = player.raycast(5, tickDelta, false);

            if (item.getItem() instanceof HammerItem && hit.getType() == HitResult.Type.BLOCK) {
                Direction direction = player.getHorizontalFacing();
                Direction direction1 = player.getMovementDirection();
                World world = player.getWorld();
                Vec3d seconpos = hit.getPos().offset(direction, 0.1);
                Vec3d seconpos1 = hit.getPos().offset(direction1, 1.1);

                BlockPos.Mutable mutable = new BlockPos.Mutable();
                BlockPos.Mutable mutable1 = new BlockPos.Mutable();
                mutable.set(seconpos.x, seconpos.y, seconpos.z);
                mutable1.set(seconpos1.x, seconpos1.y, seconpos1.z);

                if (world.getBlockState(mutable).getBlock() == ModBlocks.FORGE_BLOCK || world.getBlockState(mutable1).getBlock() == ModBlocks.FORGE_BLOCK) {
                    int width = client.getWindow().getScaledWidth();
                    int height = client.getWindow().getScaledHeight();

                    int x = width / 2 - 6;
                    int y = height / 2 + 10;

                    RenderSystem.setShader(GameRenderer::getPositionTexProgram);
                    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                    RenderSystem.setShaderTexture(0, HAMMER);


                    int progress = ((HammerItem) item.getItem()).getHammerUse();
                    float proportion = 1 - ((float) progress / 200);
                    int filled = (int) (16 * proportion);

                    drawContext.drawTexture(HAMMER, x, y, 0, 0, 16, 16, 16, 16);
                    RenderSystem.setShaderTexture(0, HAMMER_FULL);
                    drawContext.drawTexture(HAMMER_FULL, x, y, 0, 0, filled, 16, 16, 16);
                }
            }
        }
    }
}
