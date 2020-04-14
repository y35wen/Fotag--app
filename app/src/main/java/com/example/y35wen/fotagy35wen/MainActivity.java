package com.example.y35wen.fotagy35wen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.ViewGroup;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IView {

    // fields
    private ImageCollectionModel imageCollectionModel;
    private ArrayList<ImageaView> imageaViews = new ArrayList<ImageaView>();
    private ViewGroup viewGroup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();

    }

    public void initial(){

        // init ImageCollectionModel
        imageCollectionModel = new ImageCollectionModel();
        viewGroup = (ViewGroup) findViewById(R.id.main);
        // setup views
        Toolbar toolbar = new Toolbar(this,imageCollectionModel);
        ViewGroup toolGroup = (ViewGroup) findViewById(R.id.toolbar);
        toolGroup.addView(toolbar);

        imageCollectionModel.addView(this);
    }

    public void list() {

        if(imageCollectionModel.getImageCollection().size()==0){
            viewGroup.removeAllViews();
            imageaViews.clear();
            imageCollectionModel.getFilteredimages().clear();
        }
        else if (imageCollectionModel.getFilteredimages().size()==10) {
            for (int i = 0; i < imageCollectionModel.getImageCollection().size(); i++) {
                ImageaView img = new ImageaView(this, imageCollectionModel.getImageCollection().get(i));
                imageaViews.add(img);
                viewGroup.addView(img);
            }
        } else{
            viewGroup.removeAllViews();
            for (int i = 0; i < imageaViews.size(); i++) {
                if (imageaViews.get(i).getRate() >= imageCollectionModel.getRate()) {
                    viewGroup.addView(imageaViews.get(i));
                }
            }
        }

    }

    public void updateView() {
        list();
    }

}