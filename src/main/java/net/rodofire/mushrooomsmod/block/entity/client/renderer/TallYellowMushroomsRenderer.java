package net.rodofire.mushrooomsmod.block.entity.client.renderer;

import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.rodofire.mushrooomsmod.block.entity.TallYellowMushroomsBE;
import net.rodofire.mushrooomsmod.block.entity.client.model.TallYellowMushroomModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class TallYellowMushroomsRenderer extends GeoBlockRenderer<TallYellowMushroomsBE> {
    public TallYellowMushroomsRenderer(BlockEntityRendererFactory.Context context) {
        super(new TallYellowMushroomModel());
    }
}
