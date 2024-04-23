package net.rodofire.mushrooomsmod.world.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.feature.mushroomfeature.ModMushroomFeatureConfig;

import java.util.ArrayList;

public class CustomPurpleSecondMushroompFeature extends CustomPurpleSecondMushroomp {

    public CustomPurpleSecondMushroompFeature(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public ArrayList<Vec3i> getTrunkCoordinates(BlockPos pos, ModMushroomFeatureConfig config, Random random, int maxheight, int minheight, int cap) {

        //Direction 0=north , 1 = north-east...
        int direction1 = Random.create().nextBetween(0, 7);
        int direction2 = getSecondDirection(direction1);
        int direction3 = getSecondDirection(direction2);

        //Max height of the trunk
        int maxheight1 = Random.create().nextBetween(minheight, maxheight);
        int maxheight2 = Random.create().nextBetween(minheight, maxheight);
        int maxheight3 = 0;

        //Height where the trunk start
        int startheight1 = Random.create().nextBetween(1, 2 * minheight / 3);
        int startheight2 = Random.create().nextBetween(1, 2 * minheight / 3);
        int startheight3 = 0;

        //Second direction of the trunk
        int sens1 = Random.create().nextBetween(0, 1);
        int sens2 = Random.create().nextBetween(0, 1);
        int sens3 = 0;

        if (sens1 == 0) sens1 = -1;
        if (sens2 == 0) sens2 = -1;

        ArrayList<Vec3i> coordinates1 = new ArrayList<>();
        ArrayList<Vec3i> coordinates2 = new ArrayList<>();
        ArrayList<Vec3i> coordinates3 = new ArrayList<>();

        coordinates1.add(new Vec3i(0, startheight1, 0));
        coordinates2.add(new Vec3i(0, startheight2, 0));

        if (cap == 3) {
            direction3 = getThirdDirection(direction1, direction2);
            maxheight3 = Random.create().nextBetween(minheight, maxheight);
            startheight3 = Random.create().nextBetween(1, 2 * minheight / 3);
            sens3 = Random.create().nextBetween(0, 1);
            if (sens3 == 0) sens3 = -1;
            coordinates3.add(new Vec3i(0, startheight3, 0));
        }

        ArrayList<Vec3i> coordinates = new ArrayList<>();

        //set stem up to the start of the branch
        for (int i = 0; i < Math.max(Math.max(startheight1, startheight2), startheight3); i++) {
            coordinates.add(new Vec3i(0, i, 0));
        }


        ArrayList<Vec3i> lastcoordinates = new ArrayList<>();

        coordinates.addAll(shouldMove(random, coordinates1, direction1, sens1, startheight1, maxheight1, 5));
        lastcoordinates.add(coordinates.get(coordinates.size() - 1));

        coordinates.addAll(shouldMove(random, coordinates2, direction2, sens2, startheight2, maxheight2, 5));
        lastcoordinates.add(coordinates.get(coordinates.size() - 1));

        if (cap == 3) {
            coordinates.addAll(shouldMove(random, coordinates3, direction3, sens3, startheight3, maxheight3, 5));
            lastcoordinates.add(coordinates.get(coordinates.size() - 1));
        }
        coordinates.addAll(lastcoordinates);
        return coordinates;
    }

    @Override
    public ArrayList<Vec3i> getCapCoordinates(World world, BlockPos pos, BlockPos.Mutable mutable, ModMushroomFeatureConfig config, Random random, ArrayList<Vec3i> trunkcoordinates, int cap) {
        ArrayList<Vec3i> capCoordinates = new ArrayList<>();
        for (int i = 0; i < cap; i++) {
            Vec3i vect = trunkcoordinates.get(trunkcoordinates.size() - 1 - i);
            capCoordinates.addAll(getCap(getCapLarge(), Random.create().nextBetween(2, 3), vect));
        }
        return capCoordinates;
    }

    public int getCapLarge() {
        int random = Random.create().nextBetween(2, 12);
        if (random <= 4) return 2;
        if (random <= 7) return 3;
        if (random <= 9) return 4;
        if (random <= 11) return 5;
        return 6;
    }

    public ArrayList<Vec3i> getCap(int cap, int height, Vec3i caps) {
        //generate cap
        ArrayList<Vec3i> capslist = new ArrayList<>();
        if (cap > 3) {
            for (int i = -cap; i <= cap; i++) {
                for (int j = 0; j < height; j++) {
                    for (int k = -cap; k <= cap; k++) {
                        //Large base
                        if (j < 2) {
                            boolean maxim1 = Math.abs(i) == cap - 1;
                            boolean maxkm1 = Math.abs(k) == cap - 1;
                            boolean maxi = Math.abs(i) == cap;
                            boolean maxk = Math.abs(k) == cap;
                            boolean secondmaxi = Math.abs(i) >= cap - 3;
                            boolean secondmaxk = Math.abs(k) >= cap - 3;
                            if ((maxi && secondmaxk) || (maxk && secondmaxi) || (maxim1 && maxkm1)) continue;
                            capslist.add(caps.add(i, j, k));
                        }//Smaller Base
                        else {
                            boolean maxim2 = Math.abs(i) == cap - 2;
                            boolean maxkm2 = Math.abs(k) == cap - 2;
                            boolean maxim1 = Math.abs(i) == cap - 1;
                            boolean maxkm1 = Math.abs(k) == cap - 1;
                            boolean maxi = Math.abs(i) == cap;
                            boolean maxk = Math.abs(k) == cap;
                            boolean secondmaxi = Math.abs(i) >= cap - 3;
                            boolean secondmaxk = Math.abs(k) >= cap - 3;
                            if (maxi || maxk || maxim2 && maxkm2 || maxim1 && secondmaxk || maxkm1 && secondmaxi)
                                continue;
                            capslist.add(caps.add(i, j, k));
                        }
                    }
                }
            }
        } else {
            for (int i = -cap; i <= cap; i++) {
                for (int j = 0; j < height; j++) {
                    for (int k = -cap; k <= cap; k++) {
                        boolean maxi = Math.abs(i) == cap;
                        boolean maxk = Math.abs(k) == cap;
                        if ((maxi && maxk)) continue;
                        capslist.add(caps.add(i, j, k));
                    }
                }
            }
        }
        return capslist;
    }

    @Override
    public void poseCoordinates(World world, BlockPos pos, BlockPos.Mutable mutable, ModMushroomFeatureConfig config, Random random, ArrayList<Vec3i> trunkcoordinates, ArrayList<Vec3i> capcoordinates) {

        BlockState blockState = config.capProvider.get(random, pos);
        for (int i = 0; i < capcoordinates.size(); i++) {
            mutable.set(pos, capcoordinates.get(i));
            world.setBlockState(mutable, blockState);
        }
         blockState = config.stemProvider.get(random, pos);
        for (int i = 0; i < trunkcoordinates.size(); i++) {
            mutable.set(pos, trunkcoordinates.get(i));
            if (world.getBlockState(mutable).isOf(ModBlocks.PURPLE_MUSHROOM_BLOCK)){
                world.setBlockState(mutable.move(Direction.EAST), Blocks.AIR.getDefaultState());
                world.setBlockState(mutable.move(Direction.NORTH), Blocks.AIR.getDefaultState());
                world.setBlockState(mutable.move(Direction.WEST), Blocks.AIR.getDefaultState());
                world.setBlockState(mutable.move(Direction.SOUTH), Blocks.AIR.getDefaultState());
            }
            world.setBlockState(mutable, blockState);
        }
    }

    public int getSecondDirection(int direction) {
        return (Random.create().nextBetween(2, 6) + direction) % 7;
    }

    public int getThirdDirection(int direction, int direction2) {
        int direction3 = (Random.create().nextBetween(2, 6) + direction) % 7;
        if (direction3 == direction2 || direction3 == (direction2 + 1) % 7 || direction3 == (direction2 - 1 + 7) % 7)
            return getThirdDirection(direction, direction2);
        return direction3;
    }

    public Vec3i getTrunkCoordinates(Random random, Vec3i coordinates, int direction, int sens) {
        //Generates coordinates in function of the direction
        int x;
        int z;
        double xddirection = 10 * Math.sin(direction * Math.PI / 4);
        int xidirection = (int) (xddirection / Math.abs(xddirection));

        double zddirection = 10 * Math.cos(direction * Math.PI / 4);
        int zidirection = (int) (zddirection / Math.abs(zddirection));


        if (direction % 4 == 0) {
            z = Random.create().nextBetween(0, 1) * zidirection;
            x = Random.create().nextBetween(0, 5) / 5 * sens;
            if (x == 0 && z == 0) z = zidirection;
            return coordinates.add(x, 1, z);
        }
        if (direction % 4 == 2) {
            x = Random.create().nextBetween(0, 1) * xidirection;
            z = Random.create().nextBetween(0, 5) / 5 * sens;
            if (x == 0 && z == 0) x = xidirection;
            return coordinates.add(x, 1, z);
        }
        z = Random.create().nextBetween(0, 1) * zidirection;
        x = Random.create().nextBetween(0, 1) * xidirection;
        if (x == 0 && z == 0) {
            z = zidirection;
            x = xidirection;
        }
        return coordinates.add(x, 1, z);
    }

    public ArrayList<Vec3i> shouldMove(Random random, ArrayList<Vec3i> coordinates, int direction, int sens, int start, int maxheight, int lastheight) {
        //determines the height of one particular coordinate
        if (start >= maxheight) return coordinates;
        int height = Random.create().nextBetween(0, 10);
        if (maxheight - start <= 10) {
            height = Random.create().nextBetween(0, maxheight - start);
        }

        if (height <= 3 && lastheight < 7) {
            coordinates.add(getTrunkCoordinates(random, coordinates.get(coordinates.size() - 1), direction, sens));
            return shouldMove(random, coordinates, direction, sens, start + 1, maxheight, height);
        }

        if (height <= 7 || lastheight < 3) {
            coordinates.add(getTrunkCoordinates(random, coordinates.get(coordinates.size() - 1), direction, sens));
            coordinates.add(coordinates.get(coordinates.size() - 1).up());
            return shouldMove(random, coordinates, direction, sens, start + 2, maxheight, height);
        }

        coordinates.add(getTrunkCoordinates(random, coordinates.get(coordinates.size() - 1), direction, sens));
        for (int i = 1; i < height - 5; ++i) {
            coordinates.add(coordinates.get(coordinates.size() - 1).up());
        }
        return shouldMove(random, coordinates, direction, sens, start + height - 5, maxheight, height);
    }
}
