package net.rodofire.mushrooomsmod.world;

import com.mojang.serialization.Codec;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.feature.FeatureConfig;
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
    public boolean generate(FeatureContext<TwistingVinesFeatureConfig> context) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        BlockPos.Mutable secondmutable = new BlockPos.Mutable();
        BlockPos pos = context.getOrigin();
        StructureWorldAccess world = context.getWorld();
        TwistingVinesFeatureConfig config = context.getConfig();

        int randomheight = Random.create().nextBetween(3, config.maxHeight());
        int maxheight = canGenerate(randomheight, secondmutable.set(pos), world);
        int state;

        if (maxheight <= randomheight) randomheight = Random.create().nextBetween(0, maxheight);

        mutable.set(pos);

        if (randomheight <= 4) {
            for (int i = 0; i < randomheight; ++i) {
                state = randomheight - i-1;
                world.setBlockState(mutable, ModBlocks.CAERULEA_VOLUBILIS.getDefaultState().with(BlueLuminescentVines.STAGE, state), Block.NOTIFY_LISTENERS);
                mutable.move(Direction.UP);
            }
        } else {
            for (int i = 0; i <= randomheight; ++i) {
                state = randomheight - i;
                if (state == randomheight) state = 4;
                else if (state == randomheight - 1) state = 3;
                else if (state == randomheight - 2) state = 2;
                else if (state == 0) state = 0;
                else state = 1;
                world.setBlockState(mutable, ModBlocks.CAERULEA_VOLUBILIS.getDefaultState().with(BlueLuminescentVines.STAGE, state), Block.NOTIFY_LISTENERS);
                mutable.move(Direction.UP);
            }
        }
        return true;
    }

    public static int canGenerate(int height, BlockPos.Mutable mutable, StructureWorldAccess world) {
        for (int i = 0; i < height; ++i) {
            mutable.move(Direction.UP);
            if (world.isAir(mutable.down()) || world.getBlockState(mutable.down()).isIn(BlockTags.LEAVES) || world.getBlockState(mutable.down()).isOf(ModBlocks.CAERULEA_VOLUBILIS))
                continue;
            return i;
        }
        return height;
    }

}
