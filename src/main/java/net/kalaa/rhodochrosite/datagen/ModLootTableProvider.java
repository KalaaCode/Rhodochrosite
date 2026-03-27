package net.kalaa.rhodochrosite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.kalaa.rhodochrosite.block.ModBlocks;
import net.kalaa.rhodochrosite.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RHODOCHROSITE_BLOCK);
        addDrop(ModBlocks.RAW_RHODOCHROSITE_BLOCK);

        addDrop(ModBlocks.RHODOCHROSITE_ORE, multipleOreDrops(ModBlocks.RHODOCHROSITE_ORE, ModItems.RAW_RHODOCHROSITE, 3, 5));
        addDrop(ModBlocks.RHODOCHROSITE_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.RHODOCHROSITE_DEEPSLATE_ORE, ModItems.RAW_RHODOCHROSITE, 5, 7));

        addDrop(ModBlocks.RHODOCHROSITE_STAIRS);
        addDrop(ModBlocks.RHODOCHROSITE_SLAB, slabDrops(ModBlocks.RHODOCHROSITE_SLAB));
        addDrop(ModBlocks.RHODOCHROSITE_WALL);

        addDrop(ModBlocks.RHODOCHROSITE_TORCH);
        addDrop(ModBlocks.RHODOCHROSITE_LANTERN);
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, int minDrops, int maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
