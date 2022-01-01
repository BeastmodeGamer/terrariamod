package net.andychen.terrariamod.item.custom;

import net.andychen.terrariamod.sounds.ModSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;

public class MagicMirrorItem extends Item {

    public MagicMirrorItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 30;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        world.playSound(null, player.getX(), player.getY(), player.getZ(),
                ModSounds.MAGIC_MIRROR, SoundCategory.NEUTRAL, 1F, 1F);
        player.setCurrentHand(hand);
        return TypedActionResult.consume(itemStack);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity player) {
        PlayerEntity user = (PlayerEntity) player;
        if (!world.isClient) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) player;
            BlockPos spawnPoint = serverPlayerEntity.getSpawnPointPosition();
            float f = serverPlayerEntity.getSpawnAngle();
            boolean bl = serverPlayerEntity.isSpawnForced();
            boolean alive = true;
            ServerWorld serverWorld = world.getServer().getWorld(serverPlayerEntity.getSpawnPointDimension());
            Optional optional;
            if (spawnPoint != null) {
                optional = PlayerEntity.findRespawnPosition(serverWorld, spawnPoint, f, bl, alive);
                serverPlayerEntity.networkHandler.requestTeleport(spawnPoint.getX(), spawnPoint.getY(), spawnPoint.getZ(), serverPlayerEntity.getYaw(), serverPlayerEntity.getPitch());
                user.getItemCooldownManager().set(this, 30);
            } else {
                serverPlayerEntity.networkHandler.requestTeleport(spawnPoint.getX(), spawnPoint.getY(), spawnPoint.getZ(), serverPlayerEntity.getYaw(), serverPlayerEntity.getPitch());
                user.getItemCooldownManager().set(this, 30);
            }
        }
        return stack;
    }
}
