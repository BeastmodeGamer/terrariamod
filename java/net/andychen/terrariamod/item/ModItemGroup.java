package net.andychen.terrariamod.item;

import net.andychen.terrariamod.TerrariaMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup TERRARIA = FabricItemGroupBuilder.build(new Identifier(TerrariaMod.MOD_ID, "terraria"),
            () -> new ItemStack(ModItems.HELLSTONE_ORE));
}
