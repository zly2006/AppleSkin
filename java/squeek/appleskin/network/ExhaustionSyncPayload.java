package squeek.appleskin.network;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;

public class ExhaustionSyncPayload implements CustomPayload {
    public static final PacketCodec<PacketByteBuf, ExhaustionSyncPayload> CODEC = CustomPayload.codecOf(ExhaustionSyncPayload::write, ExhaustionSyncPayload::new);
    public static final CustomPayload.Id<ExhaustionSyncPayload> ID = CustomPayload.id("appleskin:exhaustion_sync");

    float exhaustion;

    public ExhaustionSyncPayload(float exhaustion) {
        this.exhaustion = exhaustion;
    }

    public ExhaustionSyncPayload(PacketByteBuf buf) {
        this.exhaustion = buf.readFloat();
    }

    public void write(PacketByteBuf buf) {
        buf.writeFloat(exhaustion);
    }

    public float getExhaustion() {
        return exhaustion;
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }

}
