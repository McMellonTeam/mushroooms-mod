package net.rodofire.mushrooomsmod.world.biome;

import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldRegion;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldRegionSimplified;
import net.rodofire.mushrooomsmod.world.biome.rules.ModMaterialsRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(new Identifier(MushrooomsMod.MOD_ID, "overworld"), 4));
        Regions.register(new ModOverworldRegionSimplified(new Identifier(MushrooomsMod.MOD_ID, "overworld_simplified"), 4));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MushrooomsMod.MOD_ID, ModMaterialsRules.makeRules());
    }
}
