package org.sandaix.productlist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView add_check;
    LinearLayout checkInfLayout,mainLayout;
    LayoutInflater inflater;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_check = (ImageView) findViewById(R.id.add_check);
        add_check.setOnClickListener(this);
        checkInfLayout = (LinearLayout) findViewById(R.id.check_root_layout);
        mainLayout = (LinearLayout) findViewById(R.id.main_layout);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        inflater = getLayoutInflater();
        context = this;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_check:
                Intent intent = new Intent(getApplicationContext(), ProductsListActivity.class);
                startActivity(intent);
//                View inflateView = inflater.inflate(R.layout.checkitem, mainLayout, false);
//                mainLayout.addView(inflateView);
//                inflateView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(getApplicationContext(), ProductsListActivity.class);
//                        startActivity(intent);
//                    }
//                });
                break;

        }
    }
}
