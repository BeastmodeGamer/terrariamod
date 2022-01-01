package net.andychen.terrariamod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Optional;

public class ModLivingEntity extends LivingEntity {
    private static final TrackedData<Float> MANA = null;
    public final int defaultMaxMana;

    protected ModLivingEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
        this.defaultMaxMana = 20;
        this.setMana(this.getMaxMana());
    }

    public void initDataTracker() {
        this.dataTracker.startTracking(MANA, 1.0F);
    }

    public float getMaxMana() {
        return (Float)this.dataTracker.get(MANA);
    }

    public void setMana(float mana) {
        this.dataTracker.set(MANA, MathHelper.clamp(mana, 0.0F, this.getMaxMana()));
    }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return null;
    }

    @Override
    public ItemStack getEquippedStack(EquipmentSlot slot) {
        return null;
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {

    }

    @Override
    public Arm getMainArm() {
        return null;
    }
}
