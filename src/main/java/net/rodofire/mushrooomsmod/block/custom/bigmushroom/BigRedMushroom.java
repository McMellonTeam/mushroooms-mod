package net.rodofire.mushrooomsmod.block.custom.bigmushroom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Optional;

public class BigRedMushroom extends BigMushroom implements Fertilizable {
    private final RegistryKey<ConfiguredFeature<?, ?>> featureKey;

    public BigRedMushroom(Settings settings, RegistryKey<ConfiguredFeature<?, ?>> featureKey) {
        super(settings);
        this.featureKey = featureKey;
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
        System.out.println("try");
        Optional<RegistryEntry.Reference<ConfiguredFeature<?, ?>>> optional = world.getRegistryManager().get(RegistryKeys.CONFIGURED_FEATURE).getEntry(this.featureKey);
        if (optional.isEmpty()) {
            return false;
        }
        world.removeBlock(pos, false);
        if (((ConfiguredFeature) ((RegistryEntry) optional.get()).value()).generate(world, world.getChunkManager().getChunkGenerator(), random, pos)) {
            return true;
        }
        world.setBlockState(pos, state, Block.NOTIFY_ALL);
        return false;
    }
}
