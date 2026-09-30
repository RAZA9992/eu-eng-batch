/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.config.QueryTask0Config
 *  it.sisal.reporting.wfit.util.Utils
 *  org.springframework.boot.context.properties.ConfigurationProperties
 *  org.springframework.context.annotation.Configuration
 */
package it.sisal.reporting.wfit.config;

import it.sisal.reporting.wfit.util.Utils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(value="query.path.task0")
public class QueryTask0Config {
    private String check;
    private String result;
    private String merge;
    private String getDays;
    private Integer numDays;
    private Integer gameCode;

    public void setCheck(String check) throws java.io.IOException {
        this.check = Utils.getFileContentFromResource((String)check);
    }

    public void setResult(String result) throws java.io.IOException {
        this.result = Utils.getFileContentFromResource((String)result);
    }

    public void setMerge(String merge) throws java.io.IOException {
        this.merge = Utils.getFileContentFromResource((String)merge);
    }

    public void setGetDays(String getDays) throws java.io.IOException {
        this.getDays = Utils.getFileContentFromResource((String)getDays);
    }

    public void setNumDays(Integer numDays) {
        this.numDays = numDays;
    }

    public void setGameCode(Integer gameCode) {
        this.gameCode = gameCode;
    }

    public String getCheck() {
        return this.check;
    }

    public String getResult() {
        return this.result;
    }

    public String getMerge() {
        return this.merge;
    }

    public String getGetDays() {
        return this.getDays;
    }

    public Integer getNumDays() {
        return this.numDays;
    }

    public Integer getGameCode() {
        return this.gameCode;
    }

    public String toString() {
        return "QueryTask0Config(check=" + this.getCheck() + ", result=" + this.getResult() + ", merge=" + this.getMerge() + ", getDays=" + this.getGetDays() + ", numDays=" + this.getNumDays() + ", gameCode=" + this.getGameCode() + ")";
    }
}

