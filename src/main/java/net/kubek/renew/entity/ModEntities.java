package net.kubek.renew.entity;

import net.kubek.renew.Renew;
import net.kubek.renew.entity.custom.EnchanterEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<EnchanterEntity> ENCHANTER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Renew.MOD_ID,"enchanter"),
            EntityType.Builder.create(EnchanterEntity::new, SpawnGroup.MONSTER).dimensions(1f,2.5f).makeFireImmune().maxTrackingRange(40).build());
    public static void registerModEntities(){}
}
