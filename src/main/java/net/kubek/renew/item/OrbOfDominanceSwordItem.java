package net.kubek.renew.item;

import net.kubek.renew.components.ModDataComponentTypes;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;

import java.util.List;
import java.util.function.Consumer;

public class OrbOfDominanceSwordItem extends Item {

    public OrbOfDominanceSwordItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(settings.tool(material, BlockTags.SWORD_EFFICIENT,attackDamage,attackSpeed,1f));
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
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
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

       super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.translatable("tooltip.renew.orb_of_dominance_sword_line_one"));
        if(stack.get(ModDataComponentTypes.AdditionalDamage)!=null) {
            textConsumer.accept(Text.literal("Damage: " + (stack.get(ModDataComponentTypes.AdditionalDamage).floatValue()-(stack.get(ModDataComponentTypes.AdditionalDamage).floatValue()%0.2f))));
        }
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }
}

