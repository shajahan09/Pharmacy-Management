package com.test.pharmecyproject.ui.staff;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.test.pharmecyproject.R;
import com.test.pharmecyproject.model.Staff;
import com.test.pharmecyproject.rest.APIClient;
import com.test.pharmecyproject.rest.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddStaff extends Fragment {
    APIInterface apiInterface;

    EditText name,bsalary,malw,id,phone,total;

    Button saveBtn,reset;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_addstaff, container, false);
        final TextView textView = root.findViewById(R.id.text_addStaff);

        insertStaffList(root);

        return root;
    }

    public void insertStaffList(View root){
        id = root.findViewById(R.id.sId);
        phone = root.findViewById(R.id.sPhn);
        name = root.findViewById(R.id.sName);
        bsalary = root.findViewById(R.id.basicSalary);
        malw = root.findViewById(R.id.mediAlw);
        saveBtn = root.findViewById(R.id.saveStaff);
        reset = root.findViewById(R.id.resetStaff);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText(" ");
                bsalary.setText(" ");
                malw.setText(" ");
                id.setText(" ");
                phone.setText(" ");

            }
        });


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiInterface = APIClient.getClient().create(APIInterface.class);

                Staff staff = new Staff();
                staff.setName(name.getText().toString());
                staff.setUserId(Integer.parseInt(id.getText().toString()));
                staff.setPhone(Integer.parseInt(phone.getText().toString()));
                staff.setName(name.getText().toString());
                staff.setBsalary(Double.parseDouble(bsalary.getText().toString()));
                staff.setMalw(Double.parseDouble(malw.getText().toString()));
                staff.setTotal(Double.parseDouble(bsalary.getText().toString()) + Double.parseDouble(malw.getText().toString()));
                Call<Staff> productCall = apiInterface.insertStaffList(staff);
                productCall.enqueue(new Callback<Staff>() {
                    @Override
                    public void onResponse(Call<Staff> call, Response<Staff> response) {
                        Toast.makeText( getContext(), "Successfully Insert ID-"+response.body().getId(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<Staff> call, Throwable t) {

                    }
                });
            }
        });

    }
}