package com.example.y35wen.fotagy35wen;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;



public class ImageaView extends LinearLayout implements IView {

    //fields
    private ImageModel imageModel;
    private RatingBar rateStar;
    private  int rate=0;
    private boolean isFull;

    //constructor
    public ImageaView(final Context context, ImageModel imageModel1) {

        super(context);
        View.inflate(context, R.layout.oneimg, this);
        this.imageModel = imageModel1;

        // to show picture
        ImageView img = (ImageView) findViewById(R.id.picture);
        int name = Integer.parseInt(imageModel.getPath());
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(),name);
        img.setImageBitmap(bitmap);


        // rate
        rateStar = (RatingBar) findViewById(R.id.rating);
        rateStar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                rate = (int)v;
                imageModel.setRate(rate);
            }
        });

        // reset button
        ImageButton reset = (ImageButton) findViewById(R.id.reset);
        reset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                imageModel.setRate(0);
                rateStar.setRating(0);
            }
        });

        imageModel.addView(this);
    }


    public int getRate(){return this.rate;}



    public void updateView() {
    }

}


