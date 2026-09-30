/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.config.QueryTask0Config
 *  it.sisal.reporting.wfit.exception.ReportingBatchException
 *  it.sisal.reporting.wfit.model.task1.WeekGameBalance
 *  it.sisal.reporting.wfit.service.Task1InitializationWeekGameBalanceService
 *  it.sisal.reporting.wfit.task.Task1InitializationWeekGameBalance
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
import it.sisal.reporting.wfit.model.task1.WeekGameBalance;
import it.sisal.reporting.wfit.service.Task1InitializationWeekGameBalanceService;
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

public class Task1InitializationWeekGameBalance
implements Tasklet {
    private static final Logger log = LoggerFactory.getLogger(Task1InitializationWeekGameBalance.class);
    private final Task1InitializationWeekGameBalanceService task1InitializationWeekGameBalanceService;
    private final QueryTask0Config queryTask0Config;

    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) {
        MDC.put((String)"uuid", (String)Utils.setMDC((String)"Task1"));
        try {
            Integer daysFromDb = this.task1InitializationWeekGameBalanceService.getNumDays();
            Integer days = -1 == daysFromDb ? this.queryTask0Config.getNumDays() : daysFromDb;
            LocalDateTime lastMonday = LocalDate.now().minusDays(days.intValue()).atStartOfDay();
            log.info("Retrieve year and week for lastMonday: [{}]", (Object)lastMonday);
            WeekGameBalance weekGameBalance = this.task1InitializationWeekGameBalanceService.selectWeekGameBalance(lastMonday);
            if (null != weekGameBalance.getYear() && null != weekGameBalance.getWeek()) {
                log.info("Insert new week game balance: [{}]", (Object)weekGameBalance);
                this.task1InitializationWeekGameBalanceService.mergeWeekGameBalance(weekGameBalance);
            }
        }
        catch (Exception e) {
            log.error("Execution terminated with error [{}]", (Object)Utils.getStackTrace((Throwable)e));
            throw new ReportingBatchException("Failed execution of step 1");
        }
        MDC.clear();
        return RepeatStatus.FINISHED;
    }

    public Task1InitializationWeekGameBalance(Task1InitializationWeekGameBalanceService task1InitializationWeekGameBalanceService, QueryTask0Config queryTask0Config) {
        this.task1InitializationWeekGameBalanceService = task1InitializationWeekGameBalanceService;
        this.queryTask0Config = queryTask0Config;
    }
}

