package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree;

import net.minecraft.block.SaplingGenerator;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplings {
    public static final SaplingGenerator BLUE_LUMINESCENT_SAPLING = new SaplingGenerator("blue_luminescent_sapling", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.BLUE_LUMINESCENT_TREE_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());

    public static final SaplingGenerator OAK_BERRIES_SAPLING_GENERATOR = new SaplingGenerator("oak_berries_sapling", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.OAK_BERRIES_TREE_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());

    public static final SaplingGenerator PELTOGYNE_SAPLING_GENERATOR = new SaplingGenerator("peltogyne_sapling", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.OAK_BERRIES_TREE_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());

    public static final SaplingGenerator COLORFUL_TREE_SAPLING_GENERATOR = new SaplingGenerator("colorful_tree_sapling", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.OAK_BERRIES_TREE_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
}
