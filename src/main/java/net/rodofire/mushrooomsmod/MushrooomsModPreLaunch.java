package net.rodofire.mushrooomsmod;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.rodofire.mushrooomsmod.configs.ModConfig;

public class MushrooomsModPreLaunch implements PreLaunchEntrypoint {

    //due to the random order of the mod loading provided by fabris, I had to register config during prelaunch
    @Override
    public void onPreLaunch() {
        AutoConfig.register(ModConfig.class, PartitioningSerializer.wrap(JanksonConfigSerializer::new));
        MushrooomsMod.CONFIG = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        MushrooomsMod.LOGGER.info("Prelaunching Config for Mushrooomsmod");
    }
}
