package me.shadowflare.deadsky.effects;

import me.shadowflare.deadsky.DeadSky;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public abstract class DeadSkyEffects {
    public static void load() {}

    public static Frostburn FROSTBURN = Registry.register(Registries.STATUS_EFFECT, new Identifier(DeadSky.ID, "frostburn"), new Frostburn(StatusEffectCategory.HARMFUL, 0x0000FF));
}
