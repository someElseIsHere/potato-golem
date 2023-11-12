package org.theplaceholder.potatogolem.fabric;

import net.fabricmc.api.ClientModInitializer;
import org.theplaceholder.potatogolem.client.PotatoGolemClient;

public class PotatoGolemFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PotatoGolemClient.init();
    }
}
