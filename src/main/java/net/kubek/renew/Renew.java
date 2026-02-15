package net.kubek.renew;

import net.fabricmc.api.ModInitializer;

import net.kubek.renew.components.ModDataComponentTypes;
import net.kubek.renew.item.ModItems;
import net.kubek.renew.item.ModItemsGroup;
import net.kubek.renew.item.OrbOfDominanceParts;
import net.kubek.renew.item.OrbOfDominanceTools;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.Rarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Renew implements ModInitializer {
	public static final String MOD_ID = "renew";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
        ModItems.registerModItems();
        OrbOfDominanceTools.registerOrbOfDominanceTools();
        ModItemsGroup.registerItemGroups();
        OrbOfDominanceParts.registerOrbOfDominanceParts();
        ModDataComponentTypes.registerDataComponentTypes();



	}
}