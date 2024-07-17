package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.rodofire.easierworldcreator.util.FastMaths;
import net.rodofire.easierworldcreator.worldgenutil.WorldGenUtil;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.world.features.config.ModMushroomFeatureConfig;
import net.rodofire.mushrooomsmod.world.noises.FastNoiseLite;

import java.util.List;

public class CustomBlueMushroomFeature extends CustomBlueMushroom {
    public CustomBlueMushroomFeature(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public void generateCap(StructureWorldAccess world, Random random, BlockPos pos, int maxlarge, BlockState state) {

    }

    @Override
    public void generateLargeCap(StructureWorldAccess world, Random random, BlockPos pos, int maxlarge, BlockState state) {
        int large = Random.create().nextBetween(maxlarge + 3, maxlarge + 10);
        int height = Random.create().nextBetween(3, maxlarge);
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        int length = 0;
        int largexsquared = large * large;
        int largeysquared = height * height;

        boolean force = true;

        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetFractalType(FastNoiseLite.FractalType.FBm);
        noise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise.SetFrequency(0.06f);
        noise.SetFractalOctaves(2);

        for (float x = -large; x <= large; ++x) {
            for (float z = -large; z <= large; ++z) {

                float a = 3 * noise.GetNoise(x + pos.getX(), z + pos.getZ());

                for (float y = -height; y <= height; ++y) {
                    if (x * x / (float) largexsquared + y * y / (float) largeysquared + z * z / (float) largexsquared <= 1.0F) {
                        mutable.set(pos, (int) x, (int) (y + a), (int) z);
                        WorldGenUtil.verifyBlock(world, force, List.of(ModBlocks.BLUE_MUSHROOM_BLOCK), List.of(state), mutable);
                    }
                }
            }
        }
    }

    @Override
    public void generateTrunk(StructureWorldAccess world, Random random, BlockPos pos, ModMushroomFeatureConfig config, BlockState trunk, boolean force) {

    }

    //TODO change box
    @Override
    public void generateLargeTrunk(StructureWorldAccess world, Random random, BlockPos pos, BlockState trunk, boolean force, int height, int maxlarge, int minlarge) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        Vec3d vect3d = pos.toCenterPos();
        Box box = Box.of(vect3d, maxlarge, 2, maxlarge);
        System.out.println(vect3d + "   " + box);
        for (Entity entity : world.getOtherEntities(null, box)) {
            System.out.println("on");
            Vec3d vect = entity.getPos().subtract(pos.toCenterPos());
            System.out.println(vect);
            double distance = FastMaths.getLength((int) vect.x, (int) vect.z);
            System.out.println("distance " + distance);
            int x = (int) ((maxlarge * vect.x / distance) + pos.getX());
            int y = pos.getY();
            int z = (int) ((maxlarge * vect.z / distance) + pos.getZ());
            System.out.println(x + " " + y + " " + z);
            entity.teleport(x, y, z);
            System.out.println("fin");
        }
        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetFractalType(FastNoiseLite.FractalType.FBm);
        noise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise.SetFrequency(0.5f);

        double c3 = (double) 360 / height;
        for (double j = 1; j <= maxlarge; ++j) {
            double c1 = (j + (j * minlarge / maxlarge)) / 2;
            double c2 = (j - (j * minlarge / maxlarge)) / 2;
            for (int u = 0; u <= height; u++) {
                for (double v = 0; v <= 360; v += 45 / j) {
                    double a = c1 + c2 * FastMaths.getFastCos(u * c3);
                    int x = (int) (a * FastMaths.getFastCos(v));
                    int z = (int) (a * FastMaths.getFastSin(v));
                    mutable.set(pos, x, u, z);
                    float t = 4 * noise.GetNoise(mutable.getX(), mutable.getZ());
                    if (t < 1) {
                        WorldGenUtil.verifyBlock(world, force, null, List.of(trunk), mutable.down());
                        continue;
                    }
                    WorldGenUtil.verifyBlock(world, force, null, List.of(trunk), mutable);
                    if (t > 1) {
                        WorldGenUtil.verifyBlock(world, force, null, List.of(trunk), mutable.up());
                    }
                }
            }
        }
    }


}
