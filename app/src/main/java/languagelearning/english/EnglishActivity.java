package  ideanity.oceans.languagelearning.english;

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
import ideanity.oceans.languagelearning.Level1;
import ideanity.oceans.languagelearning.Level2;
import ideanity.oceans.languagelearning.Level3;
import ideanity.oceans.languagelearning.MainActivity2;
import ideanity.oceans.languagelearning.R;

public class EnglishActivity extends HomeActivity {

    RelativeLayout elevel1, elevel2, elevel3;
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
                EnglishActivity.super.onBackPressed();
            }
        });
        if(f==true) btn.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.enroll(0, email);
                db.close();
                Intent i = new Intent(EnglishActivity.this, MainActivity2.class);
                i.putExtra("userauth", name);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        elevel1 = findViewById(R.id.level1);
        elevel2 = findViewById(R.id.level2);
        elevel3 = findViewById(R.id.level3);

        elevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EnglishActivity.this, Level1.class);
                int flag = 1;
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });
        elevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EnglishActivity.this, Level2.class);
                int flag = 1;
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });
        elevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EnglishActivity.this, Level3.class);
                int flag = 1;
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });



    }

}