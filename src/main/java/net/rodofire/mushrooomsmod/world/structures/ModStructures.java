package net.rodofire.mushrooomsmod.world.structures;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.structure.Structure;
import net.rodofire.mushrooomsmod.util.ModTags;
import net.rodofire.mushrooomsmod.world.structures.mushrooms.YellowMushroomStructure;

public class ModStructures {
    public static void bootstrap(Registerable<Structure> structureRegisterable) {
        RegistryEntryLookup<Biome> biomeLookup = structureRegisterable.getRegistryLookup(RegistryKeys.BIOME);
        RegistryEntryLookup<StructurePool> poolLookup = structureRegisterable.getRegistryLookup(RegistryKeys.TEMPLATE_POOL);

        structureRegisterable.register(
                ModStructureKey.YELLOW_MUSHROOM,
                new YellowMushroomStructure(
                        new Structure.Config.Builder(
                                biomeLookup.getOrThrow(ModTags.Biomes.HAS_YELLOW_MUSHROOM))
                                .step(GenerationStep.Feature.VEGETAL_DECORATION)
                                .build()
                )
        );
    }
}
