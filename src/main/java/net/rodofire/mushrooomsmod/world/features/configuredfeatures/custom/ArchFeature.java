package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.shapegen.TorusGen;
import net.rodofire.easierworldcreator.shapeutil.BlockLayer;
import net.rodofire.easierworldcreator.shapeutil.Shape;
import net.rodofire.easierworldcreator.util.MathUtil;
import net.rodofire.mushrooomsmod.world.features.config.ArchConfig;

import java.io.IOException;

public class ArchFeature extends Feature<ArchConfig> {
    public ArchFeature(Codec<ArchConfig> configCodec) {
        super(configCodec);
    }

    //Since that arch generation is pretty big, we need to change the generation to be chunk independant
    @Override
    public boolean generate(FeatureContext<ArchConfig> context) {
        BlockPos pos = context.getOrigin();

        StructureWorldAccess world = context.getWorld();


        int chunkX = new ChunkPos(pos).x;
        int chunkZ = new ChunkPos(pos).z;

        //if(WorldGenUtil.getRandomBoolean(0.8f))return false;

        if (world.isClient()) return false;
        if (MathUtil.getRandomBoolean(0.90f)) return false;
        boolean bl = false;
        for (int i = 0; i < 10; i++) {
            if (world.getBlockState(pos.down(i)).isOpaqueFullCube()) bl = true;
        }
        if (!bl) return false;

        TorusGen sphereGen = new TorusGen(world, pos, Shape.PlaceMoment.WORLD_GEN, Random.create().nextBetween(2, 7), Random.create().nextBetween(24, 64));
        sphereGen.setBlockLayers(new BlockLayer(Blocks.GRASS_BLOCK.getDefaultState(), 1), new BlockLayer(Blocks.STONE.getDefaultState(), 2));
        sphereGen.setOuterRadiusZ(Random.create().nextBetween(24, 64));
        sphereGen.setLayersType(Shape.LayersType.SURFACE);
        sphereGen.setYRotation(Random.create().nextBetween(50, 140));
        sphereGen.setSecondYRotation(Random.create().nextBetween(0, 180));

        try {
            sphereGen.place();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
