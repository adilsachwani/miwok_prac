package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    ArrayList<Word> Words;
    ListView mListView;
    WordAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_layout);

        Words = new ArrayList<Word>();
        mListView = (ListView) findViewById(R.id.list);

        Words.add(new Word("father","apa",R.drawable.family_father));
        Words.add(new Word("mother","әṭa",R.drawable.family_mother));
        Words.add(new Word("son","angsi",R.drawable.family_son));
        Words.add(new Word("daughter","tune",R.drawable.family_daughter));
        Words.add(new Word("older brother","taachi",R.drawable.family_older_brother));
        Words.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother));
        Words.add(new Word("older sister","teṭe",R.drawable.family_older_sister));
        Words.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister));
        Words.add(new Word("grandmother","ama",R.drawable.family_grandmother));
        Words.add(new Word("grandfather","paapa",R.drawable.family_grandfather));

        mAdapter = new WordAdapter(this,Words,R.color.category_family);
        mListView.setAdapter(mAdapter);
    }
}