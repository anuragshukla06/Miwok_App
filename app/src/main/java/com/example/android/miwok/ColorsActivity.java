package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.translation_list);

        ArrayList<Word> colorsTranslation = new ArrayList<Word>();
        ListView colorsListView = (ListView) findViewById(R.id.translationListView);
        String englishTranslation[] = {"red", "green", "brown", "gray", "black", "white", "dusty yellow", "mustard yellow"};
        String miwokTranslation[] = {"weṭeṭṭi", "chokokki", "ṭakaakki", "ṭopoppi", "kululli", "kelelli", "ṭopiisә", "chiwiiṭә"};


        colorsTranslation.add(new Word(miwokTranslation[0], englishTranslation[0], R.drawable.color_red));
        colorsTranslation.add(new Word(miwokTranslation[1], englishTranslation[1], R.drawable.color_green));
        colorsTranslation.add(new Word(miwokTranslation[2], englishTranslation[2], R.drawable.color_brown));
        colorsTranslation.add(new Word(miwokTranslation[3], englishTranslation[3], R.drawable.color_gray));
        colorsTranslation.add(new Word(miwokTranslation[4], englishTranslation[4], R.drawable.color_black));
        colorsTranslation.add(new Word(miwokTranslation[5], englishTranslation[5], R.drawable.color_white));
        colorsTranslation.add(new Word(miwokTranslation[6], englishTranslation[6], R.drawable.color_dusty_yellow));
        colorsTranslation.add(new Word(miwokTranslation[7], englishTranslation[7], R.drawable.color_mustard_yellow));

        WordAdapter wordAdapter = new WordAdapter(this, colorsTranslation, R.color.category_colors);
        colorsListView.setAdapter(wordAdapter);

    }
}
