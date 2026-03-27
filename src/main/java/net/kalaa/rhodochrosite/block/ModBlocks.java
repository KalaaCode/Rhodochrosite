package net.kalaa.rhodochrosite.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kalaa.rhodochrosite.Rhodochrosite;
import net.kalaa.rhodochrosite.particle.ModParticles;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    // 1. ALL YOUR NORMAL BLOCKS
    public static final Block RHODOCHROSITE_BLOCK = registerBlock("rhodochrosite_block", new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RAW_RHODOCHROSITE_BLOCK = registerBlock("raw_rhodochrosite_block", new Block(AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.CALCITE)));
    public static final Block RHODOCHROSITE_ORE = registerBlock("rhodochrosite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block RHODOCHROSITE_DEEPSLATE_ORE = registerBlock("rhodochrosite_deepslate_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 6), AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block RHODOCHROSITE_STAIRS = registerBlock("rhodochrosite_stairs", new StairsBlock(ModBlocks.RHODOCHROSITE_BLOCK.getDefaultState(), AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block RHODOCHROSITE_SLAB = registerBlock("rhodochrosite_slab", new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block RHODOCHROSITE_WALL = registerBlock("rhodochrosite_wall", new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block RHODOCHROSITE_LANTERN = registerBlock("rhodochrosite_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN).nonOpaque()));

    // 2. THE TORCH "SHORTCUT"
    // We register the blocks normally
    public static final Block RHODOCHROSITE_TORCH = Registry.register(Registries.BLOCK,
            Identifier.of(Rhodochrosite.MOD_ID, "rhodochrosite_torch"),
            new TorchBlock(ModParticles.RHODOCHROSITE_FLAME, AbstractBlock.Settings.copy(Blocks.TORCH).nonOpaque()));

    public static final Block RHODOCHROSITE_WALL_TORCH = Registry.register(Registries.BLOCK,
            Identifier.of(Rhodochrosite.MOD_ID, "rhodochrosite_wall_torch"),
            new WallTorchBlock(ModParticles.RHODOCHROSITE_FLAME, AbstractBlock.Settings.copy(Blocks.WALL_TORCH).nonOpaque().dropsLike(RHODOCHROSITE_TORCH)));

    // We register the Item MANUALLY here
    public static final Item RHODOCHROSITE_TORCH_ITEM = Registry.register(Registries.ITEM, Identifier.of(Rhodochrosite.MOD_ID, "rhodochrosite_torch"), new VerticallyAttachableBlockItem(RHODOCHROSITE_TORCH, RHODOCHROSITE_WALL_TORCH, new Item.Settings(), Direction.DOWN));


    private static Block registerBlock(String name, Block block) {
        // Standard registration for everything EXCEPT torches
        Registry.register(Registries.ITEM, Identifier.of(Rhodochrosite.MOD_ID, name), new BlockItem(block, new Item.Settings()));
        return Registry.register(Registries.BLOCK, Identifier.of(Rhodochrosite.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        Rhodochrosite.LOGGER.info("Registering Mod Blocks for " + Rhodochrosite.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.RHODOCHROSITE_BLOCK);
            entries.add(ModBlocks.RAW_RHODOCHROSITE_BLOCK);
            entries.add(ModBlocks.RHODOCHROSITE_STAIRS);
            entries.add(ModBlocks.RHODOCHROSITE_SLAB);
            entries.add(ModBlocks.RHODOCHROSITE_WALL);
            entries.add(ModBlocks.RHODOCHROSITE_TORCH_ITEM); // Add the ITEM, not the block
            entries.add(ModBlocks.RHODOCHROSITE_LANTERN);
        });
    }
}