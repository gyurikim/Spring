package com.gura.spring05.cafe.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.cafe.dto.CafeCommentDto;
import com.gura.spring05.cafe.dto.CafeDto;
import com.gura.spring05.cafe.service.CafeService;

@Controller
public class CafeController {
	@Autowired
	private CafeService service;
	
	@RequestMapping("/cafe/list")
	public ModelAndView list(ModelAndView mView, HttpServletRequest request,CafeCommentDto dto) {
		//파일목록과 페이징 처리에 필요한 값들을 request에 담아주는 서비스 메소드 호출하기
		service.list(request);
	
		mView.setViewName("cafe/list");
		return mView;
	}
	
	//회원정보 추가 양식을 요청하는 메소드
	@RequestMapping("/cafe/insertform")
	public ModelAndView authinsertform(ModelAndView mView,HttpServletRequest request) {
		//수행할 비즈니스 로직은 없다
		mView.setViewName("cafe/insertform");
		return mView;
	}
	
	@RequestMapping("/cafe/insert")
	public ModelAndView authInsert(@ModelAttribute ("dto") CafeDto dto,ModelAndView mView,HttpServletRequest request) {
		//서비스를 통해서 비즈니스 로직 처리하기
		service.addContent(dto, request);
		//mView.addObject("dto",dto);
		mView.setViewName("cafe/insert");
		return mView;
	}
	
	
	@RequestMapping("/cafe/delete")
	public ModelAndView authDeleteFile(HttpServletRequest request,int num) {
		service.deleteContent(num,request);
		return new ModelAndView("redirect:/cafe/list.do"); 
	}
	
	
	//회원정보를 수정하는 양식을 요청하는 메소드
		@RequestMapping("/cafe/updateform")
		public ModelAndView authupdateform(ModelAndView mView,@RequestParam int num,HttpServletRequest request) {
			//ModelAndView 객체에 회원정보가 담기도록 서비스의 메소드 호출
			service.getContent(mView, num);
			//view page로 포워드 이동해서 수정할 회원의 정보를 출력해 준다
			mView.setViewName("cafe/updateform");
			return mView;
		}

		//회원정보 수정을요청하는 메소드
		@RequestMapping("/cafe/update")
		public ModelAndView authupdate(@ModelAttribute ("dto") CafeDto dto,ModelAndView mView,HttpServletRequest request) {
			//회원정보가 수정 되도록 서비스의 메소드 호출
			service.updateContent(dto);
			mView.setViewName("cafe/update");
			return mView;
		}
		
		@RequestMapping("/cafe/detail")
		public ModelAndView detail(HttpServletRequest request ,ModelAndView mView,@RequestParam int num) {
			
			//UsersService객체를 이용해서 개인정보를 ModelAndView 객체에 담기도록한다
			service.getDetail(request);
			//view page에 정보를 담고		
			mView.setViewName("cafe/detail");
			return mView;//ModelAndView객체를 리턴해주기
			
		}
		
		//댓굴 저장 요청처리
		@RequestMapping(value="/cafe/comment_insert", method=RequestMethod.POST)
		public ModelAndView authCommentInsert(HttpServletRequest request,@RequestParam int ref_group) {
			service.saveComment(request);
			return new ModelAndView("redirect:/cafe/detail.do?num="+ref_group);
		}
		
		//댓글 삭제 요청처리
		@ResponseBody
		@RequestMapping(value="/cafe/comment_delete", method=RequestMethod.POST)
		public Map<String, Object> authCommentDelete(HttpServletRequest request,@RequestParam int num){
			service.deleteComment(num);
			
			Map<String,Object> map=new HashMap<>();
			map.put("isSuccess",true);
			return map;//{"isSuccess:true"}형식의 json문자열이 응답된다
		}
		
		//댓글 수정 요청처리
		@ResponseBody	//ajax요청을 할때 붙여주어야하는 어노테이션
		@RequestMapping("/cafe/comment_update")
		public Map<String,Object> authCommentUpdate(HttpServletRequest request,@ModelAttribute CafeCommentDto dto){
			service.updateComment(dto);
			
			Map<String, Object> map= new HashMap<>();
			map.put("isSuccess", true);
			return map;
		}
		
		
		
		
}






