package net.andychen.terrariamod.entity;

import net.andychen.terrariamod.TerrariaMod;
import net.andychen.terrariamod.entity.mob.CrimeraEntity;
import net.andychen.terrariamod.entity.mob.FaceMonsterEntity;
import net.andychen.terrariamod.entity.projectile.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntityType {

    public static final EntityType<FaceMonsterEntity> FACE_MONSTER = register("face_monster",
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FaceMonsterEntity::new).dimensions(EntityDimensions.fixed(0.6F, 2.35F)));
    public static final EntityType<CrimeraEntity> CRIMERA = register("crimera",
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CrimeraEntity::new).dimensions(EntityDimensions.fixed(0.8F, 0.4F)));

    public static final EntityType<AmethystBoltEntity> AMETHYST_BOLT = register("amethyst_bolt",
            FabricEntityTypeBuilder.<AmethystBoltEntity>create(SpawnGroup.MISC, AmethystBoltEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10));
    public static final EntityType<TopazBoltEntity> TOPAZ_BOLT = register("topaz_bolt",
            FabricEntityTypeBuilder.<TopazBoltEntity>create(SpawnGroup.MISC, TopazBoltEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10));
    public static final EntityType<SapphireBoltEntity> SAPPHIRE_BOLT = register("sapphire_bolt",
            FabricEntityTypeBuilder.<SapphireBoltEntity>create(SpawnGroup.MISC, SapphireBoltEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10));
    public static final EntityType<EmeraldBoltEntity> EMERALD_BOLT = register("emerald_bolt",
            FabricEntityTypeBuilder.<EmeraldBoltEntity>create(SpawnGroup.MISC, EmeraldBoltEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10));
    public static final EntityType<RubyBoltEntity> RUBY_BOLT = register("ruby_bolt",
            FabricEntityTypeBuilder.<RubyBoltEntity>create(SpawnGroup.MISC, RubyBoltEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10));
    public static final EntityType<DiamondBoltEntity> DIAMOND_BOLT = register("diamond_bolt",
            FabricEntityTypeBuilder.<DiamondBoltEntity>create(SpawnGroup.MISC, DiamondBoltEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10));

    public static final EntityType<BombEntity> BOMB = register("bomb",
            FabricEntityTypeBuilder.<BombEntity>create(SpawnGroup.MISC, BombEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4F, 0.4F)).trackRangeBlocks(4).trackedUpdateRate(10));

    /*public static final EntityType<BombEntity> BOMB = register("bomb",
            FabricEntityTypeBuilder.<BombEntity>create(SpawnGroup.MISC, BombEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10));*/

    private static <T extends Entity> EntityType<T> register(String name, FabricEntityTypeBuilder<T> type) {
        return (EntityType) Registry.register(Registry.ENTITY_TYPE, new Identifier(TerrariaMod.MOD_ID, name), type.build());
    }

    public static void registerModEntityTypes(){
        System.out.println("Registering ModEntityTypes for " + TerrariaMod.MOD_ID);
    }
}