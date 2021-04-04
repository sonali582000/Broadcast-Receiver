package com.example.mylab12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class CardView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
    }

    public void healthy(View view) {
        Snackbar sb = Snackbar.make(view,"Coming Soon ..!!",Snackbar.LENGTH_LONG);
        sb.show();
    }

    public void fast(View view) {
        Intent homeIntent = new Intent(this,MainActivity.class);
        startActivity(homeIntent);
        finish();
    }

    public void fruits(View view) {
        Snackbar sb = Snackbar.make(view,"Coming Soon ..!!",Snackbar.LENGTH_LONG);
        sb.show();
    }
}