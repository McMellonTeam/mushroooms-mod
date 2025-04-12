package net.rodofire.mushrooomsmod.world.structures.custom.structure.mushrooms;

import com.mojang.serialization.MapCodec;
import it.unimi.dsi.fastutil.longs.LongSet;
import net.minecraft.structure.StructurePiecesCollector;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;
import net.rodofire.easierworldcreator.maths.MathUtil;
import net.rodofire.easierworldcreator.shape.block.gen.LineGen;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;
import net.rodofire.easierworldcreator.shape.block.rotations.Rotator;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.world.structures.ModStructureTypes;
import net.rodofire.mushrooomsmod.world.structures.custom.piece.mushroom.YellowMushroomPiece;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class YellowMushroomStructure extends Structure {
    public static final MapCodec<YellowMushroomStructure> CODEC = createCodec(YellowMushroomStructure::new);

    public YellowMushroomStructure(Config config) {
        super(config);
    }

    @Override
    protected Optional<StructurePosition> getStructurePosition(Context context) {
        ChunkPos chunkPos = context.chunkPos();
        int x = chunkPos.getCenterX() + context.random().nextBetween(-7, 7);
        int z = chunkPos.getCenterZ() + context.random().nextBetween(-7, 7);

        int y = context.chunkGenerator().getHeightOnGround(x, z, Heightmap.Type.WORLD_SURFACE_WG, context.world(), context.noiseConfig());

        if(context.chunkGenerator().getSeaLevel() == y) return Optional.empty();

        BlockPos pos = new BlockPos(x, y, z);

        return Optional.of(new StructurePosition(pos, collector -> {
            getPieces(collector, pos, context);
        }));
    }

    private void getPieces(StructurePiecesCollector builder, BlockPos pos, Context context) {
        Random random = context.random();
        boolean flatCap = MathUtil.getRandomBoolean(random, 0.33f);
        int height = random.nextBetween(12, 22);
        int large = random.nextBetween(4, flatCap ? 9 : 10);

        int maxXOffset = 10;
        int maxZOffset = 10;

        BlockPos end = pos.add(random.nextBetween(-height * maxXOffset / 30, height * maxXOffset / 30), height, random.nextBetween(-height * maxZOffset / 30, height * maxZOffset) / 30);
        LineGen lineGen = new LineGen(pos, end);


        int rot1 = random.nextBetween(0, 30);
        int rot2 = random.nextBetween(0, 360);

        Rotator rotator = new Rotator(end.down(large / 2), 0, rot1, rot2);

        SphereGen sphereGen = new SphereGen(end.down(large / 2), flatCap ? large * 2 : (int) (large * 1.5f));
        sphereGen.setRadiusY(large);
        sphereGen.setRotator(rotator);

        LongSet covered = lineGen.getCoveredChunks();
        covered.addAll(sphereGen.getCoveredChunks());

        Identifier id = Identifier.of(MushrooomsMod.MOD_ID, "yellow_mushroom_" + random.nextLong());
        Set<ChunkPos> chunkPosSet = covered.longStream().mapToObj(ChunkPos::new).collect(Collectors.toSet());

        for (long encodedChunkPos : covered) {
            ChunkPos chunkPos = new ChunkPos(encodedChunkPos);

            builder.addPiece(new YellowMushroomPiece(new BlockBox(chunkPos.getStartX(), 0, chunkPos.getStartZ(), chunkPos.getStartX() + 16, 300, chunkPos.getStartZ() + 16), pos, end, rotator, large, flatCap, id, chunkPosSet));
        }

    }

    @Override
    public StructureType<?> getType() {
        return ModStructureTypes.YELLOW_MUSHROOM;
    }
}
