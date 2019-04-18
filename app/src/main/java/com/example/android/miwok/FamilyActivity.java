package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.translation_list);

        ArrayList<Word> familyTranslation = new ArrayList<Word>();
        ListView translationListView = (ListView) findViewById(R.id.translationListView);

        String englishTranslation[] = {"father", "mother", "son", "daughter", "older brother", "younger brother", "older sister", "younger sister", "grandmother", "grandfather"};
        String miwokTranslation[] = {"әpә","әṭa","angsi","tune","taachi","chalitti","teṭe","kolliti","ama","paapa"};

        for(int i=0; i<10; i++){
            familyTranslation.add(new Word(miwokTranslation[i], englishTranslation[i]));
        }

        WordAdapter wordAdapter = new WordAdapter(this, familyTranslation);
        translationListView.setAdapter(wordAdapter);

    }
}
