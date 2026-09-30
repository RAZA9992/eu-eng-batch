/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.service.Task5UpdateStatusService
 *  it.sisal.reporting.wfit.service.cache.ReportingCacheManager
 *  it.sisal.reporting.wfit.task.Task5UpdateStatus
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

import it.sisal.reporting.wfit.model.task0.AccountingWeek;
import it.sisal.reporting.wfit.service.Task5UpdateStatusService;
import it.sisal.reporting.wfit.service.cache.ReportingCacheManager;
import it.sisal.reporting.wfit.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class Task5UpdateStatus
implements Tasklet {
    private static final Logger log = LoggerFactory.getLogger(Task5UpdateStatus.class);
    private final Task5UpdateStatusService task5UpdateStatusService;
    private final ReportingCacheManager reportingCacheManager;

    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) {
        MDC.put((String)"uuid", (String)Utils.setMDC((String)"Task5"));
        try {
            AccountingWeek accountingWeek = this.reportingCacheManager.get();
            log.info("Check if all week balance are present");
            boolean check = this.task5UpdateStatusService.checkWeekBalance(accountingWeek);
            log.info("Checked if all week balance are present with result: [{}]", (Object)check);
            if (check) {
                log.info("Update status to 3 (COMPLETED) for week: [{}]", (Object)accountingWeek);
                this.task5UpdateStatusService.updateStatus(accountingWeek);
            }
            this.reportingCacheManager.delete();
            this.task5UpdateStatusService.delNumDays();
        }
        catch (Exception e) {
            log.error("Execution terminated with error [{}]", (Object)Utils.getStackTrace((Throwable)e));
        }
        MDC.clear();
        return RepeatStatus.FINISHED;
    }

    public Task5UpdateStatus(Task5UpdateStatusService task5UpdateStatusService, ReportingCacheManager reportingCacheManager) {
        this.task5UpdateStatusService = task5UpdateStatusService;
        this.reportingCacheManager = reportingCacheManager;
    }
}

