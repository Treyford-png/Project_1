package edu.bsu.cs222;

/**
 * Contains methods to
 * 1. Validate if a date string is a valid date
 * 2. Parses a formatted string (yyyy-mm-dd) into appropriate int values
 *
 * @author Holden Hankins
 * @version 4 February 2026
 */
public class Date {

    /**
     * Following 3 methods all work to parse a string containing a date (hopefully) formatted yyyy-mm-dd
     * Overflow errors resolved, but formatting errors handled in check functions
     * Errors throw -1 return value
     */


    public static int getYear(String date) {
        // Error prevention
        if (date == null) {
            return -1;
        }
        if (checkInvalidFormat(date)) {
            return -1;
        }

        // Converts int int int int to 4 digit year
        return  (date.charAt(0) - '0') * 1000 +
                (date.charAt(1) - '0') * 100 +
                (date.charAt(2) - '0') * 10 +
                (date.charAt(3) - '0');
    }

    public static int getMonth(String date) {
        // Error prevention
        if (date == null) {
            return -1;
        }
        if (checkInvalidFormat(date)) {
            return -1;
        }
        return ((date.charAt(5) - '0') * 10) + (date.charAt(6) - '0');
    }

    public static int getDay(String date) {
        // Error prevention
        if (date == null) {
            return -1;
        }
        if (checkInvalidFormat(date)) {
            return -1;
        }

        return ((date.charAt(8) - '0') * 10) + (date.charAt(9) - '0');
    }

    /**
     * Verifies a string is in the format yyyy-dd-mm
     */
    public static boolean checkInvalidFormat(String date) {
        if (date == null) {
            return true;
        }
        if (date.length() != 10) { // Prevents overflow errors
            return true;
        }
        return !(date.charAt(4) == '-' && date.charAt(7) == '-');
    }

    /**
     * Following 4 methods verify date is formatted, then check for validity of year, month, or day
     */

    public static boolean checkYear(String date) {
        // No need to check if empty as checkInvalidFormat does that for us
        if (checkInvalidFormat(date)) {
            return false;
        }

        // Wikipedia was founded in 2000
        // In the future, Change max year come new year
        int year = getYear(date);
        return year > 2000 && year < 2027;
    }

    public static boolean checkMonth(String date) {
        if (checkInvalidFormat(date)) {
            return false;
        }
        int month = getMonth(date);
        return month > 0 && month < 13;
    }

    public static boolean checkDay(String date) {
        if (checkInvalidFormat(date) || !checkMonth(date)) {
            return false;
        }

        int month = (((date.charAt(5) - '0') * 10) + (date.charAt(6) - '0'));
        int day = getDay(date);

        // Check if date is possible in given month
        if (month == 2) { // February edge case
            if (isLeapYear(getYear(date))) {
                return day > 0 && day < 30;
            }
            else {
                return day > 0 && day < 29;
            }
        }
        else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return day > 1 && day < 32;
        }
        return day > 0 && day < 31;
    }

    public static boolean isLeapYear(int i) {
        if (i < 0) {
            return false;
        }
        else if (i % 100 == 0) { // Special case for centurial years not divisible by 400
            return i % 400 == 0;
        }
        else { // All other years divisible by 4 are leap years
            return i % 4 == 0;
        }
    }

    /**
     * Runs all 4 checks above simultaneously
     * @param date String
     * @return if yyyy-mm-dd is possible
     */
    public static boolean validateDate(String date) {
        // Checks format separately to prevent errors
        if (checkInvalidFormat(date)) {
            return false;
        }

        return checkYear(date) && checkMonth(date) && checkDay(date);
    }
}