package org.sandaix.productlist;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.Inflater;

public class ProductsListActivity extends AppCompatActivity implements View.OnClickListener, ProductDialog.OnDialogResultListener {
    FloatingActionButton fab;
    LinearLayout main_root;
    TextView sumPurchased,sumPlaned;
    SimpleDateFormat sdf;
    String currentDateandTime;
    EditText checkName;
    DbHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);
        main_root = (LinearLayout) findViewById(R.id.main_layout);
        sumPurchased = (TextView) findViewById(R.id.purchased);
        sumPlaned = (TextView) findViewById(R.id.sumPlaned);
        sumPlaned.setText("0");
        sumPurchased.setText("0");

        fab = (FloatingActionButton) findViewById(R.id.add_product);
        fab.setOnClickListener(this);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Имя чека");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sdf = new SimpleDateFormat("dd.MM.yyyy");
        currentDateandTime = sdf.format(new Date());
        checkName = (EditText) findViewById(R.id.check_name);
        checkName.setText(currentDateandTime);

        dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_product:
                ProductDialog dialog = new ProductDialog();
                //dialog.setTargetFragment(dialog,0);
                //dialog.setTargetFragment(this,0);
                dialog.show(getSupportFragmentManager(), "ProductDialog");

//                View inf_product = getLayoutInflater().inflate(R.layout.product_item, main_root, false);
//                main_root.addView(inf_product);

                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_productlist, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id == R.id.add_new_product){
            Intent intent = new Intent(this, addNewProduct.class);
            startActivity(intent);
        }
        if(id == android.R.id.home){
            NavUtils.navigateUpTo(this, NavUtils.getParentActivityIntent(this));


        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onPositiveResult(String productName, float productPrice, float productQuantity, String productDescription) {
        Toast.makeText(ProductsListActivity.this, productName, Toast.LENGTH_SHORT).show();
        View product_item = getLayoutInflater().inflate(R.layout.product_item,main_root,false);
        main_root.addView(product_item);
        //product_item.setid
        TextView pName = (TextView) product_item.findViewById(R.id.product_name);
        TextView pSumm = (TextView) product_item.findViewById(R.id.product_summ);
        final CheckBox pStatus = (CheckBox) product_item.findViewById(R.id.product_status);
        pStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View parentView = (View)v.getParent();
                TextView pSumm = (TextView) parentView.findViewById(R.id.product_summ);
                if(pStatus.isChecked()){
                    sumPurchased.setText(String.valueOf(Float.parseFloat(sumPurchased.getText().toString()) + Float.parseFloat(pSumm.getText().toString())));
                }
                else{
                    sumPurchased.setText(String.valueOf(Float.parseFloat(sumPurchased.getText().toString()) - Float.parseFloat(pSumm.getText().toString())));
                }
            }
        });
        pName.setText(productName);
        float result = productPrice*productQuantity;
        sumPlaned.setText(String.valueOf(Float.parseFloat(sumPlaned.getText().toString()) + result));
        pSumm.setText(Float.toString(result));

    }

    @Override
    public void onNegativeResult() {

    }
}
