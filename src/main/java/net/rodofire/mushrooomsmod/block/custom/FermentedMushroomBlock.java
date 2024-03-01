package net.rodofire.mushrooomsmod.block.custom;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.util.ModTags;

public class FermentedMushroomBlock extends Block {
    public Block block;
    public boolean ismaxfermented;


    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getMainHandStack();
        if(!ismaxfermented){
            if (stack.isIn(ModTags.Items.MUSHROOM_POWDER)) {
                world.setBlockState(pos, block.getDefaultState());
                //stack.decrement(-1);
                return ActionResult.SUCCESS;
            }
        }else {
            if (stack.isIn(ItemTags.AXES) && stack.getItem() instanceof AxeItem axeItem && axeItem.getMaterial().getMiningLevel() > MiningLevels.STONE) {
                world.setBlockState(pos, block.getDefaultState());
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }
    public FermentedMushroomBlock(Block block, boolean ismaxfermented, Settings settings) {
        super(settings);
        this.block = block;
        this.ismaxfermented=ismaxfermented;
    }
}
