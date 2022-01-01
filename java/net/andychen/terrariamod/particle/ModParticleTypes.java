package net.andychen.terrariamod.particle;

import net.andychen.terrariamod.TerrariaMod;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModParticleTypes {
    public static final DefaultParticleType AMETHYST_BOLT = registerParticle("amethyst_bolt", FabricParticleTypes.simple());
    public static final DefaultParticleType TOPAZ_BOLT = registerParticle("topaz_bolt", FabricParticleTypes.simple());
    public static final DefaultParticleType SAPPHIRE_BOLT = registerParticle("sapphire_bolt", FabricParticleTypes.simple());
    public static final DefaultParticleType EMERALD_BOLT = registerParticle("emerald_bolt", FabricParticleTypes.simple());
    public static final DefaultParticleType RUBY_BOLT = registerParticle("ruby_bolt", FabricParticleTypes.simple());
    public static final DefaultParticleType DIAMOND_BOLT = registerParticle("diamond_bolt", FabricParticleTypes.simple());

    private static DefaultParticleType registerParticle(String name, DefaultParticleType particle) {
        return Registry.register(Registry.PARTICLE_TYPE, new Identifier(TerrariaMod.MOD_ID, name), particle);
    }

}
