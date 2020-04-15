package com.reactiveworks.practice.dateandtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class DateAndTimeExample {

	public static void main(String[] args) {

		LocalDate birthdate = LocalDate.of(1997, 4, 4);
		//LocalDate dt=birthdate.format()
		LocalDateTime dt=LocalDateTime.now();
		LocalDate today = LocalDate.now();
		Period p = Period.between(birthdate, today);
		System.out.println(p.getYears() + " years " + p.getMonths() + " months " + p.getDays() + " days");

		//LocalDate date = LocalDate.parse("2014-03-18");
		// System.out.println(date.with(ChronoField.DAY_OF_MONTH));
		//System.out.printf("%d%d%d", date.getDayOfWeek(), date.getMonth(), date.getYear());

	}

}
