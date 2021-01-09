package net.bitheral.bcm;

import net.bitheral.bcm.client.ClientReference;
import net.bitheral.bcm.common.init.ModBlocks;
import net.bitheral.bcm.common.init.ModItems;
import net.bitheral.bcm.server.dedicated.DedicatedServerReference;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("bcm")
public class BCMod
{
    public static final ISidedReference SIDED_SYSTEM = DistExecutor.safeRunForDist(() -> ClientReference::new, () -> DedicatedServerReference::new);

    public BCMod() {
        final IEventBus mod = FMLJavaModLoadingContext.get().getModEventBus(),
                forge = MinecraftForge.EVENT_BUS;

        addRegistries(mod);
        SIDED_SYSTEM.setup(mod, forge);
        mod.addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {}
    private void addRegistries(final IEventBus mod) {
        ModItems.ITEMS.register(mod);
        ModBlocks.BLOCKS.register(mod);
    }
}
