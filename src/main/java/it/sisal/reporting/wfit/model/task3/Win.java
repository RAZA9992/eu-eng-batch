/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.BaseAggregate
 *  it.sisal.reporting.wfit.model.task3.Win
 */
package it.sisal.reporting.wfit.model.task3;

import it.sisal.reporting.wfit.model.BaseAggregate;

public class Win
extends BaseAggregate {
    private Integer ordWinsAmount;
    private Integer optWinsAmount;
    private Integer ordWinsQuantity;
    private Integer optWinsQuantity;
    private Integer winsTaxAmount;
    private Integer winsQuantity;

    public void setOrdWinsAmount(Integer ordWinsAmount) {
        this.ordWinsAmount = ordWinsAmount;
    }

    public void setOptWinsAmount(Integer optWinsAmount) {
        this.optWinsAmount = optWinsAmount;
    }

    public void setOrdWinsQuantity(Integer ordWinsQuantity) {
        this.ordWinsQuantity = ordWinsQuantity;
    }

    public void setOptWinsQuantity(Integer optWinsQuantity) {
        this.optWinsQuantity = optWinsQuantity;
    }

    public void setWinsTaxAmount(Integer winsTaxAmount) {
        this.winsTaxAmount = winsTaxAmount;
    }

    public void setWinsQuantity(Integer winsQuantity) {
        this.winsQuantity = winsQuantity;
    }

    public Integer getOrdWinsAmount() {
        return this.ordWinsAmount;
    }

    public Integer getOptWinsAmount() {
        return this.optWinsAmount;
    }

    public Integer getOrdWinsQuantity() {
        return this.ordWinsQuantity;
    }

    public Integer getOptWinsQuantity() {
        return this.optWinsQuantity;
    }

    public Integer getWinsTaxAmount() {
        return this.winsTaxAmount;
    }

    public Integer getWinsQuantity() {
        return this.winsQuantity;
    }

    public String toString() {
        return "Win(ordWinsAmount=" + this.getOrdWinsAmount() + ", optWinsAmount=" + this.getOptWinsAmount() + ", ordWinsQuantity=" + this.getOrdWinsQuantity() + ", optWinsQuantity=" + this.getOptWinsQuantity() + ", winsTaxAmount=" + this.getWinsTaxAmount() + ", winsQuantity=" + this.getWinsQuantity() + ")";
    }
}

