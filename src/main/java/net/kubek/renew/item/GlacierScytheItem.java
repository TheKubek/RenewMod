package net.kubek.renew.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

import java.util.Objects;

public class GlacierScytheItem extends EnchanterScytheItem{

    public GlacierScytheItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getWorld();
        ServerWorld serverWorld = Objects.requireNonNull(world.getServer()).getWorld(world.getRegistryKey());
        if(attacker instanceof PlayerEntity entity) {
            if (!world.isClient && entity.getItemCooldownManager().getCooldownProgress(this.getDefaultStack(), 0) == 0) {
                DamageSource damageSource = new DamageSource(
                        world.getRegistryManager()
                                .getOrThrow(RegistryKeys.DAMAGE_TYPE)
                                .getOrThrow(DamageTypes.INDIRECT_MAGIC));

                target.damage(serverWorld,damageSource, 6f);
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,200,1));
                entity.getItemCooldownManager().set(this.getDefaultStack(), 900);
                attacker.heal(6f);

            }
        }
        super.postHit(stack, target, attacker);

    }
}
