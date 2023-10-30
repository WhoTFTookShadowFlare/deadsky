package me.shadowflare.deadsky.items;

import java.util.List;
import java.util.UUID;

import com.github.crimsondawn45.fabricshieldlib.lib.event.ShieldBlockCallback;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import me.shadowflare.deadsky.effects.DeadSkyEffects;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
public abstract class VoidMetal {
	public static class Block extends BlockItem {
		public Block(net.minecraft.block.Block block, Settings settings) {
			super(block, settings);
		}
		
		public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
			tooltip.add(Text.translatable("item.deadsky.void_metal_block.description"));
	    }
	}
	
	public static class Ingot extends Item {
		public Ingot(Settings settings) {
			super(settings);
		}
		
		public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
			tooltip.add(Text.translatable("item.deadsky.void_metal_ingot.description"));
	    }
	}
	
	public static class Nugget extends Item {
		public Nugget(Settings settings) {
			super(settings);
		}
		
		public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
			tooltip.add(Text.translatable("item.deadsky.void_metal_nugget.description"));
	    }
	}

	public static class RawBlock extends BlockItem {
		public RawBlock(net.minecraft.block.Block block, Settings settings) {
			super(block, settings);
		}

		public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
			tooltip.add(Text.translatable("item.deadsky.raw_void_metal_block.description"));
		}
	}

	public static class Raw extends Item {
		public Raw(Settings settings) {
			super(settings);
		}

		public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
			tooltip.add(Text.translatable("item.deadsky.raw_void_metal.description"));
		}
	}

	public static class UpgradeTemplate extends SmithingTemplateItem {

		public UpgradeTemplate() {
			super(
					Text.translatable("deadsky.void_metal_upgrade_template.apply_to").formatted(Formatting.BLUE),
					Text.translatable("deadsky.void_metal_upgrade_template.ingredients").formatted(Formatting.BLUE),
					Text.translatable("deadsky.void_metal_upgrade_template.title").formatted(Formatting.GRAY),
					Text.empty(), Text.empty(), List.of(), List.of()
			);
		}
	}

	public static class Sword extends SwordItem {
		public Sword(Settings settings) {
			super(new Tool(), 6, 1.6f, settings);
		}

		public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
			StatusEffectInstance effect = new StatusEffectInstance(DeadSkyEffects.FROSTBURN, 20, 1);
			target.addStatusEffect(effect);
			return super.postHit(stack, target, attacker);
		}

		@Override
		public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
			tooltip.add(Text.translatable("item.deadsky.void_metal_sword.hit_effect").formatted(Formatting.GREEN));
		}
	}

	public static class Shield extends FabricShieldItem {
		public Shield(Settings settings) {
			super(settings, 200, 15, DeadSkyItems.VOID_METAL_INGOT);

			ShieldBlockCallback.EVENT.register(this::onBlock);
		}

		@Override
		public void appendShieldTooltip(ItemStack stack, List<Text> tooltip, TooltipContext context) {
			tooltip.add(Text.translatable("item.deadsky.void_metal_shield.description").formatted(Formatting.GREEN));
		}

		public ActionResult onBlock(LivingEntity def, DamageSource src, float amount, Hand hand, ItemStack shield) {

			if (this == shield.getItem()) {
				if (src.getAttacker() instanceof LivingEntity) {
					LivingEntity attacker = (LivingEntity) src.getAttacker();
					StatusEffectInstance inst = new StatusEffectInstance(DeadSkyEffects.FROSTBURN, 30, 1);
					attacker.addStatusEffect(inst);
				}
			}

			return ActionResult.PASS;
		}
	}

	public static class ArmorEffect extends ArmorItem {

		private final ImmutableMultimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

		public ArmorEffect(Type type, Settings settings) {
			super(new Armor(), type, settings);

			ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
			builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(UUID.randomUUID(), "armor", getProtection(), EntityAttributeModifier.Operation.ADDITION));
			builder.put(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(UUID.randomUUID(), "armor_toughness", getToughness(), EntityAttributeModifier.Operation.ADDITION));
			builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(UUID.randomUUID(), "kb_resist", getMaterial().getKnockbackResistance(), EntityAttributeModifier.Operation.ADDITION));
			builder.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(UUID.randomUUID(), "health", 10, EntityAttributeModifier.Operation.ADDITION));
			builder.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(UUID.randomUUID(), "speed", -0.125, EntityAttributeModifier.Operation.MULTIPLY_BASE));
			
			attributeModifiers = builder.build();
		}

		public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
			return slot == this.type.getEquipmentSlot() ? this.attributeModifiers : super.getAttributeModifiers(slot);
		}
	}

	public static class Tool implements ToolMaterial {

		@Override
		public int getDurability() {
			return 4096;
		}

		@Override
		public float getMiningSpeedMultiplier() {
			return 10;
		}

		@Override
		public float getAttackDamage() {
			return 4.0f;
		}

		@Override
		public int getMiningLevel() {
			return 5;
		}

		@Override
		public int getEnchantability() {
			return 17;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.ofItems(DeadSkyItems.VOID_METAL_INGOT);
		}
	}

	public static class Armor implements ArmorMaterial {
		private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};

		@Override
		public int getDurability(ArmorItem.Type type) {
			return BASE_DURABILITY[type.getEquipmentSlot().getEntitySlotId()] * 375;
		}

		@Override
		public int getProtection(ArmorItem.Type type) {
			return ArmorMaterials.DIAMOND.getProtection(type);
		}

		@Override
		public int getEnchantability() {
			return 17;
		}

		@Override
		public SoundEvent getEquipSound() {
			return ArmorMaterials.IRON.getEquipSound();
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.ofItems(DeadSkyItems.VOID_METAL_INGOT);
		}

		@Override
		public String getName() {
			return "void_metal";
		}

		@Override
		public float getToughness() {
			return ArmorMaterials.DIAMOND.getToughness();
		}

		@Override
		public float getKnockbackResistance() {
			return ArmorMaterials.NETHERITE.getKnockbackResistance();
		}
	}
}
