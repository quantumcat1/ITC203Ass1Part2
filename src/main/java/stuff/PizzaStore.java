package stuff;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped
public class PizzaStore implements Serializable
{
	private static final long serialVersionUID = 4345260379751761401L;
	private Pizza currentPizza;
	private Map<Integer, Pizza> pizzas;
	private ToppingFactory toppingFactory;
	private PizzaFactory pizzaFactory;
	private int selectedBase;
	private int selectedSauce;
	private int selectedCheese;

	//public PizzaStore()
	@PostConstruct
	public void initialise()
	{
		pizzas = new LinkedHashMap<Integer, Pizza>();
		toppingFactory = new ToppingFactory();
		pizzaFactory = new PizzaFactory();
		selectedBase = 0;
		selectedSauce = 0;
		selectedCheese = 0;
		currentPizza = pizzaFactory.createPizza(selectedBase, selectedSauce, selectedCheese);
	}

	public List<ItemVO> getToppings()
	//public Map<Integer, ItemVO> getToppings()
	{
		return toppingFactory.getToppings();
	}
	public Map<Integer, Pizza> getPizzas()
	{
		return pizzas;
	}
	public int getSelectedBase()
	{
		return selectedBase;
	}
	public void setSelectedBase(int selectedBase)
	{
		this.selectedBase = selectedBase;
	}
	public int getSelectedSauce()
	{
		return selectedSauce;
	}
	public void setSelectedSauce(int selectedSauce)
	{
		this.selectedSauce = selectedSauce;
	}
	public int getSelectedCheese()
	{
		return selectedCheese;
	}
	public void setSelectedCheese(int selectedCheese)
	{
		this.selectedCheese = selectedCheese;
	}

	public void addTopping(int toppingId)
	{
		currentPizza = toppingFactory.addTopping(currentPizza, toppingId);
	}
	public void newPizza()
	{
		selectedBase = 0;
		selectedCheese = 0;
		selectedSauce = 0;
		currentPizza = pizzaFactory.createPizza(selectedBase, selectedSauce, selectedCheese);
	}
	public void addCurrentPizza()
	{
		pizzas.put(currentPizza.getId(), currentPizza);
		currentPizza = null;
	}
	public String getCurrentPizzaString()
	{
		if(currentPizza != null)
		{
			return currentPizza.getDescription()
					+ "<p>Cost: "
					+ ItemVO.getDisplayCost(currentPizza.getCost());
		}
		return "Click 'New Pizza' to start a new pizza";
	}
	public String getReceiptString()
	{
		if(pizzas.size() == 0)
		{
			return "";
		}
		String str = "-----RECEIPT-----";
		int i = 1;
		int totalCost = 0;
		for (Map.Entry<Integer, Pizza> entry : pizzas.entrySet())
		{
			Pizza p = entry.getValue();
			totalCost += p.getCost();
			str += "<h4>Pizza " + i + ": " + ItemVO.getDisplayCost(p.getCost()) + "</h4>";
			str += p.getReceiptString();
			i++;
		}
		str += "<p/><u><i>Total: " + ItemVO.getDisplayCost(totalCost) + "</u></i>";
		return str;
	}
	public Map<Integer, ItemVO> getBases()
	{
		return pizzaFactory.getBases();
	}
	public Map<Integer, ItemVO> getSauces()
	{
		return pizzaFactory.getSauces();
	}
	public Map<Integer, ItemVO> getCheeses()
	{
		return pizzaFactory.getCheeses();
	}
	public void baseChanged(ValueChangeEvent e)
	{
		selectedBase = (Integer) e.getNewValue();
		pizzaFactory.setBase(currentPizza, selectedBase);
	}
	public void sauceChanged(ValueChangeEvent e)
	{
		selectedSauce = (Integer) e.getNewValue();
		pizzaFactory.setSauce(currentPizza, selectedSauce);
	}
	public void cheeseChanged(ValueChangeEvent e)
	{
		selectedCheese = (Integer) e.getNewValue();
		pizzaFactory.setCheese(currentPizza, selectedCheese);
	}
}
