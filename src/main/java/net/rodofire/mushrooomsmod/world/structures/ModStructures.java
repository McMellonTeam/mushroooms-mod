package net.rodofire.mushrooomsmod.world.structures;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.structure.Structure;
import net.rodofire.mushrooomsmod.util.ModTags;
import net.rodofire.mushrooomsmod.world.structures.custom.structure.mushrooms.GiantYellowMushroomStructure;
import net.rodofire.mushrooomsmod.world.structures.custom.structure.mushrooms.PurpleMushroomStructure;
import net.rodofire.mushrooomsmod.world.structures.custom.structure.mushrooms.YellowMushroomStructure;

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

        structureRegisterable.register(
                ModStructureKey.GIANT_YELLOW_MUSHROOM,
                new GiantYellowMushroomStructure(
                        new Structure.Config.Builder(
                                biomeLookup.getOrThrow(ModTags.Biomes.HAS_GIANT_YELLOW_MUSHROOM))
                                .step(GenerationStep.Feature.VEGETAL_DECORATION)
                                .build()
                )
        );

        structureRegisterable.register(
                ModStructureKey.PURPLE_MUSHROOM,
                new PurpleMushroomStructure(
                        new Structure.Config.Builder(
                                biomeLookup.getOrThrow(ModTags.Biomes.HAS_PURPLE_MUSHROOM))
                                .step(GenerationStep.Feature.VEGETAL_DECORATION)
                                .build()
                )
        );
    }
}
