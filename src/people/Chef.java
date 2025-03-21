package people;

import java.util.HashMap;
import java.util.Map;

import restaurant.Food;

public class Chef {
	private String name;
	private HashMap<Food, Integer> histories;

	public Chef(String name) {
		this.name = name;
		this.histories = new HashMap<Food, Integer>();
	}
	
	public void addHistory(Food food, int total) {
		if(histories.containsKey(food)) {
			this.histories.replace(food, histories.get(food) + total);
			return;
		}
		this.histories.put(food, total);
	}
	
	public void showCookHistory() {
		System.out.println("Chef " + this.name + " History Cooking:");
		for(Map.Entry<Food, Integer> history : histories.entrySet()) {
			System.out.println(history.getKey().getName()  +", Total: " + history.getValue());
		}
		System.out.println();
	}
	
	//getter setter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
