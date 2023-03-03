package ideanity.oceans.languagelearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import ideanity.oceans.languagelearning.english.AlphabetActivity;
import ideanity.oceans.languagelearning.spanish.SAlphabetActivity;
import ideanity.oceans.languagelearning.german.GAlphabetActivity;
import ideanity.oceans.languagelearning.french.FAlphabetActivity;


public class Level1 extends HomeActivity {

    RelativeLayout color, number, alphabet, week,  family;
    int flag;
    ImageView backMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_level1);

        flag = getIntent().getIntExtra("lang", 0);

        color = findViewById(R.id.color);
        number = findViewById(R.id.number);
        alphabet = findViewById(R.id.alphabet);
        week = findViewById(R.id.week);
        family = findViewById(R.id.family);
        backMenu = findViewById(R.id.menu_nav);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level1.super.onBackPressed();
            }
        });
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Level1.this, ColorsActivity.class);
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });

        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Level1.this, NumbersActivity.class);
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });

        alphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1)startActivity(new Intent(Level1.this, AlphabetActivity.class));
                else if(flag==2)startActivity(new Intent(Level1.this, SAlphabetActivity.class));
                else if(flag==3)startActivity(new Intent(Level1.this, FAlphabetActivity.class));
                else if(flag==4)startActivity(new Intent(Level1.this, GAlphabetActivity.class));

            }
        });

        week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Level1.this, WeekActivity.class);
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });


        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Level1.this, FamilyActivity.class);
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });

    }

}