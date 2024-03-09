package net.rodofire.mushrooomsmod.world.biome;

import net.minecraft.data.DataOutput;
import net.minecraft.data.server.tag.TagProvider;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.biome.Biome;

import java.util.concurrent.CompletableFuture;

public class ModBiomesTagsProvider extends TagProvider<Biome> {
    protected ModBiomesTagsProvider(DataOutput output, RegistryKey<? extends Registry<Biome>> registryRef, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(output, registryRef, registryLookupFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(ModBiomesTags.LUMINESCENT_CAVE)
                .add(ModBiomes.BLUE_LUMINESCENT_SHROOM_CAVE);

        getOrCreateTagBuilder(ModBiomesTags.COLORFUL_PLAINS)
                .add(ModBiomes.COLORFUL_PLAINS);
    }
}
