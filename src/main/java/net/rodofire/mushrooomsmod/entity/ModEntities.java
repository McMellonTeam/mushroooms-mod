package net.rodofire.mushrooomsmod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.custom.*;

public class ModEntities {
    public static final EntityType<GrokiEntity> GROKI = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MushrooomsMod.MOD_ID, "groki"), EntityType.Builder.create(GrokiEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.9f, 1.45f).build());

    public static final EntityType<BoleteCowEntity> BOLETE_COW = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MushrooomsMod.MOD_ID, "bolete_cow"), EntityType.Builder.create(BoleteCowEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1.3f, 1.8f).build());

    public static final EntityType<PlotiEntity> PLOTI = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MushrooomsMod.MOD_ID, "ploti"), EntityType.Builder.create(PlotiEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.25f, 0.3f).build());

    public static final EntityType<CrystalCreeperEntity> CRYSTAL_CREEPER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MushrooomsMod.MOD_ID, "crystal_creeper"), EntityType.Builder.create(CrystalCreeperEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.7f).build());

    public static final EntityType<CrystalGolemEntity> CRYSTAL_GOLEM = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MushrooomsMod.MOD_ID, "crystal_golem"), EntityType.Builder.create(CrystalGolemEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1.2f, 2.8f).build());

    public static final EntityType<SchroomStickEntity> SCHROOM_STICK = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MushrooomsMod.MOD_ID, "schroom_stick"), EntityType.Builder.create(SchroomStickEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.3f, 1.6f).build());

    public static final EntityType<InventoryArmorStandEntity> INVENTORY_ARMOR_STAND_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MushrooomsMod.MOD_ID, "inventory_armor_stand"), EntityType.Builder.create(InventoryArmorStandEntity::new, SpawnGroup.MISC)
                    .dimensions(0.9f, 1.8f).build());
    public static final EntityType<LockedInventoryArmorStand> LOCKED_INVENTORY_ARMOR_STAND = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MushrooomsMod.MOD_ID, "locked_inventory_armor_stand"), EntityType.Builder.create(LockedInventoryArmorStand::new, SpawnGroup.MISC)
                    .dimensions(0.9f, 1.8f).build());


    /*public static final EntityType<MosquitoEntity> MOSQUITO_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MushrooomsMod.MOD_ID, "mosquito"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, MosquitoEntity::new)
                    .dimensions(EntityDimensions.fixed(0.2f, 0.5f)).build());*/




    public static void registerModENtities(){
        MushrooomsMod.LOGGER.info("Registering Mod Entities For Mushrooomsmod");
    }

}
