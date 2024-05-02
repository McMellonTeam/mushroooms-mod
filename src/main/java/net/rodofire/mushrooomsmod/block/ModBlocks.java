package net.rodofire.mushrooomsmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.custom.*;
import net.rodofire.mushrooomsmod.block.custom.PinkLuminescentVines.PinkLuminescentBodyVinesBlock;
import net.rodofire.mushrooomsmod.block.custom.PinkLuminescentVines.PinkLuminescentHeadVinesBlock;
import net.rodofire.mushrooomsmod.block.custom.PinkMushroomBlock.PinkMushroomVinesBodyBlock;
import net.rodofire.mushrooomsmod.block.custom.PinkMushroomBlock.PinkMushroomVinesHeadBlock;
import net.rodofire.mushrooomsmod.block.custom.bigmushroom.*;
import net.rodofire.mushrooomsmod.item.ModItems;
import net.rodofire.mushrooomsmod.particle.ModParticles;
import net.rodofire.mushrooomsmod.sound.ModBlockSoundGroup;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.ModConfiguredFeatures;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.world.tree.sapplinggenerator.BlueLuminescentSapplingGenerator;

public class ModBlocks {
    private static void addItemstoNaturalGroup(FabricItemGroupEntries entries) {

    }

    private static void addItemstoFoodGroup(FabricItemGroupEntries entries) {
        entries.add(ModItems.BAGUETTE);
    }

    private static void addItemstoFunctionalGroup(FabricItemGroupEntries entries) {
    }

    private static void addItemstoToolsGroup(FabricItemGroupEntries entries) {

    }

    private static void addItemstoSpawnEggsGroup(FabricItemGroupEntries entries) {
        entries.add(ModItems.BOLETE_COW_SPAWN_EGG);
        entries.add(ModItems.GROKI_SPAWN_EGG);

    }

