package com.usermanager.atosusermanager.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usermanager.atosusermanager.dao.IUserDao;
import com.usermanager.atosusermanager.dto.UserDto;
import com.usermanager.atosusermanager.entity.User;
import com.usermanager.atosusermanager.mapper.ServiceMapper;

@Service
public class DataManagerService implements IDataManagerService {
	@Autowired
	IUserDao userDao;
	@Autowired
	ServiceMapper mapper;

	@Override
	public UserDto getUserById(long id) {
		Optional<User> result = userDao.findById(id);
		if (result.isPresent()) {
			return this.mapper.mappUserModelToUserDto(result.get());
		}
		return null;
	}

	@Override
	public void saveUser(UserDto userDto) {
		userDao.save(this.mapper.mappUserDtoToUserModel(userDto));
	}

}
