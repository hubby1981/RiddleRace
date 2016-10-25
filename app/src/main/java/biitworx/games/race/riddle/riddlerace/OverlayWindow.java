package biitworx.games.race.riddle.riddlerace;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;

/**
 * Created by marce_000 on 25.10.2016.
 */
public class OverlayWindow {
    int backColor = Color.argb(220, 200, 200, 200);
    public boolean closed = true;

    private Runnable yes;
    private Runnable no;
    RectF yesClick;
    RectF noClick;

    public void activate(Runnable yes, Runnable no) {
        this.yes = yes;
        this.no = no;
        closed = false;
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
            border.setStrokeWidth(3);
            border.setColor(Color.argb(200, 50, 50, 50));
            RectF wnd = new RectF(rc.left + rc.width() / 20, rc.centerY() - rc.height() / 8, rc.right - rc.width() / 20, rc.centerY() + rc.height() / 8);

            canvas.drawRect(wnd, border);
            RectF top = new RectF(wnd.left, wnd.top, wnd.right, wnd.top + wnd.height() / 4);
            border.setStyle(Paint.Style.FILL_AND_STROKE);

            canvas.drawRect(top, border);

            float size = top.width()/6;
            yesClick = new RectF(top.left+size*0.5f,wnd.bottom-top.height()*2,top.left+size*2.75f,wnd.bottom-top.height());
            noClick = new RectF(top.left+size*3.25f,wnd.bottom-top.height()*2,top.left+size*5.5f,wnd.bottom-top.height());

            border.setStyle(Paint.Style.STROKE);
            canvas.drawRect(yesClick, border);
            canvas.drawRect(noClick, border);
            border.setColor(Color.argb(240, 130, 200, 130));
            border.setStyle(Paint.Style.FILL);

            canvas.drawRect(yesClick, border);
            border.setColor(Color.argb(240, 240,160,160));
            border.setStyle(Paint.Style.FILL);
            canvas.drawRect(noClick, border);
        }

    }


    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if(yesClick.contains(event.getX(),event.getY())){
                yes.run();
            }
            if(noClick.contains(event.getX(),event.getY())){
                no.run();
            }

        }
        return false;
    }
}
