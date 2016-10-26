package biitworx.games.race.riddle.riddlerace;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by marce_000 on 25.10.2016.
 */
public class OverlayWindow {
    int backColor = Color.argb(175, 200, 200, 200);
    public boolean closed = true;
    public boolean nobuttons = false;
    private Runnable yes;
    private Runnable no;
    RectF yesClick;
    RectF noClick;
    String yesText;
    String noText;
    String title;
    String text;
    Timer timer;
    boolean inverted;
    public OverlayWindow(boolean inverted){
        this.inverted = inverted;
    }

    public void activate(Runnable yes, Runnable no, String yesText, String noText, String title, String text) {
        this.yes = yes;
        this.no = no;
        closed = false;
        this.yesText = yesText;
        this.noText = noText;
        this.text = text;
        this.title = title;
    }


    public void activate(final Runnable yes, String title, String text) {


        closed = false;
        nobuttons = true;
        this.text = text;
        this.title = title;
        timer=new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                yes.run();
            }
        },500);

    }

    public void draw(Canvas canvas) {
        if (!closed) {
            Paint back = new Paint();
            back.setColor(backColor);
            back.setStyle(Paint.Style.FILL);

            RectF rc = new RectF(canvas.getClipBounds());

            canvas.drawRect(rc, back);


            Paint border = new Paint();
            border.setStyle(Paint.Style.STROKE);
            border.setStrokeWidth(5);
            border.setColor(Color.argb(175, 50, 50, 50));

            int hh = 8;

            RectF wnd = new RectF(rc.left + rc.width() / 30, rc.centerY() - rc.height() /hh, rc.right - rc.width() / 30, rc.centerY() + rc.height() / hh);

            RectF top = new RectF(wnd.left, wnd.top, wnd.right, wnd.top + wnd.height() / 4);
            RectF middle = new RectF(wnd.left, wnd.top + wnd.height() / 4, wnd.right, wnd.top + wnd.height() / 2);

            border.setColor(Color.argb(235, 200, 200, 200));

            border.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRect(wnd, border);
            border.setColor(Color.argb(175, 50, 50, 50));

            canvas.drawRect(top, border);

            float size = top.width() / 6;
            yesClick = new RectF(top.left + size * 0.5f, wnd.bottom - top.height() * 1.5f, top.left + size * 2.75f, wnd.bottom - top.height() * 0.5f);
            noClick = new RectF(top.left + size * 3.25f, wnd.bottom - top.height() * 1.5f, top.left + size * 5.5f, wnd.bottom - top.height() * 0.5f);
            float cw = yesClick.height() / 5;

            border.setStyle(Paint.Style.STROKE);
            if (!nobuttons) {
                canvas.drawRoundRect(yesClick, cw, cw, border);
                canvas.drawRoundRect(noClick, cw, cw, border);
                border.setColor(inverted ? Color.argb(240, 240, 160, 160): Color.argb(240, 130, 200, 130));

                border.setStyle(Paint.Style.FILL);
                canvas.drawRoundRect(yesClick, cw, cw, border);
                border.setColor(!inverted ? Color.argb(240, 240, 160, 160): Color.argb(240, 130, 200, 130));

                border.setStyle(Paint.Style.FILL);
                canvas.drawRoundRect(noClick, cw, cw, border);
            }
            border.setStyle(Paint.Style.STROKE);
            border.setColor(Color.argb(175, 50, 50, 50));
            canvas.drawRect(wnd, border);


            border.setTextSize(top.height() / 2.25f);
            border.setStrokeWidth(2);
            border.setStyle(Paint.Style.FILL_AND_STROKE);

            drawText(canvas, border, top, title, Color.argb(255, 255, 255, 255), false, 6);

            if (!nobuttons) {
                drawText(canvas, border, yesClick, yesText, Color.argb(255, 50, 50, 50), true, 6);
                drawText(canvas, border, noClick, noText, Color.argb(255, 50, 50, 50), true, 6);
            }
            border.setTextSize(top.height() / 2.5f);

            drawText(canvas, border, middle, text, Color.argb(255, 50, 50, 50), false, 4);

        }

    }

    private void drawText(Canvas canvas, Paint rc, RectF tab, String res, int color, boolean center, int seed) {
        String text = res;
        rc.setColor(color);

        float wt = rc.measureText(text);
        canvas.drawText(text, center ? tab.centerX() - (wt / 2) : tab.left + tab.width() / 30, tab.centerY() + tab.height() / seed, rc);
    }

    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN && !nobuttons) {
            if (yesClick.contains(event.getX(), event.getY())) {
                yes.run();
            }
            if (noClick.contains(event.getX(), event.getY())) {
                no.run();
            }

        }
        return false;
    }
}
