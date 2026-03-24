package net.kalaa.rhodochrosite;

import net.fabricmc.api.ModInitializer;

import net.kalaa.rhodochrosite.block.ModBlocks;
import net.kalaa.rhodochrosite.item.ModItemGroups;
import net.kalaa.rhodochrosite.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 //Very important comment
public class Rhodochrosite implements ModInitializer {
	public static final String MOD_ID = "rhodochrosite";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
	}
}