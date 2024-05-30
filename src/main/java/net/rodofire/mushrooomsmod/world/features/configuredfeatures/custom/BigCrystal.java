package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.mushrooomsmod.world.features.config.ModSimpleBlockFeatureConfig;

public class BigCrystal extends Feature<ModSimpleBlockFeatureConfig> {

    public BigCrystal(Codec<ModSimpleBlockFeatureConfig> configCodec) {
        super(configCodec);
    }


    @Override
    public boolean generate(FeatureContext<ModSimpleBlockFeatureConfig> context) {
        BlockPos pos = context.getOrigin();
        BlockPos secondpos = pos.add(Random.create().nextBetween(1, 20) * randomOpposite(), Random.create().nextBetween(6, 30) * randomOpposite(), Random.create().nextBetween(1, 20) * randomOpposite());

        ModSimpleBlockFeatureConfig config = context.getConfig();
        Random random = context.getRandom();
        StructureWorldAccess world = context.getWorld();
        BlockState state = config.blockprovider.get(random, pos);
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        mutable.set(pos);

        BlockPos middlestate = new BlockPos((secondpos.getX() + pos.getX()) / 2 , (secondpos.getY() + pos.getY()) / 2,( secondpos.getZ() + pos.getZ()) / 2);
        BlockState state1 = world.getBlockState(pos);
        BlockState state2 = world.getBlockState(middlestate);
        if (!state2.isAir()) return false;
        if (state1.isAir() && world.getBlockState(mutable.down()).isAir() && world.getBlockState(mutable.up()).isAir()) return false;
        //create a round base
        int baselarge = Random.create().nextBetween(2, 5);
        for (int i = 1; i < baselarge; i++) {
            for (float j = (float) -Math.PI; j < Math.PI; j += (float) (Math.PI / (6 * i))) {
                int x = (int) ((i) * Math.cos(j));
                int z = (int) ((i) * Math.sin(j));
                mutable.set(pos, x, 0, z);

                drawLine(world, mutable, secondpos, state);
            }
        }
        return true;
    }

    //based on the Bresenham algorithm
    private void drawLine(StructureWorldAccess world, BlockPos start, BlockPos end, BlockState state) {
        int x1 = start.getX();
        int y1 = start.getY();
        int z1 = start.getZ();
        int x2 = end.getX();
        int y2 = end.getY();
        int z2 = end.getZ();

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int dz = Math.abs(z2 - z1);

        int xs = x1 < x2 ? 1 : -1;
        int ys = y1 < y2 ? 1 : -1;
        int zs = z1 < z2 ? 1 : -1;

        if (dx >= dy && dx >= dz) {
            int p1 = 2 * dy - dx;
            int p2 = 2 * dz - dx;
            while (x1 != x2) {
                x1 += xs;
                if (p1 >= 0) {
                    y1 += ys;
                    p1 -= 2 * dx;
                }
                if (p2 >= 0) {
                    z1 += zs;
                    p2 -= 2 * dx;
                }
                p1 += 2 * dy;
                p2 += 2 * dz;
                BlockPos currentPos = new BlockPos(x1, y1, z1);
                BlockState currentState = world.getBlockState(currentPos);
                if (currentState.isAir() || currentState.isIn(BlockTags.FLOWERS)) {
                    world.setBlockState(currentPos, state, 2);
                }
            }
        } else if (dy >= dx && dy >= dz) {
            int p1 = 2 * dx - dy;
            int p2 = 2 * dz - dy;
            while (y1 != y2) {
                y1 += ys;
                if (p1 >= 0) {
                    x1 += xs;
                    p1 -= 2 * dy;
                }
                if (p2 >= 0) {
                    z1 += zs;
                    p2 -= 2 * dy;
                }
                p1 += 2 * dx;
                p2 += 2 * dz;
                BlockPos currentPos = new BlockPos(x1, y1, z1);
                BlockState currentState = world.getBlockState(currentPos);
                if (currentState.isAir() || currentState.isIn(BlockTags.FLOWERS)) {
                    world.setBlockState(currentPos, state, 2);
                }
            }
        } else {
            int p1 = 2 * dy - dz;
            int p2 = 2 * dx - dz;
            while (z1 != z2) {
                z1 += zs;
                if (p1 >= 0) {
                    y1 += ys;
                    p1 -= 2 * dz;
                }
                if (p2 >= 0) {
                    x1 += xs;
                    p2 -= 2 * dz;
                }
                p1 += 2 * dy;
                p2 += 2 * dx;
                BlockPos currentPos = new BlockPos(x1, y1, z1);
                BlockState currentState = world.getBlockState(currentPos);
                if (currentState.isAir() || currentState.isIn(BlockTags.FLOWERS)) {
                    world.setBlockState(currentPos, state, 2);
                }
            }
        }
    }

    public int randomOpposite() {
        return (Random.create().nextBetween(0, 1) == 0) ? 1 : -1;
    }


}
