package net.louis.mushrooomsmod.world.tree.structuremushrooms;

import com.mojang.serialization.Codec;
import net.louis.mushrooomsmod.world.ModConfiguredFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;

import java.util.ArrayList;

public class CustomGreenSecondMushroomFeature extends CustomGreenSecondMushroom {

    public CustomGreenSecondMushroomFeature(Codec<HugeMushroomFeatureConfig> codec) {
        super(codec);
    }
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return ModConfiguredFeatures.GREEN_MUSHROOM_KEY;
    }

    @Override
    protected Integer[] generateTrunk(WorldAccess world, Random random, BlockPos pos, BlockPos.Mutable mutable, int height, HugeMushroomFeatureConfig config) {
        int direction = Random.create().nextBetween(0,3);
        ArrayList<Integer> heightb=new ArrayList<>();
        ArrayList<Integer> coordinates = new ArrayList<>();
        coordinates.add(0);
        coordinates.add(0);

        heightb.add(0);

        if (height<6){
            heightb.add(Random.create().nextBetween(height/3,2*height/3));
            heightb.add((Random.create().nextBetween(heightb.get(1)+1,(height*2)/3)));
        }else {

            heightb.add(Random.create().nextBetween(height/4,height/2));
            heightb.add((Random.create().nextBetween(heightb.get(1)+1,(height*3)/4)));
            heightb.add((Random.create().nextBetween(heightb.get(2)+1,(height*3)/4)));
        }

        coordinates = getTrunkDirection(direction,heightb.size()-1,coordinates);
        placeTrunk(heightb,mutable,pos,world, Blocks.MUSHROOM_STEM.getDefaultState(),coordinates);
        int lastx=coordinates.get(coordinates.size()-2);
        int lastz=coordinates.get(coordinates.size()-1);
        return new Integer[]{lastx,lastz};
    }



    protected ArrayList<Integer> getTrunkDirection(int direction, int stop, ArrayList<Integer> coordinates){
        if (stop<=0)return coordinates;
        int randomx;
        int randomz;
        if(coordinates.size()==2){
            randomx=0;
            randomz=0;
        }else {
            randomx=coordinates.get(coordinates.size()-2);
            randomz=coordinates.get(coordinates.size()-1);
        }
        int newrandom = Random.create().nextBetween(0,1);


        switch (direction) {
            case 0 :
                randomx = randomx + newrandom;
                randomz =  randomz + (1 - newrandom);
                break;
            case 1 :
                randomx = randomx + newrandom;
                randomz =  randomz - (1 - newrandom);
                break;
            case 2 :
                randomx = randomx - newrandom;
                randomz =  randomz + (1 - newrandom);
                break;
            default :
                randomx = randomx - newrandom;
                randomz =  randomz - (1 - newrandom);
                break;
        }
        coordinates.add(randomx);
        coordinates.add(randomz);
        return getTrunkDirection(direction,stop-1,coordinates);
    }

    protected void placeTrunk(ArrayList<Integer> height, BlockPos.Mutable mutable,BlockPos start, WorldAccess world, BlockState blockstate, ArrayList<Integer> coordinates){
        int a=0;
        int randomx;
        int randomz;
        int intheight;
        int maxheight;
        while(height.size()!=a+1) {
            intheight=height.get(a);
            maxheight=height.get(a+1);
            randomx=coordinates.get(2*a);
            randomz=coordinates.get(2*a+1);
            for (int i = intheight ; i <= maxheight; ++i) {
                System.out.println(randomx +"  "+ i+ "   "+ randomz);
                mutable.set(start,randomx, i, randomz);
                this.setBlockState(world, mutable, blockstate);
            }
            ++a;
        }
    }

    @Override
    protected void generateFirstCap(WorldAccess world, Random random, BlockPos start, int y,Integer[] coordinates, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config, int large) {

    }



}
