package dev.voice.coffeereloaded.network.packet;

import dev.voice.coffeereloaded.CoffeeReloaded;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class PopupRequestC2S {
    public PopupRequestC2S() {
    
    }
    
    public PopupRequestC2S(FriendlyByteBuf buf) {
    
    }
    
    public void toBytes(FriendlyByteBuf buf) {
    
    }
    
    public boolean handle(@NotNull Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        
        assert context!= null;
        
        context.enqueueWork(() -> {
            
            ServerPlayer player = context.getSender();
            
            if (player == null) {
                CoffeeReloaded.LOGGER.error("Player is null");
            }
        });
        
        return true;
    }
}