package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.decorator;

import com.mojang.serialization.MapCodec;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModDecoratorTypes;

public class OakBerriesTreeDecorator extends TreeDecorator {
    public static final OakBerriesTreeDecorator INSTANCE = new OakBerriesTreeDecorator();

    // Our constructor doesn't have any arguments, so we create a unit codec that returns the singleton instance
    public static final MapCodec<OakBerriesTreeDecorator> CODEC = MapCodec.unit(() -> INSTANCE);

    private OakBerriesTreeDecorator() {
    }

    @Override
    protected TreeDecoratorType<?> getType() {
        return ModDecoratorTypes.RICH_TREE_DECORATOR;
    }

    @Override
    public void generate(TreeDecorator.Generator generator) {
        // Iterate through block positions
        generator.getLeavesPositions().forEach(pos -> {
            Random random = generator.getRandom();
            if (random.nextInt(4) == 0) {
                generator.replace(pos, ModBlocks.OAK_BERRIES_LEAVES.getDefaultState().with(Properties.BERRIES, true));
            }
        });
    }
}