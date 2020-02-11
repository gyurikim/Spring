package com.gura.spring05.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gura.spring05.shop.dto.ShopDto;

//@Component 어노테이션을 붙여도 상관없지만 트랜잭션어노테이션을 붙이기 위해서 @Repository 어노테이션을 붙여 사용한다
@Repository
public class ShopDaoImpl implements ShopDao{
	//의존객체 주입
	@Autowired
	private SqlSession session;
	
	@Override
	public List<ShopDto> getList() {
		return session.selectList("shop.getList");
	}

	@Override
	public void minusCount(int num) {
		//재고의 갯수 줄이기
		session.update("shop.minusCount",num);
	}

	@Override
	public void minusMoney(ShopDto dto) {
		//계좌잔액 줄이기
		session.update("shop.minusMoney", dto);
	}

	@Override
	public void plusPoint(ShopDto dto) {
		//포인트 적립하기
		session.update("shop.plusPoint",dto);
	}

	@Override
	public int getPrice(int num) {
		//가격 select해서 리턴하기
		return session.selectOne("shop.getPrice",num);
	}

}
