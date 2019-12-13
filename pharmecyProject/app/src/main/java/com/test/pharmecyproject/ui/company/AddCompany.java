package com.test.pharmecyproject.ui.company;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.test.pharmecyproject.R;
import com.test.pharmecyproject.model.Company;
import com.test.pharmecyproject.model.Staff;
import com.test.pharmecyproject.rest.APIClient;
import com.test.pharmecyproject.rest.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCompany extends Fragment {

    APIInterface apiInterface;

    EditText name,email,catagory;

    Button saveBtn,reset;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.activity_addcompany, container, false);
        TextView textView = root.findViewById(R.id.text_addcom);

        insertStaffList(root);

        return root;
    }


    public void insertStaffList(View root){
        name = root.findViewById(R.id.comName);
        email = root.findViewById(R.id.comEmail);
//        catagory = root.findViewById(R.id.sName);

        saveBtn = root.findViewById(R.id.saveCompany);
        reset = root.findViewById(R.id.resetCompany);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText(" ");
                email.setText(" ");

            }
        });


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiInterface = APIClient.getClient().create(APIInterface.class);

                Company company = new Company();
                company.setName(name.getText().toString());
                company.setEmail(email.getText().toString());

                Call<Company> productCall = apiInterface.insertStaffList(company);
                productCall.enqueue(new Callback<Company>() {
                    @Override
                    public void onResponse(Call<Company> call, Response<Company> response) {
                        Toast.makeText( getContext(), "Successfull Insert-", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Company> call, Throwable t) {
                        Toast.makeText( getContext(), "Failed Insert-", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

    }


}
