package me.shadowflare.deadsky;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public enum DeadSkyEndGeneration {
    VOID_METAL_ORE(RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(DeadSky.ID, "void_metal_ore")));

    private final RegistryKey<PlacedFeature> key;

    private DeadSkyEndGeneration(RegistryKey<PlacedFeature> key) {
        this.key = key;
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, key);
        System.out.println("Loaded: " + key.getValue());
    }

    public static void load() {}
}
