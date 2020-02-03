package com.gura.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.food.dao.FoodDao;
import com.gura.food.dto.FoodDto;

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

}
