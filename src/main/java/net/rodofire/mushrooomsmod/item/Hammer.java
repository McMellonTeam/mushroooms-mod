package net.rodofire.mushrooomsmod.item;

import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.random.Random;

public class Hammer extends ToolItem {
    private final float attackDamage;
    float attackspeed;

    public Hammer(ToolMaterial material, int attackDamage, float attackspeed, Settings settings) {
        super(material, settings);
        this.attackDamage = attackDamage + (float) Random.create().nextBetween(0, 2) / 2;
        this.attackspeed = attackspeed;
    }

}
