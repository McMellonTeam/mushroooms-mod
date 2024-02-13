package net.louis.mushrooomsmod.world.tree.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.ArrayList;

public abstract class CustomGreenMushroom extends Feature<HugeMushroomFeatureConfig> {


    public CustomGreenMushroom(Codec<HugeMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    protected boolean canGenerate(WorldAccess world, BlockPos pos, int height, int large, BlockPos.Mutable mutablePos, HugeMushroomFeatureConfig config) {
        return true;
    }

    @Override
    public boolean generate(FeatureContext<HugeMushroomFeatureConfig> context) {
        BlockPos.Mutable mutable;
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        Random random = context.getRandom();
        HugeMushroomFeatureConfig hugeMushroomFeatureConfig = context.getConfig();

        int large = Random.create().nextBetween(1,5);
        int height = Random.create().nextBetween(5,12);


        if (!this.canGenerate(structureWorldAccess, blockPos,height, large, mutable = new BlockPos.Mutable(), hugeMushroomFeatureConfig)) {
            return false;
        }

        Integer[] coordinates = generateTrunk(structureWorldAccess,random,blockPos,mutable,height,hugeMushroomFeatureConfig);
        this.generateFirstCap(structureWorldAccess,random,blockPos,height,coordinates,mutable,hugeMushroomFeatureConfig,large);


        return true;
    }
    protected abstract Integer[] generateTrunk(WorldAccess world, Random random, BlockPos pos, BlockPos.Mutable mutable, int height, HugeMushroomFeatureConfig config);
    protected abstract void generateFirstCap(WorldAccess var1, Random var2, BlockPos var3, int var4,Integer[] coordinates, BlockPos.Mutable var5, HugeMushroomFeatureConfig var6, int large);
}
