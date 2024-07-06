package net.rodofire.mushrooomsmod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;

public class ModScreenHandlers {
    public static void registerScreenHandler() {
        MushrooomsMod.LOGGER.info("Registering Screen Handlers for " + MushrooomsMod.MOD_ID);
    }

    public static final ScreenHandlerType<net.rodofire.mushrooomsmod.screen.ForgeScreenHandler> FORGE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MushrooomsMod.MOD_ID, "forge_screen_handler"),
                    new ExtendedScreenHandlerType<>(net.rodofire.mushrooomsmod.screen.ForgeScreenHandler::new,ForgeScreenHandler.PACKET_CODEC ));


    public record ForgeScreenHandler(String label) {
        public static final PacketCodec<RegistryByteBuf, ForgeScreenHandler> PACKET_CODEC = PacketCodec.tuple(
                PacketCodecs.STRING, ForgeScreenHandler::label, ForgeScreenHandler::new);
    }


}
