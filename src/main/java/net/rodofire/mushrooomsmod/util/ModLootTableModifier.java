package net.rodofire.mushrooomsmod.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.block.ModBlocks;

public class ModLootTableModifier {
    private static final Identifier SNIFFER_ID = Identifier.of("minecraft", "gameplay/sniffer_digging");

    public static void modifyLootTable() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (SNIFFER_ID.equals(key.getRegistry())) {
                LootPool. Builder pool = LootPool. builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModBlocks.PREHISTORIC_ROSE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                tableBuilder.pool(pool);
            }

        });
    }
}
