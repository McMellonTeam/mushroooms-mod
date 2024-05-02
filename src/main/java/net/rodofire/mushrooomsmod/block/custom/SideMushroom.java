package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

public class SideMushroom extends Block {
    public SideMushroom(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        boolean bl1 = world.getBlockState(pos.north()) == this.getDefaultState();
        boolean bl2 = world.getBlockState(pos.south()) == this.getDefaultState();
        boolean bl3 = world.getBlockState(pos.west()) == this.getDefaultState();
        boolean bl4 = world.getBlockState(pos.east()) == this.getDefaultState();
        return bl1 || bl2 || bl3 || bl4;
    }
}
