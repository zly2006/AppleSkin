package squeek.appleskin.api.event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;

/**
 * Can be used to customize the displayed hunger/saturation values of foods.
 * Called whenever the food values of items are being determined.
 */
public class FoodValuesEvent extends Event
{
	public FoodValuesEvent(Player player, ItemStack itemStack, FoodProperties defaultFoodProperties, FoodProperties modifiedFoodProperties)
	{
		this.player = player;
		this.itemStack = itemStack;
		this.defaultFoodProperties = defaultFoodProperties;
		this.modifiedFoodProperties = modifiedFoodProperties;
	}

	public FoodProperties defaultFoodProperties;
	public FoodProperties modifiedFoodProperties;
	public final ItemStack itemStack;
	public final Player player;
}
