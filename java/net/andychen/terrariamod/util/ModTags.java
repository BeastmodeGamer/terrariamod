package net.andychen.terrariamod.util;

import net.andychen.terrariamod.TerrariaMod;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {

        public static final Tag<Block> NEEDS_DIAMOND_TOOL = TagFactory.BLOCK.create(new Identifier("minecraft", "needs_diamond_tool"));
    }

    public static class Items {

        public static final Tag<Item> PICKAXE = TagFactory.ITEM.create(new Identifier("minecraft", "pickaxe"));
    }
}
