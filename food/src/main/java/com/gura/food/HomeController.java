package com.gura.food;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	// /home.do  요청이 왔을때 요청을 처리하게 하는 @RequestMapping 어노테이션
	@RequestMapping("/home.do")
	public String home(HttpServletRequest request) {
		//모델
		List<String> notice=new ArrayList<String>();
		notice.add("감기조심");
		notice.add("코로나 조심");
		notice.add("다들 살아 남아요~");
		notice.add("어쩌구...");
		notice.add("저쩌구...");
		
		//모델을 request 에 담는다.
		request.setAttribute("notice", notice);
		
		/*
		 *  "home" 을 리턴해주면
		 *  
		 *  "/WEB-INF/views/"+"home"+".jsp" 와 같은 문자열이 만들어 지고
		 *  
		 *  /WEB-INF/views/home.jsp 페이지로 forward 이동 되어서 
		 *  
		 *  응답된다. 
		 */
		return "home";
	}
	@RequestMapping("/play")
	public ModelAndView play(HttpSession session, ModelAndView mView) {
		//세션에 로그인 정보가 있는지 확인한다
		String id= (String)session.getAttribute("id");
		if(id==null){//로그인이 안되어있는 상태
			mView.setViewName("redirect:/users/loginform.do");//리다이렉트 이동
		}else {//로그인 되어있는 상태
			mView.setViewName("play");//포워드 이동
		}
		return mView;
	}
}



