/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.repository.batch.BatchRepository
 *  it.sisal.reporting.wfit.service.Task5UpdateStatusService
 *  it.sisal.reporting.wfit.service.Task5UpdateStatusServiceImpl
 *  org.springframework.stereotype.Service
 */
package it.sisal.reporting.wfit.service;

import it.sisal.reporting.wfit.model.task0.AccountingWeek;
import it.sisal.reporting.wfit.repository.batch.BatchRepository;
import it.sisal.reporting.wfit.service.Task5UpdateStatusService;
import org.springframework.stereotype.Service;

@Service
public class Task5UpdateStatusServiceImpl
implements Task5UpdateStatusService {
    private final BatchRepository batchRepository;

    public boolean checkWeekBalance(AccountingWeek accountingWeek) {
        return this.batchRepository.checkWeekBalance(accountingWeek);
    }

    public void updateStatus(AccountingWeek accountingWeek) {
        this.batchRepository.updateStatus(accountingWeek);
    }

    public Integer delNumDays() {
        return this.batchRepository.deleteNumDays();
    }

    public Task5UpdateStatusServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }
}

