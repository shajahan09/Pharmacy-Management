package com.test.pharmecyproject.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.test.pharmecyproject.R;
import com.test.pharmecyproject.model.HomeListItem;
import com.test.pharmecyproject.model.Medicine;
import com.test.pharmecyproject.model.Staff;
import com.test.pharmecyproject.rest.APIClient;
import com.test.pharmecyproject.rest.APIInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StockViewFragment extends Fragment {
    APIInterface apiInterface;
    List<Medicine> listItems= new ArrayList<>();
    CustomHomeAdapter homeAdapter;
    ListView listView;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
         listView = root.findViewById(R.id.home_list);


//                listItems = new ArrayList<>();
//        listItems.add(new HomeListItem("Ace","\"https://beximcopharma.com/images/sobipro/product-pic/napa-iv.jpghttp://www.squarepharma.com.bd/products/ACE-SYRUP-100.jpg",250,1,10));
////        listItems.add(new HomeListItem("Ace","https://beximcopharma.com/images/sobipro/product-pic/napa-iv.jpghttp://www.squarepharma.com.bd/products/ACE-SYRUP-100.jpg",110,1,10));
//        listItems.add(new HomeListItem("Seclo","http://www.squarepharma.com.bd/products/SECLO-40_l1.jpg",250,1,10));
//        listItems.add(new HomeListItem("Napa","http://officeneeds.com.bd/media/catalog/product/cache/1/thumbnail/600x/d22404af19680639189bc055fa7ef2d2/n/a/napa_extra_epharma_10_pcs_tk25.jpg",50,1,10));
//        listItems.add(new HomeListItem("Ace","http://www.squarepharma.com.bd/products/ACE-SUP-125.jpg",150,1,25));


        APIInterface apiInterface= APIClient.getClient().create(APIInterface.class);
        final Call<List<Medicine>> medicineList = apiInterface.getMedicine();
        medicineList.enqueue(new Callback<List<Medicine>>() {
            @Override
            public void onResponse(Call<List<Medicine>> call, Response<List<Medicine>> response) {
                Log.d("name" , response.body().get(0).getName());
                listItems = response.body();
                load();


            }

            @Override
            public void onFailure(Call<List<Medicine>> call, Throwable t) {
//                call.cancel();
            }
        });

        return root;
   }

    private void load() {
        List<Medicine> medicine = new ArrayList<>();
        for (int i = 0; i < medicine.size(); i++) {
            Medicine md = new Medicine();
            md.setName(medicine.get(i).getName());
            md.setPrice(Double.parseDouble(String.valueOf(medicine.get(i).getPrice())));
            md.setQty(Double.parseDouble(String.valueOf(medicine.get(i).getQty())));
            md.setDate(medicine.get(0).getDate());

            medicine.add(md);

        }
        homeAdapter = new CustomHomeAdapter(listItems,getActivity());
        listView.setAdapter(homeAdapter);

    }


}