package net.kalaa.rhodochrosite.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.kalaa.rhodochrosite.Rhodochrosite;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final SimpleParticleType RHODOCHROSITE_FLAME = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Rhodochrosite.MOD_ID, "rhodochrosite_flame"),
                RHODOCHROSITE_FLAME);
    }
}