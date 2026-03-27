package net.kalaa.rhodochrosite.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kalaa.rhodochrosite.Rhodochrosite;
import net.kalaa.rhodochrosite.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup RHODOCHROSITE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Rhodochrosite.MOD_ID, "rhodochrosite_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RHODOCHROSITE))
                    .displayName(Text.translatable("itemgroup.rhodochrosite.rhodochrosite_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RHODOCHROSITE);
                        entries.add(ModItems.RAW_RHODOCHROSITE);
                    }).build());

    public static final ItemGroup RHODOCHROSITE_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Rhodochrosite.MOD_ID, "rhodochrosite_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.RHODOCHROSITE_BLOCK))
                    .displayName(Text.translatable("itemgroup.rhodochrosite.rhodochrosite_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RHODOCHROSITE_BLOCK);
                        entries.add(ModBlocks.RAW_RHODOCHROSITE_BLOCK);

                        entries.add(ModBlocks.RHODOCHROSITE_ORE);
                        entries.add(ModBlocks.RHODOCHROSITE_DEEPSLATE_ORE);

                        entries.add(ModBlocks.RHODOCHROSITE_STAIRS);
                        entries.add(ModBlocks.RHODOCHROSITE_SLAB);
                        entries.add(ModBlocks.RHODOCHROSITE_WALL);

                        entries.add(ModBlocks.RHODOCHROSITE_TORCH);
                        entries.add(ModBlocks.RHODOCHROSITE_LANTERN);
                    }).build());



    public static void registerItemGroups() {
        Rhodochrosite.LOGGER.info("Registering Item Groups for " + Rhodochrosite.MOD_ID);
    }
}
