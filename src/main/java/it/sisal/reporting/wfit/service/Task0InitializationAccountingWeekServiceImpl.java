/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.repository.batch.BatchRepository
 *  it.sisal.reporting.wfit.repository.core.CoreRepository
 *  it.sisal.reporting.wfit.service.Task0InitializationAccountingWeekService
 *  it.sisal.reporting.wfit.service.Task0InitializationAccountingWeekServiceImpl
 *  org.springframework.stereotype.Service
 */
package it.sisal.reporting.wfit.service;

import it.sisal.reporting.wfit.model.task0.AccountingWeek;
import it.sisal.reporting.wfit.repository.batch.BatchRepository;
import it.sisal.reporting.wfit.repository.core.CoreRepository;
import it.sisal.reporting.wfit.service.Task0InitializationAccountingWeekService;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class Task0InitializationAccountingWeekServiceImpl
implements Task0InitializationAccountingWeekService {
    private final CoreRepository coreRepository;
    private final BatchRepository batchRepository;

    public AccountingWeek selectAccountingWeekControl(LocalDateTime lastMonday) {
        return this.batchRepository.selectAccountingControlWeek(lastMonday);
    }

    public AccountingWeek selectAccountingWeek(LocalDateTime lastMonday) {
        return this.coreRepository.selectAccountingWeek(lastMonday);
    }

    public void mergeAccountingWeek(AccountingWeek accountingWeek) {
        this.batchRepository.mergeAccountingWeek(accountingWeek);
    }

    public Integer getNumDays() {
        return this.batchRepository.getNumDays();
    }

    public Task0InitializationAccountingWeekServiceImpl(CoreRepository coreRepository, BatchRepository batchRepository) {
        this.coreRepository = coreRepository;
        this.batchRepository = batchRepository;
    }
}

