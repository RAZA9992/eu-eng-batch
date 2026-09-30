/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.config.DataSourceParams
 */
package it.sisal.reporting.wfit.config;

public class DataSourceParams {
    private String url;
    private String username;
    private String password;
    private String type;
    private int initPoolSize;
    private int minPoolSize;
    private int maxPoolSize;
    private String name;
    private int timeInterval;
    private int maxStatements;

    public String getUrl() {
        return this.url;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getType() {
        return this.type;
    }

    public int getInitPoolSize() {
        return this.initPoolSize;
    }

    public int getMinPoolSize() {
        return this.minPoolSize;
    }

    public int getMaxPoolSize() {
        return this.maxPoolSize;
    }

    public String getName() {
        return this.name;
    }

    public int getTimeInterval() {
        return this.timeInterval;
    }

    public int getMaxStatements() {
        return this.maxStatements;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setInitPoolSize(int initPoolSize) {
        this.initPoolSize = initPoolSize;
    }

    public void setMinPoolSize(int minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }

    public void setMaxStatements(int maxStatements) {
        this.maxStatements = maxStatements;
    }

    public String toString() {
        return "DataSourceParams(url=" + this.getUrl() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", type=" + this.getType() + ", initPoolSize=" + this.getInitPoolSize() + ", minPoolSize=" + this.getMinPoolSize() + ", maxPoolSize=" + this.getMaxPoolSize() + ", name=" + this.getName() + ", timeInterval=" + this.getTimeInterval() + ", maxStatements=" + this.getMaxStatements() + ")";
    }
}

