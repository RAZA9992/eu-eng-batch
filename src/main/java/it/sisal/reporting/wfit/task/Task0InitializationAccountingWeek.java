/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.config.QueryTask0Config
 *  it.sisal.reporting.wfit.exception.ReportingBatchException
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.service.Task0InitializationAccountingWeekService
 *  it.sisal.reporting.wfit.service.cache.ReportingCacheManager
 *  it.sisal.reporting.wfit.task.Task0InitializationAccountingWeek
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

import it.sisal.reporting.wfit.config.QueryTask0Config;
import it.sisal.reporting.wfit.exception.ReportingBatchException;
import it.sisal.reporting.wfit.model.task0.AccountingWeek;
import it.sisal.reporting.wfit.service.Task0InitializationAccountingWeekService;
import it.sisal.reporting.wfit.service.cache.ReportingCacheManager;
import it.sisal.reporting.wfit.util.Utils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class Task0InitializationAccountingWeek
implements Tasklet {
    private static final Logger log = LoggerFactory.getLogger(Task0InitializationAccountingWeek.class);
    private final Task0InitializationAccountingWeekService task0InitializationAccountingWeekService;
    private final ReportingCacheManager reportingCacheManager;
    private final QueryTask0Config queryTask0Config;

    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) {
        MDC.put((String)"uuid", (String)Utils.setMDC((String)"Task0"));
        try {
            Integer daysFromDb = this.task0InitializationAccountingWeekService.getNumDays();
            Integer days = -1 == daysFromDb ? this.queryTask0Config.getNumDays() : daysFromDb;
            LocalDateTime lastMonday = LocalDate.now().minusDays(days.intValue()).atStartOfDay();
            log.info("Retrieve the accounting week for lastMonday: [{}]", (Object)lastMonday);
            AccountingWeek accountingWeekControl = this.task0InitializationAccountingWeekService.selectAccountingWeekControl(lastMonday);
            log.info("Retrieved accounting week with year: [{}], and week: [{}]", (Object)accountingWeekControl.getYear(), (Object)accountingWeekControl.getWeek());
            if (null == accountingWeekControl.getYear() && null == accountingWeekControl.getWeek()) {
                log.info("Accounting week doesn't exist, we retrieve information for add new one");
                AccountingWeek accountingWeek = this.task0InitializationAccountingWeekService.selectAccountingWeek(lastMonday);
                log.info("Insert new accounting week: [{}]", (Object)accountingWeek);
                this.task0InitializationAccountingWeekService.mergeAccountingWeek(accountingWeek);
                this.reportingCacheManager.put(accountingWeek);
            } else {
                this.reportingCacheManager.put(accountingWeekControl);
            }
        }
        catch (Exception e) {
            log.error("Execution terminated with error [{}]", (Object)Utils.getStackTrace((Throwable)e));
            throw new ReportingBatchException("Failed execution of step 0");
        }
        MDC.clear();
        return RepeatStatus.FINISHED;
    }

    public Task0InitializationAccountingWeek(Task0InitializationAccountingWeekService task0InitializationAccountingWeekService, ReportingCacheManager reportingCacheManager, QueryTask0Config queryTask0Config) {
        this.task0InitializationAccountingWeekService = task0InitializationAccountingWeekService;
        this.reportingCacheManager = reportingCacheManager;
        this.queryTask0Config = queryTask0Config;
    }
}

