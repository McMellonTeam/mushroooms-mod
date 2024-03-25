package net.rodofire.mushrooomsmod.world.biome.surface;

import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialsRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule STONE = makeStateRule(Blocks.STONE);
    private static final MaterialRules.MaterialRule DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);
    private static final MaterialRules.MaterialRule PURPLE_MUSHROOM_BLOCK = makeStateRule(ModBlocks.PURPLE_MUSHROOM_BLOCK);
    private static final MaterialRules.MaterialRule GREEN_MUSHROOM_BLOCK = makeStateRule(ModBlocks.GREEN_MUSHROOM_BLOCK);
    private static final MaterialRules.MaterialRule BLUE_LUMINESCENT_DEEPSLATE = makeStateRule(ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEESLATE);
    private static final MaterialRules.MaterialRule PURPLE_SCHROOM_DEEPSLATE = makeStateRule(ModBlocks.PURPLE_SCHROOM_DEESLATE);


    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition below0 = MaterialRules.verticalGradient("deepslate", YOffset.belowTop(0), YOffset.getBottom());
        MaterialRules.MaterialRule understone = MaterialRules.sequence(STONE);

        MaterialRules.MaterialRule deepslatesurface = MaterialRules.sequence(MaterialRules.condition(below0, BLUE_LUMINESCENT_DEEPSLATE), DEEPSLATE);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModOverworldBiomes.BLUE_LUMINESCENT_SHROOM_CAVE),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR,deepslatesurface))
                            /*MaterialRules.condition(MaterialRules.biome(ModOverworldBiomes.BLUE_LUMINESCENT_SHROOM_CAVE),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR,deepslatesurface1)))*/

                //MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.SHROOM_ISLAND),DEEPSLATE))
        ));
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
