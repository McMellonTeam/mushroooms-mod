package net.louis.mushrooomsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.louis.mushrooomsmod.block.ModBlocks;
import net.louis.mushrooomsmod.block.bigmushroom.BigMushroomPlant;
import net.louis.mushrooomsmod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {


        //Blocks
        addDrop(ModBlocks.PURPLE_MUSHROOM_BLOCK);
        addDrop(ModBlocks.GREEN_MUSHROOM_BLOCK);
        addDrop(ModBlocks.BLUE_MUSHROOM_BLOCK);
        addDrop(ModBlocks.LUMINESCENT_MUSHROOM_BLOCK);
        addDrop(ModBlocks.LUMINESCENT_MUSHROOM_STEM);
        addDrop(ModBlocks.LUMINESCENT_PINK_MUSHROOM_BLOCK);
        addDrop(ModBlocks.COMPRESSED_PURPLE_MUSHROOM);

        //Hard Blocks
        addDropWithSilkTouch(ModBlocks.PURPLE_SCHROOM_DEESLATE, Blocks.DEEPSLATE);
        addDropWithSilkTouch(ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEESLATE, Blocks.DEEPSLATE);
        addDropWithSilkTouch(ModBlocks.GREEN_STONY_SCHROOM_DEPOT, Blocks.STONE);
        addDrop(ModBlocks.RHYOLITE);

        //Mushrooms
        addDrop(ModBlocks.PURPLE_MUSHROOM);
        addDrop(ModBlocks.GREEN_MUSHROOM);
        addDrop(ModBlocks.BLUE_MUSHROOM);
        addDrop(ModBlocks.LUMINESCENT_MUSHROOM);
        addDrop(ModBlocks.LUMINESCENT_PINK_MUSHROOM);
        addDrop(ModBlocks.TRANSPARENT_MUSHROOM_STEM);
        addDrop(ModBlocks.GREEN_MUSHROOM_STEM);
        addDrop(ModBlocks.MUSHROOM_FLOWERS);

        //Flowers
        addDrop(ModBlocks.MUSHROOM_FLOWERS);
        addDrop(ModBlocks.RED_LUMERIA);
        addDrop(ModBlocks.SOL_OCCIDENTIS);
        addDrop(ModBlocks.CYANUS_RUBENS);
        addDrop(ModBlocks.CYANEA);
        addDrop(ModBlocks.CYANUS_RUBENS);
        addDrop(ModBlocks.FUTIALI);
        addDrop(ModBlocks.NOCTULICA);
        addDrop(ModBlocks.TURQUOSUM_STILUS);
        addDrop(ModBlocks.SAPHIRA_FLORENS);
        addDrop(ModBlocks.PREHISTORIC_ROSE);
        addDrop(ModBlocks.YELLOW_QUINCE);
        addDrop(ModBlocks.RED_QUINCE);
        addDrop(ModBlocks.ORANGE_PERENNIAL);
        addDrop(ModBlocks.BLUE_PERENNIAL);
        addDrop(ModBlocks.PURPLE_PERENNIAL);
        addDrop(ModBlocks.LUMINESCENT_PERENNIAL);
        addDrop(ModBlocks.PINK_PERENNIAL);
        addDrop(ModBlocks.GREEN_PERENNIAL);
        addDrop(ModBlocks.YELLOW_PERENNIAL);
        addDrop(ModBlocks.TINY_LILAC);
        addDrop(ModBlocks.YELICE);
        addDrop(ModBlocks.FLAMESTHYSIA);

        //Vines
        addDrop(ModBlocks.PINK_MUSHROOM_VINES,ModItems.PINK_MUSHROOM_VINES_ITEM);
        addDrop(ModBlocks.PINK_MUSHROOM_VINES_PLANT,ModItems.PINK_MUSHROOM_VINES_ITEM);

        //Big Mushrooms
        addDrop(ModBlocks.TINY_PURPLE_MUSHROOM);
        addDrop(ModBlocks.LITTLE_PURPLE_MUSHROOM);
        addDrop(ModBlocks.MEDIUM_PURPLE_MUSHROOM);
        addDrop(ModBlocks.BIG_PURPLE_MUSHROOM);
        addDrop(ModBlocks.TINY_GREEN_MUSHROOM);
        addDrop(ModBlocks.LITTLE_GREEN_MUSHROOM);
        addDrop(ModBlocks.MEDIUM_GREEN_MUSHROOM);
        addDrop(ModBlocks.BIG_GREEN_MUSHROOM);

        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.BIG_PURPLE_MUSHROOM_PLANT).properties(StatePredicate.Builder.create().exactMatch(BigMushroomPlant.AGE, 3));
        addDrop(ModBlocks.BIG_PURPLE_MUSHROOM_PLANT, cropDrops(ModBlocks.BIG_PURPLE_MUSHROOM_PLANT, ModItems.PURPLE_MUSHROOM_POWDER, ModItems.BIG_PURPLE_MUSHROOM_SEED, builder ));

        //Potted Flowers
        addPottedPlantDrops(ModBlocks.POTTED_LUMINESCENT_MUSHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_GREEN_MUSHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_PURPLE_MUSHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_BLUE_MUSHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_LUMINESCENT_PINK_MUSHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_OCULAE);
        addPottedPlantDrops(ModBlocks.POTTED_SOL_OCCIDENTIS);
        addPottedPlantDrops(ModBlocks.POTTED_CYANUS_RUBENS);
        addPottedPlantDrops(ModBlocks.POTTED_CYANEA);
        addPottedPlantDrops(ModBlocks.POTTED_FUTIALI);
        addPottedPlantDrops(ModBlocks.POTTED_PREHISTORIC_ROSE);
        addPottedPlantDrops(ModBlocks.POTTED_PREHISTURPLE_SCHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_PREHISTO_BLUE_SCHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_PREHISTO_GREEN_SCHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_PREHISTO_PINK_SCHROOM);
        addPottedPlantDrops(ModBlocks.POTTED_ORANGE_PERENNIAL);
        addPottedPlantDrops(ModBlocks.POTTED_BLUE_PERENNIAL);
        addPottedPlantDrops(ModBlocks.POTTED_YELLOW_PERENNIAL);
        addPottedPlantDrops(ModBlocks.POTTED_PURPLE_PERENNIAL);
        addPottedPlantDrops(ModBlocks.POTTED_LUMINESCENT_PERENNIAL);
        addPottedPlantDrops(ModBlocks.POTTED_PINK_PERENNIAL);
        addPottedPlantDrops(ModBlocks.POTTED_GREEN_PERENNIAL);
        addPottedPlantDrops(ModBlocks.POTTED_RED_QUINCE);
        addPottedPlantDrops(ModBlocks.POTTED_YELLOW_QUINCE);
        addPottedPlantDrops(ModBlocks.POTTED_YELICE);
        addPottedPlantDrops(ModBlocks.POTTED_FLAMESTHYSIA);

        //Light Blocks
        addDrop(ModBlocks.RED_LANTERN);
        addDrop(ModBlocks.GREEN_LANTERN);
        addDrop(ModBlocks.GREEN_TORCH);
    }
}
