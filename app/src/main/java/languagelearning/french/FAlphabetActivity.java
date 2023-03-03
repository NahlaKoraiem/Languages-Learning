package ideanity.oceans.languagelearning.french;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ideanity.oceans.languagelearning.R;
import ideanity.oceans.languagelearning.RecyclerViewAction;
import ideanity.oceans.languagelearning.helpers.AlphabetHelper;

public class FAlphabetActivity extends AppCompatActivity implements RecyclerViewAction {

    RecyclerView recyclerViewAlphabet;
    RecyclerView.Adapter adapter;

    ImageView backMenu;
    TextView colorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_alphabet);

        recyclerViewAlphabet = findViewById(R.id.recycler_alphabet);
        backMenu = findViewById(R.id.menu_nav);
        colorName = findViewById(R.id.alphabet_number);


        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FAlphabetActivity.super.onBackPressed();
            }
        });

        featuredAlphabet();

    }

    private void featuredAlphabet() {
        ArrayList<AlphabetHelper> questionLocations = new ArrayList<>();
        questionLocations.add(new AlphabetHelper("A"));
        questionLocations.add(new AlphabetHelper("B"));
        questionLocations.add(new AlphabetHelper("C"));
        questionLocations.add(new AlphabetHelper("D"));
        questionLocations.add(new AlphabetHelper("E"));
        questionLocations.add(new AlphabetHelper("F"));
        questionLocations.add(new AlphabetHelper("G"));
        questionLocations.add(new AlphabetHelper("H"));
        questionLocations.add(new AlphabetHelper("I"));
        questionLocations.add(new AlphabetHelper("J"));
        questionLocations.add(new AlphabetHelper("K"));
        questionLocations.add(new AlphabetHelper("L"));
        questionLocations.add(new AlphabetHelper("M"));
        questionLocations.add(new AlphabetHelper("N"));
        questionLocations.add(new AlphabetHelper("O"));
        questionLocations.add(new AlphabetHelper("P"));
        questionLocations.add(new AlphabetHelper("Q"));
        questionLocations.add(new AlphabetHelper("R"));
        questionLocations.add(new AlphabetHelper("S"));
        questionLocations.add(new AlphabetHelper("T"));
        questionLocations.add(new AlphabetHelper("U"));
        questionLocations.add(new AlphabetHelper("V"));
        questionLocations.add(new AlphabetHelper("W"));
        questionLocations.add(new AlphabetHelper("X"));
        questionLocations.add(new AlphabetHelper("Y"));
        questionLocations.add(new AlphabetHelper("Z"));

        adapter = new FAlphabetAdapter(questionLocations, this, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewAlphabet.setLayoutManager(gridLayoutManager);
        recyclerViewAlphabet.setAdapter(adapter);
    }

    @Override
    public void onViewClicked(int clickedViewId, int clickedItemPosition) {
        try {
            switch (clickedItemPosition) {
                case 0:
                    colorName.setText("A");
                    break;
                case 1:
                    colorName.setText("B");
                    break;
                case 2:
                    colorName.setText("C");
                    break;
                case 3:
                    colorName.setText("D");
                    break;
                case 4:
                    colorName.setText("E");
                    break;
                case 5:
                    colorName.setText("F");
                    break;
                case 6:
                    colorName.setText("G");
                    break;
                case 7:
                    colorName.setText("H");
                    break;
                case 8:
                    colorName.setText("I");
                    break;
                case 9:
                    colorName.setText("J");
                    break;
                case 10:
                    colorName.setText("K");
                    break;
                case 11:
                    colorName.setText("L");
                    break;
                case 12:
                    colorName.setText("M");
                    break;
                case 13:
                    colorName.setText("N");
                    break;
                case 14:
                    colorName.setText("O");
                    break;
                case 15:
                    colorName.setText("P");
                    break;
                case 16:
                    colorName.setText("Q");
                    break;
                case 17:
                    colorName.setText("R");
                    break;
                case 18:
                    colorName.setText("S");
                    break;
                case 19:
                    colorName.setText("T");
                    break;
                case 20:
                    colorName.setText("U");
                    break;
                case 21:
                    colorName.setText("V");
                    break;
                case 22:
                    colorName.setText("W");
                    break;
                case 23:
                    colorName.setText("X");
                    break;
                case 24:
                    colorName.setText("Y");
                    break;
                case 25:
                    colorName.setText("Z");
                    break;
                default:
                    Toast.makeText(this, "Wrong index", Toast.LENGTH_SHORT).show();
                    colorName.setText("Alphabet");
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewLongClicked(int clickedViewId, int clickedItemPosition) {

    }
}