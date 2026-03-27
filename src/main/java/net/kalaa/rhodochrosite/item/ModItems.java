package net.kalaa.rhodochrosite.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kalaa.rhodochrosite.Rhodochrosite;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RHODOCHROSITE = registerItem("rhodochrosite", new Item(new Item.Settings()));
    public static final Item RAW_RHODOCHROSITE = registerItem("raw_rhodochrosite", new Item(new Item.Settings()));

    public static final Item RHODOCHROSITE_SWORD = registerItem("rhodochrosite_sword",
            new SwordItem(ModToolMaterials.RHODOCHROSITE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RHODOCHROSITE, 3, -2.4f))));
    public static final Item RHODOCHROSITE_PICKAXE = registerItem("rhodochrosite_pickaxe",
            new PickaxeItem(ModToolMaterials.RHODOCHROSITE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.RHODOCHROSITE, 1, -2.4f))));
    public static final Item RHODOCHROSITE_SHOVEL = registerItem("rhodochrosite_shovel",
            new ShovelItem(ModToolMaterials.RHODOCHROSITE, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.RHODOCHROSITE, 1.5f, -3.0f))));
    public static final Item RHODOCHROSITE_AXE = registerItem("rhodochrosite_axe",
            new AxeItem(ModToolMaterials.RHODOCHROSITE, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.RHODOCHROSITE, 6, -3.2f))));
    public static final Item RHODOCHROSITE_HOE = registerItem("rhodochrosite_hoe",
            new HoeItem(ModToolMaterials.RHODOCHROSITE, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.RHODOCHROSITE, 0, -3f))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Rhodochrosite.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Rhodochrosite.LOGGER.info("Registering Mod Items for " + Rhodochrosite.MOD_ID);


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RHODOCHROSITE);
            entries.add(RAW_RHODOCHROSITE);
        });
    }
}