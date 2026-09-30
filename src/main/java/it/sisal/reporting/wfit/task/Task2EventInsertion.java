/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.service.Task2EventInsertionService
 *  it.sisal.reporting.wfit.service.cache.ReportingCacheManager
 *  it.sisal.reporting.wfit.task.Task2EventInsertion
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
import it.sisal.reporting.wfit.service.Task2EventInsertionService;
import it.sisal.reporting.wfit.service.cache.ReportingCacheManager;
import it.sisal.reporting.wfit.util.Utils;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class Task2EventInsertion
implements Tasklet {
    private static final Logger log = LoggerFactory.getLogger(Task2EventInsertion.class);
    private final Task2EventInsertionService task2EventInsertionService;
    private final ReportingCacheManager reportingCacheManager;

    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) {
        MDC.put((String)"uuid", (String)Utils.setMDC((String)"Task2"));
        try {
            AccountingWeek accountingWeek = this.reportingCacheManager.get();
            LocalDateTime lastMonday = accountingWeek.getBeginsOn();
            log.info("Retrieve the accounting week from lastMonday: [{}]", (Object)lastMonday);
            List events = this.task2EventInsertionService.selectEvents(lastMonday);
            if (null != events && !events.isEmpty()) {
                log.info("Insert all event of last week: [{}] events", (Object)events.size());
                this.task2EventInsertionService.insertEvents(events);
            }
        }
        catch (Exception e) {
            log.error("Execution terminated with error [{}]", (Object)Utils.getStackTrace((Throwable)e));
        }
        MDC.clear();
        return RepeatStatus.FINISHED;
    }

    public Task2EventInsertion(Task2EventInsertionService task2EventInsertionService, ReportingCacheManager reportingCacheManager) {
        this.task2EventInsertionService = task2EventInsertionService;
        this.reportingCacheManager = reportingCacheManager;
    }
}

