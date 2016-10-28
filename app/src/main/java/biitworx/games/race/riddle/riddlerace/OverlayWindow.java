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
    private Runnable ok;

    RectF yesClick;
    RectF noClick;
    RectF okClick;
    RectF close;
    String yesText;
    String noText;
    String title;
    String text;
    String text1;
    String text2;
    String text3;

    Timer timer;
    boolean inverted;
    boolean onlyOk = false;
    boolean blink = false;
    int blinkCol = Color.argb(175, 50, 50, 50);
    int blinker = 0;
    boolean altBlink = false;

    public OverlayWindow(boolean inverted) {
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
        blink = false;

    }


    public void activate(final Runnable yes, String title, String text) {
        blink = true;

        closed = false;
        nobuttons = true;
        this.text = text;
        this.title = title;
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                yes.run();
            }
        }, 500);

    }

    public void okActivate(final Runnable ok, String title, String text, String text1, String text2, String text3) {

        blink = false;

        closed = false;
        onlyOk = true;
        nobuttons = false;
        this.text = text;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;

        this.title = title;
        this.ok = ok;
    }

    public void draw(Canvas canvas) {
        if(blink){
            blinker++;

            if (blinker > 3) {
                blinker = 0;
                if (altBlink) {
                    blinkCol = Color.argb(175, 50, 50, 50);
                } else {
                    blinkCol = Color.argb(175, 50, 100, 100);
                }
                altBlink = !altBlink;
            }
        }

        if (!closed) {
            Paint back = new Paint();
            back.setColor(backColor);
            back.setStyle(Paint.Style.FILL);

            RectF rc = new RectF(canvas.getClipBounds());

            canvas.drawRect(rc, back);


            Paint border = new Paint();
            border.setStyle(Paint.Style.STROKE);
            border.setStrokeWidth(6);
            border.setColor(Color.argb(175, 50, 50, 50));

            int hh = onlyOk ? 6 : 8;

            RectF wnd = new RectF(rc.left + rc.width() / 30, rc.centerY() - rc.height() / hh, rc.right - rc.width() / 30, rc.centerY() + rc.height() / hh);

            RectF top = new RectF(wnd.left, wnd.top, wnd.right, wnd.top + wnd.height() / (onlyOk ? 5 : 4));
            RectF middle = new RectF(wnd.left, wnd.top + wnd.height() / (onlyOk ? 5 : 4), wnd.right, wnd.top + wnd.height() / (onlyOk ? 3 : 2));

            border.setColor(Color.argb(235, 200, 200, 200));

            border.setStyle(Paint.Style.FILL_AND_STROKE);
            border.setShadowLayer(hh * 2, 0, 0, Color.DKGRAY);
            canvas.drawRect(wnd, border);
            if (blink) {
                border.setColor(blinkCol);
            } else {
                border.setColor(Color.argb(175, 50, 50, 50));

            }
            border.setShadowLayer(0, 0, 0, Color.DKGRAY);

            canvas.drawRect(top, border);

            float size = top.width() / 6;
            yesClick = new RectF(top.left + size * 0.5f, wnd.bottom - top.height() * 1.5f, top.left + size * 2.75f, wnd.bottom - top.height() * 0.5f);
            noClick = new RectF(top.left + size * 3.25f, wnd.bottom - top.height() * 1.5f, top.left + size * 5.5f, wnd.bottom - top.height() * 0.5f);
            okClick = new RectF(top.left + size * 1.5f, wnd.bottom - top.height() * 1.5f, top.left + size * 4.5f, wnd.bottom - top.height() * 0.5f);

            float cw = yesClick.height() / 5;
            border.setStrokeWidth(6);
            border.setShadowLayer(hh * 2, 0, 0, Color.DKGRAY);

            border.setStyle(Paint.Style.STROKE);
            if (!nobuttons) {
                if (!onlyOk) {
                    canvas.drawRoundRect(yesClick, cw, cw, border);
                    canvas.drawRoundRect(noClick, cw, cw, border);
                    border.setColor(inverted ? Color.argb(240, 240, 160, 160) : Color.argb(240, 130, 200, 130));

                    border.setStyle(Paint.Style.FILL);
                    canvas.drawRoundRect(yesClick, cw, cw, border);
                    border.setColor(!inverted ? Color.argb(240, 240, 160, 160) : Color.argb(240, 130, 200, 130));

                    border.setStyle(Paint.Style.FILL);
                    canvas.drawRoundRect(noClick, cw, cw, border);
                } else {
                    canvas.drawRoundRect(okClick, cw, cw, border);
                    border.setColor(inverted ? Color.argb(240, 240, 160, 160) : Color.argb(240, 130, 200, 130));
                    border.setStyle(Paint.Style.FILL);
                    canvas.drawRoundRect(okClick, cw, cw, border);
                }

            }
            border.setShadowLayer(0, 0, 0, Color.DKGRAY);
            border.setStyle(Paint.Style.STROKE);
            border.setColor(Color.argb(175, 50, 50, 50));
            canvas.drawRect(wnd, border);


            border.setTextSize(top.height() / 2.25f);
            border.setStrokeWidth(2);
            border.setStyle(Paint.Style.FILL_AND_STROKE);

            drawText(canvas, border, top, title, Color.argb(255, 255, 255, 255), false, 6);

            if (!nobuttons) {
                if (!onlyOk) {
                    drawText(canvas, border, yesClick, yesText, Color.argb(255, 50, 50, 50), true, 6);
                    drawText(canvas, border, noClick, noText, Color.argb(255, 50, 50, 50), true, 6);
                } else {
                    drawText(canvas, border, okClick, "OK", Color.argb(255, 50, 50, 50), true, 6);

                }
            }
            border.setTextSize(top.height() / 2.5f);

            drawText(canvas, border, middle, text, Color.argb(255, 50, 50, 50), false, 4);
            if (onlyOk) {
                drawText(canvas, border, new RectF(middle.left, middle.bottom, middle.right, middle.bottom + middle.height() * 0.75f), text1, Color.argb(255, 50, 50, 50), false, 4);
                drawText(canvas, border, new RectF(middle.left, middle.bottom, middle.right, middle.bottom + middle.height() * 1.75f), text2, Color.argb(255, 50, 50, 50), false, 4);
                drawText(canvas, border, new RectF(middle.left, middle.bottom, middle.right, middle.bottom + middle.height() * 2.75f), text3, Color.argb(255, 50, 50, 50), false, 4);

            }

            if (!nobuttons) {
                close = new RectF(top.right - top.height(), top.top, top.right, top.bottom);

                border.setColor(C.redLight);
                border.setAlpha(200);
                border.setStyle(Paint.Style.FILL);
                canvas.drawCircle(close.centerX(), close.centerY(), close.width() / 3f, border);
                border.setColor(Color.argb(200, 200, 200, 200));
                border.setStrokeWidth(4);
                border.setStyle(Paint.Style.STROKE);
                canvas.drawCircle(close.centerX(), close.centerY(), close.width() / 3f, border);
                border.setStrokeWidth(2);
                border.setFakeBoldText(true);
                border.setStyle(Paint.Style.FILL);
                border.setTextSize(close.height() / 2.8f);
                drawText(canvas, border, close, "X", Color.argb(255, 255, 255, 255), true, 8);
            }
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
            if (!onlyOk) {
                if (yesClick.contains(event.getX(), event.getY())) {
                    blink = true;
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            yes.run();

                        }
                    },500);
                }
                if (noClick.contains(event.getX(), event.getY())) {
                    no.run();
                }
                if (close != null && close.contains(event.getX(), event.getY()) && no != null) {
                    no.run();

                }
            } else {
                if (okClick.contains(event.getX(), event.getY())) {
                    ok.run();
                }
                if (close != null && close.contains(event.getX(), event.getY()) && ok != null) {
                    ok.run();

                }
            }

        }
        return false;
    }
}
