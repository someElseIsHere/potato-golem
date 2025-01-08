package org.theplaceholder.potatogolem.client;

import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import org.theplaceholder.potatogolem.PotatoGolemMod;
import org.theplaceholder.potatogolem.client.entity.PotatoGolemModel;
import org.theplaceholder.potatogolem.client.entity.PotatoGolemRenderer;

public class PotatoGolemModClient {

    public static void init() {
        EntityRendererRegistry.register(PotatoGolemMod.POTATO_GOLEM, PotatoGolemRenderer::new);
        EntityModelLayerRegistry.register(PotatoGolemModel.LAYER_LOCATION, PotatoGolemModel::createBodyLayer);
        EntityRendererRegistry.register(PotatoGolemMod.SPAWN_MIXTURE_ENTITY, ThrownItemRenderer::new);
    }
}
