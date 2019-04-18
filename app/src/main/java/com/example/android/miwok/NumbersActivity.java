package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.translation_list);

        ArrayList<Word> words = new ArrayList<Word>();
        ListView numbersListView = (ListView) findViewById(R.id.translationListView);

        String englishNumbers[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        String miwokNumbers[] = {"lutti","otiiko","tolookosu","oyyisa","massokka","temmokka","kenekaku","kawinta","wo’e","na’aacha"};

        for(int i=0; i<10; i++){
            words.add(new Word(miwokNumbers[i], englishNumbers[i]));
        }

        WordAdapter wordAdapter = new WordAdapter(this, words);
        numbersListView.setAdapter(wordAdapter);

    }
}
