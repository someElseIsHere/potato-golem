package org.theplaceholder.potatogolem.mixin;

import net.minecraft.world.entity.animal.IronGolem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(IronGolem.class)
public interface IronGolemAccessor {
    @Invoker("getAttackDamage")
    float invokeGetAttackDamage();

    @Accessor("attackAnimationTick")
    void setAttackAnimationTick(int ticks);
}
