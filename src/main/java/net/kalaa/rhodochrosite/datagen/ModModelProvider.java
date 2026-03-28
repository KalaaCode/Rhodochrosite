package net.kalaa.rhodochrosite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.kalaa.rhodochrosite.block.ModBlocks;
import net.kalaa.rhodochrosite.item.ModItems;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        generator.registerSimpleCubeAll(ModBlocks.RAW_RHODOCHROSITE_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.RHODOCHROSITE_ORE);
        generator.registerSimpleCubeAll(ModBlocks.RHODOCHROSITE_DEEPSLATE_ORE);

        generator.registerCubeAllModelTexturePool(ModBlocks.RHODOCHROSITE_BLOCK)
                .stairs(ModBlocks.RHODOCHROSITE_STAIRS)
                .slab(ModBlocks.RHODOCHROSITE_SLAB)
                .wall(ModBlocks.RHODOCHROSITE_WALL);

        // This handles the torch item and both block models
        generator.registerTorch(ModBlocks.RHODOCHROSITE_TORCH, ModBlocks.RHODOCHROSITE_WALL_TORCH);

        // This handles the lantern item and the hanging/standing block models
        generator.registerLantern(ModBlocks.RHODOCHROSITE_LANTERN);
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        generator.register(ModItems.RHODOCHROSITE, Models.GENERATED);
        generator.register(ModItems.RAW_RHODOCHROSITE, Models.GENERATED);

        generator.register(ModItems.RHODOCHROSITE_SWORD, Models.HANDHELD);
        generator.register(ModItems.RHODOCHROSITE_PICKAXE, Models.HANDHELD);
        generator.register(ModItems.RHODOCHROSITE_SHOVEL, Models.HANDHELD);
        generator.register(ModItems.RHODOCHROSITE_AXE, Models.HANDHELD);
        generator.register(ModItems.RHODOCHROSITE_HOE, Models.HANDHELD);

        generator.registerArmor(((ArmorItem) ModItems.RHODOCHROSITE_HELMET));
        generator.registerArmor(((ArmorItem) ModItems.RHODOCHROSITE_CHESTPLATE));
        generator.registerArmor(((ArmorItem) ModItems.RHODOCHROSITE_LEGGINGS));
        generator.registerArmor(((ArmorItem) ModItems.RHODOCHROSITE_BOOTS));

        generator.register(ModItems.RHODOCHROSITE_HORSE_ARMOR, Models.GENERATED);
    }
}