package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree;

import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.mixin.world.FoliagePlacerTypeInvoker;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree.BlueLuminescentFoliagePlacer;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<BlueLuminescentFoliagePlacer> BLUE_LUMINESCENT_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("blue_luminescent_foliage_placer", BlueLuminescentFoliagePlacer.CODEC);

    public static void register() {
        MushrooomsMod.LOGGER.info("Registering Trunkplacers");
    }
}
