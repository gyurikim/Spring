package com.gura.spring05.food.dto;

public class FoodDto {
	private int num;
	private String menu;
	private String loc;
	
	public FoodDto() {}

	public FoodDto(int num, String menu, String loc) {
		super();
		this.num = num;
		this.menu = menu;
		this.loc = loc;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
}
