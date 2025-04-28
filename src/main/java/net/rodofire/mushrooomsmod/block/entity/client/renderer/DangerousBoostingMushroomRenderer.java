package net.rodofire.mushrooomsmod.block.entity.client.renderer;

import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.rodofire.mushrooomsmod.block.entity.DangerousBoostingMushroomBE;
import net.rodofire.mushrooomsmod.block.entity.client.model.DangerousBoostingMushroomModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class DangerousBoostingMushroomRenderer extends GeoBlockRenderer<DangerousBoostingMushroomBE> {

    public DangerousBoostingMushroomRenderer(BlockEntityRendererFactory.Context context) {
        super(new DangerousBoostingMushroomModel());
    }
}
