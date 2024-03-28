package net.rodofire.mushrooomsmod.world;

import com.mojang.serialization.Codec;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.Direction;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TwistingVinesFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.mushrooomsmod.block.custom.BlueLuminescentVines;

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

        int randomheight;
        int maxheight;
        int i = config.spreadWidth();

        mutable.set(pos);
        for (int a = 0; a <= i * i; ++a) {
            mutable.set(pos).move(Random.create().nextBetween(-i, i), randomheight = Random.create().nextBetween(3, config.maxHeight()), Random.create().nextBetween(-i, i));
            secondmutable.set(mutable);
            if ((maxheight = canGenerate(randomheight, secondmutable, world)) == 0) continue;
            if (maxheight < randomheight) randomheight = Random.create().nextBetween(0, maxheight);
            generateColumn(randomheight, world, mutable);
        }


        return true;
    }

    private static void generateColumn(int randomheight, StructureWorldAccess world, BlockPos.Mutable mutable) {
        int state;
        if (randomheight <= 4) {
            for (int i = 0; i < randomheight; ++i) {
                state = randomheight - i - 1;
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
    }

    public static int canGenerate(int height, BlockPos.Mutable mutable, StructureWorldAccess world) {
        if (!canBePlaced(mutable, world)) return 0;
        for (int i = 0; i < height; ++i) {
            mutable.move(Direction.UP);
            if (world.isOutOfHeightLimit(mutable)) return i;
            if (world.isAir(mutable)) continue;
            return i;
        }
        return height;
    }

    public static boolean canBePlaced(BlockPos.Mutable mutable, StructureWorldAccess world) {
        return world.getBlockState(mutable.down()).isOf(ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEEPSLATE);
    }
}
