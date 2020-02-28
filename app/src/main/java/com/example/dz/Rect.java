package com.example.dz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Rect extends SurfaceView implements Runnable {
    private Thread thread;
    private float x;
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;
    private boolean rectRun;
    private float rectY;
    private float rectX;
    private float changeRectX;
    private boolean clic= false;

    public Rect (Context context, int screenX, int screenY) {
        super(context);
        surfaceHolder = getHolder();
        paint = new Paint();
        rectY = screenY;
        changeRectX = screenX/2;
        rectX = screenX;

    }

    @Override
    public void run() {

        while (rectRun) {
            Update();
            Draw();
        }
    }

    private void Update() {

            if (x < changeRectX&&clic) {
                changeRectX--;
            }
            if (x > changeRectX&&clic) {
                changeRectX++;
            }
    }

    private void Draw() {
        if (surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();
            canvas.drawColor(Color.BLACK);
            paint.setColor(Color.RED);
            canvas.drawRect(0, 0, changeRectX,rectY, paint);
            paint.setColor(Color.BLUE);
            canvas.drawRect(changeRectX, 0, rectX,rectY, paint);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_UP:
                clic = false;
                break;
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                clic = true;

                break;
        }
        return true;
    }

    public void pause() {
        rectRun=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        rectRun=true;
        thread = new Thread(this);
        thread.start();
    }
}
