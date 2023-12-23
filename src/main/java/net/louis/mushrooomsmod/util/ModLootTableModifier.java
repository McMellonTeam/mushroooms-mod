package net.louis.mushrooomsmod.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.louis.mushrooomsmod.block.ModBlocks;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifier {
    private static final Identifier SNIFFER_ID = new Identifier("minecraft", "gameplay/sniffer_digging");
    public static void modifyLootTable(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (SNIFFER_ID.equals(id)){
                LootPool.Builder poolbuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModBlocks.PREHISTORIC_ROSE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build());
                tableBuilder.pool(poolbuilder.build());
            }

        });
    }
}
