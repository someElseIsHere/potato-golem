package org.theplaceholder.potatogolem;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.theplaceholder.potatogolem.goal.PotatoOwnerHurtByTargetGoal;
import org.theplaceholder.potatogolem.goal.PotatoOwnerHurtTargetGoal;

import java.util.Optional;
import java.util.UUID;

public class PotatoGolemEntity extends IronGolem implements OwnableEntity {
    protected static final EntityDataAccessor<Optional<UUID>> DATA_OWNERUUID_ID = SynchedEntityData.defineId(PotatoGolemEntity.class, EntityDataSerializers.OPTIONAL_UUID);;

    public PotatoGolemEntity(EntityType<PotatoGolemEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void playStepSound(BlockPos blockPos, BlockState blockState) {
        this.playSound(PotatoGolemSounds.STEP.get(), 1.0F, 1.0F);
    }

    @Override
    public boolean hurt(DamageSource damageSource, float f) {
        Crackiness crackiness = this.getCrackiness();
        boolean bl = super.hurt(damageSource, f);
        if (bl && this.getCrackiness() != crackiness) {
            this.playSound(PotatoGolemSounds.DAMAGE.get(), 1.0F, 1.0F);
        }
        return bl;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_OWNERUUID_ID, Optional.empty());
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        this.attackAnimationTick = 17;
        this.level().broadcastEntityEvent(this, (byte)4);
        float f = this.getAttackDamage();
        float g = (int)f > 0 ? f / 2.0F + (float)this.random.nextInt((int)f) : f;
        boolean bl = entity.hurt(this.damageSources().mobAttack(this), g);
        if (bl) {
            double d;
            if (entity instanceof LivingEntity livingEntity) {
                d = livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
            } else {
                d = 0.0;
            }
            double e = Math.max(0.0, 1.0 - d);
            entity.setDeltaMovement(entity.getDeltaMovement().add(0.0, 0.4000000059604645 * e, 0.0));
            this.doEnchantDamageEffects(this, entity);
        }

        this.playSound(PotatoGolemSounds.ATTACK.get(), 1.0F, 1.0F);
        return bl;
    }

    @Override
    protected @NotNull InteractionResult mobInteract(Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);

        if (itemStack.is(Items.DIRT) && !isTamed()) {
            setOwnerUUID(player.getUUID());
            if(!player.isCreative())
                itemStack.shrink(1);
            spawnTamingParticles();
        }

        if (!itemStack.is(Items.POTATO)) {
            return InteractionResult.PASS;
        } else {
            float f = this.getHealth();
            this.heal(25.0F);
            if (this.getHealth() == f) {
                return InteractionResult.PASS;
            } else {
                float g = 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F;
                this.playSound(PotatoGolemSounds.REPAIR.get(), 1.0F, g);
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }

                return InteractionResult.sidedSuccess(this.level().isClientSide);
            }
        }
    }

    @Override
    public void handleEntityEvent(byte b) {
        if (b == 4) {
            this.attackAnimationTick = 17;
            this.playSound(PotatoGolemSounds.ATTACK.get(), 1.0F, 1.0F);
        } else {
            super.handleEntityEvent(b);
        }
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9, 32.0F));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (livingEntity) -> livingEntity instanceof Enemy && !(livingEntity instanceof Creeper)));
        this.targetSelector.addGoal(5, new PotatoOwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(6, new PotatoOwnerHurtTargetGoal(this));
    }

    @Override
    protected SoundEvent getDeathSound() {
        return PotatoGolemSounds.DEATH.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return PotatoGolemSounds.HURT.get();
    }

    @Nullable
    @Override
    public UUID getOwnerUUID() {
        return this.entityData.get(DATA_OWNERUUID_ID).orElse(null);
    }

    public void setOwnerUUID(@Nullable UUID uUID) {
        this.entityData.set(DATA_OWNERUUID_ID, Optional.ofNullable(uUID));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        if (this.getOwnerUUID() != null) {
            compoundTag.putUUID("Owner", this.getOwnerUUID());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        UUID uUID;
        if (compoundTag.hasUUID("Owner")) {
            uUID = compoundTag.getUUID("Owner");
        } else {
            String string = compoundTag.getString("Owner");
            uUID = OldUsersConverter.convertMobOwnerIfNecessary(this.getServer(), string);
        }

        if (uUID != null) {
            try {
                this.setOwnerUUID(uUID);
            } catch (Throwable ignored) {}
        }
    }

    public boolean isOwnedBy(LivingEntity livingEntity) {
        return livingEntity == this.getOwner();
    }

    @Override
    public boolean canAttack(LivingEntity livingEntity) {
        return !this.isOwnedBy(livingEntity) && super.canAttack(livingEntity);
    }

    protected void spawnTamingParticles() {
        ParticleOptions particleOptions = ParticleTypes.HEART;

        for(int i = 0; i < 7; ++i) {
            double d = this.random.nextGaussian() * 0.02;
            double e = this.random.nextGaussian() * 0.02;
            double f = this.random.nextGaussian() * 0.02;
            this.level().addParticle(particleOptions, this.getRandomX(1.0), this.getRandomY() + 0.5, this.getRandomZ(1.0), d, e, f);
        }

    }

    public boolean isTamed() {
        return this.getOwnerUUID() != null;
    }
}
