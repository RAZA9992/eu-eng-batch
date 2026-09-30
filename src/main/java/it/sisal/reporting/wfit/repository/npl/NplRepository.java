/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.model.task2.Event
 *  it.sisal.reporting.wfit.model.task3.Win
 *  it.sisal.reporting.wfit.model.task4.Sale
 *  it.sisal.reporting.wfit.repository.npl.NplRepository
 */
package it.sisal.reporting.wfit.repository.npl;

import it.sisal.reporting.wfit.model.task0.AccountingWeek;
import it.sisal.reporting.wfit.model.task2.Event;
import it.sisal.reporting.wfit.model.task3.Win;
import it.sisal.reporting.wfit.model.task4.Sale;
import java.time.LocalDateTime;
import java.util.List;

public interface NplRepository {
    public List<Event> selectEvents(LocalDateTime var1);

    public List<Win> selectWins(AccountingWeek var1, String var2);

    public List<Sale> selectSale(AccountingWeek var1, String var2);
}

