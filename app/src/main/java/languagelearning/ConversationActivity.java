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
import ideanity.oceans.languagelearning.adapter.ConversationAdapter;
import ideanity.oceans.languagelearning.helpers.ConversationHelper;

public class ConversationActivity extends AppCompatActivity implements RecyclerViewAction {

    RecyclerView recyclerViewConversation;
    RecyclerView.Adapter adapter;
    int flag;

    ImageView backMenu;
    TextView colorName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_conversation);
        flag = getIntent().getIntExtra("lang", 0);
        recyclerViewConversation = findViewById(R.id.recycler_alphabet);
        backMenu = findViewById(R.id.menu_nav);
        colorName = findViewById(R.id.conversation_answer);
        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConversationActivity.super.onBackPressed();
            }
        });

        featuredAlphabet();

    }

    private void featuredAlphabet() {
        ArrayList<ConversationHelper> questionLocations = new ArrayList<>();
        questionLocations.add(new ConversationHelper("Name"));
        questionLocations.add(new ConversationHelper("Year"));
        questionLocations.add(new ConversationHelper("Living in"));
        questionLocations.add(new ConversationHelper("Health"));
        questionLocations.add(new ConversationHelper("Nationality"));
        questionLocations.add(new ConversationHelper("Weather"));


        adapter = new ConversationAdapter(questionLocations, this, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewConversation.setLayoutManager(gridLayoutManager);
        recyclerViewConversation.setAdapter(adapter);
    }

    @Override
    public void onViewClicked(int clickedViewId, int clickedItemPosition) {
        try {
            switch (clickedItemPosition) {
                case 0:
                    if(flag==1)colorName.setText("What is your name?");
                    else if (flag==2)colorName.setText("¿Cuál es su nombre?");
                    else if (flag==3)colorName.setText("Quel est ton nom?");
                    else if (flag==4)colorName.setText("Wie heissen Sie?");
                    break;
                case 1:
                    if(flag==1)colorName.setText("How old are you?");
                    else if (flag==2)colorName.setText("¿Cuantos años tienes?");
                    else if (flag==3)colorName.setText("Quel âge as-tu?");
                    else if (flag==4)colorName.setText("wie alt sind Sie?");
                    break;
                case 2:
                    if(flag==1)colorName.setText("Where are you living?");
                    else if (flag==2)colorName.setText("¿Donde estas viviendo?");
                    else if (flag==3)colorName.setText("Où habites-tu?");
                    else if (flag==4)colorName.setText("Wo lebst Du?");
                    break;
                case 3:
                    if(flag==1)colorName.setText("How are you?");
                    else if (flag==2)colorName.setText("¿Cómo estás?");
                    else if (flag==3)colorName.setText("Comment ca va?");
                    else if (flag==4)colorName.setText("Wie geht es dir?");
                    break;
                case 4:
                    if(flag==1)colorName.setText("What is your nationality?");
                    else if (flag==2)colorName.setText("¿Cual es tu nacionalidad?");
                    else if (flag==3)colorName.setText("Quelle est ta nationalité?");
                    else if (flag==4)colorName.setText("Was ist deine Nationalität?");
                    break;
                case 5:
                    if(flag==1) colorName.setText("How is the weather now?");
                    else if (flag==2)colorName.setText("¿Cómo está el clima ahora?");
                    else if (flag==3)colorName.setText("Comment est le temps en ce moment?");
                    else if (flag==4)colorName.setText("Wie ist das Wetter zurzeit?");
                    break;
                default:
                    Toast.makeText(this, "Wrong index", Toast.LENGTH_SHORT).show();
                    colorName.setText("What to ask?");
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewLongClicked(int clickedViewId, int clickedItemPosition) {

    }

}