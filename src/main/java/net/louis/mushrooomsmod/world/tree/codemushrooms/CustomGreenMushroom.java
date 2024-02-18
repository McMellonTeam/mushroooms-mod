package net.louis.mushrooomsmod.world.tree.codemushrooms;

import com.mojang.serialization.Codec;
import net.louis.mushrooomsmod.feature.mushroomfeature.ModMushroomFeatureConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public abstract class CustomGreenMushroom extends Feature<ModMushroomFeatureConfig> {
    public CustomGreenMushroom(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }
    protected boolean canGenerate(WorldAccess world, BlockPos pos, int height, BlockPos.Mutable mutablePos, ModMushroomFeatureConfig config) {
        return true;
    }

    @Override
    public boolean generate(FeatureContext<ModMushroomFeatureConfig> context) {
        BlockPos.Mutable mutable;
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        Random random = context.getRandom();
        ModMushroomFeatureConfig modMushroomFeatureConfig = context.getConfig();
        int height = modMushroomFeatureConfig.foliageRadius;

        if(!canGenerate(structureWorldAccess,blockPos,height,mutable= new BlockPos.Mutable(), modMushroomFeatureConfig)) return false;
        Integer[] coordinates = trunkPlace(blockPos,mutable,structureWorldAccess,modMushroomFeatureConfig);
        capPlacer(blockPos,mutable,structureWorldAccess,modMushroomFeatureConfig,coordinates);





        return true;
    }
    protected abstract Integer[] trunkPlace(BlockPos start, BlockPos.Mutable mutable, WorldAccess world, ModMushroomFeatureConfig config);
    protected abstract void capPlacer(BlockPos start, BlockPos.Mutable mutable, WorldAccess world, ModMushroomFeatureConfig config, Integer[] coordinates);
}
