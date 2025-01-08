package org.theplaceholder.potatogolem.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import org.theplaceholder.potatogolem.client.PotatoGolemModClient;
import org.theplaceholder.potatogolem.PotatoGolemMod;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PotatoGolemMod.MOD_ID)
public class PotatoGolemModForge {
    public PotatoGolemModForge() {
        EventBuses.registerModEventBus(PotatoGolemMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        PotatoGolemMod.init();
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> PotatoGolemModClient::init);
    }
}