package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBrushableBlock extends Block {
    //Brushabe block that return block without returning an item
    public Block block;

    public BlockBrushableBlock(Settings settings, Block block) {
        super(settings);
        this.block = block;
    }

    public boolean brush(long worldTime, PlayerEntity player, BlockPos pos, int i) {
        System.out.println("hello");
        if (i !=200) return false;
        finishBrushing(player, pos);
        return true;
    }

    private void finishBrushing(PlayerEntity player, BlockPos pos) {
        World world = player.getEntityWorld();
        world.setBlockState(pos, this.block.getDefaultState());
    }
}
