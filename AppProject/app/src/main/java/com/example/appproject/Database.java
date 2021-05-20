package com.example.appproject;

public class Database {
    static class Alldata {
        static final String TABLE_NAME = "lake";
        static final String COLUMN_NAME_ID = "id";
        static final String COLUMN_NAME_NAME = "name";
        static final String COLUMN_NAME_COMPANY = "company";
        static final String COLUMN_NAME_SIZE = "size";
        static final String COLUMN_NAME_COST = "cost";
        static final String COLUMN_NAME_LOCATION = "location";
        static final String COLUMN_NAME_CATEGORY = "category";
        static final String COLUMN_NAME_DEPTH = "depth";
        static final String COLUMN_NAME_WIKI = "wiki";
    }

    public static final String SQL_CREATE_TABLE_LAKE =
            "CREATE TABLE " + Alldata.TABLE_NAME + " (" +
                Alldata.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                Alldata.COLUMN_NAME_NAME + " TEXT," +
                Alldata.COLUMN_NAME_COMPANY + " TEXT," +
                Alldata.COLUMN_NAME_SIZE + " INT," +
                Alldata.COLUMN_NAME_COST + " INT," +
                Alldata.COLUMN_NAME_LOCATION + " TEXT," +
                Alldata.COLUMN_NAME_CATEGORY + " TEXT," +
                Alldata.COLUMN_NAME_DEPTH + " INT," +
                Alldata.COLUMN_NAME_WIKI + " TEXT)" ;

    public static final String SQL_DELETE_TABLE_LAKE =
            "DROP TABLE IF EXISTS " + Alldata.TABLE_NAME;

}
