package net.kubek.renew.entity.client;

import net.kubek.renew.Renew;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModEntityModelLayers {
    public static EntityModelLayer ENCHANTER =
            new EntityModelLayer(Identifier.of(Renew.MOD_ID,"enchanter"),"main");
    public static EntityModelLayer CORRUPTED_ENCHANTER =
            new EntityModelLayer(Identifier.of(Renew.MOD_ID,"corrupted_enchanter"),"main");
}
