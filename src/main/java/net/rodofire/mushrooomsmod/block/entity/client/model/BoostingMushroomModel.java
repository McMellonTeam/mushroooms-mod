package net.rodofire.mushrooomsmod.block.entity.client.model;

import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.entity.BoostingMushroomBlockEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class BoostingMushroomModel extends GeoModel<BoostingMushroomBlockEntity> {
    @Override
    public Identifier getModelResource(BoostingMushroomBlockEntity animatable, @Nullable GeoRenderer<BoostingMushroomBlockEntity> renderer) {
        return Identifier.of(MushrooomsMod.MOD_ID, "geo/mushroom_boost.geo.json");
    }

    @Override
    public Identifier getTextureResource(BoostingMushroomBlockEntity animatable, @Nullable GeoRenderer<BoostingMushroomBlockEntity> renderer) {
        return Identifier.of(MushrooomsMod.MOD_ID, "textures/block/mushroom_boost.png");
    }

    @Override
    public Identifier getAnimationResource(BoostingMushroomBlockEntity animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "animations/mushroom_boost.animation.json");
    }
}
