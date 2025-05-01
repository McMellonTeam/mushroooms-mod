package net.rodofire.mushrooomsmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.block.entity.TallYellowMushroomsBE;
import org.jetbrains.annotations.Nullable;

public class TallYellowMushroom extends BlockWithEntity {
    public static final MapCodec<TallYellowMushroom> CODEC = TallYellowMushroom.createCodec(TallYellowMushroom::new);

    public static BooleanProperty ENABLED = Properties.ENABLED;
    public static EnumProperty<Direction> DIRECTION = Properties.HORIZONTAL_FACING;

    public TallYellowMushroom(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return ModBlocks.TALL_YELLOW_MUSHROOMS.getDefaultState().with(ENABLED, false).with(DIRECTION, Direction.NORTH);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(ENABLED, DIRECTION);
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        Direction direction = getHorizontalDirectionFromVelocity(entity.getVelocity());
/*        if (direction == null) return;
        else state = state.with(ENABLED, true).with(DIRECTION, direction);

        if (world instanceof ServerWorld serverWorld) {
            serverWorld.setBlockState(pos, state);
        }*/
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isIn(BlockTags.DIRT);
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return state.get(ENABLED);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.setBlockState(pos, state.with(ENABLED, false), 2);
    }

    Direction getHorizontalDirectionFromVelocity(Vec3d velocity) {
        if (velocity.lengthSquared() < 1.0E-5) {
            return null;
        }
        return Direction.fromRotation(MathHelper.atan2(velocity.x, velocity.z) * (180F / (float) Math.PI));
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TallYellowMushroomsBE(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }
}
