package com.test.pharmecyproject.ui.home;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.test.pharmecyproject.R;
import com.test.pharmecyproject.model.HomeListItem;
import com.test.pharmecyproject.model.Medicine;

import java.util.List;

public class CustomHomeAdapter implements ListAdapter {

    List<Medicine> item;
    Context context;

    public List<Medicine> getItem() {
        return item;
    }

    public CustomHomeAdapter(List<Medicine> item,Context context) {
        this.item = item;
        this.context =context;
    }


    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Medicine listItem = item.get(position);
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.home_list_row,null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            TextView productTitle = convertView.findViewById(R.id.product_name);
           ImageView productImage = convertView.findViewById(R.id.product_image);
            TextView price = convertView.findViewById(R.id.product_price);
            TextView quanity = convertView.findViewById(R.id.cart_product_quantity_tv);
            TextView datetitle = convertView.findViewById(R.id.expireDate);
//            TextView weight = convertView.findViewById(R.id.product_weight_text);
            productTitle.setText(listItem.getName().toString());
            price.setText(Double.toString(listItem.getPrice()));
//            weight.setText(Float.toString(listItem.getWeight()));
            datetitle.setText(listItem.getDate());
            quanity.setText(Double.toString(listItem.getQty()));
            Picasso.with(context).load(listItem.getImg()).into(productImage);


        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
