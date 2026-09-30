/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.repository.core.CoreRepository
 */
package it.sisal.reporting.wfit.repository.core;

import it.sisal.reporting.wfit.model.task0.AccountingWeek;
import java.time.LocalDateTime;

public interface CoreRepository {
    public AccountingWeek selectAccountingWeek(LocalDateTime var1);
}

