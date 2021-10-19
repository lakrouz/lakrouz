package com.usermanager.atosusermanager.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.usermanager.atosusermanager.dao.IUserDao;
import com.usermanager.atosusermanager.dto.UserDto;
import com.usermanager.atosusermanager.entity.User;

// @RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class DataManagerServiceTest {
	@InjectMocks
	DataManagerService dataManagerService;
	@Mock
	IUserDao userDao;

	@Test
	void test1() {
		Long id = 123L;
		User expectedUser = new User();
		expectedUser.setUserName("test name");
		Optional<User> expectedResult = Optional.of(expectedUser);
		Mockito.when(userDao.findById(id)).thenReturn(expectedResult);
		UserDto actualResult = dataManagerService.getUserById(id);
		assertNotNull(actualResult);
		assertNotNull(expectedUser.getUserName());
		assertTrue(expectedUser.getUserName().contentEquals(actualResult.getUserName()));
	}

}
