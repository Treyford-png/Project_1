package edu.bsu.cs222;

public class WikiEdit {
    private String username;
    private String date; // yyyy/mm/dd
    private String time; // hh/mm/ssZ (UTC)

    public WikiEdit() {
        username = null;
        date = "0000-00-00";
        time = "00-00-00Z";
    }

    public WikiEdit(String username, String date, String time) {
        this.username = username;
        this.date = date;
        this.time = time;
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

    public String getOutput() {
        return date + " " + time + "Z  " + username + "\n";
    }
}