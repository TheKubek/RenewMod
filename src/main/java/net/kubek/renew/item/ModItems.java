package net.kubek.renew.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kubek.renew.Renew;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

import static net.kubek.renew.item.OrbOfDominanceTools.*;

public class ModItems {

    public static final Item STAFF_OF_DOMINANCE = registerItem("staff_of_dominance",settings ->  new StaffOfDominanceItem(settings.maxCount(1).fireproof().rarity(Rarity.EPIC)));
    public static final Item ORB_OF_DOMINANCE = registerItem("orb_of_dominance",settings ->  new OrbOfDominanceItem(settings.maxCount(1).fireproof().rarity(Rarity.EPIC)));
    public static final Item DOMINANCE_DICE = registerItem("dominance_dice",settings ->  new DominanceDiceItem(settings.maxCount(8).rarity(Rarity.RARE)));

    public static final Item TEDDY_BEAR_PLUSHIE = registerItem("teddy_bear_plushie",settings -> new PlushieItem(settings.maxCount(1)));
    public static final Item MONKEY_PLUSHIE = registerItem("monkey_plushie",settings -> new PlushieItem(settings.maxCount(1)));
    public static final Item KOALA_PLUSHIE = registerItem("koala_plushie",settings -> new PlushieItem(settings.maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item RED_PANDA_PLUSHIE = registerItem("red_panda_plushie",settings -> new PlushieItem(settings.maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item SUMMEYY_PLUSHIE = registerItem("summeyy_plushie",settings -> new SummeyyPlushieItem(settings.maxCount(1).rarity(Rarity.EPIC)));

    public static final Item WOODEN_CUTLASS = registerItem("wooden_cutlass",settings -> new Item(settings.sword(ToolMaterial.WOOD,1,-1.8f)));
    public static final Item STONE_CUTLASS = registerItem("stone_cutlass",settings -> new Item(settings.sword(ToolMaterial.STONE,1,-1.7f)));
    public static final Item IRON_CUTLASS = registerItem("iron_cutlass",settings -> new Item(settings.sword(ToolMaterial.IRON,1,-1.6f)));
    public static final Item GOLDEN_CUTLASS = registerItem("golden_cutlass",settings -> new  Item(settings.sword(ToolMaterial.GOLD,1,-1f)));
    public static final Item DIAMOND_CUTLASS = registerItem("diamond_cutlass",settings -> new Item(settings.sword(ToolMaterial.DIAMOND,1,-1.4f)));
    public static final Item NETHERITE_CUTLASS = registerItem("netherite_cutlass",settings -> new Item(settings.sword(ToolMaterial.NETHERITE,1,-1.3f).fireproof()));
    public static final Item DANCER_SWORD = registerItem("dancer_sword",settings -> new DancerSwordItem(ToolMaterial.DIAMOND,2,-1.4f,settings.rarity(Rarity.RARE)));

    public static final Item WOODEN_SCYTHE = registerItem("wooden_scythe",settings ->new ScytheItem(ToolMaterial.WOOD,1f,-3f,settings));
    public static final Item STONE_SCYTHE = registerItem("stone_scythe", settings -> new ScytheItem(ToolMaterial.STONE,1f,-3f,settings));
    public static final Item IRON_SCYTHE = registerItem("iron_scythe",settings -> new ScytheItem(ToolMaterial.IRON,1f,-3f,settings));
    public static final Item GOLDEN_SCYTHE = registerItem("golden_scythe",settings -> new ScytheItem(ToolMaterial.GOLD,1f,-3f,settings));
    public static final Item DIAMOND_SCYTHE = registerItem("diamond_scythe",settings -> new ScytheItem(ToolMaterial.DIAMOND,1f,-3f,settings));
    public static final Item NETHERITE_SCYTHE = registerItem("netherite_scythe",settings -> new ScytheItem(ToolMaterial.NETHERITE,1f,-3f,settings.fireproof()));
    public static final Item ENCHANTER_SCYTHE = registerItem("enchanter_scythe",settings -> new EnchanterScytheItem(ToolMaterial.NETHERITE,1f,-3f,settings.fireproof().rarity(Rarity.RARE)));
    public static final Item GLACIER_SCYTHE = registerItem("glacier_scythe",settings ->new GlacierScytheItem(ToolMaterial.NETHERITE,1f,-3f,settings.fireproof().rarity(Rarity.EPIC)));

    public static final Item COSMETIC_DICE = registerItem("cosmetic_dice",settings -> new CosmeticDice(settings.maxCount(8).rarity(Rarity.UNCOMMON)));

    public static final Item ORB_OF_DOMINANCE_HELMET = registerItem("orb_of_dominance_helmet",settings -> new Item(
            settings.fireproof().armor(ModArmorMaterials.ORB_OF_DOMINANCE_ARMOR_MATERIAL,EquipmentType.HELMET).maxDamage(EquipmentType.HELMET.getMaxDamage(400))){
        @Override
        public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
            if(!world.isClient && entity instanceof PlayerEntity player&&player.getEquippedStack(EquipmentSlot.HEAD).getItem()==ORB_OF_DOMINANCE_HELMET){
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,100,0));
            }
            super.inventoryTick(stack, world, entity, EquipmentSlot.HEAD);
        }

    });
public static final Item ORB_OF_DOMINANCE_CHESTPLATE = registerItem("orb_of_dominance_chestplate",settings -> new Item(
        settings.fireproof().armor(ModArmorMaterials.ORB_OF_DOMINANCE_ARMOR_MATERIAL,EquipmentType.CHESTPLATE).maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(400))){

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if(!world.isClient && entity instanceof PlayerEntity player&&player.getEquippedStack(EquipmentSlot.CHEST).getItem()==ORB_OF_DOMINANCE_CHESTPLATE){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,100,0));
        }
        super.inventoryTick(stack, world, entity, EquipmentSlot.CHEST);
    }
});
public static final Item ORB_OF_DOMINANCE_LEGGINGS = registerItem("orb_of_dominance_leggings",settings -> new Item(
        settings.fireproof().armor(ModArmorMaterials.ORB_OF_DOMINANCE_ARMOR_MATERIAL,EquipmentType.LEGGINGS).maxDamage(EquipmentType.LEGGINGS.getMaxDamage(400))){

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if(!world.isClient && entity instanceof PlayerEntity player&&player.getEquippedStack(EquipmentSlot.LEGS).getItem()==ORB_OF_DOMINANCE_LEGGINGS){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST,100,0));
        }
        super.inventoryTick(stack, world, entity, EquipmentSlot.LEGS);
    }
});
public static final Item ORB_OF_DOMINANCE_BOOTS = registerItem("orb_of_dominance_boots",settings -> new Item(
        settings.fireproof().armor(ModArmorMaterials.ORB_OF_DOMINANCE_ARMOR_MATERIAL,EquipmentType.BOOTS).maxDamage(EquipmentType.BOOTS.getMaxDamage(400))){

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if(!world.isClient && entity instanceof PlayerEntity player&&player.getEquippedStack(EquipmentSlot.FEET).getItem()==ORB_OF_DOMINANCE_BOOTS){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,100,0));
        }
        super.inventoryTick(stack, world, entity, EquipmentSlot.FEET);
    }
});



    protected static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Renew.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Renew.MOD_ID, name)))));
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
            entries.addAfter(Items.NETHERITE_BOOTS,ORB_OF_DOMINANCE_HELMET);
            entries.addAfter(ORB_OF_DOMINANCE_HELMET,ORB_OF_DOMINANCE_CHESTPLATE);
            entries.addAfter(ORB_OF_DOMINANCE_CHESTPLATE,ORB_OF_DOMINANCE_LEGGINGS);
            entries.addAfter(ORB_OF_DOMINANCE_LEGGINGS,ORB_OF_DOMINANCE_BOOTS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries->{
            entries.addAfter(Items.WOODEN_HOE,WOODEN_SCYTHE);
            entries.addAfter(Items.STONE_HOE,STONE_SCYTHE);
            entries.addAfter(Items.IRON_HOE,IRON_SCYTHE);
            entries.addAfter(Items.GOLDEN_HOE,GOLDEN_SCYTHE);
            entries.addAfter(Items.DIAMOND_HOE,DIAMOND_SCYTHE);
            entries.addAfter(Items.NETHERITE_HOE,NETHERITE_SCYTHE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addAfter(ModItems.NETHERITE_SCYTHE,ORB_OF_DOMINANCE_AXE);
            entries.addAfter(ORB_OF_DOMINANCE_AXE,ORB_OF_DOMINANCE_PICKAXE);
            entries.addAfter(ORB_OF_DOMINANCE_PICKAXE,ORB_OF_DOMINANCE_SHOVEL);
            entries.addAfter(ORB_OF_DOMINANCE_SHOVEL,ORB_OF_DOMINANCE_HOE);
            entries.addAfter(ORB_OF_DOMINANCE_HOE,ORB_OF_DOMINANCE_SCYTHE);
            entries.addAfter(OrbOfDominanceTools.ORB_OF_DOMINANCE_SCYTHE,ENCHANTER_SCYTHE);
            entries.addAfter(ENCHANTER_SCYTHE,GLACIER_SCYTHE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(e ->{
            e.addAfter(Items.NETHERITE_SWORD,ORB_OF_DOMINANCE_SWORD);
            e.addAfter(ModItems.NETHERITE_CUTLASS,ORB_OF_DOMINANCE_CUTLASS);
        });
    }

}
