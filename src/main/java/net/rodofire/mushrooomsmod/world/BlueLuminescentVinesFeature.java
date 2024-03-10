package net.rodofire.mushrooomsmod.world;

import com.mojang.serialization.Codec;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.registry.tag.BlockTags;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TwistingVinesFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.mushrooomsmod.block.custom.BlueLuminescentVines;
import net.rodofire.mushrooomsmod.util.ModTags;

public class BlueLuminescentVinesFeature extends Feature<TwistingVinesFeatureConfig> {
    public BlueLuminescentVinesFeature(Codec<TwistingVinesFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext context) {
        BlockPos pos = context.getOrigin();
        StructureWorldAccess world = context.getWorld();

        int randomheight = Random.create().nextBetween(3, 50);
        int maxheight = canGenerate(randomheight, pos, world);
        int state;

        if (maxheight <= randomheight) randomheight = Random.create().nextBetween(0, maxheight);

        if (randomheight <= 4) {
            for (int i = 0; i < randomheight; ++i) {
                pos = pos.up();
                state = randomheight - i-1;
                world.setBlockState(pos.down(), ModBlocks.CAERULEA_VOLUBILIS.getDefaultState().with(BlueLuminescentVines.STAGE, state), Block.NOTIFY_NEIGHBORS);
            }
        } else {
            for (int i = 0; i <= randomheight; ++i) {
                pos = pos.up();
                state = randomheight - i;
                if (state == randomheight) state = 4;
                else if (state == randomheight - 1) state = 3;
                else if (state == randomheight - 2) state = 2;
                else if (state == 0) state = 0;
                else state = 1;
                world.setBlockState(pos.down(), ModBlocks.CAERULEA_VOLUBILIS.getDefaultState().with(BlueLuminescentVines.STAGE, state), Block.NOTIFY_NEIGHBORS);
            }
        }
        return true;
    }

    public static int canGenerate(int height, BlockPos pos, StructureWorldAccess world) {
        for (int i = 0; i < height; ++i) {
            pos = pos.up();
            if (world.isAir(pos.down()) || world.getBlockState(pos.down()).isIn(BlockTags.LEAVES) || world.getBlockState(pos.down()).isOf(ModBlocks.CAERULEA_VOLUBILIS))
                continue;
            return i;
        }
        return height;
    }

}
