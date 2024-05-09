package net.rodofire.mushrooomsmod.world.mushrooms.structuremushrooms;

import com.mojang.serialization.Codec;
import me.emafire003.dev.structureplacerapi.StructurePlacerAPI;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.world.features.config.ModMushroomFeatureConfig;

public class CustomRedHugeMushroomFeature extends CustomRedHugeMushroom {
    public CustomRedHugeMushroomFeature(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }


    @Override
    protected Integer[] trunkPlace(BlockPos start, int large, BlockPos.Mutable mutable, WorldAccess world, ModMushroomFeatureConfig config, Random random) {
        int trunkheight = Random.create().nextBetween(2, 5);
        int randx = 0;
        int randz = 0;

        BlockState blockstate = config.stemProvider.get(random, mutable);

        if (trunkheight > 2) {
            randx = Random.create().nextBetween(-1, 1);
            randz = Random.create().nextBetween(-1, 1);
            while (randx == 0 && randz == 0) {
                randx = Random.create().nextBetween(-1, 1);
                randz = Random.create().nextBetween(-1, 1);
            }
        }

        if (!canGenerate(large, new Integer[]{randx, randz, trunkheight - 2}, world, start, mutable))
            return new Integer[]{0};

        for (int j = 0; j < 2; ++j) {
            mutable.set(start, 0, j, 0);
            this.setBlockState(world, mutable, blockstate);
        }
        for (int i = 2; i <= trunkheight; ++i) {
            mutable.set(start, randx, i, randz);
            this.setBlockState(world, mutable, blockstate);
        }

        return new Integer[]{randx, trunkheight, randz};
    }


    @Override
    protected boolean capPlacer(BlockPos start, int large, BlockPos.Mutable mutable, WorldAccess world, ModMushroomFeatureConfig config, Integer[] coordinates, Random random) {
        int large1;
        int randx = coordinates[0];
        int height1 = coordinates[1];
        int randz = coordinates[2];
        int rotation = Random.create().nextInt(4);
        int randomcapnumber = Random.create().nextInt(3) + 1;

        String path = "red_cap/red_cap_" + large + "_" + randomcapnumber;
        BlockRotation blockRotation;

        start = start.add(randx, height1 + 1, randz);

        switch (rotation) {
            case 0:
                blockRotation = BlockRotation.NONE;
                large = -large;
                large1 = large;
                break;
            case 1:
                blockRotation = BlockRotation.CLOCKWISE_90;
                large1 = -large;
                break;
            case 2:
                blockRotation = BlockRotation.CLOCKWISE_180;
                large1 = large;
                break;
            default:
                blockRotation = BlockRotation.COUNTERCLOCKWISE_90;
                large1 = large;
                large = -large;
                break;
        }
        if (!world.isClient()) {
            StructurePlacerAPI structure = new StructurePlacerAPI((ServerWorld) world, new Identifier(MushrooomsMod.MOD_ID, path), start, BlockMirror.NONE, blockRotation, true, 1f, new BlockPos(large, 0, large1));
            structure.loadStructure();
        }
        return true;
    }

    protected boolean canGenerate(int large, Integer[] coordinates, WorldAccess world, BlockPos pos, BlockPos.Mutable mutable) {
        int randx = coordinates[0];
        int randz = coordinates[1];
        int height1 = coordinates[2];
        int height;

        if (large == 1) height = 7;
        else if (large == 2) height = 9;
        else height = 15;

        for (int i = 0; i < 2; ++i) {
            BlockState blockState2 = world.getBlockState(pos);
            pos = pos.up();
            if (blockState2.isAir() || blockState2.isIn(BlockTags.LEAVES)) continue;
            return false;
        }

        for (int i = 0; i < height1; ++i) {
            mutable.set(pos, randx, i + 2, randz);
            BlockState blockState2 = world.getBlockState(pos);
            if (blockState2.isAir() || blockState2.isIn(BlockTags.LEAVES)) continue;
            return false;
        }

        for (int i = 0; i < height; ++i) {
            for (int j = -large; j <= large; ++j) {
                for (int k = -large; k <= large; ++k) {
                    mutable.set(pos, j, i + height1, k);
                    BlockState blockState2 = world.getBlockState(mutable);
                    if (blockState2.isAir() || blockState2.isIn(BlockTags.LEAVES)) continue;
                    return false;
                }
            }
        }
        return true;
    }


}
