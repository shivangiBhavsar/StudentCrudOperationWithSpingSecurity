package com.studentrestapi.Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Dates
{
	    public static String getCurrentDate() {
	    LocalDateTime currentDateTime = LocalDateTime.now();

        // Define the desired date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        // Format the current date and time using the defined formatter
        String formattedDateTime = currentDateTime.format(formatter);
		return formattedDateTime;
	    }

}
