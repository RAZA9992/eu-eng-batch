/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.service.Task5UpdateStatusService
 */
package it.sisal.reporting.wfit.service;

import it.sisal.reporting.wfit.model.task0.AccountingWeek;

public interface Task5UpdateStatusService {
    public boolean checkWeekBalance(AccountingWeek var1);

    public void updateStatus(AccountingWeek var1);

    public Integer delNumDays();
}

