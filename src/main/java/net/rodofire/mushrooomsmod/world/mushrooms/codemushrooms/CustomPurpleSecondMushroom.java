package net.rodofire.mushrooomsmod.world.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.rodofire.mushrooomsmod.feature.mushroomfeature.ModMushroomFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;

import java.util.ArrayList;

public class CustomPurpleSecondMushroom extends CustomPurpleSecondMushroomFeature {
    public CustomPurpleSecondMushroom(Codec<ModMushroomFeatureConfig> codec) {
        super(codec);
    }

    //Good Luck understanding what I done here
    @Override
    protected Integer[] placeTrunk(WorldAccess world, Random random, BlockPos start, int y, BlockPos.Mutable mutable, ModMushroomFeatureConfig config) {
        int rand = Random.create().nextBetween(12, 18);
        int randnumbcap = Random.create().nextBetween(2, 3);

        BlockState blockState = config.stemProvider.get(random, start);
        mutable.set(start, 0, 0, 0);
        this.setBlockState(world, mutable, blockState);

        int randheight1 = Random.create().nextBetween(1, rand / 3 + 1);
        int randheight2 = Random.create().nextBetween(1, rand / 3 + 1);
        int randheight3 = Random.create().nextBetween(1, rand / 3 + 1);
        //int randheight4 = Random.create().nextBetween(1,y/2);
        int randmaxheiht1 = Random.create().nextBetween(4, rand) + randheight1;
        int randmaxheiht2 = Random.create().nextBetween(4, rand) + randheight2;
        int randmaxheiht3 = Random.create().nextBetween(4, rand) + randheight3;
        if (randmaxheiht3 <= 5) {
            randmaxheiht3 = 6;
        }
        if (randmaxheiht2 <= 5) {
            randmaxheiht2 = 6;
        }
        if (randmaxheiht1 <= 5) {
            randmaxheiht1 = 6;
        }
        if (randmaxheiht1 == randmaxheiht2) {
            if (randmaxheiht2 <= 11) {
                randmaxheiht1 = Random.create().nextBetween(8, rand);
            } else {
                randmaxheiht1 = Random.create().nextBetween(6, 9);
            }
        }
        if (randmaxheiht3 == randmaxheiht2) {
            if (randmaxheiht2 <= 11) {
                randmaxheiht3 = Random.create().nextBetween(11, rand);
            } else {
                randmaxheiht3 = Random.create().nextBetween(6, 11);
            }
        }
        if (randmaxheiht3 == randmaxheiht1) {
            if (randheight1 <= 11) {
                randmaxheiht3 = Random.create().nextBetween(11, rand);
            } else {
                randmaxheiht3 = Random.create().nextBetween(6, 11);
            }
        }
        //int randmaxheiht4 = Random.create().nextBetween(2,y) + randheight4;

        int height1 = 0;
        int height2 = 0;
        int height3 = 0;
        //int height4 = 0;
        boolean nord = false;
        boolean nordest = false;
        boolean nordouest = false;
        boolean ouest = false;
        boolean est = false;
        boolean sudest = false;
        boolean sud = false;
        boolean sudouest = false;
        String choisis = "";

        int direction1 = Random.create().nextBetween(0, 7);
        if (direction1 == 0) {
            nord = true;
            choisis = "nord";
        } else if (direction1 == 1) {
            nordouest = true;
            choisis = "nordouest";
        } else if (direction1 == 2) {
            ouest = true;
            choisis = "ouest";
        } else if (direction1 == 3) {
            sudouest = true;
            choisis = "sudouest";
        } else if (direction1 == 4) {
            sud = true;
            choisis = "sud";
        } else if (direction1 == 5) {
            sudest = true;
            choisis = "sudest";
        } else if (direction1 == 6) {
            est = true;
            choisis = "est";
        } else if (direction1 == 7) {
            nordest = true;
            choisis = "nordest";
        }


        int maxh = Math.max(randmaxheiht3, randmaxheiht1);
        int maxmax = Math.max(maxh, randmaxheiht2);

        if (randnumbcap == 2) {
            String seconddirection = get2nddirection(choisis, nord, nordouest, ouest, sudouest, sud, sudest, est, nordest);
            boolean nord2 = false;
            boolean nordouest2 = false;
            boolean ouest2 = false;
            boolean sudouest2 = false;
            boolean sud2 = false;
            boolean sudest2 = false;
            boolean est2 = false;
            boolean nordest2 = false;
            if (seconddirection.equals("nord")) {
                nord2 = true;
            } else if (seconddirection.equals("nordouest")) {
                nordouest2 = true;
            } else if (seconddirection.equals("ouest")) {
                ouest2 = true;
            } else if (seconddirection.equals("sudouest")) {
                sudouest2 = true;
            } else if (seconddirection.equals("sud")) {
                sud2 = true;
            } else if (seconddirection.equals("sudest")) {
                sudest2 = true;
            } else if (seconddirection.equals("est")) {
                est2 = true;
            } else if (seconddirection.equals("nordest")) {
                nordest2 = true;
            }
            int randx1 = 0;
            int randz1 = 0;
            int randx2 = 0;
            int randz2 = 0;
            int randx1n = 0;
            int randz1n = 0;
            int randz2n = 0;
            int randx2n = 0;
            int randvaleur1 = 0;
            int randvaleur2 = 0;
            int randomheight = 0;
            int randomheight2 = 0;
            int randomnewheight = 0;
            int sens = 3;
            int sens2 = 3;
            sens = Random.create().nextBetween(0, 1);
            sens2 = Random.create().nextBetween(0, 1);
            for (int i = 1; i <= maxmax; i++) {
                if (i < randheight1 || i < randheight2) {
                    mutable.set(start, 0, i, 0);
                    this.setBlockState(world, mutable, blockState);
                }
                if (i >= randheight1 && i <= randmaxheiht1) {
                    if (height1 != 0) {
                        height1 = height1 - 1;
                    } else {
                        Integer[] coordinates = posecoordinates(randz1, randx1, randx1n, randz1n, sens, nord, sud, est, ouest, nordouest, nordest, sudouest, sudest);
                        randx1n = coordinates[0];
                        randz1n = coordinates[1];
                        Integer[] height = generateHeight(height1, randomheight, randheight1, i, world, random, start, randmaxheiht1 - i, mutable, config, randz1n, randx1n);
                        height1 = height[0];
                        randomheight = height[1];
                        randz1 = randz1n;
                        randx1 = randx1n;
                    }
                }
                if (i >= randheight2 && i <= randmaxheiht2) {
                    if (height2 != 0) {
                        height2 = height2 - 1;
                    } else {
                        Integer[] coordinates2 = posecoordinates(randz2, randx2, randx2n, randz2n, sens2, nord2, sud2, est2, ouest2, nordouest2, nordest2, sudouest2, sudest2);
                        randx2n = coordinates2[0];
                        randz2n = coordinates2[1];
                        Integer[] height = generateHeight(height2, randomheight2, randheight2, i, world, random, start, randmaxheiht2 - i, mutable, config, randz2n, randx2n);
                        height2 = height[0];
                        randomheight2 = height[1];
                        randz2 = randz2n;
                        randx2 = randx2n;
                    }
                }

            }
            return new Integer[]{randx1n, randmaxheiht1, randz1n, randx2n, randmaxheiht2, randz2n};
        } else {
            String[] directions = get3rddirection(choisis);
            boolean nord2 = false;
            boolean nordouest2 = false;
            boolean ouest2 = false;
            boolean sudouest2 = false;
            boolean sud2 = false;
            boolean sudest2 = false;
            boolean est2 = false;
            boolean nordest2 = false;
            boolean nord3 = false;
            boolean nordouest3 = false;
            boolean ouest3 = false;
            boolean sudouest3 = false;
            boolean sud3 = false;
            boolean sudest3 = false;
            boolean est3 = false;
            boolean nordest3 = false;
            String seconddirection = directions[0];
            String thirddirection = directions[1];
            if (seconddirection.equals("nord")) {
                nord2 = true;
            } else if (seconddirection.equals("nordouest")) {
                nordouest2 = true;
            } else if (seconddirection.equals("ouest")) {
                ouest2 = true;
            } else if (seconddirection.equals("sudouest")) {
                sudouest2 = true;
            } else if (seconddirection.equals("sud")) {
                sud2 = true;
            } else if (seconddirection.equals("sudest")) {
                sudest2 = true;
            } else if (seconddirection.equals("est")) {
                est2 = true;
            } else if (seconddirection.equals("nordest")) {
                nordest2 = true;
            }
            if (thirddirection.equals("nord")) {
                nord3 = true;
            } else if (thirddirection.equals("nordouest")) {
                nordouest3 = true;
            } else if (thirddirection.equals("ouest")) {
                ouest3 = true;
            } else if (thirddirection.equals("sudouest")) {
                sudouest3 = true;
            } else if (thirddirection.equals("sud")) {
                sud3 = true;
            } else if (thirddirection.equals("sudest")) {
                sudest3 = true;
            } else if (thirddirection.equals("est")) {
                est3 = true;
            } else if (thirddirection.equals("nordest")) {
                nordest3 = true;
            }
            int randx1 = 0;
            int randz1 = 0;
            int randx2 = 0;
            int randz2 = 0;
            int randx3 = 0;
            int randz3 = 0;
            int randx1n = 0;
            int randz1n = 0;
            int randz2n = 0;
            int randx2n = 0;
            int randz3n = 0;
            int randx3n = 0;
            int randomheight = 0;
            int randomheight2 = 0;
            int randomheight3 = 0;
            int sens = 3;
            int sens2 = 3;
            int sens3 = 3;
            sens = Random.create().nextBetween(0, 1);
            sens2 = Random.create().nextBetween(0, 1);
            sens3 = Random.create().nextBetween(0, 1);
            for (int i = 1; i <= maxmax; i++) {
                if (i < randheight1 || i < randheight2 || i < randheight3) {
                    mutable.set(start, 0, i, 0);
                    this.setBlockState(world, mutable, blockState);
                }
                if (i >= randheight1 && i <= randmaxheiht1) {
                    if (height1 != 0) {
                        height1 = height1 - 1;
                    } else {
                        Integer[] coordinates = posecoordinates(randz1, randx1, randx1n, randz1n, sens, nord, sud, est, ouest, nordouest, nordest, sudouest, sudest);
                        randx1n = coordinates[0];
                        randz1n = coordinates[1];
                        Integer[] height = generateHeight(height1, randomheight, randheight1, i, world, random, start, randmaxheiht1 - i, mutable, config, randz1n, randx1n);
                        height1 = height[0];
                        randomheight = height[1];
                        randz1 = randz1n;
                        randx1 = randx1n;
                    }
                }
                if (i >= randheight2 && i <= randmaxheiht2) {
                    if (height2 != 0) {
                        height2 = height2 - 1;
                    } else {
                        Integer[] coordinates2 = posecoordinates(randz2, randx2, randx2n, randz2n, sens2, nord2, sud2, est2, ouest2, nordouest2, nordest2, sudouest2, sudest2);
                        randx2n = coordinates2[0];
                        randz2n = coordinates2[1];
                        Integer[] height = generateHeight(height2, randomheight2, randheight2, i, world, random, start, randmaxheiht2 - i, mutable, config, randz2n, randx2n);
                        height2 = height[0];
                        randomheight2 = height[1];
                        randz2 = randz2n;
                        randx2 = randx2n;
                    }
                }
                if (i >= randheight3 && i <= randmaxheiht3) {
                    if (height3 != 0) {
                        height3 = height3 - 1;
                    } else {
                        Integer[] coordinates2 = posecoordinates(randz3, randx3, randx3n, randz3n, sens3, nord3, sud3, est3, ouest3, nordouest3, nordest3, sudouest3, sudest3);
                        randx3n = coordinates2[0];
                        randz3n = coordinates2[1];
                        Integer[] height = generateHeight(height3, randomheight3, randheight3, i, world, random, start, randmaxheiht3 - i, mutable, config, randz3n, randx3n);
                        height3 = height[0];
                        randomheight3 = height[1];
                        randz3 = randz3n;
                        randx3 = randx3n;
                    }
                }
            }
            return new Integer[]{randx1n, randmaxheiht1, randz1n, randx2n, randmaxheiht2, randz2n, randx3n, randmaxheiht3, randz3n};
        }
    }


