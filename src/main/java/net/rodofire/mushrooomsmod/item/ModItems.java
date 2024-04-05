package net.rodofire.mushrooomsmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.entity.ModEntities;
import net.rodofire.mushrooomsmod.item.Custom.HammerItem;
import net.rodofire.mushrooomsmod.item.Custom.SchroomSoup;
import net.rodofire.mushrooomsmod.sound.ModSounds;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldBiomes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class ModItems {
    public static final ItemGroup MUSHROOM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MushrooomsMod.MOD_ID, "luminescent_mushroom"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.mushroooms"))
                    .icon(() -> new ItemStack(ModBlocks.BLUE_LUMINESCENT_MUSHROOM)).entries((displayContext, entries) -> {
                        //Blocks
                        //Natural
                        //Mushroom Related
                        entries.add(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_ALTERED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK);

                        entries.add(ModBlocks.BLUE_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.BLUE_DEGRADATED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.BLUE_FERMENTED_MUSHROOM_BLOCK);

                        entries.add(ModBlocks.PURPLE_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.PURPLE_ALTERED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.PURPLE_DEGRADATED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.PURPLE_FERMENTED_MUSHROOM_BLOCK);

                        entries.add(ModBlocks.GREEN_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.GREEN_ALTERED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.GREEN_DEGRADATED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.GREEN_FERMENTED_MUSHROOM_BLOCK);

                        entries.add(ModBlocks.YELLOW_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.YELLOW_DEGRADATED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.YELLOW_FERMENTED_MUSHROOM_BLOCK);

                        entries.add(ModBlocks.ORANGE_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.ORANGE_ALTERED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.ORANGE_DEGRADATED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.ORANGE_FERMENTED_MUSHROOM_BLOCK);

                        entries.add(Blocks.RED_MUSHROOM_BLOCK);
                        /*entries.add(ModBlocks.RED_ALTERED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.RED_DEGRADATED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.RED_FERMENTED_MUSHROOM_BLOCK);*/

                        entries.add(ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK);
                        /*entries.add(ModBlocks.PINK_LUMINESCENT_ALTERED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.PINK_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.PINK_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK);*/

                        entries.add(Blocks.BROWN_MUSHROOM_BLOCK);
                        /*entries.add(ModBlocks.BROWN_ALTERED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.BROWN_DEGRADATED_MUSHROOM_BLOCK);
                        entries.add(ModBlocks.BROWN_FERMENTED_MUSHROOM_BLOCK);*/

                        entries.add(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_STEM);
                        entries.add(ModBlocks.TRANSPARENT_MUSHROOM_STEM);
                        entries.add(ModBlocks.GREEN_MUSHROOM_STEM);
                        entries.add(ModBlocks.COMPRESSED_PURPLE_MUSHROOM);

                        //Soft Blocks
                        entries.add(ModBlocks.COMPRESSED_DIRT);
                        entries.add(ModBlocks.LIGHT_COMPRESSED_DIRT);

                        //Hard Blocks
                        entries.add(ModBlocks.PURPLE_SCHROOM_DEESLATE);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEEPSLATE);
                        entries.add(ModBlocks.GREEN_STONY_SCHROOM_DEPOT);
                        entries.add(ModBlocks.RHYOLITE);

                        //Plants
                        //Mushrooms
                        entries.add(ModBlocks.GREEN_MUSHROOM);
                        entries.add(ModBlocks.BLUE_MUSHROOM);
                        entries.add(ModBlocks.PURPLE_MUSHROOM);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_MUSHROOM);
                        entries.add(ModBlocks.LUMINESCENT_PINK_MUSHROOM);
                        entries.add(ModBlocks.ORANGE_MUSHROOM);
                        entries.add(ModBlocks.YELLOW_MUSHROOM);

                        //Flowers Mushrooms
                        entries.add(ModBlocks.STERILE_BLUE_MUSHROOM);
                        entries.add(ModBlocks.MUSHROOM_SMALL_BROWN);
                        entries.add(ModBlocks.MUSHROOM_SMALL_RED);

                        //Flowers
                        entries.add(ModBlocks.PREHISTO_PINK_SCHROOM);
                        entries.add(ModBlocks.PREHISTO_BLUE_SCHROOM);
                        entries.add(ModBlocks.PREHISTURPLE_SCHROOM);
                        entries.add(ModBlocks.PREHISTO_GREEN_SCHROOM);
                        entries.add(ModBlocks.MUSHROOM_FLOWERS);
                        entries.add(ModBlocks.RED_LUMERIA);
                        entries.add(ModBlocks.SOL_OCCIDENTIS);
                        entries.add(ModBlocks.CYANUS_RUBENS);
                        entries.add(ModBlocks.CYANEA);
                        entries.add(ModBlocks.FUTIALI);
                        entries.add(ModBlocks.NOCTULICA);
                        entries.add(ModBlocks.TURQUOSUM_STILUS);
                        entries.add(ModBlocks.SAPHIRA_FLORENS);
                        entries.add(ModBlocks.PREHISTORIC_ROSE);
                        entries.add(ModBlocks.ORANGE_PERENNIAL);
                        entries.add(ModBlocks.BLUE_PERENNIAL);
                        entries.add(ModBlocks.GREEN_PERENNIAL);
                        entries.add(ModBlocks.PINK_PERENNIAL);
                        entries.add(ModBlocks.LUMINESCENT_PERENNIAL);
                        entries.add(ModBlocks.PURPLE_PERENNIAL);
                        entries.add(ModBlocks.YELLOW_PERENNIAL);
                        entries.add(ModBlocks.YELLOW_QUINCE);
                        entries.add(ModBlocks.RED_QUINCE);
                        entries.add(ModBlocks.TINY_LILAC);
                        entries.add(ModBlocks.OCULAE);
                        entries.add(ModBlocks.YELICE);
                        entries.add(ModBlocks.FLAMESTHYSIA);
                        entries.add(ModBlocks.APAGANTHE);
                        entries.add(ModBlocks.PINK_HEATER);
                        entries.add(ModBlocks.WYSTERIA);
                        entries.add(ModBlocks.BLUEBELL);
                        entries.add(ModBlocks.VIPERIN);
                        entries.add(ModBlocks.HIBISCUS);
                        entries.add(ModBlocks.PLATUM);
                        entries.add(ModBlocks.DIANTHUS);
                        entries.add(ModBlocks.CYCAS);
                        entries.add(ModBlocks.ARUM);
                        entries.add(ModBlocks.HYDRANGEA);
                        entries.add(ModBlocks.ANEMONE);
                        entries.add(ModBlocks.JACYNTHE);
                        entries.add(ModBlocks.ACONIT);
                        entries.add(ModBlocks.PERVENCHE);

                        //Grass
                        entries.add(ModBlocks.TINY_GRASS);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_GRASS);
                        entries.add(ModBlocks.BLUE_LUMINESCENT_TALL_GRASS);

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


                        //Light Blocks
                        entries.add(ModBlocks.GREEN_LANTERN);
                        entries.add(ModBlocks.RED_LANTERN);
                        entries.add(ModItems.GREEN_TORCH);
                        entries.add(ModBlocks.GREEN_CAMPFIRE);

                        //Building Blocks
                        entries.add(ModBlocks.LAVA_BLACKSTONE);
                        entries.add(ModBlocks.LAVA_BLACKSTONE_BRICKS);
                        entries.add(ModBlocks.LAVA_BLACKSTONE_MEDIUM_BRICKS);
                        entries.add(ModBlocks.LAVA_BLACKSTONE_TINY_BRICKS);

                        //Music Disk
                        entries.add(ModItems.HYMNE_FRANCAIS_MUSIC_DISC);
                        entries.add(ModItems.HYMNE_URSS_MUSIC_DISC);

                        entries.add(ModItems.GROKI_SPAWN_EGG);
                        entries.add(ModItems.BOLETE_COW_SPAWN_EGG);

                        //crystal
                        entries.add(ModItems.PINK_CRYSTAL_ITEM);
                        entries.add(ModBlocks.PINK_CRYSTAL_BLOCK);

                        entries.add(ModItems.CRUSHED_DIAMOND);

                        //Utils
                        entries.add(ModBlocks.FORGE_BLOCK);

                        //Tools
                        entries.add(ModItems.IRON_HAMMER);

                        //Food
                        entries.add(ModItems.BAGUETTE);
                        entries.add(ModItems.LUMINESCENT_SCHROOM_SOUP);


                    }).build());

    //Blocks
    public static final Item PURPLE_MUSHROOM_POWDER = registerItem("mushroom_powder_purple", new Item(new FabricItemSettings()));

    //Flowers
    public static final Item CAERULEA_VOLUBILIS_ITEM = registerItem("caerulea_volubilis_item", new AliasedBlockItem(ModBlocks.CAERULEA_VOLUBILIS, new FabricItemSettings()));

    //Vines
    public static final Item PINK_MUSHROOM_VINES_ITEM = registerItem("mushroom_vines_pink_item", new AliasedBlockItem(ModBlocks.PINK_MUSHROOM_VINES, new FabricItemSettings()));
    //Big Mushrooms
    public static final Item BIG_PURPLE_MUSHROOM_SEED = registerItem("mushroom_big_purple_seed", new AliasedBlockItem(ModBlocks.BIG_PURPLE_MUSHROOM_PLANT, new FabricItemSettings()));
    public static final Item BIG_GREEN_MUSHROOM_SEED = registerItem("mushroom_big_green_seed", new AliasedBlockItem(ModBlocks.BIG_GREEN_MUSHROOM_PLANT, new FabricItemSettings()));

    //food
    public static final Item BAGUETTE = registerItem("baguette", new Item(new FabricItemSettings().food(ModFoodComponents.BAGUETTE)));
    public static final Item LUMINESCENT_SCHROOM_SOUP = registerItem("luminescent_schroom_soup", new SchroomSoup(new FabricItemSettings().food(ModFoodComponents.BLUE_LUMINESCENT_SCHROOM_SOUP), ModOverworldBiomes.BLUE_LUMINESCENT_SHROOM_CAVE, new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300, 0)));

    //Lights
    public static final Item GREEN_TORCH = registerItem("torch_green_item", new VerticallyAttachableBlockItem(ModBlocks.GREEN_TORCH, ModBlocks.WALL_GREEN_TORCH, new Item.Settings(), Direction.DOWN));

    //Disc
    public static final Item HYMNE_FRANCAIS_MUSIC_DISC = registerItem("hymne_francais_music_disc", new MusicDiscItem(11, ModSounds.LA_MARSEILLAISE_DISC, new FabricItemSettings().maxCount(1), 80));
    public static final Item HYMNE_URSS_MUSIC_DISC = registerItem("hymne_urss_music_disc", new MusicDiscItem(10, ModSounds.HYMEN_URSS, new FabricItemSettings().maxCount(1), 210));

    //Egg
    public static final Item GROKI_SPAWN_EGG = registerItem("groki_spawn_egg", new SpawnEggItem(ModEntities.GROKI, 0x765A34, 0x1BC2CF, new FabricItemSettings()));
    public static final Item BOLETE_COW_SPAWN_EGG = registerItem("bolete_cow_spawn_egg", new SpawnEggItem(ModEntities.BOLETE_COW, 0xBF28DD, 0xF4DBF9, new FabricItemSettings()));


    public static final Item CRUSHED_DIAMOND = registerItem("crushed_diamond", new Item(new FabricItemSettings()));
    public static final Item PINK_CRYSTAL_ITEM = registerItem("crystal_pink_item", new AliasedBlockItem(ModBlocks.PINK_CRYSTAL, new FabricItemSettings()));

    //Tools
    public static final Item IRON_HAMMER = registerItem("iron_hammer", new HammerItem(ToolMaterials.IRON, 40,-3.7f,4,new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MushrooomsMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MushrooomsMod.LOGGER.info("registering mod items");
    }
}
