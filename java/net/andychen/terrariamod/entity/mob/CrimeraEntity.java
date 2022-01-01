package net.andychen.terrariamod.entity.mob;

import net.andychen.terrariamod.sounds.ModSounds;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class CrimeraEntity extends FlyingEntity implements Monster {
    private static final TrackedData<Integer> SIZE;
    protected static final TrackedData<Byte> VEX_FLAGS;
    private static final int CHARGING_FLAG = 1;
    @Nullable
    private BlockPos bounds;

    public CrimeraEntity(EntityType<? extends FlyingEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new CrimeraEntity.VexMoveControl(this);
        this.experiencePoints = 3;
    }


    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0D)
                .add(EntityAttributes.GENERIC_ARMOR, 2.0D);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(4, new CrimeraEntity.ChargeTargetGoal());
        this.goalSelector.add(8, new CrimeraEntity.LookAtTargetGoal());
        this.goalSelector.add(9, new LookAtEntityGoal(this, PlayerEntity.class, 3.0F, 1.0F));
        this.goalSelector.add(10, new LookAtEntityGoal(this, MobEntity.class, 8.0F));
        this.targetSelector.add(3, new ActiveTargetGoal(this, PlayerEntity.class, true));
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(SIZE, 0);
        this.dataTracker.startTracking(VEX_FLAGS, (byte)0);
    }

    public void setPhantomSize(int size) {
        this.dataTracker.set(SIZE, MathHelper.clamp(size, 0, 64));
    }

    private void onSizeChanged() {
        this.calculateDimensions();
        this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue((double)(6 + this.getPhantomSize()));
    }

    public int getPhantomSize() {
        return (Integer)this.dataTracker.get(SIZE);
    }

    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return dimensions.height * 0.35F;
    }

    public int method_33588() {
        return this.getId() * 3;
    }

    protected boolean isDisallowedInPeaceful() {
        return true;
    }

    public void onTrackedDataSet(TrackedData<?> data) {
        if (SIZE.equals(data)) {
            this.onSizeChanged();
        }

        super.onTrackedDataSet(data);
    }

    public void move(MovementType movementType, Vec3d movement) {
        super.move(movementType, movement);
        this.checkBlockCollision();
    }

    public void tick() {
        super.tick();
        this.setNoGravity(true);
        if (this.world.isClient) {
            float f = MathHelper.cos((float)(this.method_33588() + this.age) * 7.448451F * 0.017453292F + 3.1415927F);
            float g = MathHelper.cos((float)(this.method_33588() + this.age + 1) * 7.448451F * 0.017453292F + 3.1415927F);

            int i = this.getPhantomSize();
            float h = MathHelper.cos(this.getYaw() * 0.017453292F) * (1.3F + 0.21F * (float)i);
            float j = MathHelper.sin(this.getYaw() * 0.017453292F) * (1.3F + 0.21F * (float)i);
            float k = (0.3F + f * 0.45F) * ((float)i * 0.2F + 1.0F);
            this.world.addParticle(ParticleTypes.CRIMSON_SPORE, this.getX() + (double)h, this.getY() + (double)k, this.getZ() + (double)j, 0.0D, 0.0D, 0.0D);
            this.world.addParticle(ParticleTypes.CRIMSON_SPORE, this.getX() - (double)h, this.getY() + (double)k, this.getZ() - (double)j, 0.0D, 0.0D, 0.0D);
        }

    }

    protected void mobTick() {
        super.mobTick();
    }

    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        this.setPhantomSize(0);
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("BoundX")) {
            this.bounds = new BlockPos(nbt.getInt("BoundX"), nbt.getInt("BoundY"), nbt.getInt("BoundZ"));
        }
        this.setPhantomSize(nbt.getInt("Size"));
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        if (this.bounds != null) {
            nbt.putInt("BoundX", this.bounds.getX());
            nbt.putInt("BoundY", this.bounds.getY());
            nbt.putInt("BoundZ", this.bounds.getZ());
        }
        nbt.putInt("Size", this.getPhantomSize());
    }

    public boolean shouldRender(double distance) {
        return true;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.DEATH_GENERIC;
    }

    public EntityGroup getGroup() {
        return EntityGroup.UNDEAD;
    }

    public boolean canTarget(EntityType<?> type) {
        return true;
    }

    public EntityDimensions getDimensions(EntityPose pose) {
        int i = this.getPhantomSize();
        EntityDimensions entityDimensions = super.getDimensions(pose);
        float f = (entityDimensions.width + 0.2F * (float)i) / entityDimensions.width;
        return entityDimensions.scaled(f);
    }
    static {
        SIZE = DataTracker.registerData(CrimeraEntity.class, TrackedDataHandlerRegistry.INTEGER);
    }

    @Nullable
    public BlockPos getBounds() {
        return this.bounds;
    }

    public void setBounds(@Nullable BlockPos pos) {
        this.bounds = pos;
    }

    private boolean areFlagsSet(int mask) {
        int i = (Byte)this.dataTracker.get(VEX_FLAGS);
        return (i & mask) != 0;
    }

    private void setVexFlag(int mask, boolean value) {
        int i = (Byte)this.dataTracker.get(VEX_FLAGS);
        int j;
        if (value) {
            j = i | mask;
        } else {
            j = i & ~mask;
        }

        this.dataTracker.set(VEX_FLAGS, (byte)(i & 255));
    }

    public boolean isCharging() {
        return this.areFlagsSet(1);
    }

    public void setCharging(boolean charging) {
        this.setVexFlag(1, charging);
    }

    static {
        VEX_FLAGS = DataTracker.registerData(CrimeraEntity.class, TrackedDataHandlerRegistry.BYTE);
    }

    private class VexMoveControl extends MoveControl {
        public VexMoveControl(CrimeraEntity owner) {
            super(owner);
        }

        public void tick() {
            if (this.state == State.MOVE_TO) {
                Vec3d vec3d = new Vec3d(this.targetX - CrimeraEntity.this.getX(), this.targetY - CrimeraEntity.this.getY(), this.targetZ - CrimeraEntity.this.getZ());
                double d = vec3d.length();
                if (d < CrimeraEntity.this.getBoundingBox().getAverageSideLength()) {
                    this.state = State.WAIT;
                    CrimeraEntity.this.setVelocity(CrimeraEntity.this.getVelocity().multiply(0.5D));
                } else {
                    CrimeraEntity.this.setVelocity(CrimeraEntity.this.getVelocity().add(vec3d.multiply(this.speed * 0.05D / d)));
                    if (CrimeraEntity.this.getTarget() == null) {
                        Vec3d vec3d2x = CrimeraEntity.this.getVelocity();
                        CrimeraEntity.this.setYaw(-((float)MathHelper.atan2(vec3d2x.x, vec3d2x.z)) * 57.295776F);
                        CrimeraEntity.this.bodyYaw = CrimeraEntity.this.getYaw();
                    } else {
                        double vec3d2 = CrimeraEntity.this.getTarget().getX() - CrimeraEntity.this.getX();
                        double e = CrimeraEntity.this.getTarget().getZ() - CrimeraEntity.this.getZ();
                        CrimeraEntity.this.setYaw(-((float)MathHelper.atan2(vec3d2, e)) * 57.295776F);
                        CrimeraEntity.this.bodyYaw = CrimeraEntity.this.getYaw();
                    }
                }

            }
        }
    }

    private class ChargeTargetGoal extends Goal {
        public ChargeTargetGoal() {
            this.setControls(EnumSet.of(Control.MOVE));
        }

        public boolean canStart() {
            if (CrimeraEntity.this.getTarget() != null && !CrimeraEntity.this.getMoveControl().isMoving() && CrimeraEntity.this.random.nextInt(toGoalTicks(7)) == 0) {
                return CrimeraEntity.this.squaredDistanceTo(CrimeraEntity.this.getTarget()) > 4.0D;
            } else {
                return false;
            }
        }

        public boolean shouldContinue() {
            return CrimeraEntity.this.getMoveControl().isMoving() && CrimeraEntity.this.isCharging() && CrimeraEntity.this.getTarget() != null && CrimeraEntity.this.getTarget().isAlive();
        }

        public void start() {
            LivingEntity livingEntity = CrimeraEntity.this.getTarget();
            if (livingEntity != null) {
                Vec3d vec3d = livingEntity.getEyePos();
                CrimeraEntity.this.moveControl.moveTo(vec3d.x, vec3d.y, vec3d.z, 1.0D);
            }

            CrimeraEntity.this.setCharging(true);
            CrimeraEntity.this.playSound(SoundEvents.ENTITY_VEX_CHARGE, 1.0F, 1.0F);
        }

        public void stop() {
            CrimeraEntity.this.setCharging(false);
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity livingEntity = CrimeraEntity.this.getTarget();
            if (livingEntity != null) {
                if (CrimeraEntity.this.getBoundingBox().intersects(livingEntity.getBoundingBox())) {
                    CrimeraEntity.this.tryAttack(livingEntity);
                    CrimeraEntity.this.setCharging(false);
                } else {
                    double d = CrimeraEntity.this.squaredDistanceTo(livingEntity);
                    if (d < 9.0D) {
                        Vec3d vec3d = livingEntity.getEyePos();
                        CrimeraEntity.this.moveControl.moveTo(vec3d.x, vec3d.y, vec3d.z, 1.0D);
                    }
                }

            }
        }
    }

    private class LookAtTargetGoal extends Goal {
        public LookAtTargetGoal() {
            this.setControls(EnumSet.of(Control.MOVE));
        }

        public boolean canStart() {
            return !CrimeraEntity.this.getMoveControl().isMoving() && CrimeraEntity.this.random.nextInt(toGoalTicks(7)) == 0;
        }

        public boolean shouldContinue() {
            return false;
        }

        public void tick() {
            BlockPos blockPos = CrimeraEntity.this.getBounds();
            if (blockPos == null) {
                blockPos = CrimeraEntity.this.getBlockPos();
            }

            for(int i = 0; i < 3; ++i) {
                BlockPos blockPos2 = blockPos.add(CrimeraEntity.this.random.nextInt(15) - 7, CrimeraEntity.this.random.nextInt(11) - 5, CrimeraEntity.this.random.nextInt(15) - 7);
                if (CrimeraEntity.this.world.isAir(blockPos2)) {
                    CrimeraEntity.this.moveControl.moveTo((double)blockPos2.getX() + 0.5D, (double)blockPos2.getY() + 0.5D, (double)blockPos2.getZ() + 0.5D, 0.25D);
                    if (CrimeraEntity.this.getTarget() == null) {
                        CrimeraEntity.this.getLookControl().lookAt((double)blockPos2.getX() + 0.5D, (double)blockPos2.getY() + 0.5D, (double)blockPos2.getZ() + 0.5D, 180.0F, 20.0F);
                    }
                    break;
                }
            }

        }
    }
}
