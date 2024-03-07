package net.rodofire.mushrooomsmod.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.datagen.recipe.ForgeRecipeBuilder;
import net.rodofire.mushrooomsmod.recipe.ForgeRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class HammerItem extends ToolItem {
    double attackDamage;
    double attackSpeed;
    int maxcrushableblocks;
    public static int hammeruse = 0;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public HammerItem(ToolMaterial material, int attackDamage, float attackSpeed, int maxcrushableblocks, Settings settings) {
        super(material, settings);
        this.attackDamage = attackDamage;
        double attackDamage1 = attackDamage + (float) Random.create().nextBetween(0, 2) / 2;
        this.attackSpeed = attackSpeed;
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", attackDamage1, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
        this.maxcrushableblocks = maxcrushableblocks;
    }


    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        if (hammeruse != 0 || world.isClient()) return mine(world, pos);
        System.out.println(hammeruse);
        return use(world, pos,miner);
    }

    public boolean use(World world, BlockPos pos,PlayerEntity miner) {
        Block targetedblock = world.getBlockState(pos).getBlock();
        if (targetedblock.equals(ModBlocks.FORGE_BLOCK)) {

            hammeruse = 100;
            BlockEntity blockEntity = world.getBlockEntity(pos);
            Inventory inventory = (Inventory) blockEntity;

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

                world.playSound(miner,pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS,1f,1f);
            }
            return false;
        }return true;
    }



    public boolean mine(World world, BlockPos pos) {
        return !world.getBlockState(pos).isOf(ModBlocks.FORGE_BLOCK);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (hammeruse != 0) hammeruse--;
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        //tooltip.add((int) attackDamage,Text.translatable("tooltip.mushrooomsmod.hammer.attack_damage"));
        tooltip.add(Text.translatable("tooltip.mushrooomsmod.hammer.attack_damage : " + (int) attackSpeed));
        tooltip.add(Text.translatable("tooltip.mushrooomsmod.hammer.usage").formatted(Formatting.AQUA));
        super.appendTooltip(stack, world, tooltip, context);
    }
    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {
            return this.attributeModifiers;
        }
        return super.getAttributeModifiers(slot);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (state.getHardness(world, pos) != 0.0f) {
            stack.damage(2, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }
        return true;
    }
}
