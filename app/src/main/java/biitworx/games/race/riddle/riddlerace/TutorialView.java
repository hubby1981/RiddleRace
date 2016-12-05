package biitworx.games.race.riddle.riddlerace;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by marce on 12.11.2016.
 */

public class TutorialView extends View {

    private boolean move = false;
    private String text1 = "Test";
    private Storyboard storyboard = new Storyboard();

    public TutorialView(Context context, AttributeSet attrs) {
        super(context, attrs);


        place = new PlacementCircleView(getContext(), "Tutorial");
        place.start(null);
        place.simulate = true;


        storyboard.add(createTask(new Runnable() {
            @Override
            public void run() {
                LevelEditorView.Holder h = LevelEditorView.getHolder(new Point(0, 3));
                place.addAll(createView(C.getRedArray()[0], C.getGreenArray()[0], C.getBlueArray()[0], 1, h.x, h.y, h.direction, 1, 0, 270, 0, 2, 0));
                text1 = "First Circle";

            }
        }, 5));
        storyboard.add(createTask(new Runnable() {
            @Override
            public void run() {
                LevelEditorView.Holder h = LevelEditorView.getHolder(new Point(4, 3));

                place.addAll(createView(C.getRedArray()[1], C.getGreenArray()[1], C.getBlueArray()[1], 1, h.x, h.y, h.direction, 1, 1, 90, 0, 2, 0));
                text1 = "Second Circle";


            }
        }, 10));

        storyboard.add(createTask(new Runnable() {
            @Override
            public void run() {
                move = true;
                text1 = "";

            }
        }, 30));


        storyboard.add(1,new Frame(new Runnable() {
            @Override
            public void run() {
                text1 = "Tutorial begins in 5 Seconds";
            }
        },0));
        storyboard.add(1,new Frame(new Runnable() {
            @Override
            public void run() {
                text1 = "Tutorial begins in 4 Seconds";
            }
        },1));
        storyboard.add(1,new Frame(new Runnable() {
            @Override
            public void run() {
                text1 = "Tutorial begins in 3 Seconds";
            }
        },2));
        storyboard.add(1,new Frame(new Runnable() {
            @Override
            public void run() {
                text1 = "Tutorial begins in 2 Seconds";
            }
        },3));
        storyboard.add(1,new Frame(new Runnable() {
            @Override
            public void run() {
                text1 = "Tutorial begins in 1 Second";
            }
        },4));
        storyboard.play(0);
    }

    public Tutorial view;

    private PlacementCircleView place;

    private CircleView createView(int red, int green, int blue, int speed, int posx, int posy, int direction, int length, int inverse, int degree, int next, int faktor, int freaky) {
        int ff = faktor + 8;
        if (ff > 10) {
            int fk = 10;
            ff -= fk;
            fk += ff / 2;
            ff = fk;
        }
        CircleView result = new CircleView(place, red, green, blue, speed * 4, posx, posy, direction, length, inverse, degree, next, ff, freaky);
        result.simulate = true;
        return result;
    }

    private Frame createTask(final Runnable r, long when) {

        return new Frame(r, when);
    }


    @Override
    public void onDraw(Canvas canvas) {


        int top = BG.buildStdBackground(canvas, canvas.getClipBounds());


        RectF inner = new RectF(canvas.getClipBounds());

        RectF title = new RectF(inner.left, inner.top + inner.height() / 10, inner.right, inner.top + (inner.height() / 10) * 2);
        RectF texte = new RectF(inner.left, title.bottom, inner.right, title.bottom + (inner.height() / 10));

        Paint text = new Paint();
        text.setTextSize(title.height() / 3f);
        text.setFakeBoldText(true);
        text.setStyle(Paint.Style.FILL);
        BG.drawText(canvas, text, title, TE.get(R.string.tutorial_title), Color.argb(255, 50, 50, 50), true, 1.5f);

        text.setTextSize(title.height() / 4f);

        BG.drawText(canvas, text, texte, text1, Color.argb(255, 50, 50, 50), true, 5f);

        Rect content = new Rect((int) (inner.left + inner.width() / 10), (int) (inner.top + (inner.height() / 10) * 3), (int) (inner.right - inner.width() / 10), (int) (inner.bottom - (inner.height() / 10) * 1));

        if (place != null) {
            if (move == true)
                for (CircleView circleView : place.allViews()) {
                    circleView.move();
                }
            place.drawMe(canvas, content);
        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {


        if (place != null)
            place.onTouchEvent(event);
        return true;
    }

}
