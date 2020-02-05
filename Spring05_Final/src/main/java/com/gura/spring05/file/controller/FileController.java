package com.gura.spring05.file.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.file.dto.FileDto;
import com.gura.spring05.file.service.FileService;

@Controller
public class FileController{
	@Autowired
	private FileService service;
	
	@RequestMapping("/file/list")
	public ModelAndView list(ModelAndView mView, HttpServletRequest request) {
		//파일목록과 페이징 처리에 필요한 값들을 request에 담아주는 서비스 메소드 호출하기
		service.list(request);
		
		mView.setViewName("file/list");
		return mView;
	}
	//파일 업로드 폼 요청처리
	@RequestMapping("/file/upload_form")
	public ModelAndView authUploadForm(HttpServletRequest request) {
		return new ModelAndView("file/upload_form");
	}
	
	//파일 업로드 요청처리
	@RequestMapping(value="/file/upload", method = RequestMethod.POST)
	public ModelAndView authUpload(HttpServletRequest request,@ModelAttribute FileDto dto) {
		service.saveFile(request, dto);
				
		return new ModelAndView("redirect:/file/list.do");
	}
	
	//파일 다운로드 처리
	@RequestMapping("/file/download")
	public ModelAndView download(ModelAndView mView, @RequestParam int num) {
		//다운로드 시켜줄 파일 데이터를 ModelAndView객체에 담기도록
		service.getFileData(mView, num);
		//다운로드 횟수 증기시키도록
		service.addDownCount(num);
		//view page에 담아서
		mView.setViewName("fileDownView");//뷰가 빈으로 만들어져있으면 0순위로 뷰를 찾아가지만 존재하지 않으면 알아서 jsp페이지를 찾아간다
		return mView;//리턴한다
	}
	
	@RequestMapping("/file/delete")
	public ModelAndView authDeleteFile(HttpServletRequest request) {
		service.removeFile(request);
		return new ModelAndView("redirect:/file/list.do"); 
	}
}




