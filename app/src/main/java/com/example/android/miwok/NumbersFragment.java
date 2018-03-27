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

public class NumbersFragment extends Fragment {

    ArrayList<Word> Words;
    ListView mListView;
    WordAdapter mAdapter;
    MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompleteListner = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    public NumbersFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.words_layout,container,false);

        Words = new ArrayList<Word>();
        mListView = (ListView) rootView.findViewById(R.id.list);

        Words.add(new Word("one","lutti",R.drawable.number_one,R.raw.number_one));
        Words.add(new Word("two","otiiko",R.drawable.number_two,R.raw.number_two));
        Words.add(new Word("three","tolookosu",R.drawable.number_three,R.raw.number_three));
        Words.add(new Word("four","oyyisa",R.drawable.number_four,R.raw.number_four));
        Words.add(new Word("five","massokka",R.drawable.number_five,R.raw.number_five));
        Words.add(new Word("six","temmokka",R.drawable.number_six,R.raw.number_six));
        Words.add(new Word("seven","kenekaku",R.drawable.number_seven,R.raw.number_seven));
        Words.add(new Word("eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
        Words.add(new Word("nine","wo'e",R.drawable.number_nine,R.raw.number_nine));
        Words.add(new Word("ten","na'aacha",R.drawable.number_ten,R.raw.number_ten));

        mAdapter = new WordAdapter(getActivity(),Words,R.color.category_numbers);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word word = Words.get(i);

                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompleteListner);

            }
        });

        return rootView;
    }

    private void releaseMediaPlayer() {

        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
