package stuff;

public class Topping extends Pizza
{
	private Pizza pizza;
	private ItemVO topping;

	public Topping(Pizza pizza, ItemVO topping)
	{
		this.pizza = pizza;
		this.topping = topping;
	}
	public int getCost()
	{
		return pizza.getCost() + topping.getCost();
	}
	public int getId()
	{
		return pizza.getId();
		/*go back to previous and get id - if the previous
		 * is a topping then it will get its previous etc
		 * until it gets back to the original pizza
		 */
	}
	public String getDescription()
	{
		String str = ", ";
		if(!(pizza instanceof Topping)) //if this is the first topping
		{
			str = " <p>Toppings: ";
		}
		return pizza.getDescription() + str + topping.getDescription();
	}
	public String getReceiptString()
	{
		String str = "<br>";
		if(!(pizza instanceof Topping)) //if this is the first topping
		{
			str = "<p/><u>Toppings</u><br/>";
		}
		return pizza.getReceiptString() + str + topping.toString();
	}
}
