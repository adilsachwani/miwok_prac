package com.example.android.miwok;

public class Word {

    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageResourceId;
    private boolean mImage;

    public Word(String mDefaultTranslation, String mMiwokTranslation){
        this.mMiwokTranslation = mMiwokTranslation;
        this.mDefaultTranslation = mDefaultTranslation;
        mImage = false;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation, int mImageResourceId){
        this.mMiwokTranslation = mMiwokTranslation;
        this.mDefaultTranslation = mDefaultTranslation;
        this.mImageResourceId = mImageResourceId;
        mImage = true;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public boolean getImage(){
        return mImage;
    }


}
