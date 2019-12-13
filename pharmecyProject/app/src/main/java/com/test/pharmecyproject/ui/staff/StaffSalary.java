package com.test.pharmecyproject.ui.staff;

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
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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

public class StaffSalary extends Fragment {
    APIInterface apiInterface;
//    TextView textView1;
    TableLayout tableLayout;
    List<Staff> staff=new ArrayList<>();
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_staff_salary, container, false);
        final TextView textView = root.findViewById(R.id.text_salary);
        tableLayout = root.findViewById(R.id.tableSalary);


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
                header1.setText("Name");
                header1.setTextSize(15);
                tableRow1.addView(header1,0);


                TextView header2 = new TextView(getContext());
                header2.setText("Basic-Salary");
                header2.setTextSize(15);
                tableRow1.addView(header2,1);

                TextView header3 = new TextView(getContext());
                header3.setText("MLW");
                header3.setTextSize(15);
                tableRow1.addView(header3,2);


                TextView header4 = new TextView(getContext());
                header4.setText("Total");
                header4.setTextSize(20);
                tableRow1.addView(header4,3);


//                TextView actin = new TextView(getContext());
//                actin.setText("TotalSalary");
//                tableRow1.addView(actin,2);
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
            final TextView name = new TextView(getContext());
            final TextView mlw = new TextView(getContext());
            final TextView bsalary = new TextView(getContext());
            final TextView total = new TextView(getContext());

            name.setText(staff.get(i).getName().toString());
            mlw.setText(Double.toString(staff.get(i).getMalw()));
            bsalary.setText(Double.toString(staff.get(i).getBsalary()));
            total.setText(Double.toString(staff.get(i).getTotal()));


            row.addView(name,0);
            row.addView(bsalary,1);
            row.addView(mlw,2);
            row.addView(total,3);
            tableLayout.addView(row,new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }

}
