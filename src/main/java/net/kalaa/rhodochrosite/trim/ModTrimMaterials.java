package net.kalaa.rhodochrosite.trim;

import net.kalaa.rhodochrosite.Rhodochrosite;
import net.kalaa.rhodochrosite.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class ModTrimMaterials {
    public static void register() {
        Rhodochrosite.LOGGER.info("Registering Trim Materials for " + Rhodochrosite.MOD_ID);
    }

    public static final RegistryKey<ArmorTrimMaterial> RHODOCHROSITE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(Rhodochrosite.MOD_ID, "rhodochrosite"));

    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable) {
        register(registerable, RHODOCHROSITE, Registries.ITEM.getEntry(ModItems.RHODOCHROSITE),
                Style.EMPTY.withColor(TextColor.parse("#ff91af").getOrThrow()), 0.4f);

    }

    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> armorTrimKey,
                                 RegistryEntry<Item> item, Style style, float itemModelIndex) {
        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(armorTrimKey.getValue().getPath(), item, itemModelIndex, Map.of(),
                Text.translatable(Util.createTranslationKey("trim_material", armorTrimKey.getValue())).fillStyle(style));

        registerable.register(armorTrimKey, trimMaterial);
    }
}