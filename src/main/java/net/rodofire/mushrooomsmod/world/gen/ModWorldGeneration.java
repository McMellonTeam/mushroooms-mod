package net.rodofire.mushrooomsmod.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModPlantsGeneration.generateFlowers();
        ModPlantsGeneration.generateVines();
        ModTreeGeneration.generateTrees();

        ModEntityGeneration.addSpawn();

        ModOreGeneration.generateOres();
        System.out.println("registering worldgeneration");
    }
}
