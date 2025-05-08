package net.rodofire.mushrooomsmod.world.structures.custom.structure.mushrooms;

import com.mojang.serialization.MapCodec;
import fr.rodofire.ewc.shape.block.gen.SphereGen;
import fr.rodofire.ewc.shape.block.rotations.Rotator;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.structure.StructurePiecesCollector;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.structure.StructureType;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.world.structures.ModStructureTypes;
import net.rodofire.mushrooomsmod.world.structures.custom.config.mushroom.GiantYellowMushroomGeneratorConfig;
import net.rodofire.mushrooomsmod.world.structures.custom.piece.mushroom.GiantYellowMushroomPiece;

import java.util.Set;
import java.util.stream.Collectors;

public class GiantYellowMushroomStructure extends MushrooomsModStructure {
    public static final MapCodec<GiantYellowMushroomStructure> CODEC = createCodec(GiantYellowMushroomStructure::new);

    public GiantYellowMushroomStructure(Config config) {
        super(config);
    }


    @Override
    protected void getPieces(StructurePiecesCollector builder, BlockPos pos, Context context) {
        Random random = context.random();
        BlockPos end = pos.add(random.nextBetween(-8, 8), random.nextBetween(50, 80), random.nextBetween(-8, 8));

        int down = random.nextBetween(1, 3);
        int radius = random.nextBetween(20, 32);
        SphereGen sphereGen = new SphereGen(end, radius);
        sphereGen.setRadiusY(random.nextBetween(4, 7));


        int rot1 = random.nextBetween(-10, 10);
        int rot2 = random.nextBetween(0, 360);
        Rotator rotator = new Rotator(end, 0, rot1, rot2);
        sphereGen.setRotator(rotator);


        int heightMask = random.nextBetween(down + 2, down + 6);
        SphereGen mask = new SphereGen(end.down(heightMask), random.nextBetween(19, radius));
        mask.setRadiusY(heightMask);

        Rotator rotatorMask = new Rotator(end.down(heightMask - down), 0, rot1, rot2);
        mask.setRotator(rotatorMask);

        LongOpenHashSet covered = sphereGen.getCoveredChunks();

        GiantYellowMushroomGeneratorConfig config = new GiantYellowMushroomGeneratorConfig(sphereGen, mask, pos, end);

        Identifier id = Identifier.of(MushrooomsMod.MOD_ID, "giant_yellow_mushroom_" + random.nextLong());
        Set<ChunkPos> chunkPosSet = covered.longStream().mapToObj(ChunkPos::new).collect(Collectors.toSet());
        for (long encodedChunkPos : covered) {
            ChunkPos chunkPos = new ChunkPos(encodedChunkPos);

            BlockBox blockBox = new BlockBox(chunkPos.getStartX(), 0, chunkPos.getStartZ(), chunkPos.getStartX() + 16, 300, chunkPos.getStartZ() + 16);
            builder.addPiece(new GiantYellowMushroomPiece(blockBox, id, chunkPosSet, config));
        }

    }

    @Override
    public StructureType<?> getType() {
        return ModStructureTypes.GIANT_YELLOW_MUSHROOM;
    }
}
