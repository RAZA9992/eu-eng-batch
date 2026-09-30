/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task2.Event
 */
package it.sisal.reporting.wfit.model.task2;

import java.time.LocalDateTime;

public class Event {
    private Integer year;
    private Integer number;
    private LocalDateTime drawDate;

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setDrawDate(LocalDateTime drawDate) {
        this.drawDate = drawDate;
    }

    public Integer getYear() {
        return this.year;
    }

    public Integer getNumber() {
        return this.number;
    }

    public LocalDateTime getDrawDate() {
        return this.drawDate;
    }

    public String toString() {
        return "Event(year=" + this.getYear() + ", number=" + this.getNumber() + ", drawDate=" + String.valueOf(this.getDrawDate()) + ")";
    }
}