    protected Integer[] posecoordinates(int randz1, int randx1, int randx1n, int randz1n, int sens, boolean nord, boolean sud, boolean est, boolean ouest, boolean nordouest, boolean nordest, boolean sudouest, boolean sudest) {
        if (randz1 == 0) {
            randx1n = 1;
        }
        if (nord) {
            randx1n = Random.create().nextBetween(0, 6);
            randz1n = Random.create().nextBetween(0, 6);
            if (sens == 0) {
                sens = 1;
            } else {
                sens = -1;
            }
            if (randx1n % 5 == 0) {
                randx1n = randx1;
            } else {
                randx1n = randx1 + 1;
            }
            if (randz1n % 5 == 0) {
                randz1n = randz1 + sens;
            } else {
                randz1n = randz1;
            }
            if (randz1n - randz1 == 0 && randx1n - randx1 == 0) {
                randx1n = randx1 + 1;
            }
        } else if (nordouest) {
            randx1n = Random.create().nextBetween(0, 4);
            randz1n = Random.create().nextBetween(0, 4);
            if (randx1n % 2 == 0) {
                randx1n = randx1;
            } else {
                randx1n = randx1 + 1;
            }
            if (randz1n % 2 == 0) {
                randz1n = randz1;
            } else {
                randz1n = randz1 - 1;
            }
            if (randz1n - randz1 == 0 && randx1n - randx1 == 0) {
                randz1n = randz1 - 1;
                randx1n = randx1 + 1;
            }
        } else if (ouest) {
            if (sens == 0) {
                sens = 1;
            } else {
                sens = -1;
            }
            randx1n = Random.create().nextBetween(0, 6);
            randz1n = Random.create().nextBetween(0, 6);
            if (randx1n % 5 == 0) {
                randx1n = randx1 + sens;
            } else {
                randx1n = randx1;
            }
            if (randz1n % 5 == 0) {
                randz1n = randz1;
            } else {
                randz1n = randz1 - 1;
            }
            if (randz1n - randz1 == 0 && randx1n - randx1 == 0) {
                randz1n = randz1 - 1;
            }
        } else if (sudouest) {
            randx1n = Random.create().nextBetween(0, 4);
            randz1n = Random.create().nextBetween(0, 4);
            if (randx1n % 5 == 0) {
                randx1n = randx1;
            } else {
                randx1n = randx1 - 1;
            }
            if (randz1n % 5 == 0) {
                randz1n = randz1;
            } else {
                randz1n = randz1 - 1;
            }
            if (randz1n - randz1 == 0 && randx1n - randx1 == 0) {
                randz1n = randz1 - 1;
                randx1n = randx1 - 1;
            }

        } else if (sud) {
            if (sens == 0) {
                sens = 1;
            } else {
                sens = -1;
            }
            randx1n = Random.create().nextBetween(0, 6);
            randz1n = Random.create().nextBetween(0, 6);
            if (randx1n % 5 == 0) {
                randx1n = randx1;
            } else {
                randx1n = randx1 - 1;
            }
            if (randz1n % 5 == 0) {
                randz1n = randz1 + sens;
            } else {
                randz1n = randz1;
            }
            if (randz1n - randz1 == 0 && randx1n - randx1 == 0) {
                randx1n = randx1 - 1;
            }
        } else if (sudest) {
            if (sens == 0) {
                sens = 1;
            } else {
                sens = -1;
            }
            randx1n = Random.create().nextBetween(0, 4);
            randz1n = Random.create().nextBetween(0, 4);
            if (randx1n % 5 == 0) {
                randx1n = randx1;
            } else {
                randx1n = randx1 - 1;
            }
            if (randz1n % 5 == 0) {
                randz1n = randz1;
            } else {
                randz1n = randz1 + 1;
            }
            if (randz1n - randz1 == 0 && randx1n - randx1 == 0) {
                randz1n = randz1 + 1;
                randx1n = randx1 - 1;
            }

        } else if (est) {
            randx1n = Random.create().nextBetween(0, 6);
            randz1n = Random.create().nextBetween(0, 6);
            if (randx1n % 5 == 0) {
                randx1n = randx1 + 1;
            } else {
                randx1n = randx1;
            }
            if (randz1n % 5 == 0) {
                randz1n = randz1;
            } else {
                randz1n = randz1 + 1;
            }
            if (randz1n - randz1 == 0 && randx1n - randx1 == 0) {
                randz1n = randz1 + 1;
            }
        } else if (nordest) {
            randx1n = Random.create().nextBetween(0, 4);
            randz1n = Random.create().nextBetween(0, 4);
            if (randx1n % 5 == 0) {
                randx1n = randx1;
            } else {
                randx1n = randx1 + 1;
            }
            if (randz1n % 5 == 0) {
                randz1n = randz1;
            } else {
                randz1n = randz1 + 1;
            }
            if (randz1n - randz1 == 0 && randx1n - randx1 == 0) {
                randz1n = randz1 + 1;
                randx1n = randx1 + 1;
            }
        }
        Integer[] value = new Integer[2];
        value[0] = randx1n;
        value[1] = randz1n;
        return value;
    }

