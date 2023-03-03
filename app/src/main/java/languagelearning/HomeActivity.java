package ideanity.oceans.languagelearning;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ideanity.oceans.languagelearning.english.EnglishActivity;
import ideanity.oceans.languagelearning.french.FrenchActivity;
import ideanity.oceans.languagelearning.german.GermanActivity;
import ideanity.oceans.languagelearning.spanish.SpanishActivity;

public class HomeActivity extends Login {

    RelativeLayout english, spanish, french, german;
    ImageView backMenu;
    private DBHelper db;
        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_home);
            db = new DBHelper(this);
            String email = getIntent().getStringExtra("email");

            english = findViewById(R.id.english);
            spanish = findViewById(R.id.spanish);
            french = findViewById(R.id.french);
            german = findViewById(R.id.german);
            backMenu = findViewById(R.id.menu_nav);
            backMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HomeActivity.super.onBackPressed();
                }
            });
            english.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean f = db.ifEnglish(email);
                    Intent i = new Intent(HomeActivity.this, EnglishActivity.class);
                    i.putExtra("f", f);
                    i.putExtra("email", email);
                    startActivity(i);
                }
            });
            spanish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean f = db.ifSpanish(email);
                    Intent i = new Intent(HomeActivity.this, SpanishActivity.class);
                    i.putExtra("f", f);
                    i.putExtra("email", email);
                    startActivity(i);
                }
            });

            french.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean f = db.ifFrench(email);
                    Intent i = new Intent(HomeActivity.this, FrenchActivity.class);
                    i.putExtra("f", f);
                    i.putExtra("email", email);
                    startActivity(i);
                }
            });
            german.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean f = db.ifGerman(email);
                    Intent i = new Intent(HomeActivity.this, GermanActivity.class);
                    i.putExtra("f", f);
                    i.putExtra("email", email);
                    startActivity(i);
                }
            });



        }
}
