package com.gura.spring05.food.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.food.dto.FoodDto;

public interface FoodService {
	public void getList(ModelAndView mView,HttpServletRequest request);
	public void addFood(FoodDto dto);
	public void getFood(ModelAndView mView, int num);
	public void updateFood(ModelAndView mView,FoodDto dto);
	public void deleteFood(int num);
	public void getLocList(ModelAndView mView, String loc);
	
}
