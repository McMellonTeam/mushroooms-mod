package net.louis.mushrooomsmod.world.tree.HugeBigRedMushroom;

import com.mojang.serialization.Codec;
import net.louis.mushrooomsmod.feature.mushroomfeature.ModMushroomFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class HugeBigRedMushroomFeature extends CustomHugeBigRedMushroomFeature{
    public HugeBigRedMushroomFeature(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<ModMushroomFeatureConfig> context) {
        return false;
    }

    @Override
    protected Integer[] trunkPlace(BlockPos start, int height, int large, BlockPos.Mutable mutable, WorldAccess world, ModMushroomFeatureConfig config, Random random) {
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
        BlockState blockstate=config.stemProvider.get(random,mutable);
        for(int i=0; i<=trunkheight;++i ){
            mutable.set(start, randx, i+1, randz);
            this.setBlockState(world, mutable, blockstate);
        }

        return new Integer[]{randx,trunkheight,randz};
    }



    @Override
    protected void capPlacer(BlockPos start,int large, int height, BlockPos.Mutable mutable, WorldAccess world, ModMushroomFeatureConfig config, Integer[] coordinates) {

    }
}
