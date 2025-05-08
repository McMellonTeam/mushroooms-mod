package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.maths.FastMaths;
import fr.rodofire.ewc.maths.MathUtil;
import fr.rodofire.ewc.shape.block.simplegen.GenLines;
import fr.rodofire.ewc.shape.block.simplegen.GenSpheres;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
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
        Random random = context.getRandom();
        BlockPos pos = context.getOrigin();
        if (random.nextBetween(0, 4) == 0) {
            BlockPos secondPos = pos.add(random.nextBetween(1, 16) * MathUtil.getRandomOpposite(random), random.nextBetween(6, 30) * MathUtil.getRandomOpposite(random), random.nextBetween(1, 16) * MathUtil.getRandomOpposite(random));
            BlockPos thirdPos = pos.add(random.nextBetween(1, 16) * MathUtil.getRandomOpposite(random), random.nextBetween(6, 30) * MathUtil.getSign(secondPos.getY()), random.nextBetween(1, 16) * MathUtil.getRandomOpposite(random));

            ModSimpleBlockFeatureConfig config = context.getConfig();
            StructureWorldAccess world = context.getWorld();
            BlockState state = config.blockprovider.get(random, pos);
            BlockPos.Mutable mutable = new BlockPos.Mutable();

            mutable.set(pos);

            BlockPos middleState = new BlockPos((secondPos.getX() + pos.getX()) / 2, (secondPos.getY() + pos.getY()) / 2, (secondPos.getZ() + pos.getZ()) / 2);
            BlockPos secondMiddleState = new BlockPos((thirdPos.getX() + pos.getX()) / 2, (thirdPos.getY() + pos.getY()) / 2, (thirdPos.getZ() + pos.getZ()) / 2);
            BlockState state1 = world.getBlockState(pos);
            BlockState state2 = world.getBlockState(middleState);
            BlockState state3 = world.getBlockState(secondMiddleState);

            if (!generatePillar(secondPos, pos, state2, state1, world, mutable, state, random)) return false;
            return generatePillar(thirdPos, pos, state3, state1, world, mutable, state, random);
        } else {
            BlockPos secondpos = pos.add(random.nextBetween(1, 16) * MathUtil.getRandomOpposite(random), random.nextBetween(6, 30) * MathUtil.getRandomOpposite(random), random.nextBetween(1, 16) * MathUtil.getRandomOpposite(random));

            ModSimpleBlockFeatureConfig config = context.getConfig();
            StructureWorldAccess world = context.getWorld();
            BlockState state = config.blockprovider.get(random, pos);
            BlockPos.Mutable mutable = new BlockPos.Mutable();

            mutable.set(pos);

            BlockPos middlestate = new BlockPos((secondpos.getX() + pos.getX()) / 2, (secondpos.getY() + pos.getY()) / 2, (secondpos.getZ() + pos.getZ()) / 2);
            BlockState state1 = world.getBlockState(pos);
            BlockState state2 = world.getBlockState(middlestate);
            return this.generatePillar(secondpos, pos, state2, state1, world, mutable, state, random);
        }
    }

    private boolean generatePillar(BlockPos secondpos, BlockPos pos, BlockState state2, BlockState state1, StructureWorldAccess world, BlockPos.Mutable mutable, BlockState state, Random random) {
        Direction direction;
        if (secondpos.getY() - pos.getY() > 0) direction = Direction.DOWN;
        else direction = Direction.UP;

        if (!state2.isAir()) return false;
        if (state1.isAir() && world.getBlockState(mutable.down()).isAir() && world.getBlockState(mutable.up()).isAir())
            return false;

        //create a round base
        int baseLarge = random.nextBetween(2, 5);
        for (int i = 1; i <= baseLarge; i++) {
            for (float j = (float) 0; j < 360; j += (float) 45 / i) {
                int x = (int) ((i) * FastMaths.getFastCos(j));
                int z = (int) ((i) * FastMaths.getFastSin(j));
                mutable.set(pos, x, 0, z);
                world.setBlockState(mutable, state, 2);

                GenLines.drawLine(world, mutable, secondpos, state);
            }
        }
        GenSpheres.generateHalfFullSphere(world, baseLarge, pos, direction, state);
        return true;
    }

}
