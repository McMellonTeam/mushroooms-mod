package net.rodofire.mushrooomsmod.block.entity.client.renderer;

import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.rodofire.mushrooomsmod.block.entity.BoostingMushroomBE;
import net.rodofire.mushrooomsmod.block.entity.client.model.BoostingMushroomModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class BoostingMushroomRenderer extends GeoBlockRenderer<BoostingMushroomBE> {
    public BoostingMushroomRenderer(BlockEntityRendererFactory.Context context) {
        super(new BoostingMushroomModel());
    }
}
