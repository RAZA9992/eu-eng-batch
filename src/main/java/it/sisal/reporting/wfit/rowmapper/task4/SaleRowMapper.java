/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task4.Sale
 *  it.sisal.reporting.wfit.rowmapper.task4.SaleRowMapper
 *  org.springframework.jdbc.core.RowMapper
 */
package it.sisal.reporting.wfit.rowmapper.task4;

import it.sisal.reporting.wfit.model.task4.Sale;
import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;

public class SaleRowMapper
implements RowMapper<Sale> {
    public Sale mapRow(ResultSet rs, int rowNum) throws java.sql.SQLException {
        Sale sale = new Sale();
        sale.setYear(Integer.valueOf(rs.getInt("evt_year")));
        sale.setNumber(Integer.valueOf(rs.getInt("evt_number")));
        sale.setZoneCode(rs.getString("rsl_zone_code"));
        sale.setResellerNumber(Integer.valueOf(rs.getInt("rsl_number")));
        sale.setTicketsQuantity(Integer.valueOf(rs.getInt("tickets_quantity")));
        sale.setOrdTicketsQuantity(Integer.valueOf(rs.getInt("ord_tickets_quantity")));
        sale.setOptTicketsQuantity(Integer.valueOf(rs.getInt("opt_tickets_quantity")));
        sale.setOrdCombinations(Integer.valueOf(rs.getInt("ord_combinations")));
        sale.setOptCombinations(Integer.valueOf(rs.getInt("opt_combinations")));
        sale.setOrdDebitAmount(Integer.valueOf(rs.getInt("ord_debit_amount")));
        sale.setOrdCreditAmount(Integer.valueOf(rs.getInt("ord_credit_amount")));
        sale.setOptDebitAmount(Integer.valueOf(rs.getInt("opt_debit_amount")));
        sale.setOptCreditAmount(Integer.valueOf(rs.getInt("opt_credit_amount")));
        return sale;
    }
}

