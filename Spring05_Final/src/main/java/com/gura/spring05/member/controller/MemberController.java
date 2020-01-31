package com.gura.spring05.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.member.dao.MemberDao;
import com.gura.spring05.member.dto.MemberDto;

@Controller
public class MemberController {
	//의존 객체 주입받기(DI)
	@Autowired	//의존객체 주입을 받지않으면 널포인트이셉션이 발생하므로 까먹지 않게 주의한다!!!
	private MemberDao dao;	//MemberDaoImpl로 변수 타입을 지정해줘도 오류없이 작동이 가능하다
	
	//회원 목록 보기 요청을 처리(/member/list.do)을 할 컨트롤러의 메소드
	@RequestMapping("/member/list")
	public ModelAndView list(ModelAndView mView) {
		//회원 목록을 얻어오려면?
		List<MemberDto> list=dao.getList();
		mView.addObject("list",list);
		mView.setViewName("member/list");
		/*
		 * 아닛! 스프링이 AI도 아니고 어떻게 member라는 mapper를 찾아가느냐!!!!
		 * servlet-context.xml 문서를 보면 sessionFactory를  setconfigLocation해서 Configuration.xml문서로 이동이되는데
		 * 아니! 이 문서에서 Mapper를 설정해줫잖아!!
		 * 이러한 이유때문에 MemberMapper를 찾아갈수 있었구나아~
		 */
		return mView;
	}
	
	//회원 정보 삭제 요청 처리 메소드
	@RequestMapping("/member/delete")
	public String delete(@RequestParam int num) {
		//MemberDao객체를 이용해서 회원정보 삭제
		dao.delete(num);
		return "redirect:/member/list.do";
	}
	
	//회원정보 추가 양식을 요청하는 메소드
	@RequestMapping("/member/insertform")
	public String insertform() {
		//수행할 비즈니스 로직은 없다
		return "member/insertform";
	}
	
	/*
	 * @ModelAttribute MemberDto dto를 메소드의 인자로 선언하면 
	 * 폼 전송되는 파라미터가 자동으로 MemberDto 객체에 setter 메소드를 통해서 들어가고, 그 객체가 메소드의 인자로 전달된다
	 * 단 파라미터명과 Dto의 필드명이 일치해야된다
	 */
	//회원정보 추가요청하는 메소드
	@RequestMapping("/member/insert")
	public ModelAndView insert(@ModelAttribute ("dto") MemberDto dto,ModelAndView mView) {
		dao.insert(dto);
		/*
		 * @ModelAttribute ("dto") MemberDto dto의 의미는 
		 * 1. 전송되는 파라미터를 자동으로 추출해서 MemberDto에 담아 주기도 하고
		 * 2. "dto"라는 키값으로 MemberDto객체를 request 영역에 담아주는 열할도 한다
		 */
		//mView.addObject("dto",dto);
		mView.setViewName("member/insert");
		return mView;
	}
	
	//회원정보를 수정하는 양식을 요청하는 메소드
	@RequestMapping("/member/updateform")
	public ModelAndView updateform(ModelAndView mView,@RequestParam int num) {
		//수정할 회원의 정보를 얻어와서
		MemberDto dto= dao.getData(num);
		//"dto"라는 키값으로 request 영역에 담기도 하고
		mView.addObject("dto",dto);
		//view page로 포워드 이동해서 수정할 회원의 정보를 출력해 준다
		mView.setViewName("member/updateform");
		return mView;
	}

	//회원정보 수정을요청하는 메소드
	@RequestMapping("/member/update")
	public ModelAndView update(@ModelAttribute MemberDto dto,ModelAndView mView) {
		dao.update(dto);
		mView.addObject("dto",dto);
		mView.setViewName("member/update");
		return mView;
	}
	
}












