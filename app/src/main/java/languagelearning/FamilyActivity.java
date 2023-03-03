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
import adapter.FamilyAdapter;
import ideanity.oceans.languagelearning.helpers.FamilyHelper;

public class FamilyActivity extends AppCompatActivity implements RecyclerViewAction {

    RecyclerView recyclerViewFamily;
    RecyclerView.Adapter adapter;
    int flag;
    ImageView backMenu;
    TextView colorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_family);
        flag = getIntent().getIntExtra("lang", 0);
        recyclerViewFamily = findViewById(R.id.recycler_shape);
        backMenu = findViewById(R.id.menu_nav);
        colorName = findViewById(R.id.member_name);

        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FamilyActivity.super.onBackPressed();
            }
        });
        
        featuredShapes();

    }

    private void featuredShapes() {
        ArrayList<FamilyHelper> questionLocations = new ArrayList<>();
        questionLocations.add(new FamilyHelper(R.drawable.grandpa));
        questionLocations.add(new FamilyHelper(R.drawable.grandma));
        questionLocations.add(new FamilyHelper(R.drawable.dad));
        questionLocations.add(new FamilyHelper(R.drawable.mom));
        questionLocations.add(new FamilyHelper(R.drawable.brother));
        questionLocations.add(new FamilyHelper(R.drawable.sister));
        questionLocations.add(new FamilyHelper(R.drawable.aunt));
        questionLocations.add(new FamilyHelper(R.drawable.uncle));
        questionLocations.add(new FamilyHelper(R.drawable.cousin));
        questionLocations.add(new FamilyHelper(R.drawable.mcousin));


        adapter = new FamilyAdapter(questionLocations, this, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewFamily.setLayoutManager(gridLayoutManager);
        recyclerViewFamily.setAdapter(adapter);
    }

    @Override
    public void onViewClicked(int clickedViewId, int clickedItemPosition) {
        try {
            switch (clickedItemPosition) {
                case 0:
                    if (flag==1)colorName.setText("Grandpa");
                    else if (flag==2)colorName.setText("Abuelo");
                    else if (flag==3)colorName.setText("Grand-père");
                    else if (flag==4)colorName.setText("Opa");
                    break;
                case 1:
                    if (flag==1)colorName.setText("Grandma");
                    else if (flag==2)colorName.setText("Abuela");
                    else if (flag==3)colorName.setText("Grand-mère");
                    else if (flag==4)colorName.setText("Oma");
                    break;
                case 2:
                    if (flag==1)colorName.setText("Dad");
                    else if (flag==2)colorName.setText("Papá");
                    else if (flag==3)colorName.setText("Père");
                    else if (flag==4)colorName.setText("Papa");
                    break;
                case 3:
                    if (flag==1)colorName.setText("Mom");
                    else if (flag==2)colorName.setText("Mamá");
                    else if (flag==3)colorName.setText("Maman");
                    else if (flag==4)colorName.setText("Mama");
                    break;
                case 4:
                    if (flag==1)colorName.setText("Brother");
                    else if (flag==2)colorName.setText("Hermano");
                    else if (flag==3)colorName.setText("Frère");
                    else if (flag==4)colorName.setText("Bruder");
                    break;
                case 5:
                    if (flag==1)colorName.setText("Sister");
                    else if (flag==2)colorName.setText("Hermana");
                    else if (flag==3)colorName.setText("Sœur");
                    else if (flag==4)colorName.setText("Schwester");
                    break;
                case 6:
                    if (flag==1)colorName.setText("Aunt");
                    else if (flag==2)colorName.setText("Tía");
                    else if (flag==3)colorName.setText("Tante");
                    else if (flag==4)colorName.setText("Tante");
                    break;
                case 7:
                    if (flag==1)colorName.setText("Uncle");
                    else if (flag==2)colorName.setText("Tío");
                    else if (flag==3)colorName.setText("Oncle");
                    else if (flag==4)colorName.setText("Onkel");
                    break;
                case 8:
                    if (flag==1)colorName.setText("Cousin");
                    else if (flag==2)colorName.setText("Prima");
                    else if (flag==3)colorName.setText("Cousine");
                    else if (flag==4)colorName.setText("Cousine");
                    break;
                case 9:
                    if (flag==1)colorName.setText("Cousin");
                    else if (flag==2)colorName.setText("Primo");
                    else if (flag==3)colorName.setText("Primo");
                    else if (flag==4)colorName.setText("Cousin");
                    break;
                default:
                    Toast.makeText(this, "Wrong index", Toast.LENGTH_SHORT).show();
                    colorName.setText("My Family");
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewLongClicked(int clickedViewId, int clickedItemPosition) {

    }

}