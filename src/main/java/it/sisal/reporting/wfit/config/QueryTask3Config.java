/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.config.QueryTask3Config
 *  it.sisal.reporting.wfit.util.Utils
 *  org.springframework.boot.context.properties.ConfigurationProperties
 *  org.springframework.context.annotation.Configuration
 */
package it.sisal.reporting.wfit.config;

import it.sisal.reporting.wfit.util.Utils;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(value="query.path.task3")
public class QueryTask3Config {
    private String check;
    private String winsForPoints;
    private String winsInstant;
    private String mergeWeekBalance;
    private String mergeWeekAggregate;
    private String update;
    private List<Integer> typeWinsCode;

    public void setCheck(String check) throws java.io.IOException {
        this.check = Utils.getFileContentFromResource((String)check);
    }

    public void setWinsForPoints(String winsForPoints) throws java.io.IOException {
        this.winsForPoints = Utils.getFileContentFromResource((String)winsForPoints);
    }

    public void setWinsInstant(String winsInstant) throws java.io.IOException {
        this.winsInstant = Utils.getFileContentFromResource((String)winsInstant);
    }

    public void setMergeWeekBalance(String mergeWeekBalance) throws java.io.IOException {
        this.mergeWeekBalance = Utils.getFileContentFromResource((String)mergeWeekBalance);
    }

    public void setMergeWeekAggregate(String mergeWeekAggregate) throws java.io.IOException {
        this.mergeWeekAggregate = Utils.getFileContentFromResource((String)mergeWeekAggregate);
    }

    public void setUpdate(String update) throws java.io.IOException {
        this.update = Utils.getFileContentFromResource((String)update);
    }

    public String getCheck() {
        return this.check;
    }

    public String getWinsForPoints() {
        return this.winsForPoints;
    }

    public String getWinsInstant() {
        return this.winsInstant;
    }

    public String getMergeWeekBalance() {
        return this.mergeWeekBalance;
    }

    public String getMergeWeekAggregate() {
        return this.mergeWeekAggregate;
    }

    public String getUpdate() {
        return this.update;
    }

    public List<Integer> getTypeWinsCode() {
        return this.typeWinsCode;
    }

    public void setTypeWinsCode(List<Integer> typeWinsCode) {
        this.typeWinsCode = typeWinsCode;
    }

    public String toString() {
        return "QueryTask3Config(check=" + this.getCheck() + ", winsForPoints=" + this.getWinsForPoints() + ", winsInstant=" + this.getWinsInstant() + ", mergeWeekBalance=" + this.getMergeWeekBalance() + ", mergeWeekAggregate=" + this.getMergeWeekAggregate() + ", update=" + this.getUpdate() + ", typeWinsCode=" + String.valueOf(this.getTypeWinsCode()) + ")";
    }
}

