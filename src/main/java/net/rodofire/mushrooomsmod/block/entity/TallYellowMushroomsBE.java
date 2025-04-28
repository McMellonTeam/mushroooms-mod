package net.rodofire.mushrooomsmod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.rodofire.mushrooomsmod.block.ModBlockEntities;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;

public class TallYellowMushroomsBE extends BlockEntity implements GeoBlockEntity {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    private static final RawAnimation IDLE = RawAnimation.begin().then("animation.tall_yellow_mushrooms.idle", Animation.LoopType.LOOP);
    private static final RawAnimation NORTH = RawAnimation.begin().then("animation.tall_yellow_mushrooms.north", Animation.LoopType.PLAY_ONCE).then("animation.tall_yellow_mushrooms.idle", Animation.LoopType.LOOP);
    private static final RawAnimation SOUTH = RawAnimation.begin().then("animation.tall_yellow_mushrooms.south", Animation.LoopType.PLAY_ONCE).then("animation.tall_yellow_mushrooms.idle", Animation.LoopType.LOOP);
    private static final RawAnimation EAST = RawAnimation.begin().then("animation.tall_yellow_mushrooms.east", Animation.LoopType.PLAY_ONCE).then("animation.tall_yellow_mushrooms.idle", Animation.LoopType.LOOP);
    private static final RawAnimation WEST = RawAnimation.begin().then("animation.tall_yellow_mushrooms.west", Animation.LoopType.PLAY_ONCE).then("animation.tall_yellow_mushrooms.idle", Animation.LoopType.LOOP);

    public TallYellowMushroomsBE(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TALL_YELLOW_MUSHROOMS, pos, state);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, state -> {
            BlockState cachedState = state.getAnimatable().getCachedState();
            BlockState baseState = ModBlocks.TALL_YELLOW_MUSHROOMS.getDefaultState();

            if (cachedState.getBlock() != baseState.getBlock() || !cachedState.get(Properties.ENABLED)) {
            }
            return state.setAndContinue(IDLE);
/*
            Direction facing = cachedState.get(Properties.HORIZONTAL_FACING);
            return switch (facing) {
                case NORTH -> state.setAndContinue(NORTH);
                case SOUTH -> state.setAndContinue(SOUTH);
                case EAST  -> state.setAndContinue(EAST);
                case WEST  -> state.setAndContinue(WEST);
                default    -> state.setAndContinue(IDLE);
            };*/
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
