/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.util.QueryParams
 */
package it.sisal.reporting.wfit.util;

public enum QueryParams {
    CACHE_NAME("reportingBatch"),
    DATE_REF("v_date_ref"),
    I_DATE_REF("p_i_date_ref"),
    YEAR_REF("v_year_ref"),
    WEEK_REF("v_week_ref"),
    BEGINS_ON("v_begins_on"),
    ENDS_ON("v_ends_on"),
    GAME_DESCR("v_game_descr"),
    STATUS_DESCR("v_status_descr"),
    GAME_CODE("v_game_code"),
    STATUS_CODE("v_status_code"),
    GAME_DESCRIPTION("VinciCasa"),
    STATUS_CODE_CREATED("1"),
    STATUS_DESCR_CREATED("Created"),
    STATUS_CODE_COMPLETED("3"),
    STATUS_DESCR_COMPLETED("Completed"),
    EVT_YEAR("v_evt_year"),
    EVT_NUMBER("v_evt_number"),
    EVT_DRAW_DAT("v_evt_draw_dt"),
    WINS_CODE("v_wins_type_code"),
    ZONE_CODE("v_zone_code"),
    RSL_NUMBER("v_rsl_number"),
    ORD_WINS_QUANTITY("v_ord_wins_quantity"),
    OPT_WINS_QUANTITY("v_opt_wins_quantity"),
    ORD_WINS_AMOUNT("v_ord_wins_amount"),
    OPT_WINS_AMOUNT("v_opt_wins_amount"),
    WINS_QUANTITY("v_wins_quantity"),
    WINS_TAX_AMOUNT("v_wins_tax_amount"),
    CREATED_ON("v_created_on"),
    UPDATED_ON("v_updated_on"),
    SALES_CODE("v_sales_type_code"),
    TICKETS_QUANTITY("v_tickets_quantity"),
    ORD_TICKETS_QUANTITY("v_ord_tickets_quantity"),
    OPT_TICKETS_QUANTITY("v_opt_tickets_quantity"),
    ORD_COMBINATIONS("v_ord_combinations"),
    OPT_COMBINATIONS("v_opt_combinations"),
    ORD_DEBIT_AMOUNT("v_ord_debit_amount"),
    ORD_CREDIT_AMOUNT("v_ord_credit_amount"),
    OPT_DEBIT_AMOUNT("v_opt_debit_amount"),
    OPT_CREDIT_AMOUNT("v_opt_credit_amount");

    private final String key;

    private QueryParams(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}

