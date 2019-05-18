package com.example.android.miwok;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListner = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {

            if (mediaPlayer != null) {
                if ((focusChange == AudioManager.AUDIOFOCUS_GAIN ||
                        focusChange == AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)) {
                    Log.i("first2", "here");
                    mediaPlayer.start();
                } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                        focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                    Log.i("first1", "here");
                } else if(focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                    Log.i("first2", "here");
                    releaseMediaPlayer();
                }

            }
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.translation_list);

        final ArrayList<Word> words = new ArrayList<Word>();
        ListView numbersListView = (ListView) findViewById(R.id.translationListView);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        String englishNumbers[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        String miwokNumbers[] = {"lutti", "otiiko", "tolookosu", "oyyisa", "massokka", "temmokka", "kenekaku", "kawinta", "wo’e", "na’aacha"};

        words.add(new Word(miwokNumbers[0], englishNumbers[0], R.drawable.number_one, R.raw.number_one));
        words.add(new Word(miwokNumbers[1], englishNumbers[1], R.drawable.number_two, R.raw.number_two));
        words.add(new Word(miwokNumbers[2], englishNumbers[2], R.drawable.number_three, R.raw.number_three));
        words.add(new Word(miwokNumbers[3], englishNumbers[3], R.drawable.number_four, R.raw.number_four));
        words.add(new Word(miwokNumbers[4], englishNumbers[4], R.drawable.number_five, R.raw.number_five));
        words.add(new Word(miwokNumbers[5], englishNumbers[5], R.drawable.number_six, R.raw.number_six));
        words.add(new Word(miwokNumbers[6], englishNumbers[6], R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word(miwokNumbers[7], englishNumbers[7], R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word(miwokNumbers[8], englishNumbers[8], R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word(miwokNumbers[9], englishNumbers[9], R.drawable.number_ten, R.raw.number_ten));


        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_numbers);
        numbersListView.setAdapter(wordAdapter);

        numbersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Word word = words.get(position);
                mediaPlayer = MediaPlayer.create(getApplicationContext(), word.getAudioResourceId());

                int result = audioManager.requestAudioFocus(mOnAudioFocusChangeListner,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            releaseMediaPlayer();
                        }
                    });
                }
            }
        });


    }

    public void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(mOnAudioFocusChangeListner);
        }
    }
}
