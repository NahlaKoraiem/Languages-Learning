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

import ideanity.oceans.languagelearning.adapter.PronounsAdapter;
import ideanity.oceans.languagelearning.helpers.PronounsHelper;

public class PronounsActivity extends AppCompatActivity implements RecyclerViewAction {

    RecyclerView recyclerViewPronouns;
    RecyclerView.Adapter adapter;
    int flag;
    ImageView backMenu;
    TextView colorName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pronouns);
        flag = getIntent().getIntExtra("lang", 0);
        recyclerViewPronouns = findViewById(R.id.recycler_alphabet);
        backMenu = findViewById(R.id.menu_nav);
        colorName = findViewById(R.id.pronouns_me);

        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PronounsActivity.super.onBackPressed();
            }
        });

        featuredAlphabet();

    }

    private void featuredAlphabet() {
        ArrayList<PronounsHelper> questionLocations = new ArrayList<>();
        questionLocations.add(new PronounsHelper("I"));
        questionLocations.add(new PronounsHelper("He"));
        questionLocations.add(new PronounsHelper("She"));
        questionLocations.add(new PronounsHelper("We"));
        questionLocations.add(new PronounsHelper("They"));
        questionLocations.add(new PronounsHelper("It"));
        questionLocations.add(new PronounsHelper("Them"));


        adapter = new PronounsAdapter(questionLocations, this, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewPronouns.setLayoutManager(gridLayoutManager);
        recyclerViewPronouns.setAdapter(adapter);
    }

    @Override
    public void onViewClicked(int clickedViewId, int clickedItemPosition) {
        try {
            switch (clickedItemPosition) {
                case 0:
                    if (flag==1)colorName.setText("I");
                    else if (flag==2)colorName.setText("Yo");
                    else if (flag==3)colorName.setText("Je");
                    else if (flag==4)colorName.setText("Ich");
                    break;
                case 1:
                    if (flag==1)colorName.setText("He");
                    else if (flag==2)colorName.setText("Él");
                    else if (flag==3)colorName.setText("Il");
                    else if (flag==4)colorName.setText("Er");
                    break;
                case 2:
                    if (flag==1)colorName.setText("She");
                    else if (flag==2)colorName.setText("Ella");
                    else if (flag==3)colorName.setText("Elle");
                    else if (flag==4)colorName.setText("sie");
                    break;
                case 3:
                    if (flag==1)colorName.setText("We");
                    else if (flag==2)colorName.setText("Nosotros");
                    else if (flag==3)colorName.setText("Nous");
                    else if (flag==4)colorName.setText("Wir");
                    break;
                case 4:
                    if (flag==1)colorName.setText("They");
                    else if (flag==2)colorName.setText("Ellos");
                    else if (flag==3)colorName.setText("Ils");
                    else if (flag==4)colorName.setText("Sie");
                    break;
                case 5:
                    if (flag==1)colorName.setText("It");
                    else if (flag==2)colorName.setText("Eso");
                    else if (flag==3)colorName.setText("Il");
                    else if (flag==4)colorName.setText("Es");
                    break;
                case 6:
                    if (flag==1)colorName.setText("Them");
                    else if (flag==2)colorName.setText("Ellas");
                    else if (flag==3)colorName.setText("Les");
                    else if (flag==4)colorName.setText("Sie");
                    break;
                default:
                    Toast.makeText(this, "Wrong index", Toast.LENGTH_SHORT).show();
                    colorName.setText("You");
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewLongClicked(int clickedViewId, int clickedItemPosition) {

    }

}