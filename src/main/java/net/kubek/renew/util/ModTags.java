package net.kubek.renew.util;

import net.kubek.renew.Renew;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
        public static class Blocks{
            public static final TagKey<Block> NEEDS_ORB_OF_DOMINANCE_TOOl = createTag("needs_orb_of_dominance_tool");
            public static final TagKey<Block> INCORRECT_FOR_ORB_OF_DOMINANCE_TOOL = createTag("incorrect_for_orb_of_dominance_tool");



            private static TagKey<Block> createTag(String name){
                return TagKey.of(RegistryKeys.BLOCK,Identifier.of(Renew.MOD_ID,name));
            }
        }
        public static class Items {
        public static final TagKey<Item> CUTLASSES =createTag("cutlasses");
        public static final TagKey<Item> SCYTHES =createTag("scythes");
        public static final TagKey<Item> ORB_OF_DOMINANCE =createTag("orb_of_dominance");




        private static TagKey<Item> createTag(String name){
                return TagKey.of(RegistryKeys.ITEM, Identifier.of(Renew.MOD_ID,name));
            }
        }
}
