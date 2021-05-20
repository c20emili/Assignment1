package com.example.appproject;

public class Database {
    static class Lake {
        static final String TABLE_NAME = "lake";
        static final String COLUMN_NAME_ID = "id";
        static final String COLUMN_NAME_NAME = "name";
        static final String COLUMN_NAME_SIZE = "size";
        static final String COLUMN_NAME_COST = "cost";
        static final String COLUMN_NAME_LOCATION = "location";
        static final String COLUMN_NAME_CATEGORY = "category";
        static final String COLUMN_NAME_DEPTH = "depth";
        static final String COLUMN_NAME_WIKI = "wiki";

    }

    public static final String SQL_CREATE_TABLE_LAKE =
            "CREATE TABLE " + Lake.TABLE_NAME + " (" +
                Lake.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                Lake.COLUMN_NAME_NAME + " TEXT," +
                Lake.COLUMN_NAME_SIZE + " INT," +
                Lake.COLUMN_NAME_COST + " INT," +
                Lake.COLUMN_NAME_LOCATION + " TEXT," +
                Lake.COLUMN_NAME_CATEGORY + " TEXT," +
                Lake.COLUMN_NAME_DEPTH + " INT," +
                Lake.COLUMN_NAME_WIKI + " TEXT)" ;

    public static final String SQL_DELETE_TABLE_LAKE =
            "DROP TABLE IF EXISTS " + Lake.TABLE_NAME;

}
