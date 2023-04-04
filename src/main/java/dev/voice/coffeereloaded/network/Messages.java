package dev.voice.coffeereloaded.network;

import dev.voice.coffeereloaded.CoffeeReloaded;
import dev.voice.coffeereloaded.network.packet.CreativeModePopupS2C;
import dev.voice.coffeereloaded.network.packet.PopupRequestC2S;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class Messages {
    private static SimpleChannel INSTANCE;

    private static int id = 0;

    public Messages() {

    }

    public static int getId() {
        return id++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(CoffeeReloaded.MODID, "messages")).networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true).serverAcceptedVersions(s -> true).simpleChannel();

        INSTANCE = net;

        net.messageBuilder(PopupRequestC2S.class, getId(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(PopupRequestC2S::new)
                .encoder(PopupRequestC2S::toBytes)
                .consumerMainThread(PopupRequestC2S::handle)
                .add();
        
        net.messageBuilder(CreativeModePopupS2C.class, getId(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(CreativeModePopupS2C::new)
                .encoder(CreativeModePopupS2C::toBytes)
                .consumerMainThread(CreativeModePopupS2C::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToClient(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}