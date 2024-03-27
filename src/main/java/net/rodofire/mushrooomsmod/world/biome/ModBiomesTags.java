package net.rodofire.mushrooomsmod.world.biome;

import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.rodofire.mushrooomsmod.MushrooomsMod;

public class ModBiomesTags {
    public static final TagKey<Biome> LUMINESCENT_CAVE = ModBiomesTags.of("luminescent_cave");
    public static final TagKey<Biome> COLORFUL_PLAINS = ModBiomesTags.of("colorful_plains");




    private static TagKey<Biome> of(String id) {
        return TagKey.of(RegistryKeys.BIOME, new Identifier(MushrooomsMod.MOD_ID, id));
    }
}
