package net.kalaa.rhodochrosite.trim;

import net.kalaa.rhodochrosite.Rhodochrosite;
import net.kalaa.rhodochrosite.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimPattern;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModTrimPatterns {
    public static void register() {
        Rhodochrosite.LOGGER.info("Registering Trim Patterns for " + Rhodochrosite.MOD_ID);
    }

    public static final RegistryKey<ArmorTrimPattern> JEWELRY = RegistryKey.of(RegistryKeys.TRIM_PATTERN,
            Identifier.of(Rhodochrosite.MOD_ID, "jewelry"));

    public static void bootstrap(Registerable<ArmorTrimPattern> context) {
        register(context, ModItems.JEWELRY_SMITHING_TEMPLATE, JEWELRY);
        System.out.println("DEBUG: Jewelry Pattern is looking for: " + JEWELRY.getValue());
    }

    private static void register(Registerable<ArmorTrimPattern> context, Item item, RegistryKey<ArmorTrimPattern> key) {
        ArmorTrimPattern trimPattern = new ArmorTrimPattern(key.getValue(), Registries.ITEM.getEntry(item),
                Text.translatable(Util.createTranslationKey("trim_pattern", key.getValue())), false);

        context.register(key, trimPattern);
    }
}