package com.test.pharmecyproject.ui.sale;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.test.pharmecyproject.R;
import com.test.pharmecyproject.model.Medicine;
import com.test.pharmecyproject.model.Sale;
import com.test.pharmecyproject.model.Staff;
import com.test.pharmecyproject.rest.APIClient;
import com.test.pharmecyproject.rest.APIInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewSale extends Fragment {

    TableLayout tableLayout;

    List<Sale> sales=new ArrayList<>();

    APIInterface apiInterface;
    TextView name,qty,price;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_view_sale, container, false);
        final TextView textView = root.findViewById(R.id.text_sales_view);


        tableLayout = root.findViewById(R.id.tableList);
        loadTableList();

        APIInterface apiInterface= APIClient.getClient().create(APIInterface.class);
        final Call<List<Sale>> saleList = apiInterface.getSale();
        saleList.enqueue(new Callback<List<Sale>>() {
            @Override
            public void onResponse(Call<List<Sale>> call, Response<List<Sale>> response) {
                sales = response.body();

                TableRow tableRow1 = new TableRow(getContext());
                tableRow1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.WRAP_CONTENT));
                TextView header1 = new TextView(getContext());
                header1.setText("Name");
                header1.setTextSize(15);
                tableRow1.addView(header1,0);

                TextView header2 = new TextView(getContext());
                header2.setText("Quatity");
                header2.setTextSize(15);
                tableRow1.addView(header2,1);

                TextView header3 = new TextView(getContext());
                header3.setText("Price");
                header3.setTextSize(15);
                tableRow1.addView(header3,2);

//                TextView header4 = new TextView(getContext());
//                header4.setText("subTotal");
//                header4.setTextSize(15);
//                tableRow1.addView(header4,3);

                TextView header4 = new TextView(getContext());
                header4.setText("Discount");
                header4.setTextSize(15);
                tableRow1.addView(header4,3);




                TextView header5 = new TextView(getContext());
                header5.setText("Total");
                header5.setTextSize(15);
                tableRow1.addView(header5,4);


//                Button actin = new Button(getContext());
//                actin.setText("Edit");
//                tableRow1.addView(actin,3);

                tableLayout.addView(tableRow1,new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,TableLayout.LayoutParams.MATCH_PARENT));
                loadTableList();

            }

            @Override
            public void onFailure(Call<List<Sale>> call, Throwable t) {

            }
        });

        return root;
    }

    public void loadTableList() {



        for(int i = 0; i< sales.size(); i++){
            TableRow row = new TableRow(getContext());
            TextView name = new TextView(getContext());
            TextView qty = new TextView(getContext());
            TextView price = new TextView(getContext());
            TextView disc = new TextView(getContext());
//            TextView subTotal = new TextView(getContext());
            TextView total = new TextView(getContext());

            name.setText(sales.get(i).getName());
            qty.setText(Double.toString(sales.get(i).getQty()));
            price.setText(Double.toString(sales.get(i).getPrice()));
            disc.setText(Double.toString(sales.get(i).getDiscount()));
//            subTotal.setText(Double.toString(sales.get(i).getSubTotal()));
            total.setText(Double.toString(sales.get(i).getTotal()));
//            edit.setText("Edit");









            row.addView(name,0);
            row.addView(qty,1);
            row.addView(price,2);
//            row.addView(subTotal,3);
            row.addView(disc,3);
            row.addView(total,4);
            //            row.addView(name,0);

            tableLayout.addView(row,new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }
}