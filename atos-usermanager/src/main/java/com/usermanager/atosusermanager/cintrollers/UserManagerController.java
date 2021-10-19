package com.usermanager.atosusermanager.cintrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.usermanager.atosusermanager.dto.UserDto;
import com.usermanager.atosusermanager.service.IDataManagerService;

@RestController
public class UserManagerController {
	@Autowired
	private IDataManagerService dataManagerService;

	// @CrossOrigin("http://localhost:4200")
	@PostMapping("/addUser")
	public HttpStatus addUser(@RequestBody UserDto userDto) {
		try {
			dataManagerService.saveUser(userDto);
			return HttpStatus.OK;
		} catch (Exception e) {
			// log exception
			// throw custom exception here
			// ou
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}

	}

	// @CrossOrigin("http://localhost:4200")
	@GetMapping("/getUser")
	public UserDto getUser(Long id) {
		return dataManagerService.getUserById(id);
	}

}
