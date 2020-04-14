package com.example.y35wen.fotagy35wen;

import java.util.ArrayList;


public class ImageCollectionModel {

    //fields
    private int rate;
    private int GridorList;
    public boolean isAdded;
    private ImageModel newModel;
    private ArrayList<ImageModel> imageCollection;

    private ArrayList<IView> views;
    public boolean firstloaded=true;

///// new added
    private ImageModel image1 = new ImageModel( Integer.toString(R.drawable.download));
    private ImageModel image2 = new ImageModel( Integer.toString(R.drawable.download2));
    private ImageModel image3 = new ImageModel( Integer.toString(R.drawable.download3));
    private ImageModel image4 = new ImageModel( Integer.toString(R.drawable.download4));
    private ImageModel image5 = new ImageModel( Integer.toString(R.drawable.download5));
    private ImageModel image6 = new ImageModel( Integer.toString(R.drawable.download6));
    private ImageModel image7 = new ImageModel( Integer.toString(R.drawable.download7));
    private ImageModel image8 = new ImageModel( Integer.toString(R.drawable.download8));
    private ImageModel image9 = new ImageModel( Integer.toString(R.drawable.download9));
    private ImageModel image10 = new ImageModel( Integer.toString(R.drawable.download10));
    private ArrayList<ImageModel> filteredimages = new ArrayList<ImageModel>();


    //constructor
    public ImageCollectionModel() {
        this.rate = 0;
        this.GridorList = 0;
        this.isAdded=false;
        this.imageCollection = new ArrayList<ImageModel>();
        this.views = new ArrayList<IView>();

    }

    // common get methods

    public int getRate(){
        return rate;
    }

    public int getGrid() {
        return this.GridorList;
    }


    public boolean getisAdded() {
        return isAdded;
    }

    public ImageModel getNewmodel(){
        return this.newModel;
    }

    public ArrayList<ImageModel> getImageCollection(){
        return this.imageCollection;
    }

//////  ADDED
    public ArrayList<ImageModel> getFilteredimages(){
        return this.filteredimages;
    }


    public void filterImageModel(){
        filteredimages.clear();
        for(int i=0;i<imageCollection.size();i++){
            if(imageCollection.get(i).getRate() >= this.rate){
                filteredimages.add(imageCollection.get(i));
            }
        }
    }


    //common set methods
    public void setisAdded(boolean x){
        isAdded=x;
        this.notifyObservers();
    }

    public void setRate(int n) {
        this.rate = n;
        filterImageModel();
        this.notifyObservers();
    }

    public void setGridorList(int n) {
        GridorList = n;
        for(int i=0;i<imageCollection.size();i++){
            imageCollection.get(i).setGridorList(n);
        }
        this.notifyObservers();

    }

    public void setImageCollection(ImageModel newModel) {
        this.newModel=newModel;
        for(int i=0; i<imageCollection.size();i++){
            if(newModel.getPath().equals(imageCollection.get(i).getPath())){
                isAdded=false;
                return;
            }
        }
        isAdded=true;
        imageCollection.add(newModel);
        this.notifyObservers();

    }



////////// new added
    public void addimageCollection() {

        image1.setRate(0);
        image2.setRate(0);
        image3.setRate(0);
        image4.setRate(0);
        image5.setRate(0);
        image6.setRate(0);
        image7.setRate(0);
        image8.setRate(0);
        image9.setRate(0);
        image10.setRate(0);
        imageCollection.add(image1);
        imageCollection.add(image2);
        imageCollection.add(image3);
        imageCollection.add(image4);
        imageCollection.add(image5);
        imageCollection.add(image6);
        imageCollection.add(image7);
        imageCollection.add(image8);
        imageCollection.add(image9);
        imageCollection.add(image10);
        filteredimages.add(image1);
        filteredimages.add(image2);
        filteredimages.add(image3);
        filteredimages.add(image4);
        filteredimages.add(image5);
        filteredimages.add(image6);
        filteredimages.add(image7);
        filteredimages.add(image8);
        filteredimages.add(image9);
        filteredimages.add(image10);

        isAdded=true;

        this.notifyObservers();
    }


    public void clearall(){
        imageCollection.clear();
        isAdded=false;
        notifyObservers();
    }

    /////////////////////////////////////////////////
    public void addView(IView v) {
        views.add(v);
        v.updateView();
    }

    public void notifyObservers(){
        for(IView view: this.views) {
            view.updateView();
        }
    }
}

