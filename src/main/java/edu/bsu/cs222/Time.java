package edu.bsu.cs222;

/**
 * Checks the validity of a time string to detect corruption
 * format: hh:mm:ssZ (Z represents UTC)
 *
 * @author Holden Hankins
 * @author Treyford Mercer
 * @version 0.1.0
 */
public class Time {

    /**
     * Helper method which helps create a 2-digit number from 2 consecutive ints
     */
    public static int timeCalc(int tens, int ones) {
        return (tens * 10) + ones;
    }

    /**
     * Getter methods (used for validity checking)
     * All call checkFormat() first to prevent errors
     * If an error is found, -1 is returned
     * NOTE: -1 is NOT a magic number as it is commonplace to use for error detection in industry
     */

    public static int getHours(String time) {
        if (!checkFormat(time)) {
            return -1;
        }

        // [0][1]:__:__Z
        return (timeCalc(time.charAt(0) - '0', time.charAt(1)) - '0');
    }

    public static int getMinutes(String time) {
        if (!checkFormat(time)) {
            return -1;
        }

        // __:[3][4]:__Z
        return (timeCalc(time.charAt(3) - '0', time.charAt(4)) - '0');
    }

    public static int getSeconds(String time) {
        if (!checkFormat(time)) {
            return -1;
        }

        // __:__:[6][7]Z
        return (timeCalc(time.charAt(6) - '0', time.charAt(7)) - '0');
    }


    /**
     * Checker methods
     * Verify string is in format "[hours1][hours2]:[minutes1][minutes2]:[seconds1][seconds2]Z"
     * 0 <= hours <= 24
     * 0 <= minutes <= 60
     * 0 <= seconds <= 60
     */

    public static boolean checkFormat(String time) {
        // Checks errors in this order to prevent overflow errors
        if (time == null) {
            return false;
        }
        else if (time.length() != 9) {
            return false;
        }
        else return time.charAt(2) == ':' && time.charAt(5) == ':' && time.charAt(8) == 'Z';
    }

    public static boolean checkHours(String time) {
        int hours = getHours(time);
        return hours >= 0 && hours <= 24;
    }

    public static boolean checkMinutes(String time) {
        int minutes = getMinutes(time);
        return minutes >= 0 && minutes <= 60;
    }

    public static boolean checkSeconds(String time) {
        int seconds = getSeconds(time);
        return seconds >= 0 && seconds <= 60;
    }

    /**
     * Primary method, which runs all checks in class
     * @param time, contained in a String
     * @return validity of time
     */
    public static boolean checkTime(String time) {
        // checFormat() is ran in each get method
        return checkHours(time) && checkMinutes(time) && checkSeconds(time);
    }
}