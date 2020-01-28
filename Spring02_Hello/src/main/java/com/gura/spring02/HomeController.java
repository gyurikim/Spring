package com.gura.spring02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * @Controller 어노테이션
 * - 해당 클래스가 Spring MVC 프로젝트에서 Controller가 될 수 있도록 한다
 * - component scan 을 통해서 spring bean contrainer에서 관리가 되는 bean이 되어야 동작을 한다.
 */
@Controller
public class HomeController {
	
	// /home.do 요청이 왔을때 요청을 처리하게 하는 @RequestMapping 어노테이션
	@RequestMapping("/home.do")
	public String home() {
		/*
		 *  "home"을 리턴해주면
		 *  "/WEB-INF/views" + "home" + ".jsp"와 같은 문자열이 만들어지고
		 *   /WEB-INF/views/home.jsp페이지로 forward이동 되어서 응답된다.
		 */
		return "home";
	}
}
