package com.test.pharmecyproject.ui.staff;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.test.pharmecyproject.R;
import com.test.pharmecyproject.model.Medicine;
import com.test.pharmecyproject.model.Staff;
import com.test.pharmecyproject.rest.APIClient;
import com.test.pharmecyproject.rest.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProductFragment extends Fragment {
    APIInterface apiInterface;

EditText name,qty,price,img,date;
Spinner spinner;
Button saveBtn,resetBtn;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_addproduct, container, false);
        final TextView textView = root.findViewById(R.id.text_addproduct);


//       textView.setText("test Add");

        insertMedicineList(root);


        return root;
    }
    public void insertMedicineList(View root){
        name = root.findViewById(R.id.addMedicine);
        qty = root.findViewById(R.id.addMediQty);
        price = root.findViewById(R.id.addMediPrice);
        img = root.findViewById(R.id.addMediImg);
        date = root.findViewById(R.id.addMediDate);
//        spinner = root.findViewById(R.id.spinner1);
        saveBtn = root.findViewById(R.id.mediSaveBtn);
        resetBtn =root.findViewById(R.id.mediResetBtn);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText(" ");
                qty.setText(" ");
                price.setText(" ");
                img.setText(" ");
                date.setText(" ");
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiInterface = APIClient.getClient().create(APIInterface.class);
                Medicine medicine = new Medicine();
                medicine.setName(name.getText().toString());
                medicine.setQty(Double.parseDouble(qty.getText().toString()));
                medicine.setPrice(Double.parseDouble(price.getText().toString()));
                medicine.setDate(date.getText().toString());
                medicine.setImg(img.getText().toString());

                Call<Medicine> medicineCall = apiInterface.insertMedeineList(medicine);
                medicineCall.enqueue(new Callback<Medicine>() {
                    @Override
                    public void onResponse(Call<Medicine> call, Response<Medicine> response) {
                      //  Toast.makeText( getContext(), "Successfully Insert ID-"+response.body().getId(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Medicine> call, Throwable t) {

                    }
                });

            }
        });

    }

}