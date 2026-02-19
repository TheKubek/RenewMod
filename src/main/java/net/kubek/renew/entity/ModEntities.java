package net.kubek.renew.entity;

import net.kubek.renew.Renew;
import net.kubek.renew.entity.custom.CorruptedEnchanterEntity;
import net.kubek.renew.entity.custom.EnchanterEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final RegistryKey<EntityType<?>> ENCHANTER_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE,Identifier.of(Renew.MOD_ID,"enchanter"));
    public static final EntityType<EnchanterEntity> ENCHANTER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Renew.MOD_ID,"enchanter"),
            EntityType.Builder.create(EnchanterEntity::new, SpawnGroup.MONSTER).dimensions(1.2f,3f).makeFireImmune().maxTrackingRange(40).build(ENCHANTER_KEY));
    public static final RegistryKey<EntityType<?>> CORRUPTED_ENCHANTER_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE,Identifier.of(Renew.MOD_ID,"corrupted_enchanter"));
    public static final EntityType<CorruptedEnchanterEntity> CORRUPTED_ENCHANTER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Renew.MOD_ID,"corrupted_enchanter"),
            EntityType.Builder.create(CorruptedEnchanterEntity::new, SpawnGroup.MONSTER).dimensions(1.2f,3f).makeFireImmune().maxTrackingRange(50).build(CORRUPTED_ENCHANTER_KEY));

    public static void registerModEntities(){}
}
