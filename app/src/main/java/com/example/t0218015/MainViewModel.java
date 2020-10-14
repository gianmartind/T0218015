package com.example.t0218015;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainViewModel extends ViewModel {
    private List<Food> foodList;
    private MutableLiveData<List<Food>> foods;

    public MainViewModel(){
        this.foodList = new ArrayList<>();
        this.foods = new MutableLiveData<>();
    }

    public LiveData<List<Food>> getList(){
        return foods;
    }

    public void loadData(){
        this.foodList.addAll(Arrays.asList(MockFood.foodObjectArr));
        this.foods.setValue(this.foodList);
    }

    public void addNew(String title, String details){
        Food item = new Food(title, details);
        this.foodList.add(item);
        this.foods.setValue(this.foodList);
    }

    public void deleteItem(int i){
        this.foodList.remove(i);
        this.foods.setValue(this.foodList);
    }

    public void setFavourite(int i){
        this.foodList.get(i).setFavourite((this.foodList.get(i).getFavourite() == true) ? false : true);
        this.foods.setValue(this.foodList);
    }
}
