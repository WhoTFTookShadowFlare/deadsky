package me.shadowflare.deadsky.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import me.shadowflare.deadsky.config.DeadSkyConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;

@Mixin(LivingEntity.class)
public class TotemCooldown {

	// boolean tryUseTotem(DamageSource source)
	@Inject(
				method = "tryUseTotem(Lnet/minecraft/entity/damage/DamageSource;)Z",
				cancellable = true,
				at = { @At("HEAD") })
	public void returnIfCooldownActive(DamageSource dmgSrc, CallbackInfoReturnable<Boolean> cbi) {
		if((Object) this instanceof PlayerEntity) {
			PlayerEntity ply = (PlayerEntity) (Object) this;
			if(ply.getItemCooldownManager().isCoolingDown(Items.TOTEM_OF_UNDYING)) {
				cbi.setReturnValue(false);
				cbi.cancel();
			}
		}
	}
	
	// boolean tryUseTotem(DamageSource source)
	@Inject(
			method = "tryUseTotem(Lnet/minecraft/entity/damage/DamageSource;)Z",
			at = { @At("TAIL") })
	public void setTotemCooldown(DamageSource dmgSrc, CallbackInfoReturnable<Boolean> cbi) {
		if(((Object) this) instanceof PlayerEntity) {
			PlayerEntity ply = (PlayerEntity) (Object) this;
			ply.getItemCooldownManager().set(
					Items.TOTEM_OF_UNDYING,
					DeadSkyConfig.VanillaRebalance.getTotemCooldown()
					);
		}
	}
	
}
