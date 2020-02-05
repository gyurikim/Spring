package com.gura.spring05.users.dao;

import com.gura.spring05.users.dto.UsersDto;

public interface UsersDao {
	public boolean isExist(String inputId);
	public void insert(UsersDto dto);
	public String getPwdHash(String id);
	public UsersDto getData(String id);
	public String getProfile(String id);
	public void updateProfile(UsersDto dto);
	public void updatePwd(UsersDto dto);
	public void delete(String id);
	public void updateUser(UsersDto dto);
}
