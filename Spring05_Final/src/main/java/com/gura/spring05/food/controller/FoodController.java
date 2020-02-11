package com.gura.spring05.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.food.dto.FoodDto;
import com.gura.spring05.food.service.FoodService;

@Controller
public class FoodController {
	//의존객체 주입받기
	@Autowired
	private FoodService service;
	
	@RequestMapping("/food/list")
	public ModelAndView list(ModelAndView mView) {
		service.getList(mView);
		mView.setViewName("food/list");
		return mView;
	}
	
	@RequestMapping("/food/insertform")
	public String insertform() {
		return "food/insertform";
	}
	
	@RequestMapping("/food/insert")
	public ModelAndView insert(@ModelAttribute ("dto") FoodDto dto,ModelAndView mView) {
		service.addFood(dto);
		mView.setViewName("food/insert");
		return mView;
	}
	
	@RequestMapping("/food/delete")
	public String delete(@RequestParam int num) {
		service.deleteFood(num);
		return "food/delete";
	}
	
	@RequestMapping("/food/updateform")
	public ModelAndView updateform(ModelAndView mView,@RequestParam int num) {
		//수정할 회원의 정보를 얻어와서
		service.getFood(mView, num);
		//view page로 포워드 이동해서 수정할 회원의 정보를 출력해 준다
		mView.setViewName("food/updateform");
		return mView;
	}

	//회원정보 수정을요청하는 메소드
	@RequestMapping("/food/update")
	public ModelAndView update(@ModelAttribute FoodDto dto,ModelAndView mView) {
		service.updateFood(mView, dto);
		mView.setViewName("food/update");
		return mView;
	}
	
	@RequestMapping("/food/locList")
	public ModelAndView locList(ModelAndView mView,@ModelAttribute FoodDto dto,@RequestParam String loc) {
		service.getLocList(mView,dto, loc);
		mView.setViewName("food/locList");
		return mView;
	}
	
}











