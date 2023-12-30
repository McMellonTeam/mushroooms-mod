package net.louis.mushrooomsmod.world.gen;

import java.util.logging.Logger;

public class ModWorldGeneration {
    public static void generateModWorldGen(){
        //ModPlantsGeneration.generateFlowers();
        //ModTreeGeneration.generateTrees();
        ModPlantsGeneration.generateVines();
        System.out.println("registering worldgeneration");
    }
}
