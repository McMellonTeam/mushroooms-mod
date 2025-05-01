package net.rodofire.mushrooomsmod.world.structures;

import com.mojang.serialization.MapCodec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.world.structures.custom.structure.mushrooms.GiantYellowMushroomStructure;
import net.rodofire.mushrooomsmod.world.structures.custom.structure.mushrooms.PurpleMushroomStructure;
import net.rodofire.mushrooomsmod.world.structures.custom.structure.mushrooms.YellowMushroomStructure;

public interface ModStructureTypes {
    StructureType<YellowMushroomStructure> YELLOW_MUSHROOM = register("yellow_mushroom", YellowMushroomStructure.CODEC);
    StructureType<GiantYellowMushroomStructure> GIANT_YELLOW_MUSHROOM = register("giant_yellow_mushroom", GiantYellowMushroomStructure.CODEC);
    StructureType<PurpleMushroomStructure> PURPLE_MUSHROOM = register("purple_mushroom", PurpleMushroomStructure.CODEC);

    private static <S extends Structure> StructureType<S> register(String id, MapCodec<S> codec) {
        return Registry.register(Registries.STRUCTURE_TYPE, Identifier.of(MushrooomsMod.MOD_ID, id), () -> codec);
    }

    static void registerStructureTypes() {
        MushrooomsMod.LOGGER.info("|\t-Registering Structure Types");
    }
}
