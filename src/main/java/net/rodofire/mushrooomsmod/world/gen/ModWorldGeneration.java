package net.rodofire.mushrooomsmod.world.gen;

import net.rodofire.mushrooomsmod.MushrooomsMod;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModPlantsGeneration.generateFlowers();
        ModPlantsGeneration.generateVines();
        ModTreeGeneration.generateTrees();

        ModEntityGeneration.addSpawn();

        ModOreGeneration.generateOres();

        MushrooomsMod.LOGGER.info("Generating Mod World Generation");
    }
}
