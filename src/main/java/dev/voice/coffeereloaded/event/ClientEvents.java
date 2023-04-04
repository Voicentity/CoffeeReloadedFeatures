package dev.voice.coffeereloaded.event;

import dev.voice.coffeereloaded.CoffeeReloaded;
import dev.voice.coffeereloaded.network.Messages;
import dev.voice.coffeereloaded.network.packet.PopupRequestC2S;
import dev.voice.coffeereloaded.util.KeyBinds;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = CoffeeReloaded.MODID, value = Dist.CLIENT)
    public static class ClientForgeEvent {
        @SubscribeEvent
        public static void onKeyRegister(@NotNull RegisterKeyMappingsEvent event) {
            event.register(KeyBinds.OPEN_TAB_KEY);
        }

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (KeyBinds.OPEN_TAB_KEY.consumeClick()) {
                assert Minecraft.getInstance().player != null;

                Minecraft.getInstance().player.sendSystemMessage(Component.literal("pressed the b key"));

                Messages.sendToServer(new PopupRequestC2S());
            }
        }
    }
}