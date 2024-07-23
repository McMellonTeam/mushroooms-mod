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
            new Identifier(MushrooomsMod.MOD_ID, "groki"), EntityType.Builder.create(GrokiEntity::new, SpawnGroup.CREATURE)
                    .setDimensions(0.9f, 1.45f).build("groki"));

    public static final EntityType<BoleteCowEntity> BOLETE_COW = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MushrooomsMod.MOD_ID, "bolete_cow"), EntityType.Builder.create(BoleteCowEntity::new, SpawnGroup.CREATURE)
                    .setDimensions(1.3f, 1.8f).build("bolete_cow"));

    public static final EntityType<PlotiEntity> PLOTI = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MushrooomsMod.MOD_ID, "ploti"), EntityType.Builder.create(PlotiEntity::new, SpawnGroup.CREATURE)
                    .setDimensions(0.25f, 0.3f).build("ploti"));

    public static final EntityType<CrystalCreeperEntity> CRYSTAL_CREEPER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MushrooomsMod.MOD_ID, "crystal_creeper"), EntityType.Builder.create(CrystalCreeperEntity::new, SpawnGroup.MONSTER)
                    .setDimensions(0.6f, 1.7f).build("crystal_creeper"));

    public static final EntityType<CrystalGolemEntity> CRYSTAL_GOLEM = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MushrooomsMod.MOD_ID, "crystal_golem"), EntityType.Builder.create(CrystalGolemEntity::new, SpawnGroup.CREATURE)
                    .setDimensions(1.2f, 2.8f).build("crystal_golem"));

    public static final EntityType<SchroomStickEntity> SCHROOM_STICK = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MushrooomsMod.MOD_ID, "schroom_stick"), EntityType.Builder.create(SchroomStickEntity::new, SpawnGroup.CREATURE)
                    .setDimensions(0.3f, 1.6f).build("schroom_stick"));

    public static final EntityType<InventoryArmorStandEntity> INVENTORY_ARMOR_STAND_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MushrooomsMod.MOD_ID, "inventory_armor_stand"), EntityType.Builder.create(InventoryArmorStandEntity::new, SpawnGroup.MISC)
                    .setDimensions(0.9f, 1.8f).build("inventory_armor_stand"));


    public static void registerModENtities() {
        MushrooomsMod.LOGGER.info("Registering Mod Entities For Mushrooomsmod");
    }

}
