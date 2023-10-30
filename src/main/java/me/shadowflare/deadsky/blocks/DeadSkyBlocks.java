package me.shadowflare.deadsky.blocks;

import me.shadowflare.deadsky.DeadSky;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DeadSkyBlocks {
	public static void load() {}
	
	public static final Block VOID_METAL_BLOCK = Registry.register(Registries.BLOCK, new Identifier(DeadSky.ID, "void_metal_block"), new Block(FabricBlockSettings.create().requiresTool().strength(45.0F, 1200.0F)));
	public static final Block VOID_METAL_ORE = Registry.register(Registries.BLOCK, new Identifier(DeadSky.ID, "void_metal_ore"), new Block(FabricBlockSettings.create().requiresTool().strength(45.0F, 1200.0F)));
	public static final Block RAW_VOID_METAL_BLOCK = Registry.register(Registries.BLOCK, new Identifier(DeadSky.ID, "raw_void_metal_ore"), new Block(FabricBlockSettings.create().requiresTool().strength(45.0F, 1200.0F)));
}
