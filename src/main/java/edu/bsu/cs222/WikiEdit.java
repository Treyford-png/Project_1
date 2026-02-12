package edu.bsu.cs222;
import java.util.Objects;

/**
 * Stores information retaining a revision made to a Wikipedia article
 * Information stored is username, date (validated in Date), and time (validated in Time)
 *
 * @author Holden Hankins
 * @author Treyford Mercer
 * @version 0.1.0
 */
public class WikiEdit {
    private String username;
    private String date; // yyyy/mm/dd
    private String time; // hh/mm/ssZ (UTC)
    private boolean exists; // Used to determine end of documented edits

    public WikiEdit() {
        username = null;
        date = "0000-00-00";
        time = "00-00-00Z";
        exists = false;
    }

    public WikiEdit(String username, String date, String time) {
        this.username = Objects.requireNonNullElse(username, "[Warning: blank or corrupted Username]");

        if (!Date.validateDate(date)) {
            this.date = "[Warning: invalid or corrupted date]";
        }
        else {
            this.date = date;
        }

        if (!Time.checkTime(time)) {
            this.time = "[Warning: invalid or corrupted time]";
        }
        else {
            this.time = time;
        }

        exists = true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setToExists() {
        exists = true;
    }

    public void setAll(String username, String date, String time) {
        setUsername(username);
        setDate(date);
        setTime(time);
        exists = true;
    }

    public boolean doesExists() {
        return exists;
    }

    public String getOutput() {
        return date + " " + time + "  " + username;
    }

}