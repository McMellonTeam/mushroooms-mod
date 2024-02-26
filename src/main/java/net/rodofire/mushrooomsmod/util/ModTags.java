package net.rodofire.mushrooomsmod.util;

import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> MUSHROOM_PLANT =
                createTag("mushroom_plant");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(MushrooomsMod.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> DIAMOND_ITEMS = createTag("diamond_item");
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(MushrooomsMod.MOD_ID, name));
        }
    }
}