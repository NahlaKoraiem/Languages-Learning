package ideanity.oceans.languagelearning;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Level3 extends HomeActivity {

    RelativeLayout sports, pronouns, verbs, sentence;
    int flag;
    ImageView backMenu;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_level3);

        flag = getIntent().getIntExtra("lang", 0);

        sports = findViewById(R.id.sport);
        pronouns = findViewById(R.id.pronouns);
        verbs = findViewById(R.id.verbs);
        sentence = findViewById(R.id.sentence);

        backMenu = findViewById(R.id.menu_nav);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level3.super.onBackPressed();
            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Level3.this, SportsActivity.class);
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });

        pronouns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Level3.this, PronounsActivity.class);
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });

        verbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Level3.this, VerbsActivity.class);
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });

        sentence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Level3.this, SentencesActivity.class);
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });



    }

}