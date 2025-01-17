package org.theplaceholder.potatogolem.entity.goal;

import java.util.EnumSet;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import org.theplaceholder.potatogolem.entity.PotatoGolemEntity;

public class PotatoOwnerHurtByTargetGoal extends TargetGoal {
    private final PotatoGolemEntity tameAnimal;
    private LivingEntity ownerLastHurtBy;
    private int timestamp;

    public PotatoOwnerHurtByTargetGoal(PotatoGolemEntity entity) {
        super(entity, false);
        this.tameAnimal = entity;
        this.setFlags(EnumSet.of(Flag.TARGET));
    }

    public boolean canUse() {
        if (this.tameAnimal.isTamed()) {
            LivingEntity livingEntity = this.tameAnimal.getOwner();
            if (livingEntity == null) {
                return false;
            } else {
                this.ownerLastHurtBy = livingEntity.getLastHurtByMob();
                int i = livingEntity.getLastHurtByMobTimestamp();
                return i != this.timestamp && ownerLastHurtBy != null && ownerLastHurtBy.isAlive() && ownerLastHurtBy != tameAnimal;
            }
        } else {
            return false;
        }
    }

    public void start() {
        this.mob.setTarget(this.ownerLastHurtBy);
        LivingEntity livingEntity = this.tameAnimal.getOwner();
        if (livingEntity != null) {
            this.timestamp = livingEntity.getLastHurtByMobTimestamp();
        }

        super.start();
    }
}
