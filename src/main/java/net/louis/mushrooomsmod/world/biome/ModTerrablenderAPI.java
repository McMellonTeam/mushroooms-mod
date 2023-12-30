package net.louis.mushrooomsmod.world.biome;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        //Regions.register(new ModOverworldRegion(new Identifier(MushrooomsMod.MOD_ID, "overworld"),4));
        //SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MushrooomsMod.MOD_ID, ModMaterialsRules.makeRules());
    }
}
