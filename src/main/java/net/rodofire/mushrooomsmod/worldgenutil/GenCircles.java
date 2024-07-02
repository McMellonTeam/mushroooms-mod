package net.rodofire.mushrooomsmod.worldgenutil;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;

public class GenCircles {
    //Validate
    public static void generateCircle(StructureWorldAccess world,  int largex, BlockState state, BlockPos pos) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        generateOval(world,  largex, largex, state, x, z, y, false, false);
    }
    public static void generateFullCircle(StructureWorldAccess world,  int largex, BlockState state, BlockPos pos) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        generateOval(world,  largex, largex, state, x, z, y, false, true);
    }
    public static void generateFullCircle(StructureWorldAccess world,  int largex, BlockState state, BlockPos pos,boolean force) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        generateOval(world,  largex, largex, state, x, z, y, force, true);
    }

    public static void generateOval(StructureWorldAccess world, int radiusX, int radiusZ, BlockState blockState, int centerX, int centerZ, int y, boolean force, boolean full) {
        int x = 0;
        int z = radiusZ;
        int twoASquare = 2 * radiusX * radiusX;
        int twoBSquare = 2 * radiusZ * radiusZ;
        int decision1 = (int) (radiusZ * radiusZ - radiusX * radiusX * radiusZ + 0.25 * radiusX * radiusX);
        int dx = twoBSquare * x;
        int dz = twoASquare * z;

        // Region 1
        while (dx < dz) {
            if(!full) {
                placeOvalBlocks(world, blockState, centerX, centerZ, x, y, z, force);
            }else {
                placeFullOval(world, blockState, centerX, centerZ, x, y, z, force);
            }
            if (decision1 < 0) {
                x++;
                dx = dx + twoBSquare;
                decision1 = decision1 + dx + radiusZ * radiusZ;
            } else {
                x++;
                z--;
                dx = dx + twoBSquare;
                dz = dz - twoASquare;
                decision1 = decision1 + dx - dz + radiusZ * radiusZ;
            }
        }

        // Region 2
        int decision2 = (int) (radiusZ * radiusZ * (x + 0.5) * (x + 0.5) + radiusX * radiusX * (z - 1) * (z - 1) - radiusX * radiusX * radiusZ * radiusZ);
        while (z >= 0) {
            if(!full) {
                placeOvalBlocks(world, blockState, centerX, centerZ, x, y, z, force);
            }else {
                placeFullOval(world, blockState, centerX, centerZ, x, y, z, force);
            }
            if (decision2 > 0) {
                z--;
                dz = dz - twoASquare;
                decision2 = decision2 + radiusX * radiusX - dz;
            } else {
                z--;
                x++;
                dx = dx + twoBSquare;
                dz = dz - twoASquare;
                decision2 = decision2 + dx - dz + radiusX * radiusX;
            }
        }
    }

    public static void placeOvalBlocks(StructureWorldAccess world, BlockState blockstate, int centerX, int centerZ, int x, int y, int z, boolean force) {
        BlockPos.Mutable pos = new BlockPos.Mutable();
        if(!force){
            if(world.getBlockState(pos.set(centerX + x, y, centerZ + z)).isAir()){
                world.setBlockState(pos, blockstate, 2);
            }
            if(world.getBlockState(pos.set(centerX + x, y, centerZ - z)).isAir()){
                world.setBlockState(pos, blockstate, 2);
            }
            if (world.getBlockState(pos.set(centerX - x, y, centerZ + z)).isAir()){
                world.setBlockState(pos, blockstate, 2);
            }
            if (world.getBlockState(pos.set(centerX - x, y, centerZ - z)).isAir()){
                world.setBlockState(pos, blockstate, 2);
            }
        }else {
            world.setBlockState(pos.set(centerX + x, y, centerZ + z), blockstate, 2);
            world.setBlockState(pos.set(centerX + x, y, centerZ - z), blockstate, 2);
            world.setBlockState(pos.set(centerX - x, y, centerZ + z), blockstate, 2);
            world.setBlockState(pos.set(centerX - x, y, centerZ - z), blockstate, 2);
        }

    }
    public static void placeFullOval(StructureWorldAccess world, BlockState blockstate, int centerX, int centerZ, int x, int y, int z, boolean force){
        BlockPos start1 = new BlockPos(centerX + x, y, centerZ + z);
        BlockPos start2 = new BlockPos(centerX - x, y, centerZ + z);

        BlockPos end1 = new BlockPos(centerX + x, y, centerZ - z);
        BlockPos end2 = new BlockPos(centerX - x, y, centerZ - z);
        GenLines.drawLine(world,start1,end1,blockstate,force);
        GenLines.drawLine(world,start2,end2,blockstate,force);
    }
}
