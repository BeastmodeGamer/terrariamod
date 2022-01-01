package net.andychen.terrariamod.world.gen.feature;

import net.andychen.terrariamod.TerrariaMod;
import net.andychen.terrariamod.block.ModBlocks;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModOreFeatures {

    public static final RuleTest BASE_STONE_OVERWORLD;

    static {
        BASE_STONE_OVERWORLD = new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD);
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModfier) {
        return modifiers(CountPlacementModifier.of(count), heightModfier);
    }

    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }

    public static final ConfiguredFeature<?, ?> CRIMSTONE_CONFIGURE = registerConfiguredFeature("crimstone",
            Feature.ORE.configure(new OreFeatureConfig(BASE_STONE_OVERWORLD, ModBlocks.CRIMSTONE.getDefaultState(), 64)));

    public static final PlacedFeature CRIMSTONE = registerPlacedFeature("crimstone", CRIMSTONE_CONFIGURE.withPlacement(
            modifiersWithCount(255, HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(320)))));

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> registerConfiguredFeature(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(TerrariaMod.MOD_ID, name),
                configuredFeature);
    }

    private static PlacedFeature registerPlacedFeature(String name, PlacedFeature placedFeature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(TerrariaMod.MOD_ID, name),
                placedFeature);
    }
}
