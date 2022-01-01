package net.andychen.terrariamod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

import java.util.concurrent.ThreadLocalRandom;

public class HellstonePickaxeItem extends PickaxeItem {
    public HellstonePickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 4+1);
        if (randomNum == 1) {
            target.setOnFireFor(3);
        }
        return true;
    }
}
