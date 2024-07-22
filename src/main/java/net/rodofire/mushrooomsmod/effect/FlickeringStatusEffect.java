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
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient()) {
            return false;
        }
        ServerWorld world = (ServerWorld) entity.getWorld();
        Vec3d vec3d = entity.getPos();
        for (int i = 0; i < 400; ++i) {
            Vec3d vec3d2 = vec3d.add((float) Random.create().nextBetween(-200, 200) / 10, (float) Random.create().nextBetween(-200, 200) / 10, (float) Random.create().nextBetween(-200, 200) / 10);
            Vec3d vec3d3 = vec3d.add((float) Random.create().nextBetween(-20, 20) / 10, (float) Random.create().nextBetween(-20, 20) / 10, (float) Random.create().nextBetween(-20, 20) / 10);
            world.spawnParticles(ParticleTypes.GLOW_SQUID_INK, vec3d2.x, vec3d2.y, vec3d2.z, 0, vec3d3.x, vec3d3.y, vec3d3.z, 0.00001f);
        }
        super.applyUpdateEffect(entity, amplifier);
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

}
