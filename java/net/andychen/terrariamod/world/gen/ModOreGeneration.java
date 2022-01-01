package net.andychen.terrariamod.world.gen;

import net.andychen.terrariamod.world.gen.feature.ModConfiguredFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {

    public static void generateOres() {
        //Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                //new Identifier(TerrariaMod.MOD_ID, "hellstone_ore"), ModConfiguredFeatures.HELLSTONE_ORE_CONFIGURED_FEATURE);
        //Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(TerrariaMod.MOD_ID, "hellstone_ore"),
                //ModConfiguredFeatures.HELLSTONE_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, ModConfiguredFeatures.HELLSTONE_ORE_KEY);
    }
}