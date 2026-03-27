package net.kalaa.rhodochrosite.util;

import net.kalaa.rhodochrosite.Rhodochrosite;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_RHODOCHROSITE_TOOL = createTag("needs_rhodochrosite_tool");
        public static final TagKey<Block> INCORRECT_FOR_RHODOCHROSITE_TOOL = createTag("incorrect_for_rhodochrosite_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Rhodochrosite.MOD_ID, name));
        }
    }

}
