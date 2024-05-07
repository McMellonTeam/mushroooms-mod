package net.rodofire.mushrooomsmod.world.biome.rules;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldBiomes;

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
        MaterialRules.MaterialCondition belowtop = MaterialRules.not(MaterialRules.aboveY(YOffset.belowTop(-6), 1));


        //Dirt Related
        MaterialRules.MaterialRule dirt = MaterialRules.condition(MaterialRules.stoneDepth(0, true, 3, VerticalSurfaceType.FLOOR), DIRT);


        //Stone Related
        MaterialRules.MaterialRule bluedeepslate = MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, BLUE_LUMINESCENT_DEEPSLATE), DEEPSLATE);


        return MaterialRules.sequence(
                //Blue Luminescent Cave
                MaterialRules.condition(MaterialRules.biome(ModOverworldBiomes.BLUE_LUMINESCENT_SHROOM_CAVE),
                        MaterialRules.condition(deepslatelevel, bluedeepslate)),

                //Vanilla Cave
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModOverworldBiomes.VANILLA_SHROOM_CAVE),
                        MaterialRules.sequence(MaterialRules.condition(belowtop, MaterialRules.sequence(MaterialRules.condition(stonecavelevel, MaterialRules.sequence(
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR,
                                        MaterialRules.sequence(MaterialRules.condition(noiseAbove(2d), ROOTED_DIRT), MaterialRules.condition(noiseAbove(0.9d), COARSE_DIRT), MYCELIUM)) ))))))


        ));
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }

    public static MaterialRules.MaterialCondition noiseAbove(double min) {
        return MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, min / 8.5d, Double.MAX_VALUE);
    }
}
