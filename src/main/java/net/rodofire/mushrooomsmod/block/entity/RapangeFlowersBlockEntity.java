package net.rodofire.mushrooomsmod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.rodofire.mushrooomsmod.block.ModBlockEntities;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;

public class RapangeFlowersBlockEntity extends BlockEntity implements GeoBlockEntity {
    private static final RawAnimation DOWN = RawAnimation.begin().then("animation.rapange_flowers.down", Animation.LoopType.HOLD_ON_LAST_FRAME);
    private static final RawAnimation UP = RawAnimation.begin().then("animation.rapange_flowers.up", Animation.LoopType.PLAY_ONCE).then("animation.rapange_flowers.idle", Animation.LoopType.LOOP);
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);


    public RapangeFlowersBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.RAPANGE_FLOWERS_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, state -> {
            if (state.getAnimatable().getCachedState() == ModBlocks.RAPANGE_FLOWERS.getDefaultState().with(Properties.UP, true)) {
                return state.setAndContinue(UP);
            } else {
                return state.setAndContinue(DOWN);
            }
        }));
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
