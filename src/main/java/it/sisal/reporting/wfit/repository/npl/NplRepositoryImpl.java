/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.config.QueryTask2Config
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.model.task2.Event
 *  it.sisal.reporting.wfit.model.task3.Win
 *  it.sisal.reporting.wfit.model.task4.Sale
 *  it.sisal.reporting.wfit.repository.npl.NplRepository
 *  it.sisal.reporting.wfit.repository.npl.NplRepositoryImpl
 *  it.sisal.reporting.wfit.rowmapper.task2.EventRowMapper
 *  it.sisal.reporting.wfit.rowmapper.task3.WinRowMapper
 *  it.sisal.reporting.wfit.rowmapper.task4.SaleRowMapper
 *  it.sisal.reporting.wfit.util.QueryParams
 *  org.springframework.jdbc.core.RowMapper
 *  org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
 *  org.springframework.stereotype.Repository
 */
package it.sisal.reporting.wfit.repository.npl;

import it.sisal.reporting.wfit.config.QueryTask2Config;
import it.sisal.reporting.wfit.model.task0.AccountingWeek;
import it.sisal.reporting.wfit.model.task2.Event;
import it.sisal.reporting.wfit.model.task3.Win;
import it.sisal.reporting.wfit.model.task4.Sale;
import it.sisal.reporting.wfit.repository.npl.NplRepository;
import it.sisal.reporting.wfit.rowmapper.task2.EventRowMapper;
import it.sisal.reporting.wfit.rowmapper.task3.WinRowMapper;
import it.sisal.reporting.wfit.rowmapper.task4.SaleRowMapper;
import it.sisal.reporting.wfit.util.QueryParams;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NplRepositoryImpl
implements NplRepository {
    private final NamedParameterJdbcTemplate nplJDBCTemplate;
    private final QueryTask2Config queryTask2Config;

    public List<Event> selectEvents(LocalDateTime lastMonday) {
        HashMap<String, LocalDateTime> queryParams = new HashMap<String, LocalDateTime>();
        queryParams.put(QueryParams.DATE_REF.getKey(), lastMonday);
        return this.nplJDBCTemplate.query(this.queryTask2Config.getResult(), queryParams, (RowMapper)new EventRowMapper());
    }

    public List<Win> selectWins(AccountingWeek accountingWeek, String query) {
        HashMap<String, LocalDateTime> queryParams = new HashMap<String, LocalDateTime>();
        queryParams.put(QueryParams.BEGINS_ON.getKey(), accountingWeek.getBeginsOn());
        queryParams.put(QueryParams.ENDS_ON.getKey(), accountingWeek.getEndsOn());
        return this.nplJDBCTemplate.query(query, queryParams, (RowMapper)new WinRowMapper());
    }

    public List<Sale> selectSale(AccountingWeek accountingWeek, String query) {
        HashMap<String, LocalDateTime> queryParams = new HashMap<String, LocalDateTime>();
        queryParams.put(QueryParams.BEGINS_ON.getKey(), accountingWeek.getBeginsOn());
        queryParams.put(QueryParams.ENDS_ON.getKey(), accountingWeek.getEndsOn());
        return this.nplJDBCTemplate.query(query, queryParams, (RowMapper)new SaleRowMapper());
    }

    public NplRepositoryImpl(NamedParameterJdbcTemplate nplJDBCTemplate, QueryTask2Config queryTask2Config) {
        this.nplJDBCTemplate = nplJDBCTemplate;
        this.queryTask2Config = queryTask2Config;
    }
}

