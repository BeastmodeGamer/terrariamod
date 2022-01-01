package net.andychen.terrariamod.sounds;

import net.andychen.terrariamod.TerrariaMod;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    public static SoundEvent CRIMSON_MUSIC = registerSoundEvent("crimson_music");
    public static SoundEvent SNOWBALL_CANNON_SHOOT = registerSoundEvent("snowball_cannon_shoot");
    public static SoundEvent MAGIC_MIRROR = registerSoundEvent("magic_mirror");
    public static SoundEvent BASIC = registerSoundEvent("basic");
    public static SoundEvent TELEPORT = registerSoundEvent("teleport");
    public static SoundEvent FACE_MONSTER = registerSoundEvent("face_monster");
    public static SoundEvent HURT = registerSoundEvent("hurt");
    public static SoundEvent DEATH_ZOMBIE = registerSoundEvent("death_zombie");
    public static SoundEvent DEATH_GENERIC = registerSoundEvent("death_generic");
    public static SoundEvent EXPLOSION = registerSoundEvent("explosion");
    public static SoundEvent MAGIC_USE = registerSoundEvent("magic_use");
    public static SoundEvent MAGIC_PROJECTILE_DEATH = registerSoundEvent("magic_projectile_death");

    public static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(TerrariaMod.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void registerSounds() {
        System.out.println("Registering ModSounds for " + TerrariaMod.MOD_ID);
    }
}
