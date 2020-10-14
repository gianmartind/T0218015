package com.example.t0218015;

public class Food {
    private String title;
    private String details;
    private boolean isFavourite;

    public Food(String title, String details){
        this.title = title;
        this.details = details;
        this.isFavourite = false;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDetails(String details){
        this.details = details;
    }

    public void setFavourite(boolean isFavourite){
        this.isFavourite = isFavourite;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDetails(){
        return this.details;
    }

    public boolean getFavourite(){
        return this.isFavourite;
    }
}
