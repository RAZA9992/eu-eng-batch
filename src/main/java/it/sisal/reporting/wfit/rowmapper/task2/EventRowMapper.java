/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.model.task2.Event
 *  it.sisal.reporting.wfit.rowmapper.task2.EventRowMapper
 *  org.springframework.jdbc.core.RowMapper
 */
package it.sisal.reporting.wfit.rowmapper.task2;

import it.sisal.reporting.wfit.model.task2.Event;
import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;

public class EventRowMapper
implements RowMapper<Event> {
    public Event mapRow(ResultSet rs, int rowNum) throws java.sql.SQLException {
        Event event = new Event();
        event.setYear(Integer.valueOf(rs.getInt("evt_year")));
        event.setNumber(Integer.valueOf(rs.getInt("evt_number")));
        event.setDrawDate(rs.getTimestamp("evt_draw_dt").toLocalDateTime());
        return event;
    }
}

