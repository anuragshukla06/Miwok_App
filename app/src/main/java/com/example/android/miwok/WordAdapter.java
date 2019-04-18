package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    WordAdapter(Activity context, ArrayList<Word> words){
        super(context, 0, words);

    }

    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word word = getItem(position);
        TextView defaultTranslation = listItemView.findViewById(R.id.defaultWordTextView);
        TextView miwokTranslation = listItemView.findViewById(R.id.miwokWordTextView);

        defaultTranslation.setText(word.getDefaultTranslation());
        miwokTranslation.setText(word.getMiwokTranslation());


        return listItemView;
    }
}
