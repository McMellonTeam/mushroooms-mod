package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.rodofire.mushrooomsmod.block.custom.PinkMushroomBlock.PinkMushroomVines;
import net.rodofire.mushrooomsmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.ShapeContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class MushrooomBlock extends Block  {
    public static Block fermentedblock;
    public static final VoxelShape SHAPE = createCuboidShape(0,0,0,16,16,16);
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    public MushrooomBlock(Block fermentedblock,Settings settings) {
        super(settings);
        this.fermentedblock=fermentedblock;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if(itemStack.isIn(ModTags.Items.MUSHROOM_POWDER)){
            world.setBlockState(pos,fermentedblock.getDefaultState());
            itemStack.decrement(-1);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
}
