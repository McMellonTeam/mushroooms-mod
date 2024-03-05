package net.rodofire.mushrooomsmod.block.custom;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.util.ModTags;

public class FermentedMushroomBlock extends Block {
    public final String color;
    public final String stage;
    public boolean ismaxfermented;


    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Block block = getMushroomBlock(color, stage);
        ItemStack stack = player.getMainHandStack();
        if (!ismaxfermented) {
            if (stack.isIn(ModTags.Items.MUSHROOM_POWDER)) {
                world.setBlockState(pos, block.getDefaultState());
                //stack.decrement(-1);
                return ActionResult.SUCCESS;
            }
        } else {
            if (stack.isIn(ItemTags.AXES) && stack.getItem() instanceof AxeItem axeItem && axeItem.getMaterial().getMiningLevel() > MiningLevels.STONE) {
                world.setBlockState(pos, block.getDefaultState());
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

    public FermentedMushroomBlock(String color, String stage, boolean ismaxfermented, Settings settings) {
        super(settings);
        this.color = color;
        this.stage = stage;
        this.ismaxfermented = ismaxfermented;
    }


    //Very inneficient way but by putting    Block block   on directly was crashing my game
    public Block getMushroomBlock(String color, String stage) {
        switch (color) {
            case "purple" -> {
                if (stage.equals("altered")) return ModBlocks.PURPLE_ALTERED_MUSHROOM_BLOCK;
                if (stage.equals("degradated")) return ModBlocks.PURPLE_DEGRADATED_MUSHROOM_BLOCK;
                if (stage.equals("fermented")) return ModBlocks.PURPLE_MUSHROOM_FERMENTED_BLOCK;
                if (stage.equals("normal")) return ModBlocks.PURPLE_MUSHROOM_BLOCK;
            }
            case "green" -> {
            }
            case "yellow" -> {
            }
            case "orange" -> {
            }
            case "brown" -> {
            }
            case "red" -> {
            }
            case "pink" -> {
            }
            case "blue" -> {
            }
        }
        return Blocks.MAGENTA_BANNER;
    }


}
