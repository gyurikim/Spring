package com.gura.spring05.food.dto;

public class FoodDto {
	private int num;
	private String menu;
	private String loc;
	private int startRowNum;
	private int endRowNum;
	
	public FoodDto() {}

	public FoodDto(int num, String menu, String loc, int startRowNum, int endRowNum) {
		super();
		this.num = num;
		this.menu = menu;
		this.loc = loc;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
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

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	


	
}
