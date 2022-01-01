package net.andychen.terrariamod.world.gen.feature;

import net.andychen.terrariamod.TerrariaMod;
import net.andychen.terrariamod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.BiomePlacementModifier;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.PlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModMiscFeatures {

    public static final ConfiguredFeature<DiskFeatureConfig, ?> DISK_CRIMSAND_CONFIGURE = registerConfiguredFeature("disk_crimsand",
            Feature.DISK.configure(new DiskFeatureConfig(ModBlocks.CRIMSAND.getDefaultState(),
                    UniformIntProvider.create(2, 6), 2, List.of(Blocks.DIRT.getDefaultState(), Blocks.GRASS_BLOCK.getDefaultState()))));

    public static final PlacedFeature DISK_CRIMSAND = registerPlacedFeature("disk_crimsand", DISK_CRIMSAND_CONFIGURE.withPlacement(new PlacementModifier[]{
            CountPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP, BiomePlacementModifier.of()}));;


    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> registerConfiguredFeature(String name,
                                                                                                 ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(TerrariaMod.MOD_ID, name),
                configuredFeature);
    }

    private static PlacedFeature registerPlacedFeature(String name, PlacedFeature placedFeature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(TerrariaMod.MOD_ID, name),
                placedFeature);
    }
}
