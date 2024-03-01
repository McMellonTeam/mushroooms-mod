package net.rodofire.mushrooomsmod.sound;

import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static SoundEvent LA_MARSEILLAISE_DISC = registerSoundEvent("la_marseillaise_disc");
    public static SoundEvent HYMEN_URSS = registerSoundEvent("hymne_urss");

    //Crystal
    public static SoundEvent PINK_CRYSTAL_BREAK = registerSoundEvent("pink_crystal_break");
    public static SoundEvent PINK_CRYSTAL_STEP = registerSoundEvent("pink_crystal_step");
    public static SoundEvent PINK_CRYSTAL_PLACE = registerSoundEvent("pink_crystal_place");
    public static SoundEvent PINK_CRYSTAL_HIT = registerSoundEvent("pink_crystal_hit");
    public static SoundEvent PINK_CRYSTAL_FALL = registerSoundEvent("pink_crystal_fall");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(MushrooomsMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModSound() {
        MushrooomsMod.LOGGER.info("registering sounds");
    }
}
