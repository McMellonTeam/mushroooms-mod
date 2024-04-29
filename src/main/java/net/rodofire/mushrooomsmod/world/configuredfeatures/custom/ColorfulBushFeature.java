package net.rodofire.mushrooomsmod.world.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import me.emafire003.dev.structureplacerapi.StructurePlacerAPI;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.ModBlocks;

public class ColorfulBushFeature extends Feature<DefaultFeatureConfig> {
    public ColorfulBushFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    public boolean canGenerate(World world, BlockPos pos, int large, int height) {
        for (int i = 0; i < large; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < large; k++) {
                    BlockState blockState = world.getBlockState(pos.add(i, j, k));
                    if (j==0 && world.getBlockState(pos.add(i,0,k))==Blocks.WATER.getDefaultState()) return false;
                    if (blockState.isAir() || blockState.isOf(Blocks.GRASS) || blockState.isOf(Blocks.TALL_GRASS))
                        continue;
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        World world = (World)context.getWorld();
        if (world.isClient()) return false;
        BlockPos pos = context.getOrigin();
        int capnumber = Random.create().nextBetween(1, 4);
        if (!canGenerate(world, pos, 3, 2)) return false;
        StructurePlacerAPI bush = new StructurePlacerAPI((ServerWorld) world, new Identifier(MushrooomsMod.MOD_ID, "bush_" + capnumber), pos);
        bush.loadStructure();
        BlockState blockState = getLeaveBlock().getDefaultState().with(LeavesBlock.PERSISTENT, true);
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 5; k++) {
                    if (world.getBlockState(pos.add(i, j, k)).isOf(Blocks.BEDROCK))
                        world.setBlockState(pos.add(i, j, k), blockState, 1);
                    int a =1;
                    while (world.getBlockState(pos.down(a)).isAir()){
                        world.setBlockState(pos.add(i, j-a, k), blockState, 1);
                        ++a;
                    }
                }
            }
        }
        return true;
    }

    public Block getLeaveBlock() {
        int random = Random.create().nextBetween(0, 6);
        return switch (random) {
            case 0 -> ModBlocks.BLUE_COLORFUL_LEAVES;
            case 1 -> ModBlocks.RED_COLORFUL_LEAVES;
            case 2 -> ModBlocks.YELLOW_COLORFUL_LEAVES;
            case 3 -> ModBlocks.GREEN_COLORFUL_LEAVES;
            case 4 -> ModBlocks.ORANGE_COLORFUL_LEAVES;
            case 5 -> ModBlocks.PURPLE_COLORFUL_LEAVES;
            default -> ModBlocks.PINK_COLORFUL_LEAVES;
        };
    }
}
