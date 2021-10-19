package com.usermanager.atosusermanager.service;

import com.usermanager.atosusermanager.dto.UserDto;

public interface IDataManagerService {
	/**
	 * récupere un user par son id
	 * 
	 * @return User
	 */
	UserDto getUserById(long id);

	/**
	 * save user
	 * 
	 * @param listUserDto
	 * @return User
	 */
	void saveUser(UserDto userDto);
}
