package net.louis.mushrooomsmod.world.tree.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

public abstract class CustomOrangeMushroom extends Feature<HugeMushroomFeatureConfig> {

    public CustomOrangeMushroom(Codec<HugeMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    protected boolean canGenerate(WorldAccess world, BlockPos pos, int height, int large, BlockPos.Mutable mutablePos, HugeMushroomFeatureConfig config) {
        return true;
    }

    @Override
    public boolean generate(FeatureContext<HugeMushroomFeatureConfig> context) {
        BlockPos.Mutable mutable;
        BlockPos blockPos = context.getOrigin();
        WorldAccess world = context.getWorld();
        Random random = context.getRandom();
        HugeMushroomFeatureConfig hugeMushroomFeatureConfig = context.getConfig();
        mutable = new BlockPos.Mutable();
        int height = Random.create().nextBetween(12,21);

        if (!this.canGenerate(world, blockPos, 10, 10, mutable,hugeMushroomFeatureConfig)) {
            return false;
        }
        int large = Random.create().nextBetween(4,8);
        this.generateTrunk(world,random,blockPos,mutable,height,hugeMushroomFeatureConfig);
        this.generateCap(world, random, blockPos,height,mutable , hugeMushroomFeatureConfig, large );
        return true;
    }

    protected abstract void generateTrunk(WorldAccess world, Random random, BlockPos pos, BlockPos.Mutable mutable, int height, HugeMushroomFeatureConfig config);
    protected abstract void generateCap(WorldAccess var1, Random var2, BlockPos var3, int var4, BlockPos.Mutable var5, HugeMushroomFeatureConfig var6, int large);

}
