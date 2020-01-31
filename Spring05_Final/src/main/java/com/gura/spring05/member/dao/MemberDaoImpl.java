package com.gura.spring05.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.member.dto.MemberDto;

@Repository 	//어노테이션을 사용하면 컴포넌트-스캔할때 Bean이 생성된다!!
public class MemberDaoImpl implements MemberDao{
	
	//핵심 의존 객체를 spring으로 주입받기 > Dependency injection(DI)
	//지역변수는 선언만 한다면 null값이 들어있지만, 컨테이너에서 값을 관리하다가 호출되면 값을 넣어준다. 
	@Autowired
	private SqlSession session;
	
	@Override
	public List<MemberDto> getList() {
		//return session.selectList("member.getList");
		List<MemberDto> list=session.selectList("member.getList");
		return list;
	}

	@Override
	public void delete(int num) {
		session.delete("member.delete",num);
	}

	@Override
	public void insert(MemberDto dto) {
		session.insert("member.insert", dto);		
	}

	@Override
	public MemberDto getData(int num) {
		MemberDto dto=session.selectOne("member.getData", num);
		return dto;
	}

	@Override
	public void update(MemberDto dto) {
		session.update("member.update", dto);
	}
	
	
}
