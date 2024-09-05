package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.mushrooomsmod.world.features.config.ModMushroomFeatureConfig;

public abstract class CustomBlueMushroom extends Feature<ModMushroomFeatureConfig> {
    public CustomBlueMushroom(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    public boolean canPlace(StructureWorldAccess world, Random random, BlockPos pos, int large, int height) {
        for (int i = -large + 4; i <= large - 4; i++) {
            for (int j = -height + 1; j <= height; j++) {
                for (int k = -large + 2; k <= large - 2; k++) {
                    BlockState state = world.getBlockState(pos.add(i, j, k));
                    if (state.isAir()) {
                        continue;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean generate(FeatureContext<ModMushroomFeatureConfig> context) {
        long startTimeCartesian = System.nanoTime();

        StructureWorldAccess worldAccess = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random random = context.getRandom();
        BlockState cap = context.getConfig().capProvider.get(random, pos);
        BlockState trunk = context.getConfig().stemProvider.get(random, pos);
        int height = Random.create().nextBetween(10, 20);
        int secondheight = 0;
        if (Random.create().nextBoolean()) {
            secondheight = Random.create().nextBetween(2, 5);
        }

        int minlarge = Random.create().nextBetween(2, 3);
        int maxlarge = Random.create().nextBetween(minlarge + 2, minlarge + 3);
        int large = Random.create().nextBetween(maxlarge + 6, maxlarge + 10);
        int heightCap = Random.create().nextBetween(3, maxlarge);

        if (!worldAccess.getBlockState(pos.down()).isIn(BlockTags.DIRT)) return false;
        if (!this.canPlace(worldAccess, random, pos.add(0, height + secondheight, 0), large, heightCap)) return false;

        this.generateLargeCap(worldAccess, random, pos.add(0, height + secondheight, 0), maxlarge, cap, large, heightCap);
        this.generateLargeTrunk(worldAccess, random, pos, trunk, false, height + secondheight - 1, maxlarge, minlarge);


        long endTimeCartesian = (System.nanoTime());
        long durationCartesian = (endTimeCartesian - startTimeCartesian) / 1000000;
        System.out.println("duration : " + durationCartesian + " ms");

        return true;
    }


    public abstract void generateLargeCap(StructureWorldAccess world, Random random, BlockPos pos, int maxlarge, BlockState state, int large, int height);


    public abstract void generateLargeTrunk(StructureWorldAccess world, Random random, BlockPos pos, BlockState trunk, boolean force, int height, int maxlarge, int minlarge);
}
