/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.config.DataSourceConfig
 *  it.sisal.reporting.wfit.config.DataSourceParams
 *  org.springframework.boot.context.properties.ConfigurationProperties
 *  org.springframework.context.annotation.Bean
 *  org.springframework.context.annotation.Configuration
 */
package it.sisal.reporting.wfit.config;

import it.sisal.reporting.wfit.config.DataSourceParams;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    @Bean(value={"dataSourceParamsBatch"})
    @ConfigurationProperties(value="app.datasource.batch")
    public DataSourceParams dataSourceParamsBatch() {
        return new DataSourceParams();
    }

    @Bean(value={"dataSourceParamsCore"})
    @ConfigurationProperties(value="app.datasource.core")
    public DataSourceParams dataSourceParamsCore() {
        return new DataSourceParams();
    }

    @Bean(value={"dataSourceParamsNpl"})
    @ConfigurationProperties(value="app.datasource.npl")
    public DataSourceParams dataSourceParamsNpl() {
        return new DataSourceParams();
    }
}

