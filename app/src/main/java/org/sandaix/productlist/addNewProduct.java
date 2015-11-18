package org.sandaix.productlist;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class addNewProduct extends Activity implements View.OnClickListener{

    Spinner categorySpinner;
    Button ok_btn;
    Button cancel_btn;
    DbHelper dbHelper;
    SQLiteDatabase db;
    EditText productName;
    EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_product);
        dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();

        //unitMeasure = (Spinner) findViewById(R.id.unit_of_measure);
        categorySpinner = (Spinner) findViewById(R.id.category);
        ok_btn = (Button) findViewById(R.id.ok);
        cancel_btn = (Button) findViewById(R.id.cancel);
        ok_btn.setOnClickListener(this);
        cancel_btn.setOnClickListener(this);
        productName = (EditText) findViewById(R.id.product_name);
        description = (EditText) findViewById(R.id.description);


//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,items);
//        unitMeasure.setAdapter(adapter);
//
//        Cursor c = db.query("category",null,null,null,null,null,null);
//        ArrayList<String> categoryList = new ArrayList<String>();
//        if(c.moveToFirst()) {
//            do {
//                categoryList.add(c.getString(c.getColumnIndex("name")));
//            } while (c.moveToNext());
//            ArrayAdapter<String> categoryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, categoryList);
//            categorySpinner.setAdapter(categoryAdapter);
//        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ok:
                ContentValues cv = new ContentValues();
                cv.put("category", 0);
                cv.put("name", productName.getText().toString());
                cv.put("imageIndex", 0);
                cv.put("description", description.getText().toString());
                //cv.put("unitOfMeasure", unitMeasure.getItemIdAtPosition(unitMeasure.getSelectedItemPosition()));
                cv.put("timeStamp", "29.10.2015 15:33");
                db.insert("products", null, cv);
                Toast.makeText(this, "Продукты успешно добавлен", Toast.LENGTH_SHORT).show();
                this.finish();
                break;
            case R.id.cancel:
                break;
        }
    }
}
