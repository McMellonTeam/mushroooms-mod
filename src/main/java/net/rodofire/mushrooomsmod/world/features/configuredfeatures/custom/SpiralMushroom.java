package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import fr.rodofire.ewc.blockdata.layer.BlockLayer;
import fr.rodofire.ewc.blockdata.layer.BlockLayerManager;
import fr.rodofire.ewc.shape.block.gen.SpiralGen;
import fr.rodofire.ewc.shape.block.layer.LayerManager;
import fr.rodofire.ewc.shape.block.placer.LayerPlacer;
import fr.rodofire.ewc.shape.block.rotations.Rotator;
import fr.rodofire.ewc.util.LongPosHelper;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.mushrooomsmod.block.ModBlocks;

import java.util.List;
import java.util.Map;

public class SpiralMushroom extends Feature<DefaultFeatureConfig> {
    public SpiralMushroom(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    public boolean canPlace(StructureWorldAccess world, Map<ChunkPos, LongOpenHashSet> posList) {
        for (LongOpenHashSet set : posList.values()) {
            for (long blockPos : set) {
                BlockState blockState = world.getBlockState(LongPosHelper.decodeBlockPos(blockPos));
                if (blockState.isAir()) continue;
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random random = context.getRandom();

        if (!world.getBlockState(pos.down()).isOpaqueFullCube(world, pos.down())) return false;

        BlockState block = ModBlocks.BLUE_MUSHROOM_BLOCK.getDefaultState();
        BlockState block2 = ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK.getDefaultState();
        BlockState block3 = ModBlocks.BLUE_DEGRADATED_MUSHROOM_BLOCK.getDefaultState();
        BlockState block4 = Blocks.MUSHROOM_STEM.getDefaultState();

        int large = random.nextBetween(5, 10);

        SpiralGen spiral = new SpiralGen(pos, large, random.nextBetween(25, 50));
        spiral.setSpiralType(SpiralGen.SpiralType.LARGE_OUTLINE);

        BlockLayer layer = new BlockLayer(LayerPlacer.ofRandom(random), List.of(block, block2, block3, block4), List.of((short) 6, (short) 4, (short) 2, (short) 1));


        int outline = context.getRandom().nextBetween(1,2);
        spiral.setOutlineRadiusX(outline);
        spiral.setOutlineRadiusX(outline);

        spiral.setRadiusX(new Pair<>(large, 1));
        spiral.setRadiusZ(new Pair<>(large, 1));

        Rotator rotator = new Rotator(pos, random.nextBetween(0, 360), 0,0);

        spiral.setRotator(rotator);

        Map<ChunkPos, LongOpenHashSet> posList = spiral.getShapeCoordinates();
        if (!canPlace(world, posList)) return false;

        LayerManager layerManager = new LayerManager(LayerManager.Type.SURFACE,
                new BlockLayerManager(layer)
        );
        layerManager.place(world, spiral.getShapeCoordinates());

        return true;
    }
}
