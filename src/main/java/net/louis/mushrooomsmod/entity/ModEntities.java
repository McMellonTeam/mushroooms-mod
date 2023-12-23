package net.louis.mushrooomsmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.louis.mushrooomsmod.MushrooomsMod;
import net.louis.mushrooomsmod.entity.custom.GrokiEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<GrokiEntity> GROKI = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MushrooomsMod.MOD_ID,"groki"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE,GrokiEntity::new).dimensions(EntityDimensions.fixed(0.9f,1.45f)).build());

}
