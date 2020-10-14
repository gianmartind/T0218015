package com.example.t0218015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainPresenter {
    protected List<Food> foods;
    protected IMainActivity ui;

    public MainPresenter(IMainActivity view){
        this.foods = new ArrayList<>();
        this.ui = view;
    }

    public void loadData(){
        this.foods.addAll(Arrays.asList(MockFood.foodObjectArr));
        this.ui.UpdateList(this.foods);
    }

    public void addNew(String title, String details){
        Food item = new Food(title, details);
        this.foods.add(item);
        this.ui.UpdateList(this.foods);
        this.ui.resetAddForm();
    }

    public void deleteItem(int i){
        this.foods.remove(i);
        this.ui.UpdateList(this.foods);
    }

    public void setFavourite(int i){
        this.foods.get(i).setFavourite((this.foods.get(i).getFavourite() == true) ? false : true);
        this.ui.UpdateList(this.foods);
    }

    public interface IMainActivity{
        void UpdateList(List<Food> data);
        void resetAddForm();
    }
}
