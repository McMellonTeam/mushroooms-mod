package net.rodofire.mushrooomsmod.entity.goal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.rodofire.mushrooomsmod.entity.custom.CustomCreeperEntity;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class CustomCreeperIgniteGoal extends Goal {
    private final CustomCreeperEntity creeper;
    @Nullable
    private LivingEntity target;

    public CustomCreeperIgniteGoal(CustomCreeperEntity creeper) {
        this.creeper = creeper;
        this.setControls(EnumSet.of(Control.MOVE));
    }

    @Override
    public boolean canStart() {
        LivingEntity livingEntity = this.creeper.getTarget();
        return this.creeper.getFuseSpeed() > 0 || livingEntity != null && this.creeper.squaredDistanceTo(livingEntity) < 9.0;
    }

    @Override
    public void start() {
        this.creeper.getNavigation().stop();
        this.target = this.creeper.getTarget();
    }

    @Override
    public void stop() {
        this.target = null;
    }

    @Override
    public boolean shouldRunEveryTick() {
        return true;
    }

    @Override
    public void tick() {
        if (this.target == null) {
            this.creeper.setFuseSpeed(-1);
            return;
        }
        if (this.creeper.squaredDistanceTo(this.target) > 49.0) {
            this.creeper.setFuseSpeed(-1);
            return;
        }
        if (!this.creeper.getVisibilityCache().canSee(this.target)) {
            this.creeper.setFuseSpeed(-1);
            return;
        }
        this.creeper.setFuseSpeed(1);
    }
}
