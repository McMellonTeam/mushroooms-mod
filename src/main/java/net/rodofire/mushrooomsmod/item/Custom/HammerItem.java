package net.rodofire.mushrooomsmod.item.Custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.block.ModBlocks;

import java.util.List;

public class HammerItem extends ToolItem {
    int maxcrushableblocks;
    private int hammeruse = 0;

    public HammerItem(ToolMaterial material, int maxcrushableblocks, Settings settings) {
        super(material, settings);
        this.maxcrushableblocks = maxcrushableblocks;
    }

    public static AttributeModifiersComponent createAttributeModifiers(ToolMaterial material, int baseAttackDamage, float attackSpeed) {
        return AttributeModifiersComponent.builder().add(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, (float)baseAttackDamage + material.getAttackDamage(), EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).add(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).build();
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        if (hammeruse!=0) return mine(world, pos);
        if (world.isClient()) {
            return mine(world, pos);
        }
        return use(world, pos, miner);
    }

    public boolean use(World world, BlockPos pos, PlayerEntity miner) {
        Block targetedblock = world.getBlockState(pos).getBlock();
        if (targetedblock.equals(ModBlocks.FORGE_BLOCK)) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            Inventory inventory = (Inventory) blockEntity;
            hammeruse = 200;
            if (inventory.getStack(0).getCount() == 0) return false;
            else {

                int transfer;
                int crushed = inventory.getStack(1).getCount();
                int crush = inventory.getStack(0).getCount();

                if (64 - crushed <= crush) crush = crushed;

                ItemStack stack = inventory.getStack(0);
                ItemStack result = CrushableItems.getCrushed(stack);

                if (crush <= maxcrushableblocks) {
                    inventory.setStack(0, ItemStack.EMPTY);
                    result.setCount(crush + crushed);
                    inventory.setStack(1, result);
                } else {
                    inventory.removeStack(0, transfer = Random.create().nextBetween(1, maxcrushableblocks));
                    result.setCount(transfer + crushed);
                    inventory.setStack(1, result);
                }

                world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1f, 1.0f / (world.getRandom().nextFloat() * 0.5f + 1.0f) + 0.2f);
            }
            return false;
        }
        return true;
    }


    public boolean mine(World world, BlockPos pos) {
        return !world.getBlockState(pos).isOf(ModBlocks.FORGE_BLOCK);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (hammeruse != 0) hammeruse--;
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    public int getHammerUse() {
        return this.hammeruse;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.mushrooomsmod.hammer.usage").formatted(Formatting.AQUA));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
