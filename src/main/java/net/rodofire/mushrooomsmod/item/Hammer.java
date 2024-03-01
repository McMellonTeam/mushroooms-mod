package net.rodofire.mushrooomsmod.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.block.ModBlocks;

public class Hammer extends ToolItem {
    private final float attackDamage;
    float attackspeed;
    int maxcrushableblocks;

    public Hammer(ToolMaterial material, int attackDamage, float attackspeed, int maxcrushableblocks, Settings settings) {
        super(material, settings);
        this.attackDamage = attackDamage + (float) Random.create().nextBetween(0, 2) / 2;
        this.attackspeed = attackspeed;
        this.maxcrushableblocks = maxcrushableblocks;
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return super.canMine(state, world, pos, miner);
    }

    public boolean use(BlockState state, World world, BlockPos pos, PlayerEntity miner){
        Block targetedblock = world.getBlockState(pos).getBlock();
        if(targetedblock.equals(ModBlocks.FORGE_BLOCK)){
            BlockEntity blockEntity = world.getBlockEntity(pos);
            Inventory inventory = (Inventory) blockEntity;
            if(inventory.getStack(0).getCount()==0)return false;
            else {
                int transfer;
                int crushed = inventory.getStack(1).getCount();
                int crush = inventory.getStack(0).getCount();
                if(64-crushed<=crush)crush=crushed;
                ItemStack stack = inventory.getStack(0);
                ItemStack result = CrushableItems.getCrushed(stack);
                if(crush<=maxcrushableblocks){
                    inventory.removeStack(0,transfer=Random.create().nextBetween(1,crush));
                    inventory.setStack(1,result);
                    return false;
                }else {
                    inventory.removeStack(0);
                }
            }
        }
        return true;
    }
}
