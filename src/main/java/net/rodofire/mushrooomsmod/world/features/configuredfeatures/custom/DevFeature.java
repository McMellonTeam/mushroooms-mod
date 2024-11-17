package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.shapegen.CylinderGen;
import net.rodofire.easierworldcreator.shapegen.TorusGen;
import net.rodofire.easierworldcreator.shapeutil.BlockLayer;
import net.rodofire.easierworldcreator.shapeutil.Shape;
import net.rodofire.easierworldcreator.util.FastMaths;
import net.rodofire.easierworldcreator.worldgenutil.FastNoiseLite;
import net.rodofire.mushrooomsmod.world.features.config.ModSimpleBlockFeatureConfig;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.util.RockUtil;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DevFeature extends Feature<ModSimpleBlockFeatureConfig> {
    public DevFeature(Codec<ModSimpleBlockFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<ModSimpleBlockFeatureConfig> context) {
        /*System.out.println("ok");
        StructureWorldAccess world = context.getWorld();
        Random random = context.getRandom();
        BlockPos pos = context.getOrigin();
        BlockState state = context.getConfig().blockprovider.get(random, pos);
        long startTimeCartesian = System.nanoTime();

        long endTimeCartesian = (System.nanoTime());
        long durationCartesian = (endTimeCartesian - startTimeCartesian) / 1000000;
        System.out.println("duration : " + durationCartesian + " ms");
        return true;*/

        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();

        boolean bl = false;
        for (int i = 0; i < 10; i++) {
            if (world.getBlockState(pos.down(i)).isOpaqueFullCube()) bl = true;
        }
        if (!bl) return false;

        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetFrequency(0.1f);

        int radiusx = Random.create().nextBetween(10, 23);
        int radiusz = Random.create().nextBetween(10, 23);
        int innerRadius = Random.create().nextBetween(2, 7);

        TorusGen torus = new TorusGen(world, pos, Shape.PlaceMoment.WORLD_GEN, innerRadius, radiusx);

        BlockLayer stone = RockUtil.getRandomBlockLayer(
                Random.create().nextBetween(3, 5),
                Random.create().nextBetween(2, 5),
                Blocks.STONE.getDefaultState(),
                RockUtil.getRandomStone(Blocks.TUFF.getDefaultState()));
        stone.setBlocksToForce(Set.of(Blocks.GRASS_BLOCK, Blocks.DIRT));
        torus.setBlockLayers(
                new BlockLayer(
                        Blocks.GRASS_BLOCK.getDefaultState(), 1),

                stone);

        torus.setTorusType(TorusGen.TorusType.HORIZONTAL_HALF);


        torus.setLayerPlace(Shape.LayerPlace.NOISE3D);
        FastNoiseLite placeNoise = new FastNoiseLite((int) world.getSeed());
        placeNoise.SetFrequency(0.2f);
        torus.setNoise(placeNoise);

        torus.setOuterRadiusZ(radiusz);
        torus.setLayersType(Shape.LayersType.SURFACE);

        int rotationX = Random.create().nextBetween(0, 180);
        int rotattionY = -Random.create().nextBetween(50, 140);

        torus.setZRotation(rotationX);
        torus.setYRotation(rotattionY);
        //torus.setSecondxrotation(Random.create().nextBetween(0, 180));

        List<Set<BlockPos>> poslist = torus.getBlockPos();

        for (Set<BlockPos> set : poslist) {
            Iterator<BlockPos> iterator = set.iterator();

            while (iterator.hasNext()) {
                BlockPos pos1 = iterator.next();
                if (noise.GetNoise(pos1.getX(), pos1.getY(), pos1.getZ()) <= -0.8f) {
                    iterator.remove();
                }
            }
        }

        BlockPos pos1 = new BlockPos((int) (radiusx * FastMaths.getFastCos(rotationX)), 0, (int) (radiusz * FastMaths.getFastSin(rotationX)));
        BlockPos pos2 = new BlockPos((int) (-radiusx * FastMaths.getFastCos(rotationX)), 0, (int) (-radiusz * FastMaths.getFastSin(rotationX)));

        CylinderGen cylinder = new CylinderGen(world, pos.add(pos1), Shape.PlaceMoment.WORLD_GEN, innerRadius, 15);
        CylinderGen cylinder2 = new CylinderGen(world, pos.add(pos2), Shape.PlaceMoment.WORLD_GEN, innerRadius, 15);

        cylinder.setBlockLayers(stone);
        cylinder2.setBlockLayers(stone);

        cylinder.setYRotation(-rotattionY);
        cylinder2.setYRotation(-rotattionY);


        torus.place(poslist);
        cylinder.place();
        cylinder2.place();

        return true;

    }
}
