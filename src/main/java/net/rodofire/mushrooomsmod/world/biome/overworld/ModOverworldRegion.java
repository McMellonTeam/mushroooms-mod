package net.rodofire.mushrooomsmod.world.biome.overworld;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class ModOverworldRegion extends Region {
    private VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

    public ModOverworldRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    //https://mcreator.net/wiki/vanilla-biome-settings-data-list
    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        //Sakura Plain
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.NEUTRAL)
                .humidity(MultiNoiseUtil.ParameterRange.of(-0.25f, 0.2f))
                .continentalness(ParameterUtils.Continentalness.MID_INLAND)
                .erosion(ParameterUtils.Erosion.EROSION_6, ParameterUtils.Erosion.EROSION_5)
                .depth(ParameterUtils.Depth.SURFACE)
                .weirdness(ParameterUtils.Weirdness.VALLEY)
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.SAKURA_FOREST));

        //MUSHROOM_SHIRE
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.NEUTRAL)
                .humidity(MultiNoiseUtil.ParameterRange.of(-0.35f, 0.1f))
                .continentalness(ParameterUtils.Continentalness.MUSHROOM_FIELDS, ParameterUtils.Continentalness.FAR_INLAND)
                .erosion(MultiNoiseUtil.ParameterRange.of(-1.0F, -0.6f))
                .depth(ParameterUtils.Depth.SURFACE)
                .weirdness(MultiNoiseUtil.ParameterRange.of(-0.15f, 0.15f))
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.MUSHROOM_SHIRE));

        //MYSTIC_MUSHROGROVE
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(MultiNoiseUtil.ParameterRange.of(-0.3f, 0.2f))
                .humidity(ParameterUtils.Humidity.DRY)
                .continentalness(ParameterUtils.Continentalness.MUSHROOM_FIELDS, ParameterUtils.Continentalness.NEAR_INLAND)
                .erosion(ParameterUtils.Erosion.EROSION_1)
                .depth(ParameterUtils.Depth.SURFACE)
                .weirdness(MultiNoiseUtil.ParameterRange.of(-0.15f, 0.55f))
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.MYSTIC_MUSHROGROVE));


        //GOLDEN_MYCOSHROOM
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.WARM)
                .humidity(ParameterUtils.Humidity.ARID, ParameterUtils.Humidity.DRY)
                .continentalness(ParameterUtils.Continentalness.FAR_INLAND)
                .erosion(ParameterUtils.Erosion.EROSION_3, ParameterUtils.Erosion.EROSION_4)
                .depth(ParameterUtils.Depth.SURFACE)
                .weirdness(ParameterUtils.Weirdness.PEAK_VARIANT)
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.GOLDEN_MYCOSHROOM));


        //colorful plains
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.NEUTRAL)
                .humidity(ParameterUtils.Humidity.NEUTRAL)
                .continentalness(ParameterUtils.Continentalness.INLAND)
                .erosion(MultiNoiseUtil.ParameterRange.of(-0.4f, 0.15f))
                .depth(ParameterUtils.Depth.SURFACE)
                .weirdness(MultiNoiseUtil.ParameterRange.of(-1f, -0.45f))
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.COLORFUL_PLAINS));

        //colorful forest
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.NEUTRAL)
                .humidity(ParameterUtils.Humidity.NEUTRAL)
                .continentalness(ParameterUtils.Continentalness.INLAND)
                .erosion(ParameterUtils.Erosion.EROSION_5, ParameterUtils.Erosion.EROSION_4)
                .depth(ParameterUtils.Depth.SURFACE)
                .weirdness(MultiNoiseUtil.ParameterRange.of(-1f, 0.05f))
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.COLORFUL_FOREST));

        //blue mushroom forest
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.NEUTRAL)
                .humidity(ParameterUtils.Humidity.WET)
                .continentalness(ParameterUtils.Continentalness.INLAND)
                .erosion(ParameterUtils.Erosion.EROSION_3)
                .depth(ParameterUtils.Depth.SURFACE)
                .weirdness(MultiNoiseUtil.ParameterRange.of(-1f, 0.05f))
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.BLUE_MUSHROOM_FOREST));

        builder.build().forEach(mapper);
    }

}
