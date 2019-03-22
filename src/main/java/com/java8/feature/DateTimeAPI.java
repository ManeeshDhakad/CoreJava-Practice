package com.java8.feature;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


/*
New Date Time API are based on following concepts:
Immutable-value classes - New classes are immutable so they are thread safe. Developer doesn’t need to worry about concurrency issues in a multi-threaded application.
Domain-driven design – Previous APIs are not model their domain precisely. Fore example the Date() class was a wrapper around the number of milliseconds since 1970 but when we print it, it also represent a time zone.  The new classes model their domain very precisely.
Separation of chronologies. The new API allows people to work with different calendaring systems in order to support the needs of users in some areas of the world, such as Japan or Thailand, that don’t necessarily follow ISO-8601. 
LocalDate() & LocatTime& LocalDateTime classes
These classes are local in the sense that they represent date and time from the context of the observer i.e. uses the system calendar.  These classes can be used when there is no need of time zone context. For example a desktop application can use these two classes.
LocalDateTime is a composite class, which is a pairing of LocalDate and LocalTime.

 */
public class DateTimeAPI {
	
	public static void main(String[] args) {
		// Before java 8
		Date date = new Date(2007, 11, 13, 16, 40); // month starts from 0 to 11, 11 Means Dec, 
		System.out.println(date);
		
		TimeZone zone = TimeZone.getTimeZone("Asia/HongKong");
		System.out.println(zone);
		
		Calendar cal = new GregorianCalendar(zone);
		System.out.println(cal);
		
		DateFormat fm = new SimpleDateFormat("HH:mm z");
		String s = "";//fm.format(cal);
		System.out.println(s);
		
		/*Bugs in code before java 8
		1. Month start from 0 to 11
		2. Asia/Hong_Kong not accepted
		3. date not accepted in GregorianCalendar
		4. fm.format(cal) throws error
		*/
		
		//Before Java 8:
		// define the time 8 hours from now
		cal = Calendar.getInstance(); 
		cal.add(Calendar.HOUR, 8); 
		cal.getTime(); // actually returns a Date

		
		
		//Java 8:
		LocalTime now = LocalTime.now();
		LocalTime later = now.plusHours(8);
		System.out.println(later);
		
		//java.time.LocalDate class - represents a year-month-day date without time.
		LocalDate currentDate = LocalDate.now(); // the current date
		LocalDate tenthFeb2014 = LocalDate.of(2014, Month.FEBRUARY, 10); // 2014-02-10 
		LocalDate firstAug2014 = LocalDate.of(2014, 8, 1); // months values start at 1 (2014-08-01)
		LocalDate sixtyFifthDayOf2010 = LocalDate.ofYearDay(2010, 65); // the 65th day of 2010 (2010-03-06)

		// java.time.LocalTime – works wih times without date.
		LocalTime currentTime = LocalTime.now(); // current time
		LocalTime midday = LocalTime.of(12, 0); // 12:00
		LocalTime afterMidday = LocalTime.of(13, 30, 15); // 13:30:15
		LocalTime fromSecondsOfDay = LocalTime.ofSecondOfDay(12345); // 12345th second of day (03:25:45)
		
		//java.time.LocalDateTime - combines date and time in one class.
		LocalDateTime currentDateTime = LocalDateTime.now();// dates with times, e.g. 2014-02-18 19:08:37.950
		LocalDateTime secondAug2014 = LocalDateTime.of(2014, 10, 2, 12, 30);// 2014-10-02 12:30
		LocalDateTime christmas2014 = LocalDateTime.of(2014, Month.DECEMBER, 24, 12, 0);// 2014-12-24 12:00
		
		//By default LocalDate/Time classes use the system clock in the default time zone. This cab be changed by providing a time zone or an alternative Clock implementation:
		LocalTime currentTimeInLosAngeles = LocalTime.now(ZoneId.of("America/Los_Angeles"));//local time in Los Aneles
		LocalTime nowInUtc = LocalTime.now(Clock.systemUTC());// current time in UTC time zone

	}
}
