package com.example.prirucnikizbora;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.inputmethodservice.Keyboard;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prirucnikizbora.R.raw;

import java.security.KeyStore;
import java.util.ArrayList;

import static com.example.prirucnikizbora.R.raw.s11;
import static com.example.prirucnikizbora.R.raw.s16;
    //tekst je izdovjen u interfejs db
public class HomeActivity extends AppCompatActivity implements db {

    //glavni naslovi sa početne stranice
    TextView naslovG1,naslovG2,naslovG3,naslovG4,naslovG5,naslovG6,naslovG7,naslovG8;

    // arraylist koja se koristi kao bekstek
    ArrayList searchList = new ArrayList<String>();
    // koristi se grupni view na istom Activity kako bi izbjegli grubi prelaz između pojedinih dijelova aplikacije
    LinearLayout linearView1,linearView21,linearView22,linearView23,linearView24,linearView25,linearView26,linearView27
            ,linearView28,linearView3,linearView4,linearView5;

    LinearLayout podnaslovS1,podnaslovS2,podnaslovS3,podnaslovS4,podnaslovS5,podnaslovS6,podnaslovS7
            ,podnaslovS8,podnaslovS9,podnaslovS10,podnaslovS11,podnaslovS12,podnaslovS13,podnaslovS14,
            podnaslovS15,podnaslovS16,podnaslovS17,podnaslovS18,podnaslovS19,
            podnaslovS20,podnaslovS21,podnaslovS22,podnaslovS23,podnaslovS24,podnaslovS25
            ,podnaslovS26,podnaslovS27,podnaslovS28,podnaslovS29,podnaslovS30,podnaslovS31,podnaslovS32,
            podnaslovS33,podnaslovS34,podnaslovS35,podnaslovS36,podnaslovS37,podnaslovS38,podnaslovS39,podnaslovS40,podnaslovS41,podnaslovS42,podnaslovS43,podnaslovS44,podnaslovS45,podnaslovS46,
            podnaslovS47,podnaslovS48,podnaslovS49,podnaslovS50,podnaslovS51,podnaslovS52,podnaslovS53,podnaslovS54,podnaslovS55,podnaslovS56,
            podnaslovS57,podnaslovS58,podnaslovS59,podnaslovS60,podnaslovSnema;


    LinearLayout mjera1,mjera2,mjera3,mjera4,mjera5,mjera6,mjera7,mjera8,mjera9,mjera10,mjera11,mjera12,mjera13,
            mjera14,mjera15,mjera16,mjera17,mjera18,mjera19,mjera20,mjera21,mjera22;

    TextView naslovMjere;
    TextView opcija1,opcija2,opcija3,opcija4,opcija5,opcija6,opcija7,opcija8,opcija9;
    LinearLayout korak1,korak2,korak3,korak4,korak5,korak6,korak7,korak8,korak9;
    LinearLayout korak11,korak22,korak33,korak44,korak55,korak66,korak77,korak88,korak99;
    TextView korak1text,korak2text,korak3text,korak4text,korak5text,korak6text,korak7text,korak8text,korak9text;
    ImageView imopcija1,imopcija2,imopcija3,imopcija4,imopcija5,imopcija6,imopcija7,imopcija8,imopcija9;

    TextView podnaslov11,podnaslov12,podnaslov13,podnaslov14,podnaslov15,podnaslov16,
            podnaslov21,podnaslov22,naslovTeksta,textView,naslovApp,
            podnaslov31,podnaslov32,podnaslov33,podnaslov34,podnaslov35,podnaslov36,
            podnaslov37,podnaslov38,podnaslov39,podnaslov310,podnaslov41,
            podnaslov51,podnaslov52,podnaslov53,podnaslov54,podnaslov55,podnaslov56,
            podnaslov57,podnaslov58,podnaslov59,podnaslov61,podnaslov62,
            podnaslov71,podnaslov72,
            podnaslov81,podnaslov82,podnaslov83,podnaslov84,podnaslov85,podnaslov86;
    ImageView slika;
    EditText searcher;
    int brisi;
    ImageView imZoomIn,imZoomOut,searchLogo,imHome;
    ImageView imMjere;
    int textSize=18;
    String backStackPatern;
    String backStack="000";
    String uzorak;
    int length,searchCounter=0;
    public long backPressedTime,backPressedTime1;
    Boolean key=false;

    SpannableString text1,text2,text31,text33,text34,text35,text36;

    private static final int TIME_INTERVAL = 190; // iinterval od 190 ms, dva klika na back dugme unutar 190ms na izlaz iz app

