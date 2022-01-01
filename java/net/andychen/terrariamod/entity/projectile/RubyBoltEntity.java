package net.andychen.terrariamod.entity.projectile;

import net.andychen.terrariamod.entity.ModEntityType;
import net.andychen.terrariamod.particle.ModParticleTypes;
import net.andychen.terrariamod.sounds.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.LlamaSpitEntity;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class RubyBoltEntity extends LlamaSpitEntity {
    private int life;

    public RubyBoltEntity(EntityType<? extends RubyBoltEntity> entityType, World world) {
        super(entityType, world);
    }

    public RubyBoltEntity(World world, PlayerEntity owner) {
        this(ModEntityType.RUBY_BOLT, world);
        this.setOwner(owner);
        this.setPosition(owner.getX(), owner.getEyeY() - 0.10000000149011612D, owner.getZ());
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.world.isClient) {
            this.age();
        }
        this.world.addImportantParticle(ModParticleTypes.RUBY_BOLT, true, this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F, 0.0F);
        this.world.addImportantParticle(ModParticleTypes.RUBY_BOLT, true, this.getX(), this.getY() - random.nextFloat(0, 0.1F), this.getZ(), 0.0F, random.nextFloat(0, 0.05F), 0.0F);
        this.world.addImportantParticle(ModParticleTypes.RUBY_BOLT, true, this.getX(), this.getY() + random.nextFloat(0, 0.1F), this.getZ(), 0.0F, -random.nextFloat(0, 0.05F), 0.0F);
        this.world.addImportantParticle(ModParticleTypes.RUBY_BOLT, true, this.getX(), this.getY(), this.getZ() - random.nextFloat(0, 0.1F), 0.0F, 0.0F, random.nextFloat(0, 0.05F));
        this.world.addImportantParticle(ModParticleTypes.RUBY_BOLT, true, this.getX(), this.getY(), this.getZ() + random.nextFloat(0, 0.1F), 0.0F, 0.0F, -random.nextFloat(0, 0.05F));
        this.world.addImportantParticle(ModParticleTypes.RUBY_BOLT, true, this.getX() + random.nextFloat(0, 0.1F), this.getY(), this.getZ(), random.nextFloat(0, 0.05F), 0.0F, 0.0F);
        this.world.addImportantParticle(ModParticleTypes.RUBY_BOLT, true, this.getX() - random.nextFloat(0, 0.1F), this.getY(), this.getZ(), -random.nextFloat(0, 0.05F), 0.0F, 0.0F);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = this.getOwner();
        if (entity instanceof LivingEntity) {
            entityHitResult.getEntity().damage(DamageSource.mobProjectile(this, (LivingEntity)entity).setProjectile(), 4.5F);
        }
        this.discard();
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        if (!this.world.isClient) {
            world.playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.MAGIC_PROJECTILE_DEATH, SoundCategory.NEUTRAL, 1.0F, 1F);
            this.discard();
        }

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
            this.world.addParticle(ModParticleTypes.RUBY_BOLT, this.getX(), this.getY(), this.getZ(), d * g, e, f * g);
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
            this.discard();
        }

    }
}
