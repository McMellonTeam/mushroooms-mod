package net.rodofire.mushrooomsmod.mixin.client;

import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Screen.class)
public interface ScreenMixin {

    /*@Invoker("addDrawableChild")
    public <T extends Element & Drawable & Selectable> T addDrawableChild(T drawableElement) {
        throw new UnsupportedOperationException();
    }*/

    @Invoker("addDrawableChild")
    <T extends Element & Drawable & Selectable> T invokeAddDrawableChild(T drawableElement);

    @Invoker("addDrawable")
    <T extends Drawable> T invokeAddDrawable(T drawableElement);


}
