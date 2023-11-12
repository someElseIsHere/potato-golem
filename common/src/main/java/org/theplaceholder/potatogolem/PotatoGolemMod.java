package org.theplaceholder.potatogolem;

import com.google.common.base.Suppliers;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class PotatoGolemMod {
	public static final String MOD_ID = "potato_golem";
	public static final Supplier<RegistrarManager> MANAGER = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));
	public static final Registrar<EntityType<?>> ENTITIES = MANAGER.get().get(Registries.ENTITY_TYPE);
	public static final RegistrySupplier<EntityType<PotatoGolemEntity>> POTATO_GOLEM = ENTITIES.register(new ResourceLocation(MOD_ID, MOD_ID), () -> EntityType.Builder.of(PotatoGolemEntity::new, MobCategory.MISC).sized(2.5F, 5.75F).clientTrackingRange(10).build("potato_golem"));

	public static void init() {
		EntityAttributeRegistry.register(POTATO_GOLEM, PotatoGolemEntity::createAttributes);
		PotatoGolemSounds.init();
	}
}
