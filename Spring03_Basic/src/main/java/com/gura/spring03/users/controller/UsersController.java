package com.gura.spring03.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.users.dto.UsersDto;

@Controller
public class UsersController {
	//로그인 폼 요청 메소드
	@RequestMapping("/users/loginform")
	public String loginform() {
		//수행할 비즈니스 로직은 없다
		//request영역에 담을 모델도 없다.
		
		//view page의 정보만 단순히 리턴해주는 경우도 있다.
		return "users/loginform";
	}
	
	//로그인 요청 메소드
	@RequestMapping("/users/login")
	public String login(HttpServletRequest request, HttpSession session){
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		//유효한 정보인지 확인여부
		boolean isSuccess=false;
		if(id.equals("gura")&&pwd.equals("1234")) {
			isSuccess=true;
			//로그인 처리를 할 아이디를 세션에 담기
			session.setAttribute("id", id);
		}
		//로그인 성공 여부를 request에 담는다
		request.setAttribute("isSuccess", isSuccess);
		// view page의 정보를 리턴한다
		return "users/login";
	}
	
	/*
	 * @RequestParam 어노테이션을 전송되는 파라미터를 자동으로 추출할떄 사용한다.
	 * 단, 지역변수의 이름은 파라미터의 이름과 같아야한다.
	 */
	@RequestMapping("/users/login2")
	public ModelAndView login2(@RequestParam String id, @RequestParam String pwd, HttpSession session, ModelAndView mView) {//파라미터명과 같으면 자동으로 추출가능
		//유효한 정보인지 확인여부
		boolean isSuccess=false;
		if(id.equals("gura")&&pwd.equals("1234")) {
			isSuccess=true;
			//로그인 처리를 할 아이디를 세션에 담기
			session.setAttribute("id", id);
		}
		//view 페이지에서 필요한 모델을 담고
		mView.addObject("isSuccess", isSuccess);
		//view page의 정보도 담고
		mView.setViewName("users/login");
		//리턴해준다
		return mView;
	}
	
	@RequestMapping("/users/login3")
	public ModelAndView login3(UsersDto dto,HttpSession session,ModelAndView mView) {
		//유효한 정보인지 확인여부
		boolean isSuccess=false;
		if(dto.getId().equals("gura")&&dto.getPwd().equals("1234")) {
			isSuccess=true;
			//로그인 처리를 할 아이디를 세션에 담기
			session.setAttribute("id", dto.getId());
		}
		//view 페이지에서 필요한 모델을 담고
		mView.addObject("isSuccess", isSuccess);
		//view page의 정보도 담고
		mView.setViewName("users/login");
		//리턴해준다
		return mView;
	}
	
	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "users/logout";
	}
	
}










