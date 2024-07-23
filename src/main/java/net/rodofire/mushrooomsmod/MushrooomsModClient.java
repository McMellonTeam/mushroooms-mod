package net.rodofire.mushrooomsmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.rodofire.mushrooomsmod.block.ModBlockEntities;
import net.rodofire.mushrooomsmod.block.entity.client.renderer.BoostingMushroomRenderer;
import net.rodofire.mushrooomsmod.block.entity.client.renderer.DangerousBoostingMushroomRenderer;
import net.rodofire.mushrooomsmod.block.entity.client.renderer.ForgeBlockEntityRenderer;
import net.rodofire.mushrooomsmod.block.entity.client.renderer.RapangeFlowerRenderer;
import net.rodofire.mushrooomsmod.client.HammerHUDOverlay;
import net.rodofire.mushrooomsmod.client.ModBlockRenderType;
import net.rodofire.mushrooomsmod.client.ModColor;
import net.rodofire.mushrooomsmod.entity.ModEntities;
import net.rodofire.mushrooomsmod.entity.client.renderer.*;
import net.rodofire.mushrooomsmod.networking.ModNetwork;
import net.rodofire.mushrooomsmod.particle.ModParticles;
import net.rodofire.mushrooomsmod.particle.custom.GreenfireParticle;

public class MushrooomsModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModNetwork.registerS2CPackets();


        ModColor.createBlockColors();
        ModColor.createItemColors();

        HudRenderCallback.EVENT.register(new HammerHUDOverlay());



        //Blocks
        ModBlockRenderType.createCutoutBlocks();
        ModBlockRenderType.createTransludentBlocks();

        //Entity
        EntityRendererRegistry.register(ModEntities.GROKI, GrokiRenderer::new);
        EntityRendererRegistry.register(ModEntities.BOLETE_COW, BoleteCowRenderer::new);
        EntityRendererRegistry.register(ModEntities.PLOTI, PlotiRenderer::new);
        EntityRendererRegistry.register(ModEntities.CRYSTAL_CREEPER, CrystalCreeperRenderer::new);
        EntityRendererRegistry.register(ModEntities.CRYSTAL_GOLEM, CrystalGolemRenderer::new);
        EntityRendererRegistry.register(ModEntities.SCHROOM_STICK, SchroomStickRenderer::new);
        EntityRendererRegistry.register(ModEntities.INVENTORY_ARMOR_STAND_ENTITY, InventoryArmorStandRenderer::new);

        //Block Entity
        BlockEntityRendererFactories.register(ModBlockEntities.FORGE_BLOCK_ENTITY, ForgeBlockEntityRenderer::new);

        BlockEntityRendererFactories.register(ModBlockEntities.BOOSTING_MUSHROOM_ENTITY, BoostingMushroomRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.DANGEROUS_BOOSTING_MUSHROOM_ENTITY, DangerousBoostingMushroomRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.RAPANGE_FLOWERS_BLOCK_ENTITY, RapangeFlowerRenderer::new);


        //Particle
        ParticleFactoryRegistry.getInstance().register(ModParticles.GREENFIRE_PARTICLE, GreenfireParticle.Factory::new);
    }

}
