package net.andychen.terrariamod;

import net.andychen.terrariamod.block.ModBlocks;
import net.andychen.terrariamod.entity.ModEntityType;
import net.andychen.terrariamod.entity.mob.CrimeraEntity;
import net.andychen.terrariamod.entity.mob.FaceMonsterEntity;
import net.andychen.terrariamod.item.ModItems;
import net.andychen.terrariamod.sounds.ModSounds;
import net.andychen.terrariamod.util.ModEntityAttributes;
import net.andychen.terrariamod.world.biome.ModBiomes;
import net.andychen.terrariamod.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TerrariaMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("terrariamod");

	public static final String MOD_ID = "terrariamod";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBiomes.registerModBiomes();

		ModWorldGen.generateModWorldGen();

		ModSounds.registerSounds();

		ModEntityType.registerModEntityTypes();
		ModEntityAttributes.registerModEntityAttributes();
		FabricDefaultAttributeRegistry.register(ModEntityType.CRIMERA, CrimeraEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityType.FACE_MONSTER, FaceMonsterEntity.createAttributes());
		LOGGER.info("Hello Fabric world!");
	}
}
