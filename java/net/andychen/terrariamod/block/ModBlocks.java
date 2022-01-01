package net.andychen.terrariamod.block;

import net.andychen.terrariamod.TerrariaMod;
import net.andychen.terrariamod.block.custom.*;
import net.andychen.terrariamod.item.ModItemGroup;
import net.andychen.terrariamod.world.features.tree.ShadewoodSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    // ORE
    public static final Block HELLSTONE_ORE_BLOCK = registerBlock("hellstone_ore_block",
            new HellstoneOreBlock(FabricBlockSettings.of(Material.STONE).strength(5.0f).resistance(6000.0f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE).luminance(10)));
    public static final Block CRIMTANE_ORE_BLOCK = registerBlock("crimtane_ore_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).resistance(6000.0f).requiresTool().sounds(BlockSoundGroup.STONE).luminance(6)));
    public static final Block DEMONITE_ORE_BLOCK = registerBlock("demonite_ore_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).resistance(6000.0f).requiresTool().sounds(BlockSoundGroup.STONE).luminance(6)));

    // CRIMSON
    public static final Block SHADEWOOD_LOG = registerBlock("shadewood_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block SHADEWOOD_LEAVES = registerBlock("shadewood_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).requiresTool()));
    public static final Block SHADEWOOD_SAPLING = registerBlock("shadewood_sapling",
            new ModSaplingBlock(new ShadewoodSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));
    public static final Block SHADEWOOD_PLANKS = registerBlock("shadewood_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block SHADEWOOD_STAIRS = registerBlock("shadewood_stairs",
            new ModStairsBlock(ModBlocks.SHADEWOOD_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS)));
    public static final Block SHADEWOOD_SLAB = registerBlock("shadewood_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)));
    public static final Block SHADEWOOD_DOOR = registerBlock("shadewood_door",
            new ModDoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR).nonOpaque()));
    public static final Block CRIMSTONE = registerBlock("crimstone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f).resistance(6.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block CRIMSAND = registerBlock("crimsand",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block VICIOUS_MUSHROOM = registerBlock("vicious_mushroom",
            new ViciousMushroomBlock(FabricBlockSettings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)));
    public static final Block CRIMSON_FOLIAGE = registerBlock("crimson_foliage",
            new FoliageBlock(FabricBlockSettings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)));

    // CORRUPTION
    public static final Block EBONWOOD_LOG = registerBlock("ebonwood_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block EBONWOOD_LEAVES = registerBlock("ebonwood_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).requiresTool()));
    public static final Block EBONWOOD_PLANKS = registerBlock("ebonwood_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block EBONWOOD_STAIRS = registerBlock("ebonwood_stairs",
            new ModStairsBlock(ModBlocks.EBONWOOD_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS)));
    public static final Block EBONWOOD_SLAB = registerBlock("ebonwood_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)));
    public static final Block EBONWOOD_DOOR = registerBlock("ebonwood_door",
            new ModDoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR).nonOpaque()));
    public static final Block EBONSTONE = registerBlock("ebonstone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f).resistance(6.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block EBONSAND = registerBlock("ebonsand",
            new FallingBlock(FabricBlockSettings.copy(Blocks.SAND)));

    // STONE
    public static final Block GRANITE = registerBlock("granite",
            new Block(FabricBlockSettings.copy(Blocks.STONE)));
    public static final Block MARBLE = registerBlock("marble",
            new Block(FabricBlockSettings.copy(Blocks.STONE)));
    public static final Block SMOOTH_GRANITE = registerBlock("smooth_granite",
            new Block(FabricBlockSettings.copy(Blocks.STONE)));
    public static final Block SMOOTH_MARBLE = registerBlock("smooth_marble",
            new Block(FabricBlockSettings.copy(Blocks.STONE)));

    public static final Block EXTRACTINATOR = registerBlock("extractinator",
            new Block(FabricBlockSettings.of(Material.METAL).strength(1.5f).resistance(30.0f).requiresTool().sounds(BlockSoundGroup.METAL).nonOpaque()));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(TerrariaMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registry.ITEM, new Identifier(TerrariaMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(ModItemGroup.TERRARIA)));
    }

    public static void registerModBlocks(){
        System.out.println("Registering ModBlocks for " + TerrariaMod.MOD_ID);
    }
}
