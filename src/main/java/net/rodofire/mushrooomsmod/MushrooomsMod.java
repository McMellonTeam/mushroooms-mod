package net.rodofire.mushrooomsmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.rodofire.mushrooomsmod.block.BlockUtils;
import net.rodofire.mushrooomsmod.block.ModBlockEntities;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.configs.ModConfig;
import net.rodofire.mushrooomsmod.effect.ModStatusEffects;
import net.rodofire.mushrooomsmod.entity.ModEntities;
import net.rodofire.mushrooomsmod.entity.ModEntitiesAttribute;
import net.rodofire.mushrooomsmod.event.PlayerTickHandler;
import net.rodofire.mushrooomsmod.item.ModItemGroup;
import net.rodofire.mushrooomsmod.item.ModItems;
import net.rodofire.mushrooomsmod.networking.ModNetwork;
import net.rodofire.mushrooomsmod.particle.ModParticles;
import net.rodofire.mushrooomsmod.recipe.ModRecipes;
import net.rodofire.mushrooomsmod.sound.ModSounds;
import net.rodofire.mushrooomsmod.util.ModLootTableModifier;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.ModFeatures;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModDecoratorTypes;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModFoliagePlacerTypes;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModTrunkPlacerTypes;
import net.rodofire.mushrooomsmod.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MushrooomsMod implements ModInitializer {

    public static final String MOD_ID = "mushrooomsmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static ModConfig CONFIG;

    @Override
    public void onInitialize() {

        ModBlocks.registerModBlocks();
        ModBlockEntities.registerBlockEntities();

        BlockUtils.registerStripable();
        BlockUtils.registerFlammable();

        ModItems.registerModItems();
        ModItemGroup.registerItemGroup();

        ModEntities.registerModENtities();
        ModEntitiesAttribute.registerAttributes();


        ModParticles.registerParticles();
        ModStatusEffects.registerEffects();

        ModSounds.registerModSound();

        ModDecoratorTypes.register();
        ModTrunkPlacerTypes.register();
        ModFoliagePlacerTypes.register();

        ModWorldGeneration.generateModWorldGen();
        ModFeatures.addFeatures();


        ModLootTableModifier.modifyLootTable();

        ModRecipes.registerRecipes();

        ModNetwork.registerC2SPackets();


        //ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());


        LOGGER.info("Starting MushrooomsMod!");

    }
}