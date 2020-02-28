package com.example.dz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

public class RectActivity extends AppCompatActivity {
    private Rect rectView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        rectView = new Rect(this,size.x, size.y);
        setContentView(rectView);
    }
    @Override
    protected void onPause() {
        super.onPause();
        rectView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        rectView.resume();
    }
}
