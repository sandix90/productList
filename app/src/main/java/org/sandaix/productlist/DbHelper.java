package org.sandaix.productlist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alex on 9/30/15.
 */
public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context){
        super(context, "sandix.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String productsQuery = "CREATE TABLE products (" +
                "id integer primary key autoincrement," +
                "category integer," +
                "name nvarchar(50)," +
                "imageIndex integer,"+
                "description text," +
                "timestamp datetime)";
        db.execSQL(productsQuery);

        String checkListQuery = "CREATE TABLE checkList (" +
                "id integer primary key autoincrement," +
                "name nvarchar(100)," +
                "items_count integer," +
                "items_bought integer, "+
                "datetime datetime)";
        db.execSQL(checkListQuery);

        String  checkProductsQuery = "CREATE TABLE checkProduct (" +
                "id integer primary key autoincrement," +
                "checkList_id integer REFERENCES checkList(id) ," +
                "product_id integer REFERENCES products(id)," +
                "status integer," +
                "price real," +
                "count real," +
                "description text)";
        db.execSQL(checkProductsQuery);

        String categoryQuery = "CREATE TABLE category (" +
                "id integer primary key autoincrement, " +
                "name nvarchar(50)," +
                "description text," +
                "timestamp datetime)";
        db.execSQL(categoryQuery);

        String imagesQuery = "CREATE TABLE images (" +
                "id integer primary key autoincrement," +
                "path nvarchar(400)," +
                "timestamp datetime)";
        db.execSQL(imagesQuery);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
