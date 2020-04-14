package com.example.y35wen.fotagy35wen;

import java.util.ArrayList;

public class ImageModel{

    //fields
    private String path;
    private int rate;
    private int GridorList;

    private ArrayList<IView> views;

    //constructor
    public ImageModel(String path) {
        this.path = path;
        this.rate = 0;
        this.GridorList=0;
        this.views= new ArrayList<IView>();
    }

    //common get methods
    public String getPath() {
        return this.path;
    }

    public int getRate() {
        return this.rate;
    }
    public int getGridorList(){
        return this.GridorList;
    }

    //common set method
    public void setRate(int x) {
        this.rate = x;
        this.notifyObservers();
    }

    public void setGridorList(int x){
        this.GridorList=x;
        this.notifyObservers();
    }



    //////////////////////
    public void addView(IView view) {
        views.add(view);
        view.updateView();
    }

    public void removeView(){
        views.clear();
    }


    public void notifyObservers(){
        for(IView view: this.views) {
            view.updateView();
        }
   }
}
