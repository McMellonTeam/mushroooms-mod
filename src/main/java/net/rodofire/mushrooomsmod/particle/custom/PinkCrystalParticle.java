package net.rodofire.mushrooomsmod.particle.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class PinkCrystalParticle extends SpriteBillboardParticle {
    protected PinkCrystalParticle(ClientWorld level, double xCoord, double yCoord, double zCoord,
                                  SpriteProvider spriteSet, double xd, double yd, double zd) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);

        this.velocityMultiplier = 1F;
        this.x = xd;
        this.y = yd;
        this.z = zd;
        this.scale *= 1;
        this.maxAge = 70;
        this.setSpriteForAge(spriteSet);

        this.red = 1f;
        this.green = 1f;
        this.blue = 1f;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }
    @Override
    public void tick() {
        super.tick();
        fadeOut();
    }
    private void fadeOut() {
        this.alpha = (-(1/(float)maxAge) * (float)age/2 + 1);
    }
    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(DefaultParticleType particleType, ClientWorld level, double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new GreenfireParticle(level, x, y, z, this.sprites, dx, dy, dz);
        }
    }
}
