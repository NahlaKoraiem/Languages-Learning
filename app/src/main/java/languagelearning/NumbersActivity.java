package ideanity.oceans.languagelearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ideanity.oceans.languagelearning.adapter.NumberAdapter;
import ideanity.oceans.languagelearning.helpers.NumberHelper;

public class NumbersActivity extends AppCompatActivity implements RecyclerViewAction {

    RecyclerView recyclerViewNumber;
    RecyclerView.Adapter adapter;
    int flag;
    static MediaPlayer mpone;
    static MediaPlayer mptwo;
    static MediaPlayer mpthree;
    static MediaPlayer mpfour;
    static MediaPlayer mpfive;
    static MediaPlayer mpsix;
    static MediaPlayer mpseven;
    static MediaPlayer mpeight;
    static MediaPlayer mpnine;
    static MediaPlayer mpten;
    static MediaPlayer mpeleven;
    static MediaPlayer mptwelve;
    static MediaPlayer mpthrten;
    static MediaPlayer mpfouteen;
    static MediaPlayer mpfifthen;
    static MediaPlayer mpsixten;
    static MediaPlayer mpseventen;
    static MediaPlayer mpeighten;
    static MediaPlayer mpninten;
    static MediaPlayer mptwenty;

    ImageView backMenu;
    TextView colorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_numbers);
        flag = getIntent().getIntExtra("lang", 0);
        recyclerViewNumber = findViewById(R.id.recycler_numbers);
        backMenu = findViewById(R.id.menu_nav);
        colorName = findViewById(R.id.number_name);

        mpone = MediaPlayer.create(NumbersActivity.this, R.raw.kid_1);
        mptwo= MediaPlayer.create(NumbersActivity.this, R.raw.kid_2);
        mpthree= MediaPlayer.create(NumbersActivity.this, R.raw.kid_3);
        mpfour= MediaPlayer.create(NumbersActivity.this, R.raw.kid_4);
        mpfive= MediaPlayer.create(NumbersActivity.this, R.raw.kid_5);
        mpsix= MediaPlayer.create(NumbersActivity.this, R.raw.kid_6);
        mpseven= MediaPlayer.create(NumbersActivity.this, R.raw.kid_7);
        mpeight= MediaPlayer.create(NumbersActivity.this, R.raw.kid_8);
        mpnine= MediaPlayer.create(NumbersActivity.this, R.raw.kid_9);
        mpten= MediaPlayer.create(NumbersActivity.this, R.raw.kid_10);
        mpeleven = MediaPlayer.create(NumbersActivity.this, R.raw.eleven);
        mptwelve= MediaPlayer.create(NumbersActivity.this, R.raw.twelve);
        mpthrten= MediaPlayer.create(NumbersActivity.this, R.raw.thirteen);
        mpfouteen= MediaPlayer.create(NumbersActivity.this, R.raw.fourteen);
        mpfifthen= MediaPlayer.create(NumbersActivity.this, R.raw.fifteen);
        mpsixten= MediaPlayer.create(NumbersActivity.this, R.raw.sixteen);
        mpseventen= MediaPlayer.create(NumbersActivity.this, R.raw.seventeen);
        mpeighten= MediaPlayer.create(NumbersActivity.this, R.raw.eighteen);
        mpninten= MediaPlayer.create(NumbersActivity.this, R.raw.nineteen);
        mptwenty= MediaPlayer.create(NumbersActivity.this, R.raw.twenty);

        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumbersActivity.super.onBackPressed();
            }
        });

        featuredNumbers();
    }

    private void featuredNumbers() {
        ArrayList<NumberHelper> questionLocations = new ArrayList<>();
        questionLocations.add(new NumberHelper("1"));
        questionLocations.add(new NumberHelper("2"));
        questionLocations.add(new NumberHelper("3"));
        questionLocations.add(new NumberHelper("4"));
        questionLocations.add(new NumberHelper("5"));
        questionLocations.add(new NumberHelper("6"));
        questionLocations.add(new NumberHelper("7"));
        questionLocations.add(new NumberHelper("8"));
        questionLocations.add(new NumberHelper("9"));
        questionLocations.add(new NumberHelper("10"));
        questionLocations.add(new NumberHelper("11"));
        questionLocations.add(new NumberHelper("12"));
        questionLocations.add(new NumberHelper("13"));
        questionLocations.add(new NumberHelper("14"));
        questionLocations.add(new NumberHelper("15"));
        questionLocations.add(new NumberHelper("16"));
        questionLocations.add(new NumberHelper("17"));
        questionLocations.add(new NumberHelper("18"));
        questionLocations.add(new NumberHelper("19"));
        questionLocations.add(new NumberHelper("20"));

        adapter = new NumberAdapter(questionLocations, this, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewNumber.setLayoutManager(gridLayoutManager);
        recyclerViewNumber.setAdapter(adapter);
    }

    @Override
    public void onViewClicked(int clickedViewId, int clickedItemPosition) {
        try {
            switch (clickedItemPosition) {
                case 0:
                    if(flag==1){mpone.start(); colorName.setText("One");}
                    else if (flag==2) colorName.setText("Uno");
                    else if (flag==3) colorName.setText("Un");
                    else if (flag==4) colorName.setText("Eins");
                    break;
                case 1:
                    if(flag ==1) {mptwo.start(); colorName.setText("Two");}
                    else if (flag ==2) colorName.setText("Dos");
                    else if (flag == 3)colorName.setText("Deux");
                    else if (flag == 4)colorName.setText("Zwei");
                    break;
                case 2:
                    if(flag == 1){mpthree.start(); colorName.setText("Three");}
                    else if (flag == 2) colorName.setText("Tres");
                    else if (flag == 3)colorName.setText("Trois");
                    else if (flag == 4 )colorName.setText("Drei");
                    break;
                case 3:
                    if(flag==1) {mpfour.start();
                        colorName.setText("Four");
                    }
                    else if (flag==2)colorName.setText("Cuatro");
                    else if (flag==3)colorName.setText("Quatre");
                    else if (flag == 4)colorName.setText("Vier");
                    break;
                case 4:
                    if(flag==1) {mpfive.start();
                        colorName.setText("Five");
                    }
                    else if (flag==2)colorName.setText("Cinco");
                    else if (flag==3)colorName.setText("Cinq");
                    else if (flag == 4)colorName.setText("Fünf");
                    break;
                case 5:
                    if(flag==1) {mpsix.start();
                        colorName.setText("Six");
                    }
                    else if (flag==2)colorName.setText("Seis");
                    else if (flag==3)colorName.setText("Six");
                    else if (flag == 4)colorName.setText("Sechs");
                    break;
                case 6:
                    if(flag==1) {
                        mpseven.start();
                    }
                    else if (flag==2)colorName.setText("Siete");
                    else if (flag==3)colorName.setText("Sept");
                    else if (flag == 4)colorName.setText("Sieben");
                    break;
                case 7:
                    if(flag==1) {mpeight.start();
                        colorName.setText("Eight");
                    }
                    else if (flag==2)colorName.setText("Ocho");
                    else if (flag==3)colorName.setText("Huit");
                    else if (flag == 4)colorName.setText("OnAchte");
                    break;
                case 8:
                    if(flag==1) {mpnine.start();
                        colorName.setText("Nine");
                    }
                    else if (flag==2)colorName.setText("Nueve");
                    else if (flag==3)colorName.setText("Huit");
                    else if (flag == 4)colorName.setText("Neun");
                    break;
                case 9:
                    if(flag==1) {mpten.start();
                        colorName.setText("Ten");
                    }
                    else if (flag==2)colorName.setText("Diez");
                    else if (flag==3)colorName.setText("Dix");
                    else if (flag == 4)colorName.setText("Zehn");
                    break;
                case 10:
                    if(flag==1) {mpeleven.start();
                        colorName.setText("Eleven");
                    }
                    else if (flag==2)colorName.setText("Once");
                    else if (flag==3)colorName.setText("Onze");
                    else if (flag == 4)colorName.setText("Elf");
                    break;
                case 11:
                    if(flag==1) {mptwelve.start();
                        colorName.setText("Twelve");
                    }
                    else if (flag==2)colorName.setText("Doce");
                    else if (flag==3)colorName.setText("Douze");
                    else if (flag == 4)colorName.setText("Zwölf");
                    break;
                case 12:
                    if(flag==1) {mpthrten.start();
                        colorName.setText("Thirteen");
                    }
                    else if (flag==2)colorName.setText("Trece");
                    else if (flag==3)colorName.setText("Treize");
                    else if (flag == 4)colorName.setText("Dreizehn");
                    break;
                case 13:
                    if(flag==1) {mpfouteen.start();
                        colorName.setText("Fourteen");
                    }
                    else if (flag==2)colorName.setText("Catorce");
                    else if (flag==3)colorName.setText("Quatorze");
                    else if (flag == 4)colorName.setText("Vierzehn");
                    break;
                case 14:
                    if(flag==1) {mpfifthen.start();
                        colorName.setText("Fifteen");
                    }
                    else if (flag==2)colorName.setText("Quince");
                    else if (flag==3)colorName.setText("Quinze");
                    else if (flag == 4)colorName.setText("Fünfzehn");
                    break;
                case 15:
                    if(flag==1) {
                        mpsixten.start();
                    }
                    else if (flag==2)colorName.setText("Dieciséis");
                    else if (flag==3)colorName.setText("Seize");
                    else if (flag == 4)colorName.setText("Sechszehn");
                    break;
                case 16:
                    if(flag==1) {mpseventen.start();
                        colorName.setText("Seventeen");
                    }
                    else if (flag==2)colorName.setText("Diecisiete");
                    else if (flag==3)colorName.setText("Dix-sept");
                    else if (flag == 4)colorName.setText("Siebzehn");
                    break;
                case 17:
                    if(flag==1) {mpeighten.start();
                        colorName.setText("Eighteen");
                    }
                    else if (flag==2)colorName.setText("Dieciocho");
                    else if (flag==3)colorName.setText("Dix-huit");
                    else if (flag == 4)colorName.setText("Achtzehn");
                    break;
                case 18:
                    if(flag==1) {mpninten.start();
                        colorName.setText("Nineteen");
                    }
                    else if (flag==2)colorName.setText("Diecinueve");
                    else if (flag==3)colorName.setText("Dix-neuf");
                    else if (flag == 4)colorName.setText("Neunzehn");
                    break;
                case 19:
                    if(flag==1) {mptwenty.start();
                        colorName.setText("Twenty");
                    }
                    else if (flag==2)colorName.setText("Veinte");
                    else if (flag==3)colorName.setText("Vingt");
                    else if (flag == 4)colorName.setText("Zwanzig");
                    break;
                default:
                    Toast.makeText(this, "Wrong index", Toast.LENGTH_SHORT).show();
                    colorName.setText("Numbers");
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
        mpeight.release();
        mpnine.release();
        mpten.release();
        mpeleven.release();
        mptwelve.release();
        mpthrten.release();
        mpfouteen.release();
        mpfifthen.release();
        mpsixten.release();
        mpseventen.release();
        mpeighten.release();
        mpninten.release();
        mptwenty.release();
    }


}
















