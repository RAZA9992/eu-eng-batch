/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.config.QueryTask4Config
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.model.task1.WeekGameBalance
 *  it.sisal.reporting.wfit.service.Task4SalesService
 *  it.sisal.reporting.wfit.service.cache.ReportingCacheManager
 *  it.sisal.reporting.wfit.task.Task4Sales
 *  it.sisal.reporting.wfit.util.Utils
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.slf4j.MDC
 *  org.springframework.batch.core.StepContribution
 *  org.springframework.batch.core.scope.context.ChunkContext
 *  org.springframework.batch.core.step.tasklet.Tasklet
 *  org.springframework.batch.repeat.RepeatStatus
 */
package it.sisal.reporting.wfit.task;

import it.sisal.reporting.wfit.config.QueryTask4Config;
import it.sisal.reporting.wfit.model.task0.AccountingWeek;
import it.sisal.reporting.wfit.model.task1.WeekGameBalance;
import it.sisal.reporting.wfit.service.Task4SalesService;
import it.sisal.reporting.wfit.service.cache.ReportingCacheManager;
import it.sisal.reporting.wfit.util.Utils;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class Task4Sales
implements Tasklet {
    private static final Logger log = LoggerFactory.getLogger(Task4Sales.class);
    private final Task4SalesService task4SalesService;
    private final ReportingCacheManager reportingCacheManager;
    private final QueryTask4Config queryTask4Config;

    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) {
        MDC.put((String)"uuid", (String)Utils.setMDC((String)"Task4"));
        try {
            AccountingWeek accountingWeek = this.reportingCacheManager.get();
            log.info("Iterate all type of sales");
            List<Integer> saleCodes = this.queryTask4Config.getTypeSalesCode();
            saleCodes.forEach(saleCode -> {
                log.info("Retrieve a week balance for check aggregate about sale type: [{}]", saleCode);
                WeekGameBalance weekGameBalance = this.task4SalesService.checkWeekBalanceSale(accountingWeek, (Integer)saleCode);
                log.info("Retrieved this week balance: [{}]", (Object)weekGameBalance);
                if (null == weekGameBalance.getYear()) {
                    log.info("Calculate sales aggregate to insert for last week");
                    List sales = this.task4SalesService.selectSale(accountingWeek, (Integer)saleCode);
                    log.info("Insert [{}] sales aggregate", (Object)sales.size());
                    this.task4SalesService.mergeSales(accountingWeek, (Integer)saleCode, sales);
                }
            });
        }
        catch (Exception e) {
            log.error("Execution terminated with error [{}]", (Object)Utils.getStackTrace((Throwable)e));
        }
        MDC.clear();
        return RepeatStatus.FINISHED;
    }

    public Task4Sales(Task4SalesService task4SalesService, ReportingCacheManager reportingCacheManager, QueryTask4Config queryTask4Config) {
        this.task4SalesService = task4SalesService;
        this.reportingCacheManager = reportingCacheManager;
        this.queryTask4Config = queryTask4Config;
    }
}

