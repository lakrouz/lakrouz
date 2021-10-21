package com.usermanager.atosusermanager.mapper;

import org.springframework.stereotype.Service;
import com.usermanager.atosusermanager.dto.UserDto;
import com.usermanager.atosusermanager.entity.User;

@Service
public class ServiceMapper {

	/**
	 * permet de mapper le user model to user dto
	 * 
	 * @param userModel
	 * @return UserDto
	 */
	public UserDto mappUserModelToUserDto(User userModel) {
		UserDto dto = null;
		if (userModel != null) {
			dto = new UserDto();
			dto.setId(userModel.getId());
			dto.setUserName(userModel.getUserName());
			dto.setBirthCountry(userModel.getBirthCountry());
			dto.setBirthDate(userModel.getBirthdate());
			dto.setGender(userModel.getGender());
		}
		return dto;
	}

	/**
	 * permet de mapper user dto to user model
	 * 
	 * @param userDto
	 * @return UserDto
	 */
	public User mappUserDtoToUserModel(UserDto userDto) {
		User model = null;
		if (userDto != null) {
			model = new User();
			model.setUserName(userDto.getUserName());
			model.setBirthCountry(userDto.getBirthCountry());
			model.setBirthdate(userDto.getBirthDate());
			model.setGender(userDto.getGender());
		}
		return model;
	}

}
