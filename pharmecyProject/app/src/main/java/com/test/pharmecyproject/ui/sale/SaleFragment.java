package com.test.pharmecyproject.ui.sale;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
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

public class SaleFragment extends Fragment {
    APIInterface apiInterface;
    List<Sale> sales =new ArrayList<>();

    int posation;
    Button saleadd,totalBtn,resetBtn;
    TextView subTotal,total;
    EditText qty,price,dis;
    Double res;
    AutoCompleteTextView autoCompleteTextView;
    public SaleFragment(){

    }



    private static  final  String[] medicines = new String[]{
            "Napa","Ace","Seclo","Paracitamle","Naprox","Depodil",
            "NapaExtra"};
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tools, container, false);

       TextView textView = root.findViewById(R.id.text_sale);

       autoCompleteTextView = root.findViewById(R.id.autoCom);



        subTotal =root.findViewById(R.id.subTotal);
        saleadd= root.findViewById(R.id.saleadd);

        total = root.findViewById(R.id.totalSale);
        totalBtn = root.findViewById(R.id.netTotal);
        resetBtn = root.findViewById(R.id.fReset);


           qty = root.findViewById(R.id.fQty);
        price = root.findViewById(R.id.fPrice);
         dis = root.findViewById(R.id.discountSale);


        AutoCompleteTextView autoCompleteTextView = root.findViewById(R.id.autoCom);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, medicines);
        autoCompleteTextView.setAdapter(adapter);

        if(medicines.equals("Napa")){
            posation=1;

        }if(medicines.equals("Ace")){
            posation=2;

        }

        saleadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String qt=qty.getText().toString();
                Double mnum1=Double.parseDouble(qt);

                String pr=price.getText().toString();
                Double mnum2=Double.parseDouble(pr);
                res=mnum1*mnum2;




                subTotal.setText(Double.toString(res));



            }
        });
        totalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String disc = dis.getText().toString();
                Double num3 = Double.parseDouble(disc)/100;
                Double resultparsent = res * num3;
                total.setText(Double.toString(res - resultparsent));

                addSale();







            }
        });
//        resetBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                qty.setText(" ");
//                price.setText(" ");
//                dis.setText(" ");
//
//            }
//        });


        return root;
    }



public void addSale(){
    apiInterface = APIClient.getClient().create(APIInterface.class);
    Sale sale = new Sale();
    String auto =autoCompleteTextView.getText().toString();

    sale.setName(auto);
    sale.setPrice(Double.parseDouble(price.getText().toString()));
    sale.setQty(Double.parseDouble(qty.getText().toString()));
    sale.setDiscount(Double.parseDouble(dis.getText().toString()));
    sale.setSubTotal(Double.parseDouble(subTotal.getText().toString()));
    sale.setTotal(Double.parseDouble(total.getText().toString()));


    Call<Sale> saleCall = apiInterface.insertSaleList(sale);
    saleCall.enqueue(new Callback<Sale>() {
        @Override
        public void onResponse(Call<Sale> call, Response<Sale> response) {
            Toast.makeText( getContext(), "Successfull Insert",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailure(Call<Sale> call, Throwable t) {
            Toast.makeText( getContext(), "Failed Insert",Toast.LENGTH_SHORT).show();

        }
    });

}
}