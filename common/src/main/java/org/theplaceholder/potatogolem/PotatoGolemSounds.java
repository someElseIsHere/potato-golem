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
    public static final RegistrySupplier<SoundEvent> STEP = register("step");
    public static final RegistrySupplier<SoundEvent> DAMAGE = register("damage");
    public static final RegistrySupplier<SoundEvent> ATTACK = register("attack");
    public static final RegistrySupplier<SoundEvent> REPAIR = register("repair");
    public static final RegistrySupplier<SoundEvent> DEATH = register("death");
    public static final RegistrySupplier<SoundEvent> HURT = register("hurt");
    
    public static RegistrySupplier<SoundEvent> register(String id){
        ResourceLocation location = new ResourceLocation(MOD_ID, id);
        return SOUNDS.register(location, () -> SoundEvent.createVariableRangeEvent(location));
    }

    public static void init(){}
}
