/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.model.task1.WeekGameBalance
 *  it.sisal.reporting.wfit.model.task2.Event
 *  it.sisal.reporting.wfit.model.task3.Win
 *  it.sisal.reporting.wfit.model.task4.Sale
 *  it.sisal.reporting.wfit.repository.batch.BatchRepository
 */
package it.sisal.reporting.wfit.repository.batch;

import it.sisal.reporting.wfit.model.task0.AccountingWeek;
import it.sisal.reporting.wfit.model.task1.WeekGameBalance;
import it.sisal.reporting.wfit.model.task2.Event;
import it.sisal.reporting.wfit.model.task3.Win;
import it.sisal.reporting.wfit.model.task4.Sale;
import java.time.LocalDateTime;
import java.util.List;

public interface BatchRepository {
    public AccountingWeek selectAccountingControlWeek(LocalDateTime var1);

    public void mergeAccountingWeek(AccountingWeek var1);

    public WeekGameBalance selectWeekGameBalance(LocalDateTime var1);

    public void mergeWeekGameBalance(WeekGameBalance var1);

    public void insertEvents(List<Event> var1);

    public WeekGameBalance checkWeekBalanceWin(AccountingWeek var1, Integer var2);

    public void mergeWins(AccountingWeek var1, Integer var2, List<Win> var3);

    public WeekGameBalance checkWeekBalanceSale(AccountingWeek var1, Integer var2);

    public void mergeSales(AccountingWeek var1, Integer var2, List<Sale> var3);

    public boolean checkWeekBalance(AccountingWeek var1);

    public void updateStatus(AccountingWeek var1);

    public Integer getNumDays();

    public Integer deleteNumDays();
}

