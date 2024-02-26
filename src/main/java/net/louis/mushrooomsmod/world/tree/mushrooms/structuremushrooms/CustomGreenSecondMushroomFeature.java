package net.louis.mushrooomsmod.world.tree.mushrooms.structuremushrooms;

import com.mojang.serialization.Codec;
import me.emafire003.dev.structureplacerapi.StructurePlacerAPI;
import net.louis.mushrooomsmod.MushrooomsMod;
import net.louis.mushrooomsmod.world.ModConfiguredFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
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
    protected ArrayList<Integer> getCoordinates(WorldAccess world, Random random, BlockPos pos, BlockPos.Mutable mutable, int height, HugeMushroomFeatureConfig config) {
        int direction = Random.create().nextBetween(0,3);
        ArrayList<Integer> heightb=new ArrayList<>();
        ArrayList<Integer> coordinates = new ArrayList<>();
        coordinates.add(0);
        coordinates.add(0);

        heightb.add(0);

        ArrayList<Integer> values = new ArrayList<>();

        if (height<7){
            heightb.add(Random.create().nextBetween(height/3,2*height/3-1));
            heightb.add((Random.create().nextBetween(heightb.get(1)+1,(height*2)/3)));
        }else {

            heightb.add(Random.create().nextBetween(height/4,height/2));
            heightb.add((Random.create().nextBetween(heightb.get(1)+1,(height*3)/4-1)));
            heightb.add((Random.create().nextBetween(heightb.get(2)+1,(height*3)/4)));
        }
        values.add(heightb.size());
        for(int i=0;i<heightb.size();++i){
            values.add(heightb.get(i));
        }

        ArrayList<Integer> directions = getTrunkDirection(direction,heightb.size()-1,coordinates);

        for(int i=0;i<directions.size();++i){
            values.add(directions.get(i));
        }

        return values;
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

    protected void placeTrunk(ArrayList<Integer> height, BlockPos.Mutable mutable,BlockPos start, WorldAccess world, BlockState blockstate, ArrayList<Integer> coordinates, int lastheight){
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
                mutable.set(start,randomx, i, randomz);
                this.setBlockState(world, mutable, blockstate);
            }
            ++a;
        }
        for (int i = height.get(height.size()-1) ; i <= lastheight; ++i) {
            randomx = coordinates.get(coordinates.size()-2);
            randomz = coordinates.get(coordinates.size()-1);
            mutable.set(start,randomx, i, randomz);
            this.setBlockState(world, mutable, blockstate);
        }
    }

    @Override
    protected Integer[] generateFirstCap(WorldAccess world, Random random, BlockPos start, int y,Integer[] coordinates, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config, int large) {
        int cap = getCap(large);
        int large1;
        int rotation = Random.create().nextInt(4);
        BlockRotation blockRotation;

        String path = "green_cap/first_cap/green_first_cap_" + large + "_"+cap;

        mutable.set(start,coordinates[0],y,coordinates[1]);

        blockRotation = getBlockRotation(rotation);

        Integer[] coordinatesRotation = getCoordinatesRotation(rotation,large);
        large=coordinatesRotation[0];
        large1=coordinatesRotation[1];


        if(!world.isClient()){
            StructurePlacerAPI firstcap = new StructurePlacerAPI((ServerWorld)world, new Identifier(MushrooomsMod.MOD_ID, path), mutable, BlockMirror.NONE,blockRotation,true,1f,new BlockPos(large,0,large1));
            firstcap.loadStructure();
        }
        return new Integer[]{rotation,cap};
    }

    @Override
    protected void generateSecondCap(WorldAccess world, Random random, BlockPos start, int height, Integer[] coordinates, BlockPos.Mutable mutable, HugeMushroomFeatureConfig var6, int large, int rotation, int cap) {
        int large1;
        BlockRotation blockRotation;

        String path = "green_cap/second_cap/green_second_cap_" + large + "_"+cap+"_"+  Random.create().nextBetween(1,2);


        mutable.set(start,coordinates[0],height-1,coordinates[1]);

        blockRotation = getBlockRotation(rotation);

        Integer[] coordinatesRotation = getCoordinatesRotation(rotation,large+1);
        large=coordinatesRotation[0];
        large1=coordinatesRotation[1];
        if(!world.isClient()){
            StructurePlacerAPI secondcap = new StructurePlacerAPI((ServerWorld)world, new Identifier(MushrooomsMod.MOD_ID, path), mutable, BlockMirror.NONE,blockRotation,true,1f,new BlockPos(large,0,large1));
            secondcap.loadStructure();
        }
    }
    @Override
    protected void generateThirdCap(WorldAccess world, Random random, BlockPos start, int height, Integer[] coordinates, BlockPos.Mutable mutable, HugeMushroomFeatureConfig var6, int large, int rotation) {
        int large1;
        int cap = getCap(large);
        BlockRotation blockRotation;

        String path = "green_cap/first_cap/green_first_cap_" + large + "_"+cap;

        mutable.set(start,coordinates[0],height+1,coordinates[1]);

        blockRotation = getBlockRotation(rotation);

        Integer[] coordinatesRotation = getCoordinatesRotation(rotation,large);
        large=coordinatesRotation[0];
        large1=coordinatesRotation[1];

        if(!world.isClient()){
            StructurePlacerAPI firstcap = new StructurePlacerAPI((ServerWorld)world, new Identifier(MushrooomsMod.MOD_ID, path), mutable, BlockMirror.NONE,blockRotation,true,1f,new BlockPos(large,0,large1));
            firstcap.loadStructure();
        }
    }

    protected Integer getCap(int large){
        switch (large) {
            case 1 :
                return Random.create().nextBetween(1,6);
            case 2 :
                return Random.createLocal().nextBetween(1,5);
            case 3 :
                return Random.createLocal().nextBetween(1,8);
            default:
                return Random.create().nextBetween(1,10);
        }
    }
    protected Integer[] getCoordinatesRotation(int rotation,int large){
        int large1;
        switch (rotation){
            default :
                large1=large;
                large=-large;
                break;
            case 2 :
                large1=large;
                break;
            case 1 :
                large1=-large;
                break;
            case 0 :
                large=-large;
                large1=large;
                break;
        }
        return new Integer[]{large,large1};
    }
    protected BlockRotation getBlockRotation(int rotation){
        BlockRotation blockRotation;
        switch (rotation){
            case 0 :
                blockRotation = BlockRotation.NONE;
                break;
            case 1 :
                blockRotation = BlockRotation.CLOCKWISE_90;
                break;
            case 2 :
                blockRotation = BlockRotation.CLOCKWISE_180;
                break;
            default:
                blockRotation = BlockRotation.COUNTERCLOCKWISE_90;
                break;
        }
        return blockRotation;
    }


    @Override
    protected void placeDown(WorldAccess world, Random random,BlockPos pos, BlockPos.Mutable mutable, int height, int large,HugeMushroomFeatureConfig config){
        BlockState blockstate = config.capProvider.get(random, pos);
        int randomx;
        int randomz;
        int x;
        int z;
        int down = Random.create().nextBetween(1,large*2);
        int random2=5;

        for (int i = 0;i<=down;++i){
            int random1 = Random.create().nextBetween(0,3);

            if(random1==random2)random1=(random1+Random.create().nextBetween(1,3))%4;

            if(random1==0){
                x= Random.create().nextBetween(-large-1,large+1);
                z=large+1;
            } else if (random1==1) {
                x= Random.create().nextBetween(-large-1,large+1);
                z=-large-1;
            } else if (random1==2) {
                z= Random.create().nextBetween(-large-1,large+1);
                x=large+1;
            }else {
                z= Random.create().nextBetween(-large-1,large+1);
                x=-large-1;
            }


            if(x<0){
                randomx=1;
            }else {
                randomx=-1;
            }

            if(z<0){
                randomz=1;
            }else{
                randomz=-1;
            }

            mutable.set(pos, x,height-2,z);

            boolean blockontop = false;
            if (world.getBlockState(mutable.up()).isOf(blockstate.getBlock()))blockontop=true;

            while (!blockontop){

                if(Math.abs(x)>large+1||Math.abs(z)>large+1)return;

                x=x+randomx;
                mutable.set(pos,x,height-2,z);

                if (world.getBlockState(mutable.up()).isOf(blockstate.getBlock()))break;

                z=z+randomz;
                mutable.set(pos,x,height-2,z);

                if (world.getBlockState(mutable.up()).isOf(blockstate.getBlock()))break;
            }

            int randomj = Random.create().nextBetween(0,2);

            for(int j=0;j<=randomj;++j){
                mutable.set(pos,x,height-2-j,z);
                this.setBlockState(world,mutable,blockstate);
            }
            random2=random1;
        }
    }



}
