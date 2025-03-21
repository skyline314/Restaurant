package restaurant;

import java.util.ArrayList;

public class Menu {
	private String name;
	private ArrayList<Food> foods;
	

	public Menu(String name) {
		this.name = name;
		this.foods = new ArrayList<Food>();
	}

	public void add(Food food) {
		this.foods.add(food);
	}
	
	public void showFoods() {
		for(Food food : foods) {
			System.out.println("    - " + food.getName());
		}
	}
	
	// getter setter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Food> getFoods() {
		return foods;
	}

	public void setFoods(ArrayList<Food> foods) {
		this.foods = foods;
	}
}
