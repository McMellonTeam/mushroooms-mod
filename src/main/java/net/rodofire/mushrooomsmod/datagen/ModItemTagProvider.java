package net.rodofire.mushrooomsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.rodofire.mushrooomsmod.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {


    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Items.DIAMOND_ITEMS)
                .add(Items.DIAMOND_AXE)
                .add(Items.DIAMOND_SHOVEL)
                .add(Items.DIAMOND_SWORD)
                .add(Items.DIAMOND_BOOTS)
                .add(Items.DIAMOND_CHESTPLATE)
                .add(Items.DIAMOND_HELMET)
                .add(Items.DIAMOND_HOE)
                .add(Items.DIAMOND_LEGGINGS)
                .add(Items.DIAMOND_HELMET)
                .add(Items.DIAMOND_HORSE_ARMOR)
                .add(Items.DIAMOND_PICKAXE);

    }
}
