package com.example.myreservationapp.model.data;

import java.util.Date;

public class Invoice {
    private int invoice_id;
    private double balanceDue;
    private Date date;

    public Invoice(int invoice_id, double balanceDue, Date date) {
        this.invoice_id = invoice_id;
        this.balanceDue = balanceDue;
        this.date = date;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public double getBalance_due() {
        return balanceDue;
    }

    public void setBalance_due(double balanceDue) {
        this.balanceDue = balanceDue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
