package me.shadowflare.deadsky;

import me.shadowflare.deadsky.blocks.DeadSkyBlocks;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public enum DeadSkyDamageTypes {
    FROSTBURN(RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(DeadSky.ID, "frostburn")));

    private final RegistryKey<DamageType> key;

    public DamageSource get(World wrl) {
        return new DamageSource(wrl.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }

    private DeadSkyDamageTypes(RegistryKey<DamageType> key) {
        this.key = key;
    }

    public static void load() {}
}
