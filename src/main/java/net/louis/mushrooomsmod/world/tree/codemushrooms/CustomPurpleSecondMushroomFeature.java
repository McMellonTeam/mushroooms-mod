package net.louis.mushrooomsmod.world.tree.codemushrooms;

import com.mojang.serialization.Codec;
import net.louis.mushrooomsmod.feature.mushroomfeature.ModMushroomFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeMushroomFeature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public abstract class CustomPurpleSecondMushroomFeature extends Feature<ModMushroomFeatureConfig> {
    public CustomPurpleSecondMushroomFeature(Codec<ModMushroomFeatureConfig> codec) {
        super(codec);
    }

    protected void generateStem(WorldAccess world, Random random, BlockPos pos, BlockPos start, ModMushroomFeatureConfig config, int height, BlockPos.Mutable mutablePos, BlockPos.Mutable mutable) {
        for (int i = 0; i < height; ++i) {
            mutablePos.set(pos).move(Direction.UP, i);
            if (world.getBlockState(mutablePos).isOpaqueFullCube(world, mutablePos)) continue;
            this.setBlockState(world, mutablePos, config.stemProvider.get(random, pos));
            if (i == height-3){
                mutable.set(start, 0, i, -1);
                this.setBlockState(world, mutable, config.stemProvider.get(random, pos));
            }
            if(i== height - 2){
                mutable.set(start, 0, i, -1);
                this.setBlockState(world, mutable, config.stemProvider.get(random, pos));
                mutable.set(start, -1, i, 0);
                this.setBlockState(world, mutable, config.stemProvider.get(random, pos));
                mutable.set(start, 1, i, 0);
                this.setBlockState(world, mutable, config.stemProvider.get(random, pos));
            }
            if (i == height-1){
                mutable.set(start, 0, i, 1);
                this.setBlockState(world, mutable, config.stemProvider.get(random, pos));
                mutable.set(start, -1, i, 0);
                this.setBlockState(world, mutable, config.stemProvider.get(random, pos));
                mutable.set(start, 1, i, 0);
                this.setBlockState(world, mutable, config.stemProvider.get(random, pos));
                mutable.set(start, 0, i, -1);
                this.setBlockState(world, mutable, config.stemProvider.get(random, pos));
                mutable.set(start, -1, i, -1);
                this.setBlockState(world, mutable, config.stemProvider.get(random, pos));
                mutable.set(start, -1, i, -1);
                this.setBlockState(world, mutable, config.stemProvider.get(random, pos));
            }
        }
    }

    protected int getHeight(Random random) {
        int i = random.nextInt(5) + 4;
        if (random.nextInt(14) == 0) {
            i *= 2;
        }
        return i;
    }

    protected boolean canGenerate(WorldAccess world, BlockPos pos, int height, BlockPos.Mutable mutablePos, ModMushroomFeatureConfig config) {
        int i = pos.getY();
        if (i < world.getBottomY() + 1 || i + height + 1 >= world.getTopY()) {
            return false;
        }
        BlockState blockState = world.getBlockState(pos.down());
        if (!HugeMushroomFeature.isSoil(blockState) && !blockState.isIn(BlockTags.MUSHROOM_GROW_BLOCK)) {
            return false;
        }
        for (int j = 0; j <= height; ++j) {
            int k = this.getCapSize(-1, -1, config.foliageRadius, j);
            for (int l = -k; l <= k; ++l) {
                for (int m = -k; m <= k; ++m) {
                    BlockState blockState2 = world.getBlockState(mutablePos.set(pos, l, j, m));
                    if (blockState2.isAir() || blockState2.isIn(BlockTags.LEAVES)) continue;
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean generate(FeatureContext<ModMushroomFeatureConfig> context) {
        BlockPos.Mutable mutable;
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        Random random = context.getRandom();
        ModMushroomFeatureConfig modMushroomFeatureConfig = context.getConfig();
        int i = this.getHeight(random);
        if (!this.canGenerate(structureWorldAccess, blockPos, i, mutable = new BlockPos.Mutable(), modMushroomFeatureConfig)) {
            return false;
        }
        int z = modMushroomFeatureConfig.foliageRadius;

        Integer[] coordinates =  placeTrunk(structureWorldAccess, random , blockPos, i,   mutable , modMushroomFeatureConfig );
        generateCap(structureWorldAccess,random,blockPos, mutable,coordinates,modMushroomFeatureConfig);
        return true;
    }
    protected abstract Integer[] placeTrunk(WorldAccess world, Random random, BlockPos start, int y, BlockPos.Mutable mutable, ModMushroomFeatureConfig config) ;
    protected abstract void placeBranch(WorldAccess world, BlockPos pos, BlockPos.Mutable mutable ,  int dx, int dy, int dz, int a);
    protected abstract int getCapSize(int var1, int var2, int var3, int var4);

    protected abstract void generateCap(WorldAccess var1, Random var2, BlockPos var3,  BlockPos.Mutable var5,  Integer[]coordinates, ModMushroomFeatureConfig config);
    protected abstract void generateSecondCap(WorldAccess var1, Random var2, BlockPos var3, int var4, BlockPos.Mutable var5, ModMushroomFeatureConfig var6, int var7);
    protected abstract void generateBottomCap(WorldAccess var1, Random var2, BlockPos var3, int var4, BlockPos.Mutable var5, ModMushroomFeatureConfig var6, int var7);
}

