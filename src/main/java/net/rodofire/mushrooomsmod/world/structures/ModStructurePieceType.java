package net.rodofire.mushrooomsmod.world.structures;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.world.structures.mushrooms.YellowMushroomPiece;

import java.util.Locale;

public interface ModStructurePieceType {
    StructurePieceType YELLOW_MUSHROOM = register(YellowMushroomPiece::new, "yellow_mushroom.json");

    private static StructurePieceType register(StructurePieceType type, String id) {
        return Registry.register(Registries.STRUCTURE_PIECE, Identifier.of(MushrooomsMod.MOD_ID, id), type);
    }

    static void registerStructurePiecesType() {
        MushrooomsMod.LOGGER.info("|\t-Registering Structure Pieces Type");
    }
}
