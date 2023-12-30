package net.louis.mushrooomsmod.block;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.louis.mushrooomsmod.MushrooomsMod;
import net.louis.mushrooomsmod.block.PinkLuminescentVines.PinkLuminescentBodyVinesBlock;
import net.louis.mushrooomsmod.block.PinkLuminescentVines.PinkLuminescentHeadVinesBlock;
import net.louis.mushrooomsmod.block.PinkMushroomBlock.PinkMushroomVinesBodyBlock;
import net.louis.mushrooomsmod.block.PinkMushroomBlock.PinkMushroomVinesHeadBlock;
import net.louis.mushrooomsmod.block.bigmushroom.*;
import net.louis.mushrooomsmod.item.ModItems;
import net.louis.mushrooomsmod.particle.ModParticles;
import net.louis.mushrooomsmod.world.ModConfiguredFeatures;
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
public class ModBlocks {
    private static void  addItemstoNaturalGroup(FabricItemGroupEntries entries){
        //Blocks
        //Natural
        //Mushroom Related
        entries.add(BLUE_MUSHROOM_BLOCK);
        entries.add(LUMINESCENT_MUSHROOM_BLOCK);
        entries.add(LUMINESCENT_MUSHROOM_STEM);
        entries.add(PURPLE_MUSHROOM_BLOCK);
        entries.add(GREEN_MUSHROOM_BLOCK);
        entries.add(TRANSPARENT_MUSHROOM_STEM);
        entries.add(GREEN_MUSHROOM_STEM);
        entries.add(LUMINESCENT_PINK_MUSHROOM_BLOCK);
        entries.add(COMPRESSED_PURPLE_MUSHROOM);

        //Soft Blocks
        entries.add(COMPRESSED_DIRT);
        entries.add(LIGHT_COMPRESSED_DIRT);

        //Hard Blocks
        entries.add(PURPLE_SCHROOM_DEESLATE);
        entries.add(BLUE_LUMINESCENT_SCHROOM_DEESLATE);
        entries.add(GREEN_STONY_SCHROOM_DEPOT);
        entries.add(RHYOLITE);

        //Mushrooms
        entries.add(GREEN_MUSHROOM);
        entries.add(BLUE_MUSHROOM);
        entries.add(PURPLE_MUSHROOM);
        entries.add(LUMINESCENT_MUSHROOM);
        entries.add(LUMINESCENT_PINK_MUSHROOM);

        //Flowers
        entries.add(PREHISTO_PINK_SCHROOM);
        entries.add(PREHISTO_BLUE_SCHROOM);
        entries.add(PREHISTURPLE_SCHROOM);
        entries.add(PREHISTO_GREEN_SCHROOM);
        entries.add(MUSHROOM_FLOWERS);
        entries.add(RED_LUMERIA);
        entries.add(SOL_OCCIDENTIS);
        entries.add(CYANUS_RUBENS);
        entries.add(CYANEA);
        entries.add(FUTIALI);
        entries.add(NOCTULICA);
        entries.add(TURQUOSUM_STILUS);
        entries.add(SAPHIRA_FLORENS);
        entries.add(PREHISTORIC_ROSE);
        entries.add(ORANGE_PERENNIAL);
        entries.add(BLUE_PERENNIAL);
        entries.add(GREEN_PERENNIAL);
        entries.add(PINK_PERENNIAL);
        entries.add(LUMINESCENT_PERENNIAL);
        entries.add(PURPLE_PERENNIAL);
        entries.add(YELLOW_PERENNIAL);
        entries.add(YELLOW_QUINCE);
        entries.add(RED_QUINCE);
        entries.add(TINY_LILAC);
        entries.add(OCULAE);
        entries.add(YELICE);
        entries.add(FLAMESTHYSIA);
        entries.add(APAGANTHE);
        entries.add(PINK_HEATER);
        entries.add(WYSTERIA);
        entries.add(BLUEBELL);


        //Vines
        entries.add(ModItems.CAERULEA_VOLUBILIS_ITEM);
        entries.add(ModItems.PINK_MUSHROOM_VINES_ITEM);

        //Big Mushrooms
        entries.add(ModItems.BIG_PURPLE_MUSHROOM_SEED);
        entries.add(ModItems.BIG_GREEN_MUSHROOM_SEED);
        entries.add(ModItems.PURPLE_MUSHROOM_POWDER);
        entries.add(ModBlocks.TINY_PURPLE_MUSHROOM);
        entries.add(ModBlocks.LITTLE_PURPLE_MUSHROOM);
        entries.add(ModBlocks.MEDIUM_PURPLE_MUSHROOM);
        entries.add(ModBlocks.BIG_PURPLE_MUSHROOM);
        entries.add(ModBlocks.TINY_GREEN_MUSHROOM);
        entries.add(ModBlocks.LITTLE_GREEN_MUSHROOM);
        entries.add(ModBlocks.MEDIUM_GREEN_MUSHROOM);
        entries.add(ModBlocks.BIG_GREEN_MUSHROOM);
    }
    private static void  addItemstoFoodGroup(FabricItemGroupEntries entries){
        entries.add(ModItems.BAGUETTE);
    }
    private static void addItemstoFunctionalGroup(FabricItemGroupEntries entries){
        //Light Blocks
        entries.add(GREEN_LANTERN);
        entries.add(RED_LANTERN);
        entries.add(ModItems.GREEN_TORCH);
        entries.add(GREEN_CAMPFIRE);
    }
    private static void addItemstoToolsGroup(FabricItemGroupEntries entries){
        //Music Disk
        entries.add(ModItems.HYMNE_FRANCAIS_MUSIC_DISC);
        entries.add(ModItems.HYMNE_URSS_MUSIC_DISC);
    }

