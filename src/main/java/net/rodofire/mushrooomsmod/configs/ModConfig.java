package net.rodofire.mushrooomsmod.configs;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import net.rodofire.mushrooomsmod.MushrooomsMod;

//Done thanks to bsroleplay :https://github.com/B4nduty/bsroleplay-1.21
//b4nduty :  https://github.com/B4nduty
//licensed under CC0 - 1.0

@Config(name = MushrooomsMod.MOD_ID)
@Config.Gui.Background("mushrooomsmod:textures/block/mushroom_block_blue_luminescent.png")
public class ModConfig extends PartitioningSerializer.GlobalData {

    @ConfigEntry.Category("common")
    @ConfigEntry.Gui.TransitiveObject()
    public Common common = new Common();

    @Config(name = MushrooomsMod.MOD_ID + "-common")
    public static final class Common implements ConfigData {
        @ConfigEntry.Gui.Tooltip()
        @Comment("""
                spawn rate of common biomes, cannot be <= 0
                """)
        int commonBiomeSpawnRate = 4;

        public int getCommonBiomeSpawnRate() {
            return Math.max(1, commonBiomeSpawnRate);
        }
    }
}
