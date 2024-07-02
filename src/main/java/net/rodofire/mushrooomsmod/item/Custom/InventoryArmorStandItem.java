package net.rodofire.mushrooomsmod.item.Custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.entity.ModEntities;
import net.rodofire.mushrooomsmod.entity.custom.InventoryArmorStandEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class InventoryArmorStandItem extends Item {
    public InventoryArmorStandItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        ItemStack itemStack = context.getStack();
        if (!world.isClient) {
            ServerWorld worldServer = (ServerWorld) world;
            Consumer<InventoryArmorStandEntity> consumer = EntityType.copier(worldServer, itemStack, context.getPlayer());
            InventoryArmorStandEntity entity = ModEntities.INVENTORY_ARMOR_STAND_ENTITY.create(worldServer, itemStack.getNbt(), consumer, pos, SpawnReason.SPAWN_EGG, true, true);
            if (entity == null) {
                return ActionResult.FAIL;
            }
            float f = (float) MathHelper.floor((MathHelper.wrapDegrees(context.getPlayerYaw() - 180.0f) + 90.0f) / 45.0f) * 45.0f;
            entity.refreshPositionAndAngles(entity.getX(), entity.getY(), entity.getZ(), f, 0.0f);
            worldServer.spawnEntityAndPassengers(entity);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.mushrooomsmod.inventory_armor_stand_usage").formatted(Formatting.BLUE));
            tooltip.add(Text.translatable("tooltip.mushrooomsmod.inventory_armor_stand_use").formatted(Formatting.BLUE));
        } else {
            tooltip.add(Text.translatable("tooltip.mushrooomsmod.shift"));
        }
    }
}
