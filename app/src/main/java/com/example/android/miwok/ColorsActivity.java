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

        for(int i=0; i<englishTranslation.length; i++){
            colorsTranslation.add(new Word(miwokTranslation[i], englishTranslation[i]));
        }

        WordAdapter wordAdapter = new WordAdapter(this, colorsTranslation);
        colorsListView.setAdapter(wordAdapter);

    }
}
