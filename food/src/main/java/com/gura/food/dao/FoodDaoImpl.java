package com.gura.food.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.food.dto.FoodDto;

@Repository
public class FoodDaoImpl implements FoodDao{
	@Autowired
	private SqlSession session;
	
	@Override
	public List<FoodDto> getList() {
		List<FoodDto> list=session.selectList("food.getList");
		return list;
	}

	@Override
	public void insert(FoodDto dto) {
		session.insert("food.insert",dto);
		
	}

	@Override
	public void delete(int num) {
		session.delete("food.delete", num);
		
	}

	@Override
	public FoodDto getData(int num) {
		FoodDto dto=session.selectOne("food.getData", num);
		return dto;
	}

	@Override
	public void update(FoodDto dto) {
		session.update("food.update", dto);
		
	}

	@Override
	public List<FoodDto> locGetList(String loc) {
		List<FoodDto> list=session.selectList("food.locGetList",loc);
		return list;
	}
	
}
