package com.gura.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.food.dao.FoodDao;
import com.gura.food.dto.FoodDto;
import com.gura.food.service.FoodService;

@Controller
public class FoodController {
	//의존객체 주입받기
	@Autowired
	private FoodService service;
	
	@RequestMapping("/foods/list")
	public ModelAndView list(ModelAndView mView) {
		service.getList(mView);
		mView.setViewName("foods/list");
		return mView;
	}
	
	@RequestMapping("/foods/insertform")
	public String insertform() {
		return "foods/insertform";
	}
	
	@RequestMapping("/foods/insert")
	public ModelAndView insert(@ModelAttribute ("dto") FoodDto dto,ModelAndView mView) {
		service.addFood(dto);
		mView.setViewName("foods/insert");
		return mView;
	}
	
	@RequestMapping("/foods/delete")
	public String delete(@RequestParam int num) {
		service.deleteFood(num);
		return "redirect:/foods/list.do";
	}
	
	@RequestMapping("/foods/updateform")
	public ModelAndView updateform(ModelAndView mView,@RequestParam int num) {
		//수정할 회원의 정보를 얻어와서
		service.getFood(mView, num);
		//view page로 포워드 이동해서 수정할 회원의 정보를 출력해 준다
		mView.setViewName("foods/updateform");
		return mView;
	}

	//회원정보 수정을요청하는 메소드
	@RequestMapping("/foods/update")
	public ModelAndView update(@ModelAttribute FoodDto dto,ModelAndView mView) {
		service.updateFood(mView, dto);
		mView.setViewName("foods/update");
		return mView;
	}
	
	@RequestMapping("/foods/loc")
	public ModelAndView locList(ModelAndView mView,@ModelAttribute FoodDto dto) {
		service.getLocList(mView, dto);
		mView.setViewName("foods/locList?loc=${loc}");
		return mView;
	}
	
}











