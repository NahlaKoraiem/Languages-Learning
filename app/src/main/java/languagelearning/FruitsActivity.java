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

import ideanity.oceans.languagelearning.adapter.FruitsAdapter;
import ideanity.oceans.languagelearning.helpers.FruitsHelper;

public class FruitsActivity extends AppCompatActivity implements RecyclerViewAction {

    RecyclerView recyclerViewFruits;
    RecyclerView.Adapter adapter;
    int flag;
    ImageView backMenu;
    TextView colorName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fruits);
        flag = getIntent().getIntExtra("lang", 0);
        recyclerViewFruits = findViewById(R.id.recycler_shape);
        backMenu = findViewById(R.id.menu_nav);
        colorName = findViewById(R.id.fruit_name);

        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FruitsActivity.super.onBackPressed();
            }
        });

        featuredShapes();

    }

    private void featuredShapes() {
        ArrayList<FruitsHelper> questionLocations = new ArrayList<>();
        questionLocations.add(new FruitsHelper(R.drawable.apple));
        questionLocations.add(new FruitsHelper(R.drawable.starwberries));
        questionLocations.add(new FruitsHelper(R.drawable.mango));
        questionLocations.add(new FruitsHelper(R.drawable.banana));
        questionLocations.add(new FruitsHelper(R.drawable.watermelon));
        questionLocations.add(new FruitsHelper(R.drawable.orange));
        questionLocations.add(new FruitsHelper(R.drawable.pineapple));
        questionLocations.add(new FruitsHelper(R.drawable.grape));
        questionLocations.add(new FruitsHelper(R.drawable.cherry));
        questionLocations.add(new FruitsHelper(R.drawable.kiwi));


        adapter = new FruitsAdapter(questionLocations, this, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewFruits.setLayoutManager(gridLayoutManager);
        recyclerViewFruits.setAdapter(adapter);
    }

    @Override
    public void onViewClicked(int clickedViewId, int clickedItemPosition) {
        try {
            switch (clickedItemPosition) {
                case 0:
                    if (flag==1)colorName.setText("Apple");
                    else if (flag==2)colorName.setText("Manzana");
                    else if (flag==3)colorName.setText("Pomme");
                    else if (flag==4)colorName.setText("Apfel");
                    break;
                case 1:
                    if (flag==1)colorName.setText("Strawberries");
                    else if (flag==2)colorName.setText("Fresas");
                    else if (flag==3)colorName.setText("Fraises");
                    else if (flag==4)colorName.setText("Erdbeeren");
                    break;
                case 2:
                    if (flag==1)colorName.setText("Mango");
                    else if (flag==2)colorName.setText("Mango");
                    else if (flag==3)colorName.setText("Mangue");
                    else if (flag==4)colorName.setText("Mango");
                    break;
                case 3:
                    if (flag==1)colorName.setText("Banana");
                    else if (flag==2)colorName.setText("Plátano");
                    else if (flag==3)colorName.setText("Banane");
                    else if (flag==4)colorName.setText("Banane");
                    break;
                case 4:
                    if (flag==1)colorName.setText("Watermelon");
                    else if (flag==2)colorName.setText("Sandía");
                    else if (flag==3)colorName.setText("Pastèque");
                    else if (flag==4)colorName.setText("Wassermelone");
                    break;
                case 5:
                    if (flag==1) colorName.setText("Orange");
                    else if (flag==2)colorName.setText("Naranja");
                    else if (flag==3)colorName.setText("Orange");
                    else if (flag==4)colorName.setText("Orange");
                    break;
                case 6:
                    if (flag==1)colorName.setText("Pineapple");
                    else if (flag==2)colorName.setText("Piña");
                    else if (flag==3)colorName.setText("Ananas");
                    else if (flag==4)colorName.setText("Ananas");
                    break;
                case 7:
                    if (flag==1)colorName.setText("Grape");
                    else if (flag==2)colorName.setText("Uva");
                    else if (flag==3)colorName.setText("Grain de raisin");
                    else if (flag==4)colorName.setText("Traube");
                    break;
                case 8:
                    if (flag==1)colorName.setText("Chery");
                    else if (flag==2)colorName.setText("Chery");
                    else if (flag==3)colorName.setText("Chery");
                    else if (flag==4)colorName.setText("Kirsche");
                    break;
                case 9:
                    if (flag==1)colorName.setText("Kiwi");
                    else if (flag==2)colorName.setText("Kiwi");
                    else if (flag==3)colorName.setText("Kiwi");
                    else if (flag==4)colorName.setText("Kiwi");
                    break;
                default:
                    Toast.makeText(this, "Wrong index", Toast.LENGTH_SHORT).show();
                    colorName.setText("Fruits");
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewLongClicked(int clickedViewId, int clickedItemPosition) {

    }

}