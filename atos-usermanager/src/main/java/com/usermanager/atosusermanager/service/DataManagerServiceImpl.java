package com.usermanager.atosusermanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usermanager.atosusermanager.dao.IUserDao;
import com.usermanager.atosusermanager.dto.UserDto;
import com.usermanager.atosusermanager.entity.User;
import com.usermanager.atosusermanager.mapper.ServiceMapper;
import com.usermanager.atosusermanager.validator.Validator;

@Service
public class DataManagerServiceImpl implements IDataManagerService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IUserDao userDao;
	@Autowired
	Validator validator;
	@Autowired
	ServiceMapper mapper;

	@Override
	public UserDto getUserById(long id) throws Exception {
		log.info("get data from database ");
		Optional<User> result = userDao.findById(id);
		if (result.isPresent()) {
			return this.mapper.mappUserModelToUserDto(result.get());
		}
		return null;
	}

	@Override
	public UserDto saveUser(UserDto userDto) throws Exception {
		log.info("save user into database ");
		// save user
		User savedUser = userDao.save(this.mapper.mappUserDtoToUserModel(userDto));
		// return a saved user
		return this.mapper.mappUserModelToUserDto(savedUser);

	}

	@Override
	public List<UserDto> getAllUsers() throws Exception {
		Iterable<User> allUsers = userDao.findAll();
		List<User> result = new ArrayList<>();
		allUsers.forEach(result::add);
		return result.stream().map(e -> this.mapper.mappUserModelToUserDto(e)).collect(Collectors.toList());
	}

	@Override
	public List<UserDto> getUsersByName(UserDto userDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
