package net.rodofire.mushrooomsmod.world;

import com.mojang.serialization.Codec;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TwistingVinesFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class BlueLuminescentVinesFeature extends Feature<TwistingVinesFeatureConfig> {
    public BlueLuminescentVinesFeature(Codec<TwistingVinesFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext context) {
        BlockPos pos=context.getOrigin();
        StructureWorldAccess world = context.getWorld();
        int randomheight = Random.create().nextBetween(3,50);

        int maxheight = canGenerate(randomheight,pos,world);
        if(maxheight!=randomheight)randomheight = Random.create().nextBetween(3,maxheight);

        for (int i =0; i<=randomheight;++i){
            world.setBlockState(pos, ModBlocks.CAERULEA_VOLUBILIS.getDefaultState(), Block.NOTIFY_LISTENERS);
        }
        return true;
    }

    public static int canGenerate(int height, BlockPos pos,StructureWorldAccess world){
        for (int i=0;i<height;++i){
            pos = pos.up();
            if(world.isAir(pos.down())) continue;
            return i;
        }
        return height;
    }

}
