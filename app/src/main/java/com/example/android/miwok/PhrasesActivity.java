package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.translation_list);

        ListView phrasesListView = (ListView) findViewById(R.id.translationListView);
        ArrayList<Word> phrasesTranslation = new ArrayList<>();
        String englishTranslations[] = {"Where are you going?",
                "What is your name?",
                "My name is...",
                "How are you feeling?",
                "I’m feeling good.",
                "Are you coming?",
                "Yes, I’m coming.",
                "I'm coming.",
                "Let's go.",
                "Come here."};
        String miwokTranslation[] = {"minto wuksus", "tinnә oyaase'nә", "oyaaset...", "michәksәs?", "kuchi achit", "әәnәs'aa?", "әәnәs'aa?", "әәnәm", "yoowutis", "әnni'nem"};

        for(int i=0; i<englishTranslations.length; i++){
            phrasesTranslation.add(new Word(miwokTranslation[i], englishTranslations[i]));
        }

        WordAdapter wordAdapter = new WordAdapter(this, phrasesTranslation);
        phrasesListView.setAdapter(wordAdapter);

    }
}
