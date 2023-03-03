package ideanity.oceans.languagelearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ideanity.oceans.languagelearning.adapter.GreetingAdapter;
import ideanity.oceans.languagelearning.helpers.GreetingHelper;

public class GreetingActivity extends AppCompatActivity implements RecyclerViewAction {

    RecyclerView recyclerViewGreeting;
    RecyclerView.Adapter adapter;
    int flag;
    ImageView backMenu;
    TextView colorName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_greeting);
        flag = getIntent().getIntExtra("lang", 0);
        recyclerViewGreeting = findViewById(R.id.recycler_alphabet);
        backMenu = findViewById(R.id.menu_nav);
        colorName = findViewById(R.id.greeting_answer);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GreetingActivity.super.onBackPressed();
            }
        });

        featuredAlphabet();

    }

    private void featuredAlphabet() {
        ArrayList<GreetingHelper> questionLocations = new ArrayList<>();
        questionLocations.add(new GreetingHelper("Hello"));
        questionLocations.add(new GreetingHelper("Good morning"));
        questionLocations.add(new GreetingHelper("Good afternoon"));
        questionLocations.add(new GreetingHelper("Good evening"));
        questionLocations.add(new GreetingHelper("It’s been a while since I’ve seen you!"));
        questionLocations.add(new GreetingHelper("What’s your name?"));
        questionLocations.add(new GreetingHelper("How are you?"));
        questionLocations.add(new GreetingHelper("How’s it going?"));
        questionLocations.add(new GreetingHelper("Where are you from?"));
        questionLocations.add(new GreetingHelper("Welcome"));


        adapter = new GreetingAdapter(questionLocations, this, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewGreeting.setLayoutManager(gridLayoutManager);
        recyclerViewGreeting.setAdapter(adapter);
    }

    @Override
    public void onViewClicked(int clickedViewId, int clickedItemPosition) {
        try {
            switch (clickedItemPosition) {
                case 0:
                    if (flag==1)colorName.setText("Hello");
                    else if (flag==2)colorName.setText("Hola");
                    else if (flag==3) colorName.setText("Bonjour");
                    else if (flag==4)colorName.setText("Hallo");
                    break;
                case 1:
                    if (flag==0)colorName.setText("Good Morning");
                    else if (flag==2)colorName.setText("Buenos días");
                    else if (flag==3)colorName.setText("Bonjour");
                    else if (flag==4)colorName.setText("Guten Morgen");
                    break;
                case 2:
                    if (flag==0)colorName.setText("Good Afternoon");
                    else if (flag==2)colorName.setText("Buena tarde");
                    else if (flag==3)colorName.setText("Bonne après-midi");
                    else if (flag==4)colorName.setText("Guten Tag");
                    break;
                case 3:
                    if (flag==0)colorName.setText("Good Evening");
                    else if (flag==2)colorName.setText("Buenas noches");
                    else if (flag==3)colorName.setText("Bonsoir");
                    else if (flag==4)colorName.setText("Guten Abend");
                    break;
                case 4:
                    if (flag==0)colorName.setText("It’s been a while since I’ve seen you!");
                    else if (flag==2)colorName.setText("Ha pasado un tiempo desde que te he visto!");
                    else if (flag==3)colorName.setText("Ça fait un moment que je ne t'ai pas vu !");
                    else if (flag==4)colorName.setText("Es ist schon eine Weile her, seit ich dich gesehen habe!");
                    break;
                case 5:
                    if (flag==0) colorName.setText("What’s your name?");
                    else if (flag==2)colorName.setText("¿Cuál es su nombre?");
                    else if (flag==3)colorName.setText("Quel est ton nom?");
                    else if (flag==4)colorName.setText("Wie heissen Sie?");
                    break;
                case 6:
                    if (flag==0)colorName.setText("How are you?");
                    else if (flag==2)colorName.setText("¿Cómo estás?");
                    else if (flag==3)colorName.setText("Comment ca va?");
                    else if (flag==4)colorName.setText("Wie geht es dir?");
                    break;
                case 7:
                    if (flag==0)colorName.setText("How’s it going?");
                    else if (flag==2)colorName.setText("¿Cómo te va?");
                    else if (flag==3)colorName.setText("Comment ça va?");
                    else if (flag==4)colorName.setText("Wie geht's?");
                    break;
                case 8:
                    if (flag==0)colorName.setText("Where are you from?");
                    else if (flag==2)colorName.setText("¿De donde eres?");
                    else if (flag==3)colorName.setText("D'où viens-tu?");
                    else if (flag==4)colorName.setText("Woher kommen Sie?");
                    break;
                case 9:
                    if (flag==0)colorName.setText("Welcome");
                    else if (flag==2)colorName.setText("Bienvenidos");
                    else if (flag==3)colorName.setText("Bienvenu");
                    else if (flag==4)colorName.setText("Herzlich willkommen");
                    break;
                default:
                    Toast.makeText(this, "Wrong index", Toast.LENGTH_SHORT).show();
                    colorName.setText("Hello");
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewLongClicked(int clickedViewId, int clickedItemPosition) {

    }

}