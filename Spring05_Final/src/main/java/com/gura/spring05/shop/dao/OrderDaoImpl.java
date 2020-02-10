package com.gura.spring05.shop.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.shop.dto.OrderDto;

@Repository
public class OrderDaoImpl implements OrderDao{
	//의존객체 주입
	@Autowired
	private SqlSession session;

	@Override
	public void addOrder(OrderDto dto) {
		//주문테이블에 주문 추가
		session.insert("shop.addOrder",dto);
	}
}
