package com.usermanager.atosusermanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TABLE_USER")
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "user_name", length = 100, nullable = false)
	private String userName;

	@Column(name = "birh_date", length = 100, nullable = false)
	private String birthdate;

	@Column(name = "birth_country", length = 100, nullable = false)
	private String birthCountry;

	@Column(name = "phone_number", nullable = false)
	private long phoneNumber;

	@Column(name = "gender", nullable = false)
	private String gender;

}
