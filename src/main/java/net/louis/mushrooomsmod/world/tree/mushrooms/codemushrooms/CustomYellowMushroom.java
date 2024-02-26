package net.louis.mushrooomsmod.world.tree.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.louis.mushrooomsmod.block.ModBlocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.ArrayList;

public abstract class CustomYellowMushroom extends Feature<HugeMushroomFeatureConfig> {

    public CustomYellowMushroom(Codec<HugeMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    protected boolean canGenerate(WorldAccess world, BlockPos pos, int height, int large, BlockPos.Mutable mutablePos, HugeMushroomFeatureConfig config,int randomx,int randomz,double phi,double theta, float multiplier) {
        for(int i =-large+randomx;i<=large+randomx;++i){
            for(int j = -large+randomz;j<=large+randomz;++j){
                for(int k = height-large+4;k<=large+height;k++) {
                    mutablePos.set(pos, (int)multiplier*i, k, (int)multiplier*j);
                    if (!world.getBlockState(mutablePos).isIn(BlockTags.LEAVES) && !world.getBlockState(mutablePos).isAir()&&!world.getBlockState(mutablePos).isIn(BlockTags.FLOWERS))
                        return false;
                }
            }
        }
        for (int i = 0; i <= height; i++){
            for(int j=-1;j<=1;++j){
                for(int k=-1;k<=1;++k){
                    mutablePos.set(pos, j+(randomx/height)*i, i, k + (randomz/height)*i);
                    if (!world.getBlockState(mutablePos).isIn(BlockTags.LEAVES) && !world.getBlockState(mutablePos).isAir() && !world.getBlockState(mutablePos).isIn(BlockTags.FLOWERS))
                        return false;
                }
            }
        }
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
        boolean flatcap=false;
        float multiplier = 1.5f;

        Integer[] coordinates;

        int large;
        int height;

        if(Random.create().nextInt(3)==0){
            flatcap=true;
            multiplier = 2;
        }



        if (world.getBlockState(blockPos.east()).isOf(ModBlocks.YELLOW_MUSHROOM) || world.getBlockState(blockPos.north()).isOf(ModBlocks.YELLOW_MUSHROOM) || world.getBlockState(blockPos.south()).isOf(ModBlocks.YELLOW_MUSHROOM) || world.getBlockState(blockPos.west()).isOf(ModBlocks.YELLOW_MUSHROOM)) {
             height = Random.create().nextBetween(10, 20);
             large = Random.create().nextBetween(4,8);

            ArrayList<Double> direction = this.direction(world,random,blockPos,height,mutable,hugeMushroomFeatureConfig);
            double randomx = (direction.get(0));
            double randomz = direction.get(1);
            double phi = direction.get(2);
            double theta = direction.get(3);


            if (!this.canGenerate(world, blockPos, height, large, mutable,hugeMushroomFeatureConfig,(int) randomx,(int) randomz, phi, theta,multiplier)) {
                return false;
            }

            coordinates = this.generateHugeTrunk(world,random,blockPos,mutable,height,hugeMushroomFeatureConfig, (int) randomx,(int) randomz, phi, theta);
        }else{
            height = Random.create().nextBetween(5, 11);
            large = Random.create().nextBetween(2,4);

            ArrayList<Double> direction = this.direction(world,random,blockPos,height,mutable,hugeMushroomFeatureConfig);
            double randomx = (direction.get(0));
            double randomz = direction.get(1);
            double phi = direction.get(2);
            double theta = direction.get(3);

            if (!this.canGenerate(world, blockPos, height, large, mutable,hugeMushroomFeatureConfig,(int) randomx,(int) randomz, phi, theta,multiplier )) {
                return false;
            }

            coordinates = this.generateTrunk(world,random,blockPos,mutable,height,hugeMushroomFeatureConfig, (int) randomx,(int) randomz, phi, theta);
        }

        if(flatcap){
            return this.generateFlatterCap(world, random, blockPos,height,mutable , hugeMushroomFeatureConfig, large, coordinates );
        }
        return this.generateCap(world, random, blockPos,height,mutable , hugeMushroomFeatureConfig, large, coordinates );
    }

    protected abstract Integer[] generateHugeTrunk(WorldAccess world, Random random, BlockPos pos, BlockPos.Mutable mutable, int height, HugeMushroomFeatureConfig config, int randomx,int randomz,double phi,double theta);
    protected abstract Integer[] generateTrunk(WorldAccess world, Random random, BlockPos pos, BlockPos.Mutable mutable, int height, HugeMushroomFeatureConfig config, int randomx,int randomz,double phi,double theta);
    protected abstract boolean generateCap(WorldAccess var1, Random var2, BlockPos var3, int var4, BlockPos.Mutable var5, HugeMushroomFeatureConfig var6, int large, Integer[] coordinates);
    protected abstract boolean generateFlatterCap(WorldAccess var1, Random var2, BlockPos var3, int var4, BlockPos.Mutable var5, HugeMushroomFeatureConfig var6, int large, Integer[] coordinates);

    protected abstract ArrayList<Double> direction (WorldAccess world, Random random, BlockPos pos, int height, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config);

}
