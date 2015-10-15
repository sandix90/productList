package org.sandaix.productlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by sandakov.a on 13.10.2015.
 */
public class ProductDialog extends DialogFragment implements  View.OnClickListener{

    private OnDialogResultListener callback;

    public interface OnDialogResultListener{
        public void onPositiveResult(String value);
        public void onNegativeResult();

    }

    Button ok,cancel;
    ListView products;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.product_dialog, null);
        int width = getActivity().getResources().getDisplayMetrics().widthPixels;
        int height = getActivity().getResources().getDisplayMetrics().heightPixels;

        getDialog().getWindow().setAttributes(new WindowManager.LayoutParams(width,height));
        ok = (Button) v.findViewById(R.id.ok);
        cancel = (Button) v.findViewById(R.id.cancel);
        ok.setOnClickListener(this);
        cancel.setOnClickListener(this);
        products = (ListView) v.findViewById(R.id.products);
        products.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //callback.onPositiveResult(products.getSelectedItem().toString());
                    callback.onPositiveResult(products.getItemAtPosition(position).toString());
                    dismiss();
            }
        });

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ok:
                break;
            case R.id.cancel:
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

