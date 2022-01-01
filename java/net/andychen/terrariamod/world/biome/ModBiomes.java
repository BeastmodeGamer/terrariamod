package net.andychen.terrariamod.world.biome;

import net.andychen.terrariamod.TerrariaMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class ModBiomes {

    public static final RegistryKey<Biome> CRIMSON_KEY = registerBiomeKey("crimson");

    static {
        registerBiome(CRIMSON_KEY, ModOverworldBiomeCreator.createCrimson());
    }

    private static RegistryKey<Biome> registerBiomeKey(String name) {
        return RegistryKey.of(Registry.BIOME_KEY, new Identifier(TerrariaMod.MOD_ID, name));
    }

    private static Biome registerBiome(RegistryKey<Biome> key, Biome biome) {
        return (Biome) BuiltinRegistries.set(BuiltinRegistries.BIOME, key, biome);
    }

    public static void registerModBiomes(){
        System.out.println("Registering ModBiomes for " + TerrariaMod.MOD_ID);
    }
}
