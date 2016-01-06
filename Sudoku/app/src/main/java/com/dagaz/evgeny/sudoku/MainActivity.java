package com.dagaz.evgeny.sudoku;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.content.DialogInterface;

// Start
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Sudoku";

    Button continueButton;
    Button newButton;
    Button aboutButton;
    Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continueButton = (Button) findViewById(R.id.btn_sp_continue);
        newButton      = (Button) findViewById(R.id.btn_sp_new_game);
        aboutButton    = (Button) findViewById(R.id.btn_sp_about);
        exitButton     = (Button) findViewById(R.id.btn_sp_exit);

        continueButton.setOnClickListener(this);
        newButton.setOnClickListener(this);
        aboutButton.setOnClickListener(this);
        exitButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sp_about:
                Intent i = new Intent(this, About.class);
                startActivity(i);
                break;
            case R.id.btn_sp_new_game:
                openNewGameDialog();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                startActivity(new Intent(this, Prefs.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void openNewGameDialog()
    {
        new AlertDialog.Builder(this)
                .setTitle(R.string.new_game_title)
                .setItems(R.array.difficulty,
                        new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startGame(which);
            }
        });
        Log.d(TAG, "New Game");
    }

    private  void startGame(int i){
        Log.d(TAG, "clicked on " + i);
    }
}
