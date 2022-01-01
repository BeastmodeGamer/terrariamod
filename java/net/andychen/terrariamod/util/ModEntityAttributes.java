package net.andychen.terrariamod.util;

import net.andychen.terrariamod.TerrariaMod;
import net.andychen.terrariamod.entity.ModEntityType;
import net.andychen.terrariamod.entity.mob.CrimeraEntity;
import net.andychen.terrariamod.entity.mob.FaceMonsterEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class ModEntityAttributes {

    public void registerEntityAtrributes() {
        FabricDefaultAttributeRegistry.register(ModEntityType.FACE_MONSTER, FaceMonsterEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntityType.CRIMERA, CrimeraEntity.createAttributes());
    }

    public static void registerModEntityAttributes(){
        System.out.println("Registering ModEntityAttributes for " + TerrariaMod.MOD_ID);
    }
}
