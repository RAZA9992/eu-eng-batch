/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.config.QueryTask0Config
 *  it.sisal.reporting.wfit.config.QueryTask1Config
 *  it.sisal.reporting.wfit.config.QueryTask2Config
 *  it.sisal.reporting.wfit.config.QueryTask3Config
 *  it.sisal.reporting.wfit.config.QueryTask4Config
 *  it.sisal.reporting.wfit.config.QueryTask5Config
 *  it.sisal.reporting.wfit.exception.ReportingBatchException
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.model.task1.WeekGameBalance
 *  it.sisal.reporting.wfit.model.task2.Event
 *  it.sisal.reporting.wfit.model.task3.Win
 *  it.sisal.reporting.wfit.model.task4.Sale
 *  it.sisal.reporting.wfit.repository.batch.BatchRepository
 *  it.sisal.reporting.wfit.repository.batch.BatchRepositoryImpl
 *  it.sisal.reporting.wfit.rowmapper.task0.AccountingWeekRowMapper
 *  it.sisal.reporting.wfit.rowmapper.task1.WeekGameBalanceRowMapper
 *  it.sisal.reporting.wfit.util.QueryParams
 *  it.sisal.reporting.wfit.util.Utils
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Qualifier
 *  org.springframework.dao.EmptyResultDataAccessException
 *  org.springframework.jdbc.core.RowMapper
 *  org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
 *  org.springframework.stereotype.Repository
 *  org.springframework.transaction.annotation.Transactional
 */
package it.sisal.reporting.wfit.repository.batch;

import it.sisal.reporting.wfit.config.QueryTask0Config;
import it.sisal.reporting.wfit.config.QueryTask1Config;
import it.sisal.reporting.wfit.config.QueryTask2Config;
import it.sisal.reporting.wfit.config.QueryTask3Config;
import it.sisal.reporting.wfit.config.QueryTask4Config;
import it.sisal.reporting.wfit.config.QueryTask5Config;
import it.sisal.reporting.wfit.exception.ReportingBatchException;
import it.sisal.reporting.wfit.model.task0.AccountingWeek;
import it.sisal.reporting.wfit.model.task1.WeekGameBalance;
import it.sisal.reporting.wfit.model.task2.Event;
import it.sisal.reporting.wfit.model.task3.Win;
import it.sisal.reporting.wfit.model.task4.Sale;
import it.sisal.reporting.wfit.repository.batch.BatchRepository;
import it.sisal.reporting.wfit.rowmapper.task0.AccountingWeekRowMapper;
import it.sisal.reporting.wfit.rowmapper.task1.WeekGameBalanceRowMapper;
import it.sisal.reporting.wfit.util.QueryParams;
import it.sisal.reporting.wfit.util.Utils;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.PreparedStatement;
import java.util.*;

/*
 * Exception performing whole class analysis ignored.
 */
