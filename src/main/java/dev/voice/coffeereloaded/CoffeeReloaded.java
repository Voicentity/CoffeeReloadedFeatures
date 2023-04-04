package dev.voice.coffeereloaded;

import com.mojang.logging.LogUtils;

import com.mojang.realmsclient.gui.ErrorCallback;
import dev.voice.coffeereloaded.network.Messages;

import net.minecraftforge.api.distmarker.Dist;

import net.minecraftforge.common.MinecraftForge;

import net.minecraftforge.event.CreativeModeTabEvent;

import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.jetbrains.annotations.NotNull;

import org.slf4j.Logger;

@Mod(CoffeeReloaded.MODID)
public class CoffeeReloaded {
    public static final String MODID = "coffeereloaded";

    public static final Logger LOGGER = LogUtils.getLogger();

    public CoffeeReloaded() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        bus.addListener(this::addCreative);
    }

    private void commonSetup(@NotNull final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

        });

        Messages.register();
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
