package net.rodofire.mushrooomsmod.mixin.client;

import me.shedaniel.clothconfig2.gui.ClothConfigScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ConfirmLinkScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.client.hud.ImageButtonWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(ClothConfigScreen.class)
public class ClothConfigScreenMixin {
    //*/icons
    @Unique
    private static final Identifier DISCORD_ICON = Identifier.of(MushrooomsMod.MOD_ID, "textures/gui/discord.png");
    @Unique
    private static final Identifier GITHUB_ICON = Identifier.of(MushrooomsMod.MOD_ID, "textures/gui/github.png");
    @Unique
    private static final Identifier KOFI_ICON = Identifier.of(MushrooomsMod.MOD_ID, "textures/gui/kofi.png");
    @Unique
    private static final Identifier CURSEFORGE_ICON = Identifier.of(MushrooomsMod.MOD_ID, "textures/gui/curseforge.png");
    @Unique
    private static final Identifier MODRINTH_ICON = Identifier.of(MushrooomsMod.MOD_ID, "textures/gui/modrinth.png");


    //links
    @Unique
    private static final String DISCORD_LINK = "https://discord.gg/bAQRUxNyFj";
    @Unique
    private static final String GITHUB_LINK = "https://github.com/McMellonTeam/mushroooms-mod";
    @Unique
    private static final String KOFI_LINK = "https://ko-fi.com/rodofire";
    @Unique
    private static final String CURSEFORGE_LINK = "https://www.curseforge.com/minecraft/mc-mods/mushroooms";
    @Unique
    private static final String MODRINTH_LINK = "https://modrinth.com/mod/mushroooms";


    @Inject(method = "init", at = @At("HEAD"))
    private void addButtons(CallbackInfo ci) {
        if (((Screen) (Object) this).getTitle().getString().equals("MushrooomsMod Options")) {
            List<ImageButtonWidget> buttons = getButtons();
            for (ImageButtonWidget button : buttons) {
                ((ScreenMixin) this).invokeAddDrawableChild(button);
            }
        }
    }

    @Unique
    public ImageButtonWidget createButton(String link, int yOffset, Identifier icon, Screen screen) {
        int getIconSize = getIconSize();
        MinecraftClient client = MinecraftClient.getInstance();
        ImageButtonWidget discord = new ImageButtonWidget(
                8, client.getWindow().getScaledHeight() / 2 + (int) (yOffset * (getIconSize == 24 ? 1 : 0.75)),
                getIconSize(), getIconSize(), icon,
                button -> {
                    MinecraftClient.getInstance().setScreen(new ConfirmLinkScreen(
                            open -> {
                                if (open) {
                                    Util.getOperatingSystem().open(link);
                                }
                                MinecraftClient.getInstance().setScreen(screen);
                            }, link, true)
                    );
                }
        );
        return discord;
    }

    @Unique
    public int getIconSize() {
        int large = MinecraftClient.getInstance().getWindow().getScaledHeight();
        return large < 300 ? 20 : 24;
    }

    @Unique
    public List<ImageButtonWidget> getButtons() {
        List<ImageButtonWidget> buttons = new ArrayList<>();
        buttons.add(createButton(GITHUB_LINK, 28, GITHUB_ICON, (ClothConfigScreen) (Object) this));
        buttons.add(createButton(DISCORD_LINK, 0, DISCORD_ICON, (ClothConfigScreen) (Object) this));
        buttons.add(createButton(KOFI_LINK, 56, KOFI_ICON, (ClothConfigScreen) (Object) this));
        buttons.add(createButton(CURSEFORGE_LINK, -28, CURSEFORGE_ICON, (ClothConfigScreen) (Object) this));
        buttons.add(createButton(MODRINTH_LINK, -56, MODRINTH_ICON, (ClothConfigScreen) (Object) this));
        return buttons;
    }
}
