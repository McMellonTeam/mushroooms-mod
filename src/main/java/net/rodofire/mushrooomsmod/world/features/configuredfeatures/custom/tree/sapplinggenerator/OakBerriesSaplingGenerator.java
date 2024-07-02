package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.sapplinggenerator;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class OakBerriesSaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return ModConfiguredFeatures.OAK_BERRIES_TREE_KEY;
    }
}
