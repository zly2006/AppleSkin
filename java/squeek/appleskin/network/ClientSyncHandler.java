package squeek.appleskin.network;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class ClientSyncHandler
{
	@Environment(EnvType.CLIENT)
	public static void init()
	{
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
