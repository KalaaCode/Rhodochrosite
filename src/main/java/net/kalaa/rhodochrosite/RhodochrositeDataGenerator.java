package net.kalaa.rhodochrosite;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.kalaa.rhodochrosite.datagen.ModBlockTagProvider;
import net.kalaa.rhodochrosite.datagen.ModLootTableProvider;
import net.kalaa.rhodochrosite.datagen.ModModelProvider;
import net.kalaa.rhodochrosite.datagen.ModRecipeProvider;

public class RhodochrositeDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
