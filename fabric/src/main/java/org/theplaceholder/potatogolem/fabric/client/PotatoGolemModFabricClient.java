package org.theplaceholder.potatogolem.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import org.theplaceholder.potatogolem.client.PotatoGolemModClient;

public class PotatoGolemModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PotatoGolemModClient.init();
    }
}
