/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.config.QueryTask4Config
 *  it.sisal.reporting.wfit.exception.ReportingBatchException
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.model.task1.WeekGameBalance
 *  it.sisal.reporting.wfit.model.task4.Sale
 *  it.sisal.reporting.wfit.repository.batch.BatchRepository
 *  it.sisal.reporting.wfit.repository.npl.NplRepository
 *  it.sisal.reporting.wfit.service.Task4SalesService
 *  it.sisal.reporting.wfit.service.Task4SalesServiceImpl
 *  org.springframework.stereotype.Service
 */
package it.sisal.reporting.wfit.service;

import it.sisal.reporting.wfit.config.QueryTask4Config;
import it.sisal.reporting.wfit.exception.ReportingBatchException;
import it.sisal.reporting.wfit.model.task0.AccountingWeek;
import it.sisal.reporting.wfit.model.task1.WeekGameBalance;
import it.sisal.reporting.wfit.model.task4.Sale;
import it.sisal.reporting.wfit.repository.batch.BatchRepository;
import it.sisal.reporting.wfit.repository.npl.NplRepository;
import it.sisal.reporting.wfit.service.Task4SalesService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class Task4SalesServiceImpl
implements Task4SalesService {
    private final BatchRepository batchRepository;
    private final NplRepository nplRepository;
    private final QueryTask4Config queryTask4Config;

    public WeekGameBalance checkWeekBalanceSale(AccountingWeek accountingWeek, Integer salesCode) {
        return this.batchRepository.checkWeekBalanceSale(accountingWeek, salesCode);
    }

    public List<Sale> selectSale(AccountingWeek accountingWeek, Integer saleCode) {
        return switch (saleCode) {
            case 100 -> this.nplRepository.selectSale(accountingWeek, this.queryTask4Config.getSalesByEvent());
            case 110 -> this.nplRepository.selectSale(accountingWeek, this.queryTask4Config.getSalesBySubscription());
            case 120 -> this.nplRepository.selectSale(accountingWeek, this.queryTask4Config.getSalesBySubscriptionDeduction());
            default -> throw new ReportingBatchException("Illegal win code");
        };
    }

    public void mergeSales(AccountingWeek accountingWeek, Integer saleCode, List<Sale> sales) {
        this.batchRepository.mergeSales(accountingWeek, saleCode, sales);
    }

    public Task4SalesServiceImpl(BatchRepository batchRepository, NplRepository nplRepository, QueryTask4Config queryTask4Config) {
        this.batchRepository = batchRepository;
        this.nplRepository = nplRepository;
        this.queryTask4Config = queryTask4Config;
    }
}

