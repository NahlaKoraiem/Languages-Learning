package ideanity.oceans.languagelearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ideanity.oceans.languagelearning.adapter.WeekAdapter;
import ideanity.oceans.languagelearning.helpers.WeekHelper;

public class WeekActivity extends AppCompatActivity implements RecyclerViewAction {

    RecyclerView recyclerViewWeek;
    RecyclerView.Adapter adapter;
    static MediaPlayer mpone;
    static MediaPlayer mptwo;
    static MediaPlayer mpthree;
    static MediaPlayer mpfour;
    static MediaPlayer mpfive;
    static MediaPlayer mpsix;
    static MediaPlayer mpseven;
    int flag;
    ImageView backMenu;
    TextView colorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_week);
        flag = getIntent().getIntExtra("lang", 0);
        recyclerViewWeek = findViewById(R.id.recycler_week);
        backMenu = findViewById(R.id.menu_nav);
        colorName = findViewById(R.id.week_number);

        mpone = MediaPlayer.create(WeekActivity.this, R.raw.sunday);
        mptwo= MediaPlayer.create(WeekActivity.this, R.raw.monday);
        mpthree= MediaPlayer.create(WeekActivity.this, R.raw.tuesday);
        mpfour= MediaPlayer.create(WeekActivity.this, R.raw.wednesday);
        mpfive= MediaPlayer.create(WeekActivity.this, R.raw.thursday);
        mpsix= MediaPlayer.create(WeekActivity.this, R.raw.friday);
        mpseven= MediaPlayer.create(WeekActivity.this, R.raw.saturday);

        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WeekActivity.super.onBackPressed();
            }
        });
        
        featuredWeek();
        
    }

    private void featuredWeek() {
        ArrayList<WeekHelper> questionLocations = new ArrayList<>();
        questionLocations.add(new WeekHelper("Sunday"));
        questionLocations.add(new WeekHelper("Monday"));
        questionLocations.add(new WeekHelper("Tuesday"));
        questionLocations.add(new WeekHelper("Wednesday"));
        questionLocations.add(new WeekHelper("Thursday"));
        questionLocations.add(new WeekHelper("Friday"));
        questionLocations.add(new WeekHelper("Saturday"));

        recyclerViewWeek.setHasFixedSize(true);
        recyclerViewWeek.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapter = new WeekAdapter(questionLocations, this, this);
        recyclerViewWeek.setAdapter(adapter);
        
    }

    @Override
    public void onViewClicked(int clickedViewId, int clickedItemPosition) {
        try {
            switch (clickedItemPosition) {
                case 0:
                    if (flag==1){mpone.start(); colorName.setText("Sunday");}
                    else if(flag==2)colorName.setText("Domingo");
                    else if(flag==3)colorName.setText("Lundi");
                    else if(flag==4)colorName.setText("Sonntag");
                    break;
                case 1:
                    if (flag==1){mptwo.start(); colorName.setText("Monday");}
                    else if(flag==2)colorName.setText("Lunes");
                    else if(flag==3)colorName.setText("Lundi");
                    else if(flag==4)colorName.setText("Montag");
                    break;
                case 2:
                    if (flag==1){mpthree.start(); colorName.setText("Tuesday");}
                    else if(flag==2)colorName.setText("Martes");
                    else if(flag==3)colorName.setText("Mardi");
                    else if(flag==4)colorName.setText("Dienstag");
                    break;
                case 3:
                    if (flag==1){mpfour.start(); colorName.setText("Wednesday");}
                    else if(flag==2)colorName.setText("Miércoles");
                    else if(flag==3)colorName.setText("Mercredi");
                    else if(flag==4)colorName.setText("Mittwoch");
                    break;
                case 4:
                    if (flag==1){mpfive.start(); colorName.setText("Thursday");}
                    else if(flag==2)colorName.setText("Jueves");
                    else if(flag==3)colorName.setText("Jeudi");
                    else if(flag==4)colorName.setText("Donnerstag");
                    break;
                case 5:
                    if (flag==1){mpsix.start(); colorName.setText("Friday");}
                    else if(flag==2)colorName.setText("Viernes");
                    else if(flag==3)colorName.setText("Vendredi");
                    else if(flag==4)colorName.setText("Freitag");
                    break;
                case 6:
                    if (flag==1){mpseven.start(); colorName.setText("Saturday");}
                    else if(flag==2)colorName.setText("Sábado");
                    else if(flag==3)colorName.setText("Samedi");
                    else if(flag==4)colorName.setText("Samstag");
                    break;
                default:
                    Toast.makeText(this, "Wrong index", Toast.LENGTH_SHORT).show();
                    colorName.setText("Today");
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewLongClicked(int clickedViewId, int clickedItemPosition) {

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mpone.release();
        mptwo.release();
        mpthree.release();
        mpfour.release();
        mpfive.release();
        mpsix.release();
        mpseven.release();
    }


}
