/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task1.WeekGameBalance
 *  it.sisal.reporting.wfit.rowmapper.task1.WeekGameBalanceRowMapper
 *  org.springframework.jdbc.core.RowMapper
 */
package it.sisal.reporting.wfit.rowmapper.task1;

import it.sisal.reporting.wfit.model.task1.WeekGameBalance;
import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;

public class WeekGameBalanceRowMapper
implements RowMapper<WeekGameBalance> {
    public WeekGameBalance mapRow(ResultSet rs, int rowNum) throws java.sql.SQLException {
        WeekGameBalance weekGameBalance = new WeekGameBalance();
        weekGameBalance.setYear(Integer.valueOf(rs.getInt("year_ref")));
        weekGameBalance.setWeek(Integer.valueOf(rs.getInt("week_ref")));
        return weekGameBalance;
    }
}

