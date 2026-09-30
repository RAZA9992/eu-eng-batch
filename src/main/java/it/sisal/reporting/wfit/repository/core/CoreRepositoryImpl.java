/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.config.QueryTask0Config
 *  it.sisal.reporting.wfit.exception.ReportingBatchException
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.repository.core.CoreRepository
 *  it.sisal.reporting.wfit.repository.core.CoreRepositoryImpl
 *  it.sisal.reporting.wfit.rowmapper.task0.AccountingWeekRowMapper
 *  it.sisal.reporting.wfit.util.QueryParams
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Qualifier
 *  org.springframework.dao.EmptyResultDataAccessException
 *  org.springframework.jdbc.core.RowMapper
 *  org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
 *  org.springframework.stereotype.Repository
 */
package it.sisal.reporting.wfit.repository.core;

import it.sisal.reporting.wfit.config.QueryTask0Config;
import it.sisal.reporting.wfit.exception.ReportingBatchException;
import it.sisal.reporting.wfit.model.task0.AccountingWeek;
import it.sisal.reporting.wfit.repository.core.CoreRepository;
import it.sisal.reporting.wfit.rowmapper.task0.AccountingWeekRowMapper;
import it.sisal.reporting.wfit.util.QueryParams;
import java.time.LocalDateTime;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CoreRepositoryImpl
implements CoreRepository {
    private static final Logger log = LoggerFactory.getLogger(CoreRepositoryImpl.class);
    private final NamedParameterJdbcTemplate coreJDBCTemplate;
    private final QueryTask0Config queryTask0Config;

    public CoreRepositoryImpl(@Qualifier(value="coreJDBCTemplate") NamedParameterJdbcTemplate coreJDBCTemplate, QueryTask0Config queryTask0Config) {
        this.coreJDBCTemplate = coreJDBCTemplate;
        this.queryTask0Config = queryTask0Config;
    }

    public AccountingWeek selectAccountingWeek(LocalDateTime lastMonday) {
        HashMap<String, LocalDateTime> queryParams = new HashMap<String, LocalDateTime>();
        queryParams.put(QueryParams.I_DATE_REF.getKey(), lastMonday);
        log.debug("Retrieve accounting week of last week for create in DB destination");
        try {
            return (AccountingWeek)this.coreJDBCTemplate.queryForObject(this.queryTask0Config.getResult(), queryParams, (RowMapper)new AccountingWeekRowMapper());
        }
        catch (EmptyResultDataAccessException e) {
            throw new ReportingBatchException("Can't retrieve information for create Accounting week from CORE DB");
        }
    }
}

