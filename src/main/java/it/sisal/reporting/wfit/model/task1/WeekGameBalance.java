/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task1.WeekGameBalance
 */
package it.sisal.reporting.wfit.model.task1;

public class WeekGameBalance {
    private Integer year;
    private Integer week;

    public Integer getYear() {
        return this.year;
    }

    public Integer getWeek() {
        return this.week;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String toString() {
        return "WeekGameBalance(year=" + this.getYear() + ", week=" + this.getWeek() + ")";
    }
}

