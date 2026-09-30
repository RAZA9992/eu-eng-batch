/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task1.WeekGameBalance
 *  it.sisal.reporting.wfit.repository.batch.BatchRepository
 *  it.sisal.reporting.wfit.service.Task1InitializationWeekGameBalanceService
 *  it.sisal.reporting.wfit.service.Task1InitializationWeekGameBalanceServiceImpl
 *  org.springframework.stereotype.Service
 */
package it.sisal.reporting.wfit.service;

import it.sisal.reporting.wfit.model.task1.WeekGameBalance;
import it.sisal.reporting.wfit.repository.batch.BatchRepository;
import it.sisal.reporting.wfit.service.Task1InitializationWeekGameBalanceService;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class Task1InitializationWeekGameBalanceServiceImpl
implements Task1InitializationWeekGameBalanceService {
    private final BatchRepository batchRepository;

    public WeekGameBalance selectWeekGameBalance(LocalDateTime lastMonday) {
        return this.batchRepository.selectWeekGameBalance(lastMonday);
    }

    public void mergeWeekGameBalance(WeekGameBalance weekGameBalance) {
        this.batchRepository.mergeWeekGameBalance(weekGameBalance);
    }

    public Integer getNumDays() {
        return this.batchRepository.getNumDays();
    }

    public Task1InitializationWeekGameBalanceServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }
}

