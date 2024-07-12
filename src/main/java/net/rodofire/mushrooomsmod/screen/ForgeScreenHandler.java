package net.rodofire.mushrooomsmod.screen;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.Slot;
import net.rodofire.mushrooomsmod.block.entity.ForgeBlockEntity;
import org.jetbrains.annotations.Nullable;

public class ForgeScreenHandler extends ScreenHandler {


    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final ForgeBlockEntity blockEntity;

    //public static final PacketCodec<RegistryByteBuf, ForgeScreenHandler> PACKET_CODEC = PacketCodec.tuple(
    //        PacketCodecs.STRING, buf -> buf. );


    public ForgeScreenHandler(int i, PlayerInventory playerInventory) {
        //super(ModScreenHandlers.FORGE_SCREEN_HANDLER, i);
        this(i, playerInventory, playerInventory.player.getWorld().getBlockEntity(playerInventory.player.getBlockPos()),
                new ArrayPropertyDelegate(2));
    }


    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return false;
    }


    /*public static final PacketCodec<RegistryByteBuf, ForgeScreenHandler> PACKET_CODEC = PacketCodec.tuple(
            PacketCodecs.STRING, ForgeScreenHandler::label, ForgeScreenHandler::new);*/


    /*public ForgeScreenHandler(int syncId, PropertyDelegate arrayPropertyDelegate) {
        super(ModScreenHandlers.FORGE_SCREEN_HANDLER, syncId);


        this.inventory = ((Inventory) blockEntity);
        //inventory.onOpen(playerInventory.player);
        this.propertyDelegate = arrayPropertyDelegate;
        this.blockEntity = ((ForgeBlockEntity) blockEntity);

        this.addSlot(new Slot(null, 0, 25, 32));
        this.addSlot(new Slot(null, 1, 133, 32));

        addProperties(arrayPropertyDelegate);
    }*/

    public ForgeScreenHandler(int syncId, PlayerInventory playerInventory,
                              BlockEntity blockEntity, PropertyDelegate arrayPropertyDelegate) {
        super(ModScreenHandlers.FORGE_SCREEN_HANDLER, syncId);

        checkSize(((Inventory) blockEntity), 2);
        this.inventory = ((Inventory) blockEntity);
        inventory.onOpen(playerInventory.player);
        this.propertyDelegate = arrayPropertyDelegate;
        this.blockEntity = ((ForgeBlockEntity) blockEntity);

        this.addSlot(new Slot(inventory, 0, 25, 32));
        this.addSlot(new Slot(inventory, 1, 133, 32));

        addProperties(arrayPropertyDelegate);
    }

}
