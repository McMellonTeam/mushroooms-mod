package net.rodofire.mushrooomsmod.world.structures.custom.structure.mushrooms;

import net.minecraft.structure.StructurePiecesCollector;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.structure.Structure;

import java.util.Optional;

public abstract class MushrooomsModStructure extends Structure {
    protected MushrooomsModStructure(Config config) {
        super(config);
    }

    @Override
    protected Optional<StructurePosition> getStructurePosition(Context context) {
        ChunkPos chunkPos = context.chunkPos();
        int x = chunkPos.getCenterX() + context.random().nextBetween(-7, 7);
        int z = chunkPos.getCenterZ() + context.random().nextBetween(-7, 7);

        int y = context.chunkGenerator().getHeightOnGround(x, z, Heightmap.Type.WORLD_SURFACE_WG, context.world(), context.noiseConfig());

        if (context.chunkGenerator().getSeaLevel() == y) return Optional.empty();

        BlockPos pos = new BlockPos(x, y, z);

        return Optional.of(new StructurePosition(pos, collector -> {
            getPieces(collector, pos, context);
        }));
    }

    protected abstract void getPieces(StructurePiecesCollector collector, BlockPos pos, Context context);

    public BlockBox getBoundingBox(ChunkPos pos) {
        return new BlockBox(
                pos.getStartX(),
                0,
                pos.getStartZ(),
                pos.getEndX(),
                128,
                pos.getEndZ()
        );
    }
}
