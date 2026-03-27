package net.kalaa.rhodochrosite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kalaa.rhodochrosite.item.ModItems;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.kalaa.rhodochrosite.block.ModBlocks;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        // No specific tags needed for logic, but good for organization!
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.RHODOCHROSITE_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.RHODOCHROSITE_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.RHODOCHROSITE_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.RHODOCHROSITE_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.RHODOCHROSITE_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.RHODOCHROSITE_HELMET)
                .add(ModItems.RHODOCHROSITE_CHESTPLATE)
                .add(ModItems.RHODOCHROSITE_LEGGINGS)
                .add(ModItems.RHODOCHROSITE_BOOTS);
    }
}