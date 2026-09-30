/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.service.Task0InitializationAccountingWeekService
 */
package it.sisal.reporting.wfit.service;

import it.sisal.reporting.wfit.model.task0.AccountingWeek;
import java.time.LocalDateTime;

public interface Task0InitializationAccountingWeekService {
    public AccountingWeek selectAccountingWeekControl(LocalDateTime var1);

    public AccountingWeek selectAccountingWeek(LocalDateTime var1);

    public void mergeAccountingWeek(AccountingWeek var1);

    public Integer getNumDays();
}

