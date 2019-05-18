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
public class PhrasesFragment extends Fragment {


    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.translation_list, container, false);

        ListView phrasesListView = rootView.findViewById(R.id.translationListView);
        final ArrayList<Word> phrasesTranslation = new ArrayList<>();
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


        phrasesTranslation.add(new Word(miwokTranslation[0], englishTranslations[0], R.raw.phrase_where_are_you_going));
        phrasesTranslation.add(new Word(miwokTranslation[1], englishTranslations[1], R.raw.phrase_what_is_your_name));
        phrasesTranslation.add(new Word(miwokTranslation[2], englishTranslations[2], R.raw.phrase_my_name_is));
        phrasesTranslation.add(new Word(miwokTranslation[3], englishTranslations[3], R.raw.phrase_how_are_you_feeling));
        phrasesTranslation.add(new Word(miwokTranslation[4], englishTranslations[4], R.raw.phrase_im_feeling_good));
        phrasesTranslation.add(new Word(miwokTranslation[5], englishTranslations[5], R.raw.phrase_are_you_coming));
        phrasesTranslation.add(new Word(miwokTranslation[6], englishTranslations[6], R.raw.phrase_yes_im_coming));
        phrasesTranslation.add(new Word(miwokTranslation[7], englishTranslations[7], R.raw.phrase_im_coming));
        phrasesTranslation.add(new Word(miwokTranslation[8], englishTranslations[8], R.raw.phrase_lets_go));
        phrasesTranslation.add(new Word(miwokTranslation[9], englishTranslations[9], R.raw.phrase_come_here));


        WordAdapter wordAdapter = new WordAdapter(getActivity(), phrasesTranslation, R.color.category_phrases);
        phrasesListView.setAdapter(wordAdapter);

        phrasesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Word word = phrasesTranslation.get(position);
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
