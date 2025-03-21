package restaurant;

import java.util.ArrayList;

import people.Chef;
import people.Visitor;
import main.Main;

public class Restaurant {
	private String name;
	private ArrayList<Menu> menus;
	private ArrayList<Chef> chefs;
	private int income;
	
	
	public Restaurant(String name) {
		this.name = name;
		this.menus = new ArrayList<Menu>();
		this.chefs = new ArrayList<Chef>();
		this.income = 0;
	}

	public void addMenu(Menu menu) {
		this.menus.add(menu);
	}

	public void showMenu() {
		System.out.println(this.name +" Menus : ");
		
		for(Menu menu : menus) {
			System.out.println("  "+menu.getName() + " :");
			
			menu.showFoods();
		}
		System.out.println();
	}

	public void addChef(Chef chef) {
		this.chefs.add(chef);
	}
	
	public void showChef() {
		System.out.println(this.name + " Chefs :");
		for(Chef chef : chefs) {
			System.out.println(" - " + chef.getName());
		}
		System.out.println();
	}
	
	private Food searchFood(String name) {
		for(Menu menu : menus) {
			for(Food food : menu.getFoods()) {
				if(name.equals(food.getName())) {
					return food;
				}
			}
		}
		
		//tidak ketemu
		return null;
	}

	public void order(Chef chef, Visitor visitor, String foodName, int totalOrder) {
		//add to chef history
		Food orderFood = searchFood(foodName);
		if(orderFood == null) { // tidak ketemu di menu
			return;
		}
		chef.addHistory(orderFood, Integer.valueOf(totalOrder));
		
		//add total price to visitor
		visitor.setTotalPrice(visitor.getTotalPrice() +  totalOrder * orderFood.getPrice());
		
		//add to order list visitor
		visitor.addOrders(orderFood, Integer.valueOf(totalOrder));
		
		//add income restaurant
		this.income +=  totalOrder * ((int) orderFood.getPrice());
	}

	public void showTotalIncome() {
		System.out.println("Total " + this.name + " Restaurant Income : " + Main.formatIDR(income));
	}


}
