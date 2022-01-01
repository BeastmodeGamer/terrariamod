package net.andychen.terrariamod.world.biome;

import net.andychen.terrariamod.sounds.ModSounds;
import net.andychen.terrariamod.world.gen.feature.ModBiomeFeatures;
import net.minecraft.client.sound.MusicType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import org.jetbrains.annotations.Nullable;

public class ModOverworldBiomeCreator extends OverworldBiomeCreator {
    protected static final int DEFAULT_WATER_COLOR = 4159204;
    protected static final int DEFAULT_WATER_FOG_COLOR = 329011;
    private static final int DEFAULT_FOG_COLOR = 12638463;
    @Nullable
    private static final MusicSound DEFAULT_MUSIC = null;

    private static Biome createBiome(Biome.Precipitation precipitation, Biome.Category category, float temperature, float downfall, SpawnSettings.Builder spawnSettings, net.minecraft.world.biome.GenerationSettings.Builder generationSettings, @Nullable MusicSound music) {
        return createBiomeTemplate(precipitation, category, temperature, downfall, 4159204, 329011, spawnSettings, generationSettings, music);
    }

    private static Biome createBiomeTemplate(Biome.Precipitation precipitation, Biome.Category category, float temperature, float downfall, int waterColor, int waterFogColor, SpawnSettings.Builder spawnSettings, net.minecraft.world.biome.GenerationSettings.Builder generationSettings, @Nullable MusicSound music) {
        return (new Biome.Builder()).precipitation(precipitation).category(category).temperature(temperature).downfall(downfall).effects((new net.minecraft.world.biome.BiomeEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(12638463).skyColor(getSkyColor(temperature)).moodSound(BiomeMoodSound.CAVE).music(music).build()).spawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    private static void addBasicFeatures(net.minecraft.world.biome.GenerationSettings.Builder generationSettings) {
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);
    }

    public static Biome createCrimson() {
        SpawnSettings.Builder builder = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addBatsAndMonsters(builder);
        ModBiomeFeatures.addCrimsonMonsters(builder);
        net.minecraft.world.biome.GenerationSettings.Builder builder2 = new net.minecraft.world.biome.GenerationSettings.Builder();
        DefaultBiomeFeatures.addLandCarvers(builder2);
        DefaultBiomeFeatures.addAmethystGeodes(builder2);
        DefaultBiomeFeatures.addDungeons(builder2);
        DefaultBiomeFeatures.addSprings(builder2);
        DefaultBiomeFeatures.addFrozenTopLayer(builder2);
        DefaultBiomeFeatures.addFossils(builder2);
        ModBiomeFeatures.addViciousMushrooms(builder2);
        ModBiomeFeatures.addCrimsonFoliage(builder2);
        ModBiomeFeatures.addShadewoodTrees(builder2);
        ModBiomeFeatures.addCrimsonDisks(builder2);
        ModBiomeFeatures.addCrimstone(builder2);
        DefaultBiomeFeatures.addForestGrass(builder2);
        DefaultBiomeFeatures.addDefaultMushrooms(builder2);

        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.RAIN)
                .category(Biome.Category.FOREST)
                .temperature(0.6F)
                .downfall(0.8F)
                .effects((new net.minecraft.world.biome.BiomeEffects.Builder())
                        .waterColor(7872036)
                        .waterFogColor(5051668)
                        .fogColor(7872036)
                        .skyColor(6310206)
                        .grassColor(12865860)
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.CRIMSON_SPORE, 0.00625F))
                        .loopSound(ModSounds.CRIMSON_MUSIC)
                        .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D)).build())
                .spawnSettings(builder.build())
                .generationSettings(builder2.build())
                .build();
    }
}
