package com.example.android.miwok;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {


    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.translation_list, container, false);

        final ArrayList<Word> colorsTranslation = new ArrayList<Word>();
        ListView colorsListView = (ListView) rootView.findViewById(R.id.translationListView);
        String englishTranslation[] = {"red", "green", "brown", "gray", "black", "white", "dusty yellow", "mustard yellow"};
        String miwokTranslation[] = {"weṭeṭṭi", "chokokki", "ṭakaakki", "ṭopoppi", "kululli", "kelelli", "ṭopiisә", "chiwiiṭә"};


        colorsTranslation.add(new Word(miwokTranslation[0], englishTranslation[0], R.drawable.color_red, R.raw.color_red));
        colorsTranslation.add(new Word(miwokTranslation[1], englishTranslation[1], R.drawable.color_green, R.raw.color_green));
        colorsTranslation.add(new Word(miwokTranslation[2], englishTranslation[2], R.drawable.color_brown, R.raw.color_brown));
        colorsTranslation.add(new Word(miwokTranslation[3], englishTranslation[3], R.drawable.color_gray, R.raw.color_gray));
        colorsTranslation.add(new Word(miwokTranslation[4], englishTranslation[4], R.drawable.color_black, R.raw.color_black));
        colorsTranslation.add(new Word(miwokTranslation[5], englishTranslation[5], R.drawable.color_white, R.raw.color_white));
        colorsTranslation.add(new Word(miwokTranslation[6], englishTranslation[6], R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colorsTranslation.add(new Word(miwokTranslation[7], englishTranslation[7], R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter wordAdapter = new WordAdapter(getActivity(), colorsTranslation, R.color.category_colors);
        colorsListView.setAdapter(wordAdapter);

        colorsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Word word = colorsTranslation.get(position);
                MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), word.getAudioResourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
            }
        });

        return rootView;
    }

}
