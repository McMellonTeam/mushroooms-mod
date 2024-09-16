package net.rodofire.mushrooomsmod.world.biome.rules;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldBiomes;
import net.rodofire.mushrooomsmod.world.noises.ModNoises;

public class ModMaterialsRules {
    //Dirt Related
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule MYCELIUM = makeStateRule(Blocks.MYCELIUM);
    private static final MaterialRules.MaterialRule COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final MaterialRules.MaterialRule ROOTED_DIRT = makeStateRule(Blocks.ROOTED_DIRT);

    //Stone Related
    private static final MaterialRules.MaterialRule STONE = makeStateRule(Blocks.STONE);
    private static final MaterialRules.MaterialRule DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);
    private static final MaterialRules.MaterialRule PURPLE_MUSHROOM_BLOCK = makeStateRule(ModBlocks.PURPLE_MUSHROOM_BLOCK);
    private static final MaterialRules.MaterialRule GREEN_MUSHROOM_BLOCK = makeStateRule(ModBlocks.GREEN_MUSHROOM_BLOCK);
    private static final MaterialRules.MaterialRule BLUE_LUMINESCENT_DEEPSLATE = makeStateRule(ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEEPSLATE);
    private static final MaterialRules.MaterialRule PURPLE_SCHROOM_DEEPSLATE = makeStateRule(ModBlocks.PURPLE_SCHROOM_DEESLATE);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition deepslatelevel = MaterialRules.verticalGradient("deepslate", YOffset.fixed(0), YOffset.fixed(8));
        MaterialRules.MaterialCondition stonecavelevel = MaterialRules.aboveY(YOffset.fixed(0), 1);
        MaterialRules.MaterialCondition abovetop = MaterialRules.aboveY(YOffset.belowTop(-2), 0);
        MaterialRules.MaterialCondition belowtop = MaterialRules.not(MaterialRules.aboveY(YOffset.belowTop(10), 1));
        MaterialRules.MaterialCondition aboveWater = MaterialRules.aboveY(YOffset.fixed(60), 0);


        //Dirt Related
        MaterialRules.MaterialRule dirtfloor = MaterialRules.condition(MaterialRules.stoneDepth(0, true, 3, VerticalSurfaceType.FLOOR), DIRT);


        //Stone Related
        MaterialRules.MaterialRule bluedeepslate = MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, BLUE_LUMINESCENT_DEEPSLATE), DEEPSLATE);
        MaterialRules.MaterialRule purpledeepslate = MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, PURPLE_SCHROOM_DEEPSLATE), DEEPSLATE);


        return sequence(
                //Blue Luminescent Cave
                condition(MaterialRules.biome(ModOverworldBiomes.BLUE_LUMINESCENT_SHROOM_CAVE),
                        condition(deepslatelevel, bluedeepslate)),

                //Purple Schroom Cave
                condition(MaterialRules.biome(ModOverworldBiomes.BLUE_LUMINESCENT_SHROOM_CAVE),
                        condition(deepslatelevel, purpledeepslate)),

                //Vanilla Cave
                sequence(condition(MaterialRules.biome(ModOverworldBiomes.VANILLA_SHROOM_CAVE),
                        sequence(condition(belowtop, sequence(condition(stonecavelevel,
                                sequence(condition(MaterialRules.STONE_DEPTH_FLOOR,
                                                sequence(condition(emmentalNoiseAbove(0.25d), ROOTED_DIRT), condition(emmentalNoiseAbove(-0.25d), MYCELIUM), COARSE_DIRT)), dirtfloor,
                                        sequence(condition(MaterialRules.STONE_DEPTH_CEILING,
                                                sequence(condition(emmentalNoiseAbove(0d), DIRT), condition(emmentalNoiseAbove(-0.2d), ROOTED_DIRT), condition(emmentalNoiseAbove(-0.4d), COARSE_DIRT))))))))))),

                //Forest Cave
                condition(MaterialRules.biome(ModOverworldBiomes.FOREST_CAVE),
                        condition(belowtop, condition(stonecavelevel, sequence(condition(MaterialRules.STONE_DEPTH_FLOOR, GRASS_BLOCK),
                                condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH_RANGE_6, DIRT), condition(MaterialRules.STONE_DEPTH_CEILING, DIRT))))),

                //Schroom Island
                condition(MaterialRules.biome(ModOverworldBiomes.SHROOM_ISLAND1),
                        condition(aboveWater, sequence(condition(MaterialRules.STONE_DEPTH_FLOOR, MYCELIUM), condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH_RANGE_6, DIRT)))),
                condition(MaterialRules.biome(ModOverworldBiomes.SHROOM_ISLAND2),
                        condition(aboveWater, sequence(condition(MaterialRules.STONE_DEPTH_FLOOR, MYCELIUM), condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH_RANGE_6, DIRT))))
        );


    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }

    public static MaterialRules.MaterialCondition surfaceNoiseAbove(double min) {
        return MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, min / 8.5d, Double.MAX_VALUE);
    }

    public static MaterialRules.MaterialCondition emmentalNoiseAbove(double min) {
        return MaterialRules.noiseThreshold(ModNoises.EMMENTAL_NOISE, min, Double.MAX_VALUE);
    }

    public static MaterialRules.MaterialCondition patchNoiseAbove(double min) {
        return MaterialRules.noiseThreshold(ModNoises.PATCH_NOISE, min, Double.MAX_VALUE);
    }

    //Methods for better readability
    public static MaterialRules.MaterialRule condition(MaterialRules.MaterialCondition condition, MaterialRules.MaterialRule rule) {
        return MaterialRules.condition(condition, rule);
    }

    public static MaterialRules.MaterialRule sequence(MaterialRules.MaterialRule... rules) {
        return MaterialRules.sequence(rules);
    }
}
