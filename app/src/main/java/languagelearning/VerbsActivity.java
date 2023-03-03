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

import ideanity.oceans.languagelearning.adapter.VerbsAdapter;
import ideanity.oceans.languagelearning.helpers.VerbsHelper;

public class VerbsActivity extends AppCompatActivity implements RecyclerViewAction {

    RecyclerView recyclerViewVerbs;
    RecyclerView.Adapter adapter;
    int flag;
    ImageView backMenu;
    TextView colorName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_verbs);
        flag = getIntent().getIntExtra("lang", 0);
        recyclerViewVerbs = findViewById(R.id.recycler_shape);
        backMenu = findViewById(R.id.menu_nav);
        colorName = findViewById(R.id.verbs);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VerbsActivity.super.onBackPressed();
            }
        });

        featuredShapes();

    }

    private void featuredShapes() {
        ArrayList<VerbsHelper> questionLocations = new ArrayList<>();
        questionLocations.add(new VerbsHelper(R.drawable.clean));
        questionLocations.add(new VerbsHelper(R.drawable.cook));
        questionLocations.add(new VerbsHelper(R.drawable.eat));
        questionLocations.add(new VerbsHelper(R.drawable.play));
        questionLocations.add(new VerbsHelper(R.drawable.ride));
        questionLocations.add(new VerbsHelper(R.drawable.write));


        adapter = new VerbsAdapter(questionLocations, this, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewVerbs.setLayoutManager(gridLayoutManager);
        recyclerViewVerbs.setAdapter(adapter);
    }

    @Override
    public void onViewClicked(int clickedViewId, int clickedItemPosition) {
        try {
            switch (clickedItemPosition) {
                case 0:
                    if (flag==1)colorName.setText("Cleaning");
                    else if (flag==2)colorName.setText("Limpieza");
                    else if (flag==3)colorName.setText("Nettoyage");
                    else if (flag==4)colorName.setText("Reinigung");
                    break;
                case 1:
                    if (flag==1)colorName.setText("Cooking");
                    else if (flag==2)colorName.setText("Cocinando");
                    else if (flag==3)colorName.setText("Cuisine");
                    else if (flag==4)colorName.setText("Kochen");
                    break;
                case 2:
                    if (flag==1)colorName.setText("Eating");
                    else if (flag==2)colorName.setText("Comiendo");
                    else if (flag==3)colorName.setText("En mangeant");
                    else if (flag==4)colorName.setText("Essen");
                    break;
                case 3:
                    if (flag==1)colorName.setText("Playing");
                    else if (flag==2)colorName.setText("Jugando");
                    else if (flag==3)colorName.setText("En jouant");
                    else if (flag==4)colorName.setText("Spielen");
                    break;
                case 4:
                    if (flag==1)colorName.setText("Riding");
                    else if (flag==2)colorName.setText("Montando");
                    else if (flag==3)colorName.setText("Équitation");
                    else if (flag==4)colorName.setText("Reiten");
                    break;
                case 5:
                    if (flag==1)colorName.setText("Writing");
                    else if (flag==2)colorName.setText("Escritura");
                    else if (flag==3)colorName.setText("L'écriture");
                    else if (flag==4)colorName.setText("Schreiben");
                    break;
                default:
                    Toast.makeText(this, "Wrong index", Toast.LENGTH_SHORT).show();
                    colorName.setText("Baking");
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewLongClicked(int clickedViewId, int clickedItemPosition) {

    }

}