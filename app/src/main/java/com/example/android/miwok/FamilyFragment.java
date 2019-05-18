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
public class FamilyFragment extends Fragment {


    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.translation_list, container, false);

        final ArrayList<Word> familyTranslation = new ArrayList<Word>();
        ListView translationListView = (ListView) rootView.findViewById(R.id.translationListView);

        String englishTranslation[] = {"father", "mother", "son", "daughter", "older brother", "younger brother", "older sister", "younger sister", "grandmother", "grandfather"};
        String miwokTranslation[] = {"әpә","әṭa","angsi","tune","taachi","chalitti","teṭe","kolliti","ama","paapa"};


        familyTranslation.add(new Word(miwokTranslation[0], englishTranslation[0], R.drawable.family_father, R.raw.family_father));
        familyTranslation.add(new Word(miwokTranslation[1], englishTranslation[1], R.drawable.family_mother, R.raw.family_mother));
        familyTranslation.add(new Word(miwokTranslation[2], englishTranslation[2], R.drawable.family_son, R.raw.family_son));
        familyTranslation.add(new Word(miwokTranslation[3], englishTranslation[3], R.drawable.family_daughter, R.raw.family_daughter));
        familyTranslation.add(new Word(miwokTranslation[4], englishTranslation[4], R.drawable.family_older_brother, R.raw.family_older_brother));
        familyTranslation.add(new Word(miwokTranslation[5], englishTranslation[5], R.drawable.family_younger_brother, R.raw.family_younger_brother));
        familyTranslation.add(new Word(miwokTranslation[6], englishTranslation[6], R.drawable.family_older_sister, R.raw.family_older_sister));
        familyTranslation.add(new Word(miwokTranslation[7], englishTranslation[7], R.drawable.family_younger_sister, R.raw.family_younger_brother));
        familyTranslation.add(new Word(miwokTranslation[8], englishTranslation[8], R.drawable.family_grandmother, R.raw.family_grandmother));
        familyTranslation.add(new Word(miwokTranslation[9], englishTranslation[9], R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter wordAdapter = new WordAdapter(getActivity(), familyTranslation, R.color.category_family);
        translationListView.setAdapter(wordAdapter);

        translationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Word word = familyTranslation.get(position);
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