    protected String get2nddirection(String choisis, boolean nord, boolean nordouest, boolean ouest, boolean sudouest, boolean sud, boolean sudest, boolean est, boolean nordest) {
        int index = Random.create().nextBetween(0, 7);
        String direction = "";
        if (index == 0) {
            direction = "nord";
            nord = true;
        } else if (index == 1) {
            direction = "nordouest";
            nordouest = true;
        } else if (index == 2) {
            direction = "ouest";
            ouest = true;
        } else if (index == 3) {
            direction = "sudouest";
            sudouest = true;
        } else if (index == 4) {
            direction = "sud";
            sud = true;
        } else if (index == 5) {
            direction = "sudest";
            sudest = true;
        } else if (index == 6) {
            direction = "est";
            est = true;
        } else if (index == 7) {
            direction = "nordest";
            nordest = true;
        }
        if (!direction.equals(choisis)) {
            if (choisis.equals("nord")) {
                nord = false;
                if (nordest || nordouest) {
                    nordest = false;
                    nordouest = false;
                    direction = get2nddirection(choisis, nord, nordouest, ouest, sudouest, sud, sudest, est, nordest);
                }
            }
            if (choisis.equals("nordouest")) {
                nordouest = false;
                if (nord || ouest) {
                    nord = false;
                    ouest = false;
                    direction = get2nddirection(choisis, nord, nordouest, ouest, sudouest, sud, sudest, est, nordest);
                }
            }
            if (choisis.equals("ouest")) {
                ouest = false;
                if (nordouest || sudouest) {
                    nordouest = false;
                    sudouest = false;
                    direction = get2nddirection(choisis, nord, nordouest, ouest, sudouest, sud, sudest, est, nordest);
                }
            }
            if (choisis.equals("sudouest")) {
                sudouest = false;
                if (sud || ouest) {
                    sud = false;
                    ouest = false;
                    direction = get2nddirection(choisis, nord, nordouest, ouest, sudouest, sud, sudest, est, nordest);
                }
            }
            if (choisis.equals("sud")) {
                sud = false;
                if (sudest || sudouest) {
                    sudest = false;
                    sudouest = false;
                    direction = get2nddirection(choisis, nord, nordouest, ouest, sudouest, sud, sudest, est, nordest);
                }
            }
            if (choisis.equals("sudest")) {
                sudest = false;
                if (sud || est) {
                    sud = false;
                    est = false;
                    direction = get2nddirection(choisis, nord, nordouest, ouest, sudouest, sud, sudest, est, nordest);
                }
            }
            if (choisis.equals("est")) {
                est = false;
                if (nordest || sudest) {
                    nordest = false;
                    sudest = false;
                    direction = get2nddirection(choisis, nord, nordouest, ouest, sudouest, sud, sudest, est, nordest);
                }
            }
            if (choisis.equals("nordest")) {
                nordest = false;
                if (nord || est) {
                    nord = false;
                    est = false;
                    direction = get2nddirection(choisis, nord, nordouest, ouest, sudouest, sud, sudest, est, nordest);
                }
            }

        } else {
            direction = get2nddirection(choisis, nord, nordouest, ouest, sudouest, sud, sudest, est, nordest);
        }
        return direction;
    }

