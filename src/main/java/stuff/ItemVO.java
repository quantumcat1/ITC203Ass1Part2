package stuff;

import java.text.NumberFormat;
import java.util.Locale;

public class ItemVO
{
	private int cost;
	private String description;

	public ItemVO(int cost, String description)
	{
		this.cost = cost;
		this.description = description;
	}

	public int getCost()
	{
		return cost;
	}
	public String getDescription()
	{
		return description;
	}
	public String toString()
	{
		return description + ": " + getDisplayCost();
	}
	public String getDisplayCost()
	{
		return getDisplayCost(cost);
	}
	public static String getDisplayCost(int cost)
	{
		NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
		String s = n.format(cost / 100.0);
		return s;
	}

}
