package net.andychen.terrariamod.world.gen.feature;

import net.andychen.terrariamod.entity.ModEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.GenerationSettings.Builder;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.MiscPlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class ModBiomeFeatures {

    public static void addCrimsonMonsters(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ModEntityType.FACE_MONSTER, 100, 3, 4));
    }

    public static void addShadewoodTrees(Builder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModVegetationPlacedFeatures.TREES_CRIMSON);
    }

    public static void addCrimsonDisks(Builder builder) {
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, ModMiscFeatures.DISK_CRIMSAND);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, MiscPlacedFeatures.DISK_CLAY);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, MiscPlacedFeatures.DISK_GRAVEL);
    }

    public static void addCrimstone(Builder builder) {
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, ModOreFeatures.CRIMSTONE);
    }

    public static void addViciousMushrooms(Builder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModVegetationPlacedFeatures.VICIOUS_MUSHROOM);
    }

    public static void addCrimsonFoliage(Builder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModVegetationPlacedFeatures.CRIMSON_FOLIAGE);
    }
}
