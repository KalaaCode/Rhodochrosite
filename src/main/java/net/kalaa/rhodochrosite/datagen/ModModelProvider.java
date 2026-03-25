package net.kalaa.rhodochrosite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kalaa.rhodochrosite.block.ModBlocks;
import net.kalaa.rhodochrosite.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RHODOCHROSITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_RHODOCHROSITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RHODOCHROSITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RHODOCHROSITE_DEEPSLATE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RHODOCHROSITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_RHODOCHROSITE, Models.GENERATED);
    }
}
