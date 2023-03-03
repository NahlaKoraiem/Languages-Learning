package ideanity.oceans.languagelearning.german;

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
import ideanity.oceans.languagelearning.english.EnglishActivity;

public class GermanActivity extends HomeActivity {

    RelativeLayout glevel1, glevel2, glevel3;
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
                GermanActivity.super.onBackPressed();
            }
        });
        if(f==true) btn.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.enroll(3, email);
                db.close();
                Intent i = new Intent(GermanActivity.this, MainActivity2.class);
                i.putExtra("userauth", name);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        glevel1 = findViewById(R.id.level1);
        glevel2 = findViewById(R.id.level2);
        glevel3 = findViewById(R.id.level3);

        glevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GermanActivity.this, Level1.class);
                int flag = 4;
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });
        glevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GermanActivity.this, Level2.class);
                int flag = 4;
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });
        glevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GermanActivity.this, Level3.class);
                int flag = 4;
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });



    }

}