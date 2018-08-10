package com.example.rakesh.animalshadow;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1, imageView2, imageView3, imageView4, imageViewMain;
    TextView textViewStaus,textViewStaus2;
    ImageView mickyhappy,mickyupset;
    Button button;

//    list of coloured images
    Integer[]images = {
            R.drawable.bunny1,
            R.drawable.cow1,
            R.drawable.dog1,
            R.drawable.fish1,
            R.drawable.horse1,
            R.drawable.monkey1,
};

//    list of shadow images
    Integer[]shadows = {
            R.drawable.bunny2,
            R.drawable.cow2,
            R.drawable.dog2,
            R.drawable.fish2,
            R.drawable.horse2,
            R.drawable.monkey2,
    };

//  list of numbers for all the images
    Integer[]imageNumbers = {0,1,2,3,4,5};

    int turn = 0;
    int correctAns = 0;
    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.image1);
        imageView2 = findViewById(R.id.image2);
        imageView3 = findViewById(R.id.image3);
        imageView4 = findViewById(R.id.image4);
        imageViewMain = findViewById(R.id.imageMain);

        textViewStaus = findViewById(R.id.textViewStatus);
        textViewStaus2 = findViewById(R.id.textViewStatus2);

        mickyhappy = findViewById(R.id.mickyhappy);
        mickyupset = findViewById(R.id.mickyupset);

        mickyhappy.animate().alpha(0).setDuration(0);
        mickyupset.animate().alpha(0).setDuration(0);


        button = findViewById(R.id.button);

//        random shuffle the images
        Collections.shuffle(Arrays.asList(imageNumbers));
//        set images on the screen
        setImages();

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                check if correct or wrong
                if (correctAns==1){
                    score++;
                    textViewStaus.setText("CORRECT");
                    mickyhappy.animate().alpha(1).setDuration(0);

                    button.setVisibility(View.VISIBLE);
                }else {
                    textViewStaus2.setText("WRONG");
                    mickyupset.animate().alpha(1).setDuration(0);
                    button.setVisibility(View.VISIBLE);

                }
//                disable images
                imageView1.setEnabled(false);
                imageView2.setEnabled(false);
                imageView3.setEnabled(false);
                imageView4.setEnabled(false);

            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAns==2){
                    score++;
                    textViewStaus.setText("CORRECT");
                    mickyhappy.animate().alpha(1).setDuration(0);

                    button.setVisibility(View.VISIBLE);
                }else {
                    textViewStaus2.setText("WRONG");
                    mickyupset.animate().alpha(1).setDuration(0);

                    button.setVisibility(View.VISIBLE);

                }
//                disable images
                imageView1.setEnabled(false);
                imageView2.setEnabled(false);
                imageView3.setEnabled(false);
                imageView4.setEnabled(false);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAns==3){
                    score++;
                    textViewStaus.setText("CORRECT");
                    mickyhappy.animate().alpha(1).setDuration(0);

                    button.setVisibility(View.VISIBLE);
                }else {
                    textViewStaus2.setText("WRONG");
                    mickyupset.animate().alpha(1).setDuration(0);

                    button.setVisibility(View.VISIBLE);

                }
//                disable images
                imageView1.setEnabled(false);
                imageView2.setEnabled(false);
                imageView3.setEnabled(false);
                imageView4.setEnabled(false);
            }
        });


        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAns==4){
                    ++score;
                    textViewStaus.setText("CORRECT");
                    mickyhappy.animate().alpha(1).setDuration(0);

                    button.setVisibility(View.VISIBLE);
                }else {
                    textViewStaus2.setText("WRONG");
                    mickyupset.animate().alpha(1).setDuration(0);

                    button.setVisibility(View.VISIBLE);

                }
//                disable images
                imageView1.setEnabled(false);
                imageView2.setEnabled(false);
                imageView3.setEnabled(false);
                imageView4.setEnabled(false);

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                increase the turn and finish the game if 10 turns are passed
                turn++;
                if (turn == 6){
                    checkEnd();
                }
                else {
                    setImages();
                }

            }
        });
    }

    private void setImages(){
//determine which is the correct ans
        Random random = new Random();
        correctAns = random.nextInt(4)+1;

//        generate random wrong ans
        int wrongAns1, wrongAns2,wrongAns3;

        do {
            wrongAns1 = random.nextInt(4);
        }while (wrongAns1 == imageNumbers [turn] );

        do {
            wrongAns2 = random.nextInt(4);
        }while (wrongAns2 == imageNumbers [turn]||wrongAns2==wrongAns1 );

        do {
            wrongAns3 = random.nextInt(4);
        }while (wrongAns3 == imageNumbers [turn]||wrongAns3==wrongAns2||wrongAns3==wrongAns1 );

//      set images for all ans
        switch (correctAns){
            case 1:
                imageView1.setImageResource(images[imageNumbers[turn]]);
                imageView2.setImageResource(images[wrongAns1]);
                imageView3.setImageResource(images[wrongAns2]);
                imageView4.setImageResource(images[wrongAns3]);
                break;

            case 2:
                imageView1.setImageResource(images[wrongAns1]);
                imageView2.setImageResource(images[imageNumbers[turn]]);
                imageView3.setImageResource(images[wrongAns2]);
                imageView4.setImageResource(images[wrongAns3]);
                break;

            case 3:
                imageView1.setImageResource(images[wrongAns1]);
                imageView2.setImageResource(images[wrongAns2]);
                imageView3.setImageResource(images[imageNumbers[turn]]);
                imageView4.setImageResource(images[wrongAns3]);
                break;

            case 4:
                imageView1.setImageResource(images[wrongAns1]);
                imageView2.setImageResource(images[wrongAns2]);
                imageView3.setImageResource(images[wrongAns3]);
                imageView4.setImageResource(images[imageNumbers[turn]]);
                break;

        }

//        set Images for the question
        imageViewMain.setImageResource(shadows[imageNumbers[turn]]);

//        null stuff
        textViewStaus.setText("");
        textViewStaus2.setText("");
        mickyhappy.animate().alpha(0).setDuration(0);
        mickyupset.animate().alpha(0).setDuration(0);

        button.setVisibility(View.VISIBLE);

        imageView1.setEnabled(true);
        imageView2.setEnabled(true);
        imageView3.setEnabled(true);
        imageView4.setEnabled(true);

    }

    private void checkEnd(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setCancelable(false);
        if (score==6){
            alert.setMessage("Game Over \nwow full score 6/6");
        }
        else if (score==0){
            alert.setMessage("Game Over \nyou are dumbass");
        }else {
            alert.setMessage("Game Over \nScore : "+score);
        }

        alert.setPositiveButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.setNegativeButton("Play Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                   recreate();
            }
        });

        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }

}
