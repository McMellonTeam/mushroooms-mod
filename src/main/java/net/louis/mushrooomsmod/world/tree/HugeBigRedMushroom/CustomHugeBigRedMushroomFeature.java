package net.louis.mushrooomsmod.world.tree.HugeBigRedMushroom;

import com.mojang.serialization.Codec;
import net.louis.mushrooomsmod.feature.mushroomfeature.ModMushroomFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public abstract class CustomHugeBigRedMushroomFeature extends Feature<ModMushroomFeatureConfig> {
    public CustomHugeBigRedMushroomFeature(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }
    protected boolean canGenerate(WorldAccess world, BlockPos pos, int height,int large, BlockPos.Mutable mutablePos, ModMushroomFeatureConfig config) {
        for(int k=0;k<=height;++k){
            for(int l=-large;l<=large;++l){
                for(int m=-large;m<=large;++k){
                    BlockState blockState2 = world.getBlockState(mutablePos.set(pos, k, l, m));
                    if (blockState2.isAir() || blockState2.isIn(BlockTags.LEAVES)) continue;
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean generate(FeatureContext<ModMushroomFeatureConfig> context) {
        BlockPos.Mutable mutable;
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        Random random = context.getRandom();
        ModMushroomFeatureConfig modMushroomFeatureConfig = context.getConfig();
        int height = Random.create().nextBetween(5,9);
        int large = Random.create().nextBetween(2,5);
        if(!canGenerate(structureWorldAccess,blockPos,height,large,mutable= new BlockPos.Mutable(), modMushroomFeatureConfig)) return false;
        Integer[] coordinates = trunkPlace(blockPos,height, large,mutable,structureWorldAccess,modMushroomFeatureConfig, random);
        capPlacer(blockPos,large,height,mutable,structureWorldAccess,modMushroomFeatureConfig,coordinates);





        return true;
    }
    protected abstract Integer[] trunkPlace(BlockPos start,int height, int large, BlockPos.Mutable mutable, WorldAccess world, ModMushroomFeatureConfig config, Random random);
    protected abstract void capPlacer(BlockPos start,int large, int height, BlockPos.Mutable mutable, WorldAccess world, ModMushroomFeatureConfig config, Integer[] coordinates);
}