    protected String[] get3rddirection(String choisis) {
        int index = Random.create().nextBetween(2, 4);
        int index2 = Random.create().nextBetween(index + 1, 6);
        String direction2 = "";
        String direction3 = "";
        ArrayList<String> directions = new ArrayList<>();
        directions = getStringdirection(choisis, directions);
        direction2 = directions.get(index);
        direction3 = directions.get(index2);
        return new String[]{direction2, direction3};
    }

    protected ArrayList<String> getStringdirection(String choisis, ArrayList<String> directions) {
        if (directions.size() == 8) {
            return directions;
        }

        if (choisis.equals("nord")) {
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


    protected Integer[] generateHeight(int height1, int randomheight, int randstartheight, int i, WorldAccess world, Random random, BlockPos start, int maxheight, BlockPos.Mutable mutable, ModMushroomFeatureConfig config, int randz1n, int randx1n) {
        BlockState blockState = config.stemProvider.get(random, start);
        int randomnewheight;
        randomnewheight = Random.create().nextBetween(0, 10);
        if (randomnewheight < 3 && randomheight < 7 && randstartheight < 6 || maxheight == 1) {
            mutable.set(start, randx1n, i, randz1n);
            this.setBlockState(world, mutable, blockState);
        } else if (randomnewheight >= 7 && randomheight >= 3 && maxheight > randomnewheight - 5) {
            for (int a = 0; a <= randomnewheight - 5; ++a) {
                mutable.set(start, randx1n, a + i, randz1n);
                this.setBlockState(world, mutable, blockState);
            }
            height1 = randomnewheight - 5;
        } else {
            mutable.set(start, randx1n, i, randz1n);
            this.setBlockState(world, mutable, blockState);
            mutable.set(start, randx1n, i + 1, randz1n);
            this.setBlockState(world, mutable, blockState);
            height1 = 1;
        }
        randomheight = randomnewheight;
        Integer[] height = new Integer[2];
        height[0] = height1;
        height[1] = randomheight;
        return height;
    }

    @Override
    protected int getCapSize(int var1, int var2, int var3, int var4) {
        return 0;
    }


    protected void placeBranch(WorldAccess world, BlockPos pos, BlockPos.Mutable mutable, int dx, int dy, int dz, int a) {

    }

    @Override
    protected void generateCap(WorldAccess world, Random random, BlockPos start, BlockPos.Mutable mutable, Integer[] coordinates, ModMushroomFeatureConfig config) {
        int capheightsize = 0;
        int xmax = 0;
        int x = 0;
        int y = 0;
        int z = 0;
        int capsize = 0;
        BlockState blockState = config.capProvider.get(random, start);
        for (int i = 0; i < coordinates.length / 3; ++i) {
            capheightsize = Random.create().nextBetween(2, 3);
            x = coordinates[i * 3];
            y = coordinates[i * 3 + 1];
            z = coordinates[i * 3 + 2];
            xmax = getCapSize(x, y, z, 0, mutable, world, start);
            capsize = Random.create().nextBetween(2, xmax);
            if (capsize < 5) {
                capheightsize = 2;
            }
            for (int c = y; c < capheightsize + y; ++c) {
                for (int b = -capsize; b <= capsize; ++b) {
                    for (int a = -capsize; a <= capsize; ++a) {
                        if (c < 2 + y) {
                            if (capsize > 4) {
                                if ((a > capsize - 2 || -a > capsize - 2) && (b > capsize - 2 || -b > capsize - 2))
                                    continue;
                                if ((a > capsize - 3 || -a > capsize - 3) && (b == capsize || -b == capsize)) continue;
                                if ((b > capsize - 3 || -b > capsize - 3) && (a == capsize || -a == capsize)) continue;
                            } else {
                                if ((a == capsize || -a == capsize) && (b == capsize || -b == capsize)) continue;
                            }
                            mutable.set(start, x + a, c + 1, z + b);
                            this.setBlockState(world, mutable, blockState);

                        } else {
                            if ((a > capsize - 3 || -a > capsize - 3) && (b > capsize - 3 || -b > capsize - 3))
                                continue;
                            if ((a > capsize - 4 || -a > capsize - 4) && (b == capsize - 1 || -b == capsize - 1))
                                continue;
                            if ((b > capsize - 4 || -b > capsize - 4) && (a == capsize - 1 || -a == capsize - 1))
                                continue;
                            if ((a > capsize - 7 || -a > capsize - 7) && (b == capsize || -b == capsize)) continue;
                            if ((b > capsize - 7 || -b > capsize - 7) && (a == capsize || -a == capsize)) continue;
                            mutable.set(start, x + a, c + 1, z + b);
                            this.setBlockState(world, mutable, blockState);
                        }
                    }
                }
            }
        }
    }

    protected Integer getCapSize(int x, int y, int z, int a, BlockPos.Mutable mutable, WorldAccess world, BlockPos start) {
        BlockState blockState = Blocks.REDSTONE_BLOCK.getDefaultState();
        if (a == 6) {
            return a;
        }
        for (int k = 0; k < 3; ++k) {
            for (int i = x - a; i <= x + a; ++i) {
                for (int j = z - a; j <= z + a; ++j) {
                    if ((i <= 1 + x && i >= -1 + x) && (j <= 1 + z && j >= -1 + z)) {
                        continue;
                    }
                    BlockState blockState2 = world.getBlockState(mutable.set(start, i, y + k, j));
                    if (blockState2.isAir() || blockState2.isIn(BlockTags.LEAVES)) continue;
                    if (a - 1 < 2) {
                        a = 3;
                    }
                    return a - 1;
                }
            }
        }

        return getCapSize(x, y, z, a + 1, mutable, world, start);
    }

    @Override
    protected void generateSecondCap(WorldAccess var1, Random var2, BlockPos var3, int var4, BlockPos.Mutable var5, ModMushroomFeatureConfig var6, int var7) {

    }

    @Override
    protected void generateBottomCap(WorldAccess var1, Random var2, BlockPos var3, int var4, BlockPos.Mutable var5, ModMushroomFeatureConfig var6, int var7) {

    }


}
