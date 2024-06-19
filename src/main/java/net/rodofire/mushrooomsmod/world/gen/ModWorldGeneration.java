package net.rodofire.mushrooomsmod.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModPlantsGeneration.generateFlowers();
        ModTreeGeneration.generateTrees();
        ModPlantsGeneration.generateVines();
        ModEntityGeneration.addSpawn();
        System.out.println("registering worldgeneration");
    }
}
