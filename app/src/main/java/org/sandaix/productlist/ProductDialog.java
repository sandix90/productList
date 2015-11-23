package org.sandaix.productlist;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandakov.a on 13.10.2015.
 */
public class ProductDialog extends DialogFragment implements  View.OnClickListener{

    private OnDialogResultListener callback;

    public interface OnDialogResultListener{
        public void onPositiveResult(String nameProduct, float price, float quantity, String description );
        public void onNegativeResult();

    }

    Button ok,cancel;
    ListView products;
    DbHelper dbHelper;
    SQLiteDatabase db;
    Spinner unitOfMeasure;
    EditText productName, productPrice, productQuantity, productDescription;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.product_dialog, null);
//        int width = getActivity().getResources().getDisplayMetrics().widthPixels;
//        int height = getActivity().getResources().getDisplayMetrics().heightPixels;
//
//        getDialog().getWindow().setAttributes(new WindowManager.LayoutParams(width,height));

        ok = (Button) v.findViewById(R.id.ok);
        cancel = (Button) v.findViewById(R.id.cancel);
        ok.setOnClickListener(this);
        cancel.setOnClickListener(this);
        unitOfMeasure = (Spinner) v.findViewById(R.id.unit_of_measure);
        productName = (EditText) v.findViewById(R.id.product_name);
        productPrice = (EditText) v.findViewById(R.id.product_price);
        productQuantity = (EditText) v.findViewById(R.id.product_quantity);
        productDescription = (EditText) v.findViewById(R.id.description);

        String items[] = new String[5];
        items[0] = "units";
        items[1] = "kg.";
        items[2] = "liters";
        items[3] = "meters";
        items[4] = "pack";
        unitOfMeasure.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, items));

//        products = (ListView) v.findViewById(R.id.products);
//
//        dbHelper = new DbHelper(getActivity());
//        db = dbHelper.getWritableDatabase();
//        List<String> productsList = new ArrayList<String>();
//        Cursor c = db.query("products",null,null,null,null,null,null);
//        if(c.moveToFirst())
//        {
//            do{
//                productsList.add(c.getString(c.getColumnIndex("name")));
//            }while(c.moveToNext());
//        }
//        //String[] e = productsList.toArray(new String[productsList.size()]);
//
//
//        ArrayAdapter<String> productsAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line, productsList );
//        products.setAdapter(productsAdapter);
//
//
//        products.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    //callback.onPositiveResult(products.getSelectedItem().toString());
//                    callback.onPositiveResult(products.getItemAtPosition(position).toString());
//                    dismiss();
//            }
//        });

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ok:
                    if(!productName.getText().toString().equals("") &&
                    !productPrice.getText().toString().equals("") &&
                    !productQuantity.getText().toString().equals("")) {
                        callback.onPositiveResult(productName.getText().toString(),
                                Float.parseFloat(productPrice.getText().toString()),
                                Float.parseFloat(productQuantity.getText().toString()),
                                productDescription.getText().toString());
                        this.dismiss();
                    }
                    else{
                        Toast.makeText(getActivity(),"Some fields are empty",Toast.LENGTH_SHORT).show();
                    }

                break;
            case R.id.cancel:
                this.dismiss();
                break;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setStyle(STYLE_NORMAL, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar);
        //setStyle(STYLE_NORMAL, R.style.AppTheme_CustomDialog);
        //getActivity();

        callback = (OnDialogResultListener)getActivity();


    }
}

