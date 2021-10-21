package com.usermanager.atosusermanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private long id;

	private String userName;
	private String birthDate;
	private String birthCountry;
	private long phoneNumber;
	private String gender;

}
