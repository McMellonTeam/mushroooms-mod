package net.rodofire.mushrooomsmod.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class ModMushroomFeatureConfig implements FeatureConfig {
    public static final Codec<ModMushroomFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> {
        MapCodec<BlockStateProvider> capProviderCodec = BlockStateProvider.TYPE_CODEC.fieldOf("cap_provider");
        MapCodec<BlockStateProvider> secondCapProviderCodec = BlockStateProvider.TYPE_CODEC.fieldOf("second_cap_provider");
        MapCodec<BlockStateProvider> stemProviderCodec = BlockStateProvider.TYPE_CODEC.fieldOf("stem_provider");
        MapCodec<Integer> foliageRadiusCodec = Codec.INT.fieldOf("foliage_radius");

        return instance.group(
                capProviderCodec.forGetter(config -> config.capProvider),
                secondCapProviderCodec.forGetter(config -> config.secondcapProvider),
                stemProviderCodec.forGetter(config -> config.stemProvider),
                foliageRadiusCodec.forGetter(config -> config.foliageRadius)
        ).apply(instance, ModMushroomFeatureConfig::new);
    });


    //public static final Codec<ModMushroomFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(((MapCodec) BlockStateProvider.TYPE_CODEC.fieldOf("cap_provider")).forGetter(ModMuchroomFeatureConfig -> ModMuchroomFeatureConfig.capProvider), ((MapCodec)BlockStateProvider.TYPE_CODEC.fieldOf("second_cap_provider")).forGetter(ModMuchroomFeatureConfig -> ModMuchroomFeatureConfig.secondcapProvider), ((MapCodec)BlockStateProvider.TYPE_CODEC.fieldOf("stem_provider")).forGetter(ModMuchroomFeatureConfig -> ModMuchroomFeatureConfig.stemProvider), ((MapCodec)Codec.INT.fieldOf("foliage_radius")).orElse(2).forGetter(ModMuchroomFeatureConfig -> ModMuchroomFeatureConfig.foliageRadius)).apply((Applicative<ModMushroomFeatureConfig, ?>)instance, HugeMushroomFeatureConfig::new));
    public final BlockStateProvider capProvider;
    public final BlockStateProvider secondcapProvider;
    public final BlockStateProvider stemProvider;
    public final int foliageRadius;

    public ModMushroomFeatureConfig(BlockStateProvider capProvider, BlockStateProvider secondcapProvider, BlockStateProvider stemProvider, int foliageRadius) {
        this.capProvider = capProvider;
        this.stemProvider = stemProvider;
        this.foliageRadius = foliageRadius;
        this.secondcapProvider = secondcapProvider;
    }
}

