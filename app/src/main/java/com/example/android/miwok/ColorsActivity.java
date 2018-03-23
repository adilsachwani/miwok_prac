package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    ArrayList<Word> Words;
    ListView mListView;
    WordAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_layout);

        Words = new ArrayList<Word>();
        mListView = (ListView) findViewById(R.id.list);

        Words.add(new Word("red","weṭeṭṭi",R.drawable.color_red));
        Words.add(new Word("green","chokokki",R.drawable.color_green));
        Words.add(new Word("brown","ṭakaakki",R.drawable.color_brown));
        Words.add(new Word("gray","ṭopoppi",R.drawable.color_gray));
        Words.add(new Word("black","kululli",R.drawable.color_black));
        Words.add(new Word("white","kelelli",R.drawable.color_white));
        Words.add(new Word("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow));
        Words.add(new Word("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow));

        mAdapter = new WordAdapter(this,Words,R.color.category_colors);
        mListView.setAdapter(mAdapter);
    }
}
