package net.louis.mushrooomsmod.block.bigmushroom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.ShapeContext;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Optional;

public class TinyPurpleMushroom extends BigMushroom implements Fertilizable {
    private final RegistryKey<ConfiguredFeature<?, ?>> featureKey;
    public TinyPurpleMushroom(Settings settings,  RegistryKey<ConfiguredFeature<?, ?>> featureKey) {
        super(settings);
        this.featureKey=featureKey;
    }
    public static final VoxelShape SHAPE = Block.createCuboidShape(5f,0f,5f,10f,5f,10f);
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context){
        return SHAPE;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        this.trySpawningBigMushroom(world, pos, state, random);
    }
    public boolean trySpawningBigMushroom(ServerWorld world, BlockPos pos, BlockState state, Random random) {
        Optional<RegistryEntry.Reference<ConfiguredFeature<?, ?>>> optional = world.getRegistryManager().get(RegistryKeys.CONFIGURED_FEATURE).getEntry(this.featureKey);
        if (optional.isEmpty()) {
            return false;
        }
        world.removeBlock(pos, false);
        if (((ConfiguredFeature)((RegistryEntry)optional.get()).value()).generate(world, world.getChunkManager().getChunkGenerator(), random, pos)) {
            return true;
        }
        world.setBlockState(pos, state, Block.NOTIFY_ALL);
        return false;
    }
}
