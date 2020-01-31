package com.gura.food.dao;

import java.util.List;

import com.gura.food.dto.FoodDto;

public interface FoodDao{
	public List<FoodDto> getList();
	public void insert(FoodDto dto);
	public void delete(int num);
	public FoodDto getData(int num);
	public void update(FoodDto dto);
}	
