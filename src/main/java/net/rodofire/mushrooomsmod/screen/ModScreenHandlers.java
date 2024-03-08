package net.rodofire.mushrooomsmod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;

public class ModScreenHandlers {
    public static final ScreenHandlerType<ForgeScreenHandler> FORGE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(MushrooomsMod.MOD_ID, "forge_screen_handler"),
                    new ExtendedScreenHandlerType<>(ForgeScreenHandler::new));


    public static void registerScreenHandler() {
        MushrooomsMod.LOGGER.info("Registering Screen Handlers for " + MushrooomsMod.MOD_ID);
    }
}