    //Mushrooms Blocks
    public static final Block LUMINESCENT_MUSHROOM_BLOCK = registerBlock("luminescent_mushroom_block", new GlassBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK).nonOpaque().luminance(10)));
    public static final Block LUMINESCENT_MUSHROOM_STEM = registerBlock("luminescent_mushroom_stem", new GlassBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK).nonOpaque().luminance(9)));
    public static final Block BLUE_MUSHROOM_BLOCK = registerBlock("blue_mushroom_block", new Block(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block PURPLE_MUSHROOM_BLOCK = registerBlock("purple_mushroom_block", new Block(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block GREEN_MUSHROOM_BLOCK = registerBlock("green_mushroom_block", new Block(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block LUMINESCENT_PINK_MUSHROOM_BLOCK = registerBlock("luminescent_pink_mushroom_block", new GlassBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK).nonOpaque().luminance(10)));
    public static final Block TRANSPARENT_MUSHROOM_STEM = registerBlock("transparent_mushroom_stem", new GlassBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK).nonOpaque().luminance(9)));
    public static final Block GREEN_MUSHROOM_STEM = registerBlock("green_mushroom_stem", new GlassBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK).nonOpaque()));
    public static final Block COMPRESSED_PURPLE_MUSHROOM = registerBlock("compressed_purple_mushroom", new MossBlock(FabricBlockSettings.copyOf(Blocks.MOSS_BLOCK)));

    //Soft Blocks
    public static final Block COMPRESSED_DIRT = registerBlock("compressed_dirt", new Block(FabricBlockSettings.copyOf(Blocks.DIRT)));
    public static final Block LIGHT_COMPRESSED_DIRT = registerBlock("light_compressed_dirt", new Block(FabricBlockSettings.copyOf(Blocks.DIRT)));

    //Hard Blocks
    public static final Block PURPLE_SCHROOM_DEESLATE = registerBlock("purple_schroom_deepslate", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).requiresTool().instrument(Instrument.BASEDRUM)));
    public static final Block BLUE_LUMINESCENT_SCHROOM_DEESLATE = registerBlock("blue_luminescent_schroom_deepslate", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).luminance(3).requiresTool().instrument(Instrument.BASEDRUM)));
    public static final Block GREEN_STONY_SCHROOM_DEPOT = registerBlock("green_stony_schroom_depot", new Block(FabricBlockSettings.copyOf(Blocks.STONE).requiresTool().instrument(Instrument.BASEDRUM)));
    public static final Block RHYOLITE = registerBlock("rhyolite", new Block(FabricBlockSettings.copyOf(Blocks.STONE).requiresTool().instrument(Instrument.BASEDRUM)));


    //mushrooms
    public static final Block GREEN_MUSHROOM = registerBlock("green_mushroom", new MushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM), ModConfiguredFeatures.GREEN_MUSHROOM_KEY));
    public static final Block PURPLE_MUSHROOM = registerBlock("purple_mushroom", new MushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM), ModConfiguredFeatures.PURPLE_MUSHROOM_KEY));
    public static final Block BLUE_MUSHROOM = registerBlock("blue_mushroom", new MushroomPlantBlock( FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM),ModConfiguredFeatures.BLUE_MUSHROOM_KEY));
    public static final Block LUMINESCENT_MUSHROOM = registerBlock("luminescent_mushroom", new MushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).luminance(5), ModConfiguredFeatures.LUMINESCENT_MUSHROOM_KEY));
    public static final Block LUMINESCENT_PINK_MUSHROOM = registerBlock("luminescent_pink_mushroom", new MushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).luminance(5), ModConfiguredFeatures.LUMINESCENT_PINK_MUSHROOM_KEY));


    //Flowers
    public static final Block OCULAE = registerBlock("oculae", new FlowerBlock(StatusEffects.DARKNESS, 1000, FabricBlockSettings.copyOf(Blocks.GRASS).nonOpaque().noCollision()));
    public static final Block CYANUS_RUBENS = registerBlock("cyanus_rubens", new FlowerBlock(StatusEffects.DARKNESS, 1000, FabricBlockSettings.copyOf(Blocks.GRASS).nonOpaque().noCollision()));
    public static final Block CYANEA = registerBlock("cyanea", new FlowerBlock(StatusEffects.DARKNESS, 1000, FabricBlockSettings.copyOf(Blocks.GRASS).nonOpaque().noCollision()));
    public static final Block SOL_OCCIDENTIS = registerBlock("sol_occidens", new FlowerBlock(StatusEffects.DARKNESS, 1000, FabricBlockSettings.copyOf(Blocks.GRASS).nonOpaque().noCollision()));
    public static final Block FUTIALI = registerBlock("futiali", new FlowerBlock(StatusEffects.DARKNESS, 1000, FabricBlockSettings.copyOf(Blocks.GRASS).nonOpaque().noCollision()));
    public static final Block MUSHROOM_FLOWERS = registerBlock("mushroom_flowers", new FlowersMushroomBlock(FabricBlockSettings.copyOf(Blocks.TALL_GRASS).nonOpaque().noCollision(), ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_KEY));
    public static final Block TURQUOSUM_STILUS = registerBlock("turquosum_stilus", new TallFlowerBlock(FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block NOCTULICA = registerBlock("noctulica", new FlowerBlock(StatusEffects.DARKNESS, 1000, FabricBlockSettings.copyOf(Blocks.GRASS).nonOpaque().noCollision()));
    public static final Block SAPHIRA_FLORENS = registerBlock("saphira_florens", new TallFlowerBlock(FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block PREHISTORIC_ROSE = registerBlock("prehistoric_rose", new FlowerBlock(StatusEffects.GLOWING,10 ,FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block PREHISTO_PINK_SCHROOM = registerBlock("prehisto_pink_schroom", new FlowerBlock(StatusEffects.GLOWING,10 ,FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block PREHISTURPLE_SCHROOM = registerBlock("prehisturple_schroom", new FlowerBlock(StatusEffects.GLOWING,10 ,FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block PREHISTO_BLUE_SCHROOM = registerBlock("prehisto_blue_schroom", new FlowerBlock(StatusEffects.GLOWING,10 ,FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block PREHISTO_GREEN_SCHROOM = registerBlock("prehisto_green_schroom", new FlowerBlock(StatusEffects.GLOWING,10 ,FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block YELLOW_PERENNIAL = registerBlock("perennial_yellow", new FlowerBlock(StatusEffects.GLOWING,10 ,FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block PINK_PERENNIAL = registerBlock("perennial_pink", new FlowerBlock(StatusEffects.GLOWING,10 ,FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block BLUE_PERENNIAL = registerBlock("perennial_blue", new FlowerBlock(StatusEffects.GLOWING,10 ,FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block GREEN_PERENNIAL = registerBlock("perennial_green", new FlowerBlock(StatusEffects.GLOWING,10 ,FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block LUMINESCENT_PERENNIAL = registerBlock("perennial_luminescent", new FlowerBlock(StatusEffects.GLOWING,10 ,FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block ORANGE_PERENNIAL = registerBlock("perennial_orange", new FlowerBlock(StatusEffects.GLOWING,10 ,FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block PURPLE_PERENNIAL = registerBlock("perennial_purple", new FlowerBlock(StatusEffects.GLOWING,10 ,FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block RED_QUINCE = registerBlock("quince_red", new FlowerBlock(StatusEffects.GLOWING,10 ,FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block YELLOW_QUINCE = registerBlock("quince_yellow", new FlowerBlock(StatusEffects.GLOWING,10 ,FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block TINY_LILAC = registerBlock("tiny_lilac", new TallFlowerBlock(FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block YELICE = registerBlock("yelice", new FlowerBlock(StatusEffects.GLOWING,5 ,FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block FLAMESTHYSIA = registerBlock("flamesthysia", new FlowerBlock(StatusEffects.GLOWING,5 ,FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block APAGANTHE = registerBlock("apaganthe", new FlowerBlock(StatusEffects.GLOWING,5 ,FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block PINK_HEATER = registerBlock("pink_heater", new TallFlowerBlock(FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block WYSTERIA = registerBlock("wysteria", new FlowerBlock(StatusEffects.GLOWING,5 ,FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));
    public static final Block BLUEBELL = registerBlock("bluebell", new FlowerBlock(StatusEffects.GLOWING,5 ,FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));

    //Vines
    public static final Block PINK_MUSHROOM_VINES =  registerBlock("pink_mushroom_vines", new PinkMushroomVinesHeadBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.CAVE_VINES).pistonBehavior(PistonBehavior.DESTROY).noCollision()));
    public static final Block PINK_MUSHROOM_VINES_PLANT = registerBlock("pink_mushroom_vines_plant", new PinkMushroomVinesBodyBlock(FabricBlockSettings.create().breakInstantly().sounds(BlockSoundGroup.CAVE_VINES).pistonBehavior(PistonBehavior.DESTROY).noCollision()));
    public static final Block PINK_LUMINESCENT_BODY_VINES = registerBlock("pink_luminescent_body_vines", new PinkLuminescentBodyVinesBlock(FabricBlockSettings.create().nonOpaque().sounds(BlockSoundGroup.HONEY).pistonBehavior(PistonBehavior.DESTROY).breakInstantly().luminance(state -> state.get(PinkLuminescentBodyVinesBlock.MANY_VINES) ? 0 : 15)));
    public static final Block PINK_LUMINESCENT_HEAD_VINES = registerBlock("pink_luminescent_head_vines", new PinkLuminescentHeadVinesBlock(FabricBlockSettings.create().nonOpaque().sounds(BlockSoundGroup.HONEY).pistonBehavior(PistonBehavior.DESTROY).breakInstantly().luminance(3)));
    public static final Block CAERULEA_VOLUBILIS = registerBlock("caerulea_volubilis", new BlueLuminescentVines(FabricBlockSettings.copyOf(Blocks.TWISTING_VINES)));


    //Potted Flowers
    public static final Block POTTED_GREEN_MUSHROOM  = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_green_mushroom"), new FlowerPotBlock(GREEN_MUSHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_BLUE_MUSHROOM  = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_blue_mushroom"), new FlowerPotBlock(BLUE_MUSHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_PURPLE_MUSHROOM  = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_purple_mushroom"), new FlowerPotBlock(PURPLE_MUSHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque()));
    public static final Block POTTED_LUMINESCENT_MUSHROOM  = Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, "potted_luminescent_mushroom"), new FlowerPotBlock(LUMINESCENT_MUSHROOM, FabricBlockSettings.copyOf(Blocks.POTTED_RED_MUSHROOM).nonOpaque().luminance(5)));
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



    //Big Mushrooms
    public static final Block BIG_PURPLE_MUSHROOM_PLANT = registerBlock("big_purple_mushroom_plant" , new BigPurpleMushroomPlant(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).collidable(true), ModBlocks.TINY_PURPLE_MUSHROOM,ModBlocks.LITTLE_PURPLE_MUSHROOM,ModBlocks.MEDIUM_PURPLE_MUSHROOM,ModBlocks.BIG_PURPLE_MUSHROOM));
    public static final Block TINY_PURPLE_MUSHROOM = registerBlock("tiny_purple_mushroom" , new TinyPurpleMushroom(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).collidable(true).nonOpaque(), ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_KEY));
    public static final Block LITTLE_PURPLE_MUSHROOM = registerBlock("little_purple_mushroom" , new LittlePurpleMushroom(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).collidable(true).nonOpaque(), ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_KEY));
    public static final Block MEDIUM_PURPLE_MUSHROOM = registerBlock("medium_purple_mushroom" , new MediumPurpleMushroom(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).collidable(true).nonOpaque(), ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_KEY));
    public static final Block BIG_PURPLE_MUSHROOM = registerBlock("big_purple_mushroom" , new BigPurpleMushroom(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).collidable(true).nonOpaque(), ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_KEY));
    public static final Block TINY_GREEN_MUSHROOM = registerBlock("tiny_green_mushroom" , new TinyGreenMushroom(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).collidable(true).nonOpaque(), ModConfiguredFeatures.BIG_GREEN_MUSHROOM_KEY));
    public static final Block LITTLE_GREEN_MUSHROOM = registerBlock("little_green_mushroom" , new LittleGreenMushroom(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).collidable(true).nonOpaque(), ModConfiguredFeatures.BIG_GREEN_MUSHROOM_KEY));
    public static final Block MEDIUM_GREEN_MUSHROOM = registerBlock("medium_green_mushroom" , new MediumGreenMushroom(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).collidable(true).nonOpaque(), ModConfiguredFeatures.BIG_GREEN_MUSHROOM_KEY));
    public static final Block BIG_GREEN_MUSHROOM = registerBlock("big_green_mushroom" , new BigGreenMushroom(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).collidable(true).nonOpaque(), ModConfiguredFeatures.BIG_GREEN_MUSHROOM_KEY));
    public static final Block BIG_GREEN_MUSHROOM_PLANT = registerBlock("big_green_mushroom_plant" , new BigGreenMushroomPlant(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).collidable(true), ModBlocks.TINY_GREEN_MUSHROOM,ModBlocks.LITTLE_GREEN_MUSHROOM,ModBlocks.MEDIUM_GREEN_MUSHROOM,ModBlocks.BIG_GREEN_MUSHROOM));
    public static final Block RED_LUMERIA = registerBlock("red_lumeria", new BigRedMushroom(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM).nonOpaque().noCollision(), ModConfiguredFeatures.BIG_RED_MUSHROOM_KEY));

    //Light Blocks
    public static final Block RED_LANTERN = registerBlock("red_lantern", new LanternBlock(FabricBlockSettings.copyOf(Blocks.LANTERN).luminance(15).nonOpaque()));
    public static final Block GREEN_LANTERN = registerBlock("green_lantern", new LanternBlock(FabricBlockSettings.copyOf(Blocks.LANTERN).luminance(13).nonOpaque()));
    public static final Block GREEN_TORCH = registerBlock("green_torch", new TorchBlock(FabricBlockSettings.copyOf(Blocks.TORCH).luminance(12).nonOpaque(),  ModParticles.GREENFIRE_PARTICLE));
    public static final Block WALL_GREEN_TORCH = registerBlock("wall_green_torch", new WallTorchBlock(FabricBlockSettings.copyOf(Blocks.WALL_TORCH).luminance(12).nonOpaque(), ModParticles.GREENFIRE_PARTICLE));
    public static final Block GREEN_CAMPFIRE = registerBlock("green_campfire", new CampfireBlock(true, 1, FabricBlockSettings.copyOf(Blocks.CAMPFIRE).luminance(13).nonOpaque()));




    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MushrooomsMod.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(MushrooomsMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void  registerModBlocks(){
        MushrooomsMod.LOGGER.info("Registering ModBlocks for " + MushrooomsMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModBlocks::addItemstoNaturalGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModBlocks::addItemstoFoodGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModBlocks::addItemstoFunctionalGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModBlocks::addItemstoToolsGroup);
    }
}
