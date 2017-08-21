package com.e_wallet.util;

/**
 * Created by Redpike
 */
public class DbObjectNameUtil {

    /**
     * DATABASE OBJECT PREFIXES
     */
    private static final String TABLE_PREFIX = "T_";

    /**
     * SCHEMA NAME
     */
    public static final String SCHEMA = "e_wallet";

    /**
     * TABLE NAMES
     */
    public static final String USERS_TABLE = TABLE_PREFIX + "USERS";
    public static final String ROLES_TABLE = TABLE_PREFIX + "ROLES";
    public static final String GROUP_ROLES_TABLE = TABLE_PREFIX + "GROUP_ROLES";
    public static final String GROUPS_TABLE = TABLE_PREFIX + "GROUPS";
    public static final String USER_GROUPS_TABLE = TABLE_PREFIX + "USER_GROUPS";
    public static final String PRIVILEGES_TABLE = TABLE_PREFIX + "PRIVILEGES";
    public static final String SAVING_TYPES_TABLE = TABLE_PREFIX + "SAVING_TYPES";
    public static final String SAVINGS_TABLE = TABLE_PREFIX + "SAVINGS";
    public static final String CURRENCY_TABLE = TABLE_PREFIX + "CURRENCY";
    public static final String CURRENCY_RATES_TABLE = TABLE_PREFIX + "CURRENCY_RATES";
    public static final String INCOMES_TABLE = TABLE_PREFIX + "INCOMES";
    public static final String INCOME_TYPES_TABLE = TABLE_PREFIX + "INCOME_TYPES";
    public static final String EXPENSES_TABLE = TABLE_PREFIX + "EXPENSES";
    public static final String EXPENSE_TYPES_TABLE = TABLE_PREFIX + "EXPENSE_TYPES";
}
