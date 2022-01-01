package net.andychen.terrariamod.item;

import net.andychen.terrariamod.TerrariaMod;
import net.andychen.terrariamod.entity.ModEntityType;
import net.andychen.terrariamod.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    // DEMONITE
    public static final Item DEMONITE_ORE = registerItem("demonite_ore",
            new DemoniteOreItem(new FabricItemSettings().group(ModItemGroup.TERRARIA)));
    public static final Item DEMONITE_INGOT = registerItem("demonite_ingot",
            new DemoniteIngotItem(new FabricItemSettings().group(ModItemGroup.TERRARIA)));

    public static final Item DEMONITE_HELMET = registerItem("demonite_helmet",
            new DemoniteArmorItem(ModArmorMaterial.DEMONITE, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.TERRARIA)));
    public static final Item DEMONITE_CHESTPLATE = registerItem("demonite_chestplate",
            new ArmorItem(ModArmorMaterial.DEMONITE, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.TERRARIA)));
    public static final Item DEMONITE_LEGGINGS = registerItem("demonite_leggings",
            new ArmorItem(ModArmorMaterial.DEMONITE, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroup.TERRARIA)));
    public static final Item DEMONITE_BOOTS = registerItem("demonite_boots",
            new ArmorItem(ModArmorMaterial.DEMONITE, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.TERRARIA)));

    // CRIMSON
    public static final Item CRIMTANE_ORE = registerItem("crimtane_ore",
            new Item(new FabricItemSettings().group(ModItemGroup.TERRARIA)));
    public static final Item CRIMTANE_INGOT = registerItem("crimtane_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.TERRARIA)));

    public static final Item CRIMSON_HELMET = registerItem("crimson_helmet",
            new CrimsonArmorItem(ModArmorMaterial.CRIMSON, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.TERRARIA)));
    public static final Item CRIMSON_CHESTPLATE = registerItem("crimson_chestplate",
            new ArmorItem(ModArmorMaterial.CRIMSON, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.TERRARIA)));
    public static final Item CRIMSON_LEGGINGS = registerItem("crimson_leggings",
            new ArmorItem(ModArmorMaterial.CRIMSON, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroup.TERRARIA)));
    public static final Item CRIMSON_BOOTS = registerItem("crimson_boots",
            new ArmorItem(ModArmorMaterial.CRIMSON, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.TERRARIA)));

    // HELLSTONE
    public static final Item HELLSTONE_ORE = registerItem("hellstone_ore",
            new Item(new FabricItemSettings().fireproof().group(ModItemGroup.TERRARIA)));
    public static final Item HELLSTONE_INGOT = registerItem("hellstone_ingot",
            new HellstoneIngotItem(new FabricItemSettings().fireproof().group(ModItemGroup.TERRARIA)));

    public static final Item HELLSTONE_SWORD = registerItem("hellstone_sword",
            new HellstoneSwordItem(ModToolMaterial.HELLSTONE, 4, 0f, new FabricItemSettings().fireproof().group(ModItemGroup.TERRARIA)));
    public static final Item HELLSTONE_PICKAXE = registerItem("hellstone_pickaxe",
            new HellstonePickaxeItem(ModToolMaterial.HELLSTONE, 2, 0f, new FabricItemSettings().fireproof().group(ModItemGroup.TERRARIA)));
    public static final Item HELLSTONE_AXE = registerItem("hellstone_axe",
            new HellstoneAxeItem(ModToolMaterial.HELLSTONE, 6, -0.4f, new FabricItemSettings().fireproof().group(ModItemGroup.TERRARIA)));

    public static final Item HELLSTONE_HELMET = registerItem("hellstone_helmet",
            new HellstoneArmorItem(ModArmorMaterial.HELLSTONE, EquipmentSlot.HEAD, new FabricItemSettings().fireproof().group(ModItemGroup.TERRARIA)));
    public static final Item HELLSTONE_CHESTPLATE = registerItem("hellstone_chestplate",
            new ArmorItem(ModArmorMaterial.HELLSTONE, EquipmentSlot.CHEST, new FabricItemSettings().fireproof().group(ModItemGroup.TERRARIA)));
    public static final Item HELLSTONE_LEGGINGS = registerItem("hellstone_leggings",
            new ArmorItem(ModArmorMaterial.HELLSTONE, EquipmentSlot.LEGS, new FabricItemSettings().fireproof().group(ModItemGroup.TERRARIA)));
    public static final Item HELLSTONE_BOOTS = registerItem("hellstone_boots",
            new ArmorItem(ModArmorMaterial.HELLSTONE, EquipmentSlot.FEET, new FabricItemSettings().fireproof().group(ModItemGroup.TERRARIA)));

    public static final Item BOMB = registerItem("bomb",
            new BombItem(new FabricItemSettings().group(ModItemGroup.TERRARIA).maxCount(16)));

    public static final Item AMETHYST_STAFF = registerItem("amethyst_staff",
            new AmethystStaffItem(new FabricItemSettings().group(ModItemGroup.TERRARIA).maxCount(1)));
    public static final Item TOPAZ_STAFF = registerItem("topaz_staff",
            new TopazStaffItem(new FabricItemSettings().group(ModItemGroup.TERRARIA).maxCount(1)));
    public static final Item SAPPHIRE_STAFF = registerItem("sapphire_staff",
            new SapphireStaffItem(new FabricItemSettings().group(ModItemGroup.TERRARIA).maxCount(1)));
    public static final Item EMERALD_STAFF = registerItem("emerald_staff",
            new EmeraldStaffItem(new FabricItemSettings().group(ModItemGroup.TERRARIA).maxCount(1)));
    public static final Item RUBY_STAFF = registerItem("ruby_staff",
            new RubyStaffItem(new FabricItemSettings().group(ModItemGroup.TERRARIA).maxCount(1)));
    public static final Item DIAMOND_STAFF = registerItem("diamond_staff",
            new DiamondStaffItem(new FabricItemSettings().group(ModItemGroup.TERRARIA).maxCount(1)));

    public static final Item ROD_OF_DISCORD = registerItem("rod_of_discord",
            new RodOfDiscordItem(new FabricItemSettings().group(ModItemGroup.TERRARIA).maxCount(1)));
    public static final Item MAGIC_MIRROR = registerItem("magic_mirror",
            new MagicMirrorItem(new FabricItemSettings().group(ModItemGroup.TERRARIA).maxCount(1)));

    public static final Item SNOWBALL_CANNON = registerItem("snowball_cannon",
            new SnowballCannonItem(new FabricItemSettings().group(ModItemGroup.TERRARIA).maxCount(1)));

    public static final Item FACE_MONSTER_SPAWN_EGG = registerItem("face_monster_spawn_egg",
            new SpawnEggItem(ModEntityType.FACE_MONSTER, 10706239, 11095882, new FabricItemSettings().group(ModItemGroup.TERRARIA)));
    public static final Item CRIMERA_SPAWN_EGG = registerItem("crimera_spawn_egg",
            new SpawnEggItem(ModEntityType.CRIMERA, 11687245, 7679011, new FabricItemSettings().group(ModItemGroup.TERRARIA)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(TerrariaMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        System.out.println("Registering ModItems for " + TerrariaMod.MOD_ID);
    }
}
