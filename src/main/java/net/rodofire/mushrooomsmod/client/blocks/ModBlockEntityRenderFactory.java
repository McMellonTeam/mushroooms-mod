package net.rodofire.mushrooomsmod.client.blocks;

import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.rodofire.mushrooomsmod.block.ModBlockEntities;
import net.rodofire.mushrooomsmod.block.entity.client.renderer.BoostingMushroomRenderer;
import net.rodofire.mushrooomsmod.block.entity.client.renderer.DangerousBoostingMushroomRenderer;
import net.rodofire.mushrooomsmod.block.entity.client.renderer.ForgeBlockEntityRenderer;
import net.rodofire.mushrooomsmod.block.entity.client.renderer.RapangeFlowerRenderer;

public class ModBlockEntityRenderFactory {
    public static void registerBlockEntities() {
        BlockEntityRendererFactories.register(ModBlockEntities.FORGE_BLOCK_ENTITY, ForgeBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.BOOSTING_MUSHROOM_ENTITY, BoostingMushroomRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.DANGEROUS_BOOSTING_MUSHROOM_ENTITY, DangerousBoostingMushroomRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.RAPANGE_FLOWERS_BLOCK_ENTITY, RapangeFlowerRenderer::new);
    }
}
