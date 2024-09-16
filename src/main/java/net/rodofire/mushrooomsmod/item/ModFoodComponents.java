package net.rodofire.mushrooomsmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent BAGUETTE = new FoodComponent.Builder().nutrition(8).saturationModifier(1.1f).build();
    public static final FoodComponent BLUE_LUMINESCENT_SCHROOM_SOUP = new FoodComponent.Builder().nutrition(3).saturationModifier(0.4f).build();
    public static final FoodComponent YELLOW_BERRIES = new FoodComponent.Builder().nutrition(1).saturationModifier(0.1f).alwaysEdible().snack().statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 250), 0.2f).build();
    public static final FoodComponent COOKED_YELLOW_BERRIES = new FoodComponent.Builder().nutrition(1).saturationModifier(0.2f).alwaysEdible().snack().build();
}
