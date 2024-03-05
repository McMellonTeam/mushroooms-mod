package net.rodofire.mushrooomsmod.world.biome;

import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomesTags {
    public static final TagKey<Biome> IS_LUMINESCENT_CAVE  = ModBiomesTags.of("is_luminescent_cave");




    private static TagKey<Biome> of(String id) {
        return TagKey.of(RegistryKeys.BIOME, new Identifier(id));
    }
}
