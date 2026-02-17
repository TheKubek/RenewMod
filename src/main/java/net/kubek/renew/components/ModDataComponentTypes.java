package net.kubek.renew.components;

import com.mojang.serialization.Codec;
import net.kubek.renew.Renew;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    public static final ComponentType<Float> AdditionalDamage =register("additional_damage",builder -> builder.codec(Codec.FLOAT));


    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator){
        return Registry.register(Registries.DATA_COMPONENT_TYPE
                , Identifier.of(Renew.MOD_ID,name)
                ,(builderOperator.apply(ComponentType.builder()).build()));
    }

    public static void registerDataComponentTypes(){}
}
