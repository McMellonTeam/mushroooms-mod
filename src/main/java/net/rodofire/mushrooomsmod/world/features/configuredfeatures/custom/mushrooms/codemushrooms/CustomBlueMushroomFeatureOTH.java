package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.rodofire.easierworldcreator.shapegen.SphereGen;
import net.rodofire.easierworldcreator.shapeutil.*;
import net.rodofire.easierworldcreator.util.FastMaths;
import net.rodofire.easierworldcreator.util.MathUtil;
import net.rodofire.easierworldcreator.worldgenutil.FastNoiseLite;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.util.BlockStateUtil;
import net.rodofire.mushrooomsmod.world.features.config.ModMushroomFeatureConfig;

import java.util.*;

public class CustomBlueMushroomFeatureOTH extends CustomBlueMushroom {
    public CustomBlueMushroomFeatureOTH(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    /**
     * méthode pour générer un large cap de champignon bleu dans un cas animé. On calcule les coordonnées d'un cylindre auquel on ajoute du bruit et on place le cylindre
     */
    @Override
    public void generateLargeCap(StructureWorldAccess world, Random random, BlockPos pos, int maxlarge, BlockState state, int large, int height, BlockList blockLists, int yOffset) {
        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise.SetFrequency(0.06f);

        SphereGen sphere = new SphereGen(world, pos, ShapeBase.PlaceMoment.ANIMATED_OTHER, large);
        sphere.setRadiusY(height);
        sphere.setZRotation(MathUtil.getRandomOpposite() * (Random.create().nextBetween(0, 20) + Random.create().nextBetween(0, 10)));
        sphere.setSecondYRotation(Random.create().nextBetween(0, 360));
        sphere.setBlockLayers(new BlockLayer(List.of(ModBlocks.BLUE_MUSHROOM_BLOCK.getDefaultState(), ModBlocks.BLUE_MUSHROOM_BLOCK.getDefaultState(), ModBlocks.BLUE_MUSHROOM_BLOCK.getDefaultState(), ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK.getDefaultState())));
        sphere.setLayerPlace(ShapePlaceType.LayerPlace.RANDOM);
        List<Set<BlockPos>> posList = sphere.getBlockPos();

        ///on ajoute du bruit
        //éviter de calculer trop de buit
        Map<Pair<Integer, Integer>, Float> offset = new HashMap<>();
        //les nouvelles positions
        List<Set<BlockPos>> newPosList = new ArrayList<>();
        int index = 0;
        for (Set<BlockPos> set : posList) {
            newPosList.add(new HashSet<>());
            for (BlockPos pos1 : set) {
                Pair<Integer, Integer> plan = new Pair<>(pos1.getX(), pos1.getZ());
                offset.computeIfAbsent(plan, k -> noise.GetNoise(pos1.getX(), pos1.getZ()));
                float a = offset.get(plan);
                newPosList.get(index).add(pos1.add(new BlockPos(0, (int) (3 * a), 0)));
            }
            index++;
        }
        ///on initialise l'animator
        StructurePlaceAnimator animator = new StructurePlaceAnimator(world, StructurePlaceAnimator.AnimatorType.FROM_POINT, StructurePlaceAnimator.AnimatorTime.BLOCKS_PER_TICK);
        animator.setBlocksPerTick(50);
        animator.setCenterPoint(pos.down(yOffset));

        List<BlockList> mushroomBlockList = new ArrayList<>();
        mushroomBlockList.add(blockLists);
        mushroomBlockList.addAll(BlockStateUtil.UnDivideBlockList(sphere.getBlockListWithVerification(sphere.getBlockPos())));
        animator.placeFromBlockList(mushroomBlockList);
    }

    @Override
    public BlockList generateLargeTrunk(StructureWorldAccess world, Random random, BlockPos pos, BlockState trunk, boolean force, int height, int maxlarge, int minlarge) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetFractalType(FastNoiseLite.FractalType.FBm);
        noise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise.SetFrequency(0.5f);

        List<BlockPos> posList = new ArrayList<>();

        double c3 = (double) 360 / height;
        for (double j = 1; j <= maxlarge; ++j) {
            double c1 = (j + (j * minlarge / maxlarge)) / 2;
            double c2 = (j - (j * minlarge / maxlarge)) / 2;

            for (int u = 0; u <= height; u++) {

                double a = c1 + c2 * FastMaths.getFastCos((float) (u * c3));

                for (double v = 0; v <= 360; v += 45 / j) {

                    int x = (int) (a * FastMaths.getFastCos((float) v));
                    int z = (int) (a * FastMaths.getFastSin((float) v));
                    mutable.set(pos, x, u, z);
                    float t = 4 * noise.GetNoise(mutable.getX(), mutable.getZ());
                    if (u == 0) {
                        for (int i = 0; i < t * 4 + 1; i++) {
                            posList.add(mutable.down(i));
                        }
                    }
                    if (t < 1) {
                        posList.add(mutable.down());
                    } else {
                        posList.add(mutable);
                        if (t > 1) {
                            posList.add(mutable.up());
                        }
                    }

                }
            }
        }
        return new BlockList(posList, trunk);
    }
}
