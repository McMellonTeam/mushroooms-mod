package net.louis.mushrooomsmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.louis.mushrooomsmod.MushrooomsMod;
import net.louis.mushrooomsmod.block.ModBlocks;
import net.louis.mushrooomsmod.entity.ModEntities;
import net.louis.mushrooomsmod.sound.ModSounds;
import net.louis.mushrooomsmod.world.biome.ModBiomes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class ModItems {
    //Blocks
    public static final Item PURPLE_MUSHROOM_POWDER = registerItem("purple_mushroom_powder", new Item(new FabricItemSettings()));

    //Flowers
    public static final Item CAERULEA_VOLUBILIS_ITEM = registerItem("caerulea_volubilis_item", new AliasedBlockItem(ModBlocks.CAERULEA_VOLUBILIS, new FabricItemSettings()));

    //Vines
    public static final Item PINK_MUSHROOM_VINES_ITEM = registerItem("pink_mushroom_vines_item", new AliasedBlockItem(ModBlocks.PINK_MUSHROOM_VINES, new FabricItemSettings()));
    //Big Mushrooms
    public static final Item BIG_PURPLE_MUSHROOM_SEED = registerItem("big_purple_mushroom_seed", new AliasedBlockItem(ModBlocks.BIG_PURPLE_MUSHROOM_PLANT, new FabricItemSettings()));
    public static final Item BIG_GREEN_MUSHROOM_SEED = registerItem("big_green_mushroom_seed", new AliasedBlockItem(ModBlocks.BIG_GREEN_MUSHROOM_PLANT, new FabricItemSettings()));

    //food
    public static final Item BAGUETTE = registerItem("baguette", new Item(new FabricItemSettings().food(ModFoodComponents.BAGUETTE)));
    public static final Item LUMINESCENT_SCHROOM_SOUP = registerItem("luminescent_schroom_soup", new SchroomSoup(new FabricItemSettings(), ModBiomes.BLUE_LUMINESCENT_SHROOM_CAVE, new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300,0)));

    //Lights
    public static final Item GREEN_TORCH = registerItem("green_torch_item", new VerticallyAttachableBlockItem(ModBlocks.GREEN_TORCH, ModBlocks.WALL_GREEN_TORCH, new Item.Settings(), Direction.DOWN));

    //Disc
    public static final Item HYMNE_FRANCAIS_MUSIC_DISC = registerItem("hymne_francais_music_disc", new MusicDiscItem(11, ModSounds.LA_MARSEILLAISE_DISC, new FabricItemSettings().maxCount(1), 80));
    public static final Item HYMNE_URSS_MUSIC_DISC = registerItem("hymne_urss_music_disc", new MusicDiscItem(10, ModSounds.HYMEN_URSS, new FabricItemSettings().maxCount(1), 210));

    //Egg
    public static final Item GROKI_SPAWN_EGG = registerItem("groki_spawn_egg", new SpawnEggItem(ModEntities.GROKI,0x765A34,0x1BC2CF,new FabricItemSettings()));
    public static final Item BOLETE_COW_SPAWN_EGG = registerItem("bolete_cow_spawn_egg", new SpawnEggItem(ModEntities.BOLETE_COW,0xBF28DD,0xF4DBF9,new FabricItemSettings()));


    public static final Item CRUSHED_DIAMOND = registerItem("crushed_diamond", new Item(new FabricItemSettings()));









    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(MushrooomsMod.MOD_ID, name), item);
    }
    public static void registerModItems(){
        MushrooomsMod.LOGGER.info("registering mod items");
    }
}
