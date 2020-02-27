package com.example.dz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class BallActivity extends AppCompatActivity{
    private Ball bollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        bollView = new Ball(this, size.x,size.y);
        setContentView(bollView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        bollView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        bollView.resume();
    }
}

