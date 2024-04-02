package net.rodofire.mushrooomsmod.world.biome.overworld;

import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.rodofire.mushrooomsmod.world.biome.ModBiomeFeatures;

public class ModOverworldBiomes {
    public static final RegistryKey<Biome> SHROOM_ISLAND = RegistryKey.of(RegistryKeys.BIOME, new Identifier(MushrooomsMod.MOD_ID,"shroom_island" ));
    public static final RegistryKey<Biome> BLUE_LUMINESCENT_SHROOM_CAVE = RegistryKey.of(RegistryKeys.BIOME, new Identifier(MushrooomsMod.MOD_ID,"blue_luminescent_shroom_cave" ));
    public static final RegistryKey<Biome> PURPLE_SHROOM_CAVE = RegistryKey.of(RegistryKeys.BIOME, new Identifier(MushrooomsMod.MOD_ID,"purple_luminescent_shroom_cave"));
    public static final RegistryKey<Biome> MAGICAL_PLAIN = RegistryKey.of(RegistryKeys.BIOME, new Identifier(MushrooomsMod.MOD_ID,"magical_plain"));
    public static final RegistryKey<Biome> COLORFUL_PLAINS = RegistryKey.of(RegistryKeys.BIOME, new Identifier(MushrooomsMod.MOD_ID,"colorful_plain"));
    public static void bootstrap(Registerable<Biome> context){
        context.register(SHROOM_ISLAND, shroomIsland(context));
        context.register(BLUE_LUMINESCENT_SHROOM_CAVE, blueLuminescentShroomCave(context));
        context.register(PURPLE_SHROOM_CAVE, purpleSchroomCave(context));
        context.register(MAGICAL_PLAIN, magicalPlains(context));
        context.register(COLORFUL_PLAINS,colorfulPlains(context));
    }
    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }
    public static Biome shroomIsland(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));

        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addMossyRocks(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);
        DefaultBiomeFeatures.addForestFlowers(biomeBuilder);
        DefaultBiomeFeatures.addLargeFerns(biomeBuilder);

        DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
        DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x3fceda)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x30c918)
                        .grassColor(0x7f03fc)
                        .foliageColor(0xd203fc)
                        .fogColor(0x22a1e6)
                        .moodSound(BiomeMoodSound.CAVE)
                        .build())
                .build();
    }
    public static Biome blueLuminescentShroomCave(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();


        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);


        DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);


        DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        ModBiomeFeatures.addLuminescentFlowers(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x3fceda)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x30c918)
                        .grassColor(0x7f03fc)
                        .foliageColor(0xd203fc)
                        .fogColor(0x22a1e6)
                        .moodSound(BiomeMoodSound.CAVE)
                        .build())
                .build();
    }
    public static Biome purpleSchroomCave(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));

        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addMossyRocks(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);
        DefaultBiomeFeatures.addForestFlowers(biomeBuilder);
        DefaultBiomeFeatures.addLargeFerns(biomeBuilder);

        DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
        DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x3fceda)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x30c918)
                        .grassColor(0x7f03fc)
                        .foliageColor(0xd203fc)
                        .fogColor(0x22a1e6)
                        .moodSound(BiomeMoodSound.CAVE)
                        .build())
                .build();
    }
    public static Biome magicalPlains(Registerable<Biome> context) {
            SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

            spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));

            DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
            DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

            GenerationSettings.LookupBackedBuilder biomeBuilder =
                    new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                            context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

            globalOverworldGeneration(biomeBuilder);
            DefaultBiomeFeatures.addMossyRocks(biomeBuilder);
            DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

            biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);
            DefaultBiomeFeatures.addForestFlowers(biomeBuilder);
            DefaultBiomeFeatures.addLargeFerns(biomeBuilder);

            DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
            DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

            return new Biome.Builder()
                    .precipitation(true)
                    .downfall(0.4f)
                    .temperature(0.7f)
                    .generationSettings(biomeBuilder.build())
                    .spawnSettings(spawnBuilder.build())
                    .effects((new BiomeEffects.Builder())
                            .waterColor(0x3fceda)
                            .waterFogColor(0xbf1b26)
                            .skyColor(0x30c918)
                            .grassColor(0x7f03fc)
                            .foliageColor(0xd203fc)
                            .fogColor(0x22a1e6)
                            .moodSound(BiomeMoodSound.CAVE)
                            .build())

                    .build();
        }
    public static Biome colorfulPlains(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_PLAIN);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x29A7FF)
                        .waterFogColor(0x066AAF)
                        .skyColor(0x18A4E6)
                        .grassColor(0x54E618)
                        .foliageColor(0x25B258)
                        .fogColor(0x7BC5E8)
                        .moodSound(BiomeMoodSound.CAVE)
                        .build())
                .build();
    }

}
