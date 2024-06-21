package net.rodofire.mushrooomsmod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.entity.BoostingMushroomBlockEntity;
import net.rodofire.mushrooomsmod.block.entity.DangerousBoostingMushroomBlockEntity;
import net.rodofire.mushrooomsmod.block.entity.ForgeBlockEntity;

public class ModBlockEntities {
    public static final BlockEntityType<ForgeBlockEntity> FORGE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(MushrooomsMod.MOD_ID, "forge_be")
            , FabricBlockEntityTypeBuilder.create(ForgeBlockEntity::new, ModBlocks.FORGE_BLOCK).build());

    public static final BlockEntityType<BoostingMushroomBlockEntity> BOOSTING_MUSHROOM_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(MushrooomsMod.MOD_ID, "boosting_mushroom_be")
            , FabricBlockEntityTypeBuilder.create(BoostingMushroomBlockEntity::new, ModBlocks.MUSHROOM_BOOSTING).build());

    public static final BlockEntityType<DangerousBoostingMushroomBlockEntity> DANGEROUS_BOOSTING_MUSHROOM_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(MushrooomsMod.MOD_ID, "dangerous_boosting_mushroom_be")
            , FabricBlockEntityTypeBuilder.create(DangerousBoostingMushroomBlockEntity::new, ModBlocks.DANGEROUS_MUSHROOM_BOOSTING).build());

    public static void registerBlockEntities() {
        MushrooomsMod.LOGGER.info("Registering Block Entities");
    }
}
