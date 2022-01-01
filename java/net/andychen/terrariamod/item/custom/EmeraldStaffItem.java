package net.andychen.terrariamod.item.custom;

import net.andychen.terrariamod.entity.projectile.EmeraldBoltEntity;
import net.andychen.terrariamod.sounds.ModSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class EmeraldStaffItem extends Item {
    public EmeraldStaffItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand); // creates a new ItemStack instance of the user's itemStack in-hand
        world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.MAGIC_USE, SoundCategory.NEUTRAL, 0.75F, 1F); // plays a globalSoundEvent
        user.getItemCooldownManager().set(this, 16);
        if (!world.isClient) {
            EmeraldBoltEntity staffProjectileEntity = new EmeraldBoltEntity(world, user);
            staffProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.4F, 1.0F);
            staffProjectileEntity.setNoGravity(true);
            world.spawnEntity(staffProjectileEntity); // spawns entity
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}