package com.example.myreservationapp.model.data;

import java.sql.Time;

public class Reservation {

    //integer Id
    private int id;
    //private Day day;
    private Time check_in_time;
    private Time check_out_time;
    private String check_in_date;
    private String check_out_date;

    public Reservation(int id, String check_in_time, String check_out_time, String check_in_date, String check_out_date) {
        this.id = id;
        this.check_in_time = check_in_time;
        this.check_out_time = check_out_time;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
    }

    public int getId() {
        return id;
    }

    public String getCheck_in_time() {
        return String.valueOf(check_in_time);
    }

    public void setCheck_in_time(Time check_in_time) {
        this.check_in_time = check_in_time;
    }

    public String getCheck_out_time() {
        return String.valueOf(check_out_time);
    }

    public void setCheck_out_time(Time check_out_time) {
        this.check_out_time = check_out_time;
    }

    public String getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(String check_in_date) {
        this.check_in_date = check_in_date;
    }

    public String getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(String check_out_date) {
        this.check_out_date = check_out_date;
    }
}
