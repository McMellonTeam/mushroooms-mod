package net.rodofire.mushrooomsmod.world.structures;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.world.structures.custom.piece.mushroom.GiantYellowMushroomPiece;
import net.rodofire.mushrooomsmod.world.structures.custom.piece.mushroom.PurpleMushroomPiece;
import net.rodofire.mushrooomsmod.world.structures.custom.piece.mushroom.YellowMushroomPiece;

public interface ModStructurePieceType {
    StructurePieceType YELLOW_MUSHROOM = register(YellowMushroomPiece::new, "yellow_mushroom");
    StructurePieceType GIANT_YELLOW_MUSHROOM = register(GiantYellowMushroomPiece::new, "giant_yellow_mushroom");
    StructurePieceType PURPLE_MUSHROOM = register(PurpleMushroomPiece::new, "purple_mushroom");

    private static StructurePieceType register(StructurePieceType type, String id) {
        return Registry.register(Registries.STRUCTURE_PIECE, Identifier.of(MushrooomsMod.MOD_ID, id), type);
    }

    static void registerStructurePiecesType() {
        MushrooomsMod.LOGGER.info("|\t-Registering Structure Pieces Type");
    }
}
