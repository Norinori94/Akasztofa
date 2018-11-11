package com.example.nori.akasztfa;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView TextView_betu, TextView_megoldas;
    private Button Button_minusz, Button_plusz, Button_tippel;
    private ImageView ImageView_kep;

    private Random r = new Random();

    private String[] szavak = {"MUREXID", "ACETON", "KLORIDION", "FENOLFTALEIN", "KÉNSAV", "CITROMSAV", "ANALITIKA",
                               "POLAROGRÁF", "FOSZFORSAV", "FLUORESZCEIN", "HEXÁN", "BENZOL", "METILNARANCS", "HPLC",
                               "TIMSÓ", "KONDUKTOMÉTER", "EXTRAKCIÓ", "IZOPROPANOL", "BÓRAX", "DERIVATOGRÁF", "GC"};
    private Character[] betuk = {'A', 'Á', 'B', 'C', 'D', 'E', 'É', 'F', 'G', 'H', 'I', 'Í', 'J', 'K', 'L', 'M', 'N',
                                 'O', 'Ó', 'Ö', 'Ő', 'P', 'Q', 'R', 'S', 'T', 'U', 'Ú', 'Ü', 'Ű', 'V', 'W', 'X', 'Y', 'Z'};
    private int betu = 0;
    private int szo = r.nextInt(szavak.length);
    private int elet = 13;
    private int tartalmaz = 0;
    private int hianyzoBetu = 0;
    private String[] tomb = tombLetrehoz(szavak[szo].length());
    private String vonal = kiirandoSzo(tomb, szavak[szo].length());
    private List<Character> hasznaltBetuk = new ArrayList<Character>();
    MainActivity myself = this;

    private DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    myself.ujraKezd();
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
					bezar();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        TextView_megoldas.setText(vonal);
        TextView_betu.setText("" + betuk[betu]);

        Button_minusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (betu ==0) {
                    betu = 34;
                }

                else {
                    betu--;
                }

                TextView_betu.setText("" + betuk[betu]);

                for (int i = 0; i < hasznaltBetuk.size(); i++)
                {
                    if (hasznaltBetuk.contains(betuk[betu])){
                        TextView_betu.setTextColor(getResources().getColor(R.color.colorFekete));
                    }
                    if (!(hasznaltBetuk.contains(betuk[betu]))){
                        TextView_betu.setTextColor(getResources().getColor(R.color.colorNarancs));
                    }
                }
            }
        });

        Button_plusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (betu ==34) {
                    betu = 0;
                }

                else {
                    betu++;
                }

                TextView_betu.setText("" + betuk[betu]);

                for (int i = 0; i < hasznaltBetuk.size(); i++)
                {
                    if (hasznaltBetuk.contains(betuk[betu])){
                        TextView_betu.setTextColor(getResources().getColor(R.color.colorFekete));
                    }
                    if (!(hasznaltBetuk.contains(betuk[betu]))){
                        TextView_betu.setTextColor(getResources().getColor(R.color.colorNarancs));
                    }
                }
            }
        });

        Button_tippel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView_betu.setTextColor(getResources().getColor(R.color.colorFekete));
                hasznaltBetuk.add(TextView_betu.getText().charAt(0));

                for (int i = 0; i < szavak[szo].length(); i++)
                {
                    if (TextView_betu.getText().charAt(0) == szavak[szo].charAt(i)){
                        tomb[i] = TextView_betu.getText().toString();
                        vonal = kiirandoSzo(tomb, tomb.length);
                        TextView_megoldas.setText(vonal);
                        tartalmaz++;
                    }
                }

                if (tartalmaz == 0) {
                    elet--;
                    switch (elet) {
                        case 12:
                            ImageView_kep.setBackgroundResource(R.drawable.akasztofa01);
                            break;
                        case 11:
                            ImageView_kep.setBackgroundResource(R.drawable.akasztofa02);
                            break;
                        case 10:
                            ImageView_kep.setBackgroundResource(R.drawable.akasztofa03);
                            break;
                        case 9:
                            ImageView_kep.setBackgroundResource(R.drawable.akasztofa04);
                            break;
                        case 8:
                            ImageView_kep.setBackgroundResource(R.drawable.akasztofa05);
                            break;
                        case 7:
                            ImageView_kep.setBackgroundResource(R.drawable.akasztofa06);
                            break;
                        case 6:
                            ImageView_kep.setBackgroundResource(R.drawable.akasztofa07);
                            break;
                        case 5:
                            ImageView_kep.setBackgroundResource(R.drawable.akasztofa08);
                            break;
                        case 4:
                            ImageView_kep.setBackgroundResource(R.drawable.akasztofa09);
                            break;
                        case 3:
                            ImageView_kep.setBackgroundResource(R.drawable.akasztofa10);
                            break;
                        case 2:
                            ImageView_kep.setBackgroundResource(R.drawable.akasztofa11);
                            break;
                        case 1:
                            ImageView_kep.setBackgroundResource(R.drawable.akasztofa12);
                            break;
                        case 0: {
                            ImageView_kep.setBackgroundResource(R.drawable.akasztofa13);
                            AlertDialog.Builder builder = new AlertDialog.Builder(myself);
                            builder.setMessage("Nem sikerült kitalálni!\n\n" + "Szeretnél még egyet játszani?").setPositiveButton
                                    ("Igen", dialogClickListener).setNegativeButton("Nem", dialogClickListener).show();
                        }
                        break;
                    }
                }

                tartalmaz = 0;
				hianyzoBetu = 0;
				
                for (int i = 0; i < szavak[szo].length(); i++)
                {
                    if (tomb[i].equals("_")){
                        hianyzoBetu ++;
                    }
                }

                if (hianyzoBetu == 0){
                    AlertDialog.Builder builder = new AlertDialog.Builder(myself);
                    builder.setMessage("Helyes megfejtés!\n\n" + "Szeretnél még egyet játszani?").setPositiveButton
                            ("Igen", dialogClickListener).setNegativeButton("Nem", dialogClickListener).show();
                }
            }
        });


    }

    public void init(){

        ImageView_kep = (ImageView) findViewById(R.id.ImageView_kep);

        Button_plusz = (Button) findViewById(R.id.Button_plusz);
        Button_minusz = (Button) findViewById(R.id.Button_minusz);
        Button_tippel = (Button) findViewById(R.id.Button_tippel);

        TextView_betu = (TextView) findViewById(R.id.TextView_betu);
        TextView_megoldas = (TextView) findViewById(R.id.TextView_megoldas);
    }

    public String[] tombLetrehoz(int hossz){

        String vonal[] = new String[hossz];
        String elem = "_";

        for (int i = 0; i < hossz; i++)
        {
            vonal[i] = elem;
        }

        return vonal;
    }

    public String kiirandoSzo(String[] tomb, int hossz){

        String vonal = "";

        for (int i = 0; i < hossz; i++){
            vonal += " " + tomb[i];
        }

        vonal += " ";

        return vonal;
    }
	
    public void ujraKezd(){
        betu = 0;
        szo = r.nextInt(szavak.length);
        elet = 13;
        tartalmaz = 0;
        hasznaltBetuk.clear();
        tomb = tombLetrehoz(szavak[szo].length());
        ImageView_kep.setBackgroundResource(R.drawable.akasztofa00);
        vonal = kiirandoSzo(tomb, szavak[szo].length());
        TextView_megoldas.setText(vonal);
        TextView_betu.setText("" + betuk[betu]);
        TextView_betu.setTextColor(getResources().getColor(R.color.colorNarancs));
    }
	
	public void bezar() {
        finish();
        moveTaskToBack(true);
    }
}
