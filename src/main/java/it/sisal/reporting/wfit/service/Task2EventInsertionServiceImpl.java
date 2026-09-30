/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task2.Event
 *  it.sisal.reporting.wfit.repository.batch.BatchRepository
 *  it.sisal.reporting.wfit.repository.npl.NplRepository
 *  it.sisal.reporting.wfit.service.Task2EventInsertionService
 *  it.sisal.reporting.wfit.service.Task2EventInsertionServiceImpl
 *  org.springframework.stereotype.Service
 */
package it.sisal.reporting.wfit.service;

import it.sisal.reporting.wfit.model.task2.Event;
import it.sisal.reporting.wfit.repository.batch.BatchRepository;
import it.sisal.reporting.wfit.repository.npl.NplRepository;
import it.sisal.reporting.wfit.service.Task2EventInsertionService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class Task2EventInsertionServiceImpl
implements Task2EventInsertionService {
    private final NplRepository nplRepository;
    private final BatchRepository batchRepository;

    public List<Event> selectEvents(LocalDateTime lastMonday) {
        return this.nplRepository.selectEvents(lastMonday);
    }

    public void insertEvents(List<Event> eventList) {
        this.batchRepository.insertEvents(eventList);
    }

    public Task2EventInsertionServiceImpl(NplRepository nplRepository, BatchRepository batchRepository) {
        this.nplRepository = nplRepository;
        this.batchRepository = batchRepository;
    }
}

