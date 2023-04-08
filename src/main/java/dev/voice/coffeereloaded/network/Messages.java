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
    private static final SimpleChannel instance = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(CoffeeReloaded.MODID, "messages")).networkProtocolVersion(() -> "1.0")
            .clientAcceptedVersions(s -> true).serverAcceptedVersions(s -> true).simpleChannel();

    private static int id = 0;

    public Messages() {
        // Used elsewhere
    }

    public static int getId() {
        return id++;
    }

    public static void register() {
        buildMessages();
    }
    
    private static void buildMessages() {
        instance.messageBuilder(PopupRequestC2S.class, getId(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(PopupRequestC2S::new)
                .encoder(PopupRequestC2S::toBytes)
                .consumerMainThread(PopupRequestC2S::handle)
                .add();
        
        instance.messageBuilder(CreativeModePopupS2C.class, getId(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(CreativeModePopupS2C::new)
                .encoder(CreativeModePopupS2C::toBytes)
                .consumerMainThread(CreativeModePopupS2C::handle)
                .add();
    }

    public static <Message> void sendToServer(Message message) {
        instance.sendToServer(message);
    }

    public static <Message> void sendToClient(Message message, ServerPlayer player) {
        instance.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}