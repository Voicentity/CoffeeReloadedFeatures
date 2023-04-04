package dev.voice.coffeereloaded.network.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class CreativeModePopupS2C {
    public CreativeModePopupS2C() {

    }

    public CreativeModePopupS2C(FriendlyByteBuf buffer) {

    }

    public void toBytes(FriendlyByteBuf buffer) {

    }
    
    public boolean handle(@NotNull Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        
        assert context!= null;
        
        return true;
    }
}
