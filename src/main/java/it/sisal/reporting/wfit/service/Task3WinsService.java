/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.model.task1.WeekGameBalance
 *  it.sisal.reporting.wfit.model.task3.Win
 *  it.sisal.reporting.wfit.service.Task3WinsService
 */
package it.sisal.reporting.wfit.service;

import it.sisal.reporting.wfit.model.task0.AccountingWeek;
import it.sisal.reporting.wfit.model.task1.WeekGameBalance;
import it.sisal.reporting.wfit.model.task3.Win;
import java.util.List;

public interface Task3WinsService {
    public WeekGameBalance checkWeekBalanceWin(AccountingWeek var1, Integer var2);

    public List<Win> selectWin(AccountingWeek var1, Integer var2);

    public void mergeWins(AccountingWeek var1, Integer var2, List<Win> var3);
}

