/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.config.QueryTask3Config
 *  it.sisal.reporting.wfit.exception.ReportingBatchException
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.model.task1.WeekGameBalance
 *  it.sisal.reporting.wfit.model.task3.Win
 *  it.sisal.reporting.wfit.repository.batch.BatchRepository
 *  it.sisal.reporting.wfit.repository.npl.NplRepository
 *  it.sisal.reporting.wfit.service.Task3WinsService
 *  it.sisal.reporting.wfit.service.Task3WinsServiceImpl
 *  org.springframework.stereotype.Service
 */
package it.sisal.reporting.wfit.service;

import it.sisal.reporting.wfit.config.QueryTask3Config;
import it.sisal.reporting.wfit.exception.ReportingBatchException;
import it.sisal.reporting.wfit.model.task0.AccountingWeek;
import it.sisal.reporting.wfit.model.task1.WeekGameBalance;
import it.sisal.reporting.wfit.model.task3.Win;
import it.sisal.reporting.wfit.repository.batch.BatchRepository;
import it.sisal.reporting.wfit.repository.npl.NplRepository;
import it.sisal.reporting.wfit.service.Task3WinsService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class Task3WinsServiceImpl
implements Task3WinsService {
    private final BatchRepository batchRepository;
    private final NplRepository nplRepository;
    private final QueryTask3Config queryTask3Config;

    public WeekGameBalance checkWeekBalanceWin(AccountingWeek accountingWeek, Integer winsCode) {
        return this.batchRepository.checkWeekBalanceWin(accountingWeek, winsCode);
    }

    public List<Win> selectWin(AccountingWeek accountingWeek, Integer winCode) {
        return switch (winCode) {
            case 100 -> this.nplRepository.selectWins(accountingWeek, this.queryTask3Config.getWinsForPoints());
            case 110 -> this.nplRepository.selectWins(accountingWeek, this.queryTask3Config.getWinsInstant());
            default -> throw new ReportingBatchException("Illegal win code");
        };
    }

    public void mergeWins(AccountingWeek accountingWeek, Integer winCode, List<Win> wins) {
        this.batchRepository.mergeWins(accountingWeek, winCode, wins);
    }

    public Task3WinsServiceImpl(BatchRepository batchRepository, NplRepository nplRepository, QueryTask3Config queryTask3Config) {
        this.batchRepository = batchRepository;
        this.nplRepository = nplRepository;
        this.queryTask3Config = queryTask3Config;
    }
}

