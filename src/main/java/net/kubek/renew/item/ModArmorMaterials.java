
package net.kubek.renew.item;


import net.kubek.renew.Renew;
import net.kubek.renew.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<EquipmentAsset> ORB_OF_DOMINANCE_KEY = RegistryKey.of(REGISTRY_KEY,Identifier.of(Renew.MOD_ID,"orb_of_dominance"));

    public static final ArmorMaterial ORB_OF_DOMINANCE_ARMOR_MATERIAL = new ArmorMaterial(7000, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 6);
        map.put(EquipmentType.LEGGINGS, 12);
        map.put(EquipmentType.CHESTPLATE, 16);
        map.put(EquipmentType.HELMET, 6);
        map.put(EquipmentType.BODY, 22);
    }),20,SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,6f,1f, ModTags.Items.ORB_OF_DOMINANCE,ORB_OF_DOMINANCE_KEY);
}
