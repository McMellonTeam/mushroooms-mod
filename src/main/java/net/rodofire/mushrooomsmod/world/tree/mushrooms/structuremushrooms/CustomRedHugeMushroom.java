package net.rodofire.mushrooomsmod.world.tree.mushrooms.structuremushrooms;

import com.mojang.serialization.Codec;
import net.rodofire.mushrooomsmod.feature.mushroomfeature.ModMushroomFeatureConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public abstract class CustomRedHugeMushroom extends Feature<ModMushroomFeatureConfig> {
    public CustomRedHugeMushroom(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<ModMushroomFeatureConfig> context) {
        BlockPos.Mutable mutable= new BlockPos.Mutable();
        BlockPos blockPos = context.getOrigin();
        StructureWorldAccess structureWorldAccess = context.getWorld();
        Random random = context.getRandom();

        int large;
        int height = Random.create().nextBetween(5,9);

        ModMushroomFeatureConfig modMushroomFeatureConfig = context.getConfig();

        if (height<7)large = Random.create().nextBetween(1,2);
        else large =Random.create().nextBetween(2,3);

        Integer[] coordinates = trunkPlace(blockPos,large,mutable,structureWorldAccess,modMushroomFeatureConfig, random);

        if (coordinates.length==1)return false;

        capPlacer(blockPos,large,mutable,structureWorldAccess,modMushroomFeatureConfig,coordinates,random);
        return true;
    }
    protected abstract Integer[] trunkPlace(BlockPos start,int large, BlockPos.Mutable mutable, WorldAccess world, ModMushroomFeatureConfig config, Random random);
    protected abstract boolean capPlacer(BlockPos start,int large,  BlockPos.Mutable mutable, WorldAccess world, ModMushroomFeatureConfig config, Integer[] coordinates,Random random);
}
