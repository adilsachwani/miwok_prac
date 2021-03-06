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

public class PhrasesFragment extends Fragment {

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

    public PhrasesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.words_layout,container,false);

        Words = new ArrayList<Word>();
        mListView = (ListView) rootView.findViewById(R.id.list);

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

        mAdapter = new WordAdapter(getActivity(),Words,R.color.category_phrases);
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
