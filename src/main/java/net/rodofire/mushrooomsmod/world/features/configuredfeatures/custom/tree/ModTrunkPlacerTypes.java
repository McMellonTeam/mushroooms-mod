package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree;

import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.mixin.world.TrunkPlacerTypeInvoker;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree.BlueLuminescentTrunkPlacer;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> BLUE_LUMINESCENT_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("blue_luminescent_trunk_placer", BlueLuminescentTrunkPlacer.codec);

    public static void register() {
        MushrooomsMod.LOGGER.info("Registering Trunkplacers");
    }
}
