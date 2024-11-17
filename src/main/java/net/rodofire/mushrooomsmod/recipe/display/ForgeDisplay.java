package net.rodofire.mushrooomsmod.recipe.display;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.display.RecipeDisplay;
import net.minecraft.recipe.display.SlotDisplay;

public record ForgeDisplay(SlotDisplay ingredient, SlotDisplay result, SlotDisplay workStation) implements RecipeDisplay {

    @Override
    public SlotDisplay craftingStation() {
        return this.workStation;
    }

    public static final MapCodec<ForgeDisplay> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                            SlotDisplay.CODEC.fieldOf("ingredient").forGetter(ForgeDisplay::ingredient),
                            SlotDisplay.CODEC.fieldOf("result").forGetter(ForgeDisplay::result),
                            SlotDisplay.CODEC.fieldOf("work_station").forGetter(ForgeDisplay::workStation)
                    )
                    .apply(instance, ForgeDisplay::new)
    );
    public static final PacketCodec<RegistryByteBuf, ForgeDisplay> PACKET_CODEC = PacketCodec.tuple(
            SlotDisplay.PACKET_CODEC,
            ForgeDisplay::ingredient,
            SlotDisplay.PACKET_CODEC,
            ForgeDisplay::result,
            SlotDisplay.PACKET_CODEC,
            ForgeDisplay::workStation,
            ForgeDisplay::new
    );

    public static final RecipeDisplay.Serializer<ForgeDisplay> SERIALIZER = new RecipeDisplay.Serializer<>(CODEC, PACKET_CODEC);

    @Override
    public RecipeDisplay.Serializer<ForgeDisplay> serializer() {
        return SERIALIZER;
    }
}
