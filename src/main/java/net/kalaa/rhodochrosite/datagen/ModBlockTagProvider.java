package net.kalaa.rhodochrosite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kalaa.rhodochrosite.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RHODOCHROSITE_BLOCK)
                .add(ModBlocks.RAW_RHODOCHROSITE_BLOCK)
                .add(ModBlocks.RHODOCHROSITE_ORE)
                .add(ModBlocks.RHODOCHROSITE_DEEPSLATE_ORE)
                .add(ModBlocks.RHODOCHROSITE_STAIRS)
                .add(ModBlocks.RHODOCHROSITE_SLAB)
                .add(ModBlocks.RHODOCHROSITE_WALL)
                .add(ModBlocks.RHODOCHROSITE_LANTERN);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RHODOCHROSITE_BLOCK)
                .add(ModBlocks.RAW_RHODOCHROSITE_BLOCK)
                .add(ModBlocks.RHODOCHROSITE_ORE)
                .add(ModBlocks.RHODOCHROSITE_DEEPSLATE_ORE)
                .add(ModBlocks.RHODOCHROSITE_STAIRS)
                .add(ModBlocks.RHODOCHROSITE_SLAB)
                .add(ModBlocks.RHODOCHROSITE_WALL);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.RHODOCHROSITE_WALL);
    }
}