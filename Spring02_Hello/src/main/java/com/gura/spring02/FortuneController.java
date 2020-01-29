package com.gura.spring02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1.controller 어노테이션 붙여주기
@Controller
public class FortuneController {
	//2. 메소드를 만들고 requestmapping어노테이션 작성하기
	@RequestMapping("/fortune.do")
	public String fortune(HttpServletRequest request) {// 메소드명은 마음대로 지을수있다.
		// view page에 모델(data)를 전달해주기 위해서는 HttpServletRequest 객체에 참조값을 넣어주어야한다
		request.setAttribute("fortuneToday", "로또사러 가요~");
		
		//3. view page정보를 리턴해준다.
		return "fortune";
	}
}
