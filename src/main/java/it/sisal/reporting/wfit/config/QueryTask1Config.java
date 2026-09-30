/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.config.QueryTask1Config
 *  it.sisal.reporting.wfit.util.Utils
 *  org.springframework.boot.context.properties.ConfigurationProperties
 *  org.springframework.context.annotation.Configuration
 */
package it.sisal.reporting.wfit.config;

import it.sisal.reporting.wfit.util.Utils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(value="query.path.task1")
public class QueryTask1Config {
    private String awResult;
    private String gameResult;
    private String wbsResult;
    private String merge;
    private String gameDescr;
    private String statusDescr;

    public void setAwResult(String awResult) throws java.io.IOException {
        this.awResult = Utils.getFileContentFromResource((String)awResult);
    }

    public void setGameResult(String gameResult) throws java.io.IOException {
        this.gameResult = Utils.getFileContentFromResource((String)gameResult);
    }

    public void setWbsResult(String wbsResult) throws java.io.IOException {
        this.wbsResult = Utils.getFileContentFromResource((String)wbsResult);
    }

    public void setMerge(String merge) throws java.io.IOException {
        this.merge = Utils.getFileContentFromResource((String)merge);
    }

    public void setGameDescr(String gameDescr) {
        this.gameDescr = gameDescr;
    }

    public void setStatusDescr(String statusDescr) {
        this.statusDescr = statusDescr;
    }

    public String getAwResult() {
        return this.awResult;
    }

    public String getGameResult() {
        return this.gameResult;
    }

    public String getWbsResult() {
        return this.wbsResult;
    }

    public String getMerge() {
        return this.merge;
    }

    public String getGameDescr() {
        return this.gameDescr;
    }

    public String getStatusDescr() {
        return this.statusDescr;
    }

    public String toString() {
        return "QueryTask1Config(awResult=" + this.getAwResult() + ", gameResult=" + this.getGameResult() + ", wbsResult=" + this.getWbsResult() + ", merge=" + this.getMerge() + ", gameDescr=" + this.getGameDescr() + ", statusDescr=" + this.getStatusDescr() + ")";
    }
}

