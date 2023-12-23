package net.louis.mushrooomsmod.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.louis.mushrooomsmod.MushrooomsMod;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final DefaultParticleType GREENFIRE_PARTICLE = FabricParticleTypes.simple();
    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MushrooomsMod.MOD_ID, "greenfire_particle"),
                GREENFIRE_PARTICLE);
    }
}
