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
    public ModOverworldRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    //https://mcreator.net/wiki/vanilla-biome-settings-data-list
    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
        //Blue Luminescent Schroom Cave
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.ICY)
                .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.WET))
                .continentalness(ParameterUtils.Continentalness.DEEP_OCEAN, ParameterUtils.Continentalness.OCEAN)
                .erosion(ParameterUtils.Erosion.EROSION_0, ParameterUtils.Erosion.EROSION_1)
                .depth(ParameterUtils.Depth.UNDERGROUND)
                .weirdness(ParameterUtils.Weirdness.FULL_RANGE)
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.BLUE_LUMINESCENT_SHROOM_CAVE));

        //Purple Schroom Cave
        /*new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.NEUTRAL,ParameterUtils.Temperature.WARM))
                    .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.WET))
                        .continentalness(ParameterUtils.Continentalness.DEEP_OCEAN)
                            .erosion(ParameterUtils.Erosion.EROSION_1,ParameterUtils.Erosion.EROSION_2, ParameterUtils.Erosion.EROSION_3)
                                .depth(ParameterUtils.Depth.UNDERGROUND)
                                    .weirdness(ParameterUtils.Weirdness.MID_SLICE_NORMAL_ASCENDING, ParameterUtils.Weirdness.MID_SLICE_NORMAL_DESCENDING)
                                        .build().forEach(point -> builder.add(point, ModOverworldBiomes.PURPLE_SHROOM_CAVE));*/

        //Vanilla Cave
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.COOL, ParameterUtils.Temperature.NEUTRAL))
                .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.HUMID))
                .continentalness(MultiNoiseUtil.ParameterRange.of(0.03f, 0.55f))
                .erosion(ParameterUtils.Erosion.EROSION_0, ParameterUtils.Erosion.EROSION_1)
                .depth(ParameterUtils.Depth.UNDERGROUND)
                .weirdness(MultiNoiseUtil.ParameterRange.of(-0.7f, 1.0f))
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.VANILLA_SHROOM_CAVE));

        //Magical Plain
        /*new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.ICY, ParameterUtils.Temperature.FROZEN))
                    .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.WET))
                        .continentalness(ParameterUtils.Continentalness.INLAND, ParameterUtils.Continentalness.DEEP_OCEAN, ParameterUtils.Continentalness.OCEAN,ParameterUtils.Continentalness.COAST)
                            .erosion(ParameterUtils.Erosion.EROSION_0, ParameterUtils.Erosion.EROSION_1,ParameterUtils.Erosion.EROSION_2)
                                .depth(ParameterUtils.Depth.SURFACE)
                                    .weirdness(ParameterUtils.Weirdness.MID_SLICE_NORMAL_ASCENDING, ParameterUtils.Weirdness.MID_SLICE_NORMAL_DESCENDING)
                                        .build().forEach(point -> builder.add(point, ModOverworldBiomes.MAGICAL_PLAIN));*/

        //Crystal Cave
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.HOT)
                .humidity(ParameterUtils.Humidity.NEUTRAL)
                .continentalness(ParameterUtils.Continentalness.MID_INLAND)
                .erosion(ParameterUtils.Erosion.EROSION_3)
                .depth(ParameterUtils.Depth.UNDERGROUND)
                .weirdness(MultiNoiseUtil.ParameterRange.of(0.03f, 0.55f))
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.CRYSTAL_CAVE));

        //Forest Cave
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.HOT)
                .humidity(ParameterUtils.Humidity.DRY, ParameterUtils.Humidity.NEUTRAL)
                .continentalness(ParameterUtils.Continentalness.FAR_INLAND)
                .erosion(MultiNoiseUtil.ParameterRange.of(-1f, 0f))
                .depth(ParameterUtils.Depth.UNDERGROUND)
                .weirdness(MultiNoiseUtil.ParameterRange.of(-1f, 0.05f))
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.FOREST_CAVE));

        //Shroom Island
        /*new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.HOT)
                .humidity(ParameterUtils.Humidity.DRY)
                .continentalness(ParameterUtils.Continentalness.MUSHROOM_FIELDS, ParameterUtils.Continentalness.NEAR_INLAND)
                .erosion(ParameterUtils.Erosion.EROSION_0)
                .depth(ParameterUtils.Depth.UNDERGROUND)
                .weirdness(MultiNoiseUtil.ParameterRange.of(-1f, 0f))
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.SHROOM_ISLAND1));

        //Shroom Island 2
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.HOT)
                .humidity(ParameterUtils.Humidity.DRY)
                .continentalness(ParameterUtils.Continentalness.MUSHROOM_FIELDS, ParameterUtils.Continentalness.NEAR_INLAND)
                .erosion(ParameterUtils.Erosion.EROSION_0)
                .depth(ParameterUtils.Depth.UNDERGROUND)
                .weirdness(MultiNoiseUtil.ParameterRange.of(0f, 1f))
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.SHROOM_ISLAND2));*/

        //colorful plains
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.NEUTRAL)
                .humidity(ParameterUtils.Humidity.WET)
                .continentalness(ParameterUtils.Continentalness.INLAND)
                .erosion(MultiNoiseUtil.ParameterRange.of(-1f, 0f))
                .depth(ParameterUtils.Depth.SURFACE)
                .weirdness(MultiNoiseUtil.ParameterRange.of(-1f, 0.05f))
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.COLORFUL_PLAINS));

        builder.build().forEach(mapper);
    }
}
