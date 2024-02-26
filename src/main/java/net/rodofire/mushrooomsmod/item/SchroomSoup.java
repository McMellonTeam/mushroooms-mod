package net.rodofire.mushrooomsmod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class SchroomSoup extends Item {
    protected final RegistryKey<Biome> biome;
    protected final StatusEffectInstance effects;
    public SchroomSoup(Settings setting, RegistryKey<Biome> biome, StatusEffectInstance effects){
        super(setting);
        this.biome=biome;
        this.effects=effects;
    }
    /*public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if(user.eatFood(world,stack).isOf(ModItems.LUMINESCENT_SCHROOM_SOUP)){
            if (biome.){
                user.addStatusEffect(effects);
            }
        }
    }*/
}
