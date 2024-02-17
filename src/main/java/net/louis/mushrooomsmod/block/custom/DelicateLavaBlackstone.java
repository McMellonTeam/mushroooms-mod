package net.louis.mushrooomsmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DelicateLavaBlackstone extends Block {
    private static int maxboom;
    public static IntProperty RECEIVED_BOOM = IntProperty.of("received_boom",0,20);
    public DelicateLavaBlackstone(Settings settings, int maxboom) {
        super(settings);
        this.maxboom=maxboom;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder){
        builder.add(RECEIVED_BOOM);
    }
    
    /*public boolean isbreakable(World world, BlockPos blockPos,BlockState blockState){
        if (blockState.)

    }*/

}
