/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.config.QueryTask4Config
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
@ConfigurationProperties(value="query.path.task4")
public class QueryTask4Config {
    private String check;
    private String salesByEvent;
    private String salesBySubscription;
    private String salesBySubscriptionDeduction;
    private String mergeWeekBalance;
    private String mergeWeekAggregate;
    private String update;
    private List<Integer> typeSalesCode;

    public void setCheck(String check) throws java.io.IOException {
        this.check = Utils.getFileContentFromResource((String)check);
    }

    public void setSalesByEvent(String salesByEvent) throws java.io.IOException {
        this.salesByEvent = Utils.getFileContentFromResource((String)salesByEvent);
    }

    public void setSalesBySubscription(String salesBySubscription) throws java.io.IOException {
        this.salesBySubscription = Utils.getFileContentFromResource((String)salesBySubscription);
    }

    public void setSalesBySubscriptionDeduction(String salesBySubscriptionDeduction) throws java.io.IOException {
        this.salesBySubscriptionDeduction = Utils.getFileContentFromResource((String)salesBySubscriptionDeduction);
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

    public String getSalesByEvent() {
        return this.salesByEvent;
    }

    public String getSalesBySubscription() {
        return this.salesBySubscription;
    }

    public String getSalesBySubscriptionDeduction() {
        return this.salesBySubscriptionDeduction;
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

    public List<Integer> getTypeSalesCode() {
        return this.typeSalesCode;
    }

    public void setTypeSalesCode(List<Integer> typeSalesCode) {
        this.typeSalesCode = typeSalesCode;
    }

    public String toString() {
        return "QueryTask4Config(check=" + this.getCheck() + ", salesByEvent=" + this.getSalesByEvent() + ", salesBySubscription=" + this.getSalesBySubscription() + ", salesBySubscriptionDeduction=" + this.getSalesBySubscriptionDeduction() + ", mergeWeekBalance=" + this.getMergeWeekBalance() + ", mergeWeekAggregate=" + this.getMergeWeekAggregate() + ", update=" + this.getUpdate() + ", typeSalesCode=" + String.valueOf(this.getTypeSalesCode()) + ")";
    }
}