    //Mushroom Block
    public static final Block PURPLE_MUSHROOM_BLOCK = registerBlock("mushroom_block_purple", new FermentedMushroomBlock(() -> ModBlocks.PURPLE_ALTERED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block ORANGE_MUSHROOM_BLOCK = registerBlock("mushroom_block_orange", new FermentedMushroomBlock(() -> ModBlocks.ORANGE_ALTERED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block YELLOW_MUSHROOM_BLOCK = registerBlock("mushroom_block_yellow", new FermentedMushroomBlock(() -> ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block BLUE_MUSHROOM_BLOCK = registerBlock("mushroom_block_blue", new FermentedMushroomBlock(() -> ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block GREEN_MUSHROOM_BLOCK = registerBlock("mushroom_block_green", new FermentedMushroomBlock(() -> ModBlocks.GREEN_ALTERED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block BLUE_LUMINESCENT_MUSHROOM_BLOCK = registerBlock("mushroom_block_blue_luminescent", new FermentedTransparentMushroomBlock(() -> ModBlocks.BLUE_LUMINESCENT_ALTERED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block PINK_LUMINESCENT_MUSHROOM_BLOCK = registerBlock("mushroom_block_pink_luminescent", new FermentedTransparentMushroomBlock(() -> ModBlocks.PINK_LUMINESCENT_ALTERED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));

    //Fermented Stage 1
    public static final Block PURPLE_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_purple", new FermentedMushroomBlock(() -> ModBlocks.PURPLE_DEGRADATED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block ORANGE_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_orange", new FermentedMushroomBlock(() -> ModBlocks.ORANGE_DEGRADATED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block YELLOW_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_yellow", new FermentedMushroomBlock(() -> ModBlocks.YELLOW_DEGRADATED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block BLUE_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_blue", new FermentedMushroomBlock(() -> ModBlocks.BLUE_DEGRADATED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block GREEN_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_green", new FermentedMushroomBlock(() -> ModBlocks.GREEN_DEGRADATED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block BLUE_LUMINESCENT_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_blue_luminescent", new FermentedTransparentMushroomBlock(() -> ModBlocks.BLUE_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK).nonOpaque().luminance(8)));
    public static final Block PINK_LUMINESCENT_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_pink_luminescent", new FermentedTransparentMushroomBlock(() -> ModBlocks.PINK_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK).nonOpaque().luminance(8)));
    public static final Block RED_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_red", new FermentedMushroomBlock(() -> ModBlocks.RED_DEGRADATED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block BROWN_ALTERED_MUSHROOM_BLOCK = registerBlock("mushroom_block_altered_brown", new FermentedMushroomBlock(() -> ModBlocks.BROWN_DEGRADATED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));

    //Fermented Stage 2
    public static final Block PURPLE_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_purple", new FermentedMushroomBlock(() -> ModBlocks.PURPLE_FERMENTED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block ORANGE_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_orange", new FermentedMushroomBlock(() -> ModBlocks.ORANGE_FERMENTED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block YELLOW_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_yellow", new FermentedMushroomBlock(() -> ModBlocks.YELLOW_FERMENTED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block BLUE_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_blue", new FermentedMushroomBlock(() -> ModBlocks.BLUE_FERMENTED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block GREEN_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_green", new FermentedMushroomBlock(() -> ModBlocks.GREEN_FERMENTED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block BLUE_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_blue_luminescent", new FermentedTransparentMushroomBlock(() -> ModBlocks.BLUE_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK).nonOpaque().luminance(8)));
    public static final Block PINK_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_pink_luminescent", new FermentedTransparentMushroomBlock(() -> ModBlocks.PINK_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK).nonOpaque().luminance(8)));
    public static final Block RED_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_red", new FermentedMushroomBlock(() -> ModBlocks.RED_FERMENTED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block BROWN_DEGRADATED_MUSHROOM_BLOCK = registerBlock("mushroom_block_degradated_brow", new FermentedMushroomBlock(() -> ModBlocks.BROWN_FERMENTED_MUSHROOM_BLOCK, false, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));

    //Fermented Mushrooms
    public static final Block PURPLE_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_purple", new FermentedMushroomBlock(() -> ModBlocks.PURPLE_MUSHROOM_BLOCK, true, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block ORANGE_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_orange", new FermentedMushroomBlock(() -> ModBlocks.ORANGE_MUSHROOM_BLOCK, true, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block YELLOW_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_yellow", new FermentedMushroomBlock(() -> ModBlocks.YELLOW_MUSHROOM_BLOCK, true, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block BLUE_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_blue", new FermentedMushroomBlock(() -> ModBlocks.BLUE_MUSHROOM_BLOCK, true, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block GREEN_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_green", new FermentedMushroomBlock(() -> ModBlocks.GREEN_MUSHROOM_BLOCK, true, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block BLUE_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_blue_luminescent", new FermentedTransparentMushroomBlock(() -> ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK, true, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK).nonOpaque().luminance(8)));
    public static final Block PINK_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_pink_luminescent", new FermentedTransparentMushroomBlock(() -> ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK, true, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK).nonOpaque().luminance(8)));
    public static final Block RED_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_red", new FermentedMushroomBlock(() -> Blocks.RED_MUSHROOM_BLOCK, true, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block BROWN_FERMENTED_MUSHROOM_BLOCK = registerBlock("mushroom_block_fermented_brown", new FermentedMushroomBlock(() -> Blocks.BROWN_MUSHROOM_BLOCK, true, FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));


    //Mushroom Stem
    public static final Block TRANSPARENT_MUSHROOM_STEM = registerBlock("mushroom_stem_transparent", new GlassBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK).nonOpaque().luminance(9)));
    public static final Block BLUE_LUMINESCENT_MUSHROOM_STEM = registerBlock("mushroom_stem_blue_luminescent", new GlassBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK).nonOpaque().luminance(9)));
    public static final Block GREEN_MUSHROOM_STEM = registerBlock("mushroom_stem_green", new GlassBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK).nonOpaque()));


    public static final Block COMPRESSED_PURPLE_MUSHROOM = registerBlock("mushroom_compressed_purple", new MossBlock(FabricBlockSettings.copyOf(Blocks.MOSS_BLOCK)));

    //Soft Blocks
    public static final Block COMPRESSED_DIRT = registerBlock("dirt_compressed", new Block(FabricBlockSettings.copyOf(Blocks.DIRT)));
    public static final Block LIGHT_COMPRESSED_DIRT = registerBlock("dirt_compressed_light", new Block(FabricBlockSettings.copyOf(Blocks.DIRT)));

    //Hard Blocks
    public static final Block PURPLE_SCHROOM_DEESLATE = registerBlock("deepslate_mushroom_purple", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).requiresTool().instrument(Instrument.BASEDRUM)));
    public static final Block BLUE_LUMINESCENT_SCHROOM_DEEPSLATE = registerBlock("deepslate_mushroom_blue_luminescent", new GrassBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).requiresTool().instrument(Instrument.BASEDRUM)));
    public static final Block GREEN_STONY_SCHROOM_DEPOT = registerBlock("stone_mushroom_green", new Block(FabricBlockSettings.copyOf(Blocks.STONE).requiresTool().instrument(Instrument.BASEDRUM)));
    public static final Block RHYOLITE = registerBlock("rhyolite", new Block(FabricBlockSettings.copyOf(Blocks.STONE).requiresTool().instrument(Instrument.BASEDRUM)));
    public static final Block LAVA_BLACKSTONE = registerBlock("blackstone_lava", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE).luminance(8)));


