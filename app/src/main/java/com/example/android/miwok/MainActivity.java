/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView numbersButton, phrasesButton, colorsButton, familyButton;
    Intent numbersIntent, phrasesIntent, colorsIntent, familyIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        colorsButton = (TextView) findViewById(R.id.colors);
        familyButton = (TextView) findViewById(R.id.family);
        numbersButton = (TextView) findViewById(R.id.numbers);
        phrasesButton = (TextView) findViewById(R.id.phrases);

        colorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorsIntent = new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(colorsIntent);
            }
        });

        familyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                familyIntent = new Intent(MainActivity.this,FamilyActivity.class);
                startActivity(familyIntent);
            }
        });

        numbersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numbersIntent = new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(numbersIntent);
            }
        });

        phrasesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phrasesIntent = new Intent(MainActivity.this,PhrasesActivity.class);
                startActivity(phrasesIntent);
            }
        });

    }
}