/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.config.DataSourceParams
 *  it.sisal.reporting.wfit.config.OracleConfig
 *  oracle.ucp.jdbc.PoolDataSource
 *  oracle.ucp.jdbc.PoolDataSourceFactory
 *  org.springframework.beans.factory.annotation.Qualifier
 *  org.springframework.context.annotation.Bean
 *  org.springframework.context.annotation.Configuration
 *  org.springframework.context.annotation.Primary
 *  org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
 *  org.springframework.jdbc.datasource.DataSourceTransactionManager
 *  org.springframework.transaction.PlatformTransactionManager
 */
package it.sisal.reporting.wfit.config;

import it.sisal.reporting.wfit.config.DataSourceParams;
import javax.sql.DataSource;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/*
 * Exception performing whole class analysis ignored.
 */
@Configuration
public class OracleConfig {
    @Primary
    @Bean(name={"batch"})
    public DataSource ucpDataSourceBatch(@Qualifier(value="dataSourceParamsBatch") DataSourceParams dataSourceParams) throws java.sql.SQLException {
        return OracleConfig.getPoolDataSource((DataSourceParams)dataSourceParams);
    }

    @Bean(name={"core"})
    public DataSource ucpDataSourceCore(@Qualifier(value="dataSourceParamsCore") DataSourceParams dataSourceParams) throws java.sql.SQLException {
        return OracleConfig.getPoolDataSource((DataSourceParams)dataSourceParams);
    }

    @Bean(name={"npl"})
    public DataSource ucpDataSourceNpl(@Qualifier(value="dataSourceParamsNpl") DataSourceParams dataSourceParams) throws java.sql.SQLException {
        return OracleConfig.getPoolDataSource((DataSourceParams)dataSourceParams);
    }

    @Primary
    @Bean(value={"txManagerBatch"})
    public PlatformTransactionManager txManagerOnline(@Qualifier(value="batch") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(value={"batchJDBCTemplate"})
    public NamedParameterJdbcTemplate jdbcTemplateBatch(@Qualifier(value="batch") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean(value={"coreJDBCTemplate"})
    public NamedParameterJdbcTemplate jdbcTemplateCore(@Qualifier(value="core") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean(value={"nplJDBCTemplate"})
    public NamedParameterJdbcTemplate jdbcTemplateNpl(@Qualifier(value="npl") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    private static PoolDataSource getPoolDataSource(DataSourceParams dataSourceParams) throws java.sql.SQLException {
        PoolDataSource poolDataSource = PoolDataSourceFactory.getPoolDataSource();
        poolDataSource.setURL(dataSourceParams.getUrl());
        poolDataSource.setUser(dataSourceParams.getUsername());
        poolDataSource.setPassword(dataSourceParams.getPassword());
        poolDataSource.setConnectionFactoryClassName(dataSourceParams.getType());
        poolDataSource.setConnectionPoolName(dataSourceParams.getName());
        poolDataSource.setInitialPoolSize(dataSourceParams.getInitPoolSize());
        poolDataSource.setMinPoolSize(dataSourceParams.getMinPoolSize());
        poolDataSource.setMaxPoolSize(dataSourceParams.getMaxPoolSize());
        poolDataSource.setInactiveConnectionTimeout(dataSourceParams.getTimeInterval());
        poolDataSource.setMaxStatements(dataSourceParams.getMaxStatements());
        poolDataSource.setValidateConnectionOnBorrow(true);
        return poolDataSource;
    }
}

