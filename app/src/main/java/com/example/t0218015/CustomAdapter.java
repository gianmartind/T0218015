package com.example.t0218015;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private List<Food> foodList;
    private Activity activity;
    //public MainPresenter mp;

    public MainViewModel mvm;

    public CustomAdapter(Activity activity, MainViewModel mvm){
        this.activity = activity;
        this.mvm = mvm;
        this.foodList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return foodList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(this.activity).inflate(R.layout.item_list_food, parent, false);
        final Food currentFood = (Food)this.getItem(i);

        ViewHolder viewHolder = new ViewHolder(convertView, i, this.mvm);
        viewHolder.updateView(currentFood);

        /*
        TextView tvTitle = convertView.findViewById(R.id.tv_food_title);
        tvTitle.setText(currentFood.getTitle());

        TextView tvDetails = convertView.findViewById(R.id.tv_food_details);
        tvDetails.setText(currentFood.getDetails());

        ImageView tvFavourite = convertView.findViewById(R.id.tv_food_favourite);
        tvFavourite.setImageResource((currentFood.getFavourite() == true) ? android.R.drawable.btn_star_big_on : android.R.drawable.btn_star_big_off);
        */

        return convertView;
    }

    public void updateList(List<Food> newList){
        this.foodList = newList;
    }

    public void delete(int i){
        this.foodList.clear();
    }

    public void add(Food newFood) {
        this.foodList.add(newFood);
    }

    private class ViewHolder{
        protected TextView title;
        protected TextView details;
        protected ImageView favourite;
        protected ImageButton delete;
        protected int i;
        public MainViewModel mvm;

        public ViewHolder(View view, int i, MainViewModel mvm){
            this.title = view.findViewById(R.id.tv_food_title);
            this.details = view.findViewById(R.id.tv_food_details);
            this.favourite = view.findViewById(R.id.tv_food_favourite);
            this.delete = view.findViewById(R.id.tv_food_delete);
            this.i = i;
            this.mvm = mvm;
        }

        public void updateView(final Food food){
            this.title.setText(food.getTitle());
            this.details.setText(food.getDetails());
            this.favourite.setImageResource((food.getFavourite() == true) ? android.R.drawable.btn_star_big_on : android.R.drawable.btn_star_big_off);

            this.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mvm.deleteItem(i);
                }
            });
        }
    }
}
