package net.louis.mushrooomsmod.world.tree.HugeBigGreenMushroom;

import com.mojang.serialization.Codec;
import net.louis.mushrooomsmod.feature.mushroomfeature.ModMushroomFeatureConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;

import java.util.ArrayList;

public class HugeBigGreenMushroomFeature extends CustomHugeBigGreenMushroomFeature{
    public HugeBigGreenMushroomFeature(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    protected Integer[] trunkPlace(BlockPos start, BlockPos.Mutable mutable, WorldAccess world, ModMushroomFeatureConfig config) {

        return new Integer[0];
    }

    @Override
    protected void capPlacer(BlockPos start, BlockPos.Mutable mutable, WorldAccess world, ModMushroomFeatureConfig config, Integer[] coordinates) {

    }
    protected ArrayList<String> getStringdirection(String choisis, ArrayList<String> directions){
        if (directions.size()==8){
            return directions;
        }

        if (choisis.equals("nord")){
            directions.add("nord");
            return getStringdirection("nordouest", directions);
        } else if (choisis.equals("nordouest")) {
            directions.add("nordouest");
            return getStringdirection("ouest", directions);
        } else if (choisis.equals("ouest")) {
            directions.add("ouest");
            return getStringdirection("sudouest", directions);
        } else if (choisis.equals("sudouest")) {
            directions.add("sudouest");
            return getStringdirection("sud", directions);
        } else if (choisis.equals("sud")) {
            directions.add("sud");
            return getStringdirection("sudest", directions);
        } else if (choisis.equals("sudest")) {
            directions.add("sudest");
            return getStringdirection("est", directions);
        } else if (choisis.equals("est")) {
            directions.add("est");
            return getStringdirection("nordest", directions);
        } else {
            directions.add("nordest");
            return getStringdirection("nord", directions);
        }
    }

}
