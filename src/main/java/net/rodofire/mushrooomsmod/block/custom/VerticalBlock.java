package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class VerticalBlock extends Block {
    public VerticalBlock(Settings settings) {
        super(settings);
    }

    public static final DirectionProperty VERTICAL_DIRECTION = Properties.VERTICAL_DIRECTION;

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(VERTICAL_DIRECTION);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getVerticalPlayerLookDirection().getOpposite();
        BlockState blockState = this.getDefaultState();
        return blockState.with(VERTICAL_DIRECTION, direction);
    }

}
