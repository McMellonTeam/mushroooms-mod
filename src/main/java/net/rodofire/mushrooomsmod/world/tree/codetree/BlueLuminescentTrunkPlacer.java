package net.rodofire.mushrooomsmod.world.tree.codetree;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.rodofire.mushrooomsmod.world.tree.ModTrunkPlacerTypes;

import java.util.List;
import java.util.function.BiConsumer;

public class BlueLuminescentTrunkPlacer extends TrunkPlacer {
    public static final Codec<BlueLuminescentTrunkPlacer> codec = RecordCodecBuilder.create(objectInstance -> fillTrunkPlacerFields(objectInstance).apply(objectInstance, BlueLuminescentTrunkPlacer::new));

    public BlueLuminescentTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacerTypes.BLUE_LUMINESCENT_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        setToDirt(world, replacer, random, startPos.down(), config);
        int realheight = Random.create().nextBetween(firstRandomHeight, firstRandomHeight + 4);

        generateColumn(world, replacer, random, startPos, config, realheight,0);
        for (int i=0;i<=realheight;++i){
            if(Random.create().nextBetween(0,realheight/3)==0){
                generateColumn(world,replacer,random,startPos.add(Random.create().nextBetween(-1,1),0, Random.create().nextBetween(-1,1)),config,realheight,i);
            }
        }


        return ImmutableList.of(new FoliagePlacer.TreeNode(startPos.up(realheight),0,false));
    }

    private void generateColumn(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos startPos, TreeFeatureConfig config, int realheight, int start) {
        for (int i = start; i <= realheight; ++i) {
            getAndSetState(world, replacer, random, startPos.up(i), config);
        }
    }

}
