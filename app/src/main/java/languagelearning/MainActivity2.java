package ideanity.oceans.languagelearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import ideanity.oceans.languagelearning.english.EnglishActivity;
import ideanity.oceans.languagelearning.french.FrenchActivity;
import ideanity.oceans.languagelearning.german.GermanActivity;
import ideanity.oceans.languagelearning.spanish.SpanishActivity;

public class MainActivity2 extends Login {

    RelativeLayout english, spanish, french, german;
    Button btn;
    private DBHelper db;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String name = getIntent().getStringExtra("userauth");
        TextView tv = findViewById(R.id.textView3);
        tv.setText(name);

        String email = getIntent().getStringExtra("email");
        db = new DBHelper(this);
        String courses = db.getCourses(email);
        db.close();

        btn = findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, HomeActivity.class);
                i.putExtra("email", email);
                startActivity(i);
            }
        });

        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.dashboard);
        LayoutInflater inflater = getLayoutInflater();

        for(int i=0; i<courses.length(); i++){
            if(courses.charAt(i)=='1'){
                View myLayout = inflater.inflate(R.layout.lang_btn, mainLayout, false);

                TextView textView = (TextView) myLayout.findViewById(R.id.textView);
                ImageView imageView = (ImageView) myLayout.findViewById(R.id.imageView2);
                if(i==0){
                    textView.setText("English");
                    english = (RelativeLayout) myLayout;
                }
                else if(i==1){
                    textView.setText("Spanish");
                    imageView.setBackground(ContextCompat.getDrawable(this, R.drawable.number_item));
                    spanish = (RelativeLayout) myLayout;
                }
                else if(i==2){
                    textView.setText("French");
                    imageView.setBackground(ContextCompat.getDrawable(this, R.drawable.color_item));
                    french = (RelativeLayout) myLayout;
                }
                else if(i==3){
                    textView.setText("German");
                    imageView.setBackground(ContextCompat.getDrawable(this, R.drawable.alphabet_item));
                    german = (RelativeLayout) myLayout;
                }


                mainLayout.addView(myLayout);
            }
        }

        if(english!=null){
            english.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean f = db.ifEnglish(email);
                    System.out.println(f);
                    Intent i = new Intent(MainActivity2.this, EnglishActivity.class);
                    i.putExtra("f", f);
                    i.putExtra("email", email);
                    startActivity(i);
                }
            });
        }
        if(spanish!=null){
            spanish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean f = db.ifSpanish(email);
                    Intent i = new Intent(MainActivity2.this, SpanishActivity.class);
                    i.putExtra("f", f);
                    i.putExtra("email", email);
                    startActivity(i);
                }
            });
        }

        if(french!=null){
            french.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean f = db.ifFrench(email);
                    Intent i = new Intent(MainActivity2.this, FrenchActivity.class);
                    i.putExtra("f", f);
                    i.putExtra("email", email);
                    startActivity(i);
                }
            });
        }

        if(german!=null) {
            german.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean f = db.ifGerman(email);
                    Intent i = new Intent(MainActivity2.this, GermanActivity.class);
                    i.putExtra("f", f);
                    i.putExtra("email", email);
                    startActivity(i);
                }
            });
        }
    }
}