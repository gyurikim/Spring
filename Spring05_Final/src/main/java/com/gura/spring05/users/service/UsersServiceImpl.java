package com.gura.spring05.users.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gura.spring05.users.dao.UsersDao;
import com.gura.spring05.users.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersDao dao;
	
	//인자로 전달된 아이디가 존재하는지 여부를 Map에 담아서 리턴하는 메소드
	@Override
	public Map<String, Object> isExistId(String inputId) {
		boolean isExist = dao.isExist(inputId);
		Map<String, Object> map=new HashMap<>();
		map.put("isExist", isExist);// 맵을 잘 활용하면 알아서 잘 제이슨형식으로 변환되서 보다 쉽게 인자를 전달할수있다
		return map;
	}

	@Override
	public void addUser(UsersDto dto) {
		//비밀번호를 암호화한다.
		String encodePwd=new BCryptPasswordEncoder().encode(dto.getPwd());
		//암호화된 비밀번호를 UsersDto에 다시 넣어준다
		dto.setPwd(encodePwd);
		//UsersDao객체를 이용해서 DB에 저장하기
		dao.insert(dto);
	}

}
