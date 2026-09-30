/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.config.QueryTask2Config
 *  it.sisal.reporting.wfit.util.Utils
 *  org.springframework.boot.context.properties.ConfigurationProperties
 *  org.springframework.context.annotation.Configuration
 */
package it.sisal.reporting.wfit.config;

import it.sisal.reporting.wfit.util.Utils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(value="query.path.task2")
public class QueryTask2Config {
    private String result;
    private String merge;

    public void setResult(String result) throws java.io.IOException {
        this.result = Utils.getFileContentFromResource((String)result);
    }

    public void setMerge(String merge) throws java.io.IOException {
        this.merge = Utils.getFileContentFromResource((String)merge);
    }

    public String getResult() {
        return this.result;
    }

    public String getMerge() {
        return this.merge;
    }

    public String toString() {
        return "QueryTask2Config(result=" + this.getResult() + ", merge=" + this.getMerge() + ")";
    }
}

