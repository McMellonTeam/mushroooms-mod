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
        StructureWorldAccess worldAccess = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random random = context.getRandom();
        BlockState state = context.getConfig().capProvider.get(random, pos);
        boolean bigmushroom = false;
        if (Random.create().nextBetween(0, 5) == 0) {

        }


        return false;
    }

    public abstract void generateCap(StructureWorldAccess world, Random random, BlockPos pos, ModMushroomFeatureConfig config);

    public abstract void generateLargeCap(StructureWorldAccess world, Random random, BlockPos pos, ModMushroomFeatureConfig config);

    public abstract void generateTrunk(StructureWorldAccess world, Random random, BlockPos pos, ModMushroomFeatureConfig config, BlockState trunk, boolean force);

    public abstract void generateLargeTrunk(StructureWorldAccess world, Random random, BlockPos pos, ModMushroomFeatureConfig config, BlockState trunk, boolean force, int height, int maxlarge, int minlarge);
}
