package ideanity.oceans.languagelearning.french;

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
import ideanity.oceans.languagelearning.HomeActivity;
import ideanity.oceans.languagelearning.MainActivity2;
import ideanity.oceans.languagelearning.R;
import ideanity.oceans.languagelearning.Level1;
import ideanity.oceans.languagelearning.Level2;
import ideanity.oceans.languagelearning.Level3;
import ideanity.oceans.languagelearning.english.EnglishActivity;


public class FrenchActivity extends HomeActivity {

    RelativeLayout flevel1, flevel2, flevel3;
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
                FrenchActivity.super.onBackPressed();
            }
        });
        if(f==true) btn.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.enroll(2, email);
                db.close();
                Intent i = new Intent(FrenchActivity.this, MainActivity2.class);
                i.putExtra("userauth", name);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        flevel1 = findViewById(R.id.level1);
        flevel2 = findViewById(R.id.level2);
        flevel3 = findViewById(R.id.level3);

        flevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FrenchActivity.this, Level1.class);
                int flag = 3;
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });
        flevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FrenchActivity.this, Level2.class);
                int flag = 3;
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });
        flevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FrenchActivity.this, Level3.class);
                int flag = 3;
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });



    }

}