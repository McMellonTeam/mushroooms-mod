package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class DelicateLavaBlackstone extends Block {
    private static int maxboom;
    public static IntProperty RECEIVED_BOOM = IntProperty.of("received_boom", 0, 20);

    public DelicateLavaBlackstone(Settings settings, int maxboom) {
        super(settings);
        DelicateLavaBlackstone.maxboom = maxboom;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(RECEIVED_BOOM);
    }
    
    /*public boolean isbreakable(World world, BlockPos blockPos,BlockState blockState){
        if (blockState.)

    }*/

}
