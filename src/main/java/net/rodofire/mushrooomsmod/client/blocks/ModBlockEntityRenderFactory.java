package net.rodofire.mushrooomsmod.client.blocks;

import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.rodofire.mushrooomsmod.block.ModBlockEntities;
import net.rodofire.mushrooomsmod.block.entity.client.renderer.*;

public class ModBlockEntityRenderFactory {
    public static void registerBlockEntities() {
        BlockEntityRendererFactories.register(ModBlockEntities.FORGE_BLOCK, ForgeBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.BOOSTING_MUSHROOM, BoostingMushroomRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.DANGEROUS_BOOSTING_MUSHROOM, DangerousBoostingMushroomRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.RAPANGE_FLOWERS_BLOCK, RapangeFlowerRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.TALL_YELLOW_MUSHROOMS, TallYellowMushroomsRenderer::new);
    }
}
