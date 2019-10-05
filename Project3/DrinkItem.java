package Project3;

/**
 * Creates the parent DrinkItem class with parameters/variables to be set 
 * @author Joseph
 * @since 3/19/19
 *
 */
public abstract class DrinkItem extends Item {

	private String name;
	private String size;
	private String flavor;
	private String sweetness;
	private String milk;

	public DrinkItem() {
		size = "N/A";
		flavor = "N/A";
		sweetness = "N/A";
		milk = "N/A";
	}
	
	public DrinkItem(String name, String size, String flavor, String sweetness, String milk) {
		this.name = name;
		this.size = size;
		this.flavor = flavor;
		this.sweetness = sweetness;
		this.milk = milk;
	}
	
	public void setFlavor(String newFlavor) { 
		flavor = newFlavor; 
	}
	
	public void setMilk(String newMilk) { 
		milk = newMilk; 
	}
	
	public void setSize(String newSize) {
		size = newSize; 
	}
	
	public void setSweetness(String newSweet) {
		sweetness = newSweet;
	}
	
	public String getFlavor() {
		return flavor;
	}
	
	public String getMilk() {
		return milk;
	}
	
	public String getSize() {
		return size;
	}
	
	public String getSweetness() {
		return sweetness;
	}
	
	public String toString() {
		String drinkItem = "";
		return drinkItem;
	}
}
