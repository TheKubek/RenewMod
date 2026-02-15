package net.kubek.renew.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kubek.renew.Renew;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

import static net.kubek.renew.item.OrbOfDominanceTools.*;

public class ModItems {

    public static final Item STAFF_OF_DOMINANCE = registerItem("staff_of_dominance",new StaffOfDominanceItem(new Item.Settings().maxCount(1).fireproof().rarity(Rarity.EPIC)));
    public static final Item ORB_OF_DOMINANCE = registerItem("orb_of_dominance",new OrbOfDominanceItem(new Item.Settings().maxCount(1).fireproof().rarity(Rarity.EPIC)));
    public static final Item DOMINANCE_DICE = registerItem("dominance_dice",new DominanceDiceItem(new Item.Settings().maxCount(8).rarity(Rarity.RARE)));

    public static final Item TEDDY_BEAR_PLUSHIE = registerItem("teddy_bear_plushie",new PlushieItem(new Item.Settings().maxCount(1)));
    public static final Item MONKEY_PLUSHIE = registerItem("monkey_plushie",new PlushieItem(new Item.Settings().maxCount(1)));
    public static final Item KOALA_PLUSHIE = registerItem("koala_plushie",new PlushieItem(new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item RED_PANDA_PLUSHIE = registerItem("red_panda_plushie",new PlushieItem(new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.literal(""));
            tooltip.add(Text.literal("§6--unfinished item--"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item SUMMEYY_PLUSHIE = registerItem("summeyy_plushie",new SummeyyPlushieItem(new Item.Settings().maxCount(1).rarity(Rarity.EPIC)));

    public static final Item WOODEN_CUTLASS = registerItem("wooden_cutlass",new SwordItem(ToolMaterials.WOOD,new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD,1,-1.8f))));
    public static final Item STONE_CUTLASS = registerItem("stone_cutlass",new SwordItem(ToolMaterials.STONE,new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE,1,-1.7f))));
    public static final Item IRON_CUTLASS = registerItem("iron_cutlass",new SwordItem(ToolMaterials.IRON,new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON,1,-1.6f))));
    public static final Item GOLDEN_CUTLASS = registerItem("golden_cutlass",new SwordItem(ToolMaterials.GOLD,new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD,1,-1f))));
    public static final Item DIAMOND_CUTLASS = registerItem("diamond_cutlass",new SwordItem(ToolMaterials.DIAMOND,new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND,1,-1.4f))));
    public static final Item NETHERITE_CUTLASS = registerItem("netherite_cutlass",new SwordItem(ToolMaterials.NETHERITE,new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE,1,-1.3f))));
    public static final Item DANCER_SWORD = registerItem("dancer_sword",new DancerSwordItem(ToolMaterials.DIAMOND,new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE,2,-1.4f)).rarity(Rarity.RARE)));

    public static final Item WOODEN_SCYTHE = registerItem("wooden_scythe",new ScytheItem(ToolMaterials.WOOD,new Item.Settings().attributeModifiers(ScytheItem.createAttributeModifiers(ToolMaterials.WOOD,1f,-3f))));
    public static final Item STONE_SCYTHE = registerItem("stone_scythe",new ScytheItem(ToolMaterials.STONE,new Item.Settings().attributeModifiers(ScytheItem.createAttributeModifiers(ToolMaterials.STONE,1f,-3f))));
    public static final Item IRON_SCYTHE = registerItem("iron_scythe",new ScytheItem(ToolMaterials.IRON,new Item.Settings().attributeModifiers(ScytheItem.createAttributeModifiers(ToolMaterials.IRON,1f,-3f))));
    public static final Item GOLDEN_SCYTHE = registerItem("golden_scythe",new ScytheItem(ToolMaterials.GOLD,new Item.Settings().attributeModifiers(ScytheItem.createAttributeModifiers(ToolMaterials.GOLD,1f,-3f))));
    public static final Item DIAMOND_SCYTHE = registerItem("diamond_scythe",new ScytheItem(ToolMaterials.DIAMOND,new Item.Settings().attributeModifiers(ScytheItem.createAttributeModifiers(ToolMaterials.DIAMOND,1f,-3f))));
    public static final Item NETHERITE_SCYTHE = registerItem("netherite_scythe",new ScytheItem(ToolMaterials.NETHERITE,new Item.Settings().attributeModifiers(ScytheItem.createAttributeModifiers(ToolMaterials.NETHERITE,1f,-3f))));
    public static final Item ENCHANTER_SCYTHE = registerItem("enchanter_scythe",new EnchanterScytheItem(ToolMaterials.NETHERITE,new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ToolMaterials.NETHERITE,1f,-3f)).rarity(Rarity.RARE)));
    public static final Item GLACIER_SCYTHE = registerItem("glacier_scythe",new GlacierScytheItem(ToolMaterials.NETHERITE,new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ToolMaterials.NETHERITE,1f,-3f)).rarity(Rarity.EPIC)));

    public static final Item COSMETIC_DICE = registerItem("cosmetic_dice",new CosmeticDice(new Item.Settings().maxCount(8).rarity(Rarity.UNCOMMON)));



    protected static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Renew.MOD_ID,name),item);
    }

    public static void registerModItems(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.addAfter(Items.NETHERITE_SWORD,WOODEN_CUTLASS);
            entries.addAfter(WOODEN_CUTLASS,STONE_CUTLASS);
            entries.addAfter(STONE_CUTLASS,IRON_CUTLASS);
            entries.addAfter(IRON_CUTLASS,GOLDEN_CUTLASS);
            entries.addAfter(GOLDEN_CUTLASS,DIAMOND_CUTLASS);
            entries.addAfter(DIAMOND_CUTLASS,NETHERITE_CUTLASS);
            entries.addAfter(Items.MACE,DANCER_SWORD);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries->{
            entries.addAfter(Items.WOODEN_HOE,WOODEN_SCYTHE);
            entries.addAfter(Items.STONE_HOE,STONE_SCYTHE);
            entries.addAfter(Items.IRON_HOE,IRON_SCYTHE);
            entries.addAfter(Items.GOLDEN_HOE,GOLDEN_SCYTHE);
            entries.addAfter(Items.DIAMOND_HOE,DIAMOND_SCYTHE);
            entries.addAfter(Items.NETHERITE_HOE,NETHERITE_SCYTHE);
            entries.addAfter(OrbOfDominanceTools.ORB_OF_DOMINANCE_SCYTHE,ENCHANTER_SCYTHE);
            entries.addAfter(ENCHANTER_SCYTHE,GLACIER_SCYTHE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addAfter(ModItems.NETHERITE_SCYTHE,ORB_OF_DOMINANCE_AXE);
            entries.addAfter(ORB_OF_DOMINANCE_AXE,ORB_OF_DOMINANCE_PICKAXE);
            entries.addAfter(ORB_OF_DOMINANCE_PICKAXE,ORB_OF_DOMINANCE_SHOVEL);
            entries.addAfter(ORB_OF_DOMINANCE_SHOVEL,ORB_OF_DOMINANCE_HOE);
            entries.addAfter(ORB_OF_DOMINANCE_HOE,ORB_OF_DOMINANCE_SCYTHE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(e ->{
            e.addAfter(Items.NETHERITE_SWORD,ORB_OF_DOMINANCE_SWORD);
            e.addAfter(ModItems.NETHERITE_CUTLASS,ORB_OF_DOMINANCE_CUTLASS);
        });
    }

}
