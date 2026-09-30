/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.config.BatchConfig
 *  it.sisal.reporting.wfit.config.QueryTask0Config
 *  it.sisal.reporting.wfit.config.QueryTask3Config
 *  it.sisal.reporting.wfit.config.QueryTask4Config
 *  it.sisal.reporting.wfit.listener.JobCompletionNotificationListener
 *  it.sisal.reporting.wfit.service.Task0InitializationAccountingWeekService
 *  it.sisal.reporting.wfit.service.Task1InitializationWeekGameBalanceService
 *  it.sisal.reporting.wfit.service.Task2EventInsertionService
 *  it.sisal.reporting.wfit.service.Task3WinsService
 *  it.sisal.reporting.wfit.service.Task4SalesService
 *  it.sisal.reporting.wfit.service.Task5UpdateStatusService
 *  it.sisal.reporting.wfit.service.cache.ReportingCacheManager
 *  it.sisal.reporting.wfit.task.Task0InitializationAccountingWeek
 *  it.sisal.reporting.wfit.task.Task1InitializationWeekGameBalance
 *  it.sisal.reporting.wfit.task.Task2EventInsertion
 *  it.sisal.reporting.wfit.task.Task3Wins
 *  it.sisal.reporting.wfit.task.Task4Sales
 *  it.sisal.reporting.wfit.task.Task5UpdateStatus
 *  org.springframework.batch.core.Job
 *  org.springframework.batch.core.Step
 *  org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer
 *  org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
 *  org.springframework.batch.core.configuration.annotation.JobBuilderFactory
 *  org.springframework.batch.core.configuration.annotation.StepBuilderFactory
 *  org.springframework.batch.core.job.builder.JobBuilder
 *  org.springframework.batch.core.step.tasklet.Tasklet
 *  org.springframework.context.annotation.Bean
 *  org.springframework.context.annotation.Configuration
 */
package it.sisal.reporting.wfit.config;

import it.sisal.reporting.wfit.config.QueryTask0Config;
import it.sisal.reporting.wfit.config.QueryTask3Config;
import it.sisal.reporting.wfit.config.QueryTask4Config;
import it.sisal.reporting.wfit.listener.JobCompletionNotificationListener;
import it.sisal.reporting.wfit.service.Task0InitializationAccountingWeekService;
import it.sisal.reporting.wfit.service.Task1InitializationWeekGameBalanceService;
import it.sisal.reporting.wfit.service.Task2EventInsertionService;
import it.sisal.reporting.wfit.service.Task3WinsService;
import it.sisal.reporting.wfit.service.Task4SalesService;
import it.sisal.reporting.wfit.service.Task5UpdateStatusService;
import it.sisal.reporting.wfit.service.cache.ReportingCacheManager;
import it.sisal.reporting.wfit.task.Task0InitializationAccountingWeek;
import it.sisal.reporting.wfit.task.Task1InitializationWeekGameBalance;
import it.sisal.reporting.wfit.task.Task2EventInsertion;
import it.sisal.reporting.wfit.task.Task3Wins;
import it.sisal.reporting.wfit.task.Task4Sales;
import it.sisal.reporting.wfit.task.Task5UpdateStatus;
import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig
extends DefaultBatchConfigurer {
    private final QueryTask0Config queryTask0Config;
    private final QueryTask3Config queryTask3Config;
    private final QueryTask4Config queryTask4Config;
    private final ReportingCacheManager reportingCacheManager;
    private final Task0InitializationAccountingWeekService task0InitializationAccountingWeekService;
    private final Task1InitializationWeekGameBalanceService task1InitializationWeekGameBalanceService;
    private final Task2EventInsertionService task2EventInsertionService;
    private final Task3WinsService task3WinsService;
    private final Task4SalesService task4SalesService;
    private final Task5UpdateStatusService task5UpdateStatusService;
    private final JobBuilderFactory jobs;
    private final StepBuilderFactory steps;

    public void setDataSource(DataSource dataSource) {
    }

    @Bean
    public Job main(JobCompletionNotificationListener listener) {
        return ((JobBuilder)this.jobs.get("main").listener((Object)listener)).start(this.getTask0InitializationAccountingWeek()).next(this.getTask1InitializationWeekGameBalance()).next(this.getTask2EventInsertion()).next(this.getTask3Wins()).next(this.getTask4Sales()).next(this.getTask5UpdateStatus()).build();
    }

    private Step getTask0InitializationAccountingWeek() {
        return this.steps.get("Task0InitializationAccountingWeek").tasklet((Tasklet)new Task0InitializationAccountingWeek(this.task0InitializationAccountingWeekService, this.reportingCacheManager, this.queryTask0Config)).build();
    }

    private Step getTask1InitializationWeekGameBalance() {
        return this.steps.get("Task1InitializationWeekGameBalance").tasklet((Tasklet)new Task1InitializationWeekGameBalance(this.task1InitializationWeekGameBalanceService, this.queryTask0Config)).build();
    }

    private Step getTask2EventInsertion() {
        return this.steps.get("Task2EventInsertion").tasklet((Tasklet)new Task2EventInsertion(this.task2EventInsertionService, this.reportingCacheManager)).build();
    }

    private Step getTask3Wins() {
        return this.steps.get("Task3Wins").tasklet((Tasklet)new Task3Wins(this.task3WinsService, this.reportingCacheManager, this.queryTask3Config)).build();
    }

    private Step getTask4Sales() {
        return this.steps.get("Task4Sales").tasklet((Tasklet)new Task4Sales(this.task4SalesService, this.reportingCacheManager, this.queryTask4Config)).build();
    }

    private Step getTask5UpdateStatus() {
        return this.steps.get("Task5UpdateStatus").tasklet((Tasklet)new Task5UpdateStatus(this.task5UpdateStatusService, this.reportingCacheManager)).build();
    }

    public BatchConfig(QueryTask0Config queryTask0Config, QueryTask3Config queryTask3Config, QueryTask4Config queryTask4Config, ReportingCacheManager reportingCacheManager, Task0InitializationAccountingWeekService task0InitializationAccountingWeekService, Task1InitializationWeekGameBalanceService task1InitializationWeekGameBalanceService, Task2EventInsertionService task2EventInsertionService, Task3WinsService task3WinsService, Task4SalesService task4SalesService, Task5UpdateStatusService task5UpdateStatusService, JobBuilderFactory jobs, StepBuilderFactory steps) {
        this.queryTask0Config = queryTask0Config;
        this.queryTask3Config = queryTask3Config;
        this.queryTask4Config = queryTask4Config;
        this.reportingCacheManager = reportingCacheManager;
        this.task0InitializationAccountingWeekService = task0InitializationAccountingWeekService;
        this.task1InitializationWeekGameBalanceService = task1InitializationWeekGameBalanceService;
        this.task2EventInsertionService = task2EventInsertionService;
        this.task3WinsService = task3WinsService;
        this.task4SalesService = task4SalesService;
        this.task5UpdateStatusService = task5UpdateStatusService;
        this.jobs = jobs;
        this.steps = steps;
    }
}

