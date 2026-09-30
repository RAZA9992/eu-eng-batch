/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task0.AccountingWeek
 *  it.sisal.reporting.wfit.rowmapper.task0.AccountingWeekRowMapper
 *  org.springframework.jdbc.core.RowMapper
 */
package it.sisal.reporting.wfit.rowmapper.task0;

import it.sisal.reporting.wfit.model.task0.AccountingWeek;
import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;

public class AccountingWeekRowMapper
implements RowMapper<AccountingWeek> {
    public AccountingWeek mapRow(ResultSet rs, int rowNum) throws java.sql.SQLException {
        AccountingWeek accountingWeek = new AccountingWeek();
        accountingWeek.setYear(Integer.valueOf(rs.getInt("year_ref")));
        accountingWeek.setWeek(Integer.valueOf(rs.getInt("week_ref")));
        accountingWeek.setBeginsOn(rs.getTimestamp("begins_on").toLocalDateTime());
        accountingWeek.setEndsOn(rs.getTimestamp("ends_on").toLocalDateTime());
        return accountingWeek;
    }
}

