package net.kalaa.rhodochrosite;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.kalaa.rhodochrosite.block.ModBlocks;
import net.kalaa.rhodochrosite.particle.ModParticles;
import net.kalaa.rhodochrosite.particle.RhodochrositeFlameParticle;
import net.minecraft.client.render.RenderLayer;

public class RhodochrositeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RHODOCHROSITE_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RHODOCHROSITE_WALL_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RHODOCHROSITE_LANTERN, RenderLayer.getCutout());
        ParticleFactoryRegistry.getInstance().register(ModParticles.RHODOCHROSITE_FLAME, RhodochrositeFlameParticle.Factory::new);
    }
}