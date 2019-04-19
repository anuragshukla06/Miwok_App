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

        words.add(new Word(miwokNumbers[0], englishNumbers[0], R.drawable.number_one));
        words.add(new Word(miwokNumbers[1], englishNumbers[1], R.drawable.number_two));
        words.add(new Word(miwokNumbers[2], englishNumbers[2], R.drawable.number_three));
        words.add(new Word(miwokNumbers[3], englishNumbers[3], R.drawable.number_four));
        words.add(new Word(miwokNumbers[4], englishNumbers[4], R.drawable.number_five));
        words.add(new Word(miwokNumbers[5], englishNumbers[5], R.drawable.number_six));
        words.add(new Word(miwokNumbers[6], englishNumbers[6], R.drawable.number_seven));
        words.add(new Word(miwokNumbers[7], englishNumbers[7], R.drawable.number_eight));
        words.add(new Word(miwokNumbers[8], englishNumbers[8], R.drawable.number_nine));
        words.add(new Word(miwokNumbers[9], englishNumbers[9], R.drawable.number_ten));



        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_numbers);
        numbersListView.setAdapter(wordAdapter);

    }
}
