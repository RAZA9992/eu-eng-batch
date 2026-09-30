/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  org.springframework.cache.annotation.CacheConfig
 */
package it.sisal.reporting.wfit.model.task0;

import java.time.LocalDateTime;
import org.springframework.cache.annotation.CacheConfig;

@CacheConfig(cacheNames={"accountingWeek"})
public class AccountingWeek {
    private Integer year;
    private Integer week;
    private LocalDateTime beginsOn;
    private LocalDateTime endsOn;

    public Integer getYear() {
        return this.year;
    }

    public Integer getWeek() {
        return this.week;
    }

    public LocalDateTime getBeginsOn() {
        return this.beginsOn;
    }

    public LocalDateTime getEndsOn() {
        return this.endsOn;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public void setBeginsOn(LocalDateTime beginsOn) {
        this.beginsOn = beginsOn;
    }

    public void setEndsOn(LocalDateTime endsOn) {
        this.endsOn = endsOn;
    }

    public String toString() {
        return "AccountingWeek(year=" + this.getYear() + ", week=" + this.getWeek() + ", beginsOn=" + String.valueOf(this.getBeginsOn()) + ", endsOn=" + String.valueOf(this.getEndsOn()) + ")";
    }
}

