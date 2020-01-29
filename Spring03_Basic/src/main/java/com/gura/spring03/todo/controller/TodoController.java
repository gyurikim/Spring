package com.gura.spring03.todo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//1. controller 어노테이션
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
}
