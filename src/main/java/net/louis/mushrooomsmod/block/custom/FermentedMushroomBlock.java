package net.louis.mushrooomsmod.block.custom;

import net.fabricmc.fabric.mixin.client.keybinding.KeyBindingAccessor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.lwjgl.glfw.GLFW;

public class FermentedMushroomBlock extends Block  {
    public static Block block;
    public static final VoxelShape SHAPE = createCuboidShape(0,0,0,16,16,16);
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    public FermentedMushroomBlock(Block block, Settings settings) {
        super(settings);
        this.block=block;
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        System.out.println("on use");
        Item item = player.getMainHandStack().getItem();
        System.out.println(item);
        if (item.equals(Items.DIAMOND_AXE)||item.equals(Items.NETHERITE_AXE)||item.equals(Items.IRON_AXE)){
            System.out.println("axe");
            int random = Random.create().nextBetween(0,10);
            if (random!=0){
                world.setBlockState(pos,block.getDefaultState());
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

}
