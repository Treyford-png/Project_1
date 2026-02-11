package edu.bsu.cs222;
import org.junit.jupiter.api.Test;
// 2024
// 2025
// 2026
// 2000
// 1900
// 0
// non int input
public class TimeTest {
    String correctString = "2025-11-22";
    String invalidYear = "1997-11-22";
    String wrongFormat = "11-22-202";
    String empty = null;

    @Test
    public void testCaseCorrect() {
        assert Date.getYear(correctString) == 2025;
        assert Date.getMonth(correctString) == 11;
        assert Date.getDay(correctString) == 22;
        assert !Date.checkInvalidFormat(correctString);
        assert Date.checkYear(correctString);
        assert Date.checkMonth(correctString);
        assert Date.checkDay(correctString);
    }

    @Test
    public void testCaseInvalidYear() {
        assert Date.getYear(invalidYear) == 1997;
        assert Date.getMonth(invalidYear) == 11;
        assert Date.getDay(invalidYear) == 22;
        assert !Date.checkInvalidFormat(invalidYear);
        assert !Date.checkYear(invalidYear);
        assert Date.checkMonth(invalidYear);
        assert Date.checkDay(invalidYear);
    }

    @Test
    public void testCaseWrongFormat() {
        assert Date.checkInvalidFormat(wrongFormat);
        assert Date.getYear(wrongFormat) == -1;
        assert Date.getMonth(wrongFormat) == -1;
        assert Date.getDay(wrongFormat) == -1;
        assert !Date.checkYear(wrongFormat);
        assert !Date.checkMonth(wrongFormat);
        assert !Date.checkDay(wrongFormat);
    }

    @Test
    public void testCaseEmpty() {
        assert Date.getYear(empty) == -1;
        assert Date.getMonth(empty) == -1;
        assert Date.getDay(empty) == -1;
        assert Date.checkInvalidFormat(empty);
        assert !Date.checkYear(empty);
        assert !Date.checkMonth(empty);
        assert !Date.checkDay(empty);
    }
}