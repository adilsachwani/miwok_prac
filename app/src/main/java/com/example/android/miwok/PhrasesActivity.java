package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    ArrayList<Word> Words;
    ListView mListView;
    WordAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_layout);

        Words = new ArrayList<Word>();
        mListView = (ListView) findViewById(R.id.list);

        Words.add(new Word("Where are you going?","minto wuksus"));
        Words.add(new Word("What is your name?","tinnә oyaase'nә"));
        Words.add(new Word("My name is...","oyaaset..."));
        Words.add(new Word("How are you feeling?","michәksәs?"));
        Words.add(new Word("I’m feeling good.","kuchi achit"));
        Words.add(new Word("Are you coming?","әәnәs'aa?"));
        Words.add(new Word("Yes, I’m coming.","hәә’ әәnәm"));
        Words.add(new Word("I’m coming.","әәnәm"));
        Words.add(new Word("Let’s go","yoowutis"));
        Words.add(new Word("Come here.","әnni'nem"));

        mAdapter = new WordAdapter(this,Words,R.color.category_phrases);
        mListView.setAdapter(mAdapter);
    }
}
