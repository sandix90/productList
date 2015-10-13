package org.sandaix.productlist;

import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ProductsListActivity extends AppCompatActivity implements View.OnClickListener, ProductDialog.OnDialogResultListener {
    FloatingActionButton fab;
    LinearLayout main_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);
        main_root = (LinearLayout) findViewById(R.id.main_layout);

        fab = (FloatingActionButton) findViewById(R.id.add_product);
        fab.setOnClickListener(this);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Имя чека");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_product:
                ProductDialog dialog = new ProductDialog();
                dialog.setTargetFragment(dialog,0);
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
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onPositiveResult(String value) {
        Toast.makeText(ProductsListActivity.this, value, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNegativeResult() {

    }
}
