package people;

import java.util.HashMap;
import java.util.Map;

import main.Main;
import restaurant.Food;

public class Visitor {
	private String name;
	private int totalPrice;
	private HashMap<Food, Integer> orders;
	
	
	public Visitor(String name) {
		this.name = name;
		this.totalPrice = 0;
		this.orders = new HashMap<Food, Integer>();
	}
	
	public void addOrders(Food food , int total) {
		if(orders.containsKey(food)) {
			int newTotal = total + (int) orders.get(food);
			orders.replace(food, Integer.valueOf(newTotal));
			return;
		}
		this.orders.put(food, Integer.valueOf(total));
	}
	
	public void showTotalPrice() {
		System.out.println(name +" Orders :");
		
		for(Map.Entry<Food, Integer> order : orders.entrySet()) {
			System.out.println("- " + order.getKey().getName());
			System.out.println("  Total : " + (int) order.getValue());
		}
		
		System.out.println("Total Spent : " + Main.formatIDR(this.totalPrice) +"\n");
	}

	//getter setter

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}
