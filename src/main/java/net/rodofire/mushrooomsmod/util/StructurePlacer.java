package net.rodofire.mushrooomsmod.util;

import java.util.Optional;

import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.structure.processor.BlockRotStructureProcessor;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.InvalidIdentifierException;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;

public class StructurePlacer {

    private StructureWorldAccess world;
    private Identifier templateName;
    private BlockPos blockPos;
    private BlockMirror mirror;
    private BlockRotation rotation;
    private boolean ignoreEntities;
    private float integrity;
    private BlockPos offset = new BlockPos(0, 0, 0);

    public StructurePlacer(StructureWorldAccess world, Identifier templateName, BlockPos blockPos, BlockMirror mirror, BlockRotation rotation, boolean ignoreEntities, float integrity, BlockPos offset) {
        this.world = world;
        this.templateName = templateName;
        this.blockPos = blockPos;
        this.mirror = mirror;
        this.rotation = rotation;
        this.ignoreEntities = ignoreEntities;
        this.integrity = integrity;
        this.offset = offset;
    }

    public StructurePlacer(StructureWorldAccess world, Identifier templateName, BlockPos blockPos) {
        this.world = world;
        this.templateName = templateName;
        this.blockPos = blockPos;
        this.mirror = BlockMirror.NONE;
        this.rotation = BlockRotation.NONE;
        this.ignoreEntities = true;
        this.integrity = 1.0F;
        this.offset = new BlockPos(0, 0, 0);
    }

    public StructurePlacer(StructureWorldAccess world, Identifier templateName, BlockPos blockPos, BlockPos offset) {
        this.world = world;
        this.templateName = templateName;
        this.blockPos = blockPos;
        this.mirror = BlockMirror.NONE;
        this.rotation = BlockRotation.NONE;
        this.ignoreEntities = true;
        this.integrity = 1.0F;
        this.offset = offset;
    }

    public StructurePlacer(StructureWorldAccess world, Identifier templateName, BlockPos blockPos, BlockMirror mirror) {
        this.world = world;
        this.templateName = templateName;
        this.blockPos = blockPos;
        this.mirror = mirror;
        this.rotation = BlockRotation.NONE;
        this.ignoreEntities = true;
        this.integrity = 1.0F;
        this.offset = new BlockPos(0, 0, 0);
    }

    public StructurePlacer(StructureWorldAccess world, Identifier templateName, BlockPos blockPos, BlockRotation rotation) {
        this.world = world;
        this.templateName = templateName;
        this.blockPos = blockPos;
        this.mirror = BlockMirror.NONE;
        this.rotation = rotation;
        this.ignoreEntities = true;
        this.integrity = 1.0F;
        this.offset = new BlockPos(0, 0, 0);
    }

    public StructurePlacer(StructureWorldAccess world, Identifier templateName, BlockPos blockPos, BlockMirror mirror, BlockRotation rotation) {
        this.world = world;
        this.templateName = templateName;
        this.blockPos = blockPos;
        this.mirror = mirror;
        this.rotation = rotation;
        this.ignoreEntities = true;
        this.integrity = 1.0F;
        this.offset = new BlockPos(0, 0, 0);
    }

    public StructurePlacer(StructureWorldAccess world, Identifier templateName, BlockPos blockPos, float integrity) {
        this.world = world;
        this.templateName = templateName;
        this.blockPos = blockPos;
        this.mirror = BlockMirror.NONE;
        this.rotation = BlockRotation.NONE;
        this.ignoreEntities = true;
        this.integrity = integrity;
        this.offset = new BlockPos(0, 0, 0);
    }

    public boolean loadStructure() {
        if (this.templateName != null) {
            StructureTemplateManager structureTemplateManager = this.world.getServer().getStructureTemplateManager();

            Optional optional;
            try {
                optional = structureTemplateManager.getTemplate(this.templateName);
            } catch (InvalidIdentifierException var4) {
                return false;
            }

            return !optional.isPresent() ? false : this.place((StructureTemplate) optional.get());
        } else {
            return false;
        }
    }

    public boolean place(StructureTemplate template) {
        try {
            StructurePlacementData structurePlacementData = (new StructurePlacementData()).setMirror(this.mirror).setRotation(this.rotation).setIgnoreEntities(this.ignoreEntities);
            if (this.integrity < 1.0F) {
                structurePlacementData.clearProcessors().addProcessor(new BlockRotStructureProcessor(MathHelper.clamp(this.integrity, 0.0F, 1.0F))).setRandom(createRandom(this.world.getSeed()));
            }

            BlockPos blockPos2 = this.blockPos.add(this.offset);
            template.place(this.world, blockPos2, blockPos2, structurePlacementData, createRandom(this.world.getSeed()), 2);
            this.unloadStructure();
            return true;
        } catch (Exception var4) {
            Exception e = var4;
            e.printStackTrace();
            return false;
        }
    }

    public void unloadStructure() {
        if (this.templateName != null) {
            StructureTemplateManager structureTemplateManager = this.world.getServer().getStructureTemplateManager();
            structureTemplateManager.unloadTemplate(this.templateName);
        }

    }

    public static Random createRandom(long seed) {
        return seed == 0L ? Random.create(Util.getMeasuringTimeMs()) : Random.create(seed);
    }
}
