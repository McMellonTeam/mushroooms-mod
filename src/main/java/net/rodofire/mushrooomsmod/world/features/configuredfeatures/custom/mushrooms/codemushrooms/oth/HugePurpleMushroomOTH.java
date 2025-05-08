package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.blockdata.blocklist.BlockList;
import fr.rodofire.ewc.blockdata.blocklist.OrderedBlockListManager;
import fr.rodofire.ewc.blockdata.sorter.BlockSorter;
import fr.rodofire.ewc.maths.MathUtil;
import fr.rodofire.ewc.shape.block.placer.animator.StructurePlaceAnimator;
import fr.rodofire.ewc.util.BlockPlaceUtil;
import fr.rodofire.ewc.util.LongPosHelper;
import it.unimi.dsi.fastutil.longs.LongShortImmutablePair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.mushrooomsmod.world.features.config.PurpleMushroomConfig;

public abstract class HugePurpleMushroomOTH extends Feature<PurpleMushroomConfig> {
    /// la liste des fin des blockPos
    protected BlockPos[] end;

    Random random;

    public HugePurpleMushroomOTH(Codec<PurpleMushroomConfig> configCodec) {
        super(configCodec);
    }

    public boolean canGenerate(StructureWorldAccess world, OrderedBlockListManager manager) {
        for (LongShortImmutablePair pos : manager.getPosList()) {
            if (BlockPlaceUtil.verifyBlock(world, false, null, LongPosHelper.decodeBlockPos(pos.leftLong())))
                continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean generate(FeatureContext<PurpleMushroomConfig> context) {
        return generate(context, 0);
    }

    boolean generate(FeatureContext<PurpleMushroomConfig> context, int i) {
        if (i == 3)
            return false;

        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        PurpleMushroomConfig config = context.getConfig();
        this.random = context.getRandom();

        int capNumber = MathUtil.getRandomBoolean(random, 0.3f) ? 2 : 3;
        int[] directions = getDirections(capNumber);

        if (capNumber == 3) end = new BlockPos[3];
        else end = new BlockPos[3];

        BlockSorter sorter = new BlockSorter(BlockSorter.BlockSorterType.FROM_POINT);
        sorter.setCenterPoint(pos);

        OrderedBlockListManager ordered = new OrderedBlockListManager();


        ///on récupère les blockList des troncs et des caps
        BlockList blockList = this.getTrunkCoordinates(pos, directions[0], 0, config);
        ordered.put(blockList.getState(), blockList.getPosList());
        ordered.put(this.getCapCoordinates(end[0], config));

        blockList = this.getTrunkCoordinates(pos, directions[1], 1, config);
        ordered.put(blockList.getState(), blockList.getPosList());
        ordered.put(this.getCapCoordinates(end[1], config));

        if (capNumber == 3) {
            blockList = this.getTrunkCoordinates(pos, directions[2], 2, config);
            ordered.put(blockList.getState(), blockList.getPosList());
            ordered.put(this.getCapCoordinates(end[2], config));
        }

        if (!this.canGenerate(world, ordered))
            return this.generate(context, ++i);

        this.place(world, ordered);
        return true;
    }

    private void place(StructureWorldAccess world, OrderedBlockListManager blockListList) {
        StructurePlaceAnimator animator = new StructurePlaceAnimator(world, new BlockSorter(BlockSorter.BlockSorterType.FROM_POINT), StructurePlaceAnimator.AnimatorTime.CONSTANT_BLOCKS_PER_TICK);
        animator.setBlocksPerTick(3);
        animator.place(new BlockSorter(BlockSorter.BlockSorterType.INVERSE).sortOrderedBlockList(blockListList));
    }

    /**
     * méthode pour obtenir les directions, éviter que certaines branches se rencontrent
     *
     * @param caps le nombre de caps du champignon géant
     */
    int[] getDirections(int caps) {
        int actualDirection = random.nextBetween(0, 7);
        if (caps == 3) {
            int random1 = random.nextBetween(2, 4);
            int secondDirection = actualDirection + random1 % 8;
            int thirdDirection = secondDirection + random.nextBetween(2, 6 - random1) % 8;
            return new int[]{actualDirection, secondDirection, thirdDirection};
        }
        return new int[]{actualDirection, actualDirection + random.nextBetween(2, 6) % 8};
    }

    protected abstract BlockList getTrunkCoordinates(BlockPos base, int direction, int cap, PurpleMushroomConfig config);

    protected abstract OrderedBlockListManager getCapCoordinates(BlockPos pos, PurpleMushroomConfig config);
}
