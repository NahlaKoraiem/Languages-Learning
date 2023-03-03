package ideanity.oceans.languagelearning;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Level2 extends HomeActivity {

    RelativeLayout animal, greeting, conversation, fruit, vegetable;
    int flag;
    ImageView backMenu;


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_level2);

        flag = getIntent().getIntExtra("lang", 0);

        animal = findViewById(R.id.animal);
        greeting = findViewById(R.id.greeting);
        conversation = findViewById(R.id.conversation);
        fruit = findViewById(R.id.fruit);
        vegetable = findViewById(R.id.vegetable);

        backMenu = findViewById(R.id.menu_nav);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Level2.super.onBackPressed();
            }
        });
        animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(Level2.this, AnimalsActivity.class);
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });

        greeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(Level2.this, GreetingActivity.class);
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });

        conversation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(Level2.this, ConversationActivity.class);
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });

        fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(Level2.this, FruitsActivity.class);
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });

        vegetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(Level2.this, VegetablesActivity.class);
                i.putExtra("lang", flag);
                startActivity(i);
            }
        });


    }

}