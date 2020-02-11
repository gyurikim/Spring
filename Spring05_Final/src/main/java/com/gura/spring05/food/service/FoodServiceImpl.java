package com.gura.spring05.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.food.dao.FoodDao;
import com.gura.spring05.food.dto.FoodDto;

@Service
public class FoodServiceImpl implements FoodService{

	@Autowired
	private FoodDao dao;
	
	@Override
	public void getList(ModelAndView mView) {
		List<FoodDto> list=dao.getList();
		mView.addObject("list", list);
	}

	@Override
	public void addFood(FoodDto dto) {
		dao.insert(dto);
	}

	@Override
	public void getFood(ModelAndView mView, int num) {
		FoodDto dto=dao.getData(num);
		mView.addObject("dto", dto);		
	}

	@Override
	public void deleteFood(int num) {
		dao.delete(num);
	}

	@Override
	public void updateFood(ModelAndView mView, FoodDto dto) {
		dao.update(dto);
		mView.addObject("dto", dto);
	}

	@Override
	public void getLocList(ModelAndView mView,FoodDto dto,@RequestParam String loc) {
		List<FoodDto> list=dao.locGetList(loc);
		mView.addObject("dto", dto);
		mView.addObject("list", list);
		
	}

	

}
