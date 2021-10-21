package com.usermanager.atosusermanager.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usermanager.atosusermanager.dto.UserDto;
import com.usermanager.atosusermanager.outils.DateUtils;

@Service
public class Validator {
	@Autowired
	DateUtils dateUtils;

	private final String FRANCE = "France";

	/**
	 * verifier l'age de user
	 * 
	 * @param dto
	 * @return boolean
	 */
	public boolean isAgeUserValid(UserDto dto) {
		LocalDate birthDate = dateUtils.convertStringToLocalDate(dto.getBirthDate(), DateTimeFormatter.ofPattern("d/MM/uuuu"));
		int age = this.dateUtils.calculateAge(birthDate, LocalDate.now());
		return age > 18;
	}

	/**
	 * vérifier si le user est français
	 * 
	 * @param dto
	 * @return boolean
	 */
	public boolean isUserFancais(UserDto dto) {
		return dto != null && FRANCE.equalsIgnoreCase(dto.getBirthCountry());
	}

}
