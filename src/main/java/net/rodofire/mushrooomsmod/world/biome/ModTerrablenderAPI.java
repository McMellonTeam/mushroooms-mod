package net.rodofire.mushrooomsmod.world.biome;

import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModCaveRegion;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldRegion;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldRegionSimplified;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    public static int getCommonBiomesSpawnRate() {
        if (MushrooomsMod.CONFIG == null) {
            MushrooomsMod.LOGGER.error("cannot get common biomes spawn rate, CONFIG == null, returning 4");
            return 4;
        }
        if (MushrooomsMod.CONFIG.server == null) {
            MushrooomsMod.LOGGER.error("cannot get common biomes spawn rate, CONFIG == null, returning 4");
            return 4;
        }
        return MushrooomsMod.CONFIG.server.getCommonBiomeSpawnRate();
    }

    public static int getCaveBiomesSpawnRate() {
        if (MushrooomsMod.CONFIG == null) {
            MushrooomsMod.LOGGER.error("cannot get common biomes spawn rate, CONFIG == null, returning 4");
            return 4;
        }
        if (MushrooomsMod.CONFIG.server == null) {
            MushrooomsMod.LOGGER.error("cannot get common biomes spawn rate, CONFIG == null, returning 4");
            return 4;
        }
        return MushrooomsMod.CONFIG.server.getCaveBiomeSpawnRate();
    }

    @Override
    public void onTerraBlenderInitialized() {

        /*AutoConfig.register(ModConfig.class, PartitioningSerializer.wrap(JanksonConfigSerializer::new));
        MushrooomsMod.CONFIG = AutoConfig.getConfigHolder(ModConfig.class).getConfig();*/
        Regions.register(new ModOverworldRegion(new Identifier(MushrooomsMod.MOD_ID, "overworld"), getCommonBiomesSpawnRate()));
        Regions.register(new ModCaveRegion(new Identifier(MushrooomsMod.MOD_ID, "overworld_caves"), getCaveBiomesSpawnRate()));
        Regions.register(new ModOverworldRegionSimplified(new Identifier(MushrooomsMod.MOD_ID, "overworld_simplified"), 4));

    }
}
