package edu.bsu.cs222;

import org.junit.jupiter.api.Test;

public class DateTest {
    String correctString = "01:11:59Z";
    String invalidHour = "25:11:59Z";
    String invalidMinute = "01:65:59Z";
    String invalidSecond = "01:11:65Z";
    String invalidTimezone = "01:11:59T";
    String wrongFormat = "0:111:65Z";
    String wrongSize = "0:111:65";
    String empty = "null";
    @Test
    public void testCaseCorrect() {
        // All Correct
        assert(Time.getHours(correctString) == 1);
        assert(Time.getMinutes(correctString) == 11);
        assert(Time.getSeconds(correctString) == 59);
        assert(Time.checkFormat(correctString));
        assert(Time.checkHours(correctString));
        assert(Time.checkMinutes(correctString));
        assert(Time.checkSeconds(correctString));
        assert(Time.checkTime(correctString));
    }

    @Test
    public void testCaseInvalidHour() {
        assert(Time.getHours(invalidHour) == 25);
        assert(Time.getMinutes(invalidHour) == 11);
        assert(Time.getSeconds(invalidHour) == 59);
        assert(Time.checkFormat(invalidHour));
        assert(!Time.checkHours(invalidHour)); // Checking hours
        assert(Time.checkMinutes(invalidHour));
        assert(Time.checkSeconds(invalidHour));
        assert(!Time.checkTime(invalidHour)); // Checking time
    }

    @Test
    public void testCaseInvalidMinute() {
        assert(Time.getHours(invalidMinute) == 1);
        assert(Time.getMinutes(invalidMinute) == 65);
        assert(Time.getSeconds(invalidMinute) == 59);
        assert(Time.checkFormat(invalidMinute));
        assert(Time.checkHours(invalidMinute));
        assert(!Time.checkMinutes(invalidMinute)); // Checking minutes
        assert(Time.checkSeconds(invalidMinute));
        assert(!Time.checkTime(invalidMinute)); // Checking time
    }

    @Test
    public void testCaseInvalidSecond() {
        assert(Time.getHours(invalidSecond) == 1);
        assert(Time.getMinutes(invalidSecond) == 11);
        assert(Time.getSeconds(invalidSecond) == 65);
        assert(Time.checkFormat(invalidSecond));
        assert(Time.checkHours(invalidSecond));
        assert(Time.checkMinutes(invalidSecond));
        assert(!Time.checkSeconds(invalidSecond)); // Checking seconds
        assert(!Time.checkTime(invalidSecond)); // Checking time
    }

    @Test
    public void testCaseInvalidTimezone() {
        // All invalid
        assert(Time.getHours(invalidTimezone) == -1);
        assert(Time.getMinutes(invalidTimezone) == -1);
        assert(Time.getSeconds(invalidTimezone) == -1);
        assert(!Time.checkFormat(invalidTimezone));
        assert(!Time.checkHours(invalidTimezone));
        assert(!Time.checkMinutes(invalidTimezone));
        assert(!Time.checkSeconds(invalidTimezone));
        assert(!Time.checkTime(invalidTimezone));
    }

    @Test
    public void testCaseWrongFormat() {
        // All invalid
        assert(Time.getHours(wrongFormat) == -1);
        assert(Time.getMinutes(wrongFormat) == -1);
        assert(Time.getSeconds(wrongFormat) == -1);
        assert(!Time.checkFormat(wrongFormat));
        assert(!Time.checkHours(wrongFormat));
        assert(!Time.checkMinutes(wrongFormat));
        assert(!Time.checkSeconds(wrongFormat));
        assert(!Time.checkTime(wrongFormat));
    }

    @Test
    public void testCaseWrongSize() {
        // All invalid
        assert(Time.getHours(wrongSize) == -1);
        assert(Time.getMinutes(wrongSize) == -1);
        assert(Time.getSeconds(wrongSize) == -1);
        assert(!Time.checkFormat(wrongSize));
        assert(!Time.checkHours(wrongSize));
        assert(!Time.checkMinutes(wrongSize));
        assert(!Time.checkSeconds(wrongSize));
        assert(!Time.checkTime(wrongSize));
    }

    @Test
    public void testCaseEmpty() {
        // All invalid
        assert(Time.getHours(null) == -1);
        assert(Time.getMinutes(null) == -1);
        assert(Time.getSeconds(null) == -1);
        assert(!Time.checkFormat(null));
        assert(!Time.checkHours(null));
        assert(!Time.checkMinutes(null));
        assert(!Time.checkSeconds(null));
        assert(!Time.checkTime(null));
    }
}