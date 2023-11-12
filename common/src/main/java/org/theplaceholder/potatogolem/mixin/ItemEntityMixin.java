package org.theplaceholder.potatogolem.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.theplaceholder.potatogolem.PotatoGolemEntity;
import org.theplaceholder.potatogolem.PotatoGolemMod;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity implements TraceableEntity {
    public ItemEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "hurt", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/item/ItemEntity;discard()V"))
    public void onHurt(DamageSource damageSource, float f, CallbackInfoReturnable<Boolean> cir){
        if (damageSource != this.damageSources().lightningBolt())
            return;
        PotatoGolemEntity potatoGolemEntity = new PotatoGolemEntity(PotatoGolemMod.POTATO_GOLEM.get(), this.level());
        potatoGolemEntity.setPos(this.getX(), this.getY(), this.getZ());
        this.level().addFreshEntity(potatoGolemEntity);
    }
}
