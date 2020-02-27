package com.example.dz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Ball extends SurfaceView implements Runnable {
    private Thread thread;
    private boolean touch = false;
    private float radius = 0;
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;
    private boolean bollRun;
    private float rectY;
    private float rectX;
    public Ball(Context context,int screenX, int screenY) {
        super(context);
        surfaceHolder = getHolder();
        paint = new Paint();
        rectY=screenY/2;
        rectX = screenX/2;

    }

    @Override
    public void run() {

        while (bollRun) {
            Update();
            Draw();
        }
    }

    private void Update() {
        if (touch) radius += 0.1;
        else radius = 0;
    }

    private void Draw() {
        if (surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();
            canvas.drawColor(Color.WHITE);
            paint.setColor(Color.BLACK);
            canvas.drawCircle(rectX, rectY, radius, paint);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_UP:
                touch = false;
                break;
            case MotionEvent.ACTION_DOWN:
                touch = true;
                break;
        }
        return true;
    }

    public void pause() {
        bollRun=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        bollRun=true;
        thread = new Thread(this);
        thread.start();
    }
}