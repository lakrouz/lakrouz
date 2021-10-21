package com.usermanager.atosusermanager.outils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import org.springframework.stereotype.Service;

@Service
public class DateUtils {
	/**
	 * permet de calculer l'age
	 * 
	 * @param birthDate
	 * @param currentDate
	 * @return int
	 */
	public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
		if ((birthDate != null) && (currentDate != null)) {
			return Period.between(birthDate, currentDate).getYears();
		} else {
			return 0;
		}
	}

	/**
	 * convert Localedate au Stirng
	 * 
	 * @param localDate
	 * @param dtf
	 * @return String
	 */
	public String convertLocalDateToString(LocalDate localDate, DateTimeFormatter dtf) {
		return localDate == null ? null : localDate.format(dtf);
	}

	/**
	 * convert Stirng en LocalDate
	 * 
	 * @param date
	 * @param dtf
	 * @return LocalDate
	 */
	public LocalDate convertStringToLocalDate(String date, DateTimeFormatter dtf) {
		return date == null || "".equals(date) || "NULL".equals(date) ? null : LocalDate.parse(date, dtf.withResolverStyle(ResolverStyle.STRICT));
	}

}
