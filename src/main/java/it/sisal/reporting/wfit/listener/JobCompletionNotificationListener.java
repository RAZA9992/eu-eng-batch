/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.listener.JobCompletionNotificationListener
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.batch.core.JobExecution
 *  org.springframework.stereotype.Component
 */
package it.sisal.reporting.wfit.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener {
    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    public void afterJob(JobExecution jobExecution) {
        log.info("Job execution completed with status: [{}]", (Object)jobExecution.getStatus());
    }
}

