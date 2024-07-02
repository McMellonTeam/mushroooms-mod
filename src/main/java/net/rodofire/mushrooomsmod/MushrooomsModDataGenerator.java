package net.rodofire.mushrooomsmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.rodofire.mushrooomsmod.datagen.*;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldBiomes;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.ModConfiguredFeatures;
import net.rodofire.mushrooomsmod.world.features.placedfeatures.ModNetherPlacedFeatures;
import net.rodofire.mushrooomsmod.world.features.placedfeatures.ModSurfacePlacedFeatures;
import net.rodofire.mushrooomsmod.world.features.placedfeatures.ModUndergroundPlacedFeatures;
import net.rodofire.mushrooomsmod.world.noises.ModNoises;

public class MushrooomsModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModLootTableProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModWorldGenerator::new);

    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModSurfacePlacedFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModUndergroundPlacedFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModNetherPlacedFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.BIOME, ModOverworldBiomes::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.NOISE_PARAMETERS, ModNoises::bootstrap);
    }
}
