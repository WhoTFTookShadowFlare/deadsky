package me.shadowflare.deadsky.config;

import me.lortseam.completeconfig.api.ConfigEntry;
import me.lortseam.completeconfig.api.ConfigGroup;
import me.lortseam.completeconfig.data.Config;
import me.lortseam.completeconfig.data.ConfigOptions;

public class DeadSkyConfig extends Config {

	private DeadSkyConfig() {
		super(ConfigOptions.mod("deadsky"));
		load();
	}
	public static void ensureLoaded() {}
	protected static DeadSkyConfig getInstance() {
		return instance;
	}

	private static final DeadSkyConfig instance = new DeadSkyConfig();

	@Transitive
	public static class VanillaRebalance implements ConfigGroup {
	
		@ConfigEntry(
				nameKey = "deadsky.config.vanilla_rebalance.totem_cooldown",
				descriptionKey = "deadsky.config.vanilla_rebalance.totem_cooldown.description"
				)
		@ConfigEntry.BoundedInteger(min = 0)
		private static int totemCooldown = 24000;
	
		public static int getTotemCooldown() {
			return totemCooldown;
		}

		@ConfigEntry(
				nameKey = "deadsky.config.vanilla_rebalance.rework_netherite_defense",
				descriptionKey = "deadsky.config.vanilla_rebalance.rework_netherite_defense.description",
				requiresRestart = true
		)
		//@ConfigEntry.Checkbox // <- Breaks config screen
		private static boolean reworkNetheriteDefense = true;

		public static boolean getReworkNetheriteDefense() {
			return reworkNetheriteDefense;
		}

	}
}
