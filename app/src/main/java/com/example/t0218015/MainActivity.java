package com.example.t0218015;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.t0218015.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainPresenter.IMainActivity, AdapterView.OnItemClickListener {
    CustomAdapter adapter;
    ActivityMainBinding bind;
    //MainPresenter mp;
    MainViewModel mvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.bind = ActivityMainBinding.inflate(getLayoutInflater());
        View view = this.bind.getRoot();
        setContentView(view);

        this.mvm = new ViewModelProvider(this).get(MainViewModel.class);
        this.mvm.getList().observe(this, new Observer<List<Food>>() {
            @Override
            public void onChanged(List<Food> foods) {
                adapter.updateList(foods);
                adapter.notifyDataSetChanged();
            }
        });
        //this.mp = new MainPresenter(this);

        this.adapter = new CustomAdapter(this, mvm);
        this.bind.lstFoods.setAdapter(this.adapter);
        this.bind.lstFoods.setOnItemClickListener(this);


        mvm.loadData();
        //mp.loadData();

        //View itemListFood = getLayoutInflater().inflate(R.layout.item_list_food, null);
        //this.delete = (ImageView) itemListFood.findViewById(R.id.tv_food_delete);
        //this.favorite = (ImageView) itemListFood.findViewById(R.id.tv_food_favourite);
        //this.delete.setOnClickListener(this);
        this.bind.buttonAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == this.bind.buttonAdd){
            String title = this.bind.title.getText().toString();
            String details = this.bind.details.getText().toString();

            mvm.addNew(title, details);
            //mp.addNew(title, details);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mvm.setFavourite(i);
    }

    @Override
    public void UpdateList(List<Food> data) {
        adapter.updateList(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void resetAddForm(){
        this.bind.title.setText("");
        this.bind.details.setText("");
    }
}