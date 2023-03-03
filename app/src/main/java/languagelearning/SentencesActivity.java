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

import ideanity.oceans.languagelearning.adapter.SentencesAdapter;
import ideanity.oceans.languagelearning.helpers.SentencesHelper;

public class SentencesActivity extends AppCompatActivity implements RecyclerViewAction {

    RecyclerView recyclerViewSentences;
    RecyclerView.Adapter adapter;
    int flag;
    ImageView backMenu;
    TextView colorName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sentences);
        flag = getIntent().getIntExtra("lang", 0);
        recyclerViewSentences = findViewById(R.id.recycler_alphabet);
        backMenu = findViewById(R.id.menu_nav);
        colorName = findViewById(R.id.sentences);

        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SentencesActivity.super.onBackPressed();
            }
        });

        featuredAlphabet();

    }

    private void featuredAlphabet() {
        ArrayList<SentencesHelper> questionLocations = new ArrayList<>();
        questionLocations.add(new SentencesHelper("Hello i am Sara"));
        questionLocations.add(new SentencesHelper("I love cats"));
        questionLocations.add(new SentencesHelper("I am playing judo"));
        questionLocations.add(new SentencesHelper("I live in Cairo"));
        questionLocations.add(new SentencesHelper("Swimming is good"));
        questionLocations.add(new SentencesHelper("I am baking a cake"));
        questionLocations.add(new SentencesHelper("Do you want to play?"));


        adapter = new SentencesAdapter(questionLocations, this, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewSentences.setLayoutManager(gridLayoutManager);
        recyclerViewSentences.setAdapter(adapter);
    }

    @Override
    public void onViewClicked(int clickedViewId, int clickedItemPosition) {
        try {
            switch (clickedItemPosition) {
                case 0:
                    if(flag==1)colorName.setText("Hello i am Sara");
                    else if(flag==2)colorName.setText("Hola yo soy Sara");
                    else if(flag==3)colorName.setText("Bonjour je suis Sara");
                    else if(flag==4)colorName.setText("Hallo ich bin Sara");
                    break;
                case 1:
                    if(flag==1)colorName.setText("I love cats");
                    else if(flag==2)colorName.setText("Amo a los gatos");
                    else if(flag==3)colorName.setText("J'aime les chats");
                    else if(flag==4)colorName.setText("Ich liebe Katzen");
                    break;
                case 2:
                    if(flag==1)colorName.setText("I am playing judo");
                    else if(flag==2)colorName.setText("Estoy jugando judo");
                    else if(flag==3)colorName.setText("Je joue judo");
                    else if(flag==4)colorName.setText("Ich spiele judo");
                    break;
                case 3:
                    if(flag==1)colorName.setText("I live in Cairo");
                    else if(flag==2)colorName.setText("Vivo en Cairo");
                    else if(flag==3)colorName.setText("J'habite au Caire");
                    else if(flag==4)colorName.setText("Ich lebe in Kairo");
                    break;
                case 4:
                    if(flag==1)colorName.setText("Swimming is good");
                    else if(flag==2)colorName.setText("Nadar es bueno");
                    else if(flag==3)colorName.setText("La natation c'est bien");
                    else if(flag==4)colorName.setText("Schwimmen ist gut");
                    break;
                case 5:
                    if(flag==1)colorName.setText("I am baking a cake");
                    else if(flag==2)colorName.setText("Estoy horneando un pastel");
                    else if(flag==3)colorName.setText("Je fais un gâteau");
                    else if(flag==4)colorName.setText("Ich backe einen Kuchen");
                    break;
                case 6:
                    if(flag==1)colorName.setText("Do you want to play?");
                    else if(flag==2)colorName.setText("¿Quieres jugar?");
                    else if(flag==3)colorName.setText("Tu veux jouer?");
                    else if(flag==4)colorName.setText("Willst du spielen?");
                    break;
                default:
                    Toast.makeText(this, "Wrong index", Toast.LENGTH_SHORT).show();
                    colorName.setText("Make a sentence");
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewLongClicked(int clickedViewId, int clickedItemPosition) {

    }

}