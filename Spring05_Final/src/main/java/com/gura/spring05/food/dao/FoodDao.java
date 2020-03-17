package com.gura.spring05.food.dao;

import java.util.List;

import com.gura.spring05.food.dto.FoodDto;

public interface FoodDao{
	public int getCount(FoodDto dto);
	public List<FoodDto> getList();
	public void insert(FoodDto dto);
	public void delete(int num);
	public FoodDto getData(int num);
	public void update(FoodDto dto);
	public List<FoodDto> locGetList(String loc);
}	
