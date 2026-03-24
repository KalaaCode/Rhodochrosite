package net.kalaa.rhodochrosite.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kalaa.rhodochrosite.Rhodochrosite;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RHODOCHROSITE = registerItem("rhodochrosite", new Item(new Item.Settings()));
    public static final Item RAW_RHODOCHROSITE = registerItem("raw_rhodochrosite", new Item(new Item.Settings()));

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