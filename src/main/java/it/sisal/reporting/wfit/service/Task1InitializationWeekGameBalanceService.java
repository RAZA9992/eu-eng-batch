/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task1.WeekGameBalance
 *  it.sisal.reporting.wfit.service.Task1InitializationWeekGameBalanceService
 */
package it.sisal.reporting.wfit.service;

import it.sisal.reporting.wfit.model.task1.WeekGameBalance;
import java.time.LocalDateTime;

public interface Task1InitializationWeekGameBalanceService {
    public WeekGameBalance selectWeekGameBalance(LocalDateTime var1);

    public void mergeWeekGameBalance(WeekGameBalance var1);

    public Integer getNumDays();
}

