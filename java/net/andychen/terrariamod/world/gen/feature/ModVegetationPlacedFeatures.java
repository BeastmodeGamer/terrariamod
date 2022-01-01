package net.andychen.terrariamod.world.gen.feature;

import com.google.common.collect.ImmutableList;
import net.andychen.terrariamod.TerrariaMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.BiomePlacementModifier;
import net.minecraft.world.gen.decorator.PlacementModifier;
import net.minecraft.world.gen.decorator.RarityFilterPlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModVegetationPlacedFeatures extends VegetationPlacedFeatures{

    public static List<PlacementModifier> modifiersWithChance(int chance, @Nullable PlacementModifier modifier) {
        ImmutableList.Builder<PlacementModifier> builder = ImmutableList.builder();
        if (modifier != null) {
            builder.add(modifier);
        }

        if (chance != 0) {
            builder.add(RarityFilterPlacementModifier.of(chance));
        }

        builder.add(SquarePlacementModifier.of());
        builder.add(PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP);
        builder.add(BiomePlacementModifier.of());
        return builder.build();
    }

    public static final PlacedFeature TREES_CRIMSON = registerPlacedFeature("trees_crimson", ModVegetationConfiguredFeatures.TREES_CRIMSON_CONFIGURE
            .withPlacement(modifiers(PlacedFeatures.createCountExtraModifier(10, 0.1F, 1))));

    public static final PlacedFeature VICIOUS_MUSHROOM = registerPlacedFeature("vicious_mushroom", ModVegetationConfiguredFeatures.VICIOUS_MUSHROOM_CONFIGURE
            .withPlacement(new PlacementModifier[]{RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of()}));

    public static final PlacedFeature CRIMSON_FOLIAGE = registerPlacedFeature("crimson_foliage", ModVegetationConfiguredFeatures.CRIMSON_FOLIAGE_CONFIGURE
            .withPlacement(new PlacementModifier[]{RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of()}));

    private static PlacedFeature registerPlacedFeature(String name, PlacedFeature placedFeature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(TerrariaMod.MOD_ID, name),
                placedFeature);
    }
}
