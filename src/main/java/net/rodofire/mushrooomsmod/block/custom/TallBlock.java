package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class TallBlock extends Block {
    public TallBlock(Settings settings) {
        super(settings);
    }
    public static final VoxelShape SHAPE = Block.createCuboidShape(0,0,0,16,32,16);
}
