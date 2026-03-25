package net.kalaa.rhodochrosite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kalaa.rhodochrosite.block.ModBlocks;
import net.kalaa.rhodochrosite.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> RHODOCHROSITE_SMELTABLES = List.of(ModItems.RAW_RHODOCHROSITE, ModBlocks.RHODOCHROSITE_ORE,
                ModBlocks.RHODOCHROSITE_DEEPSLATE_ORE);

        offerSmelting(exporter, RHODOCHROSITE_SMELTABLES, RecipeCategory.MISC, ModItems.RHODOCHROSITE, 0.7f, 200, "rhodochrosite");
        offerBlasting(exporter, RHODOCHROSITE_SMELTABLES, RecipeCategory.MISC, ModItems.RHODOCHROSITE, 0.7f, 100, "rhodochrosite");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RHODOCHROSITE, RecipeCategory.DECORATIONS, ModBlocks.RHODOCHROSITE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RHODOCHROSITE_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RHODOCHROSITE)
                .criterion(hasItem(ModItems.RHODOCHROSITE), conditionsFromItem(ModItems.RHODOCHROSITE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RHODOCHROSITE, 9)
                .input(ModBlocks.RHODOCHROSITE_BLOCK)
                .criterion(hasItem(ModBlocks.RHODOCHROSITE_BLOCK), conditionsFromItem(ModBlocks.RHODOCHROSITE_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAW_RHODOCHROSITE_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RAW_RHODOCHROSITE)
                .criterion(hasItem(ModItems.RAW_RHODOCHROSITE), conditionsFromItem(ModItems.RAW_RHODOCHROSITE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_RHODOCHROSITE, 9)
                .input(ModBlocks.RAW_RHODOCHROSITE_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_RHODOCHROSITE_BLOCK), conditionsFromItem(ModBlocks.RAW_RHODOCHROSITE_BLOCK))
                .offerTo(exporter);
    }
}
