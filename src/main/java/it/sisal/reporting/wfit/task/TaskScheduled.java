/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.task.TaskScheduled
 *  org.slf4j.MDC
 *  org.springframework.batch.core.Job
 *  org.springframework.batch.core.JobParameters
 *  org.springframework.batch.core.JobParametersBuilder
 *  org.springframework.batch.core.launch.JobLauncher
 *  org.springframework.scheduling.annotation.Scheduled
 *  org.springframework.stereotype.Component
 */
package it.sisal.reporting.wfit.task;

import java.util.UUID;
import org.slf4j.MDC;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskScheduled {
    private final JobLauncher jobLauncher;
    private final Job job;

    @Scheduled(cron="${app.cron}")
    public void perform() throws Exception {
        MDC.put((String)"mdc", (String)String.valueOf(UUID.randomUUID()));
        JobParameters params = new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis())).toJobParameters();
        this.jobLauncher.run(this.job, params);
    }

    public TaskScheduled(JobLauncher jobLauncher, Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }
}

