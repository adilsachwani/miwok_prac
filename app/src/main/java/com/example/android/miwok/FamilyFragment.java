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

public class FamilyFragment extends Fragment {

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

    public FamilyFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.words_layout,container,false);

        Words = new ArrayList<Word>();
        mListView = (ListView) rootView.findViewById(R.id.list);

        Words.add(new Word("father","apa",R.drawable.family_father,R.raw.family_father));
        Words.add(new Word("mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
        Words.add(new Word("son","angsi",R.drawable.family_son,R.raw.family_son));
        Words.add(new Word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        Words.add(new Word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        Words.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        Words.add(new Word("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        Words.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        Words.add(new Word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        Words.add(new Word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));

        mAdapter = new WordAdapter(getActivity(),Words,R.color.category_family);
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
