package com.usermanager.atosusermanager.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.sql.SQLException;
import java.util.Optional;
import org.hibernate.exception.SQLGrammarException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.usermanager.atosusermanager.dao.IUserDao;
import com.usermanager.atosusermanager.dto.UserDto;
import com.usermanager.atosusermanager.entity.User;
import com.usermanager.atosusermanager.exception.UserManagerTechException;
import com.usermanager.atosusermanager.mapper.ServiceMapper;

@SpringBootTest
class DataManagerServiceTest {

	@TestConfiguration
	static class DataManagerServiceImplTestContextConfiguration {
		// on déclare les beans ici si on veut utiliser un context spécifique pour les tests
	}

	@Autowired
	DataManagerServiceImpl dataManagerService;
	@MockBean
	IUserDao userDao;
	@Autowired
	ServiceMapper mapper;

	@Test
	void getUserById_passing_case() throws Exception {
		Long id = 123L;
		User expectedUser = new User();
		expectedUser.setUserName("test name");
		expectedUser.setId(123L);
		expectedUser.setBirthCountry("FRANCE");
		Optional<User> expectedResult = Optional.of(expectedUser);
		Mockito.when(userDao.findById(id)).thenReturn(expectedResult);
		UserDto actualResult = dataManagerService.getUserById(id);
		assertNotNull(actualResult);
		assertNotNull(expectedUser.getUserName());
		assertTrue(expectedUser.getUserName().contentEquals(actualResult.getUserName()));
	}

	@Test
	void getUserById_shuld_rise_exception() throws Exception {
		Long id = 123L;
		User expectedUser = new User();
		expectedUser.setUserName("test name");
		expectedUser.setId(123L);
		expectedUser.setBirthCountry("FRANCE");
		Mockito.when(userDao.findById(id)).thenThrow(new SQLGrammarException("data base error message's mock", new SQLException()));

		Exception e = assertThrows(Exception.class, () -> {
			dataManagerService.getUserById(id);
		});
		String expectedResultMessage = "data base error message's mock";
		assertNotNull(e);
		assertEquals(expectedResultMessage, e.getMessage());
	}

	@Test
	void saveUser_passing_case() throws Exception {
		Long id = 123L;
		UserDto userDto = new UserDto();
		userDto.setUserName("test name");
		userDto.setId(id);
		userDto.setBirthCountry("FRANCE");
		Mockito.when(userDao.save(Mockito.any())).thenReturn(mapper.mappUserDtoToUserModel(userDto));
		UserDto actualResult = dataManagerService.saveUser(userDto);
		assertNotNull(actualResult);
	}

	@Test
	void saveUser_passing_case1() throws UserManagerTechException {
		Mockito.when(userDao.save(Mockito.any())).thenThrow(new SQLGrammarException("data base error message's mock", new SQLException()));
		Exception e = assertThrows(Exception.class, () -> {
			dataManagerService.saveUser(new UserDto());
		});
		String expectedResultMessage = "data base error message's mock";
		assertNotNull(e);
		assertEquals(expectedResultMessage, e.getMessage());
	}
}
