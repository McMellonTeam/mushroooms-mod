package net.rodofire.mushrooomsmod.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;

public class ForgeScreenHandler extends ScreenHandler {
    private ScreenHandlerType<?> type;
    private int syncid;

    //public static final PacketCodec<RegistryByteBuf, ForgeScreenHandler> PACKET_CODEC = PacketCodec.tuple(
    //        PacketCodecs.STRING, buf -> buf. );

    protected ForgeScreenHandler(@Nullable ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);

        this.type = type;
        this.syncid = syncId;
    }

    public ForgeScreenHandler(int i, PlayerInventory playerInventory, ForgeScreenHandler forgeScreenHandler) {
        super(forgeScreenHandler.getType(), i);
    }


    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return false;
    }
    /*private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final ForgeBlockEntity blockEntity;

    public static final PacketCodec<RegistryByteBuf, ForgeScreenHandler> PACKET_CODEC = PacketCodec.tuple(
            PacketCodecs.STRING, ForgeScreenHandler::label, ForgeScreenHandler::new);

    public ForgeScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf) {
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(2),"s");
    }*/

    //public static final PacketCodec<RegistryByteBuf, ForgeScreenHandler> PACKET_CODEC =


    /*public ForgeScreenHandler(int syncId, PropertyDelegate arrayPropertyDelegate) {
        super(ModScreenHandlers.FORGE_SCREEN_HANDLER, syncId);

        //this.addSlot(new Slot(null, 0, 25, 32));
        //this.addSlot(new Slot(null, 1, 133, 32));
//
        //addProperties(arrayPropertyDelegate);
    }*/

    /*public ForgeScreenHandler(int i, PlayerInventory playerInventory, Object o, Inventory inventory, PropertyDelegate propertyDelegate, ForgeBlockEntity blockEntity) {
        super(ModScreenHandlers.FORGE_SCREEN_HANDLER, i);
        this.inventory = inventory;
        this.propertyDelegate = propertyDelegate;
        this.blockEntity = blockEntity;
    }

    public ForgeScreenHandler(int i, PlayerInventory playerInventory, ForgeScreenHandler forgeScreenHandler) {
        super();

    }*/
}
