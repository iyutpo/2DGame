package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


/*
* MainActivity is the entry point to our application. */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set content view to game, so that objects in the game class can be rendered to the screen
        setContentView(new Game(this));
    }
}