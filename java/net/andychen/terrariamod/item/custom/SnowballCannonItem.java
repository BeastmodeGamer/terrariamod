package net.andychen.terrariamod.item.custom;

import net.andychen.terrariamod.sounds.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class SnowballCannonItem extends Item {
    private static final String USING_KEY = "Using";

    public SnowballCannonItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
       return 72000;
    }

    /*@Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        user.getItemCooldownManager().set(this, 3);
        if (!world.isClient) {
            //ArrowEntity arrowEntity = new ArrowEntity(world, user);
            //arrowEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 2.5F, 1.0F);
            SnowballEntity snowballEntity = new SnowballEntity(world, user);
            snowballEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 3.0F, 1.0F);
            world.playSound(null, user.getX(), user.getY(), user.getZ(),
                    ModSounds.SNOWBALL_CANNON_SHOOT, SoundCategory.NEUTRAL, 1F, 1F);
            //arrowEntity.setNoGravity(true);
            world.spawnEntity(snowballEntity);
            user.setCurrentHand(hand);
        }
       return TypedActionResult.success(itemStack);
    }*/

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                ModSounds.SNOWBALL_CANNON_SHOOT, SoundCategory.NEUTRAL, 1F, 1F);
        user.getItemCooldownManager().set(this, 3);
        if (!world.isClient) {
            SnowballEntity snowballEntity = new SnowballEntity(world, user);
            snowballEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 3.0F, 1.0F);
            world.spawnEntity(snowballEntity);
        }
        if (!user.getAbilities().creativeMode) {
            ItemStack ammo = new ItemStack(Items.SNOWBALL);
            user.getInventory().removeOne(ammo);
        }
        user.setCurrentHand(hand);
        return TypedActionResult.fail(itemStack);
    }

   /*@Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        setInUse(itemStack, true);
        if (isInUse(itemStack)){
            user.setCurrentHand(hand);
            return TypedActionResult.consume(itemStack);
        }
        return TypedActionResult.fail(itemStack);
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack itemStack, int remainingUseTicks) {
        if (!world.isClient) {
            float f = (float)((itemStack.getMaxUseTime() - remainingUseTicks) % 10);
            if(isInUse(itemStack) && f == 5) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 60, 0, false, false));
                SnowballEntity snowballEntity = new SnowballEntity(world, user);
                snowballEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 3.0F, 1.0F);
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        ModSounds.SNOWBALL_CANNON_SHOOT, SoundCategory.NEUTRAL, 1F, 1F);
                world.spawnEntity(snowballEntity);

            }
        }
    }*/

    public static boolean isInUse(ItemStack stack) {
        NbtCompound nbtCompound = stack.getNbt();
        return nbtCompound != null && nbtCompound.getBoolean("Using");
    }

    public static void setInUse(ItemStack stack, boolean using) {
        NbtCompound nbtCompound = stack.getOrCreateNbt();
        nbtCompound.putBoolean("Using", using);
    }

    @Override
    public ItemStack finishUsing(ItemStack itemStack, World world, LivingEntity player) {
        setInUse(itemStack, false);
        return itemStack;
    }
}
