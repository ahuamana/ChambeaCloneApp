package com.paparazziteam.chambea.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
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



    }

    private void clickListener() {

        imageViewSpanish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageViewSpanish.setImageResource(R.mipmap.ic_circle_check);
                imageViewEnglish.setImageResource(R.mipmap.ic_circle_nocheck);
                imageViewPortuguese.setImageResource(R.mipmap.ic_circle_nocheck);

                mHelper.updateResource("default");
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
                recreate();
            }
        });
    }


}
