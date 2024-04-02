package squeek.appleskin.network;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;

public class SaturationSyncPayload implements CustomPayload {
    public static final PacketCodec<PacketByteBuf, SaturationSyncPayload> CODEC = CustomPayload.codecOf(SaturationSyncPayload::write, SaturationSyncPayload::new);
    public static final CustomPayload.Id<SaturationSyncPayload> ID = CustomPayload.id("appleskin:saturation_sync");

    float saturation;

    public SaturationSyncPayload(float saturation) {
        this.saturation = saturation;
    }

    public SaturationSyncPayload(PacketByteBuf buf) {
        this.saturation = buf.readFloat();
    }

    public void write(PacketByteBuf buf) {
        buf.writeFloat(saturation);
    }

    public float getSaturation() {
        return saturation;
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }

}
