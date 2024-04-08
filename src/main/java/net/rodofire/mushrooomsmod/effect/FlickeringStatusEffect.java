package net.rodofire.mushrooomsmod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;

public class FlickeringStatusEffect extends StatusEffect {
    protected FlickeringStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient()) {
            return;
        }
        ServerWorld world = (ServerWorld) entity.getWorld();
        Vec3d vec3d = entity.getPos();
        for(int i=0;i<2;++i) {
            Vec3d vec3d2 = vec3d.add((float) Random.create().nextBetween(-200, 200) / 100, (float) Random.create().nextBetween(0, 300) / 100, (float) Random.create().nextBetween(-200, 200) / 100);

            Vec3d vec3d3 = vec3d2.add((float) Random.create().nextBetween(-200, 200) / 100, (float) Random.create().nextBetween(0, 200) / 100, (float) Random.create().nextBetween(-200, 200) / 100);

            world.spawnParticles(ParticleTypes.GLOW_SQUID_INK, 0.1f, 0.1f, 0.1f, 0, 0.01f, 0.01f, 0.01f, 0.0005f);
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
