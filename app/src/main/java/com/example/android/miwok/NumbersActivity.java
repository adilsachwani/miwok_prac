package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    ArrayList<Word> Words;
    ListView mListView;
    WordAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_layout);

        Words = new ArrayList<Word>();
        mListView = (ListView) findViewById(R.id.list);

        Words.add(new Word("one","lutti",R.drawable.number_one));
        Words.add(new Word("two","otiiko",R.drawable.number_two));
        Words.add(new Word("three","tolookosu",R.drawable.number_three));
        Words.add(new Word("four","oyyisa",R.drawable.number_four));
        Words.add(new Word("five","massokka",R.drawable.number_five));
        Words.add(new Word("six","temmokka",R.drawable.number_six));
        Words.add(new Word("seven","kenekaku",R.drawable.number_seven));
        Words.add(new Word("eight","kawinta",R.drawable.number_eight));
        Words.add(new Word("nine","wo'e",R.drawable.number_nine));
        Words.add(new Word("ten","na'aacha",R.drawable.number_ten));

        mAdapter = new WordAdapter(this,Words,R.color.category_numbers);
        mListView.setAdapter(mAdapter);

    }
}