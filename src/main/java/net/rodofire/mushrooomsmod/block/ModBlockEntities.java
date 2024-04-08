package net.rodofire.mushrooomsmod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.entity.ForgeBlockEntity;

public class ModBlockEntities {
    public static final BlockEntityType<ForgeBlockEntity> FORGE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(MushrooomsMod.MOD_ID, "forge_be")
            , FabricBlockEntityTypeBuilder.create(ForgeBlockEntity::new, ModBlocks.FORGE_BLOCK).build());

    public static void registerBlockEntities() {
        MushrooomsMod.LOGGER.info("Registering Block Entities");
    }
}
