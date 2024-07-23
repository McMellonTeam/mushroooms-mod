package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
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

    public boolean canGenerate(FeatureContext<ModMushroomFeatureConfig> context) {
        return false;
    }

    @Override
    public boolean generate(FeatureContext<ModMushroomFeatureConfig> context) {
        long startTimeCartesian = System.nanoTime();

        StructureWorldAccess worldAccess = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random random = context.getRandom();
        BlockState cap = context.getConfig().capProvider.get(random, pos);
        BlockState trunk = context.getConfig().stemProvider.get(random, pos);
        int height = Random.create().nextBetween(10, 15);
        int secondheight = 0;
        if (Random.create().nextBoolean()) {
            secondheight = Random.create().nextBetween(2, 5);
        }
        int minlarge = Random.create().nextBetween(2, 3);
        int maxlarge = Random.create().nextBetween(minlarge + 2, minlarge + 3);

        this.generateLargeCap(worldAccess, random, pos.add(0, height + secondheight, 0), maxlarge, cap);
        this.generateLargeTrunk(worldAccess, random, pos, trunk, false, height + secondheight, maxlarge, minlarge);


        long endTimeCartesian = (System.nanoTime());
        long durationCartesian = (endTimeCartesian - startTimeCartesian) / 1000000;
        System.out.println("duration : " + durationCartesian + " ms");

        return true;
    }


    public abstract void generateLargeCap(StructureWorldAccess world, Random random, BlockPos pos, int maxlarge, BlockState state);


    public abstract void generateLargeTrunk(StructureWorldAccess world, Random random, BlockPos pos, BlockState trunk, boolean force, int height, int maxlarge, int minlarge);
}
