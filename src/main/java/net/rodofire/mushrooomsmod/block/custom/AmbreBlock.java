package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.rodofire.mushrooomsmod.block.ModBlocks;

import java.util.ArrayList;
import java.util.List;

public class AmbreBlock extends Block {
    public AmbreBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.isClient) {
            if (world.getBlockState(pos.down()).getBlock() == Blocks.SAND) {
                if (Random.create().nextInt(3) == 0) {
                    world.setBlockState(pos, ModBlocks.AMBER_BLOCK_SANDIFIED.getDefaultState());
                }
                double x = ((double) Random.create().nextBetween(110, 150) / 100) * randomDirection();
                double y = ((double) Random.create().nextBetween(110, 150) / 100) * randomDirection();
                double z = ((double) Random.create().nextBetween(110, 150) / 100) * randomDirection();
                Vec3d vec3d = new Vec3d(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
                world.spawnParticles(ParticleTypes.COMPOSTER,
                        vec3d.x, vec3d.y, vec3d.z, 0,0.0D, 0.0D, 0.0D, 0.0001f);
            }
        }
    }

    public int randomDirection() {
        return Random.create().nextBetween(0, 1) == 0 ? 1 : -1;
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }


    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.mushrooomsmod.ambre_block").formatted(Formatting.GOLD));
        super.appendTooltip(stack, context, tooltip, options);
    }
}
