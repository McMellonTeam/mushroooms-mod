package net.rodofire.mushrooomsmod.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModConsumableComponents {
    public static final ConsumableComponent YELLOW_BERRIES = ConsumableComponents.food().consumeSeconds(0.8f).consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 250), 0.2f)).build();
    public static final ConsumableComponent COOKED_YELLOW_BERRIES = ConsumableComponents.food().consumeSeconds(0.8f).build();
}
