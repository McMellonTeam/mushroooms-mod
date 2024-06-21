package net.rodofire.mushrooomsmod.block.entity.client.renderer;

import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.rodofire.mushrooomsmod.block.entity.DangerousBoostingMushroomBlockEntity;
import net.rodofire.mushrooomsmod.block.entity.client.model.BoostingMushroomModel;
import net.rodofire.mushrooomsmod.block.entity.client.model.DangerousBoostingMushroomModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.GeoRenderer;

public class DangerousBoostingMushroomRenderer extends GeoBlockRenderer<DangerousBoostingMushroomBlockEntity> {

    public DangerousBoostingMushroomRenderer(BlockEntityRendererFactory.Context context) {
        super(new DangerousBoostingMushroomModel());
    }
}
