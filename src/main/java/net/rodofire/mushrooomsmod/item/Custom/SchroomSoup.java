package net.rodofire.mushrooomsmod.item.Custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.rodofire.mushrooomsmod.item.ModItems;
import net.rodofire.mushrooomsmod.world.biome.ModBiomesTags;

public class SchroomSoup extends Item {
    protected final RegistryKey<Biome> biome;
    protected final StatusEffectInstance effects;
    public SchroomSoup(Settings setting, RegistryKey<Biome> biome, StatusEffectInstance effects){
        super(setting);
        this.biome=biome;
        this.effects=effects;
    }
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if(user.eatFood(world,stack).isOf(ModItems.LUMINESCENT_SCHROOM_SOUP)){
            if (world.getBiome(user.getBlockPos()).isIn(ModBiomesTags.LUMINESCENT_CAVE)){
                user.addStatusEffect(effects);
            }
        }
    }
}
