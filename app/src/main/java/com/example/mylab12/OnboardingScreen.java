package com.example.mylab12;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import io.github.dreierf.materialintroscreen.MaterialIntroActivity;
import io.github.dreierf.materialintroscreen.MessageButtonBehaviour;
import io.github.dreierf.materialintroscreen.SlideFragmentBuilder;

public class OnboardingScreen extends MaterialIntroActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(new SlideFragmentBuilder()
                .title("🍔🍟🍕 The Good Mood Food 🍔🍟🍕")
                .image(R.drawable.bg1)
                .buttonsColor(R.color.black)
                .backgroundColor(R.color.fav)
                .build());

        addSlide(new SlideFragmentBuilder()
                .title("🤤 Anytime Anywhere 😋")
                .image(R.drawable.bg2)
                .buttonsColor(R.color.black)
                .backgroundColor(R.color.fav)
                .build());

        addSlide(new SlideFragmentBuilder()
                .title("👩🏻‍🍳 Unique Recipes 👨🏻‍🍳")
                .image(R.drawable.bg3)
                .buttonsColor(R.color.black)
                .backgroundColor(R.color.fav)
                .build());

        addSlide(new SlideFragmentBuilder()
                .title("How would you like to order ?😎")
                .image(R.drawable.bg4)
                .buttonsColor(R.color.black)
                .backgroundColor(R.color.fav)
                .build());
    }
    @Override
    public void onFinish() {
        super.onFinish();
        Intent homeIntent = new Intent(this, MainActivity.class);
        startActivity(homeIntent);
        finish();
    }
}