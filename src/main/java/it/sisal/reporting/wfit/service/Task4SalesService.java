/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.model.task1.WeekGameBalance
 *  it.sisal.reporting.wfit.model.task4.Sale
 *  it.sisal.reporting.wfit.service.Task4SalesService
 */
package it.sisal.reporting.wfit.service;

import it.sisal.reporting.wfit.model.task0.AccountingWeek;
import it.sisal.reporting.wfit.model.task1.WeekGameBalance;
import it.sisal.reporting.wfit.model.task4.Sale;
import java.util.List;

public interface Task4SalesService {
    public WeekGameBalance checkWeekBalanceSale(AccountingWeek var1, Integer var2);

    public List<Sale> selectSale(AccountingWeek var1, Integer var2);

    public void mergeSales(AccountingWeek var1, Integer var2, List<Sale> var3);
}

