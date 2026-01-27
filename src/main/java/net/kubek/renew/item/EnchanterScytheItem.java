package net.kubek.renew.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.World;

public class EnchanterScytheItem extends ScytheItem {
    public EnchanterScytheItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getWorld();
        if(attacker instanceof PlayerEntity entity) {
            if (!world.isClient && entity.getItemCooldownManager().getCooldownProgress(this, 0) == 0) {
                DamageSource damageSource = new DamageSource(
                        world.getRegistryManager()
                                .get(RegistryKeys.DAMAGE_TYPE)
                                .entryOf(DamageTypes.INDIRECT_MAGIC));
                target.damage(damageSource, 6f);
                entity.getItemCooldownManager().set(this, 900);
                attacker.heal(6f);

            }
        }
        return super.postHit(stack, target, attacker);

    }


}
