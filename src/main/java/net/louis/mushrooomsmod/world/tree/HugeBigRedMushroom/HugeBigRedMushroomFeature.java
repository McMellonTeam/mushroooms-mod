package net.louis.mushrooomsmod.world.tree.HugeBigRedMushroom;

import com.mojang.serialization.Codec;
import net.louis.mushrooomsmod.feature.mushroomfeature.ModMushroomFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class HugeBigRedMushroomFeature extends CustomHugeBigRedMushroomFeature{
    public HugeBigRedMushroomFeature(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }



    @Override
    protected Integer[] trunkPlace(BlockPos start, int height, int large, BlockPos.Mutable mutable, WorldAccess world, ModMushroomFeatureConfig config, Random random) {
        System.out.println("trunk");
        int trunkheight= Random.create().nextBetween(2,5);
        int randx=0;
        int randz=0;
        if(trunkheight>2){
            randx = Random.create().nextBetween(-1,1);
            randz = Random.create().nextBetween(-1,1);
            while (randx==0&&randz==0){
                randx = Random.create().nextBetween(-1,1);
                randz = Random.create().nextBetween(-1,1);
            }
        }
        if(!canGenerate(height,large,new Integer[]{randx,randz,trunkheight-2},world,start,mutable))return new Integer[]{0};
        BlockState blockstate=config.stemProvider.get(random,mutable);
        for (int j=0;j<2;++j){
            mutable.set(start,0,j,0);
            this.setBlockState(world,mutable,blockstate);
        }
        for(int i=2; i<=trunkheight;++i ){
            mutable.set(start, randx, i, randz);
            this.setBlockState(world, mutable, blockstate);
        }

        return new Integer[]{randx,trunkheight,randz};
    }



    @Override
    protected boolean capPlacer(BlockPos start,int large, int height, BlockPos.Mutable mutable, WorldAccess world, ModMushroomFeatureConfig config, Integer[] coordinates,Random random) {
        System.out.println("cap");
        if (coordinates.length==1)return false;
        int randx = coordinates[0];
        int height1 = coordinates[1];
        int randz = coordinates[2];
        for (int i=0;i<height;i++){
            for (int j=-large;j<=large;++j){
                for(int k=-large;k<=large;++k){
                    mutable.set(start, j+randx, i+1+height1, k+randz);
                    BlockState blockstate1 = config.capProvider.get(random,mutable);
                    BlockState blockState2 = config.secondcapProvider.get(random,mutable);
                    int random1 = Random.create().nextBetween(0,10);
                    if (random1==0){
                        this.setBlockState(world,mutable,blockState2);
                    }else {
                        this.setBlockState(world,mutable,blockstate1);
                    }
                }
            }
        }
        return true;
    }
    protected boolean canGenerate(int height,int large, Integer[] coordinates, WorldAccess world, BlockPos pos,BlockPos.Mutable mutable){
        int randx = coordinates[0];
        int randz = coordinates[1];
        int height1 = coordinates[2];

        for (int i=0;i<2;++i){
            BlockState blockState2 = world.getBlockState(pos);
            pos=pos.up();
            if (blockState2.isAir() || blockState2.isIn(BlockTags.LEAVES)) continue;
            return false;
        }
        for(int i=0;i<height1;++i){
            mutable.set(pos,randx, i+2,randz);
            BlockState blockState2 = world.getBlockState(pos);
            if (blockState2.isAir() || blockState2.isIn(BlockTags.LEAVES)) continue;
            return false;
        }
        for (int i=0;i<height;++i){
            for (int j=-large;j<=large;++j){
                for (int k=-large;k<=large;++k){
                    mutable.set(pos,j,i+height1+3,k);
                    BlockState blockState2 = world.getBlockState(pos);
                    if (blockState2.isAir() || blockState2.isIn(BlockTags.LEAVES)) continue;
                    return false;
                }
            }
        }
        return true;
    }
}
