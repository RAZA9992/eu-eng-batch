/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.config.QueryTask5Config
 *  it.sisal.reporting.wfit.util.Utils
 *  org.springframework.boot.context.properties.ConfigurationProperties
 *  org.springframework.context.annotation.Configuration
 */
package it.sisal.reporting.wfit.config;

import it.sisal.reporting.wfit.util.Utils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(value="query.path.task5")
public class QueryTask5Config {
    private String statusUpdate;
    private String delDays;

    public void setStatusUpdate(String statusUpdate) throws java.io.IOException {
        this.statusUpdate = Utils.getFileContentFromResource((String)statusUpdate);
    }

    public void setDelDays(String delDays) throws java.io.IOException {
        this.delDays = Utils.getFileContentFromResource((String)delDays);
    }

    public String getStatusUpdate() {
        return this.statusUpdate;
    }

    public String getDelDays() {
        return this.delDays;
    }

    public String toString() {
        return "QueryTask5Config(statusUpdate=" + this.getStatusUpdate() + ", delDays=" + this.getDelDays() + ")";
    }
}

