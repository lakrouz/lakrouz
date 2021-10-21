package com.usermanager.atosusermanager.service;

import java.util.List;
import com.usermanager.atosusermanager.dto.UserDto;
import com.usermanager.atosusermanager.exception.UserManagerTechException;

public interface IDataManagerService {
	/**
	 * get user by id
	 * 
	 * @param id
	 * @return
	 * @throws UserManagerTechException
	 */
	UserDto getUserById(long id) throws Exception;

	/**
	 * save user
	 * 
	 * @param userDto
	 * @throws UserManagerTechException
	 */
	UserDto saveUser(UserDto userDto) throws Exception;

	/**
	 * @param userDto
	 * @return getAllUsers
	 * @throws Exception
	 */
	List<UserDto> getAllUsers() throws Exception;

	/**
	 * @param userDto
	 * @return getUsersByName
	 * @throws Exception
	 */
	List<UserDto> getUsersByName(UserDto userDto) throws Exception;

}
