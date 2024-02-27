package net.rodofire.mushrooomsmod.block.custom;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.rodofire.mushrooomsmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MushrooomBlock extends Block {
    public Block block;

    public MushrooomBlock(Block block, Settings settings) {
        super(settings);
        this.block = block;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isIn(ModTags.Items.MUSHROOM_POWDER)) {
            System.out.println("itemstack");
            world.setBlockState(pos, block.getDefaultState());
            itemStack.decrement(-1);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

}
