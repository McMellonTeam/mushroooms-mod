package net.louis.mushrooomsmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.louis.mushrooomsmod.block.ModBlocks;
import net.louis.mushrooomsmod.entity.ModEntities;
import net.louis.mushrooomsmod.entity.custom.GrokiEntity;
import net.louis.mushrooomsmod.item.ModItems;
import net.louis.mushrooomsmod.particle.ModParticles;
import net.louis.mushrooomsmod.sound.ModSounds;
import net.louis.mushrooomsmod.util.ModLootTableModifier;
import net.louis.mushrooomsmod.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MushrooomsMod implements ModInitializer {

	public static final String MOD_ID = "mushrooomsmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModParticles.registerParticles();
		ModSounds.registerModSound();
		//ModWorldGeneration.generateModWorldGen();
		ModLootTableModifier.modifyLootTable();

		FabricDefaultAttributeRegistry.register(ModEntities.GROKI, GrokiEntity.setAttributes());
		System.out.println("Starting Mushroooms Mod!");

	}
}