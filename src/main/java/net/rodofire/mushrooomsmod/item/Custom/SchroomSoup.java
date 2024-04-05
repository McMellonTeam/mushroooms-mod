package net.rodofire.mushrooomsmod.item.Custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.rodofire.mushrooomsmod.item.ModItems;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldBiomes;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SchroomSoup extends Item {
    protected final RegistryKey<Biome> biome;
    protected final StatusEffectInstance effects;
    public SchroomSoup(Settings setting, RegistryKey<Biome> biome, StatusEffectInstance effects){
        super(setting);
        this.biome=biome;
        this.effects=effects;
    }
    public void applyeffect(World world, LivingEntity user, ItemStack stack) {
        if(user.eatFood(world,stack).isOf(ModItems.LUMINESCENT_SCHROOM_SOUP)){
            if(world.getBiome(user.getBlockPos()).getKey().get().equals(ModOverworldBiomes.BLUE_LUMINESCENT_SHROOM_CAVE)){
                user.addStatusEffect(effects);
            }
        }
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);
        applyeffect(world, user, stack);
        if (user instanceof PlayerEntity && ((PlayerEntity)user).getAbilities().creativeMode) {
            return itemStack;
        }
        return new ItemStack(Items.BOWL);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.mushrooomsmod.schroom_soup.description"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
