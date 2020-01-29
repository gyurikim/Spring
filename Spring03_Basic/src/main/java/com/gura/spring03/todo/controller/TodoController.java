package com.gura.spring03.todo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//1. controller 어노테이션
import org.springframework.web.servlet.ModelAndView;
@Controller
public class TodoController {
	//2. requestMapping 어노테이션으로 요청 맵핑하기
	@RequestMapping("/todo/list.do")
	public String list(HttpServletRequest request) {
		//3. 할일목록을 얻어오는 비지니스 로직 처리하기
		List<String> todoList= new ArrayList<String>();
		todoList.add("html 공부하기");
		todoList.add("css 공부하기");
		todoList.add("javasript 공부하기");
		//4. 비즈니스 로직 처리 결과 모델을 request 에 담기
		request.setAttribute("todoList", todoList);
		//5. view page의 정보를 리턴하면 해당페이지로 forward이동해서 응답이 된다
		return "todo/list";
	}
	
	@RequestMapping("/todo/list2")// .do 생략가능
	public ModelAndView list2() {//ModelAndView type은 모델의 정보와 뷰페이지의 정보를 같이 담아 전송된다. & HttpServletRequest를 선언해주지 않아도 된다
		List<String> todoList= new ArrayList<String>();
		todoList.add("html 공부하기");
		todoList.add("css 공부하기");
		todoList.add("javasript 공부하기");
		
		// model과 view page정보를 담을 수 있는 객체 생성
		ModelAndView mView=new ModelAndView();
		// ModelAndView 객체에 .addObject(key,value)로 담은 객체는 자동으로 request 객체에 담긴다
		mView.addObject("todoList", todoList);
		//view page 정보도 .setViewName() 메소드를 이용해서 담는다
		mView.setViewName("todo/list");
		return mView;	
	}
	
	//메소드 인자로 ModelAndView 객체를 받을수있는 변수를 선언하면 스프링 프레임워크가 해당 객체를 생성해서 인자로 전달해준다
	@RequestMapping("/todo/list3")// .do 생략가능
	public ModelAndView list3(ModelAndView mView) {//ModelAndView type은 모델의 정보와 뷰페이지의 정보를 같이 담아 전송된다. & HttpServletRequest를 선언해주지 않아도 된다
		List<String> todoList= new ArrayList<String>();
		todoList.add("html 공부하기");
		todoList.add("css 공부하기");
		todoList.add("javasript 공부하기");
		
		// 인자로 전달받은 객체에 Model을 담고
		mView.addObject("todoList", todoList);
		// 인자로 전달받은 객체에 view page의 정보를 담고
		mView.setViewName("todo/list");
		// 인자로 전달받을 객체의 참조값을 리턴해준다
		return mView;
	}
}
