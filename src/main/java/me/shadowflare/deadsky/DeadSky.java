package me.shadowflare.deadsky;

import me.shadowflare.deadsky.blocks.DeadSkyBlocks;
import me.shadowflare.deadsky.effects.DeadSkyEffects;
import me.shadowflare.deadsky.items.DeadSkyItems;
import net.fabricmc.api.ModInitializer;

public class DeadSky implements ModInitializer {

	public static final String ID = "deadsky";

	@Override
	public void onInitialize() {
		DeadSkyItems.load();
		DeadSkyBlocks.load();
		DeadSkyEffects.load();

		DeadSkyDamageTypes.load();
		DeadSkyEndGeneration.load();
	}
}