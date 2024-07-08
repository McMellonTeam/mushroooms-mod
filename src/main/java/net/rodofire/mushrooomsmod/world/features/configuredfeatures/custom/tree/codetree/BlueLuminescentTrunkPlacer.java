package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModTrunkPlacerTypes;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.decorator.OakBerriesTreeDecorator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class BlueLuminescentTrunkPlacer extends TrunkPlacer {
    private int baseheight;
    private int firstRandomHeight;
    private int secondRandomHeight;

    public static final BlueLuminescentTrunkPlacer INSTANCE = new BlueLuminescentTrunkPlacer(6,6,6);
    public static final MapCodec<BlueLuminescentTrunkPlacer> CODEC = MapCodec.unit(() -> INSTANCE);

    public BlueLuminescentTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
        this.baseheight = baseHeight;
        this.firstRandomHeight = firstRandomHeight;
        this.secondRandomHeight = secondRandomHeight;
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacerTypes.BLUE_LUMINESCENT_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        int realheight = Random.create().nextBetween(firstRandomHeight, firstRandomHeight + 4);
        List<FoliagePlacer.TreeNode> list = new ArrayList<FoliagePlacer.TreeNode>();

        generateColumn(world, replacer, random, startPos, config, realheight, 0);
        for (int i = 0; i <= realheight; ++i) {
            if (Random.create().nextBetween(0, realheight / 4) == 0) {
                list.add(generateColumn(world, replacer, random, startPos.add(Random.create().nextBetween(-1, 1), 0, Random.create().nextBetween(-1, 1)), config, realheight, i));
            }
        }
        return list;
    }

    private FoliagePlacer.TreeNode generateColumn(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos startPos, TreeFeatureConfig config, int realheight, int start) {
        for (int i = start; i <= realheight; ++i) {
            getAndSetState(world, replacer, random, startPos.up(i), config);
        }
        return new FoliagePlacer.TreeNode(startPos.up(realheight), 0, false);
    }


}
