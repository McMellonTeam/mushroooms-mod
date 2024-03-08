package net.rodofire.mushrooomsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.util.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        //Pickaxe
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEESLATE)
                .add(ModBlocks.PURPLE_SCHROOM_DEESLATE)
                .add(ModBlocks.GREEN_STONY_SCHROOM_DEPOT)
                .add(ModBlocks.RED_LANTERN)
                .add(ModBlocks.GREEN_LANTERN)
                .add(ModBlocks.GREEN_CAMPFIRE)
                .add(ModBlocks.RHYOLITE)
                .add(ModBlocks.LAVA_BLACKSTONE_BRICKS)
                .add(ModBlocks.LAVA_BLACKSTONE)
                .add(ModBlocks.LAVA_BLACKSTONE_TINY_BRICKS)
                .add(ModBlocks.LAVA_BLACKSTONE_MEDIUM_BRICKS)
                .add(ModBlocks.PINK_CRYSTAL)
                .add(ModBlocks.PINK_CRYSTAL_BLOCK);

        //Shovel
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.COMPRESSED_PURPLE_MUSHROOM)
                .add(ModBlocks.COMPRESSED_DIRT)
                .add(ModBlocks.LIGHT_COMPRESSED_DIRT);

        //Axe
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.BLUE_MUSHROOM_BLOCK)
                .add(ModBlocks.PURPLE_MUSHROOM_BLOCK)
                .add(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK)
                .add(ModBlocks.GREEN_MUSHROOM_BLOCK)
                .add(ModBlocks.YELLOW_MUSHROOM_BLOCK)
                .add(ModBlocks.ORANGE_MUSHROOM_BLOCK)


                .add(ModBlocks.PURPLE_ALTERED_MUSHROOM_BLOCK)
                .add(ModBlocks.PURPLE_DEGRADATED_MUSHROOM_BLOCK)
                .add(ModBlocks.PURPLE_FERMENTED_MUSHROOM_BLOCK)

                .add(ModBlocks.ORANGE_MUSHROOM_BLOCK)
                .add(ModBlocks.ORANGE_ALTERED_MUSHROOM_BLOCK)
                .add(ModBlocks.ORANGE_DEGRADATED_MUSHROOM_BLOCK)
                .add(ModBlocks.ORANGE_FERMENTED_MUSHROOM_BLOCK)

                .add(ModBlocks.YELLOW_MUSHROOM_BLOCK)
                .add(ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK)
                .add(ModBlocks.YELLOW_DEGRADATED_MUSHROOM_BLOCK)
                .add(ModBlocks.YELLOW_FERMENTED_MUSHROOM_BLOCK)

                .add(ModBlocks.BLUE_MUSHROOM_BLOCK)
                .add(ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK)
                .add(ModBlocks.BLUE_DEGRADATED_MUSHROOM_BLOCK)
                .add(ModBlocks.BLUE_FERMENTED_MUSHROOM_BLOCK)

                .add(ModBlocks.GREEN_MUSHROOM_BLOCK)
                .add(ModBlocks.GREEN_ALTERED_MUSHROOM_BLOCK)
                .add(ModBlocks.GREEN_DEGRADATED_MUSHROOM_BLOCK)
                .add(ModBlocks.GREEN_FERMENTED_MUSHROOM_BLOCK)

                .add(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK)
                .add(ModBlocks.BLUE_LUMINESCENT_ALTERED_MUSHROOM_BLOCK)
                .add(ModBlocks.BLUE_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK)
                .add(ModBlocks.BLUE_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK)

                .add(ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK)
                .add(ModBlocks.PINK_LUMINESCENT_ALTERED_MUSHROOM_BLOCK)
                .add(ModBlocks.PINK_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK)
                .add(ModBlocks.PINK_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK)


                .add(ModBlocks.RED_ALTERED_MUSHROOM_BLOCK)
                .add(ModBlocks.RED_DEGRADATED_MUSHROOM_BLOCK)
                .add(ModBlocks.RED_FERMENTED_MUSHROOM_BLOCK)

                .add(ModBlocks.BROWN_ALTERED_MUSHROOM_BLOCK)
                .add(ModBlocks.BROWN_DEGRADATED_MUSHROOM_BLOCK)
                .add(ModBlocks.BROWN_FERMENTED_MUSHROOM_BLOCK)


                .add(ModBlocks.LUMINESCENT_MUSHROOM_STEM)
                .add(ModBlocks.GREEN_MUSHROOM_STEM)
                .add(ModBlocks.TRANSPARENT_MUSHROOM_STEM);

        getOrCreateTagBuilder(ModTags.Blocks.MUSHROOM_PLANT)
                .add(ModBlocks.YELLOW_MUSHROOM)
                .add(ModBlocks.PURPLE_MUSHROOM)
                .add(ModBlocks.ORANGE_MUSHROOM)
                .add(ModBlocks.BLUE_MUSHROOM)
                .add(ModBlocks.GREEN_MUSHROOM)
                .add(ModBlocks.LUMINESCENT_MUSHROOM)
                .add(ModBlocks.LUMINESCENT_PINK_MUSHROOM)
                .add(Blocks.RED_MUSHROOM)
                .add(Blocks.BROWN_MUSHROOM);

        getOrCreateTagBuilder(BlockTags.FLOWERS)
                .add(ModBlocks.YELLOW_MUSHROOM)
                .add(ModBlocks.PURPLE_MUSHROOM)
                .add(ModBlocks.ORANGE_MUSHROOM)
                .add(ModBlocks.BLUE_MUSHROOM)
                .add(ModBlocks.GREEN_MUSHROOM)
                .add(ModBlocks.LUMINESCENT_MUSHROOM)
                .add(ModBlocks.LUMINESCENT_PINK_MUSHROOM)
                .add(Blocks.RED_MUSHROOM)
                .add(Blocks.BROWN_MUSHROOM)
                .add(ModBlocks.RED_LUMERIA)
                .add(ModBlocks.RED_LUMERIA)
                .add(ModBlocks.RED_QUINCE)
                .add(ModBlocks.YELLOW_PERENNIAL)
                .add(ModBlocks.YELLOW_QUINCE)
                .add(ModBlocks.SOL_OCCIDENTIS);
    }
}
