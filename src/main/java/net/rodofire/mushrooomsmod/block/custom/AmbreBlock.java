package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AmbreBlock extends Block {
    public AmbreBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.isClient) {
            if (world.getBlockState(pos.down()).getBlock() == Blocks.SAND) {
                if (Random.create().nextInt(1000) == 0) {
                    world.setBlockState(pos, ModBlocks.AMBER_BLOCK_SANDIFIED.getDefaultState());
                }
                if (Random.create().nextInt(50) == 0) {
                    world.addParticle(ParticleTypes.COMPOSTER,
                            (double) Random.create().nextBetween(-150, 150) / 100, (double) Random.create().nextBetween(-150, 150) / 100, (double) Random.create().nextBetween(-150, 150) / 100,
                            (double) Random.create().nextBetween(-150, 150) / 100, (double) Random.create().nextBetween(-150, 150) / 100, (double) Random.create().nextBetween(-150, 150) / 100);
                }
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.ambre_blockl"));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
