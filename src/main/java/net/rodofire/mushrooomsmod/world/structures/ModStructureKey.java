package net.rodofire.mushrooomsmod.world.structures;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.Structure;
import net.rodofire.mushrooomsmod.MushrooomsMod;

public interface ModStructureKey {
    RegistryKey<Structure> YELLOW_MUSHROOM = of("yellow_mushroom");
    RegistryKey<Structure> GIANT_YELLOW_MUSHROOM = of("giant_yellow_mushroom");
    RegistryKey<Structure> PURPLE_MUSHROOM = of("purple_mushroom");

    private static RegistryKey<Structure> of(String id) {
        return RegistryKey.of(RegistryKeys.STRUCTURE, Identifier.of(MushrooomsMod.MOD_ID, id));
    }

    static void registerStructureKeys() {
        MushrooomsMod.LOGGER.info("|\t-Registering Structure Keys");
    }
}
