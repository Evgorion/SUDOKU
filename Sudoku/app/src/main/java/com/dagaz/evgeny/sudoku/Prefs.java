package com.dagaz.evgeny.sudoku;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import static com.dagaz.evgeny.sudoku.R.xml.settings;

/**
 * Created by Evgeny on 05/01/2016.
 */
public class Prefs extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(settings);
    }
}
