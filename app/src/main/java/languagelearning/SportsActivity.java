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

import ideanity.oceans.languagelearning.adapter.SportsAdapter;
import ideanity.oceans.languagelearning.helpers.SportsHelper;

public class SportsActivity extends AppCompatActivity implements RecyclerViewAction {

    RecyclerView recyclerViewSports;
    RecyclerView.Adapter adapter;
    int flag;
    ImageView backMenu;
    TextView colorName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sports);
        flag = getIntent().getIntExtra("lang", 0);
        recyclerViewSports = findViewById(R.id.recycler_alphabet);
        backMenu = findViewById(R.id.menu_nav);
        colorName = findViewById(R.id.sports_name);

        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SportsActivity.super.onBackPressed();
            }
        });

        featuredAlphabet();

    }

    private void featuredAlphabet() {
        ArrayList<SportsHelper> questionLocations = new ArrayList<>();
        questionLocations.add(new SportsHelper("Basketball"));
        questionLocations.add(new SportsHelper("Volleyball"));
        questionLocations.add(new SportsHelper("Tennis ball"));
        questionLocations.add(new SportsHelper("Swimming"));
        questionLocations.add(new SportsHelper("Football"));
        questionLocations.add(new SportsHelper("Karate"));
        questionLocations.add(new SportsHelper("Handball"));
        questionLocations.add(new SportsHelper("Judo"));
        questionLocations.add(new SportsHelper("Rugby"));
        questionLocations.add(new SportsHelper("Dead-lifting"));


        adapter = new SportsAdapter(questionLocations, this, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewSports.setLayoutManager(gridLayoutManager);
        recyclerViewSports.setAdapter(adapter);
    }

    @Override
    public void onViewClicked(int clickedViewId, int clickedItemPosition) {
        try {
            switch (clickedItemPosition) {
                case 0:
                    if (flag==1)colorName.setText("Basketball");
                    else if (flag==2)colorName.setText("Baloncesto");
                    else if (flag==3)colorName.setText("Basket-ball");
                    else if (flag==4)colorName.setText("Basketball");
                    break;
                case 1:
                    if (flag==1)colorName.setText("Volleyball");
                    else if (flag==2)colorName.setText("Vóleibol");
                    else if (flag==3)colorName.setText("Volley-ball");
                    else if (flag==4)colorName.setText("Volleyball");
                    break;
                case 2:
                    if (flag==1)colorName.setText("Tennis ball");
                    else if (flag==2)colorName.setText("Tenis");
                    else if (flag==3)colorName.setText("Tennis");
                    else if (flag==4)colorName.setText("Tennis");
                    break;
                case 3:
                    if (flag==1)colorName.setText("Swimming");
                    else if (flag==2)colorName.setText("Nadando");
                    else if (flag==3)colorName.setText("La natation");
                    else if (flag==4)colorName.setText("Schwimmen");
                    break;
                case 4:
                    if (flag==1)colorName.setText("Football");
                    else if (flag==2)colorName.setText("Fútbol");
                    else if (flag==3)colorName.setText("Le football");
                    else if (flag==4)colorName.setText("Fußball");
                    break;
                case 5:
                    if (flag==1)colorName.setText("Karate");
                    else if (flag==2)colorName.setText("Kárate");
                    else if (flag==3)colorName.setText("Karaté");
                    else if (flag==4)colorName.setText("Karate");
                    break;
                case 6:
                    if (flag==1)colorName.setText("Handball");
                    else if (flag==2)colorName.setText("Balonmano");
                    else if (flag==3)colorName.setText("Handball");
                    else if (flag==4)colorName.setText("Handball");
                    break;
                case 7:
                    if (flag==1)colorName.setText("Judo");
                    else if (flag==2)colorName.setText("Judo");
                    else if (flag==3)colorName.setText("Judo");
                    else if (flag==4)colorName.setText("Judo");
                    break;
                case 8:
                    if (flag==1)colorName.setText("Rugby");
                    else if (flag==2)colorName.setText("Rugby");
                    else if (flag==3)colorName.setText("Le Rugby");
                    else if (flag==4)colorName.setText("Rugby");
                    break;
                case 9:
                    if (flag==1) colorName.setText("Dead-lifting");
                    else if (flag==2)colorName.setText("peso muerto");
                    else if (flag==3)colorName.setText("soulevé de terre");
                    else if (flag==4)colorName.setText("Kreuzheben");
                    break;
                default:
                    Toast.makeText(this, "Wrong index", Toast.LENGTH_SHORT).show();
                    colorName.setText("Sports");
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewLongClicked(int clickedViewId, int clickedItemPosition) {

    }

}