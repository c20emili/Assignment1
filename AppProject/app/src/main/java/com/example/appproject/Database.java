package com.example.appproject;

import com.google.gson.annotations.SerializedName;

public class Database {
    static class Lake {
        static final String MAIN_TABLE_NAME = "lake";
        static final String COLUMN_NAME_ID = "id";
        static final String COLUMN_NAME_NAME = "name";
        static final String COLUMN_NAME_COMPANY = "company";
        static final String COLUMN_NAME_SIZE = "size";
        static final String COLUMN_NAME_COST = "cost";
        static final String COLUMN_NAME_LOCATION = "location";
        static final String COLUMN_NAME_CATEGORY = "category";
    }

    public static final String SQL_CREATE_TABLE_LAKE =
            "CREATE TABLE " + Lake.MAIN_TABLE_NAME + " (" +
                Lake.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                Lake.COLUMN_NAME_NAME + " TEXT," +
                Lake.COLUMN_NAME_COMPANY + " TEXT," +
                Lake.COLUMN_NAME_SIZE + " INT," +
                Lake.COLUMN_NAME_COST + " INT," +
                Lake.COLUMN_NAME_LOCATION + " TEXT," +
                Lake.COLUMN_NAME_CATEGORY + " TEXT) ";

    public static final String SQL_DELETE_TABLE_LAKE =
            "DROP TABLE IF EXISTS " + Lake.MAIN_TABLE_NAME;

    static class Auxdata{
        static final String AUX_TABLE_NAME = "auxdata";
        static final String COLUMN_NAME_DEPTH = "depth";
        static final String COLUMN_NAME_WIKI = "wiki";
        static final String COLUMN_NAME_IMG = "img";
    }

    public static final String SQL_CREATE_TABLE_AUX =
            "CREATE TABLE " + Auxdata.AUX_TABLE_NAME + " (" +
                    Lake.COLUMN_NAME_ID + " INTEGER FOREIGN PRIMARY KEY," +
                    Auxdata.COLUMN_NAME_DEPTH + " TEXT," +
                    Auxdata.COLUMN_NAME_WIKI + " TEXT," +
                    Auxdata.COLUMN_NAME_IMG + " TEXT" +
                    Fish.COLUMN_NAME_LATIN + " INTEGER FOREIGN KEY)";

    public static final String SQL_DELETE_TABLE_AUX =
            "DROP TABLE IF EXISTS " + Auxdata.AUX_TABLE_NAME;

    static class Fish{
        static final String FISH_TABLE_NAME = "fish";
        static final String COLUMN_NAME_MINLENGHT = "minLength";
        static final String COLUMN_NAME_MAXLENGHT = "maxLength";
        static final String COLUMN_NAME_MINWEIGHT = "minWeight";
        static final String COLUMN_NAME_MAXWEIGHT = "maxWeight";
        static final String COLUMN_NAME_LATIN = "latin";
    }

    public static final String SQL_CREATE_TABLE_FISH =
            "CREATE TABLE " + Fish.FISH_TABLE_NAME + " (" +
                    Fish.COLUMN_NAME_LATIN + " INTEGER PRIMARY KEY," +
                    Fish.COLUMN_NAME_MINLENGHT + " INT," +
                    Fish.COLUMN_NAME_MAXLENGHT + " INT," +
                    Fish.COLUMN_NAME_MINWEIGHT + " INT," +
                    Fish.COLUMN_NAME_MAXWEIGHT + " INT)";

    public static final String SQL_DELETE_TABLE_FISH =
            "DROP TABLE IF EXISTS " + Fish.FISH_TABLE_NAME;
}
