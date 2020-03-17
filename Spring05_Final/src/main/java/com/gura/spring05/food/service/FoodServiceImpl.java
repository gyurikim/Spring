package com.gura.spring05.food.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.file.dto.FileDto;
import com.gura.spring05.food.dao.FoodDao;
import com.gura.spring05.food.dto.FoodDto;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodDao dao;

	@Override
	public void getList(ModelAndView mView, HttpServletRequest request) {
		FoodDto dto = new FoodDto();
		// 한 페이지에 나타낼 row 의 갯수
		final int PAGE_ROW_COUNT = 5;
		// 하단 디스플레이 페이지 갯수
		final int PAGE_DISPLAY_COUNT = 3;

		// 보여줄 페이지의 번호
		int pageNum = 1;
		// 보여줄 페이지의 번호가 파라미터로 전달되는지 읽어와 본다.
		String strPageNum = request.getParameter("pageNum");
		if (strPageNum != null) {// 페이지 번호가 파라미터로 넘어온다면
			// 페이지 번호를 설정한다.
			pageNum = Integer.parseInt(strPageNum);
		}
		// 보여줄 페이지 데이터의 시작 ResultSet row 번호
		int startRowNum = 1 + (pageNum - 1) * PAGE_ROW_COUNT;
		// 보여줄 페이지 데이터의 끝 ResultSet row 번호
		int endRowNum = pageNum * PAGE_ROW_COUNT;

		// 전체 row 의 갯수를 읽어온다.
		int totalRow = dao.getCount(dto);
		// 전체 페이지의 갯수 구하기
		int totalPageCount = (int) Math.ceil(totalRow / (double) PAGE_ROW_COUNT);
		// 시작 페이지 번호
		int startPageNum = 1 + ((pageNum - 1) / PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		// 끝 페이지 번호
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
		// 끝 페이지 번호가 잘못된 값이라면
		if (totalPageCount < endPageNum) {
			endPageNum = totalPageCount; // 보정해준다.
		}
		// FileDto 객체에 위에서 계산된 startRowNum 과 endRowNum 을 담는다.
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);

		List<FoodDto> list = dao.getList();
		mView.addObject("list", list);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("totalPageCount", totalPageCount);
		// 전체 글의 갯수 담기
		request.setAttribute("totalRow", totalRow);
	}

	@Override
	public void addFood(FoodDto dto) {
		dao.insert(dto);
	}

	@Override
	public void getFood(ModelAndView mView, int num) {
		FoodDto dto = dao.getData(num);
		mView.addObject("dto", dto);
	}

	@Override
	public void deleteFood(int num) {
		dao.delete(num);
	}

	@Override
	public void updateFood(ModelAndView mView, FoodDto dto) {
		dao.update(dto);
		mView.addObject("dto", dto);
	}

	@Override
	public void getLocList(ModelAndView mView, String loc) {
		List<FoodDto> list = dao.locGetList(loc);
		mView.addObject("list", list);

	}

}
