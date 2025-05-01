package net.rodofire.mushrooomsmod.world.structures.custom.piece.mushroom;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtOps;
import net.minecraft.structure.StructureContext;
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
import net.rodofire.easierworldcreator.maths.MathUtil;
import net.rodofire.easierworldcreator.shape.block.layer.LayerManager;
import net.rodofire.easierworldcreator.structure.MultiChunkFeaturePiece;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.world.structures.ModStructurePieceType;
import net.rodofire.mushrooomsmod.world.structures.custom.config.mushroom.PurpleMushroomGeneratorConfig;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

public class PurpleMushroomPiece extends MultiChunkFeaturePiece {
    PurpleMushroomGeneratorConfig config;
    BlockPos[] end;
    DividedBlockListManager dividedManager;
    Random random;


    public PurpleMushroomPiece(PurpleMushroomGeneratorConfig config, BlockBox boundingBox, Identifier featureId, Set<ChunkPos> chunkPosSet) {
        super(ModStructurePieceType.PURPLE_MUSHROOM, 0, boundingBox, featureId, chunkPosSet);
        this.config = config;
        this.dividedManager = config.trunk();
        this.end = config.end();
    }

    public PurpleMushroomPiece(NbtCompound nbt) {
        super(ModStructurePieceType.PURPLE_MUSHROOM, nbt);
        this.config = getGeneratorConfig(nbt, PurpleMushroomGeneratorConfig.CODEC);
        this.dividedManager = config.trunk();
        this.end = config.end();
    }

    public PurpleMushroomPiece(StructureContext structureContext, NbtCompound nbtCompound) {
        this(nbtCompound);
    }

    @Override
    protected void writeNbt(StructureContext context, NbtCompound nbt) {
        super.writeNbt(context, nbt);
        writeGeneratorConfigCodec(nbt, PurpleMushroomGeneratorConfig.CODEC, config);
    }

    @Override
    public @Nullable DividedBlockListManager getDividedStructure(StructureWorldAccess structureWorldAccess, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random random, BlockBox blockBox, ChunkPos chunkPos, BlockPos blockPos) {
        this.random = random;
        getCap();

        return dividedManager;
    }

    void getCap() {
        for (int i = 0; i < end.length; i++) {
            getCapCoordinates(end[i]);
        }
    }

    protected void getCapCoordinates(BlockPos pos) {
        int height = random.nextBetween(2, 3);
        int radius = getRadius();


        for (int i = -radius; i <= radius; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = -radius; k <= radius; k++) {
                    BlockState state = MathUtil.getRandomBoolean(random, 0.6f) ? ModBlocks.PURPLE_MUSHROOM_BLOCK.getDefaultState() : (MathUtil.getRandomBoolean(random, 0.3f) ? ModBlocks.PURPLE_DEGRADATED_MUSHROOM_BLOCK.getDefaultState() : ModBlocks.PURPLE_ALTERED_MUSHROOM_BLOCK.getDefaultState());
                    if (j < 2) {
                        boolean maxim1 = Math.abs(i) == radius - 1;
                        boolean maxkm1 = Math.abs(k) == radius - 1;
                        boolean maxi = Math.abs(i) == radius;
                        boolean maxk = Math.abs(k) == radius;
                        boolean secondmaxi = Math.abs(i) >= radius - 3;
                        boolean secondmaxk = Math.abs(k) >= radius - 3;
                        if ((maxi && secondmaxk) || (maxk && secondmaxi) || (maxim1 && maxkm1)) continue;
                        dividedManager.put(state, pos.add(i, j, k));

                    }//Smaller Base
                    else {
                        boolean maxim2 = Math.abs(i) == radius - 2;
                        boolean maxkm2 = Math.abs(k) == radius - 2;
                        boolean maxim1 = Math.abs(i) == radius - 1;
                        boolean maxkm1 = Math.abs(k) == radius - 1;
                        boolean maxi = Math.abs(i) == radius;
                        boolean maxk = Math.abs(k) == radius;
                        boolean secondmaxi = Math.abs(i) >= radius - 3;
                        boolean secondmaxk = Math.abs(k) >= radius - 3;
                        if (maxi || maxk || maxim2 && maxkm2 || maxim1 && secondmaxk || maxkm1 && secondmaxi)
                            continue;
                        dividedManager.put(state, pos.add(i, j, k));
                    }
                }
            }
        }
    }

    public int getRadius() {
        return random.nextBetween(2, 7);
    }

    @Override
    public @Nullable Pair<Map<ChunkPos, LongOpenHashSet>, LayerManager> getStructurePair(StructureWorldAccess structureWorldAccess, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random random, BlockBox blockBox, ChunkPos chunkPos, BlockPos blockPos) {
        return null;
    }
}
