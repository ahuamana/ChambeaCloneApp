package com.paparazziteam.chambea.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.paparazziteam.chambea.R;
import com.paparazziteam.chambea.utils.LocaleHelper;

public class ChooseLanguageActivity extends AppCompatActivity {

    ImageView imageViewSpanish;
    ImageView imageViewEnglish;
    ImageView imageViewPortuguese;

    LocaleHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_language);


        imageViewSpanish = findViewById(R.id.imageViewSpanish);
        imageViewEnglish = findViewById(R.id.imageViewEnglish);
        imageViewPortuguese = findViewById(R.id.imageViewPortuguese);

        mHelper = new LocaleHelper(ChooseLanguageActivity.this);

        clickListener();

        getPreferences();

    }

    private void clickListener() {

        imageViewSpanish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageViewSpanish.setImageResource(R.mipmap.ic_circle_check);
                imageViewEnglish.setImageResource(R.mipmap.ic_circle_nocheck);
                imageViewPortuguese.setImageResource(R.mipmap.ic_circle_nocheck);

                mHelper.updateResource("default");
                savePreferences("es");
                recreate(); //update the view

            }
        });

        imageViewEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageViewSpanish.setImageResource(R.mipmap.ic_circle_nocheck);
                imageViewEnglish.setImageResource(R.mipmap.ic_circle_check);
                imageViewPortuguese.setImageResource(R.mipmap.ic_circle_nocheck);

                mHelper.updateResource("en");
                savePreferences("en");
                recreate();

            }
        });

        imageViewPortuguese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageViewSpanish.setImageResource(R.mipmap.ic_circle_nocheck);
                imageViewEnglish.setImageResource(R.mipmap.ic_circle_nocheck);
                imageViewPortuguese.setImageResource(R.mipmap.ic_circle_check);

                mHelper.updateResource("pt");
                savePreferences("pt");
                recreate();
            }
        });
    }

    private void getPreferences()
    {
        SharedPreferences preferences = getSharedPreferences("languageInformation", Context.MODE_PRIVATE);

        String language = preferences.getString("state","not found");

        switch (language)
        {
            case "en":
                imageViewEnglish.setImageResource(R.mipmap.ic_circle_check);
                break;

            case "es":
                imageViewSpanish.setImageResource(R.mipmap.ic_circle_check);
                break;

            case "pt":
                imageViewPortuguese.setImageResource(R.mipmap.ic_circle_check);
                break;

            default:
                Log.e("ERROR", "Case not found");
                break;
        }


    }



    private  void savePreferences(String language)
    {
        SharedPreferences preferences = getSharedPreferences("languageInformation", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("state", language );

        editor.commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
