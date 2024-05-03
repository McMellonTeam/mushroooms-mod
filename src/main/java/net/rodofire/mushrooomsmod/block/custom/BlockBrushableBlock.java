package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

//I had absolutely no idea on how to name this class
public class BlockBrushableBlock extends Block {
    //Brushabe block that return block without returning an item
    public Block block;

    public BlockBrushableBlock(Settings settings, Block block) {
        super(settings);
        this.block = block;
    }

    public boolean brush(long worldTime, PlayerEntity player, BlockPos pos, int i) {
        if (i <= 120) return false;
        finishBrushing(player, pos);
        return true;
    }

    private void finishBrushing(PlayerEntity player, BlockPos pos) {
        World world = player.getEntityWorld();
        world.setBlockState(pos, this.block.getDefaultState());
    }
}
