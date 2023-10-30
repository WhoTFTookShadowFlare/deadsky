package me.shadowflare.deadsky.mixin.netherite_rework;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(ArmorItem.class)
public class NetheriteArmorDefense {

    @Shadow
    @Mutable
    private Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    //  public ArmorItem(ArmorMaterial material, ArmorItem.Type type, Item.Settings settings)
    @Inject(
            method = "<init>",
            at = @At(value = "TAIL")
    )
    public void changeNetherite(ArmorMaterial material, ArmorItem.Type type, Item.Settings settings, CallbackInfo cbi) {
        if(material == ArmorMaterials.NETHERITE) {
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();

            builder.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(
                    UUID.randomUUID(),
                    "health",
                    5.0,
                    EntityAttributeModifier.Operation.ADDITION
            ));

            builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(
                    UUID.randomUUID(),
                    "kb_resist",
                    ArmorMaterials.NETHERITE.getKnockbackResistance(),
                    EntityAttributeModifier.Operation.ADDITION
            ));

            builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(
                    UUID.randomUUID(),
                    "armor",
                    ArmorMaterials.DIAMOND.getProtection(type),
                    EntityAttributeModifier.Operation.ADDITION
            ));

            builder.put(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(
                    UUID.randomUUID(),
                    "armor_toughness",
                    ArmorMaterials.DIAMOND.getToughness(),
                    EntityAttributeModifier.Operation.ADDITION
            ));

            attributeModifiers = builder.build();
        }
    }
}
