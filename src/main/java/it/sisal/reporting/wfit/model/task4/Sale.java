/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.BaseAggregate
 *  it.sisal.reporting.wfit.model.task4.Sale
 */
package it.sisal.reporting.wfit.model.task4;

import it.sisal.reporting.wfit.model.BaseAggregate;

public class Sale
extends BaseAggregate {
    private Integer ticketsQuantity;
    private Integer ordTicketsQuantity;
    private Integer optTicketsQuantity;
    private Integer ordCombinations;
    private Integer optCombinations;
    private Integer ordDebitAmount;
    private Integer ordCreditAmount;
    private Integer optDebitAmount;
    private Integer optCreditAmount;

    public void setTicketsQuantity(Integer ticketsQuantity) {
        this.ticketsQuantity = ticketsQuantity;
    }

    public void setOrdTicketsQuantity(Integer ordTicketsQuantity) {
        this.ordTicketsQuantity = ordTicketsQuantity;
    }

    public void setOptTicketsQuantity(Integer optTicketsQuantity) {
        this.optTicketsQuantity = optTicketsQuantity;
    }

    public void setOrdCombinations(Integer ordCombinations) {
        this.ordCombinations = ordCombinations;
    }

    public void setOptCombinations(Integer optCombinations) {
        this.optCombinations = optCombinations;
    }

    public void setOrdDebitAmount(Integer ordDebitAmount) {
        this.ordDebitAmount = ordDebitAmount;
    }

    public void setOrdCreditAmount(Integer ordCreditAmount) {
        this.ordCreditAmount = ordCreditAmount;
    }

    public void setOptDebitAmount(Integer optDebitAmount) {
        this.optDebitAmount = optDebitAmount;
    }

    public void setOptCreditAmount(Integer optCreditAmount) {
        this.optCreditAmount = optCreditAmount;
    }

    public Integer getTicketsQuantity() {
        return this.ticketsQuantity;
    }

    public Integer getOrdTicketsQuantity() {
        return this.ordTicketsQuantity;
    }

    public Integer getOptTicketsQuantity() {
        return this.optTicketsQuantity;
    }

    public Integer getOrdCombinations() {
        return this.ordCombinations;
    }

    public Integer getOptCombinations() {
        return this.optCombinations;
    }

    public Integer getOrdDebitAmount() {
        return this.ordDebitAmount;
    }

    public Integer getOrdCreditAmount() {
        return this.ordCreditAmount;
    }

    public Integer getOptDebitAmount() {
        return this.optDebitAmount;
    }

    public Integer getOptCreditAmount() {
        return this.optCreditAmount;
    }

    public String toString() {
        return "Sale(ticketsQuantity=" + this.getTicketsQuantity() + ", ordTicketsQuantity=" + this.getOrdTicketsQuantity() + ", optTicketsQuantity=" + this.getOptTicketsQuantity() + ", ordCombinations=" + this.getOrdCombinations() + ", optCombinations=" + this.getOptCombinations() + ", ordDebitAmount=" + this.getOrdDebitAmount() + ", ordCreditAmount=" + this.getOrdCreditAmount() + ", optDebitAmount=" + this.getOptDebitAmount() + ", optCreditAmount=" + this.getOptCreditAmount() + ")";
    }
}

