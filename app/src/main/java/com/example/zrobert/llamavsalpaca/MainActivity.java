package com.example.zrobert.llamavsalpaca;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

import static java.lang.Thread.*;

public class MainActivity extends AppCompatActivity {

    //even is llama, odd is alpaca multiples of 5 is neither
    int currentAnimal = -1;
    int numPics = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentAnimal = 1;
    }
 
    protected void bigRedX(){
        ImageView iv  = (ImageView) findViewById(R.id.imageViewX);
        iv.setVisibility(View.VISIBLE);
    }

    protected void noBigRedX(){
        ImageView iv  = (ImageView) findViewById(R.id.imageViewX);
        iv.setVisibility(View.INVISIBLE);
    }

    protected void newPic() {
        //set ImageView to random Image
        Random rand = new Random();
        int randomNum = rand.nextInt(numPics);
        while(randomNum == currentAnimal){
            randomNum = rand.nextInt(numPics);
        }
        ImageView iv  = (ImageView) findViewById(R.id.imageView);
        String drawableName = "pic"+ randomNum;
        int resID = getResources().getIdentifier(drawableName, "drawable",  getPackageName());
        iv.setImageResource(resID);

        //change currentAnimal Var
        currentAnimal = randomNum;
    }

    //Onclick methods for all 3 buttons
    public void llamaClick(View view) {
        if (currentAnimal < 0)
            newPic();
        if (currentAnimal %2 == 0 && currentAnimal %5 != 0){
            noBigRedX();
            newPic();
        }
        else {
            bigRedX();
        }
    }

    public void alpacaClick(View view) {
        if (currentAnimal < 0)
            newPic();
        if (currentAnimal %2 == 1 && currentAnimal %5 != 0){
            noBigRedX();
            newPic();
        }
        else {
            bigRedX();
        }
    }

    public void neitherClick(View view) {
        if (currentAnimal < 0)
            newPic();
        if (currentAnimal % 5 == 0){
            noBigRedX();
            newPic();
        }
        else {
            bigRedX();
        }
    }
}
