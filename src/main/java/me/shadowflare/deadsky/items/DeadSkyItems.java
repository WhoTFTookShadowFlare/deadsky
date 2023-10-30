package me.shadowflare.deadsky.items;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import me.shadowflare.deadsky.DeadSky;
import me.shadowflare.deadsky.blocks.DeadSkyBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class DeadSkyItems {
	public static void load() {}

	public static final Item VOID_METAL_UPGRADE_TEMPLATE = Registry.register(Registries.ITEM, new Identifier(DeadSky.ID, "void_metal_upgrade_template"), new VoidMetal.UpgradeTemplate());
	public static final BlockItem VOID_METAL_ORE = Registry.register(Registries.ITEM, new Identifier(DeadSky.ID, "void_metal_ore"), new BlockItem(DeadSkyBlocks.VOID_METAL_ORE, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
	public static final Item RAW_VOID_METAL = Registry.register(Registries.ITEM, new Identifier(DeadSky.ID, "raw_void_metal"), new VoidMetal.Raw(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
	public static final Item VOID_METAL_NUGGET = Registry.register(Registries.ITEM, new Identifier(DeadSky.ID, "void_metal_nugget"), new VoidMetal.Nugget(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
	public static final Item VOID_METAL_INGOT = Registry.register(Registries.ITEM, new Identifier(DeadSky.ID, "void_metal_ingot"), new VoidMetal.Ingot(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
	public static final BlockItem VOID_METAL_BLOCK = Registry.register(Registries.ITEM, new Identifier(DeadSky.ID, "void_metal_block"), new VoidMetal.Block(DeadSkyBlocks.VOID_METAL_BLOCK, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
	public static final BlockItem RAW_VOID_METAL_BLOCK = Registry.register(Registries.ITEM, new Identifier(DeadSky.ID, "raw_void_metal_block"), new VoidMetal.RawBlock(DeadSkyBlocks.RAW_VOID_METAL_BLOCK, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
	public static final SwordItem VOID_METAL_SWORD = Registry.register(Registries.ITEM, new Identifier(DeadSky.ID, "void_metal_sword"), new VoidMetal.Sword(new FabricItemSettings().rarity(Rarity.UNCOMMON).maxDamage(4096)));
	public static final FabricShieldItem VOID_METAL_SHIELD = Registry.register(Registries.ITEM, new Identifier(DeadSky.ID, "void_metal_shield"), new VoidMetal.Shield(new FabricItemSettings().rarity(Rarity.UNCOMMON).maxDamage(4096)));
	public static final PickaxeItem VOID_METAL_PICKAXE = Registry.register(Registries.ITEM, new Identifier(DeadSky.ID, "void_metal_pickaxe"), new PickaxeItem(new VoidMetal.Tool(), 0, 0.0f, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
	public static final AxeItem VOID_METAL_AXE = Registry.register(Registries.ITEM, new Identifier(DeadSky.ID, "void_metal_axe"), new AxeItem(new VoidMetal.Tool(), 0, 0.0f, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
	public static final ShovelItem VOID_METAL_SHOVEL = Registry.register(Registries.ITEM, new Identifier(DeadSky.ID, "void_metal_shovel"), new ShovelItem(new VoidMetal.Tool(), 0, 0.0f, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
	public static final HoeItem VOID_METAL_HOE = Registry.register(Registries.ITEM, new Identifier(DeadSky.ID, "void_metal_hoe"), new HoeItem(new VoidMetal.Tool(), 0, 0.0f, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
	public static final ArmorItem VOID_METAL_HELMET = Registry.register(Registries.ITEM, new Identifier(DeadSky.ID, "void_metal_helmet"), new VoidMetal.ArmorEffect(ArmorItem.Type.HELMET, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
	public static final ArmorItem VOID_METAL_CHESTPLATE = Registry.register(Registries.ITEM, new Identifier(DeadSky.ID, "void_metal_chestplate"), new VoidMetal.ArmorEffect(ArmorItem.Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
	public static final ArmorItem VOID_METAL_LEGGINGS = Registry.register(Registries.ITEM, new Identifier(DeadSky.ID, "void_metal_leggings"), new VoidMetal.ArmorEffect(ArmorItem.Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
	public static final ArmorItem VOID_METAL_BOOTS = Registry.register(Registries.ITEM, new Identifier(DeadSky.ID, "void_metal_boots"), new VoidMetal.ArmorEffect(ArmorItem.Type.BOOTS, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
}
