package net.andychen.terrariamod.world.gen.feature;

import net.andychen.terrariamod.TerrariaMod;
import net.andychen.terrariamod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ModConfiguredFeatures {

    public static final RegistryKey<PlacedFeature> SHADEWOOD_KEY = registerKey("shadewood");

    public static final ConfiguredFeature<TreeFeatureConfig, ?> SHADEWOOD = registerConfiguredFeature("shadewood",
            Feature.TREE.configure((new TreeFeatureConfig.Builder(BlockStateProvider.of(ModBlocks.SHADEWOOD_LOG),
                    new StraightTrunkPlacer(5, 3, 2), BlockStateProvider.of(ModBlocks.SHADEWOOD_LEAVES),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)))
                    .ignoreVines().build()));

    public static final PlacedFeature SHADEWOOD_CHECKED = registerPlacedFeature("shadewood", SHADEWOOD.withWouldSurviveFilter(ModBlocks.SHADEWOOD_SAPLING));

    public static final RegistryKey<PlacedFeature> HELLSTONE_ORE_KEY = registerKey("hellstone_ore");

    public static final ConfiguredFeature<?, ?> HELLSTONE_ORE_CONFIGURED= registerConfiguredFeature("hellstone_ore",
            Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.NETHERRACK, ModBlocks.HELLSTONE_ORE_BLOCK.getDefaultState(), 9)));

    public static final PlacedFeature HELLSTONE_ORE_PLACED_FEATURE = registerPlacedFeature("hellstone_ore",
            HELLSTONE_ORE_CONFIGURED.withPlacement(
                    CountPlacementModifier.of(20),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(128))));

    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(TerrariaMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> registerConfiguredFeature(String name,
                                                                                     ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(TerrariaMod.MOD_ID, name),
                configuredFeature);
    }

    private static PlacedFeature registerPlacedFeature(String name, PlacedFeature placedFeature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(TerrariaMod.MOD_ID, name),
                placedFeature);
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + TerrariaMod.MOD_ID);
    }
}