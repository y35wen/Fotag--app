package com.example.y35wen.fotagy35wen;
import android.content.Context;
import android.view.View;
import android.widget.*;


public class Toolbar extends LinearLayout implements IView {

    //fields
    private ImageCollectionModel imageCollectionModel;
    private RatingBar rateFilter;
    private ImageButton clear1;
    private ImageButton loaded;
    public boolean isloaded=false;


    //constructor
    public Toolbar(Context context, final ImageCollectionModel imageCollectionModel1) {
        super(context);
        View.inflate(context, R.layout.toolbar, this);
        this.imageCollectionModel = imageCollectionModel1;

        //load button

        loaded = (ImageButton) findViewById(R.id.loaded);
        loaded.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                loadimgs();
            }
        });

        // clear button
        clear1 = (ImageButton) findViewById(R.id.clear1);
        clear1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                clearimgs();
            }
        });

        // stars
         rateFilter = (RatingBar)findViewById(R.id.rateFilter);
         rateFilter.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
             @Override
             public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                 imageCollectionModel.setRate((int)v);
             }
         });
        imageCollectionModel.addView(this);
    }

    public void clearimgs(){
        imageCollectionModel.setRate(0);
        imageCollectionModel.clearall();
        isloaded=false;
        imageCollectionModel.isAdded=false;
        rateFilter.setRating(0);
    }

    public void loadimgs(){
        if(isloaded==false){
            imageCollectionModel.addimageCollection();
            isloaded=true;
        }
    }


    public void updateView() {

    }
}
