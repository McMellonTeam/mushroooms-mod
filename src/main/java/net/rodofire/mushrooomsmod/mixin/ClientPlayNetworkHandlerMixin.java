package net.rodofire.mushrooomsmod.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkHandlerMixin {

    @Shadow
    private final MinecraftClient client;

    protected ClientPlayNetworkHandlerMixin(MinecraftClient client) {
        this.client = client;
    }

    @Inject(method = "onGameJoin", at = @At("TAIL"))
    private void mushroom_warning(GameJoinS2CPacket arg, CallbackInfo ci) {
        if (client.player == null) {
            return;
        }
        client.player.sendMessage(Text.of("MushrooomsMod : Note that this mod is still on beta and a lot of new things are going to come. Please note that some existing features provided by this mod might change"));
    }
}
