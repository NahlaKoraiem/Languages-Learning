package ideanity.oceans.languagelearning;

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
import ideanity.oceans.languagelearning.adapter.AnimalAdapter;
import ideanity.oceans.languagelearning.helpers.AnimalHelper;

public class AnimalsActivity extends AppCompatActivity implements RecyclerViewAction {

    RecyclerView recyclerViewShape;
    RecyclerView.Adapter adapter;
    int flag;
    ImageView backMenu;
    TextView colorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_animals);
        flag = getIntent().getIntExtra("lang", 0);
        recyclerViewShape = findViewById(R.id.recycler_shape);
        colorName = findViewById(R.id.animal_name);

        backMenu = findViewById(R.id.menu_nav);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimalsActivity.super.onBackPressed();
            }
        });

        featuredShapes();

    }

    private void featuredShapes() {
        ArrayList<AnimalHelper> questionLocations = new ArrayList<>();
        questionLocations.add(new AnimalHelper(R.drawable.horse));
        questionLocations.add(new AnimalHelper(R.drawable.bear));
        questionLocations.add(new AnimalHelper(R.drawable.elephant));
        questionLocations.add(new AnimalHelper(R.drawable.deer));
        questionLocations.add(new AnimalHelper(R.drawable.giraffe));
        questionLocations.add(new AnimalHelper(R.drawable.cheetah));
        questionLocations.add(new AnimalHelper(R.drawable.zebra));
        questionLocations.add(new AnimalHelper(R.drawable.dog));

        adapter = new AnimalAdapter(questionLocations, this, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewShape.setLayoutManager(gridLayoutManager);
        recyclerViewShape.setAdapter(adapter);
    }

    @Override
    public void onViewClicked(int clickedViewId, int clickedItemPosition) {
        try {
            switch (clickedItemPosition) {
                case 0:
                    if(flag==1)colorName.setText("Horse");
                    else if (flag==2)colorName.setText("Caballo");
                    else if(flag==3)colorName.setText("Cheval");
                    else if(flag==4)colorName.setText("Pferd");
                    break;
                case 1:
                    if(flag==1)colorName.setText("Bear");
                    else if(flag==2)colorName.setText("Llevar");
                    else if(flag==3)colorName.setText("Ourse");
                    else if(flag==4)colorName.setText("Bär");
                    break;
                case 2:
                    if(flag==1)colorName.setText("Elephant");
                    else if(flag==2)colorName.setText("elefante");
                    else if(flag==3)colorName.setText("Éléphante");
                    else if(flag==4)colorName.setText("Elefant");
                    break;
                case 3:
                    if(flag==1)colorName.setText("Deer");
                    else if(flag==2)colorName.setText("Cierva");
                    else if(flag==3)colorName.setText("Biche");
                    else if(flag==4)colorName.setText("Hirsch");
                    break;
                case 4:
                    if(flag==1)colorName.setText("Giraffe");
                    else if(flag==2)colorName.setText("jirafa");
                    else if(flag==3)colorName.setText("Girafe");
                    else if(flag==4)colorName.setText("Giraffe");
                    break;
                case 5:
                    if(flag==1)colorName.setText("Cheetah");
                    else if(flag==2)colorName.setText("leopardo");
                    else if(flag==3)colorName.setText("Guépard");
                    else if(flag==4)colorName.setText("Gepard");
                    break;
                case 6:
                    if(flag==1)colorName.setText("Zebra");
                    else if(flag==2)colorName.setText("cebra");
                    else if(flag==3)colorName.setText("zèbre");
                    else if(flag==4)colorName.setText("Zebra");
                    break;
                case 7:
                    if(flag==1)colorName.setText("Dog");
                    else if(flag==2)colorName.setText("perra");
                    else if(flag==3)colorName.setText("chien");
                    else if(flag==4)colorName.setText("Hund");
                    break;
                default:
                    Toast.makeText(this, "Wrong index", Toast.LENGTH_SHORT).show();
                    colorName.setText("Animals");
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewLongClicked(int clickedViewId, int clickedItemPosition) {

    }

}