/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.service.cache.ReportingCacheManager
 */
package it.sisal.reporting.wfit.service.cache;

import it.sisal.reporting.wfit.model.task0.AccountingWeek;

public interface ReportingCacheManager {
    public void put(AccountingWeek var1);

    public AccountingWeek get();

    public void delete();
}

