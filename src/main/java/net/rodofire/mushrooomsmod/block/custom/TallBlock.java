package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.shape.VoxelShape;

public class TallBlock extends Block {
    public TallBlock(Settings settings) {
        super(settings);
    }
    public static final VoxelShape SHAPE = Block.createCuboidShape(0,0,0,16,32,16);
}
