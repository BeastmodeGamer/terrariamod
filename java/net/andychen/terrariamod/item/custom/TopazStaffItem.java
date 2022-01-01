package net.andychen.terrariamod.item.custom;

import net.andychen.terrariamod.entity.projectile.TopazBoltEntity;
import net.andychen.terrariamod.sounds.ModSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TopazStaffItem extends Item {
    public TopazStaffItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand); // creates a new ItemStack instance of the user's itemStack in-hand
        world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.MAGIC_USE, SoundCategory.NEUTRAL, 0.75F, 1F); // plays a globalSoundEvent
        user.getItemCooldownManager().set(this, 19);
        if (!world.isClient) {
            TopazBoltEntity staffProjectileEntity = new TopazBoltEntity(world, user);
            staffProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.1F, 1.0F);
            staffProjectileEntity.setNoGravity(true);
            world.spawnEntity(staffProjectileEntity); // spawns entity
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}