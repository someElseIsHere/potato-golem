package org.theplaceholder.potatogolem.fabric;

import org.theplaceholder.potatogolem.PotatoGolemMod;
import net.fabricmc.api.ModInitializer;

public class PotatoGolemModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        PotatoGolemMod.init();
    }
}