package net.rodofire.mushrooomsmod.block.entity.client.renderer;

import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.rodofire.mushrooomsmod.block.entity.RapangeFlowersBlockEntity;
import net.rodofire.mushrooomsmod.block.entity.client.model.RapangeFlowerModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class RapangeFlowerRenderer extends GeoBlockRenderer<RapangeFlowersBlockEntity> {

    public RapangeFlowerRenderer(BlockEntityRendererFactory.Context context) {
        super(new RapangeFlowerModel());
    }
}
