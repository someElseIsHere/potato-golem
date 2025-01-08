package org.theplaceholder.potatogolem.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;
import org.theplaceholder.potatogolem.PotatoGolemMod;

public class ThrownSpawnMixtureEntity extends ThrowableItemProjectile {

    public ThrownSpawnMixtureEntity(EntityType<ThrownSpawnMixtureEntity> entityType, Level level) {
        super(entityType, level);
    }

    public ThrownSpawnMixtureEntity(Level level, LivingEntity livingEntity) {
        super(PotatoGolemMod.SPAWN_MIXTURE_ENTITY.get(), livingEntity, level);
    }


    @NotNull
    protected Item getDefaultItem() {
        return PotatoGolemMod.SPAWN_MIXTURE_ITEM.get();
    }

    protected float getGravity() {
        return 0.07F;
    }

    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if (this.level() instanceof ServerLevel) {
            this.level().levelEvent(2002, this.blockPosition(), 0xffd45e);

            PotatoGolemEntity potatoGolemEntity = new PotatoGolemEntity(PotatoGolemMod.POTATO_GOLEM.get(), this.level());
            potatoGolemEntity.setPos(this.getX(), this.getY(), this.getZ());
            this.level().addFreshEntity(potatoGolemEntity);
            this.discard();
        }
    }
}
