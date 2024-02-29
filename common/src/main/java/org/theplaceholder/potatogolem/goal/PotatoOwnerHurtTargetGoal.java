package org.theplaceholder.potatogolem.goal;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import org.theplaceholder.potatogolem.PotatoGolemEntity;

import java.util.EnumSet;

public class PotatoOwnerHurtTargetGoal extends TargetGoal {
    private final PotatoGolemEntity tameAnimal;
    private LivingEntity ownerLastHurt;
    private int timestamp;

    public PotatoOwnerHurtTargetGoal(PotatoGolemEntity tamableAnimal) {
        super(tamableAnimal, false);
        this.tameAnimal = tamableAnimal;
        this.setFlags(EnumSet.of(Flag.TARGET));
    }

    public boolean canUse() {
        if (this.tameAnimal.isTamed()) {
            LivingEntity livingEntity = this.tameAnimal.getOwner();
            if (livingEntity == null) {
                return false;
            } else {
                this.ownerLastHurt = livingEntity.getLastHurtMob();
                int i = livingEntity.getLastHurtMobTimestamp();
                return i != this.timestamp && ownerLastHurt != null && ownerLastHurt.isAlive() && ownerLastHurt != tameAnimal;
            }
        } else {
            return false;
        }
    }

    public void start() {
        this.mob.setTarget(this.ownerLastHurt);
        LivingEntity livingEntity = this.tameAnimal.getOwner();
        if (livingEntity != null) {
            this.timestamp = livingEntity.getLastHurtMobTimestamp();
        }

        super.start();
    }
}
