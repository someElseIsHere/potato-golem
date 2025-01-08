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
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import org.theplaceholder.potatogolem.entity.PotatoGolemEntity;
import org.theplaceholder.potatogolem.entity.ThrownSpawnMixtureEntity;
import org.theplaceholder.potatogolem.item.PotatoGolemSpawnMixtureItem;

import java.util.function.Supplier;

public class PotatoGolemMod {
	public static final String MOD_ID = "potato_golem";
	public static final ResourceLocation LOCATION = new ResourceLocation(MOD_ID, MOD_ID);
	public static final Supplier<RegistrarManager> MANAGER = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));
	
	public static final Registrar<EntityType<?>> ENTITIES = MANAGER.get().get(Registries.ENTITY_TYPE);
	public static final RegistrySupplier<EntityType<PotatoGolemEntity>> POTATO_GOLEM = ENTITIES.register(LOCATION, () -> EntityType.Builder.of(PotatoGolemEntity::new, MobCategory.MISC).sized(2.5F, 5.75F).clientTrackingRange(10).build(MOD_ID));
	public static final RegistrySupplier<EntityType<ThrownSpawnMixtureEntity>> SPAWN_MIXTURE_ENTITY = ENTITIES.register(new ResourceLocation(MOD_ID, "spawn_mixture"), () -> EntityType.Builder.<ThrownSpawnMixtureEntity>of(ThrownSpawnMixtureEntity::new, MobCategory.AMBIENT).sized(1/16f, 1/16f).clientTrackingRange(10).build("spawn_mixture"));

	public static final Registrar<Item> ITEMS = MANAGER.get().get(Registries.ITEM);
	public static final RegistrySupplier<Item> SPAWN_MIXTURE_ITEM = ITEMS.register(new ResourceLocation(MOD_ID, "spawn_mixture"), () -> new PotatoGolemSpawnMixtureItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).arch$tab(CreativeModeTabs.TOOLS_AND_UTILITIES)));

	public static void init() {
		EntityAttributeRegistry.register(POTATO_GOLEM, PotatoGolemEntity::createAttributes);
		PotatoGolemSounds.init();
	}
}
