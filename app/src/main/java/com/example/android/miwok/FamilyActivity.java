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


        familyTranslation.add(new Word(miwokTranslation[0], englishTranslation[0], R.drawable.family_father));
        familyTranslation.add(new Word(miwokTranslation[1], englishTranslation[1], R.drawable.family_mother));
        familyTranslation.add(new Word(miwokTranslation[2], englishTranslation[2], R.drawable.family_son));
        familyTranslation.add(new Word(miwokTranslation[3], englishTranslation[3], R.drawable.family_daughter));
        familyTranslation.add(new Word(miwokTranslation[4], englishTranslation[4], R.drawable.family_older_brother));
        familyTranslation.add(new Word(miwokTranslation[5], englishTranslation[5], R.drawable.family_younger_brother));
        familyTranslation.add(new Word(miwokTranslation[6], englishTranslation[6], R.drawable.family_older_sister));
        familyTranslation.add(new Word(miwokTranslation[7], englishTranslation[7], R.drawable.family_younger_sister));
        familyTranslation.add(new Word(miwokTranslation[8], englishTranslation[8], R.drawable.family_grandmother));
        familyTranslation.add(new Word(miwokTranslation[9], englishTranslation[9], R.drawable.family_grandfather));

        WordAdapter wordAdapter = new WordAdapter(this, familyTranslation, R.color.category_family);
        translationListView.setAdapter(wordAdapter);

    }
}
