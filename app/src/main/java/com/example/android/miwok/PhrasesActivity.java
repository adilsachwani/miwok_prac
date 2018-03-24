package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    ArrayList<Word> Words;
    ListView mListView;
    WordAdapter mAdapter;
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_layout);

        Words = new ArrayList<Word>();
        mListView = (ListView) findViewById(R.id.list);

        Words.add(new Word("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        Words.add(new Word("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        Words.add(new Word("My name is...","oyaaset...",R.raw.phrase_my_name_is));
        Words.add(new Word("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling));
        Words.add(new Word("I’m feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
        Words.add(new Word("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
        Words.add(new Word("Yes, I’m coming.","hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        Words.add(new Word("I’m coming.","әәnәm",R.raw.phrase_im_coming));
        Words.add(new Word("Let’s go","yoowutis",R.raw.phrase_lets_go));
        Words.add(new Word("Come here.","әnni'nem",R.raw.phrase_come_here));

        mAdapter = new WordAdapter(this,Words,R.color.category_phrases);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word word = Words.get(i);

                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();

            }
        });

    }
}
