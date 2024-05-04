package net.rodofire.mushrooomsmod.world.mushrooms.structuremushrooms;

import com.mojang.serialization.Codec;
import me.emafire003.dev.structureplacerapi.StructurePlacerAPI;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.mushrooomsmod.MushrooomsMod;


public class CustomRedFertileMushroom extends Feature<DefaultFeatureConfig> {
    public CustomRedFertileMushroom(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    public boolean canGenerate(StructureWorldAccess world, Random random, BlockPos pos, int large, int height) {
        for (int i = 0; i < large; ++i) {
            for (int j = 0; j < height; ++j) {
                for (int k = 0; k < large; ++k) {
                    BlockState blockState = world.getBlockState(pos.add(k, j, k));
                    if (blockState.isAir() || blockState.isIn(BlockTags.LEAVES)) continue;
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random random = context.getRandom();
        int mushroom = getMushroom();
        int large = getLarge(mushroom);
        int height = getHeight(mushroom);
        if (!world.getBlockState(pos.add(-large/2,-1,-large/2)).isOpaqueFullCube(world, pos.down())) return false;
        if (!canGenerate(world, random, pos.add(-large / 2, 0, -large / 2), large, height)) return false;
        placeMushroom(world, random, pos.add(-large / 2, 0, -large / 2), mushroom);
        return false;
    }

    public int getLarge(int mushroom) {
        return switch (mushroom) {
            case 1, 2, 3, 4 -> 3;
            case 5, 6, 7 -> 4;
            case 8 -> 5;
            case 9, 10 -> 7;
            default -> 2;
        };
    }

    public int getHeight(int mushroom) {
        return switch (mushroom) {
            case 1 -> 3;
            case 2, 3 -> 5;
            case 4, 5 -> 7;
            case 6, 7 -> 6;
            case 8 -> 8;
            case 9 -> 9;
            default -> 11;
        };
    }

    public int getMushroom() {
        int rand = Random.create().nextBetween(0, 100);
        if (rand < 14) return 0;
        if (rand < 26) return 1;
        if (rand < 38) return 2;
        if (rand < 51) return 3;
        if (rand < 59) return 4;
        if (rand < 76) return 5;
        if (rand < 82) return 6;
        if (rand < 89) return 7;
        if (rand < 94) return 8;
        if (rand < 96) return 9;
        return 10;
    }

    public void placeMushroom(StructureWorldAccess world, Random random, BlockPos pos, int mushroom) {
        if (!world.isClient()) {
            StructurePlacerAPI structuremushroom = new StructurePlacerAPI(world, new Identifier(MushrooomsMod.MOD_ID, "red_mushroom/red_mushroom_" + mushroom), pos, getBlockRotation());
            structuremushroom.loadStructure();
        }
    }

    public BlockRotation getBlockRotation() {
        return switch (Random.create().nextBetween(0, 3)) {
            case 1 -> BlockRotation.CLOCKWISE_90;
            case 2 -> BlockRotation.COUNTERCLOCKWISE_90;
            case 3 -> BlockRotation.CLOCKWISE_180;
            default -> BlockRotation.NONE;
        };
    }
}
