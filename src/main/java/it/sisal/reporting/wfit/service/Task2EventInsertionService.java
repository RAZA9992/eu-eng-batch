/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task2.Event
 *  it.sisal.reporting.wfit.service.Task2EventInsertionService
 */
package it.sisal.reporting.wfit.service;

import it.sisal.reporting.wfit.model.task2.Event;
import java.time.LocalDateTime;
import java.util.List;

public interface Task2EventInsertionService {
    public List<Event> selectEvents(LocalDateTime var1);

    public void insertEvents(List<Event> var1);
}

