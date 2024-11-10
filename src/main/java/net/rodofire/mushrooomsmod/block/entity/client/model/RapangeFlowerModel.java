package net.rodofire.mushrooomsmod.block.entity.client.model;

import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.entity.RapangeFlowersBlockEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class RapangeFlowerModel extends GeoModel<RapangeFlowersBlockEntity> {

    @Override
    public Identifier getModelResource(RapangeFlowersBlockEntity animatable, @Nullable GeoRenderer<RapangeFlowersBlockEntity> renderer) {
        return Identifier.of(MushrooomsMod.MOD_ID, "geo/rapange_flower.geo.json");
    }

    @Override
    public Identifier getTextureResource(RapangeFlowersBlockEntity animatable, @Nullable GeoRenderer<RapangeFlowersBlockEntity> renderer) {
        return Identifier.of(MushrooomsMod.MOD_ID, "textures/block/rapange_flowers.png");
    }

    @Override
    public Identifier getAnimationResource(RapangeFlowersBlockEntity animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "animations/rapange_flower.animation.json");
    }
}