    // ako je back stack, ponovnim pritiskom na back dugme se izlazi iz app, nakon prvog pritiska dolazi odgovarajući alert
    @Override
    public void onBackPressed() {
        if (searchList.size() == 1){
            if (backPressedTime +2000>System.currentTimeMillis()) {
                finishAffinity();

            }else {
                Toast.makeText(getBaseContext(),"Pritisnite ponovo za izlaz!",Toast.LENGTH_SHORT).show();
            }
            backPressedTime = System.currentTimeMillis();
        } else {
            if (backPressedTime1 + TIME_INTERVAL > System.currentTimeMillis())
            {
                super.onBackPressed();
                return;
            }
            backPressedTime1 = System.currentTimeMillis();
            backPressed();


        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //uređivanje teksta, boldiranje, podvlačenje...
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        StyleSpan boldSpan1 = new StyleSpan(Typeface.BOLD);
        StyleSpan boldSpan2 = new StyleSpan(Typeface.BOLD);

        StyleSpan italicSpan = new StyleSpan(Typeface.ITALIC);
        StyleSpan italicSpan1 = new StyleSpan(Typeface.ITALIC);
        StyleSpan italicSpan2 = new StyleSpan(Typeface.ITALIC);
        StyleSpan italicSpan3 = new StyleSpan(Typeface.ITALIC);

        UnderlineSpan uSpan = new UnderlineSpan();
        UnderlineSpan uSpan1 = new UnderlineSpan();
        UnderlineSpan uSpan2 = new UnderlineSpan();
        UnderlineSpan uSpan3 = new UnderlineSpan();
        UnderlineSpan uSpan4 = new UnderlineSpan();
        UnderlineSpan uSpan5 = new UnderlineSpan();

        ForegroundColorSpan foregroundSpan = new ForegroundColorSpan(Color.rgb(255, 138, 0));

        text1= new SpannableString(text1b);
        text1.setSpan(boldSpan,301,465, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        text2= new SpannableString(text2b);
        text2.setSpan(boldSpan,530,732, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        text31= new SpannableString(text31b);
        text31.setSpan(boldSpan,1403,1585, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text31.setSpan(foregroundSpan, 1586, 1639, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        text33= new SpannableString(text33b);
        text33.setSpan(boldSpan,0,24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text33.setSpan(boldSpan1,243,262, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        text34= new SpannableString(text34b);
        text34.setSpan(boldSpan,0,24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text34.setSpan(boldSpan1,907,931, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text34.setSpan(boldSpan2,1408,1440, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text35= new SpannableString(text35b);

        text35.setSpan(uSpan,0,19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text35.setSpan(uSpan1,517,579, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text35.setSpan(uSpan2,1183,1229, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        text36= new SpannableString(text36b);

        text36.setSpan(uSpan,78,92, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text36.setSpan(italicSpan,78,92, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text36.setSpan(uSpan1,113,226, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text36.setSpan(uSpan2,711,758, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text36.setSpan(italicSpan1,711,758, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text36.setSpan(uSpan3,1701,1728, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text36.setSpan(italicSpan2,1701,1728, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text36.setSpan(boldSpan,1474,1700, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text36.setSpan(uSpan4,2169,2199, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text36.setSpan(italicSpan3,2169,2199, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text36.setSpan(uSpan5,2315,2329, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        searchList.add("000");

        setContentView(R.layout.activity_home);

        //inicijalizacija elemenata

        slika = findViewById(R.id.slika);

        podnaslovSnema=findViewById(R.id.podnaslovSnema);
        podnaslovSnema.setVisibility(View.GONE);

        podnaslovS1=findViewById(R.id.podnaslovS1);
        podnaslovS2=findViewById(R.id.podnaslovS2);
        podnaslovS3=findViewById(R.id.podnaslovS3);
        podnaslovS4=findViewById(R.id.podnaslovS4);
        podnaslovS5=findViewById(R.id.podnaslovS5);
        podnaslovS6=findViewById(R.id.podnaslovS6);
        podnaslovS7=findViewById(R.id.podnaslovS7);
        podnaslovS8=findViewById(R.id.podnaslovS8);
        podnaslovS9=findViewById(R.id.podnaslovS9);
        podnaslovS10=findViewById(R.id.podnaslovS10);
        podnaslovS11=findViewById(R.id.podnaslovS11);
        podnaslovS12=findViewById(R.id.podnaslovS12);
        podnaslovS13=findViewById(R.id.podnaslovS13);
        podnaslovS14=findViewById(R.id.podnaslovS14);
        podnaslovS15=findViewById(R.id.podnaslovS15);
        podnaslovS16=findViewById(R.id.podnaslovS16);
        podnaslovS17=findViewById(R.id.podnaslovS17);
        podnaslovS18=findViewById(R.id.podnaslovS18);
        podnaslovS19=findViewById(R.id.podnaslovS19);
        podnaslovS20=findViewById(R.id.podnaslovS20);
        podnaslovS21=findViewById(R.id.podnaslovS21);
        podnaslovS22=findViewById(R.id.podnaslovS22);
        podnaslovS23=findViewById(R.id.podnaslovS23);
        podnaslovS24=findViewById(R.id.podnaslovS24);
        podnaslovS25=findViewById(R.id.podnaslovS25);
        podnaslovS26=findViewById(R.id.podnaslovS26);
        podnaslovS27=findViewById(R.id.podnaslovS27);
        podnaslovS28=findViewById(R.id.podnaslovS28);
        podnaslovS29=findViewById(R.id.podnaslovS29);
        podnaslovS30=findViewById(R.id.podnaslovS30);
        podnaslovS31=findViewById(R.id.podnaslovS31);
        podnaslovS32=findViewById(R.id.podnaslovS32);
        podnaslovS33=findViewById(R.id.podnaslovS33);
        podnaslovS34=findViewById(R.id.podnaslovS34);
        podnaslovS35=findViewById(R.id.podnaslovS35);
        podnaslovS36=findViewById(R.id.podnaslovS36);
        podnaslovS37=findViewById(R.id.podnaslovS37);
        podnaslovS38=findViewById(R.id.podnaslovS38);
        podnaslovS39=findViewById(R.id.podnaslovS39);
        podnaslovS40=findViewById(R.id.podnaslovS40);
        podnaslovS41=findViewById(R.id.podnaslovS41);
        podnaslovS42=findViewById(R.id.podnaslovS42);
        podnaslovS43=findViewById(R.id.podnaslovS43);
        podnaslovS44=findViewById(R.id.podnaslovS44);
        podnaslovS45=findViewById(R.id.podnaslovS45);
        podnaslovS46=findViewById(R.id.podnaslovS46);
        podnaslovS47=findViewById(R.id.podnaslovS47);
        podnaslovS48=findViewById(R.id.podnaslovS48);
        podnaslovS49=findViewById(R.id.podnaslovS49);
        podnaslovS50=findViewById(R.id.podnaslovS50);
        podnaslovS51=findViewById(R.id.podnaslovS51);
        podnaslovS52=findViewById(R.id.podnaslovS52);
        podnaslovS53=findViewById(R.id.podnaslovS53);
        podnaslovS54=findViewById(R.id.podnaslovS54);
        podnaslovS55=findViewById(R.id.podnaslovS55);
        podnaslovS56=findViewById(R.id.podnaslovS56);
        podnaslovS57 =findViewById(R.id.podnaslovS57);
        podnaslovS58 =findViewById(R.id.podnaslovS58);
        podnaslovS59=findViewById(R.id.podnaslovS59);
        podnaslovS60=findViewById(R.id.podnaslovS60);

        searchLogo=findViewById(R.id.searchLogo);



        sakriNaslove();


        imZoomIn = findViewById(R.id.imZoomIn);
        imZoomOut = findViewById(R.id.imZoomOut);
        imMjere = findViewById(R.id.imMjere);
        linearView4=findViewById(R.id.linearView4);
        linearView1 = findViewById(R.id.linearView1);

        naslovApp=findViewById(R.id.naslov_app);
        searcher=findViewById(R.id.searcher);
        linearView21=findViewById(R.id.linearView21);
        linearView22=findViewById(R.id.linearView22);
        linearView23=findViewById(R.id.linearView23);
        linearView24=findViewById(R.id.linearView24);
        linearView25=findViewById(R.id.linearView25);
        linearView26=findViewById(R.id.linearView26);
        linearView27=findViewById(R.id.linearView27);
        linearView28=findViewById(R.id.linearView28);






        linearView5=findViewById(R.id.linearView5);
        naslovG1= findViewById(R.id.naslovG1);
        naslovG2= findViewById(R.id.naslovG2);
        naslovG3= findViewById(R.id.naslovG3);
        naslovG4= findViewById(R.id.naslovG4);
        naslovG5= findViewById(R.id.naslovG5);
        naslovG6= findViewById(R.id.naslovG6);
        naslovG7= findViewById(R.id.naslovG7);
        naslovG8= findViewById(R.id.naslovG8);



        podnaslov11=findViewById(R.id.podnaslov11);
        podnaslov12=findViewById(R.id.podnaslov12);
        podnaslov13=findViewById(R.id.podnaslov13);
        podnaslov14=findViewById(R.id.podnaslov14);
        podnaslov15=findViewById(R.id.podnaslov15);
        podnaslov16=findViewById(R.id.podnaslov16);

        podnaslov21=findViewById(R.id.podnaslov21);
        podnaslov22=findViewById(R.id.podnaslov22);

        podnaslov31=findViewById(R.id.podnaslov31);
        podnaslov32=findViewById(R.id.podnaslov32);
        podnaslov33=findViewById(R.id.podnaslov33);
        podnaslov34=findViewById(R.id.podnaslov34);
        podnaslov35=findViewById(R.id.podnaslov35);
        podnaslov36=findViewById(R.id.podnaslov36);
        podnaslov37=findViewById(R.id.podnaslov37);
        podnaslov38=findViewById(R.id.podnaslov38);
        podnaslov39=findViewById(R.id.podnaslov39);
        podnaslov310=findViewById(R.id.podnaslov310);

        podnaslov41=findViewById(R.id.podnaslov41);

        podnaslov51=findViewById(R.id.podnaslov51);
        podnaslov52=findViewById(R.id.podnaslov52);
        podnaslov53=findViewById(R.id.podnaslov53);
        podnaslov54=findViewById(R.id.podnaslov54);
        podnaslov55=findViewById(R.id.podnaslov55);
        podnaslov56=findViewById(R.id.podnaslov56);
        podnaslov57=findViewById(R.id.podnaslov57);
        podnaslov58=findViewById(R.id.podnaslov58);
        podnaslov59=findViewById(R.id.podnaslov59);

        podnaslov61=findViewById(R.id.podnaslov61);
        podnaslov62=findViewById(R.id.podnaslov62);

        podnaslov71=findViewById(R.id.podnaslov71);
        podnaslov72=findViewById(R.id.podnaslov72);

        podnaslov81=findViewById(R.id.podnaslov81);
        podnaslov82=findViewById(R.id.podnaslov82);
        podnaslov83=findViewById(R.id.podnaslov83);
        podnaslov84=findViewById(R.id.podnaslov84);
        podnaslov85=findViewById(R.id.podnaslov85);
        podnaslov86=findViewById(R.id.podnaslov86);

        naslovMjere=findViewById(R.id.naslovMjere);

        korak1=findViewById(R.id.korak1);
        korak2=findViewById(R.id.korak2);
        korak3=findViewById(R.id.korak3);
        korak4=findViewById(R.id.korak4);
        korak5=findViewById(R.id.korak5);
        korak6=findViewById(R.id.korak6);
        korak7=findViewById(R.id.korak7);
        korak8=findViewById(R.id.korak8);
        korak9=findViewById(R.id.korak9);

        korak11=findViewById(R.id.korak11);
        korak22=findViewById(R.id.korak22);
        korak33=findViewById(R.id.korak33);
        korak44=findViewById(R.id.korak44);
        korak55=findViewById(R.id.korak55);
        korak66=findViewById(R.id.korak66);
        korak77=findViewById(R.id.korak77);
        korak88=findViewById(R.id.korak88);
        korak99=findViewById(R.id.korak99);

        opcija1=findViewById(R.id.opcija1);
        opcija2=findViewById(R.id.opcija2);
        opcija3=findViewById(R.id.opcija3);
        opcija4=findViewById(R.id.opcija4);
        opcija5=findViewById(R.id.opcija5);
        opcija6=findViewById(R.id.opcija6);
        opcija7=findViewById(R.id.opcija7);
        opcija8=findViewById(R.id.opcija8);
        opcija9=findViewById(R.id.opcija9);

        imopcija1=findViewById(R.id.imopcija1);
        imopcija2=findViewById(R.id.imopcija2);
        imopcija3=findViewById(R.id.imopcija3);
        imopcija4=findViewById(R.id.imopcija4);
        imopcija5=findViewById(R.id.imopcija5);
        imopcija6=findViewById(R.id.imopcija6);
        imopcija7=findViewById(R.id.imopcija7);
        imopcija8=findViewById(R.id.imopcija8);
        imopcija9 =findViewById(R.id.imopcija9);

        korak1text=findViewById(R.id.korak1text);
        korak2text=findViewById(R.id.korak2text);
        korak3text=findViewById(R.id.korak3text);
        korak4text=findViewById(R.id.korak4text);
        korak5text=findViewById(R.id.korak5text);
        korak6text=findViewById(R.id.korak6text);
        korak7text=findViewById(R.id.korak7text);
        korak8text=findViewById(R.id.korak8text);
        korak9text=findViewById(R.id.korak9text);

        korak11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (korak1text.getVisibility() == View.VISIBLE) {
                    korak1text.setVisibility(View.GONE);
                    imopcija1.setImageResource(R.drawable.ic_down);
                } else {
                    zatvorisve();
                    imopcija1.setImageResource(R.drawable.ic_up);
                    korak1text.setVisibility(View.VISIBLE);


                }
            }
        });
        korak22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (korak2text.getVisibility() == View.VISIBLE) {
                    korak2text.setVisibility(View.GONE);
                    imopcija2.setImageResource(R.drawable.ic_down);
                } else {
                    zatvorisve();
                    imopcija2.setImageResource(R.drawable.ic_up);
                    korak2text.setVisibility(View.VISIBLE);


                }
            }
        });

        korak33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (korak3text.getVisibility() == View.VISIBLE) {
                    korak3text.setVisibility(View.GONE);
                    imopcija3.setImageResource(R.drawable.ic_down);
                } else {
                    zatvorisve();
                    imopcija3.setImageResource(R.drawable.ic_up);
                    korak3text.setVisibility(View.VISIBLE);


                }
            }
        });
        korak44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (korak4text.getVisibility() == View.VISIBLE) {
                    korak4text.setVisibility(View.GONE);
                    imopcija4.setImageResource(R.drawable.ic_down);
                } else {
                    zatvorisve();
                    imopcija4.setImageResource(R.drawable.ic_up);
                    korak4text.setVisibility(View.VISIBLE);


                }
            }
        });
        korak55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (korak5text.getVisibility() == View.VISIBLE) {
                    korak5text.setVisibility(View.GONE);
                    imopcija5.setImageResource(R.drawable.ic_down);
                } else {
                    zatvorisve();
                    imopcija5.setImageResource(R.drawable.ic_up);
                    korak5text.setVisibility(View.VISIBLE);


                }
            }
        });
        korak66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (korak6text.getVisibility() == View.VISIBLE) {
                    korak6text.setVisibility(View.GONE);
                    imopcija6.setImageResource(R.drawable.ic_down);
                } else {
                    zatvorisve();
                    imopcija6.setImageResource(R.drawable.ic_up);
                    korak6text.setVisibility(View.VISIBLE);


                }
            }
        });
        korak77.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (korak7text.getVisibility() == View.VISIBLE) {
                    korak7text.setVisibility(View.GONE);
                    imopcija7.setImageResource(R.drawable.ic_down);
                } else {
                    zatvorisve();
                    imopcija7.setImageResource(R.drawable.ic_up);
                    korak7text.setVisibility(View.VISIBLE);


                }
            }
        });
        korak88.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (korak8text.getVisibility() == View.VISIBLE) {
                    korak8text.setVisibility(View.GONE);
                    imopcija8.setImageResource(R.drawable.ic_down);
                } else {
                    zatvorisve();
                    imopcija8.setImageResource(R.drawable.ic_up);
                    korak8text.setVisibility(View.VISIBLE);


                }
            }
        });
        korak99.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (korak9text.getVisibility() == View.VISIBLE) {
                    korak9text.setVisibility(View.GONE);
                    imopcija9.setImageResource(R.drawable.ic_down);
                } else {
                    zatvorisve();
                    imopcija9.setImageResource(R.drawable.ic_up);
                    korak8text.setVisibility(View.VISIBLE);


                }
            }
        });

        mjera1= findViewById(R.id.mjera1);
        mjera2= findViewById(R.id.mjera2);
        mjera3= findViewById(R.id.mjera3);
        mjera4= findViewById(R.id.mjera4);
        mjera5= findViewById(R.id.mjera5);
        mjera6= findViewById(R.id.mjera6);
        mjera7= findViewById(R.id.mjera7);
        mjera8= findViewById(R.id.mjera8);
        mjera9= findViewById(R.id.mjera9);
        mjera10= findViewById(R.id.mjera10);
        mjera11= findViewById(R.id.mjera11);
        mjera12= findViewById(R.id.mjera12);
        mjera13= findViewById(R.id.mjera13);
        mjera14= findViewById(R.id.mjera14);
        mjera15= findViewById(R.id.mjera15);
        mjera16= findViewById(R.id.mjera16);
        mjera17= findViewById(R.id.mjera17);
        mjera18= findViewById(R.id.mjera18);
        mjera19= findViewById(R.id.mjera19);
        mjera20= findViewById(R.id.mjera20);
        mjera21= findViewById(R.id.mjera21);
        mjera22= findViewById(R.id.mjera22);


        mjera1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("201");
                otvori1();

            }
        });
        mjera2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("202");
                otvori2();

            }
        });
        mjera3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("203");
                otvori3();

            }
        });
        mjera4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("204");
                otvori4();

            }
        });
        mjera5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("205");
                otvori5();

            }
        });
        mjera6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("206");
                otvori6();

            }
        });
        mjera7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("207");
                otvori7();

            }
        });
        mjera8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("208");
                otvori8();

            }
        });
        mjera9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("209");
                otvori9();

            }
        });
        mjera10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("210");
                otvori10();

            }
        });
        mjera11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("211");
                otvori11();

            }
        });
        mjera12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("212");
                otvori12();

            }
        });
        mjera13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("213");
                otvori13();

            }
        });
        mjera14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("214");
                otvori14();

            }
        });
        mjera15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("215");
                otvori15();

            }
        });
        mjera16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("216");
                otvori16();

            }
        });
        mjera17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("217");
                otvori17();

            }
        });
        mjera18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("218");
                otvori18();

            }
        });  mjera19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("219");
                otvori19();

            }
        });
        mjera20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("220");
                otvori20();

            }
        });
        mjera21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("221");
                otvori21();

            }
        });
        mjera22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchList.add("222");
                otvori22();

            }
        });




        naslovTeksta = findViewById(R.id.naslovPrikaz);
        textView = findViewById(R.id.textPrikaz);
        // postavljanje obostranog poravnjanja na tekst, ukoliko verzija androida to dozvoljava
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            textView.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
            korak1text.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
            korak2text.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
            korak3text.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
            korak4text.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
            korak5text.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
            korak6text.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
            korak7text.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
            korak8text.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
            korak9text.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        }
        //Zumiranje teksta
        imZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSize++;
                textView.setTextSize(textSize);
                korak1text.setTextSize(textSize);
                korak2text.setTextSize(textSize);
                korak3text.setTextSize(textSize);
                korak4text.setTextSize(textSize);
                korak5text.setTextSize(textSize);
                korak6text.setTextSize(textSize);
                korak7text.setTextSize(textSize);
                korak8text.setTextSize(textSize);
                korak9text.setTextSize(textSize);


                /*textMjere.setTextSize(textSize);
                textMjere1.setTextSize(textSize);
                textMjere2.setTextSize(textSize);*/


            }



        });
        imZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSize--;
                textView.setTextSize(textSize);
                korak1text.setTextSize(textSize);
                korak2text.setTextSize(textSize);
                korak3text.setTextSize(textSize);
                korak4text.setTextSize(textSize);
                korak5text.setTextSize(textSize);
                korak6text.setTextSize(textSize);
                korak7text.setTextSize(textSize);
                korak8text.setTextSize(textSize);
                korak9text.setTextSize(textSize);



                /*textMjere.setTextSize(textSize);
                textMjere1.setTextSize(textSize);
                textMjere2.setTextSize(textSize);*/


            }
        });



        imMjere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* if (linearView4.getVisibility() == View.GONE) {
                    searchList.add("200");
                    otvoriMjere();
                }*/
                otvoriPod7();



            }
        });

        linearView1.setVisibility(View.VISIBLE);


        imHome=findViewById(R.id.imHome);
        imHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearView1.getVisibility() == View.GONE) {
                    searchList.add("000");
                    key=false;
                    otvoriHome();
                }
            }
        });
        searchLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              otvoriSearch();


            }
        });
        linearView3=findViewById(R.id.linearView3);

        podnaslovS1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("401");
                key=false;
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov1);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text1);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s1);

            }
        });
        podnaslovS2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("402");
                key=false;
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov2);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text2);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s2);

            }
        });
        podnaslovS3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("403");
                key=false;
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov3);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text3);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s3);

            }
        });
        podnaslovS4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("404");
                key=false;
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov4);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text4);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s4);


            }
        });
        podnaslovS5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("405");
                key=false;
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov5);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text5);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s5);

            }
        });
        podnaslovS6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("406");
                key=false;
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ff8a00"));
                naslovTeksta.setText(naslov6);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text6);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s6);


            }
        });
        podnaslovS7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("407");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov7);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text7);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s7);


            }
        });
        podnaslovS8.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("408");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov8);
                textView.setTextColor(Color.parseColor("#ff8a00"));
                textView.setText(text8);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s8);


            }
        });
       podnaslovS9.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("409");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov9);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text9);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s9);

            }
        });
        podnaslovS10.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("410");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov10);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text10);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s10);

            }
        });
        podnaslovS11.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("411");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov11);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text11);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s11);

            }
        });
        podnaslovS12.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("412");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov12);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text12);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s12);

            }
        });
        podnaslovS13.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("413");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov13);
                textView.setTextColor(Color.parseColor("#ff8a00"));
                textView.setText(text13);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s13);

            }
        });
        podnaslovS14.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("414");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov14);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text14);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s14);

            }
        });
        podnaslovS15.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("415");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov15);
                textView.setTextColor(Color.parseColor("#ff8a00"));
                textView.setText(text15);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s15);

            }
        });
        podnaslovS16.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("416");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov16);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text16);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s16);

            }
        });
        podnaslovS17.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("417");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov17);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text17);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s17);



            }
        });
        podnaslovS18.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("418");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov18);
                textView.setTextColor(Color.parseColor("#ff8a00"));
                textView.setText(text18);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s18);


            }
        });
        podnaslovS19.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("419");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov19);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text19);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s19);

            }
        });
        podnaslovS20.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("420");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov20);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text20);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s20);

            }
        });
        podnaslovS21.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("421");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov21);
                textView.setTextColor(Color.parseColor("#ff8a00"));
                textView.setText(text21);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s21);


            }
        });
        podnaslovS22.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("422");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov22);
                textView.setTextColor(Color.parseColor("#ff8a00"));
                textView.setText(text22);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s22);

            }
        });
        podnaslovS23.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("423");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov23);
                textView.setTextColor(Color.parseColor("#ff8a00"));
                textView.setText(text23);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s23);

            }
        });
        podnaslovS24.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("424");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov24);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text24);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s24);

            }
        });
        podnaslovS25.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("425");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov25);
                textView.setTextColor(Color.parseColor("#ff8a00"));
                textView.setText(text25);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s25);

            }
        });
        podnaslovS26.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("426");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov26);
                textView.setText(text26);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s26);

            }
        });
        podnaslovS27.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("27");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov27);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text27);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s27);

            }
        });
        podnaslovS28.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("428");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov28);
                textView.setTextColor(Color.parseColor("#ff8a00"));
                textView.setText(text28);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s28);


            }
        });
        podnaslovS29.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("429");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov29);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text29);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s29);

            }
        });
        podnaslovS30.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("430");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov30);
                textView.setTextColor(Color.parseColor("#ff8a00"));
                textView.setText(text30);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s30);


            }
        });
        podnaslovS31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("431");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ff8a00"));
                naslovTeksta.setText(naslov31);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text31);
                slika.setVisibility(View.GONE);


            }
        });

        podnaslovS33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("433");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov33);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text33);
                slika.setVisibility(View.GONE);


            }
        });
        podnaslovS34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("434");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov34);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text34);
                slika.setVisibility(View.GONE);


            }
        });
        podnaslovS35.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("435");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov35);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text35);
                slika.setVisibility(View.GONE);

            }
        });
        podnaslovS36.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("436");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov36);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text36);
                slika.setVisibility(View.GONE);



            }
        });
        podnaslovS37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("437");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov37);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text37);
                slika.setVisibility(View.GONE);


            }
        });
        podnaslovS38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("438");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov38);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text38);
                slika.setVisibility(View.GONE);


            }
        });

        podnaslovS39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("201");
                otvori1();

            }
        });
        podnaslovS40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("202");
                otvori2();

            }
        });
        podnaslovS41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("203");
                otvori3();

            }
        });

        podnaslovS42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("205");
                otvori5();

            }
        });
        podnaslovS43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("205");
                otvori5();

            }
        });
        podnaslovS44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("206");
                otvori6();

            }
        });
        podnaslovS45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("207");
                otvori7();

            }
        });
        podnaslovS46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("208");
                otvori8();

            }
        });
        podnaslovS47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("209");
                otvori9();

            }
        });
        podnaslovS48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("210");
                otvori10();

            }
        });
        podnaslovS49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("211");
                otvori11();

            }
        });
        podnaslovS50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("212");
                otvori12();

            }
        });
        podnaslovS51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("213");
                otvori13();

            }
        });
        podnaslovS52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("214");
                otvori14();

            }
        });
        podnaslovS53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("215");
                otvori15();

            }
        });
        podnaslovS54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("216");
                otvori16();

            }
        });
        podnaslovS55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("217");
                otvori17();

            }
        });
        podnaslovS56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("218");
                otvori18();

            }
        });
        podnaslovS57.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("219");
                otvori19();

            }
        });
        podnaslovS58.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("220");
                otvori20();

            }
        });
        podnaslovS59.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("221");
                otvori21();

            }
        });
        podnaslovS60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("222");
                otvori22();

            }
        });





        naslovG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otvoriPod();

            }
        });
        naslovG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otvoriPod2();

            }
        });
        naslovG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otvoriPod3();

            }
        });
        naslovG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otvoriPod4();

            }
        });
        naslovG5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otvoriPod5();

            }
        });
        naslovG6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otvoriPod6();

            }
        });
        naslovG7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otvoriPod7();

            }
        });


        naslovG8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otvoriPod8();

            }
        });


        podnaslov11.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("401");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov1);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text1);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s1);

            }
        });
        podnaslov12.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("402");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov2);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text2);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s2);


            }
        });
        podnaslov13.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("403");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov3);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text3);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s3);


            }
        });podnaslov14.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("404");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov4);
                textView.setText(text4);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s4);

            }
        });podnaslov15.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("405");
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                otvoriPrikaz();
                naslovTeksta.setText(naslov5);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text5);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s5);


            }
        });podnaslov16.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("406");
                naslovTeksta.setTextColor(Color.parseColor("#ff8a00"));
                otvoriPrikaz();
                naslovTeksta.setText(naslov6);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text6);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s6);


            }
        });
        podnaslov21.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("407");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov7);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text7);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s7);




            }
        });
        podnaslov22.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("408");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov8);
                textView.setTextColor(Color.parseColor("#ff8a00"));
                textView.setText(text8);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s8);

            }
        });
        podnaslov31.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("409");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov9);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text9);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s9);

            }
        });
        podnaslov32.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("410");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov10);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text10);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s10);

            }
        });
        podnaslov33.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("411");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov11);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text11);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(s11);

            }
        });
        podnaslov34.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("412");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov12);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text12);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s12);

            }
        });
        podnaslov35.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("413");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov13);
                textView.setTextColor(Color.parseColor("#ff8a00"));
                textView.setText(text13);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s13);


            }
        });
        podnaslov36.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("414");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov14);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text14);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s14);


            }
        });
        podnaslov37.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("415");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov15);
                textView.setTextColor(Color.parseColor("#ff8a00"));
                textView.setText(text15);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s15);


            }
        });
        podnaslov38.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("416");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov16);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text16);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s16);



            }
        });
        podnaslov39.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("417");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov17);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text17);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s17);

            }
        });
        podnaslov310.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("418");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov18);
                textView.setTextColor(Color.parseColor("#ff8a00"));
                textView.setText(text18);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s18);

            }
        });
        podnaslov41.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("419");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov19);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text19);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s19);

            }
        });
        podnaslov51.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("420");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov20);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text20);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s20);


            }
        });
        podnaslov52.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("421");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov21);
                textView.setTextColor(Color.parseColor("#ff8a00"));
                textView.setText(text21);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s21);


            }
        });
        podnaslov53.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("422");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov22);
                textView.setTextColor(Color.parseColor("#ff8a00"));
                textView.setText(text22);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s22);


            }
        });
        podnaslov54.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("423");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov23);
                textView.setTextColor(Color.parseColor("#ff8a00"));
                textView.setText(text23);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s23);


            }
        });
        podnaslov55.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("424");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov24);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text24);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s24);

            }
        });
        podnaslov56.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("425");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov25);
                textView.setTextColor(Color.parseColor("#ff8a00"));
                textView.setText(text25);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s25);


            }
        });
        podnaslov57.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("426");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov26);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text26);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s26);

            }
        });
        podnaslov58.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("427");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov27);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text27);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s27);

            }
        });
        podnaslov59.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("428");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov28);
                textView.setTextColor(Color.parseColor("#ff8a00"));
                textView.setText(text28);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s28);

            }
        });
        podnaslov61.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("429");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov29);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text29);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s29);

            }
        });
        podnaslov62.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("430");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov30);
                textView.setTextColor(Color.parseColor("#ff8a00"));
                textView.setText(text30);
                slika.setVisibility(View.VISIBLE);
                slika.setImageResource(raw.s30);

            }
        });
        podnaslov71.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("431");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ff8a00"));
                naslovTeksta.setText(naslov31);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text31);
                slika.setVisibility(View.GONE);


            }
        });
        podnaslov72.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("432");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ff8a00"));
                naslovTeksta.setText(naslov32);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text32);
                slika.setVisibility(View.GONE);


            }
        });
        podnaslov81.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("433");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov33);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text33);
                slika.setVisibility(View.GONE);


            }
        });
        podnaslov82.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("434");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov34);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text34);
                slika.setVisibility(View.GONE);


            }
        });
        podnaslov83.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("435");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov35);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text35);
                slika.setVisibility(View.GONE);


            }
        });
        podnaslov84.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                searchList.add("436");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov36);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text36);
                slika.setVisibility(View.GONE);


            }
        });
        podnaslov85.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("437");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov37);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text37);
                slika.setVisibility(View.GONE);


            }
        });
        podnaslov86.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList.add("438");
                otvoriPrikaz();
                naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
                naslovTeksta.setText(naslov38);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setText(text38);
                slika.setVisibility(View.GONE);


            }
        });



        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            textMjere1.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
            textMjere2.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);

        }*/


    }

    private void zatvorisve() {
        imopcija1.setImageResource(R.drawable.ic_down);
        imopcija2.setImageResource(R.drawable.ic_down);
        imopcija3.setImageResource(R.drawable.ic_down);
        imopcija4.setImageResource(R.drawable.ic_down);
        imopcija5.setImageResource(R.drawable.ic_down);
        imopcija6.setImageResource(R.drawable.ic_down);
        imopcija7.setImageResource(R.drawable.ic_down);
        imopcija8.setImageResource(R.drawable.ic_down);
        imopcija9.setImageResource(R.drawable.ic_down);
        korak1text.setVisibility(View.GONE);
        korak2text.setVisibility(View.GONE);
        korak3text.setVisibility(View.GONE);
        korak4text.setVisibility(View.GONE);
        korak5text.setVisibility(View.GONE);
        korak6text.setVisibility(View.GONE);
        korak7text.setVisibility(View.GONE);
        korak8text.setVisibility(View.GONE);
        korak9text.setVisibility(View.GONE);
    }
    private void sakriNaslove() {
        podnaslovSnema.setVisibility(View.GONE);
        podnaslovS1.setVisibility(View.GONE);
        podnaslovS2.setVisibility(View.GONE);
        podnaslovS3.setVisibility(View.GONE);
        podnaslovS4.setVisibility(View.GONE);
        podnaslovS5.setVisibility(View.GONE);
        podnaslovS6.setVisibility(View.GONE);
        podnaslovS7.setVisibility(View.GONE);
        podnaslovS8.setVisibility(View.GONE);
        podnaslovS9.setVisibility(View.GONE);
        podnaslovS11.setVisibility(View.GONE);
        podnaslovS10.setVisibility(View.GONE);
        podnaslovS11.setVisibility(View.GONE);
        podnaslovS12.setVisibility(View.GONE);
        podnaslovS13.setVisibility(View.GONE);
        podnaslovS14.setVisibility(View.GONE);
        podnaslovS15.setVisibility(View.GONE);
        podnaslovS16.setVisibility(View.GONE);
        podnaslovS17.setVisibility(View.GONE);
        podnaslovS18.setVisibility(View.GONE);
        podnaslovS19.setVisibility(View.GONE);
        podnaslovS20.setVisibility(View.GONE);
        podnaslovS21.setVisibility(View.GONE);
        podnaslovS22.setVisibility(View.GONE);
        podnaslovS23.setVisibility(View.GONE);
        podnaslovS24.setVisibility(View.GONE);
        podnaslovS25.setVisibility(View.GONE);
        podnaslovS26.setVisibility(View.GONE);
        podnaslovS27.setVisibility(View.GONE);
        podnaslovS28.setVisibility(View.GONE);
        podnaslovS29.setVisibility(View.GONE);
        podnaslovS30.setVisibility(View.GONE);
        podnaslovS31.setVisibility(View.GONE);
        podnaslovS32.setVisibility(View.GONE);
        podnaslovS33.setVisibility(View.GONE);
        podnaslovS34.setVisibility(View.GONE);
        podnaslovS35.setVisibility(View.GONE);
        podnaslovS36.setVisibility(View.GONE);
        podnaslovS37.setVisibility(View.GONE);
        podnaslovS38.setVisibility(View.GONE);
        podnaslovS39.setVisibility(View.GONE);
        podnaslovS40.setVisibility(View.GONE);
        podnaslovS41.setVisibility(View.GONE);
        podnaslovS42.setVisibility(View.GONE);
        podnaslovS43.setVisibility(View.GONE);
        podnaslovS44.setVisibility(View.GONE);
        podnaslovS45.setVisibility(View.GONE);
        podnaslovS46.setVisibility(View.GONE);
        podnaslovS47.setVisibility(View.GONE);
        podnaslovS48.setVisibility(View.GONE);
        podnaslovS49.setVisibility(View.GONE);
        podnaslovS50.setVisibility(View.GONE);
        podnaslovS51.setVisibility(View.GONE);
        podnaslovS52.setVisibility(View.GONE);
        podnaslovS53.setVisibility(View.GONE);
        podnaslovS54.setVisibility(View.GONE);
        podnaslovS55.setVisibility(View.GONE);
        podnaslovS56.setVisibility(View.GONE);
        podnaslovS57.setVisibility(View.GONE);
        podnaslovS58.setVisibility(View.GONE);
        podnaslovS59.setVisibility(View.GONE);
        podnaslovS60.setVisibility(View.GONE);
    }
    private void otvoriPrikaz() {
        close();
        linearView3.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }

    private void otvoriPod() {
        searchList.add("301");
        close();
        linearView21.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }
    private void otvoriPod2() {
        searchList.add("302");
        close();
        linearView22.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }
    private void otvoriPod3() {
        searchList.add("303");
        close();
        linearView23.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }
    private void otvoriPod4() {
        searchList.add("304");
        close();
        linearView24.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }
    private void otvoriPod5() {
        searchList.add("305");
        close();
        linearView25.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }
    private void otvoriPod6() {
        searchList.add("306");
        close();
        linearView26.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }
    private void otvoriPod7() {
        searchList.add("307");
        close();
        linearView27.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }
    private void otvoriPod8() {
        searchList.add("308");
        close();
        linearView28.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }



    private void otvoriSearch() {

        if (naslovApp.getVisibility() == View.VISIBLE) {
            podnaslovSnema.setVisibility(View.GONE);
            searchList.add("100");

            sakriNaslove();
            close();
            linearView5.setVisibility(View.VISIBLE);
            searcher.setVisibility(View.VISIBLE);
            searcher.setText("");
            searcher.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT  , 0);

        }else{

           trazi();
        }
    }
    private void trazi() {
        uzorak=searcher.getText().toString().toLowerCase();
        if (!uzorak.equals("")){
            searchList.add(uzorak);
            searchList.add("101");
            sakriNaslove();
            naslovApp.setVisibility(View.GONE);
            searchCounter=0;
            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.HIDE_NOT_ALWAYS, 0);
            if((text1b.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov1.toLowerCase().contains(uzorak.toLowerCase())) ||(text1A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS1.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text2b.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov2.toLowerCase().contains(uzorak.toLowerCase())) ||(text2A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS2.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text3.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov3.toLowerCase().contains(uzorak.toLowerCase())) ||(text3A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS3.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text4.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov4.toLowerCase().contains(uzorak.toLowerCase())) ||(text4A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS4.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text5.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov5.toLowerCase().contains(uzorak.toLowerCase())) ||(text5A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS5.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text6.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov6.toLowerCase().contains(uzorak.toLowerCase())) ||(text6A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS6.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text7.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov7.toLowerCase().contains(uzorak.toLowerCase())) ||(text7A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS7.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text8.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov8.toLowerCase().contains(uzorak.toLowerCase())) ||(text8A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS8.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text9.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov9.toLowerCase().contains(uzorak.toLowerCase())) ||(text9A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS9.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text10.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov10.toLowerCase().contains(uzorak.toLowerCase())) ||(text10A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS10.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text11.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov11.toLowerCase().contains(uzorak.toLowerCase())) ||(text11A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS11.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text12.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov12.toLowerCase().contains(uzorak.toLowerCase())) ||(text12A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS12.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text13.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov13.toLowerCase().contains(uzorak.toLowerCase())) ||(text13A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS13.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text14.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov14.toLowerCase().contains(uzorak.toLowerCase())) ||(text14A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS14.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text15.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov15.toLowerCase().contains(uzorak.toLowerCase())) ||(text15A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS15.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text16.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov16.toLowerCase().contains(uzorak.toLowerCase())) ||(text16A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS16.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text17.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov17.toLowerCase().contains(uzorak.toLowerCase())) ||(text17A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS17.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text18.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov18.toLowerCase().contains(uzorak.toLowerCase())) ||(text18A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS18.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text19.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov19.toLowerCase().contains(uzorak.toLowerCase())) ||(text19A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS19.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text20.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov20.toLowerCase().contains(uzorak.toLowerCase())) ||(text20A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS20.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text21.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov21.toLowerCase().contains(uzorak.toLowerCase())) ||(text21A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS21.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text22.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov22.toLowerCase().contains(uzorak.toLowerCase())) ||(text22A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS22.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text23.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov23.toLowerCase().contains(uzorak.toLowerCase())) ||(text23A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS23.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text24.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov24.toLowerCase().contains(uzorak.toLowerCase())) ||(text24A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS24.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text25.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov25.toLowerCase().contains(uzorak.toLowerCase())) ||(text25A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS25.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text26.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov26.toLowerCase().contains(uzorak.toLowerCase())) ||(text26A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS26.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text27.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov27.toLowerCase().contains(uzorak.toLowerCase())) ||(text27A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS27.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text28.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov28.toLowerCase().contains(uzorak.toLowerCase())) ||(text28A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS28.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text29.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov29.toLowerCase().contains(uzorak.toLowerCase())) ||(text29A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS29.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text30.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov30.toLowerCase().contains(uzorak.toLowerCase())) ||(text30A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS30.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text31b.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov31.toLowerCase().contains(uzorak.toLowerCase())) ||(text31A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS31.setVisibility(View.VISIBLE);
                searchCounter++;
            }

            if((text33b.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov33.toLowerCase().contains(uzorak.toLowerCase())) ||(text33A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS33.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text34b.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov34.toLowerCase().contains(uzorak.toLowerCase())) ||(text34A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS34.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text35b.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov35.toLowerCase().contains(uzorak.toLowerCase())) ||(text35A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS35.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text36b.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov36.toLowerCase().contains(uzorak.toLowerCase())) ||(text36A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS36.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text37.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov37.toLowerCase().contains(uzorak.toLowerCase())) ||(text37A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS37.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((text38.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov38.toLowerCase().contains(uzorak.toLowerCase())) ||(text38A.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS38.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m1.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS39.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m1.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS39.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m2.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS40.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m3.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS41.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m4.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS42.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m5.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS43.setVisibility(View.VISIBLE);
                searchCounter++;

            }
            if((m6.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS44.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m7.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS45.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m8.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS46.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m9.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS47.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m10.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS48.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m11.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS49.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m12.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS50.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m13.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS51.setVisibility(View.VISIBLE);
                searchCounter++;
            }

            if((m14.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS52.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m15.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS53.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m16.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS54.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m17.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS55.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m18.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS56.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m19.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS57.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m20.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS58.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m21.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS59.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if((m22.toLowerCase().contains(uzorak.toLowerCase()))){
                podnaslovS60.setVisibility(View.VISIBLE);
                searchCounter++;
            }
            if(searchCounter<1){
                podnaslovSnema.setVisibility(View.VISIBLE);
            }
            else {
                podnaslovSnema.setVisibility(View.GONE);
            }

        }else {
            AlertDialog alertDialog = new AlertDialog.Builder(HomeActivity.this).create();
            alertDialog.setMessage("Unesite pojam za pretragu!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Uredu",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
}
    public void otvori1() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        korak5.setVisibility(View.VISIBLE);
        naslovMjere.setText("FIZIČKO NASILJE NA BM / UGROŽENA SIGURNOST");
        opcija1.setText("KORAK 1 - Zaštitite se");
        korak1text.setText(texto1);
        opcija2.setText("KORAK 2 - Pozovite policiju");
        korak2text.setText(texto2);
        opcija3.setText("KORAK 3 - Prijavite nepravilnost nadležnom koordinatoru");
        korak3text.setText(texto3);
        opcija4.setText("KORAK 4 - Unesite primjedbu u zapisnik o radu B0");
        korak4text.setText(texto4);
        opcija5.setText("KORAK 5 - Dokumentujte ");
        korak5text.setText(texto5);
        zatvoritekst();
    }
    public void otvori2() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);



        naslovMjere.setText("ZABRANA POSMATRANJA ILI USKRAĆIVANJE PRAVA POSMATRAČA");
        opcija1.setText("KORAK 1 - Upozorite predsjednika BO");
        korak1text.setText(texto6);
        opcija2.setText("KORAK 2 - Prijavite nepravilnost nadležnom koordinatoru");
        korak2text.setText(texto3);
        opcija3.setText("KORAK 3 - Kontaktirajte Opštinsku/Gradsku izbornu komisiju");
        korak3text.setText(texto7);
        zatvoritekst();
    }

    public void otvori3() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        korak5.setVisibility(View.VISIBLE);
        naslovMjere.setText("BUGARSKI VOZ (KRUŽNO GLASANJU)");
        opcija1.setText("KORAK 1 - Upozorite predsjednika BO");
        korak1text.setText(texto6);
        opcija2.setText("KORAK 2 - Prijavite nepravilnost nadležnom koordinatoru");
        korak2text.setText(texto3);
        opcija3.setText("KORAK 3 - Unesite primjedbu u Zapisnik o radu BO");
        korak3text.setText(texto4);
        opcija4.setText("KORAK 4 - Kontaktirajte Opštinsku/Gradsku izbornu komisiju");
        korak4text.setText(texto7);
        opcija5.setText("KORAK 5 - Dokumentujte nepravilnost/kršenje");
        korak5text.setText(texto5);
        zatvoritekst();
    }
    public void otvori4() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        naslovMjere.setText("KUPOVINA GLASOVA");
        opcija1.setText("KORAK 1 - Prijavite nepravilnost nadležnom koordinatoru");
        korak1text.setText(texto3);
        opcija2.setText("KORAK 2 - Kontaktirajte Opštinsku/Gradsku izbornu komisiju");
        korak2text.setText(texto7);
        opcija3.setText("KORAK 3 - Dokumentujte nepravilnost/kršenje");
        korak3text.setText(texto5);
        opcija4.setText("KORAK 4 - Pozovite policiju");
        korak4text.setText(texto2);

        zatvoritekst();
    }
    public void otvori5() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        korak5.setVisibility(View.VISIBLE);
        naslovMjere.setText("PRITISCI NA BIRAČE I ZASTRAŠIVANJE");
        opcija1.setText("KORAK 1 - Upozorite predsjednika BO");
        korak1text.setText(texto6);
        opcija2.setText("KORAK 2 - Prijavite nepravilnost nadležnom koordinatoru");
        korak2text.setText(texto3);
        opcija3.setText("KORAK 3 - Kontaktirajte Opštinsku/Gradsku izbornu komisiju");
        korak3text.setText(texto7);
        opcija4.setText("KORAK 4 - Dokumentujte nepravilnost/kršenje");
        korak4text.setText(texto5);
        opcija5.setText("KORAK 5 - Pozovite policiju");
        korak5text.setText(texto2);

        zatvoritekst();
    }
    public void otvori6() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        korak5.setVisibility(View.VISIBLE);

        naslovMjere.setText("KRŠENJE IZBORNE ŠUTNJE");
        opcija1.setText("KORAK 1 - Upozorite predsjednika BO");
        opcija1.setText("KORAK 1 - Upozorite predsjednika BO");
        korak1text.setText(texto6);
        opcija2.setText("KORAK 2 - Prijavite nepravilnost nadležnom koordinatoru");
        korak2text.setText(texto3);
        opcija3.setText("KORAK 3 - Unesite primjedbu u Zapisnik o radu BO");
        korak3text.setText(texto4);
        opcija4.setText("KORAK 4 - Kontaktirajte Opštinsku/Gradsku izbornu komisiju");
        korak4text.setText(texto7);
        opcija5.setText("KORAK 5 - Dokumentujte nepravilnost/kršenje");
        korak5text.setText(texto5);

        zatvoritekst();
    }
    public void otvori7() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        korak5.setVisibility(View.VISIBLE);

        naslovMjere.setText("PORODIČNO GLASANJU");
        opcija1.setText("KORAK 1 - Upozorite predsjednika BO");
        korak1text.setText(texto6);
        opcija2.setText("KORAK 2 - Prijavite nepravilnost nadležnom koordinatoru");
        korak2text.setText(texto3);
        opcija3.setText("KORAK 3 - Unesite primjedbu u Zapisnik o radu BO");
        korak3text.setText(texto4);
        opcija4.setText("KORAK 4 - Kontaktirajte Opštinsku/Gradsku izbornu komisiju");
        korak4text.setText(texto7);
        opcija5.setText("KORAK 5 - Dokumentujte nepravilnost/kršenje");
        korak5text.setText(texto5);
        zatvoritekst();
    }
    public void otvori8() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        korak5.setVisibility(View.VISIBLE);

        naslovMjere.setText("ZLOUPOTREBA POMOĆI PRI GLASANJU");
        opcija1.setText("KORAK 1 - Upozorite predsjednika BO");
        korak1text.setText(texto6);
        opcija2.setText("KORAK 2 - Prijavite nepravilnost nadležnom koordinatoru");
        korak2text.setText(texto3);
        opcija3.setText("KORAK 3 - Unesite primjedbu u Zapisnik o radu BO");
        korak3text.setText(texto4);
        opcija4.setText("KORAK 4 - Kontaktirajte Opštinsku/Gradsku izbornu komisiju");
        korak4text.setText(texto7);
        opcija5.setText("KORAK 5 - Dokumentujte nepravilnost/kršenje");
        korak5text.setText(texto5);

        zatvoritekst();
    }
    public void otvori9() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        korak5.setVisibility(View.VISIBLE);
        korak6.setVisibility(View.VISIBLE);
        naslovMjere.setText("NISU ISTAKNUTI REZULTATI IZBORA (ŽUTE KOPIJE)");
        opcija1.setText("KORAK 1 - Upozorite predsjednika BO");
        korak1text.setText(texto6);
        opcija2.setText("KORAK 2 - Tražite kopiju rezultata glasanja (žutu kopiju)");
        korak2text.setText(texto9);
        opcija3.setText("KORAK 3 - Prijavite nepravilnost nadležnom koordinatoru");
        korak3text.setText(texto3);
        opcija4.setText("KORAK 4 - Unesite primjedbu u Zapisnik o radu BO");
        korak4text.setText(texto4);
        opcija5.setText("KORAK 5 - Kontaktirajte Opštinsku/Gradsku izbornu komisiju");
        korak5text.setText(texto7);
        opcija6.setText("KORAK 6 - Dokumentujte nepravilnost/kršenje");
        korak6text.setText(texto5);

        zatvoritekst();
    }
    public void otvori10() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        korak5.setVisibility(View.VISIBLE);
        naslovMjere.setText("KAŠNJENJE U OTVARANJU BM PREKO 3 SATA");
        opcija1.setText("KORAK 1 - Upozorite predsjednika BO");
        korak1text.setText(texto6);
        opcija2.setText("KORAK 2 - Prijavite nepravilnost nadležnom koordinatoru");
        korak2text.setText(texto3);
        opcija3.setText("KORAK 3 - Unesite primjedbu u Zapisnik o radu BO");
        korak3text.setText(texto4);
        opcija4.setText("KORAK 4 - Kontaktirajte Opštinsku/Gradsku izbornu komisiju");
        korak4text.setText(texto7);
        opcija5.setText("KORAK 5 - Dokumentujte nepravilnost/kršenje");
        korak5text.setText(texto5);
        zatvoritekst();
    }
    @SuppressLint("SetTextI18n")
    public void otvori11() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        korak5.setVisibility(View.VISIBLE);
        naslovMjere.setText("ODSUSTVO ČLANOVA BO");
        opcija1.setText("KORAK 1 - Upozorite predsjednika BO");
        korak1text.setText(texto6);
        opcija2.setText("KORAK 2 - Prijavite nepravilnost nadležnom koordinatoru");
        korak2text.setText(texto3);
        opcija3.setText("KORAK 3 - Unesite primjedbu u Zapisnik o radu BO");
        korak3text.setText(texto4);
        opcija4.setText("KORAK 4 - Kontaktirajte Opštinsku/Gradsku izbornu komisiju");
        korak4text.setText(texto7);
        opcija5.setText("KORAK 5 - Dokumentujte nepravilnost/kršenje");
        korak5text.setText(texto5);

        zatvoritekst();
    }
    public void otvori12() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        naslovMjere.setText("NEDOSTATAK ILI NESTANAK IZBORNOG MATERIJALA");
        opcija1.setText("KORAK 1 - Prijavite nepravilnost nadležnom koordinatoru");
        korak1text.setText(texto3);
        opcija2.setText("KORAK 2 - Unesite primjedbu u Zapisnik o radu BO");
        korak2text.setText(texto4);
        opcija3.setText("KORAK 3 - Kontaktirajte Opštinsku/Gradsku izbornu komisiju");
        korak3text.setText(texto7);
        opcija4.setText("KORAK 4 - Dokumentujte nepravilnost/kršenje");
        korak4text.setText(texto5);


        zatvoritekst();
    }
    public void otvori13() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        korak5.setVisibility(View.VISIBLE);
        naslovMjere.setText("NARUŠENA TAJNOST GLASANJU");
        opcija1.setText("KORAK 1 - Upozorite predsjednika BO");
        korak1text.setText(texto6);
        opcija2.setText("KORAK 2 - Prijavite nepravilnost nadležnom koordinatoru");
        korak2text.setText(texto3);
        opcija3.setText("KORAK 3 - Unesite primjedbu u Zapisnik o radu BO");
        korak3text.setText(texto4);
        opcija4.setText("KORAK 4 - Kontaktirajte Opštinsku/Gradsku izbornu komisiju");
        korak4text.setText(texto7);
        opcija5.setText("KORAK 5 - Dokumentujte nepravilnost/kršenje");
        korak5text.setText(texto5);
        zatvoritekst();
    }
    public void otvori14() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        korak5.setVisibility(View.VISIBLE);
        naslovMjere.setText("MANIPULACIJE PRI IDENTIFIKACIJI BIRAČA");
        opcija1.setText("KORAK 1 - Upozorite predsjednika BO");
        korak1text.setText(texto6);
        opcija2.setText("KORAK 2 - Prijavite nepravilnost nadležnom koordinatoru");
        korak2text.setText(texto3);
        opcija3.setText("KORAK 3 - Unesite primjedbu u Zapisnik o radu BO");
        korak3text.setText(texto4);
        opcija4.setText("KORAK 4 - Kontaktirajte Opštinsku/Gradsku izbornu komisiju");
        korak4text.setText(texto7);
        opcija5.setText("KORAK 5 - Dokumentujte nepravilnost/kršenje");
        korak5text.setText(texto5);

        zatvoritekst();
    }
    public void otvori15() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        korak5.setVisibility(View.VISIBLE);
        naslovMjere.setText("MANIPULACIJE PRI IZDAVANJU GLASAČKIH LISTIĆA");
        opcija1.setText("KORAK 1 - Upozorite predsjednika BO");
        korak1text.setText(texto6);
        opcija2.setText("KORAK 2 - Prijavite nepravilnost nadležnom koordinatoru");
        korak2text.setText(texto3);
        opcija3.setText("KORAK 3 - Unesite primjedbu u Zapisnik o radu BO");
        korak3text.setText(texto4);
        opcija4.setText("KORAK 4 - Kontaktirajte Opštinsku/Gradsku izbornu komisiju");
        korak4text.setText(texto7);
        opcija5.setText("KORAK 5 - Dokumentujte nepravilnost/kršenje");
        korak5text.setText(texto5);

        zatvoritekst();
    }
    public void otvori16() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        korak5.setVisibility(View.VISIBLE);
        naslovMjere.setText("USKRAĆIVANJE PRAVA NA GLASANJE");
        opcija1.setText("KORAK 1 - Upozorite predsjednika BO");
        korak1text.setText(texto6);
        opcija2.setText("KORAK 2 - Prijavite nepravilnost nadležnom koordinatoru");
        korak2text.setText(texto3);
        opcija3.setText("KORAK 3 - Unesite primjedbu u Zapisnik o radu BO");
        korak3text.setText(texto4);
        opcija4.setText("KORAK 4 - Kontaktirajte Opštinsku/Gradsku izbornu komisiju");
        korak4text.setText(texto7);
        opcija5.setText("KORAK 5 - Dokumentujte nepravilnost/kršenje");
        korak5text.setText(texto5);

        zatvoritekst();
    }
    public void otvori17() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        korak5.setVisibility(View.VISIBLE);
        korak6.setVisibility(View.VISIBLE);

        naslovMjere.setText("NESLAGANJA U TESTU TAČNOSTI");
        opcija1.setText("KORAK 1 - Upozorite predsjednika BO");
        korak1text.setText(texto6);
        opcija2.setText("KORAK 2 - Prijavite nepravilnost nadležnom koordinatoru");
        korak2text.setText(texto3);
        opcija3.setText("KORAK 3 - Unesite primjedbu u Zapisnik o radu BO");
        korak3text.setText(texto4);
        opcija4.setText("KORAK 4 - Dokumentujte nepravilnost/kršenje");
        korak4text.setText(texto5);
        opcija5.setText("KORAK 5 - Tražite kopiju rezultata glasanja (žutu kopiju)");
        korak5text.setText(texto9);
        opcija6.setText("KORAK 6 - Zatražite od CIK-a BiH ponovno brojanje glasova");
        korak6text.setText(texto8);

        zatvoritekst();
    }
    public void otvori18() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        korak5.setVisibility(View.VISIBLE);
        korak6.setVisibility(View.VISIBLE);
        korak7.setVisibility(View.VISIBLE);
        korak8.setVisibility(View.VISIBLE);

        naslovMjere.setText("ZLOUPOTREBE GLASAČKIH LISTIĆA PRI BROJANJU");
        opcija1.setText("KORAK 1 - Upozorite predsjednika BO");
        korak1text.setText(texto6);
        opcija2.setText("KORAK 2 - Prijavite nepravilnost nadležnom koordinatoru");
        korak2text.setText(texto3);
        opcija3.setText("KORAK 3 - Unesite primjedbu u Zapisnik o radu BO");
        korak3text.setText(texto4);
        opcija4.setText("KORAK 4 - Dokumentujte nepravilnost/kršenje");
        korak4text.setText(texto5);
        opcija5.setText("KORAK 5 - Tražite kopiju rezultata glasanja (žutu kopiju)");
        korak5text.setText(texto9);
        opcija6.setText("KORAK 6 - Kontaktirajte Opštinsku/Gradsku izbornu komisiju");
        korak6text.setText(texto7);
        opcija7.setText("KORAK 7 - Pozovite policiju");
        korak7text.setText(texto2);
        opcija8.setText("KORAK 8 - Zatražite od CIK-a BiH ponovno brojanje glasova");
        korak8text.setText(texto8);

        zatvoritekst();
    }
    public void otvori19() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        korak5.setVisibility(View.VISIBLE);
        korak6.setVisibility(View.VISIBLE);
        korak7.setVisibility(View.VISIBLE);
        korak8.setVisibility(View.VISIBLE);

        naslovMjere.setText("NAMJERNO PONIŠTAVANJE GLASOVA");
        opcija1.setText("KORAK 1 - Upozorite predsjednika BO");
        korak1text.setText(texto6);
        opcija2.setText("KORAK 2 - Prijavite nepravilnost nadležnom koordinatoru");
        korak2text.setText(texto3);
        opcija3.setText("KORAK 3 - Unesite primjedbu u Zapisnik o radu BO");
        korak3text.setText(texto4);
        opcija4.setText("KORAK 4 - Dokumentujte nepravilnost/kršenje");
        korak4text.setText(texto5);
        opcija5.setText("KORAK 5 - Tražite kopiju rezultata glasanja (žutu kopiju)");
        korak5text.setText(texto9);
        opcija6.setText("KORAK 6 - Kontaktirajte Opštinsku/Gradsku izbornu komisiju");
        korak6text.setText(texto7);
        opcija7.setText("KORAK 7 - Pozovite policiju");
        korak7text.setText(texto2);
        opcija8.setText("KORAK 8 - Zatražite od CIK-a BiH ponovno brojanje glasova");
        korak8text.setText(texto8);

        zatvoritekst();
    }
    public void otvori20() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        korak5.setVisibility(View.VISIBLE);
        korak6.setVisibility(View.VISIBLE);
        korak7.setVisibility(View.VISIBLE);
        korak8.setVisibility(View.VISIBLE);

        naslovMjere.setText("NEDOZVOLJENO DOPISIVANJE GLASOVA");
        opcija1.setText("KORAK 1 - Upozorite predsjednika BO");
        korak1text.setText(texto6);
        opcija2.setText("KORAK 2 - Prijavite nepravilnost nadležnom koordinatoru");
        korak2text.setText(texto3);
        opcija3.setText("KORAK 3 - Unesite primjedbu u Zapisnik o radu BO");
        korak3text.setText(texto4);
        opcija4.setText("KORAK 4 - Dokumentujte nepravilnost/kršenje");
        korak4text.setText(texto5);
        opcija5.setText("KORAK 5 - Tražite kopiju rezultata glasanja (žutu kopiju)");
        korak5text.setText(texto9);
        opcija6.setText("KORAK 6 - Kontaktirajte Opštinsku/Gradsku izbornu komisiju");
        korak6text.setText(texto7);
        opcija7.setText("KORAK 7 - Pozovite policiju");
        korak7text.setText(texto2);
        opcija8.setText("KORAK 8 - Zatražite od CIK-a BiH ponovno brojanje glasova");
        korak8text.setText(texto8);

        zatvoritekst();
    }
    public void otvori21() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        korak5.setVisibility(View.VISIBLE);
        korak6.setVisibility(View.VISIBLE);
        korak7.setVisibility(View.VISIBLE);

        naslovMjere.setText("POGREŠNO EVIDENTIRANJE REZULTATA GLASANJU NA BM");
        opcija1.setText("KORAK 1 - Upozorite predsjednika BO");
        korak1text.setText(texto6);
        opcija2.setText("KORAK 2 - Prijavite nepravilnost nadležnom koordinatoru");
        korak2text.setText(texto3);
        opcija3.setText("KORAK 3 - Unesite primjedbu u Zapisnik o radu BO");
        korak3text.setText(texto4);
        opcija4.setText("KORAK 4 - Dokumentujte nepravilnost/kršenje");
        korak4text.setText(texto5);
        opcija5.setText("KORAK 5 - Tražite kopiju rezultata glasanja (žutu kopiju)");
        korak5text.setText(texto9);
        opcija6.setText("KORAK 6 - Kontaktirajte Opštinsku/Gradsku izbornu komisiju");
        korak6text.setText(texto7);
        opcija7.setText("KORAK 7 - Zatražite od CIK-a BiH ponovno brojanje glasova");
        korak7text.setText(texto8);

        zatvoritekst();
    }
    public void otvori22() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
        ZatvoriMjere();
        korak1.setVisibility(View.VISIBLE);
        korak2.setVisibility(View.VISIBLE);
        korak3.setVisibility(View.VISIBLE);
        korak4.setVisibility(View.VISIBLE);
        korak5.setVisibility(View.VISIBLE);
        korak6.setVisibility(View.VISIBLE);
        korak7.setVisibility(View.VISIBLE);

        naslovMjere.setText("OTVARANJE VREĆA SA IZBORNIM MATERIJLAOM TOKOM TRANSPORTA");
        opcija1.setText("KORAK 1 - Upozorite predsjednika BO");
        korak1text.setText(texto6);
        opcija2.setText("KORAK 2 - Prijavite nepravilnost nadležnom koordinatoru");
        korak2text.setText(texto3);
        opcija3.setText("KORAK 3 - Unesite primjedbu u Zapisnik o radu BO");
        korak3text.setText(texto4);
        opcija4.setText("KORAK 4 - Dokumentujte nepravilnost/kršenje");
        korak4text.setText(texto5);
        opcija5.setText("KORAK 5 - Tražite kopiju rezultata glasanja (žutu kopiju)");
        korak5text.setText(texto9);
        opcija6.setText("KORAK 6 - Kontaktirajte Opštinsku/Gradsku izbornu komisiju");
        korak6text.setText(texto7);
        opcija7.setText("KORAK 7 - Zatražite od CIK-a BiH ponovno brojanje glasova");
        korak7text.setText(texto8);

        zatvoritekst();
    }


    private void zatvoritekst() {
        korak1text.setVisibility(View.GONE);
        korak2text.setVisibility(View.GONE);
        korak3text.setVisibility(View.GONE);
        korak4text.setVisibility(View.GONE);
        korak5text.setVisibility(View.GONE);
        korak6text.setVisibility(View.GONE);
        korak7text.setVisibility(View.GONE);
        korak8text.setVisibility(View.GONE);
        korak9text.setVisibility(View.GONE);
    }


    private void ZatvoriMjere() {
        korak1.setVisibility(View.GONE);
        korak2.setVisibility(View.GONE);
        korak3.setVisibility(View.GONE);
        korak4.setVisibility(View.GONE);
        korak5.setVisibility(View.GONE);
        korak6.setVisibility(View.GONE);
        korak7.setVisibility(View.GONE);
        korak8.setVisibility(View.GONE);
        korak9.setVisibility(View.GONE);

    }


    private void otvoriHome() {

       close();
       linearView1.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }
    private void otvoriPrikazB() {
        close();
        linearView3.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }

    private void otvoriPodB() {

        close();
        linearView21.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }
    private void otvoriPodB2() {

        close();
        linearView22.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }
    private void otvoriPodB3() {

        close();
        linearView23.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }
    private void otvoriPodB4() {

        close();
        linearView24.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }
    private void otvoriPodB5() {

        close();
        linearView25.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }
    private void otvoriPodB6() {

        close();
        linearView26.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }
    private void otvoriPodB7() {

        close();
        linearView27.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }
    private void otvoriPodB8() {

        close();
        linearView28.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }

    private void otvoriSearchB() {

        close();
        sakriNaslove();
        trazib();
        linearView5.setVisibility(View.VISIBLE);
        searcher.setVisibility(View.VISIBLE);
        searcher.requestFocus();

    }
    private void otvoriSearchBS() {

        sakriNaslove();
        close();
        linearView5.setVisibility(View.VISIBLE);
        searcher.setVisibility(View.VISIBLE);
        searcher.setText("");
        searcher.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT  , 0);

    }

    private void otvoriMjereB() {

        close();
        linearView4.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }

    private void otvoriHomeB() {

        close();
        linearView1.setVisibility(View.VISIBLE);
        naslovApp.setVisibility(View.VISIBLE);
    }
    private void backPressed() {


        length=searchList.size();
        length--;
        backStackPatern=searchList.get(length).toString();

        if (backStackPatern.equals("101"))
        {
            brisi=length-1;

        searchList.remove(brisi);
        searchList.remove(brisi);
        length--;
            length--;
            backStackPatern=searchList.get(length).toString();

        } else
        {
            brisi=length-1;
            backStackPatern=searchList.get(brisi).toString();
            searchList.remove(length);

        }
        if (backStackPatern.equals("000")) {
            otvoriHomeB();
        }

        if (backStackPatern.equals("100")) {
            otvoriSearchBS();
        }
        if (backStackPatern.equals("101")) {
            length=searchList.size();
            length--;
            length--;
            uzorak=searchList.get(length).toString();
            searcher.setText(uzorak);
            otvoriSearchB();

        }
        if (backStackPatern.equals("201")) {
            otvori1();

        }
        if (backStackPatern.equals("202")) {
            otvori2();

        }
        if (backStackPatern.equals("203")) {
            otvori3();

        }
        if (backStackPatern.equals("204")) {
            otvori4();

        }
        if (backStackPatern.equals("205")) {
            otvori5();

        }
        if (backStackPatern.equals("206")) {
            otvori6();

        }
        if (backStackPatern.equals("207")) {
            otvori7();

        }
        if (backStackPatern.equals("208")) {
            otvori8();

        }
        if (backStackPatern.equals("209")) {
            otvori9();

        }
        if (backStackPatern.equals("210")) {
            otvori10();

        }
        if (backStackPatern.equals("211")) {
            otvori11();

        }
        if (backStackPatern.equals("212")) {
            otvori12();

        }
        if (backStackPatern.equals("213")) {
            otvori13();

        }
        if (backStackPatern.equals("214")) {
            otvori14();

        }
        if (backStackPatern.equals("215")) {
            otvori15();

        }
        if (backStackPatern.equals("216")) {
            otvori16();

        }
        if (backStackPatern.equals("217")) {
            otvori17();

        }
        if (backStackPatern.equals("218")) {
            otvori18();

        }
        if (backStackPatern.equals("219")) {
            otvori19();

        }
        if (backStackPatern.equals("220")) {
            otvori20();

        }
        if (backStackPatern.equals("221")) {
            otvori21();

        }
        if (backStackPatern.equals("222")) {
            otvori22();

        }


        if (backStackPatern.equals("301")) {
            otvoriPodB();

        }
        if (backStackPatern.equals("302")) {
            otvoriPodB2();

        }
        if (backStackPatern.equals("303")) {
            otvoriPodB3();

        }
        if (backStackPatern.equals("304")) {
            otvoriPodB4();

        }
        if (backStackPatern.equals("305")) {
            otvoriPodB5();

        }
        if (backStackPatern.equals("306")) {
            otvoriPodB6();

        }
        if (backStackPatern.equals("307")) {
            otvoriPodB7();

        }
        if (backStackPatern.equals("308")) {
            otvoriPodB8();

        }
        if (backStackPatern.equals("401")) {
            otvoriPrikazB();
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            naslovTeksta.setText(naslov1);
            textView.setText(text1);
        }
        if (backStackPatern.equals("402")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov2);
            textView.setText(text2);
        }
        if (backStackPatern.equals("403")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov3);
            textView.setText(text3);
        }
        if (backStackPatern.equals("404")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov4);
            textView.setText(text4);
        }
        if (backStackPatern.equals("405")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov5);
            textView.setText(text5);
        } if (backStackPatern.equals("406")) {
            naslovTeksta.setTextColor(Color.parseColor("#ff8a00"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov6);
            textView.setText(text6);
        }
        if (backStackPatern.equals("407")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov7);
            textView.setText(text7);
        }
        if (backStackPatern.equals("408")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov8);
            textView.setText(text8);
        }
        if (backStackPatern.equals("409")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov9);
            textView.setText(text9);
        }
        if (backStackPatern.equals("410")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov10);
            textView.setText(text10);
        }
        if (backStackPatern.equals("411")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov11);
            textView.setText(text11);
        }
        if (backStackPatern.equals("412")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov12);
            textView.setText(text12);
        }
        if (backStackPatern.equals("413")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov13);
            textView.setText(text13);
        }
        if (backStackPatern.equals("414")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov14);
            textView.setText(text14);
        }
        if (backStackPatern.equals("415")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov15);
            textView.setText(text15);
        }
        if (backStackPatern.equals("416")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov16);
            textView.setText(text16);
        }
        if (backStackPatern.equals("417")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov17);
            textView.setText(text17);
        }
        if (backStackPatern.equals("418")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov18);
            textView.setText(text18);
        }
        if (backStackPatern.equals("419")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov19);
            textView.setText(text19);
        }
        if (backStackPatern.equals("420")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov20);
            textView.setText(text20);
        }
        if (backStackPatern.equals("421")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov21);
            textView.setText(text21);
        }
        if (backStackPatern.equals("422")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov22);
            textView.setText(text22);
        }
        if (backStackPatern.equals("423")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov23);
            textView.setText(text23);
        }
        if (backStackPatern.equals("424")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov24);
            textView.setText(text24);
        }
        if (backStackPatern.equals("425")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov25);
            textView.setText(text25);
        }
        if (backStackPatern.equals("426")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov26);
            textView.setText(text26);
        }
        if (backStackPatern.equals("427")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov27);
            textView.setText(text27);
        }
        if (backStackPatern.equals("428")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov28);
            textView.setText(text28);
        }
        if (backStackPatern.equals("429")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov29);
            textView.setText(text29);
        }
        if (backStackPatern.equals("430")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov30);
            textView.setText(text30);
        }
        if (backStackPatern.equals("431")) {
            naslovTeksta.setTextColor(Color.parseColor("#ff8a00"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov31);
            textView.setText(text31);
        }
        if (backStackPatern.equals("432")) {
            naslovTeksta.setTextColor(Color.parseColor("#ff8a00"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov32);
            textView.setText(text32);
        }
        if (backStackPatern.equals("433")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov33);
            textView.setText(text33);
        }
        if (backStackPatern.equals("434")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov34);
            textView.setText(text34);
        }
        if (backStackPatern.equals("435")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov35);
            textView.setText(text35);
        }
        if (backStackPatern.equals("436")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov36);
            textView.setText(text36);
        }
        if (backStackPatern.equals("437")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov37);
            textView.setText(text37);
        }
        if (backStackPatern.equals("438")) {
            naslovTeksta.setTextColor(Color.parseColor("#ffffff"));
            otvoriPrikazB();
            naslovTeksta.setText(naslov38);
            textView.setText(text38);
        }



    }



    private void trazib() {
        sakriNaslove();
        naslovApp.setVisibility(View.GONE);
        searchCounter=0;
        if((text1b.toLowerCase().contains(uzorak.toLowerCase())) || (naslov1.toLowerCase().contains(uzorak.toLowerCase())) || (text1A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS1.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text2b.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov2.toLowerCase().contains(uzorak.toLowerCase())) ||(text2A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS2.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text3.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov3.toLowerCase().contains(uzorak.toLowerCase())) ||(text3A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS3.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text4.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov4.toLowerCase().contains(uzorak.toLowerCase())) ||(text4A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS4.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text5.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov5.toLowerCase().contains(uzorak.toLowerCase())) ||(text5A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS5.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text6.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov6.toLowerCase().contains(uzorak.toLowerCase())) ||(text6A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS6.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;

        }
        if((text7.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov7.toLowerCase().contains(uzorak.toLowerCase())) ||(text7A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS7.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text8.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov8.toLowerCase().contains(uzorak.toLowerCase())) ||(text8A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS8.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text9.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov9.toLowerCase().contains(uzorak.toLowerCase())) ||(text9A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS9.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text10.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov10.toLowerCase().contains(uzorak.toLowerCase())) ||(text10A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS10.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text11.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov11.toLowerCase().contains(uzorak.toLowerCase())) ||(text11A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS11.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text12.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov12.toLowerCase().contains(uzorak.toLowerCase())) ||(text12A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS12.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text13.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov13.toLowerCase().contains(uzorak.toLowerCase())) ||(text13A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS13.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text14.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov14.toLowerCase().contains(uzorak.toLowerCase())) ||(text14A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS14.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text15.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov15.toLowerCase().contains(uzorak.toLowerCase())) ||(text15A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS15.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text16.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov16.toLowerCase().contains(uzorak.toLowerCase())) ||(text16A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS16.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text17.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov17.toLowerCase().contains(uzorak.toLowerCase())) ||(text17A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS17.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text18.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov18.toLowerCase().contains(uzorak.toLowerCase())) ||(text18A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS18.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text19.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov19.toLowerCase().contains(uzorak.toLowerCase())) ||(text19A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS19.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text20.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov20.toLowerCase().contains(uzorak.toLowerCase())) ||(text20A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS20.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text21.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov21.toLowerCase().contains(uzorak.toLowerCase())) ||(text21A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS21.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text22.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov22.toLowerCase().contains(uzorak.toLowerCase())) ||(text22A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS22.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text23.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov23.toLowerCase().contains(uzorak.toLowerCase())) ||(text23A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS23.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text24.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov24.toLowerCase().contains(uzorak.toLowerCase())) ||(text24A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS24.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text25.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov25.toLowerCase().contains(uzorak.toLowerCase())) ||(text25A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS25.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text26.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov26.toLowerCase().contains(uzorak.toLowerCase())) ||(text26A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS26.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text27.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov27.toLowerCase().contains(uzorak.toLowerCase())) ||(text27A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS27.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text28.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov28.toLowerCase().contains(uzorak.toLowerCase())) ||(text28A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS28.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text29.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov29.toLowerCase().contains(uzorak.toLowerCase())) ||(text29A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS29.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text30.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov30.toLowerCase().contains(uzorak.toLowerCase())) ||(text30A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS30.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text31b.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov31.toLowerCase().contains(uzorak.toLowerCase())) ||(text31A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS31.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }

        if((text33b.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov33.toLowerCase().contains(uzorak.toLowerCase())) ||(text33A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS33.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text34b.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov34.toLowerCase().contains(uzorak.toLowerCase())) ||(text34A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS34.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text35b.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov35.toLowerCase().contains(uzorak.toLowerCase())) ||(text35A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS35.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text36b.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov36.toLowerCase().contains(uzorak.toLowerCase())) ||(text36A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS36.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text37.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov37.toLowerCase().contains(uzorak.toLowerCase())) ||(text37A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS37.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((text38.toLowerCase().contains(uzorak.toLowerCase()))|| (naslov38.toLowerCase().contains(uzorak.toLowerCase())) ||(text38A.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS38.setVisibility(View.VISIBLE);
            searchCounter++;
            key=false;
        }
        if((m1.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS39.setVisibility(View.VISIBLE);
            searchCounter++;
        }
        if((m1.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS39.setVisibility(View.VISIBLE);
            searchCounter++;
        }
        if((m2.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS40.setVisibility(View.VISIBLE);
            searchCounter++;
        }
        if((m3.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS41.setVisibility(View.VISIBLE);
            searchCounter++;
        }
        if((m4.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS42.setVisibility(View.VISIBLE);
            searchCounter++;
        }
        if((m5.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS43.setVisibility(View.VISIBLE);
            searchCounter++;

        }
        if((m6.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS44.setVisibility(View.VISIBLE);
            searchCounter++;
        }
        if((m7.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS45.setVisibility(View.VISIBLE);
            searchCounter++;
        }
        if((m8.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS46.setVisibility(View.VISIBLE);
            searchCounter++;
        }
        if((m9.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS47.setVisibility(View.VISIBLE);
            searchCounter++;
        }
        if((m10.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS48.setVisibility(View.VISIBLE);
            searchCounter++;
        }
        if((m11.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS49.setVisibility(View.VISIBLE);
            searchCounter++;
        }
        if((m12.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS50.setVisibility(View.VISIBLE);
            searchCounter++;
        }
        if((m13.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS51.setVisibility(View.VISIBLE);
            searchCounter++;
        }

        if((m14.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS52.setVisibility(View.VISIBLE);
            searchCounter++;
        }
        if((m15.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS53.setVisibility(View.VISIBLE);
            searchCounter++;
        }
        if((m16.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS54.setVisibility(View.VISIBLE);
            searchCounter++;
        }
        if((m17.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS55.setVisibility(View.VISIBLE);
            searchCounter++;
        }
        if((m18.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS56.setVisibility(View.VISIBLE);
            searchCounter++;
        }
        if((m19.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS57.setVisibility(View.VISIBLE);
            searchCounter++;
        }
        if((m20.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS58.setVisibility(View.VISIBLE);
            searchCounter++;
        }
        if((m21.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS59.setVisibility(View.VISIBLE);
            searchCounter++;
        }
        if((m22.toLowerCase().contains(uzorak.toLowerCase()))){
            podnaslovS60.setVisibility(View.VISIBLE);
            searchCounter++;
        }


        if(searchCounter<1){
            podnaslovSnema.setVisibility(View.VISIBLE);
        }
        else {
            podnaslovSnema.setVisibility(View.GONE);
        }
    }

    private void close() {
        linearView1.setVisibility(View.GONE);
        linearView21.setVisibility(View.GONE);
        linearView22.setVisibility(View.GONE);
        linearView23.setVisibility(View.GONE);
        linearView24.setVisibility(View.GONE);
        linearView25.setVisibility(View.GONE);
        linearView26.setVisibility(View.GONE);
        linearView27.setVisibility(View.GONE);
        linearView28.setVisibility(View.GONE);
        linearView3.setVisibility(View.GONE);
        linearView4.setVisibility(View.GONE);
        linearView5.setVisibility(View.GONE);
        naslovApp.setVisibility(View.GONE);
        searcher.setVisibility(View.GONE);
    }
}
