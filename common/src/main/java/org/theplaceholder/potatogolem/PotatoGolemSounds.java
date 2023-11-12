package org.theplaceholder.potatogolem;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import static org.theplaceholder.potatogolem.PotatoGolemMod.MANAGER;
import static org.theplaceholder.potatogolem.PotatoGolemMod.MOD_ID;

public class PotatoGolemSounds {
    public static final Registrar<SoundEvent> SOUNDS = MANAGER.get().get(Registries.SOUND_EVENT);
    public static final RegistrySupplier<SoundEvent> STEP = SOUNDS.register(new ResourceLocation(MOD_ID, "step"), () -> SoundEvent.createVariableRangeEvent( new ResourceLocation(MOD_ID, "step")));
    public static final RegistrySupplier<SoundEvent> DAMAGE = SOUNDS.register(new ResourceLocation(MOD_ID, "damage"), () -> SoundEvent.createVariableRangeEvent( new ResourceLocation(MOD_ID, "damage")));
    public static final RegistrySupplier<SoundEvent> ATTACK = SOUNDS.register(new ResourceLocation(MOD_ID, "attack"), () -> SoundEvent.createVariableRangeEvent( new ResourceLocation(MOD_ID, "attack")));
    public static final RegistrySupplier<SoundEvent> REPAIR = SOUNDS.register(new ResourceLocation(MOD_ID, "repair"), () -> SoundEvent.createVariableRangeEvent( new ResourceLocation(MOD_ID, "repair")));
    public static final RegistrySupplier<SoundEvent> DEATH = SOUNDS.register(new ResourceLocation(MOD_ID, "death"), () -> SoundEvent.createVariableRangeEvent( new ResourceLocation(MOD_ID, "death")));
    public static final RegistrySupplier<SoundEvent> HURT = SOUNDS.register(new ResourceLocation(MOD_ID, "hurt"), () -> SoundEvent.createVariableRangeEvent( new ResourceLocation(MOD_ID, "hurt")));
    public static void init(){}
}
