package net.rodofire.mushrooomsmod.world.structures.custom.piece.mushroom;

import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.rodofire.easierworldcreator.blockdata.blocklist.DividedBlockListManager;
import net.rodofire.easierworldcreator.shape.block.layer.LayerManager;
import net.rodofire.easierworldcreator.structure.MultiChunkFeaturePiece;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

public class PurpleMushroomPiece extends MultiChunkFeaturePiece {
    protected PurpleMushroomPiece(StructurePieceType type, int length, BlockBox boundingBox, Identifier featureId, Set<ChunkPos> chunkPosSet) {
        super(type, length, boundingBox, featureId, chunkPosSet);
    }

    @Override
    public @Nullable DividedBlockListManager getDividedStructure(StructureWorldAccess structureWorldAccess, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random random, BlockBox blockBox, ChunkPos chunkPos, BlockPos blockPos) {
        return null;
    }

    @Override
    public @Nullable Pair<Map<ChunkPos, LongOpenHashSet>, LayerManager> getStructurePair(StructureWorldAccess structureWorldAccess, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random random, BlockBox blockBox, ChunkPos chunkPos, BlockPos blockPos) {
        return null;
    }
}
