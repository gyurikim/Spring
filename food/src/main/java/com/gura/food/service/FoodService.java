package com.gura.food.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.gura.food.dto.FoodDto;

public interface FoodService {
	public void getList(ModelAndView mView);
	public void addFood(FoodDto dto);
	public void getFood(ModelAndView mView, int num);
	public void updateFood(ModelAndView mView,FoodDto dto);
	public void deleteFood(int num);
	public void getLocList(ModelAndView mView, FoodDto dto);
}
