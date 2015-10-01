package org.sandaix.productlist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alex on 9/30/15.
 */
public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context){
        super(context, "sandix_db.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String productsQuery = "CREATE TABLE products (" +
                "id integer primary key autoincrement, " +
                "name nvarchar(50)," +
                "price real," +
                "category integer," +
                "count real," +
                "weight real," +
                "imageIndex integer,"+
                "description text)";
        db.execSQL(productsQuery);

        String categoryQuery = "CREATE TABLE category (" +
                "id integer primary key autoincrement, " +
                "name nvarchar(50))";
        db.execSQL(categoryQuery);

        String productsListQuery = "CREATE TABLE productList (" +
                "id integer primary key autoincrement," +
                "";

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
