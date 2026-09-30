/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.BaseAggregate
 */
package it.sisal.reporting.wfit.model;

public abstract class BaseAggregate {
    private Integer year;
    private Integer number;
    private String zoneCode;
    private Integer resellerNumber;

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public void setResellerNumber(Integer resellerNumber) {
        this.resellerNumber = resellerNumber;
    }

    public Integer getYear() {
        return this.year;
    }

    public Integer getNumber() {
        return this.number;
    }

    public String getZoneCode() {
        return this.zoneCode;
    }

    public Integer getResellerNumber() {
        return this.resellerNumber;
    }

    public String toString() {
        return "BaseAggregate(year=" + this.getYear() + ", number=" + this.getNumber() + ", zoneCode=" + this.getZoneCode() + ", resellerNumber=" + this.getResellerNumber() + ")";
    }
}