    //mushrooms
    public static final Block GREEN_MUSHROOM = registerBlock("mushroom_green", new MushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM), ModConfiguredFeatures.GREEN_MUSHROOM_TREE_KEY));
    public static final Block PURPLE_MUSHROOM = registerBlock("mushroom_purple", new MushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM), ModConfiguredFeatures.PURPLE_MUSHROOM_TREE_KEY));
    public static final Block BLUE_MUSHROOM = registerBlock("mushroom_blue", new MushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM), ModConfiguredFeatures.BLUE_MUSHROOM_TREE_KEY));
    public static final Block BLUE_LUMINESCENT_MUSHROOM = registerBlock("mushroom_blue_luminescent", new MushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).luminance(5), ModConfiguredFeatures.BLUE_LUMINESCENT_MUSHROOM_TREE_KEY));
    public static final Block LUMINESCENT_PINK_MUSHROOM = registerBlock("mushroom_pink_luminescent", new MushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).luminance(5), ModConfiguredFeatures.PINK_LUMINESCENT_MUSHROOM_TREE_KEY));
    public static final Block ORANGE_MUSHROOM = registerBlock("mushroom_orange", new MushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM), ModConfiguredFeatures.ORANGE_MUSHROOM_TREE_KEY));
    public static final Block YELLOW_MUSHROOM = registerBlock("mushroom_yellow", new MushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).luminance(5), ModConfiguredFeatures.YELLOW_MUSHROOM_TREE_KEY));

    //Flowers Mushroom
    public static final Block STERILE_BLUE_MUSHROOM = registerBlock("sterile_blue_mushroom", new MushroomFlower( FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block MUSHROOM_SMALL_BROWN = registerBlock("mushroom_small_brown", new MushroomFlower(FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block MUSHROOM_SMALL_RED = registerBlock("mushroom_small_red", new MushroomFlower(FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));


    //Flowers
    public static final Block OCULAE = registerBlock("oculae", new FlowerBlock(StatusEffects.DARKNESS, 1000, FabricBlockSettings.copyOf(Blocks.GRASS).nonOpaque().noCollision()));
    public static final Block CYANUS_RUBENS = registerBlock("cyanus_rubens", new FlowerBlock(StatusEffects.DARKNESS, 1000, FabricBlockSettings.copyOf(Blocks.GRASS).nonOpaque().noCollision()));
    public static final Block CYANEA = registerBlock("cyanea", new FlowerBlock(StatusEffects.DARKNESS, 1000, FabricBlockSettings.copyOf(Blocks.GRASS).luminance(12).nonOpaque().noCollision()));
    public static final Block SOL_OCCIDENTIS = registerBlock("sol_occidens", new FlowerBlock(StatusEffects.DARKNESS, 1000, FabricBlockSettings.copyOf(Blocks.GRASS).nonOpaque().noCollision()));
    public static final Block FUTIALI = registerBlock("futiali", new FlowerBlock(StatusEffects.DARKNESS, 1000, FabricBlockSettings.copyOf(Blocks.GRASS).nonOpaque().luminance(11).noCollision()));
    public static final Block MUSHROOM_FLOWERS = registerBlock("mushroom_flowers", new FlowersMushroomBlock(FabricBlockSettings.copyOf(Blocks.TALL_GRASS).nonOpaque().noCollision(), ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_TREE_KEY));
    public static final Block TURQUOSUM_STILUS = registerBlock("turquosum_stilus", new TallFlowerBlock(FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).luminance(11).nonOpaque().noCollision()));
    public static final Block NOCTULICA = registerBlock("noctulica", new FlowerBlock(StatusEffects.DARKNESS, 1000, FabricBlockSettings.copyOf(Blocks.GRASS).luminance(12).nonOpaque().noCollision()));
    public static final Block SAPHIRA_FLORENS = registerBlock("saphira_florens", new TallFlowerBlock(FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().luminance(11).noCollision()));
    public static final Block PREHISTORIC_ROSE = registerBlock("prehistoric_rose", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block PREHISTO_PINK_SCHROOM = registerBlock("prehisto_pink_schroom", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block PREHISTURPLE_SCHROOM = registerBlock("prehisturple_schroom", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block PREHISTO_BLUE_SCHROOM = registerBlock("prehisto_blue_schroom", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block PREHISTO_GREEN_SCHROOM = registerBlock("prehisto_green_schroom", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block YELLOW_PERENNIAL = registerBlock("perennial_yellow", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block PINK_PERENNIAL = registerBlock("perennial_pink", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block BLUE_PERENNIAL = registerBlock("perennial_blue", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block GREEN_PERENNIAL = registerBlock("perennial_green", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block LUMINESCENT_PERENNIAL = registerBlock("perennial_luminescent", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block ORANGE_PERENNIAL = registerBlock("perennial_orange", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block PURPLE_PERENNIAL = registerBlock("perennial_purple", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block RED_QUINCE = registerBlock("quince_red", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block YELLOW_QUINCE = registerBlock("quince_yellow", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block TINY_LILAC = registerBlock("tiny_lilac", new TallFlowerBlock(FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block YELICE = registerBlock("yelice", new FlowerBlock(StatusEffects.GLOWING, 5, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block FLAMESTHYSIA = registerBlock("flamesthysia", new FlowerBlock(StatusEffects.GLOWING, 5, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block APAGANTHE = registerBlock("apaganthe", new FlowerBlock(StatusEffects.GLOWING, 5, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block PINK_HEATER = registerBlock("pink_heater", new TallFlowerBlock(FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block WYSTERIA = registerBlock("wysteria", new FlowerBlock(StatusEffects.GLOWING, 5, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block BLUEBELL = registerBlock("bluebell", new FlowerBlock(StatusEffects.GLOWING, 5, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block VIPERIN = registerBlock("viperin", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block HIBISCUS = registerBlock("hibiscus", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block PLATUM = registerBlock("platum", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).luminance(10).nonOpaque().noCollision()));
    public static final Block DIANTHUS = registerBlock("dianthus", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block CYCAS = registerBlock("cycas", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block ARUM = registerBlock("arum", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block HYDRANGEA = registerBlock("hydrangea", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block ANEMONE = registerBlock("anemone", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block JACYNTHE = registerBlock("jacynthe", new FlowerBlock(StatusEffects.GLOWING, 10, FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block PERVENCHE = registerBlock("pervenche", new TallFlowerBlock(FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block ACONIT = registerBlock("aconit", new TallFlowerBlock(FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));

    //Potted Mushrooms
    public static final Block POTTED_STERILE_BLUE_MUSHROOM = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_sterile_blue_mushroom"), new FlowerPotBlock(STERILE_BLUE_MUSHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_MUSHROOM_SMALL_BROWN = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_mushroom_small_brown"), new FlowerPotBlock(MUSHROOM_SMALL_BROWN, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_MUSHROOM_SMALL_RED = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_mushroom_small_red"), new FlowerPotBlock(MUSHROOM_SMALL_RED, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));


    //Grass
    public static final Block TINY_GRASS = registerBlock("tiny_grass", new GrassBlock(FabricBlockSettings.copyOf(Blocks.GRASS)));
    public static final Block BLUE_LUMINESCENT_GRASS = registerBlock("grass_blue_luminescent", new GrassBlock(FabricBlockSettings.copyOf(Blocks.GRASS).luminance(9)));
    public static final Block BLUE_LUMINESCENT_TALL_GRASS = registerBlock("grass_tall_blue_luminescent", new TallPlantBlock(FabricBlockSettings.copyOf(Blocks.TALL_GRASS).luminance(11)));

    //Vines
    public static final Block PINK_MUSHROOM_VINES = registerHiddenBlock("mushroom_vines_pink", new PinkMushroomVinesHeadBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.CAVE_VINES).pistonBehavior(PistonBehavior.DESTROY).noCollision()));
    public static final Block PINK_MUSHROOM_VINES_PLANT = registerHiddenBlock("mushroom_vines_pink_plant", new PinkMushroomVinesBodyBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.CAVE_VINES).pistonBehavior(PistonBehavior.DESTROY).noCollision()));
    public static final Block PINK_LUMINESCENT_BODY_VINES = registerHiddenBlock("mushroom_vines_pink_luminescent_body", new PinkLuminescentBodyVinesBlock(FabricBlockSettings.create().nonOpaque().sounds(BlockSoundGroup.HONEY).pistonBehavior(PistonBehavior.DESTROY).breakInstantly().luminance(state -> state.get(PinkLuminescentBodyVinesBlock.MANY_VINES) ? 0 : 15)));
    public static final Block PINK_LUMINESCENT_HEAD_VINES = registerHiddenBlock("mushroom_vines_pink_luminescent_head", new PinkLuminescentHeadVinesBlock(FabricBlockSettings.create().nonOpaque().sounds(BlockSoundGroup.HONEY).pistonBehavior(PistonBehavior.DESTROY).breakInstantly().luminance(3)));
    public static final Block CAERULEA_VOLUBILIS = registerHiddenBlock("caerulea_volubilis", new BlueLuminescentVines(FabricBlockSettings.copyOf(Blocks.TWISTING_VINES).luminance(12)));


    //Potted Flowers
    public static final Block POTTED_GREEN_MUSHROOM = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_green_mushroom"), new FlowerPotBlock(GREEN_MUSHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_BLUE_MUSHROOM = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_blue_mushroom"), new FlowerPotBlock(BLUE_MUSHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_PURPLE_MUSHROOM = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_purple_mushroom"), new FlowerPotBlock(PURPLE_MUSHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_BLUE_LUMINESCENT_MUSHROOM = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_blue_luminescent_mushroom"), new FlowerPotBlock(BLUE_LUMINESCENT_MUSHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque().luminance(5)));
    public static final Block POTTED_OCULAE = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_oculae"), new FlowerPotBlock(OCULAE, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block POTTED_LUMINESCENT_PINK_MUSHROOM = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_luminescent_pink_mushroom"), new FlowerPotBlock(LUMINESCENT_PINK_MUSHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_CYANUS_RUBENS = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_cyanus_rubens"), new FlowerPotBlock(CYANUS_RUBENS, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_CYANEA = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_cyanea"), new FlowerPotBlock(CYANEA, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_SOL_OCCIDENTIS = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_sol_occidentis"), new FlowerPotBlock(SOL_OCCIDENTIS, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_FUTIALI = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_futiali"), new FlowerPotBlock(FUTIALI, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_NOCTULICA = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_noctulica"), new FlowerPotBlock(NOCTULICA, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_PREHISTORIC_ROSE = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_prehistoric_rose"), new FlowerPotBlock(PREHISTORIC_ROSE, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_PREHISTO_BLUE_SCHROOM = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_prehisto_blue_schroom"), new FlowerPotBlock(PREHISTO_BLUE_SCHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_PREHISTO_PINK_SCHROOM = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_prehisto_pink_schroom"), new FlowerPotBlock(PREHISTO_PINK_SCHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_PREHISTURPLE_SCHROOM = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_prehisturple_schroom"), new FlowerPotBlock(PREHISTURPLE_SCHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_PREHISTO_GREEN_SCHROOM = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_prehisto_green_schroom"), new FlowerPotBlock(PREHISTO_GREEN_SCHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_YELLOW_PERENNIAL = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_perennial_yellow"), new FlowerPotBlock(YELLOW_PERENNIAL, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_GREEN_PERENNIAL = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_perennial_green"), new FlowerPotBlock(GREEN_PERENNIAL, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_ORANGE_PERENNIAL = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_perennial_orange"), new FlowerPotBlock(ORANGE_PERENNIAL, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_BLUE_PERENNIAL = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_perennial_blue"), new FlowerPotBlock(BLUE_PERENNIAL, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_LUMINESCENT_PERENNIAL = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_perennial_luminescent"), new FlowerPotBlock(LUMINESCENT_PERENNIAL, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_PINK_PERENNIAL = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_perennial_pink"), new FlowerPotBlock(PINK_PERENNIAL, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_PURPLE_PERENNIAL = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_perennial_purple"), new FlowerPotBlock(PURPLE_PERENNIAL, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_RED_QUINCE = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_quince_red"), new FlowerPotBlock(RED_QUINCE, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_YELLOW_QUINCE = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_quince_yellow"), new FlowerPotBlock(YELLOW_QUINCE, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_YELICE = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_yelice"), new FlowerPotBlock(YELICE, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_FLAMESTHYSIA = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_flamesthysia"), new FlowerPotBlock(FLAMESTHYSIA, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_APAGANTHE = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_apaganthe"), new FlowerPotBlock(APAGANTHE, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_WYSTERIA = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_wysteria"), new FlowerPotBlock(WYSTERIA, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_BLUEBELL = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_bluebell"), new FlowerPotBlock(WYSTERIA, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_VIPERIN = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_viperin"), new FlowerPotBlock(VIPERIN, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_HIBISCUS = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_hibiscus"), new FlowerPotBlock(HIBISCUS, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_PLATUM = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_platum"), new FlowerPotBlock(PLATUM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_DIANTHUS = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_dianthus"), new FlowerPotBlock(DIANTHUS, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_CYCAS = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_cycas"), new FlowerPotBlock(CYCAS, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_ARUM = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_arum"), new FlowerPotBlock(ARUM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_HYDRANGEA = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_hydrangea"), new FlowerPotBlock(HYDRANGEA, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_ANEMONE = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_anemone"), new FlowerPotBlock(ANEMONE, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_JACYNTHE = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_jacynthe"), new FlowerPotBlock(JACYNTHE, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_YELLOW_MUSHROOM = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_yellow_mushroom"), new FlowerPotBlock(YELLOW_MUSHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_ORANGE_MUSHROOM = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_orange_mushroom"), new FlowerPotBlock(ORANGE_MUSHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_BLUE_LUMINESCENT_SAPPLING = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_blue_luminescent_sappling"), new FlowerPotBlock(ModBlocks.BLUE_LUMINESCENT_SAPPLING, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));


    //Big Mushrooms
    public static final Block BIG_PURPLE_MUSHROOM_PLANT = registerHiddenBlock("mushroom_big_plant_purple", new BigPurpleMushroomPlant(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).collidable(true), ModBlocks.TINY_PURPLE_MUSHROOM, ModBlocks.LITTLE_PURPLE_MUSHROOM, ModBlocks.MEDIUM_PURPLE_MUSHROOM, ModBlocks.BIG_PURPLE_MUSHROOM));
    public static final Block TINY_PURPLE_MUSHROOM = registerBlock("mushroom_tiny_purple", new TinyPurpleMushroom(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).collidable(true).nonOpaque(), ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_TREE_KEY));
    public static final Block LITTLE_PURPLE_MUSHROOM = registerBlock("mushroom_little_purple", new LittlePurpleMushroom(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).collidable(true).nonOpaque(), ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_TREE_KEY));
    public static final Block MEDIUM_PURPLE_MUSHROOM = registerBlock("mushroom_medium_purple", new MediumPurpleMushroom(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).collidable(true).nonOpaque(), ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_TREE_KEY));
    public static final Block BIG_PURPLE_MUSHROOM = registerBlock("mushroom_big_purple", new BigPurpleMushroom(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).collidable(true).nonOpaque(), ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_TREE_KEY));
    public static final Block TINY_GREEN_MUSHROOM = registerBlock("mushroom_tiny_green", new TinyGreenMushroom(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).collidable(true).nonOpaque(), ModConfiguredFeatures.BIG_GREEN_MUSHROOM_TREE_KEY));
    public static final Block LITTLE_GREEN_MUSHROOM = registerBlock("mushroom_little_green", new LittleGreenMushroom(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).collidable(true).nonOpaque(), ModConfiguredFeatures.BIG_GREEN_MUSHROOM_TREE_KEY));
    public static final Block MEDIUM_GREEN_MUSHROOM = registerBlock("mushroom_medium_green", new MediumGreenMushroom(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).collidable(true).nonOpaque(), ModConfiguredFeatures.BIG_GREEN_MUSHROOM_TREE_KEY));
    public static final Block BIG_GREEN_MUSHROOM = registerBlock("mushroom_big_green", new BigGreenMushroom(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).collidable(true).nonOpaque(), ModConfiguredFeatures.BIG_GREEN_MUSHROOM_TREE_KEY));
    public static final Block BIG_GREEN_MUSHROOM_PLANT = registerHiddenBlock("mushroom_big_plant_green", new BigGreenMushroomPlant(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).collidable(true), ModBlocks.TINY_GREEN_MUSHROOM, ModBlocks.LITTLE_GREEN_MUSHROOM, ModBlocks.MEDIUM_GREEN_MUSHROOM, ModBlocks.BIG_GREEN_MUSHROOM));
    public static final Block RED_LUMERIA = registerBlock("red_lumeria", new BigRedMushroom(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).nonOpaque().noCollision(), ModConfiguredFeatures.BIG_RED_MUSHROOM_TREE_KEY));

    //Leaves
    public static final Block BLUE_LUMINESCENT_LEAVES = registerBlock("leaves_blue_luminescent", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).luminance(10).nonOpaque()));
    public static final Block RED_COLORFUL_LEAVES = registerBlock("leaves_colorful_red", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));
    public static final Block PINK_COLORFUL_LEAVES = registerBlock("leaves_colorful_pink", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));
    public static final Block ORANGE_COLORFUL_LEAVES = registerBlock("leaves_colorful_orange", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));
    public static final Block YELLOW_COLORFUL_LEAVES = registerBlock("leaves_colorful_yellow", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));
    public static final Block GREEN_COLORFUL_LEAVES = registerBlock("leaves_colorful_green", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));
    public static final Block BLUE_COLORFUL_LEAVES = registerBlock("leaves_colorful_blue", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));
    public static final Block PURPLE_COLORFUL_LEAVES = registerBlock("leaves_colorful_purple", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));

    //Light Blocks
    public static final Block RED_LANTERN = registerBlock("lantern_red", new LanternBlock(FabricBlockSettings.copyOf(Blocks.LANTERN).luminance(15).nonOpaque()));
    public static final Block GREEN_LANTERN = registerBlock("lantern_green", new LanternBlock(FabricBlockSettings.copyOf(Blocks.LANTERN).luminance(13).nonOpaque()));
    public static final Block GREEN_TORCH = registerHiddenBlock("torch_green", new TorchBlock(FabricBlockSettings.copyOf(Blocks.TORCH).luminance(12).nonOpaque(), ModParticles.GREENFIRE_PARTICLE));
    public static final Block WALL_GREEN_TORCH = registerHiddenBlock("torch_wall_green", new WallTorchBlock(FabricBlockSettings.copyOf(Blocks.WALL_TORCH).luminance(12).nonOpaque(), ModParticles.GREENFIRE_PARTICLE));
    public static final Block GREEN_CAMPFIRE = registerBlock("campfire_green", new CampfireBlock(true, 1, FabricBlockSettings.copyOf(Blocks.CAMPFIRE).luminance(13).nonOpaque()));


    //Construction Blocks
    public static final Block LAVA_BLACKSTONE_BRICKS = registerBlock("blackstone_lava_bricks", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE).luminance(8)));
    public static final Block LAVA_BLACKSTONE_MEDIUM_BRICKS = registerBlock("blackstone_lava_medium_bricks", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE).luminance(8)));
    public static final Block LAVA_BLACKSTONE_TINY_BRICKS = registerBlock("blackstone_lava_tiny_bricks", new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE).luminance(8)));

    //Wood
    public static final Block BLUE_LUMINESCENT_LOG = registerBlock("log_blue_luminescent", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block BLUE_LUMINESCENT_STRIPPED_LOG = registerBlock("log_stripped_blue_luminescent", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block BLUE_LUMINESCENT_STRIPPED_WOOD = registerBlock("wood_stripped_blue_luminescent", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block BLUE_LUMINESCENT_WOOD = registerBlock("wood_blue_luminescent", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block BLUE_LUMINESCENT_PLANKS = registerBlock("planks_blue_luminescent", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block BLUE_LUMINESCENT_TRAPDOOR = registerBlock("trapdoor_blue_luminescent", new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final Block BLUE_LUMINESCENT_DOOR = registerBlock("door_blue_luminescent", new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final Block BLUE_LUMINESCENT_BUTTON = registerBlock("button_blue_luminescent", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.OAK, 20, true));
    public static final Block BLUE_LUMINESCENT_PRESSURE_PLATE = registerBlock("pressure_plate_blue_luminescent", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public static final Block BLUE_LUMINESCENT_FENCE = registerBlock("fence_blue_luminescent", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    public static final Block BLUE_LUMINESCENT_FENCE_GATE = registerBlock("fence_gate_blue_luminescent", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));
    public static final Block BLUE_LUMINESCENT_SAPPLING = registerBlock("sappling_blue_luminescent", new SaplingBlock(new BlueLuminescentSapplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block BLUE_LUMINESCENT_STAIRS = registerBlock("stairs_blue_luminescent", new StairsBlock(BLUE_LUMINESCENT_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS).luminance(8)));
    public static final Block BLUE_LUMINESCENT_SLAB = registerBlock("slab_blue_luminescent", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));

    //Crystal Blocks
    public static final Block PINK_CRYSTAL = registerHiddenBlock("crystal_pink", new PinkCrystal(FabricBlockSettings.copyOf(Blocks.AMETHYST_CLUSTER)));
    public static final Block BLUE_CRYSTAL = registerHiddenBlock("crystal_blue", new Crystal(FabricBlockSettings.create().solid().nonOpaque().sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.5f).pistonBehavior(PistonBehavior.DESTROY).luminance(8)));
    public static final Block PINK_CRYSTAL_BLOCK = registerBlock("crystal_block_pink", new AmethystBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).sounds(ModBlockSoundGroup.PINK_CRYSTAL)));

   public static final Block AMBER_BLOCK = registerBlock("amber_block", new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK)));
   public static final Block AMBER_BLOCK_SANDIFIED = registerBlock("amber_block_sandified", new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE)));
   public static final Block AMBER_ORE = registerBlock("amber_ore", new Block(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE)));

    //Util Blocks
    public static final Block FORGE_BLOCK = registerBlock("forge_block", new ForgeBlock(FabricBlockSettings.copyOf(Blocks.ANVIL).nonOpaque()));

    //Idk
    public static final Block CLOUD_BLOCK = registerBlock("cloud_block", new Block(FabricBlockSettings.copyOf(Blocks.MOSS_BLOCK).strength(0.6f)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(MushrooomsMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static Block registerHiddenBlock(String id, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, id), block);
    }

    public static void registerModBlocks() {
        MushrooomsMod.LOGGER.info("Registering ModBlocks for " + MushrooomsMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModBlocks::addItemstoNaturalGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModBlocks::addItemstoFoodGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModBlocks::addItemstoFunctionalGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModBlocks::addItemstoToolsGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(ModBlocks::addItemstoSpawnEggsGroup);
    }
}
