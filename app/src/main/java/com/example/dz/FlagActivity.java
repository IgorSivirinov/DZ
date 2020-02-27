package com.example.dz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

public class FlagActivity extends AppCompatActivity {

    private Flag flagView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        flagView = new Flag(this,size.x, size.y);
        setContentView(flagView);
    }
    @Override
    protected void onPause() {
        super.onPause();
        flagView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        flagView.resume();
    }
}
