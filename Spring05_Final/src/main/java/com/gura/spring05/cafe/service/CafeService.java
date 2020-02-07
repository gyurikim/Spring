package com.gura.spring05.cafe.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.cafe.dto.CafeDto;

public interface CafeService {
	public void list(HttpServletRequest request);
	public void addContent(CafeDto dto,HttpServletRequest request);
	public void getContent(ModelAndView mView, int num);
	public void deleteContent(int num,HttpServletRequest request);
	public void updateContent(CafeDto dto);
	public void updateComment(CafeDto dto,HttpServletRequest request);
	public void getDetail(HttpServletRequest request);
}
