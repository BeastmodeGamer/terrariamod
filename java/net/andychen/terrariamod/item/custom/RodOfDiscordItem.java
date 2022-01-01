package net.andychen.terrariamod.item.custom;

import net.andychen.terrariamod.sounds.ModSounds;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.World;

public class RodOfDiscordItem extends Item {
    public RodOfDiscordItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {
            Vec3d vec3d = user.getRotationVec(1.0F);
            double x = user.getX();
            double y = user.getY();
            double z = user.getZ();
            double y2 = MathHelper.clamp(y + vec3d.getY() * 10,
                    (double) world.getBottomY(), (double) (world.getBottomY() + ((ServerWorld) world).getLogicalHeight() - 1));
            if (user.hasVehicle()) {
                user.requestTeleportAndDismount(user.getRoll(), user.getPitch(), user.getYaw());
            } else {
                user.requestTeleport(x + vec3d.getX() * 10, y2, z + vec3d.getZ() * 10);
            }
            world.playSound(null, user.getX(), user.getY(), user.getZ(),
                    ModSounds.TELEPORT, SoundCategory.NEUTRAL, 1F, 1F);
            user.damage(DamageSource.FALL, user.getMaxHealth() / 6);
            user.getItemCooldownManager().set(this, 20);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
