package net.bitheral.bcm.client;

import net.bitheral.bcm.ISidedReference;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientReference implements ISidedReference {

    @Override
    public void setup(final IEventBus mod, final IEventBus forge) {
        mod.addListener(this::clientSetup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {}
}
