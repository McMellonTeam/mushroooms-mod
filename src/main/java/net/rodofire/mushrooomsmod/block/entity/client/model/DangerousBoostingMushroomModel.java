package net.rodofire.mushrooomsmod.block.entity.client.model;

import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.entity.DangerousBoostingMushroomBlockEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class DangerousBoostingMushroomModel extends GeoModel<DangerousBoostingMushroomBlockEntity> {
    @Override
    public Identifier getModelResource(DangerousBoostingMushroomBlockEntity animatable, @Nullable GeoRenderer<DangerousBoostingMushroomBlockEntity> renderer) {
        return Identifier.of(MushrooomsMod.MOD_ID, "geo/mushroom_boost.geo.json");
    }

    @Override
    public Identifier getTextureResource(DangerousBoostingMushroomBlockEntity animatable, @Nullable GeoRenderer<DangerousBoostingMushroomBlockEntity> renderer) {
        return Identifier.of(MushrooomsMod.MOD_ID, "textures/block/mushroom_boost.png");
    }

    @Override
    public Identifier getAnimationResource(DangerousBoostingMushroomBlockEntity animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "animations/mushroom_boost.animation.json");
    }
}
