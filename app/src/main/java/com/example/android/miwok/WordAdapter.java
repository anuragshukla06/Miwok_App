package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mbackgroundColor;

    WordAdapter(Activity context, ArrayList<Word> words, int backgroundColorId){
        super(context, 0, words); // You no need to specify the layout_resource id because we are overriding the getView.
        mbackgroundColor = backgroundColorId;
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
        ImageView itemImage = listItemView.findViewById(R.id.itemImageView);
        LinearLayout verticalLayout = listItemView.findViewById(R.id.verticalLinearLayout);

        defaultTranslation.setText(word.getDefaultTranslation());
        miwokTranslation.setText(word.getMiwokTranslation());


        if (word.hasImage()) {
            itemImage.setImageResource(word.getImageResourceId());
            itemImage.setVisibility(View.VISIBLE);
        } else{
            itemImage.setVisibility(View.GONE);
        }
        verticalLayout.setBackgroundResource(mbackgroundColor);

        return listItemView;
    }


}
