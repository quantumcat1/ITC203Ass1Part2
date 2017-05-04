package stuff;

public class Pizza
{
	static private int maxId = 0;
	private int id;
	private ItemVO base;
	private ItemVO sauce;
	private ItemVO cheese;

	public Pizza()
	{
		this.id = getNewId();
	}
	public Pizza(ItemVO base, ItemVO sauce, ItemVO cheese)
	{
		this.id = getNewId();
		this.base = base;
		this.sauce = sauce;
		this.cheese = cheese;
	}
	public int getCost()
	{
		return cheese.getCost() + sauce.getCost() + base.getCost();
	}

	public static int getNewId()
	{
		maxId ++;
		return maxId;
	}
	public int getId()
	{
		return id;
	}
	public String getDescription()
	{
		return base.getDescription() + " pizza with " + sauce.getDescription() + " sauce and " + cheese.getDescription() + " cheese.";
	}
	public String getReceiptString()
	{
		return "Base: " + base.toString()
		+ "<br>Sauce: " + sauce.toString()
		+ "<br>Cheese: " + cheese.toString();
	}
	public void setBase(ItemVO base)
	{
		this.base = base;
	}
	public void setSauce(ItemVO sauce)
	{
		this.sauce = sauce;
	}
	public void setCheese(ItemVO cheese)
	{
		this.cheese = cheese;
	}
}
