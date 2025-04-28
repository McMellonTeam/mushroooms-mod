package net.rodofire.mushrooomsmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.entity.*;

public class ModBlockEntities {
    public static final BlockEntityType<ForgeBE> FORGE_BLOCK = register("forge_be", ForgeBE::new, ModBlocks.FORGE_BLOCK);
    public static final BlockEntityType<BoostingMushroomBE> BOOSTING_MUSHROOM = register("boosting_mushroom_be", BoostingMushroomBE::new, ModBlocks.MUSHROOM_BOOSTING);
    public static final BlockEntityType<DangerousBoostingMushroomBE> DANGEROUS_BOOSTING_MUSHROOM = register("dangerous_boosting_mushroom_be", DangerousBoostingMushroomBE::new, ModBlocks.DANGEROUS_MUSHROOM_BOOSTING);
    public static final BlockEntityType<RapangeFlowersBE> RAPANGE_FLOWERS_BLOCK = register("rapange_flowers_be", RapangeFlowersBE::new, ModBlocks.RAPANGE_FLOWERS);
    public static final BlockEntityType<TallYellowMushroomsBE> TALL_YELLOW_MUSHROOMS = register("tall_yellow_mushrooms", TallYellowMushroomsBE::new, ModBlocks.TALL_YELLOW_MUSHROOMS);


    private static <T extends BlockEntity> BlockEntityType<T> register(String id, BlockEntityType.BlockEntityFactory<T> factory, Block... blocks) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MushrooomsMod.MOD_ID, id), BlockEntityType.Builder.create(factory, blocks).build());
    }


    public static void registerBlockEntities() {
        MushrooomsMod.LOGGER.info("|\t-Registering Block Entities");
    }

}
