/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task3.Win
 *  it.sisal.reporting.wfit.rowmapper.task3.WinRowMapper
 *  org.springframework.jdbc.core.RowMapper
 */
package it.sisal.reporting.wfit.rowmapper.task3;

import it.sisal.reporting.wfit.model.task3.Win;
import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;

public class WinRowMapper
implements RowMapper<Win> {
    public Win mapRow(ResultSet rs, int rowNum) throws java.sql.SQLException {
        Win win = new Win();
        win.setYear(Integer.valueOf(rs.getInt("evt_year")));
        win.setNumber(Integer.valueOf(rs.getInt("evt_number")));
        win.setZoneCode(rs.getString("zone_code"));
        win.setResellerNumber(Integer.valueOf(rs.getInt("rsl_number")));
        win.setOrdWinsAmount(Integer.valueOf(rs.getInt("ord_wins_amount")));
        win.setOptWinsAmount(Integer.valueOf(rs.getInt("opt_wins_amount")));
        win.setOrdWinsQuantity(Integer.valueOf(rs.getInt("ord_wins_quantity")));
        win.setOptWinsQuantity(Integer.valueOf(rs.getInt("opt_wins_quantity")));
        win.setWinsTaxAmount(Integer.valueOf(rs.getInt("wins_tax_amount")));
        win.setWinsQuantity(Integer.valueOf(rs.getInt("wins_quantity")));
        return win;
    }
}

