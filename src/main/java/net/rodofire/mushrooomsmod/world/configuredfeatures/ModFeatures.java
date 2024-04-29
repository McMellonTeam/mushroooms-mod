package net.rodofire.mushrooomsmod.world.configuredfeatures;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.feature.*;
import net.rodofire.mushrooomsmod.feature.mushroomfeature.ModMushroomFeatureConfig;
import net.rodofire.mushrooomsmod.world.configuredfeatures.custom.BlueLuminescentVinesFeature;
import net.rodofire.mushrooomsmod.world.configuredfeatures.custom.BushFeature;
import net.rodofire.mushrooomsmod.world.configuredfeatures.custom.ColorfulBushFeature;
import net.rodofire.mushrooomsmod.world.mushrooms.HugeBlueMushroom.HugeBlueMushroomFeature;
import net.rodofire.mushrooomsmod.world.mushrooms.codemushrooms.*;
import net.rodofire.mushrooomsmod.world.mushrooms.structuremushrooms.CustomGreenSecondMushroomFeature;
import net.rodofire.mushrooomsmod.world.mushrooms.structuremushrooms.CustomRedHugeMushroomFeature;

public abstract class ModFeatures <FC extends FeatureConfig> {

    //Huge mushroom features
    public static Feature<HugeMushroomFeatureConfig> HUGE_BLUE_MUSHROOM;
    public static Feature<HugeMushroomFeatureConfig>HUGE_PURPLE_MUSHROOM;
    public static Feature<ModMushroomFeatureConfig>HUGE_GREEN_MUSHROOM ;
    public static Feature<HugeMushroomFeatureConfig>HUGE_BLUE_LUMINESCENT_MUSHROOM;
    public static Feature<HugeMushroomFeatureConfig>HUGE_LUMINESCENT_PINK_MUSHROOM;
    public static Feature<ModMushroomFeatureConfig>HUGE_BIG_PURPLE_MUSHROOM;
    public static Feature<HugeMushroomFeatureConfig>HUGE_BIG_GREEN_MUSHROOM;
    public static Feature<ModMushroomFeatureConfig>HUGE_BIG_RED_MUSHROOM;
    public static Feature<HugeMushroomFeatureConfig>HUGE_BIG_ORANGE_MUSHROOM;
    public static Feature<HugeMushroomFeatureConfig>HUGE_BIG_YELLOW_MUSHROOM;

    //Vines Features;
    public static  Feature<TwistingVinesFeatureConfig> BLUE_LUMINESCENT_VINES;

    //Bush;
    public static  Feature<DefaultFeatureConfig> BUSH;
    public static  Feature<DefaultFeatureConfig> COLORFUL_BUSH;

    public static void addFeatures(){
        HUGE_BLUE_MUSHROOM = registercustomfeature("huge_blue_mushroom", new HugeBlueMushroomFeature(HugeMushroomFeatureConfig.CODEC));
        HUGE_PURPLE_MUSHROOM = registercustomfeature("huge_purple_mushroom", new CustomPurpleMushroomFeature(HugeMushroomFeatureConfig.CODEC));
        HUGE_GREEN_MUSHROOM = registercustomfeature("huge_green_mushroom", new CustomGreenMushroomFeature(ModMushroomFeatureConfig.CODEC));
        HUGE_BLUE_LUMINESCENT_MUSHROOM = registercustomfeature("huge_blue_luminescent_mushroom", new CustomLuminescentBlueMushroomFeature(HugeMushroomFeatureConfig.CODEC));
        HUGE_LUMINESCENT_PINK_MUSHROOM = registercustomfeature("huge_luminescent_pink_mushroom", new CustomLuminescentPinkMushroomFeature(HugeMushroomFeatureConfig.CODEC));
        HUGE_BIG_PURPLE_MUSHROOM = registercustomfeature("huge_big_purple_mushroom_feature", new CustomPurpleSecondMushroompFeature(ModMushroomFeatureConfig.CODEC));
        HUGE_BIG_GREEN_MUSHROOM = registercustomfeature("huge_big_green_mushroom_feature", new CustomGreenSecondMushroomFeature(HugeMushroomFeatureConfig.CODEC));
        HUGE_BIG_RED_MUSHROOM = registercustomfeature("huge_red_red_mushroom_feature", new CustomRedHugeMushroomFeature(ModMushroomFeatureConfig.CODEC));
        HUGE_BIG_ORANGE_MUSHROOM = registercustomfeature("huge_orange_mushroom_feature", new CustomOrangeMushroomFeature(HugeMushroomFeatureConfig.CODEC));
        HUGE_BIG_YELLOW_MUSHROOM = registercustomfeature("huge_yellow_mushroom_feature", new CustomYellowMushroomFeature(HugeMushroomFeatureConfig.CODEC));
        BLUE_LUMINESCENT_VINES = registercustomfeature("blue_luminescent_vines_feature", new BlueLuminescentVinesFeature(TwistingVinesFeatureConfig.CODEC));
        BUSH = registercustomfeature("bush_feature", new BushFeature(DefaultFeatureConfig.CODEC));
        COLORFUL_BUSH = registercustomfeature("colorful_bush_feature", new ColorfulBushFeature(DefaultFeatureConfig.CODEC));
    }

    private static <C extends FeatureConfig, F extends Feature<C>> F registercustomfeature(String name, F feature) {
        return (F) Registry.register(Registries.FEATURE, name, feature);
    }
}
