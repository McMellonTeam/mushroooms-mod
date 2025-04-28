package net.rodofire.mushrooomsmod.block.entity.client.model;

import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.entity.DangerousBoostingMushroomBE;
import software.bernie.geckolib.model.GeoModel;

public class DangerousBoostingMushroomModel extends GeoModel<DangerousBoostingMushroomBE> {
    @Override
    public Identifier getModelResource(DangerousBoostingMushroomBE animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "geo/mushroom_boost.geo.json");
    }

    @Override
    public Identifier getTextureResource(DangerousBoostingMushroomBE animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "textures/block/mushroom_boost.png");
    }

    @Override
    public Identifier getAnimationResource(DangerousBoostingMushroomBE animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "animations/mushroom_boost.animation.json");
    }
}
