package net.rodofire.mushrooomsmod.block.entity.client.model;

import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.entity.TallYellowMushroomsBE;
import software.bernie.geckolib.model.GeoModel;

public class TallYellowMushroomModel extends GeoModel<TallYellowMushroomsBE> {
    @Override
    public Identifier getModelResource(TallYellowMushroomsBE tallYellowMushroomsBE) {
        return Identifier.of(MushrooomsMod.MOD_ID, "geo/tall_yellow_mushrooms.geo.json");
    }

    @Override
    public Identifier getTextureResource(TallYellowMushroomsBE tallYellowMushroomsBE) {
        return Identifier.of(MushrooomsMod.MOD_ID, "textures/block/tall_yellow_mushrooms.png");
    }

    @Override
    public Identifier getAnimationResource(TallYellowMushroomsBE tallYellowMushroomsBE) {
        return Identifier.of(MushrooomsMod.MOD_ID, "animations/tall_yellow_mushrooms.animation.json");
    }
}
