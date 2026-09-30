/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.config.QueryTask3Config
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.model.task1.WeekGameBalance
 *  it.sisal.reporting.wfit.service.Task3WinsService
 *  it.sisal.reporting.wfit.service.cache.ReportingCacheManager
 *  it.sisal.reporting.wfit.task.Task3Wins
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

import it.sisal.reporting.wfit.config.QueryTask3Config;
import it.sisal.reporting.wfit.model.task0.AccountingWeek;
import it.sisal.reporting.wfit.model.task1.WeekGameBalance;
import it.sisal.reporting.wfit.service.Task3WinsService;
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

public class Task3Wins
implements Tasklet {
    private static final Logger log = LoggerFactory.getLogger(Task3Wins.class);
    private final Task3WinsService task3WinsService;
    private final ReportingCacheManager reportingCacheManager;
    private final QueryTask3Config queryTask3Config;

    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) {
        MDC.put((String)"uuid", (String)Utils.setMDC((String)"Task3"));
        try {
            AccountingWeek accountingWeek = this.reportingCacheManager.get();
            log.info("Iterate all type of wins");
            List<Integer> winCodes = this.queryTask3Config.getTypeWinsCode();
            winCodes.forEach(winCode -> {
                log.info("Retrieve a week balance for check aggregate about win type: [{}]", winCode);
                WeekGameBalance weekGameBalance = this.task3WinsService.checkWeekBalanceWin(accountingWeek, (Integer)winCode);
                log.info("Retrieved this week balance: [{}]", (Object)weekGameBalance);
                if (null == weekGameBalance.getYear()) {
                    log.info("Calculate wins aggregate to insert for last week");
                    List wins = this.task3WinsService.selectWin(accountingWeek, (Integer)winCode);
                    log.info("Insert [{}] wins aggregate", (Object)wins.size());
                    this.task3WinsService.mergeWins(accountingWeek, (Integer)winCode, wins);
                }
            });
        }
        catch (Exception e) {
            log.error("Execution terminated with error [{}]", (Object)Utils.getStackTrace((Throwable)e));
        }
        MDC.clear();
        return RepeatStatus.FINISHED;
    }

    public Task3Wins(Task3WinsService task3WinsService, ReportingCacheManager reportingCacheManager, QueryTask3Config queryTask3Config) {
        this.task3WinsService = task3WinsService;
        this.reportingCacheManager = reportingCacheManager;
        this.queryTask3Config = queryTask3Config;
    }
}

