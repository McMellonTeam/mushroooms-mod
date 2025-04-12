package net.rodofire.mushrooomsmod.world.structures.custom.piece.mushroom;

import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.structure.StructureContext;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.rodofire.easierworldcreator.blockdata.blocklist.DividedBlockListManager;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayerManager;
import net.rodofire.easierworldcreator.shape.block.MultiChunkFeaturesHandler;
import net.rodofire.easierworldcreator.shape.block.gen.LineGen;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;
import net.rodofire.easierworldcreator.shape.block.layer.LayerManager;
import net.rodofire.easierworldcreator.shape.block.placer.LayerPlacer;
import net.rodofire.easierworldcreator.shape.block.rotations.Rotator;
import net.rodofire.easierworldcreator.structure.MultiChunkFeaturePiece;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.world.structures.ModStructurePieceType;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class YellowMushroomPiece extends MultiChunkFeaturePiece {
    Rotator rotator;
    BlockPos end;
    BlockPos center;

    int radius;
    boolean flat;

    BlockLayer capLayer;
    BlockLayer trunkLayer;

    public YellowMushroomPiece(BlockBox boundingBox, BlockPos center, BlockPos end, Rotator rotator, int radius, boolean flat, Identifier structureReference, Set<ChunkPos> chunkPosSet) {
        super(ModStructurePieceType.YELLOW_MUSHROOM, 0, boundingBox, structureReference, chunkPosSet);
        this.rotator = rotator;
        this.end = end;
        this.center = center;
        this.radius = radius;
        this.flat = flat;
    }

    public YellowMushroomPiece(NbtCompound nbtCompound) {
        super(ModStructurePieceType.YELLOW_MUSHROOM, nbtCompound);
        this.center = new BlockPos(nbtCompound.getInt("center_x"), nbtCompound.getInt("center_y"), nbtCompound.getInt("center_z"));
        this.end = new BlockPos(nbtCompound.getInt("end_x"), nbtCompound.getInt("end_y"), nbtCompound.getInt("end_z"));
        this.radius = nbtCompound.getInt("radius");
        this.flat = nbtCompound.getBoolean("flat");
        this.rotator = new Rotator(
                new BlockPos(nbtCompound.getInt("rotator_x"), nbtCompound.getInt("rotator_y"), nbtCompound.getInt("rotator_z")),
                nbtCompound.getInt("rotation1"),
                nbtCompound.getInt("rotation2"),
                nbtCompound.getInt("rotation3")
        );
    }

    public YellowMushroomPiece(StructureContext structureContext, NbtCompound nbtCompound) {
        this(nbtCompound);
    }

    @Override
    protected void writeNbt(StructureContext context, NbtCompound nbt) {
        super.writeNbt(context, nbt);
        nbt.putInt("center_x", center.getX());
        nbt.putInt("center_y", center.getY());
        nbt.putInt("center_z", center.getZ());
        nbt.putInt("end_x", end.getX());
        nbt.putInt("end_y", end.getY());
        nbt.putInt("end_z", end.getZ());
        nbt.putInt("radius", radius);
        nbt.putBoolean("flat", flat);
        nbt.putInt("rotator_x", rotator.getCenterPos().getX());
        nbt.putInt("rotator_y", rotator.getCenterPos().getY());
        nbt.putInt("rotator_z", rotator.getCenterPos().getZ());
        nbt.putInt("rotation1", rotator.getYRotation());
        nbt.putInt("rotation2", rotator.getZRotation());
        nbt.putInt("rotation3", rotator.getSecondYRotation());
    }

    @Override
    public DividedBlockListManager getDividedStructure(StructureWorldAccess structureWorldAccess, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random random, BlockBox blockBox, ChunkPos chunkPos, BlockPos blockPos) {
        MultiChunkFeaturesHandler.add(structureWorldAccess, Set.of(chunkPos), this.featureId);

        this.capLayer = new BlockLayer(
                LayerPlacer.ofRandom(random),
                List.of(ModBlocks.YELLOW_MUSHROOM_BLOCK.getDefaultState(), ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK.getDefaultState()),
                List.of((short) 2, (short) 1)
        );
        this.trunkLayer = new BlockLayer(
                LayerPlacer.ofRandom(random),
                Blocks.MUSHROOM_STEM.getDefaultState()
        );

        DividedBlockListManager dividedManager = getCap(random);
        dividedManager.put(getTrunk(random));
        return dividedManager;
    }

    @Override
    public Pair<Map<ChunkPos, LongOpenHashSet>, LayerManager> getStructurePair(StructureWorldAccess structureWorldAccess, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random random, BlockBox blockBox, ChunkPos chunkPos, BlockPos blockPos) {
        return null;
    }

    public DividedBlockListManager getTrunk(Random random) {
        LineGen line = new LineGen(center, end);
        Map<ChunkPos, LongOpenHashSet> trunkCoordinates = line.getShapeCoordinates();
        Direction[] directions = {Direction.SOUTH, Direction.EAST, Direction.NORTH, Direction.WEST};

        for (int i = 0; i < 4; i++) {
            line = new LineGen(center.up(random.nextBetween(-1, 1)), end.up(random.nextBetween(-1, 1)));
            Map<ChunkPos, LongOpenHashSet> intermediateCoordinates = line.getShapeCoordinates();

            intermediateCoordinates.forEach((chunkPos, set) -> trunkCoordinates.computeIfAbsent(chunkPos, k -> new LongOpenHashSet()).addAll(set));

            for (Direction direction : directions) {
                line = new LineGen(center.offset(direction).up(random.nextBetween(-1, 1)), end.offset(direction).up(random.nextBetween(-1, 1)));
                Map<ChunkPos, LongOpenHashSet> additionalCoordinates = line.getShapeCoordinates();

                additionalCoordinates.forEach((chunkPos, set) -> trunkCoordinates.computeIfAbsent(chunkPos, k -> new LongOpenHashSet()).addAll(set));
            }
        }

        LayerManager layerManager = new LayerManager(LayerManager.Type.SURFACE, new BlockLayerManager(trunkLayer));
        return layerManager.getDivided(trunkCoordinates);
    }

    public DividedBlockListManager getCap(Random random) {
        Rotator maskRotator = new Rotator(end.down(this.radius), 0, this.rotator.getZRotation(), this.rotator.getSecondYRotation());

        SphereGen cap = new SphereGen(end.down(this.radius / 2), this.flat ? this.radius * 2 : (int) (this.radius * 1.5f));
        SphereGen capMask = new SphereGen(end.down(this.radius), this.flat ? (int) ((2 + (float) random.nextBetween(0, 4) / 10) * (this.radius - 0.75f)) : (int) ((1.5 + (float) random.nextBetween(0, 5) / 10) * (this.radius - 1)));

        cap.setRadiusY(this.radius);
        cap.setRotator(rotator);
        capMask.setRadiusY(this.radius);
        capMask.setRotator(maskRotator);

        Map<ChunkPos, LongOpenHashSet> capCoordinates = cap.getShapeCoordinates();
        Map<ChunkPos, LongOpenHashSet> maskCoordinates = capMask.getShapeCoordinates();
        capCoordinates.forEach((coordinatesChunkPos, set) -> {
            LongSet maskedSet = maskCoordinates.get(coordinatesChunkPos);
            if (maskedSet == null) return;

            set.removeAll(maskCoordinates.get(coordinatesChunkPos));
        });

        LayerManager layerManager = new LayerManager(LayerManager.Type.SURFACE, new BlockLayerManager(capLayer));
        return layerManager.getDivided(capCoordinates);
    }
}
