package net.andychen.terrariamod.world.gen.feature;

import net.andychen.terrariamod.TerrariaMod;
import net.andychen.terrariamod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModVegetationConfiguredFeatures {

    public static final ConfiguredFeature<RandomFeatureConfig, ?> TREES_CRIMSON_CONFIGURE = registerConfiguredFeature("trees_crimson",
            Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(List.of(new RandomFeatureEntry(ModConfiguredFeatures.SHADEWOOD_CHECKED, 0.5F)),
                    ModConfiguredFeatures.SHADEWOOD_CHECKED)));

    public static final ConfiguredFeature<SimpleBlockFeatureConfig, ?> VICIOUS_MUSHROOM_CONFIGURE = registerConfiguredFeature("vicious_mushroom",
            Feature.SIMPLE_BLOCK.configure(new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.VICIOUS_MUSHROOM.getDefaultState()))));

    public static final ConfiguredFeature<RandomPatchFeatureConfig, ?> CRIMSON_FOLIAGE_CONFIGURE = registerConfiguredFeature("crimson_foliage",
            Feature.RANDOM_PATCH.configure(ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK.configure(
                    new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CRIMSON_FOLIAGE))))));

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> registerConfiguredFeature(String name,
                                                                                                 ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(TerrariaMod.MOD_ID, name),
                configuredFeature);
    }
}
