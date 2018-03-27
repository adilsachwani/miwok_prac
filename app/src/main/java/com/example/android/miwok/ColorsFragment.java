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

public class ColorsFragment extends Fragment {

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

    public ColorsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.words_layout,container,false);

        Words = new ArrayList<Word>();
        mListView = (ListView) rootView.findViewById(R.id.list);

        Words.add(new Word("red","weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
        Words.add(new Word("green","chokokki",R.drawable.color_green,R.raw.color_green));
        Words.add(new Word("brown","ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
        Words.add(new Word("gray","ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
        Words.add(new Word("black","kululli",R.drawable.color_black,R.raw.color_black));
        Words.add(new Word("white","kelelli",R.drawable.color_white,R.raw.color_white));
        Words.add(new Word("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        Words.add(new Word("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        mAdapter = new WordAdapter(getActivity(),Words,R.color.category_colors);
        mListView.setAdapter(mAdapter);

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
