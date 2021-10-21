package com.usermanager.atosusermanager.controllers;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.usermanager.atosusermanager.dto.UserDto;
import com.usermanager.atosusermanager.exception.ErrorMessage;
import com.usermanager.atosusermanager.exception.UserManagerFuncException;
import com.usermanager.atosusermanager.exception.UserManagerTechException;
import com.usermanager.atosusermanager.service.IDataManagerService;
import com.usermanager.atosusermanager.validator.Validator;

@RestController
public class UserManagerController {
	@Autowired
	private IDataManagerService dataManagerService;
	@Autowired
	Validator validator;
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	// @CrossOrigin("http://localhost:4200")
	@PostMapping("/addUser")
	public HttpStatus addUser(@RequestBody UserDto userDto) throws UserManagerTechException {

		try {
			if (validator.isAgeUserValid(userDto) && validator.isUserFancais(userDto)) {
				throw new UserManagerFuncException("vous devez etre français et avoir plus de 18", "101", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			dataManagerService.saveUser(userDto);
			return HttpStatus.OK;
		} catch (Exception e) {
			throw new UserManagerTechException("erreur lors de l'ajout d'un nouveau user ", "102", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// @CrossOrigin("http://localhost:4200")
	@GetMapping("/getUser")
	public UserDto getUser(Long id) throws UserManagerTechException {
		try {
			return dataManagerService.getUserById(id);
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new UserManagerTechException("erreur lors de la récupération de user ", "103", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAllUser")
	public List<UserDto> getAllUser() throws UserManagerTechException {
		try {
			return dataManagerService.getAllUsers();
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new UserManagerTechException("erreur lors de la récupération tous les users ", "104", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * gestion des exceptions
	 * 
	 * @param ex
	 * @return ErrorMessage
	 */
	@ExceptionHandler({ UserManagerTechException.class })
	public ErrorMessage handleException(UserManagerTechException ex) {

		return new ErrorMessage(ex.getMessage(), ex.getErrorCode());
	}

}
