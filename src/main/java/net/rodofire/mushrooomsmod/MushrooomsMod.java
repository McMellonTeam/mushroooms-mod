package net.rodofire.mushrooomsmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.rodofire.mushrooomsmod.block.ModBlockEntities;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.block.BlockUtils;
import net.rodofire.mushrooomsmod.effect.ModStatusEffects;
import net.rodofire.mushrooomsmod.entity.ModEntities;
import net.rodofire.mushrooomsmod.entity.custom.BoleteCowEntity;
import net.rodofire.mushrooomsmod.entity.custom.GrokiEntity;
import net.rodofire.mushrooomsmod.item.ModItems;
import net.rodofire.mushrooomsmod.particle.ModParticles;
import net.rodofire.mushrooomsmod.recipe.ModRecipes;
import net.rodofire.mushrooomsmod.sound.ModSounds;
import net.rodofire.mushrooomsmod.util.ModLootTableModifier;
import net.rodofire.mushrooomsmod.world.gen.ModWorldGeneration;
import net.rodofire.mushrooomsmod.world.tree.ModTrunkPlacerTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MushrooomsMod implements ModInitializer {

    public static final String MOD_ID = "mushrooomsmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        ModBlocks.registerModBlocks();
        ModBlockEntities.registerBlockEntities();
        BlockUtils.registerStripable();
        BlockUtils.registerFlammable();

        ModItems.registerModItems();

        ModParticles.registerParticles();
        ModStatusEffects.registerEffects();

        ModSounds.registerModSound();

        ModTrunkPlacerTypes.register();

        ModWorldGeneration.generateModWorldGen();
        ModLootTableModifier.modifyLootTable();

        ModRecipes.registerRecipes();

        FabricDefaultAttributeRegistry.register(ModEntities.GROKI, GrokiEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.BOLETE_COW, BoleteCowEntity.setAttributes());
        LOGGER.info("Starting MushrooomsMod!");

    }
}