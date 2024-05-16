package squeek.appleskin.mixin;

import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import squeek.appleskin.client.TooltipOverlayHandler;

import java.util.List;

@Mixin(ItemStack.class)
public class ItemStackMixin
{
	@Inject(at = @At("RETURN"), method = "getTooltip")
	private void getTooltipFromItem(Item.TooltipContext context, PlayerEntity player, TooltipType type, CallbackInfoReturnable<List> info)
	{
		if (TooltipOverlayHandler.INSTANCE != null)
			TooltipOverlayHandler.INSTANCE.onItemTooltip((ItemStack) (Object) this, player, context, type, info.getReturnValue());
	}
}
