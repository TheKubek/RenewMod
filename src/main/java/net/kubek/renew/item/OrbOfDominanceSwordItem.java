package net.kubek.renew.item;

import net.kubek.renew.components.ModDataComponentTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class OrbOfDominanceSwordItem extends SwordItem {
    public OrbOfDominanceSwordItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }
    @Override
    public float getBonusAttackDamage(Entity target, float baseAttackDamage, DamageSource damageSource) {
        assert damageSource.getAttacker() != null;
        ItemStack s = null;
        if(damageSource.getAttacker() instanceof PlayerEntity entity) {
            s = entity.getStackInHand(entity.getActiveHand());

        }
        assert s != null;
        if(s.get(ModDataComponentTypes.AdditionalDamage)==null) {
            return 0 ;
        }
        else return s.get(ModDataComponentTypes.AdditionalDamage);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(target.isBaby()){
            if(stack.get(ModDataComponentTypes.AdditionalDamage)==null) {
                stack.set(ModDataComponentTypes.AdditionalDamage,0.2f);
            }
            else if(stack.get(ModDataComponentTypes.AdditionalDamage)>=40f){
                stack.set(ModDataComponentTypes.AdditionalDamage, 40f);
            }
            else {
                    stack.set(ModDataComponentTypes.AdditionalDamage, (stack.get(ModDataComponentTypes.AdditionalDamage) + 0.2f));
            }
        }

        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.renew.orb_of_dominance_sword_line_one"));
        if(stack.get(ModDataComponentTypes.AdditionalDamage)!=null) {
            tooltip.add(Text.literal("Damage: " + (stack.get(ModDataComponentTypes.AdditionalDamage).floatValue()-(stack.get(ModDataComponentTypes.AdditionalDamage).floatValue()%0.2f))));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}

