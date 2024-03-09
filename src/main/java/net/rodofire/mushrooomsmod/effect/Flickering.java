package net.rodofire.mushrooomsmod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
public class Flickering extends StatusEffect {
    protected Flickering(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(!entity.getWorld().isClient()){
            return;
        }
        super.applyUpdateEffect(entity, amplifier);
    }
}
