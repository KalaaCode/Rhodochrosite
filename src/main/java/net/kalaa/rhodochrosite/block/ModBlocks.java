package net.kalaa.rhodochrosite.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kalaa.rhodochrosite.Rhodochrosite;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block RHODOCHROSITE_BLOCK = registerBlock("rhodochrosite_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RAW_RHODOCHROSITE_BLOCK = registerBlock("raw_rhodochrosite_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.CALCITE)));
    public static final Block RHODOCHROSITE_ORE = registerBlock("rhodochrosite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block RHODOCHROSITE_DEEPSLATE_ORE = registerBlock("rhodochrosite_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Rhodochrosite.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Rhodochrosite.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Rhodochrosite.LOGGER.info("Registering Mod Blocks for" + Rhodochrosite.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.RHODOCHROSITE_BLOCK);
            entries.add(ModBlocks.RAW_RHODOCHROSITE_BLOCK);
        });
    }
}
