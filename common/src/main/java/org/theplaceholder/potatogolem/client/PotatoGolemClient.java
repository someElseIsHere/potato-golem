package org.theplaceholder.potatogolem.client;

import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import org.theplaceholder.potatogolem.PotatoGolemMod;

public class PotatoGolemClient {
    public static void init() {
        EntityRendererRegistry.register(PotatoGolemMod.POTATO_GOLEM, PotatoGolemRenderer::new);
        EntityModelLayerRegistry.register(PotatoGolemModel.LAYER_LOCATION, PotatoGolemModel::createBodyLayer);
    }
}
