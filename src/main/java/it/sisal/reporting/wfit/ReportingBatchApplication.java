/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.ReportingBatchApplication
 *  org.springframework.boot.SpringApplication
 *  org.springframework.boot.autoconfigure.SpringBootApplication
 *  org.springframework.scheduling.annotation.EnableScheduling
 */
package it.sisal.reporting.wfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ReportingBatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReportingBatchApplication.class, (String[])new String[0]);
    }
}

