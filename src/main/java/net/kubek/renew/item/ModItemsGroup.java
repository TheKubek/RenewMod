package net.kubek.renew.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.kubek.renew.Renew;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroup {
    public static final ItemGroup ORB_OF_DOMINANCE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Renew.MOD_ID,"orb_of_dominance"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.orb_of_dominance"))
                    .icon(()-> new ItemStack(ModItems.STAFF_OF_DOMINANCE))
                    .entries((displayContext, entries) -> {
                    entries.add(ModItems.STAFF_OF_DOMINANCE);
                    entries.add(ModItems.ORB_OF_DOMINANCE);
                    entries.add(ModItems.DOMINANCE_DICE);

                    }).build());
    public static final ItemGroup ORB_OF_DOMINANCE_PARTS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Renew.MOD_ID,"orb_of_dominance_parts"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.orb_of_dominance_parts"))
                    .icon(()-> new ItemStack(ModItems.ORB_OF_DOMINANCE))
                    .entries((displayContext, entries) -> {
                        entries.add(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_ONE);
                        entries.add(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_TWO);
                        entries.add(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_THREE);
                        entries.add(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_FOUR);
                        entries.add(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_FIVE);
                        entries.add(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_SIX);
                        entries.add(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_SEVEN);
                        entries.add(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_EIGHT);
                        entries.add(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_NINE);



                    }).build());
    public static final ItemGroup PLUSHIES_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Renew.MOD_ID,"plushies"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.plushies"))
                    .icon(()-> new ItemStack(ModItems.TEDDY_BEAR_PLUSHIE))
                    .entries((displayContext, entries) -> {
                    entries.add(ModItems.TEDDY_BEAR_PLUSHIE);
                    entries.add(ModItems.MONKEY_PLUSHIE);
                    entries.add(ModItems.KOALA_PLUSHIE);
                    entries.add(ModItems.RED_PANDA_PLUSHIE);
                    entries.add(ModItems.COSMETIC_DICE);


                    }).build());

    public static void registerItemGroups(){}
}
