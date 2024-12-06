package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.structuremushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.structure.NbtPlacer;
import net.rodofire.mushrooomsmod.MushrooomsMod;


public class CustomRedFertileMushroom extends Feature<DefaultFeatureConfig> {
    public CustomRedFertileMushroom(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    public boolean canGenerate(StructureWorldAccess world, BlockPos pos, int large, int height, BlockRotation rotation) {
        int a = 0;
        int b = 0;
        if (rotation == BlockRotation.NONE || rotation == BlockRotation.CLOCKWISE_90) b = -large;
        if (rotation == BlockRotation.COUNTERCLOCKWISE_90 || rotation == BlockRotation.CLOCKWISE_180) a = -large;
        for (int i = a; i <= large + a; ++i) {
            for (int j = 1; j < height; ++j) {
                for (int k = b; k <= large + b; ++k) {
                    BlockState blockState = world.getBlockState(pos.add(i, j, k));
                    if (blockState.isAir() || blockState.isIn(BlockTags.LEAVES) || blockState.isIn(BlockTags.FLOWERS))
                        continue;
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
        int mushroom = getMushroom();
        int large = getLarge(mushroom);
        int height = getHeight(mushroom);
        BlockRotation rotation = getBlockRotation();
        Vec3i offset = getOffset(mushroom, rotation);
        if (!world.getBlockState(pos.down()).isOpaqueFullCube(world, pos.down())) {
            return false;
        }
        if (!canGenerate(world, pos.add(offset), large, height, rotation)) return false;
        placeMushroom(world, pos.add(offset), mushroom, rotation);
        return true;
    }

    //return the large of the structure
    public int getLarge(int mushroom) {
        return switch (mushroom) {
            case 1, 2, 3, 4 -> 3;
            case 5, 6, 7 -> 4;
            case 8 -> 5;
            case 9, 10 -> 7;
            case 11, 12 -> 11;
            case 13 -> 6;
            default -> 2;
        };
    }

    //return offset due to random rotation
    public Vec3i getOffset(int mushroom, BlockRotation rotation) {
        return switch (rotation) {
            case NONE -> switch (mushroom) {
                case 1, 2, 3, 5, 13 -> new Vec3i(-1, 0, -1);
                case 4, 6 -> new Vec3i(-2, 0, -1);
                case 7 -> new Vec3i(-2, 0, -2);
                case 8 -> new Vec3i(-3, 0, -1);
                case 9 -> new Vec3i(-4, 0, -2);
                case 10 -> new Vec3i(-3, 0, -3);
                case 11, 12 -> new Vec3i(-5, 0, -5);
                default -> new Vec3i(0, 0, 0);
            };
            case CLOCKWISE_90 -> switch (mushroom) {
                case 1, 2, 3, 5, 13 -> new Vec3i(1, 0, -1);
                case 4, 6 -> new Vec3i(1, 0, -2);
                case 7 -> new Vec3i(1, 0, -2);
                case 8 -> new Vec3i(1, 0, -3);
                case 9 -> new Vec3i(2, 0, -4);
                case 10 -> new Vec3i(3, 0, -3);
                case 11, 12 -> new Vec3i(5, 0, -5);
                default -> new Vec3i(0, 0, 0);
            };
            case CLOCKWISE_180 -> switch (mushroom) {
                case 1, 2, 3, 5, 13 -> new Vec3i(1, 0, 1);
                case 4, 6 -> new Vec3i(2, 0, 1);
                case 7 -> new Vec3i(3, 0, 1);
                case 8 -> new Vec3i(3, 0, 1);
                case 9 -> new Vec3i(4, 0, 2);
                case 10 -> new Vec3i(3, 0, 3);
                case 11,12 -> new Vec3i(5, 0, 5);
                default -> new Vec3i(0, 0, 0);
            };
            default -> switch (mushroom) {
                case 1, 2, 3, 5, 13 -> new Vec3i(-1, 0, 1);
                case 4, 6 -> new Vec3i(-1, 0, 2);
                case 7 -> new Vec3i(-1, 0, 2);
                case 8 -> new Vec3i(-1, 0, 3);
                case 9 -> new Vec3i(-2, 0, 4);
                case 10 -> new Vec3i(-3, 0, 3);
                case 11, 12 -> new Vec3i(-5, 0, 5);
                default -> new Vec3i(0, 0, 0);
            };
        };
    }

        public int getHeight(int mushroom) {
        return switch (mushroom) {
            case 1 -> 3;
            case 2, 3, 11, 12 -> 5;
            case 4, 5 -> 7;
            case 6, 7 -> 6;
            case 8, 13 -> 8;
            case 9 -> 9;
            default -> 11;
        };
    }

    //return wich mushroom wiil be placed
    public int getMushroom() {
        int rand = Random.create().nextBetween(0, 120);
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
        if(rand<100) return 10;
        if(rand<107) return 11;
        if(rand<114) return 12;
        return 13;
    }

    public void placeMushroom(StructureWorldAccess world, BlockPos pos, int mushroom, BlockRotation rotation) {
        if (!world.isClient()) {
            NbtPlacer structuremushroom = new NbtPlacer(world, Identifier.of(MushrooomsMod.MOD_ID, "red_mushroom/red_mushroom_" + mushroom));
            structuremushroom.place(1.0f, pos, new BlockPos(0,0,0), BlockMirror.NONE, rotation, true);
        }
    }

    //return random rotation
    public BlockRotation getBlockRotation() {
        return switch (Random.create().nextBetween(0, 3)) {
            case 1 -> BlockRotation.CLOCKWISE_90;
            case 2 -> BlockRotation.COUNTERCLOCKWISE_90;
            case 3 -> BlockRotation.CLOCKWISE_180;
            default -> BlockRotation.NONE;
        };
    }
}
