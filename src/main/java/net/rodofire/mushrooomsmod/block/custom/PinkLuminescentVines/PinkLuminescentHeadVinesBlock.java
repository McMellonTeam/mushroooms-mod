package net.rodofire.mushrooomsmod.block.custom.PinkLuminescentVines;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.util.ModProperties;

import java.util.function.ToIntFunction;

public class PinkLuminescentHeadVinesBlock extends Block {
    public static final VoxelShape SHAPE = Block.createCuboidShape(7.0, 11.0, 7.0, 8.0, 15.0, 8.0);
    public static final BooleanProperty MANY_VINES = ModProperties.MANY_VINES;

    public PinkLuminescentHeadVinesBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }


    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        BlockState blocAuDessus = world.getBlockState(pos.up());
        if (blocAuDessus.getBlock() == ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK || blocAuDessus.getBlock() == ModBlocks.PINK_LUMINESCENT_BODY_VINES) {
            BlockState blockState = state.with(MANY_VINES, true);
            world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
            return ActionResult.SUCCESS;
        }
        BlockState blockState = state.with(MANY_VINES, false);
        world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
        return ActionResult.SUCCESS;
    }

    public static int getluminancesupplier(int luminance, World world, BlockPos pos) {
        BlockState blocAuDessus = world.getBlockState(pos.up());
        if (blocAuDessus.getBlock() == ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK || blocAuDessus.getBlock() == ModBlocks.PINK_LUMINESCENT_BODY_VINES) {
            return luminance;
        }
        return 0;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(MANY_VINES);
    }

    public static ToIntFunction<BlockState> getLuminanceSupplier(int luminance) {
        return state -> state.get(ModProperties.MANY_VINES) ? luminance : 0;
    }

}
