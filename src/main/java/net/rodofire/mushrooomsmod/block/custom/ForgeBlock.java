package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.block.entity.ForgeBlockEntity;
import net.rodofire.mushrooomsmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ForgeBlock extends BlockWithEntity implements BlockEntityProvider {
    private static final VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 16, 16, 16);

    public ForgeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ForgeBlockEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (hand.equals(Hand.OFF_HAND) || world.isClient()) return ActionResult.PASS;

        BlockEntity blockEntity = world.getBlockEntity(pos);
        Inventory inventory = (Inventory) blockEntity;
        ItemStack itemStack = player.getMainHandStack();
        ItemStack putItemStack = itemStack.getItem().getDefaultStack();
        int itemfirstslot = inventory.getStack(0).getCount();
        putItemStack.setCount(itemfirstslot + 1);
        System.out.println(inventory.getStack(0) +"  "+inventory.getStack(1));
        if (!inventory.isEmpty()) {
            //code to give the inventory to the player
            if (itemStack.isEmpty() || !itemStack.isIn(ModTags.Items.FORGEABLE_ITEMS)) {
                if (itemStack.isEmpty()) {
                    //give it to the slot
                    if (inventory.getStack(1).isEmpty()) {
                        player.giveItemStack(inventory.getStack(0));
                        inventory.removeStack(0);
                    } else {
                        player.giveItemStack(inventory.getStack(1));
                        inventory.removeStack(1);
                    }
                    return ActionResult.SUCCESS;
                } else {
                    //drop the item
                    if (inventory.getStack(1).isEmpty()) {
                        dropStack(world, pos.up(), inventory.getStack(0));
                        inventory.removeStack(0);
                    } else {
                        dropStack(world, pos.up(), inventory.getStack(1));
                        inventory.removeStack(1);
                    }
                    return ActionResult.SUCCESS;
                }
            }
            //put stuff
            if (inventory.getStack(0).getCount() != 64) {
                if (itemStack.isIn(ModTags.Items.FORGEABLE_ITEMS)) {
                    if (player.isSneaking()) {
                        inventory.setStack(0, putItemStack);
                        itemStack.decrement(64);
                    } else {
                        inventory.setStack(0, putItemStack);
                        if (!player.isCreative()) itemStack.decrement(1);
                    }
                    return ActionResult.SUCCESS;
                }
            }

        } else {
            if (!itemStack.isIn(ModTags.Items.FORGEABLE_ITEMS)) return ActionResult.PASS;
            if (player.isSneaking()) {
                inventory.setStack(0, putItemStack);
                itemStack.decrement(64);
            } else {
                inventory.setStack(0, putItemStack);
                itemStack.decrement(1);
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return super.getTicker(world, state, type);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ForgeBlockEntity) {
                ItemScatterer.spawn(world, pos, (Inventory) blockEntity);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.mushrooomsmod.forge_block").formatted(Formatting.BLUE));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