@Repository
public class BatchRepositoryImpl
implements BatchRepository {
    private static final Logger log = LoggerFactory.getLogger(BatchRepositoryImpl.class);
    public static final String TERMINATED_WITH_ERROR = "Execution terminated with error [{}]";
    private final NamedParameterJdbcTemplate batchJDBCTemplate;
    private final Integer gameCode;
    private final QueryTask0Config queryTask0Config;
    private final QueryTask1Config queryTask1Config;
    private final QueryTask2Config queryTask2Config;
    private final QueryTask3Config queryTask3Config;
    private final QueryTask4Config queryTask4Config;
    private final QueryTask5Config queryTask5Config;

    public BatchRepositoryImpl(@Qualifier(value="batchJDBCTemplate") NamedParameterJdbcTemplate batchJDBCTemplate, QueryTask0Config queryTask0Config, QueryTask1Config queryTask1Config, QueryTask2Config queryTask2Config, QueryTask3Config queryTask3Config, QueryTask4Config queryTask4Config, QueryTask5Config queryTask5Config) {
        this.batchJDBCTemplate = batchJDBCTemplate;
        this.gameCode = queryTask0Config.getGameCode();
        this.queryTask0Config = queryTask0Config;
        this.queryTask1Config = queryTask1Config;
        this.queryTask2Config = queryTask2Config;
        this.queryTask3Config = queryTask3Config;
        this.queryTask4Config = queryTask4Config;
        this.queryTask5Config = queryTask5Config;
    }

    public AccountingWeek selectAccountingControlWeek(LocalDateTime lastMonday) {
        HashMap<String, LocalDateTime> queryParams = new HashMap<String, LocalDateTime>();
        queryParams.put(QueryParams.DATE_REF.getKey(), lastMonday);
        log.debug("Retrieve accounting week of today for check");
        try {
            return (AccountingWeek)this.batchJDBCTemplate.queryForObject(this.queryTask0Config.getCheck(), queryParams, (RowMapper)new AccountingWeekRowMapper());
        }
        catch (EmptyResultDataAccessException e) {
            log.debug("This accounting week doesn't exist");
            return new AccountingWeek();
        }
    }

    public void mergeAccountingWeek(AccountingWeek accountingWeek) {
        HashMap<String, Object> queryParams = new HashMap<String, Object>();
        queryParams.put(QueryParams.YEAR_REF.getKey(), accountingWeek.getYear());
        queryParams.put(QueryParams.WEEK_REF.getKey(), accountingWeek.getWeek());
        queryParams.put(QueryParams.BEGINS_ON.getKey(), accountingWeek.getBeginsOn());
        queryParams.put(QueryParams.ENDS_ON.getKey(), accountingWeek.getEndsOn());
        log.debug("Insert new accounting week for year: [{}], and week: [{}]", (Object)accountingWeek.getYear(), (Object)accountingWeek.getWeek());
        int mergeAccountingWeek = this.batchJDBCTemplate.update(this.queryTask0Config.getMerge(), queryParams);
        if (1 != mergeAccountingWeek) {
            throw new ReportingBatchException("Failed to insert new accounting week");
        }
    }

    public WeekGameBalance selectWeekGameBalance(LocalDateTime lastMonday) {
        HashMap<String, LocalDateTime> queryParams = new HashMap<String, LocalDateTime>();
        queryParams.put(QueryParams.DATE_REF.getKey(), lastMonday);
        log.debug("Retrieve year and week for last week");
        try {
            return (WeekGameBalance)this.batchJDBCTemplate.queryForObject(this.queryTask1Config.getAwResult(), queryParams, (RowMapper)new WeekGameBalanceRowMapper());
        }
        catch (EmptyResultDataAccessException e) {
            throw new ReportingBatchException("Accounting week doesn't exist");
        }
    }

    public void mergeWeekGameBalance(WeekGameBalance weekGameBalance) {
        HashMap<String, Object> queryParams = new HashMap<String, Object>();
        queryParams.put(QueryParams.YEAR_REF.getKey(), weekGameBalance.getYear());
        queryParams.put(QueryParams.WEEK_REF.getKey(), weekGameBalance.getWeek());
        queryParams.put(QueryParams.GAME_CODE.getKey(), this.gameCode);
        queryParams.put(QueryParams.STATUS_CODE.getKey(), QueryParams.STATUS_CODE_CREATED.getKey());
        log.debug("Insert new week game balance with year: [{}] and week: [{}]", (Object)weekGameBalance.getYear(), (Object)weekGameBalance.getWeek());
        int mergeWeekGameBalance = this.batchJDBCTemplate.update(this.queryTask1Config.getMerge(), queryParams);
        log.debug("Insert week game balance entry with this result: [{}]", (Object)mergeWeekGameBalance);
    }

    public void insertEvents(List<Event> eventList) {
        HashMap queryParams = new HashMap();
        log.debug("Insert every event about last week");
        eventList.forEach(event -> {
            queryParams.put(QueryParams.EVT_YEAR.getKey(), event.getYear());
            queryParams.put(QueryParams.EVT_NUMBER.getKey(), event.getNumber());
            queryParams.put(QueryParams.GAME_CODE.getKey(), this.gameCode);
            queryParams.put(QueryParams.EVT_DRAW_DAT.getKey(), event.getDrawDate());
String query = this.queryTask2Config.getMerge();
int insertEvent = this.batchJDBCTemplate.update(connection -> {
    PreparedStatement ps = connection.prepareStatement(query);
    ps.setObject(1, event.getYear());
    ps.setObject(2, event.getNumber());
    ps.setObject(3, this.gameCode);
    ps.setObject(4, event.getDrawDate());
    return ps;
});
            log.debug("Insert entry for event with year: [{}] and number: [{}] with this result [{}]", new Object[]{event.getYear(), event.getNumber(), insertEvent});
        });
    }

    public WeekGameBalance checkWeekBalanceWin(AccountingWeek accountingWeek, Integer winsCode) {
        HashMap<String, Object> queryParams = new HashMap<String, Object>();
        BatchRepositoryImpl.commonMapParams((AccountingWeek)accountingWeek, (Integer)this.gameCode, queryParams);
        queryParams.put(QueryParams.WINS_CODE.getKey(), winsCode);
        try {
            return (WeekGameBalance)this.batchJDBCTemplate.queryForObject(this.queryTask3Config.getCheck(), queryParams, (RowMapper)new WeekGameBalanceRowMapper());
        }
        catch (EmptyResultDataAccessException e) {
            return new WeekGameBalance();
        }
    }

    @Transactional
    public void mergeWins(AccountingWeek accountingWeek, Integer winCode, List<Win> wins) {
        HashMap<String, Object> queryParams = new HashMap<String, Object>();
        BatchRepositoryImpl.commonMapParams((AccountingWeek)accountingWeek, (Integer)this.gameCode, queryParams);
        queryParams.put(QueryParams.WINS_CODE.getKey(), winCode);
        queryParams.put(QueryParams.CREATED_ON.getKey(), LocalDateTime.now());
        log.debug("Result of local Date: [{}]", queryParams.get(QueryParams.CREATED_ON.getKey()));
        try {
            log.debug("Create week balance for last week");
            int createWeekBalance = this.batchJDBCTemplate.update(this.queryTask3Config.getMergeWeekBalance(), queryParams);
            if (0 == createWeekBalance) {
throw new ReportingBatchException("Can't create week balance for this win: " + winCode.toString());
}
queryParams.remove(QueryParams.CREATED_ON.getKey());
if (null != wins && !wins.isEmpty()) {
    wins.forEach(win -> {
        BatchRepositoryImpl.insertParamsWins((Map)queryParams, (Win)win);
        String query = this.queryTask3Config.getMergeWeekAggregate();
        PreparedStatement ps = null;
        try {
            ps = this.batchJDBCTemplate.getDataSource().getConnection().prepareStatement(query);
            int paramIndex = 1;
            for (Map.Entry<String, Object> entry : queryParams.entrySet()) {
                ps.setObject(paramIndex++, entry.getValue());
            }
            int insertWins = ps.executeUpdate();
            log.debug("Insert wins for win: [{}] with this result: [{}]", (Object)winCode, (Object)insertWins);
        } catch (SQLException ex) {
            throw new ReportingBatchException("Failed to execute prepared statement", ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                }
            }
        }
    });
    BatchRepositoryImpl.removeParamsWins(queryParams);
}
queryParams.put(QueryParams.UPDATED_ON.getKey(), LocalDateTime.now());
int updateWeekBalance = this.batchJDBCTemplate.update(this.queryTask3Config.getUpdate(), queryParams);
if (0 == updateWeekBalance) {
    throw new ReportingBatchException("Can't update week balance for this win: " + winCode.toString());
            }
        }
        catch (Exception e) {
            log.error("Execution terminated with error [{}]", (Object)Utils.getStackTrace((Throwable)e));
            throw new ReportingBatchException("Failed execution of step 3");
        }
    }

    public WeekGameBalance checkWeekBalanceSale(AccountingWeek accountingWeek, Integer salesCode) {
        HashMap<String, Object> queryParams = new HashMap<String, Object>();
        BatchRepositoryImpl.commonMapParams((AccountingWeek)accountingWeek, (Integer)this.gameCode, queryParams);
        queryParams.put(QueryParams.SALES_CODE.getKey(), salesCode);
        try {
            return (WeekGameBalance)this.batchJDBCTemplate.queryForObject(this.queryTask4Config.getCheck(), queryParams, (RowMapper)new WeekGameBalanceRowMapper());
        }
        catch (EmptyResultDataAccessException e) {
            return new WeekGameBalance();
        }
    }

    @Transactional
    public void mergeSales(AccountingWeek accountingWeek, Integer saleCode, List<Sale> sales) {
        HashMap<String, Object> queryParams = new HashMap<String, Object>();
        BatchRepositoryImpl.commonMapParams((AccountingWeek)accountingWeek, (Integer)this.gameCode, queryParams);
        queryParams.put(QueryParams.SALES_CODE.getKey(), saleCode);
        queryParams.put(QueryParams.CREATED_ON.getKey(), LocalDateTime.now());
        try {
            log.debug("Create week balance for last week");
            int createWeekBalance = this.batchJDBCTemplate.update(this.queryTask4Config.getMergeWeekBalance(), queryParams);
            if (0 == createWeekBalance) {
            Set<String> whitelistSalecodeTostring = new HashSet<>(Arrays.asList("item1", "item2", "item3"));
            if (!saleCode.toString().matches("\\w+(\\s*\\.\\s*\\w+)*") && !whitelistSalecodeTostring.contains(saleCode.toString()))
                throw new IllegalArgumentException();
                throw new ReportingBatchException("Can't create week balance for this sale: " + saleCode.toString());
            }
            queryParams.remove(QueryParams.CREATED_ON.getKey());
            if (null != sales && !sales.isEmpty()) {
                sales.forEach(sale -> {
                    BatchRepositoryImpl.insertParamsSales((Map)queryParams, (Sale)sale);
                    int insertSale = this.batchJDBCTemplate.update(this.queryTask4Config.getMergeWeekAggregate(), queryParams);
                    log.debug("Insert sales for: [{}] with result: [{}]", (Object)saleCode, (Object)insertSale);
                });
                BatchRepositoryImpl.removeParamsSales(queryParams);
            }
            queryParams.put(QueryParams.UPDATED_ON.getKey(), LocalDateTime.now());
            int updateWeekBalance = this.batchJDBCTemplate.update(this.queryTask4Config.getUpdate(), queryParams);
            if (0 == updateWeekBalance) {
                throw new ReportingBatchException("Can't update week balance for this sale: " + saleCode.toString());
            }
        }
        catch (Exception e) {
            log.error("Execution terminated with error [{}]", (Object)Utils.getStackTrace((Throwable)e));
            throw new ReportingBatchException("Failed execution of step 4");
        }
    }

    public boolean checkWeekBalance(AccountingWeek accountingWeek) {
        HashMap queryParams = new HashMap();
        BatchRepositoryImpl.commonMapParams((AccountingWeek)accountingWeek, (Integer)this.gameCode, queryParams);
        List winCodes = this.queryTask3Config.getTypeWinsCode();
        List saleCodes = this.queryTask4Config.getTypeSalesCode();
        try {
            winCodes.forEach(winCode -> {
                log.debug("Check for win type: [{}]", winCode);
                queryParams.put(QueryParams.WINS_CODE.getKey(), winCode);
                try {
                    this.batchJDBCTemplate.queryForObject(this.queryTask3Config.getCheck(), queryParams, (RowMapper)new WeekGameBalanceRowMapper());
                }
                catch (EmptyResultDataAccessException e) {
throw new ReportingBatchException("Week game balance doesn't exist for win type: [{}]" + winCode);
}
});
saleCodes.forEach(saleCode -> {
    log.debug("Check for sale type: [{}]", saleCode);
    queryParams.put(QueryParams.SALES_CODE.getKey(), saleCode);
    try {
        PreparedStatement ps = this.batchJDBCTemplate.getDataSource().getConnection().prepareStatement(this.queryTask4Config.getCheck());
        int paramIndex = 1;
        for (Map.Entry<String, Object> entry : queryParams.entrySet()) {
            ps.setObject(paramIndex++, entry.getValue());
        }
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            new WeekGameBalanceRowMapper().mapRow(rs, 0);
        } else {
            throw new EmptyResultDataAccessException(1);
        }
    }
    catch (EmptyResultDataAccessException e) {
        throw new ReportingBatchException("Week game balance doesn't exist for sale type: [{}]" + saleCode);
                }
            });
            return true;
        }
        catch (Exception e) {
            log.error("Execution terminated with error [{}]", (Object)Utils.getStackTrace((Throwable)e));
            return false;
        }
    }

    public void updateStatus(AccountingWeek accountingWeek) {
        HashMap<String, Object> queryParams = new HashMap<String, Object>();
        BatchRepositoryImpl.commonMapParams((AccountingWeek)accountingWeek, (Integer)this.gameCode, queryParams);
        queryParams.put(QueryParams.STATUS_CODE.getKey(), QueryParams.STATUS_CODE_COMPLETED.getKey());
        int updateStatus = this.batchJDBCTemplate.update(this.queryTask5Config.getStatusUpdate(), queryParams);
        if (0 == updateStatus) {
            throw new ReportingBatchException("Can't update status for week: [{}]" + String.valueOf(accountingWeek));
        }
    }

    public Integer getNumDays() {
        HashMap queryParams = new HashMap();
        BatchRepositoryImpl.getDaysParams((Integer)this.gameCode, queryParams);
        return (Integer)this.batchJDBCTemplate.queryForObject(this.queryTask0Config.getGetDays(), queryParams, Integer.class);
    }

    public Integer deleteNumDays() {
        HashMap queryParams = new HashMap();
        BatchRepositoryImpl.getDaysParams((Integer)this.gameCode, queryParams);
        return this.batchJDBCTemplate.update(this.queryTask5Config.getDelDays(), queryParams);
    }

    private static void getDaysParams(Integer gameCode, Map<String, Object> queryParams) {
        queryParams.put(QueryParams.GAME_CODE.getKey(), gameCode);
    }

    private static void commonMapParams(AccountingWeek accountingWeek, Integer gameCode, Map<String, Object> queryParams) {
        queryParams.put(QueryParams.YEAR_REF.getKey(), accountingWeek.getYear());
        queryParams.put(QueryParams.WEEK_REF.getKey(), accountingWeek.getWeek());
        queryParams.put(QueryParams.GAME_CODE.getKey(), gameCode);
    }

    private static void insertParamsWins(Map<String, Object> queryParams, Win win) {
        queryParams.put(QueryParams.EVT_YEAR.getKey(), win.getYear());
        queryParams.put(QueryParams.EVT_NUMBER.getKey(), win.getNumber());
        queryParams.put(QueryParams.ZONE_CODE.getKey(), win.getZoneCode());
        queryParams.put(QueryParams.RSL_NUMBER.getKey(), win.getResellerNumber());
        queryParams.put(QueryParams.ORD_WINS_QUANTITY.getKey(), win.getOrdWinsQuantity());
        queryParams.put(QueryParams.OPT_WINS_QUANTITY.getKey(), win.getOptWinsQuantity());
        queryParams.put(QueryParams.ORD_WINS_AMOUNT.getKey(), win.getOrdWinsAmount());
        queryParams.put(QueryParams.OPT_WINS_AMOUNT.getKey(), win.getOptWinsAmount());
        queryParams.put(QueryParams.WINS_QUANTITY.getKey(), win.getWinsQuantity());
        queryParams.put(QueryParams.WINS_TAX_AMOUNT.getKey(), win.getWinsTaxAmount());
    }

    private static void removeParamsWins(Map<String, Object> queryParams) {
        queryParams.remove(QueryParams.EVT_YEAR.getKey());
        queryParams.remove(QueryParams.EVT_NUMBER.getKey());
        queryParams.remove(QueryParams.ZONE_CODE.getKey());
        queryParams.remove(QueryParams.RSL_NUMBER.getKey());
        queryParams.remove(QueryParams.ORD_WINS_QUANTITY.getKey());
        queryParams.remove(QueryParams.OPT_WINS_QUANTITY.getKey());
        queryParams.remove(QueryParams.ORD_WINS_AMOUNT.getKey());
        queryParams.remove(QueryParams.OPT_WINS_AMOUNT.getKey());
        queryParams.remove(QueryParams.WINS_QUANTITY.getKey());
        queryParams.remove(QueryParams.WINS_TAX_AMOUNT.getKey());
    }

    private static void removeParamsSales(Map<String, Object> queryParams) {
        queryParams.remove(QueryParams.ZONE_CODE.getKey());
        queryParams.remove(QueryParams.RSL_NUMBER.getKey());
        queryParams.remove(QueryParams.EVT_YEAR.getKey());
        queryParams.remove(QueryParams.EVT_NUMBER.getKey());
        queryParams.remove(QueryParams.TICKETS_QUANTITY.getKey());
        queryParams.remove(QueryParams.ORD_TICKETS_QUANTITY.getKey());
        queryParams.remove(QueryParams.OPT_TICKETS_QUANTITY.getKey());
        queryParams.remove(QueryParams.ORD_COMBINATIONS.getKey());
        queryParams.remove(QueryParams.OPT_COMBINATIONS.getKey());
        queryParams.remove(QueryParams.ORD_DEBIT_AMOUNT.getKey());
        queryParams.remove(QueryParams.ORD_CREDIT_AMOUNT.getKey());
        queryParams.remove(QueryParams.OPT_DEBIT_AMOUNT.getKey());
        queryParams.remove(QueryParams.OPT_CREDIT_AMOUNT.getKey());
    }

    private static void insertParamsSales(Map<String, Object> queryParams, Sale sale) {
        queryParams.put(QueryParams.ZONE_CODE.getKey(), sale.getZoneCode());
        queryParams.put(QueryParams.RSL_NUMBER.getKey(), sale.getResellerNumber());
        queryParams.put(QueryParams.EVT_YEAR.getKey(), sale.getYear());
        queryParams.put(QueryParams.EVT_NUMBER.getKey(), sale.getNumber());
        queryParams.put(QueryParams.TICKETS_QUANTITY.getKey(), sale.getTicketsQuantity());
        queryParams.put(QueryParams.ORD_TICKETS_QUANTITY.getKey(), sale.getOrdTicketsQuantity());
        queryParams.put(QueryParams.OPT_TICKETS_QUANTITY.getKey(), sale.getOptTicketsQuantity());
        queryParams.put(QueryParams.ORD_COMBINATIONS.getKey(), sale.getOrdCombinations());
        queryParams.put(QueryParams.OPT_COMBINATIONS.getKey(), sale.getOptCombinations());
        queryParams.put(QueryParams.ORD_DEBIT_AMOUNT.getKey(), sale.getOrdDebitAmount());
        queryParams.put(QueryParams.ORD_CREDIT_AMOUNT.getKey(), sale.getOrdCreditAmount());
        queryParams.put(QueryParams.OPT_DEBIT_AMOUNT.getKey(), sale.getOptDebitAmount());
        queryParams.put(QueryParams.OPT_CREDIT_AMOUNT.getKey(), sale.getOptCreditAmount());
    }
}

