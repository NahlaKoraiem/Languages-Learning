package ideanity.oceans.languagelearning.spanish;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import ideanity.oceans.languagelearning.AnimalsActivity;
import ideanity.oceans.languagelearning.DBHelper;
import ideanity.oceans.languagelearning.Level1;
import ideanity.oceans.languagelearning.Level2;
import ideanity.oceans.languagelearning.Level3;
import ideanity.oceans.languagelearning.HomeActivity;
import ideanity.oceans.languagelearning.MainActivity2;
import ideanity.oceans.languagelearning.R;
import ideanity.oceans.languagelearning.english.EnglishActivity;

public class SpanishActivity extends HomeActivity {

    RelativeLayout slevel1, slevel2, slevel3;
    Button btn;
    ImageView backMenu;
    private DBHelper db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_course);
        db = new DBHelper(this);

        String email = getIntent().getStringExtra("email");
        String name = db.getName(email);
        boolean f = getIntent().getBooleanExtra("f", false);
        btn = findViewById(R.id.button4);

        backMenu = findViewById(R.id.menu_nav);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpanishActivity.super.onBackPressed();
            }
        });
        if(f==true) btn.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.enroll(1, email);
                db.close();
                Intent i = new Intent(SpanishActivity.this, MainActivity2.class);
                i.putExtra("userauth", name);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        slevel1 = findViewById(R.id.level1);
        slevel2 = findViewById(R.id.level2);
        slevel3 = findViewById(R.id.level3);

        slevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SpanishActivity.this, Level1.class);
                int flag = 2;
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });
        slevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SpanishActivity.this, Level2.class);
                int flag = 2;
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });
        slevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SpanishActivity.this, Level3.class);
                int flag = 2;
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });



    }

}