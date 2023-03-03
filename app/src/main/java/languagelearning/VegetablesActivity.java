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

import ideanity.oceans.languagelearning.adapter.VegetablesAdapter;
import ideanity.oceans.languagelearning.helpers.VegetablesHelper;

public class VegetablesActivity extends AppCompatActivity implements RecyclerViewAction {

    RecyclerView recyclerViewShape;
    RecyclerView.Adapter adapter;
    int flag;
    ImageView backMenu;
    TextView colorName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_vegetables);
        flag = getIntent().getIntExtra("lang", 0);
        recyclerViewShape = findViewById(R.id.recycler_shape);
        backMenu = findViewById(R.id.menu_nav);
        colorName = findViewById(R.id.vegetable_name);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VegetablesActivity.super.onBackPressed();
            }
        });

        featuredShapes();

    }

    private void featuredShapes() {
        ArrayList<VegetablesHelper> questionLocations = new ArrayList<>();
        questionLocations.add(new VegetablesHelper(R.drawable.carrot));
        questionLocations.add(new VegetablesHelper(R.drawable.tomato));
        questionLocations.add(new VegetablesHelper(R.drawable.cauliflower));
        questionLocations.add(new VegetablesHelper(R.drawable.onion));
        questionLocations.add(new VegetablesHelper(R.drawable.potato));
        questionLocations.add(new VegetablesHelper(R.drawable.mushroom));
        questionLocations.add(new VegetablesHelper(R.drawable.corn));
        questionLocations.add(new VegetablesHelper(R.drawable.garlic));
        questionLocations.add(new VegetablesHelper(R.drawable.brocoli));


        adapter = new VegetablesAdapter(questionLocations, this, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewShape.setLayoutManager(gridLayoutManager);
        recyclerViewShape.setAdapter(adapter);
    }

    @Override
    public void onViewClicked(int clickedViewId, int clickedItemPosition) {
        try {
            switch (clickedItemPosition) {
                case 0:
                    if (flag==1)colorName.setText("Carrot");
                    else if (flag==2)colorName.setText("Zanahoria");
                    else if (flag==3)colorName.setText("Carotte");
                    else if (flag==4)colorName.setText("Karotte");
                    break;
                case 1:
                    if (flag==1)colorName.setText("Tomato");
                    else if (flag==2)colorName.setText("Tomate");
                    else if (flag==3)colorName.setText("Tomate");
                    else if (flag==4)colorName.setText("Tomate");
                    break;
                case 2:
                    if (flag==1) colorName.setText("Cauliflower");
                    else if (flag==2)colorName.setText("Coliflor");
                    else if (flag==3)colorName.setText("Chou-fleur");
                    else if (flag==4)colorName.setText("Blumenkohl");
                    break;
                case 3:
                    if (flag==1)colorName.setText("Onion");
                    else if (flag==2)colorName.setText("Cebolla");
                    else if (flag==3)colorName.setText("Oignon");
                    else if (flag==4)colorName.setText("Zwiebel");
                    break;
                case 4:
                    if (flag==1)colorName.setText("Potato");
                    else if (flag==2)colorName.setText("patata");
                    else if (flag==3)colorName.setText("Pomme de terre");
                    else if (flag==4)colorName.setText("Kartoffel");
                    break;
                case 5:
                    if (flag==1)colorName.setText("Mushroom");
                    else if (flag==2)colorName.setText("Hongo");
                    else if (flag==3)colorName.setText("Champignon");
                    else if (flag==4)colorName.setText("Pilz");
                    break;
                case 6:
                    if (flag==1) colorName.setText("Corn");
                    else if (flag==2)colorName.setText("Maíz");
                    else if (flag==3)colorName.setText("Maïs");
                    else if (flag==4)colorName.setText("Mais");
                    break;
                case 7:
                    if (flag==1)colorName.setText("Garlic");
                    else if (flag==2)colorName.setText("Ajo");
                    else if (flag==3)colorName.setText("Ail");
                    else if (flag==4)colorName.setText("Knoblauch");
                    break;
                case 8:
                    if (flag==1)colorName.setText("Broccoli");
                    else if (flag==2)colorName.setText("Brócoli");
                    else if (flag==3)colorName.setText("Brocoli");
                    else if (flag==4)colorName.setText("Brokkoli");
                    break;
                default:
                    Toast.makeText(this, "Wrong index", Toast.LENGTH_SHORT).show();
                    colorName.setText("Vegetables");
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewLongClicked(int clickedViewId, int clickedItemPosition) {

    }

}