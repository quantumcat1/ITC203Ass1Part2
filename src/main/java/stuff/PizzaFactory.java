package stuff;

import java.util.LinkedHashMap;
import java.util.Map;

public class PizzaFactory
{
	Map<Integer, ItemVO> bases;
	Map<Integer, ItemVO> sauces;
	Map<Integer, ItemVO> cheeses;

	public PizzaFactory()
	{
		bases = new LinkedHashMap<Integer, ItemVO>();
		sauces = new LinkedHashMap<Integer, ItemVO>();
		cheeses = new LinkedHashMap<Integer, ItemVO>();
		//populate the maps
		bases.put(0, new ItemVO(200, "Thin and Crispy"));
		bases.put(1, new ItemVO(250, "Regular"));
		bases.put(2, new ItemVO(250, "Deep Pan"));
		bases.put(3, new ItemVO(400, "Cheese Filled"));
		sauces.put(0,  new ItemVO(100, "Tomato"));
		sauces.put(1,  new ItemVO(150, "Barbeque"));
		sauces.put(2,  new ItemVO(200, "Marinara"));
		cheeses.put(0,  new ItemVO(100, "Mozzarella"));
		cheeses.put(1,  new ItemVO(200, "Buffalo"));
		cheeses.put(2,  new ItemVO(250, "Goat"));
		cheeses.put(3,  new ItemVO(100, "Cheddar"));
	}

	public Pizza createPizza(int baseId, int sauceId, int cheeseId)
	{
		ItemVO base = bases.get(baseId);
		ItemVO sauce = sauces.get(sauceId);
		ItemVO cheese = cheeses.get(cheeseId);
		return new Pizza(base, sauce, cheese);
	}
	public Map<Integer, ItemVO> getBases()
	{
		return bases;
	}
	public Map<Integer, ItemVO> getSauces()
	{
		return sauces;
	}
	public Map<Integer, ItemVO> getCheeses()
	{
		return cheeses;
	}
	public void setSauce(Pizza pizza, int sauce)
	{
		ItemVO sauceItem = sauces.get(sauce);
		pizza.setSauce(sauceItem);
	}
	public void setCheese(Pizza pizza, int cheese)
	{
		ItemVO cheeseItem = cheeses.get(cheese);
		pizza.setCheese(cheeseItem);
	}
	public void setBase(Pizza pizza, int base)
	{
		ItemVO baseItem = bases.get(base);
		pizza.setBase(baseItem);
	}
}
