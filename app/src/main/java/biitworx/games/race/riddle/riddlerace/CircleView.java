package biitworx.games.race.riddle.riddlerace;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by marce_000 on 10.10.2016.
 */
public class CircleView {
    public int ccNext = 20;
    public Paint carLine = new Paint();
    public Paint carLine2 = new Paint();

    private int position = 0;
    private float mover = 6;
    private int posx = 0;
    private int posy = 0;
    private int direction = 0;

    public boolean hit = false;
    private int length = 1;
    private int count = 1;
    public int round = 0;
    public int red;
    public int green;
    public int blue;
    public int inverse = 0;
    public boolean rr = false;
    public boolean crashed = false;
public boolean simulate=false;
    private int fak = 2;


    public CircleView(PlacementCircleView view, int red, int green, int blue, int speed, int positionx, int positiony, int direction, int length, int inverse, int position, int next, int faktor) {

        carLine.setStyle(Paint.Style.FILL);
        carLine.setAntiAlias(true);

        carLine2.setStyle(Paint.Style.STROKE);
        carLine2.setAntiAlias(true);
        carLine2.setColor(Color.argb(128, 50, 50, 50));
        carLine2.setStrokeWidth(1);
        if (faktor < 3)
            faktor = 3;

        this.red = red;
        this.green = green;
        this.blue = blue;
        this.mover = speed;
        this.posx = positionx;
        this.posy = positiony;
        this.direction = direction;
        this.length = length;
        this.inverse = inverse;
        this.position = position;
        this.ccNext = next;
        this.fak = faktor;
    }


    public void drawMe(Canvas canvas, int count) {
        Rect rc = canvas.getClipBounds();

        int seed = rc.width() / 40;

        rc = new Rect(rc.left + seed * fak, rc.top + seed * fak, rc.right - seed * fak, rc.bottom - seed * fak);
        PlacementCircleView.line(this, rc);
        int color = 200;
        if (hit) {
            color = 255;
        }
        carLine.setColor(Color.argb(color,
                red
                , green
                , blue));
        if (direction == 0) {
            rc.top += (rc.height() / 100) * posy;

            rc.left += (rc.width() / 100) * posx;

            rc.bottom += (rc.height() / 100) * posy;

            rc.right += (rc.width() / 100) * posx;
        } else if (direction == 1) {
            rc.top -= (rc.height() / 100) * posy;

            rc.left -= (rc.width() / 100) * posx;
            rc.bottom -= (rc.height() / 100) * posy;

            rc.right -= (rc.width() / 100) * posx;
        } else if (direction == 2) {
            rc.top -= (rc.height() / 100) * posy;

            rc.left += (rc.width() / 100) * posx;
            rc.bottom -= (rc.height() / 100) * posy;

            rc.right += (rc.width() / 100) * posx;
        } else if (direction == 3) {
            rc.top += (rc.height() / 100) * posy;

            rc.left -= (rc.width() / 100) * posx;
            rc.bottom += (rc.height() / 100) * posy;

            rc.right -= (rc.width() / 100) * posx;
        } else if (direction == 4) {

            rc.left -= (rc.width() / 100) * posx;


            rc.right -= (rc.width() / 100) * posx;
        } else if (direction == 5) {
            rc.top -= (rc.height() / 100) * posy;


            rc.bottom -= (rc.height() / 100) * posy;


        } else if (direction == 6) {

            rc.left += (rc.width() / 100) * posx;


            rc.right += (rc.width() / 100) * posx;
        } else if (direction == 7) {
            rc.top += (rc.height() / 100) * posy;


            rc.bottom += (rc.height() / 100) * posy;


        }
        int distance = rc.width() / 20;
        int distance2 = rc.width() / 30;


        float rad = 1.65f;
        Rect rc2 = new Rect(rc.left - (int) ((distance) * rad),
                rc.top - (int) ((distance) * rad),
                rc.right + (int) ((distance) * rad),
                rc.bottom + (int) ((distance) * rad));

        int p = position;
        if (count == 0) {
            for (int i = 0; i < length; i++) {
                Rect rc1 = drawWithDegree(p, distance2, rc2);

                if (!crashed)
                    canvas.drawCircle(rc1.centerX(), rc1.centerY(), rc1.height() / 1.85f, carLine);

                //canvas.drawCircle(rc1.centerX(), rc1.centerY(), rc1.height() / 1.85f, carLine2);

                PlacementCircleView.circle(this, rc1);

                p -= 5f;
            }
        }

    }


    public void hitMe() {
        hit = !hit;
        if (!hit) {
            if (new Random().nextInt(5) == 3) {
                inverse = inverse == 0 ? 1 : 0;
            }
        }
    }

    public void move() {
        if (hit) {
            float mm = 1f;
            if (inverse == 0) {
                position += mm;
            } else {
                position -= mm;

            }

        } else {
            if (inverse == 0) {
                position += (1f) * mover;

            } else {
                position -= (1f) * mover;

            }
        }
        if (inverse == 0) {
            if (position > 360) {

                round++;
                rr = true;
                position = 0;
                if (length < ccNext * 3 && count > ccNext &&!simulate) {
                    length += 1;
                    count = 1;
                    mover += 0.25f;
                }
                PlacementCircleView.rounds++;

                count++;
            }
        } else {
            if (position < 0) {
                round++;
                rr = true;
                position = 360;
                if (length < ccNext * 3 && count > ccNext&&!simulate) {
                    length += 1;
                    count = 1;
                    mover += 0.25f;
                }
                PlacementCircleView.rounds++;

                count++;
            }
        }

        if(simulate){
            if(round>99){
                round=99;
            }
            if( PlacementCircleView.rounds>99){
                PlacementCircleView.rounds=99;
            }
        }

    }


    private Rect drawWithDegree(int degree, float size, Rect display) {
        float xc1 = (float) Math.sin(Math.toRadians(degree)) * (float) (display.width() / 3.5);
        float yc1 = (float) Math.cos(Math.toRadians(degree)) * (float) (display.width() / 3.5);
        float x = display.exactCenterX() + xc1;
        float y = display.exactCenterY() - yc1;

        float w = (float) (size / 1.1);
        Rect rc = new Rect((int) (x - w / 2), (int) (y - w / 2), (int) (x + w / 2), (int) (y + w / 2));

        return rc;
    }

}
