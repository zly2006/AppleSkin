package squeek.appleskin.network;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public class ClientSyncHandler
{
	@Environment(EnvType.CLIENT)
	public static void init()
	{
		PayloadTypeRegistry.playS2C().register(ExhaustionSyncPayload.ID, ExhaustionSyncPayload.CODEC);
		PayloadTypeRegistry.playS2C().register(SaturationSyncPayload.ID, SaturationSyncPayload.CODEC);

		ClientPlayNetworking.registerGlobalReceiver(ExhaustionSyncPayload.ID, (payload, context) -> {
			context.client().execute(() -> {
				context.client().player.getHungerManager().setExhaustion(payload.getExhaustion());
			});
		});
		ClientPlayNetworking.registerGlobalReceiver(SaturationSyncPayload.ID, (payload, context) -> {
			context.client().execute(() -> {
				context.client().player.getHungerManager().setSaturationLevel(payload.getSaturation());
			});
		});
	}
}
