package com.test.pharmecyproject.ui.company;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.test.pharmecyproject.R;
import com.test.pharmecyproject.model.Company;
import com.test.pharmecyproject.model.Staff;
import com.test.pharmecyproject.rest.APIClient;
import com.test.pharmecyproject.rest.APIInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewCompany extends Fragment {
    TableLayout tableLayout;

    List<Company> company = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_view_company, container, false);
        TextView textView = root.findViewById(R.id.text_staffModify);

//        textView.setText("this is Staff Modify Page");
        tableLayout = root.findViewById(R.id.tableview2);
        loadTable();
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        final Call<List<Company>> copanyList = apiInterface.getCompany();
        copanyList.enqueue(new Callback<List<Company>>() {
            @Override
            public void onResponse(Call<List<Company>> call, Response<List<Company>> response) {
                company = response.body();

                TableRow tableRow1 = new TableRow(getContext());
                tableRow1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                TextView header1 = new TextView(getContext());
                header1.setText("Company-Name");
                header1.setTextSize(15);
                tableRow1.addView(header1, 0);

                TextView header2 = new TextView(getContext());
                header2.setText("Company-Email");
                header2.setTextSize(15);
                tableRow1.addView(header2, 1);


//                Button actin = new Button(getContext());
//                actin.setText("Edit");
//                tableRow1.addView(actin,3);

                tableLayout.addView(tableRow1, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.MATCH_PARENT));
                loadTable();
            }

            @Override
            public void onFailure(Call<List<Company>> call, Throwable t) {

            }
        });


        return root;
    }

    public void loadTable() {


        for (int i = 0; i < company.size(); i++) {
            TableRow row = new TableRow(getContext());

            Button name = new Button(getContext());
            Button email = new Button(getContext());

            name.setText(company.get(i).getName().toString());
            email.setText(company.get(i).getEmail());



            row.addView(name,0);
            row.addView(email,1);

            tableLayout.addView(row,new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));

        }
    }
}
