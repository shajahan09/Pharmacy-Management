package com.test.pharmecyproject.ui.staff;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.test.pharmecyproject.R;
import com.test.pharmecyproject.model.Medicine;
import com.test.pharmecyproject.model.Staff;
import com.test.pharmecyproject.rest.APIClient;
import com.test.pharmecyproject.rest.APIInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StaffView extends Fragment {
    TableLayout tableLayout;

    List<Staff> staff=new ArrayList<>();



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//       return super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_staff_view, container, false);
        TextView textView = root.findViewById(R.id.text_viewStaff);

//            initData();

//            textView.setText("All Staff");
            tableLayout = root.findViewById(R.id.tableview);
            loadTable();

        APIInterface apiInterface= APIClient.getClient().create(APIInterface.class);
        final Call<List<Staff>> staffList = apiInterface.getStaff();
        staffList.enqueue(new Callback<List<Staff>>() {
            @Override
            public void onResponse(Call<List<Staff>> call, Response<List<Staff>> response) {
//                staff = new ArrayList<>();
                staff = response.body();

                TableRow tableRow1 = new TableRow(getContext());
                tableRow1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.WRAP_CONTENT));
                TextView header1 = new TextView(getContext());
                header1.setText("EMP-ID");
                header1.setTextSize(15);
                tableRow1.addView(header1,0);

                TextView header2 = new TextView(getContext());
                header2.setText("Name");
                header2.setTextSize(15);
                tableRow1.addView(header2,1);

                TextView header3 = new TextView(getContext());
                header3.setText("Phone");
                header3.setTextSize(15);
                tableRow1.addView(header3,2);

                TextView header4 = new TextView(getContext());
                header4.setText("Edit");
                header4.setTextSize(15);
                tableRow1.addView(header4,3);


//                Button actin = new Button(getContext());
//                actin.setText("Edit");
//                tableRow1.addView(actin,3);

                tableLayout.addView(tableRow1,new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,TableLayout.LayoutParams.MATCH_PARENT));
                loadTable();
            }

            @Override
            public void onFailure(Call<List<Staff>> call, Throwable t) {

            }
        });
        return root;

    }

    public void loadTable() {



        for(int i = 0; i< staff.size(); i++){
            TableRow row = new TableRow(getContext());
            Button id = new Button(getContext());
            Button name = new Button(getContext());
            Button phone = new Button(getContext());
            Button edit = new Button(getContext());

            name.setText(staff.get(i).getName().toString());
            id.setText(Integer.toString(staff.get(i).getUserId()));
            phone.setText(Integer.toString(staff.get(i).getPhone()));
            edit.setText("Edit");




            phone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Medicine medi = new Medicine();
                    AlertDialog.Builder alert  = new AlertDialog.Builder(getContext());
                    alert.setMessage("Are You Call this Employee?");
                    alert.setTitle(medi.getName());
                    alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getContext(),"please checked Your Connection",Toast.LENGTH_LONG).show();

                        }
                    });
                    alert.show();


                }
            });



            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {





                }
            });



            row.addView(id,0);
            row.addView(name,1);
            row.addView(phone,2);
            row.addView(edit,3);
            tableLayout.addView(row,new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }


}
