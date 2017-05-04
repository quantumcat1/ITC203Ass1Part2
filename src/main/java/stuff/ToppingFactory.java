package stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToppingFactory
{
	Map<Integer, ItemVO> toppings;

	public ToppingFactory()
	{
		toppings = new HashMap<Integer, ItemVO>();
		toppings.put(0, new ItemVO(100, "Salami"));
		toppings.put(1, new ItemVO(125, "Pepperoni"));
		toppings.put(2, new ItemVO(75, "Ham"));
		toppings.put(3, new ItemVO(100, "Bacon"));
		toppings.put(4, new ItemVO(80, "Chicken"));
		toppings.put(5, new ItemVO(120, "Ground Beef"));
		toppings.put(6, new ItemVO(200, "Prawns"));
		toppings.put(8, new ItemVO(50, "Dried Tomato"));
		toppings.put(9, new ItemVO(50, "Capsicum"));
		toppings.put(10, new ItemVO(75, "Olives"));
		toppings.put(11, new ItemVO(75, "Jalapenos"));
		toppings.put(12, new ItemVO(50, "Pineapple"));
		toppings.put(13, new ItemVO(50, "Onion"));
		toppings.put(14, new ItemVO(100, "Artichoke"));
		toppings.put(15, new ItemVO(150, "Anchovies"));
		toppings.put(16, new ItemVO(100, "Parmesan Cheese"));
		toppings.put(7, new ItemVO(75, "Baby Spinach"));
	}

	public List<ItemVO> getToppings()
	{
		return new ArrayList<ItemVO>(toppings.values());
	}

	public Pizza addTopping(Pizza pizza, int toppingId)
	{
		ItemVO item = toppings.get(toppingId);
		return new Topping(pizza, item);
	}
}
