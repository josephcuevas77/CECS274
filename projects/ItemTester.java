package projects;

public class ItemTester {

	public static void main(String[] args) {
		Item item1 = new Item();
		item1.setItemName("Banana");
		item1.setSize("5 oz");
		item1.setUnitPrice(0.50);
		item1.updateQty();
		item1.updateQty();
		
		System.out.println("Name: " + item1.getItemName());
		System.out.println("Size: " + item1.getSize() + "\t\t Unit Price: $" + item1.getUnitPrice());
		System.out.println("Qty: " + item1.getQty() + "\t\t Subtotal: $" + item1.getSubtotal());
		
		Item item2 = new Item("Strawberries", "1 pkg", 2.45, 4);
		
		//System.out.printf("Name : %-25sSize: %-10sUnit Price: $%.2f%nQty: %-10dSubtotal: $%.2f", 
			//	item2.getItemName(), item2.getSize(), item2.getUnitPrice(), item2.getQty(), item2.getSubtotal());
		
		System.out.println(item2);
		System.out.println(item1);
		System.out.printf("Total: $%.2f", item1.getSubtotal()+item2.getSubtotal());
	}

}
