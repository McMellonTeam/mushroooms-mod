package net.rodofire.mushrooomsmod.world.tree.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.rodofire.mushrooomsmod.feature.mushroomfeature.ModMushroomFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;


public class CustomGreenMushroomFeature extends CustomGreenMushroom {
    public CustomGreenMushroomFeature(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    protected void trunkPlace(BlockPos start, BlockPos.Mutable mutable, WorldAccess world, ModMushroomFeatureConfig config, int height, Random random) {
        BlockState blockState = config.stemProvider.get(random,start);
        for (int i =0;i<=height;++i){
            mutable.set(start, 0,i,0);
            this.setBlockState(world,mutable,blockState);
        }
    }

    @Override
    protected void capPlacer(BlockPos start, BlockPos.Mutable mutable, WorldAccess world, ModMushroomFeatureConfig config,  int large, int height, Random random, boolean bigcap) {
        BlockState blockState = config.capProvider.get(random,start);
        placecaps(start,mutable,world,large,height,blockState);

        if(bigcap) {
            placecaps(start, mutable, world, 0.7 * large, height + 1, blockState);
            placecaps(start, mutable, world, 0.7 * large, height - 1, blockState);
        }
    }

    protected void placecaps(BlockPos start, BlockPos.Mutable mutable, WorldAccess world,  double large, int height, BlockState blockState){
        //generate circle
        for(double intermediatelarge = 0; intermediatelarge<=large;intermediatelarge=intermediatelarge+0.25) {
            for (double i = -Math.PI; i <= Math.PI; i = i + Math.PI / (3 * intermediatelarge)) {
                double x = intermediatelarge * Math.cos(i);
                double z = intermediatelarge * Math.sin(i);
                mutable.set(start, (int) x, height, (int) z);
                this.setBlockState(world, mutable, blockState);
            }
        }
    }


}
