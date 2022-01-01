package net.andychen.terrariamod;

import net.andychen.terrariamod.entity.ModEntityType;
import net.andychen.terrariamod.entity.model.BombEntityModel;
import net.andychen.terrariamod.entity.model.CrimeraEntityModel;
import net.andychen.terrariamod.entity.model.FaceMonsterEntityModel;
import net.andychen.terrariamod.entity.model.StaffProjectileEntityModel;
import net.andychen.terrariamod.entity.projectile.*;
import net.andychen.terrariamod.entity.renderer.*;
import net.andychen.terrariamod.network.packet.EntitySpawnPacket;
import net.andychen.terrariamod.particle.ModParticleTypes;
import net.andychen.terrariamod.util.ModRenderHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;

import java.util.UUID;

@Environment(EnvType.CLIENT)
public class TerrariaClientMod implements ClientModInitializer {
    public static final EntityModelLayer MODEL_FACE_MONSTER_LAYER = new EntityModelLayer(new Identifier(TerrariaMod.MOD_ID, "face_monster"), "main");
    public static final EntityModelLayer MODEL_CRIMERA_LAYER = new EntityModelLayer(new Identifier(TerrariaMod.MOD_ID, "crimera"), "main");
    public static final EntityModelLayer MODEL_AMETHYST_BOLT_LAYER = new EntityModelLayer(new Identifier(TerrariaMod.MOD_ID, "amethyst_bolt"), "main");
    public static final EntityModelLayer MODEL_TOPAZ_BOLT_LAYER = new EntityModelLayer(new Identifier(TerrariaMod.MOD_ID, "topaz_bolt"), "main");
    public static final EntityModelLayer MODEL_SAPPHIRE_BOLT_LAYER = new EntityModelLayer(new Identifier(TerrariaMod.MOD_ID, "sapphire_bolt"), "main");
    public static final EntityModelLayer MODEL_EMERALD_BOLT_LAYER = new EntityModelLayer(new Identifier(TerrariaMod.MOD_ID, "emerald_bolt"), "main");
    public static final EntityModelLayer MODEL_RUBY_BOLT_LAYER = new EntityModelLayer(new Identifier(TerrariaMod.MOD_ID, "ruby_bolt"), "main");
    public static final EntityModelLayer MODEL_DIAMOND_BOLT_LAYER = new EntityModelLayer(new Identifier(TerrariaMod.MOD_ID, "diamond_bolt"), "main");
    public static final EntityModelLayer MODEL_BOMB_LAYER = new EntityModelLayer(new Identifier(TerrariaMod.MOD_ID, "bomb"), "main");
    public static final Identifier PacketID = new Identifier(TerrariaMod.MOD_ID, "spawn_packet");

    public void receiveEntityPacket() {
        ClientSidePacketRegistry.INSTANCE.register(PacketID, (ctx, byteBuf) -> {
            EntityType<?> et = Registry.ENTITY_TYPE.get(byteBuf.readVarInt());
            UUID uuid = byteBuf.readUuid();
            int entityId = byteBuf.readVarInt();
            Vec3d pos = EntitySpawnPacket.PacketBufUtil.readVec3d(byteBuf);
            float pitch = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
            float yaw = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
            ctx.getTaskQueue().execute(() -> {
                if (MinecraftClient.getInstance().world == null)
                    throw new IllegalStateException("Tried to spawn entity in a null world!");
                Entity e = et.create(MinecraftClient.getInstance().world);
                if (e == null)
                    throw new IllegalStateException("Failed to create instance of entity \"" + Registry.ENTITY_TYPE.getId(et) + "\"!");
                e.updateTrackedPosition(pos);
                e.setPos(pos.x, pos.y, pos.z);
                e.setPitch(pitch);
                e.setYaw(yaw);
                e.setId(entityId);
                e.setUuid(uuid);
                MinecraftClient.getInstance().world.addEntity(entityId, e);
            });
        });
    }

    @Override
    public void onInitializeClient() {
        ModRenderHelper.setRenderLayers();

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier(TerrariaMod.MOD_ID, "particle/amethyst_bolt"));
        }));
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier(TerrariaMod.MOD_ID, "particle/topaz_bolt"));
        }));
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier(TerrariaMod.MOD_ID, "particle/sapphire_bolt"));
        }));
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier(TerrariaMod.MOD_ID, "particle/emerald_bolt"));
        }));
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier(TerrariaMod.MOD_ID, "particle/ruby_bolt"));
        }));
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier(TerrariaMod.MOD_ID, "particle/diamond_bolt"));
        }));
        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.AMETHYST_BOLT, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.TOPAZ_BOLT, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.SAPPHIRE_BOLT, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.EMERALD_BOLT, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.RUBY_BOLT, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.DIAMOND_BOLT, FlameParticle.Factory::new);

        EntityRendererRegistry.register(ModEntityType.FACE_MONSTER, (context) -> {
                return new FaceMonsterEntityRenderer(context);
        });
        EntityRendererRegistry.register(ModEntityType.CRIMERA, (context) -> {
            return new CrimeraEntityRenderer(context);
        });
        EntityRendererRegistry.register(ModEntityType.BOMB, (context) -> {
            return new FlyingItemEntityRenderer(context);
        });
        EntityRendererRegistry.register(ModEntityType.AMETHYST_BOLT, (context) -> {
            return new AmethystBoltEntityRenderer(context);
        });
        EntityRendererRegistry.register(ModEntityType.TOPAZ_BOLT, (context) -> {
            return new TopazBoltEntityRenderer(context);
        });
        EntityRendererRegistry.register(ModEntityType.SAPPHIRE_BOLT, (context) -> {
            return new SapphireBoltEntityRenderer(context);
        });
        EntityRendererRegistry.register(ModEntityType.EMERALD_BOLT, (context) -> {
            return new EmeraldBoltEntityRenderer(context);
        });
        EntityRendererRegistry.register(ModEntityType.RUBY_BOLT, (context) -> {
            return new RubyBoltEntityRenderer(context);
        });
        EntityRendererRegistry.register(ModEntityType.DIAMOND_BOLT, (context) -> {
            return new DiamondBoltEntityRenderer(context);
        });
        EntityRendererRegistry.register(ModEntityType.BOMB, (context) -> {
            return new BombEntityRenderer(context);
        });
        receiveEntityPacket();


        EntityModelLayerRegistry.registerModelLayer(MODEL_FACE_MONSTER_LAYER, FaceMonsterEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_CRIMERA_LAYER, CrimeraEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_AMETHYST_BOLT_LAYER, StaffProjectileEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_TOPAZ_BOLT_LAYER, StaffProjectileEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_SAPPHIRE_BOLT_LAYER, StaffProjectileEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_EMERALD_BOLT_LAYER, StaffProjectileEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_RUBY_BOLT_LAYER, StaffProjectileEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_DIAMOND_BOLT_LAYER, StaffProjectileEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_BOMB_LAYER, BombEntityModel::getTexturedModelData);
    }
}
