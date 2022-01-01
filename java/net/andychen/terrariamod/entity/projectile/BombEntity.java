package net.andychen.terrariamod.entity.projectile;

import net.andychen.terrariamod.entity.ModEntityType;
import net.andychen.terrariamod.sounds.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.LlamaSpitEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class BombEntity extends ProjectileEntity {
    private int life;

    public BombEntity(EntityType<? extends BombEntity> entityType, World world) {
        super(entityType, world);
    }

    public BombEntity(World world, PlayerEntity owner) {
        this(ModEntityType.BOMB, world);
        this.setOwner(owner);
        this.setPosition(owner.getX(), owner.getEyeY() - 0.10000000149011612D, owner.getZ());
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.world.isClient) {
            this.age();
        }
        this.world.addImportantParticle(ParticleTypes.SMOKE, true, this.getX(), this.getY() + 0.5, this.getZ(), 0.0F, 0.0F, 0.0F);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = this.getOwner();
        if (entity instanceof LivingEntity) {
            entityHitResult.getEntity().damage(DamageSource.mobProjectile(this, (LivingEntity)entity).setProjectile(), 2.0F);
        }
        this.discard();
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        this.world.playSound(null, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), ModSounds.EXPLOSION, SoundCategory.NEUTRAL, 2.0F, 1F);
        this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 4.0F, Explosion.DestructionType.BREAK);
    }

    @Override
    protected void initDataTracker() {
    }

    @Override
    public void onSpawnPacket(EntitySpawnS2CPacket packet) {
        super.onSpawnPacket(packet);
        double d = packet.getVelocityX();
        double e = packet.getVelocityY();
        double f = packet.getVelocityZ();

        for(int i = 0; i < 7; ++i) {
            double g = 0.4D + 0.1D * (double)i;
        }
        this.setVelocity(d, e, f);
    }

    @Override
    public boolean shouldRender(double distance) {
        double d = this.getBoundingBox().getAverageSideLength() * 10.0D;
        if (Double.isNaN(d)) {
            d = 1.0D;
        }

        d *= 64.0D * getRenderDistanceMultiplier();
        return distance < d * d;
    }

    public void age() {
        ++this.life;
        if (this.life >= 200) {
            this.world.playSound(null, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), ModSounds.EXPLOSION, SoundCategory.NEUTRAL, 2.0F, 1F);
            this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 4.0F, Explosion.DestructionType.BREAK);
            this.discard();
        }

    }
}