package biitworx.games.race.riddle.riddlerace;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import biitworx.games.race.riddle.riddlerace.data.helper.poco.Level;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.Levels;

/**
 * Created by marce_000 on 10.10.2016.
 */
public class PlacementCircleView extends View {
    private Paint circleLine = new Paint();
    private Paint circleLine2 = new Paint();

    private Paint back = new Paint();
    private static HashMap<CircleView, Rect> lines = new HashMap<>();
    private static HashMap<CircleView, List<Rect>> circles = new HashMap<>();
    public String name = "";
    private static List<CircleView> all = new ArrayList<>();
    private static boolean flushed = false;
    private HashMap<CircleView, Rect> hiter = new HashMap<>();

    public static int rounds = 0;

    public static boolean crashed = false;
    private MainView view;
    public int count = 3;
    private Canvas mCanvas;
    public Level level;
    public CrashedView crashedView = new CrashedView();

    public PlacementCircleView(Context context, String name) {
        super(context);
        circleLine.setStyle(Paint.Style.STROKE);
        circleLine.setAntiAlias(true);
        circleLine.setColor(Color.argb(128, 255, 255, 255));
        circleLine2.setStyle(Paint.Style.STROKE);
        circleLine2.setAntiAlias(true);

        this.name = name;
        back.setStyle(Paint.Style.FILL);
        back.setColor(Color.argb(255, 255, 240, 220));


    }

    public void setView(MainView view) {
        this.view = view;
    }


    public void onDraw(Canvas canvas) {
        if (crashed) {
            if (rounds >= level.getMin()) {
                back.setColor(Color.argb(255, 220, 255, 220));

            } else {
                back.setColor(Color.argb(255, 255, 220, 220));

            }
        }
        mCanvas = canvas;
        hiter.clear();
        Rect outer=canvas.getClipBounds();
        int seed=outer.width()/40;
        Rect inner = new Rect(outer.left+seed,outer.top+seed,outer.right-seed,outer.bottom-seed);

        canvas.drawRect(inner, back);

        circleLine2.setStrokeWidth(2f);
        circleLine2.setColor(Color.argb(255, 50, 50, 50));

        circleLine.setStrokeWidth(inner.width() / 30);


        for (Map.Entry<CircleView, Rect> item : lines.entrySet()) {
            Rect rc = item.getValue();
            int color = 40;
            //circleLine2.setColor(item.getKey().carLine.getColor());

            if (item.getKey().rr) {
                item.getKey().rr = false;

            }
            if (item.getKey().hit) {

                color = 150;
            }
            if (crashed && color == 40)
                color = 20;

            circleLine.setColor(Color.argb(color, item.getKey().red, item.getKey().green, item.getKey().blue));
            canvas.drawCircle(rc.exactCenterX(), rc.exactCenterY(), rc.width() / 3f, circleLine);
            circleLine.setColor(Color.argb(color / 2, 255, 255, 255));
            canvas.drawCircle(rc.exactCenterX(), rc.exactCenterY(), rc.width() / 3f, circleLine);

            //canvas.drawCircle(rc.exactCenterX(), rc.exactCenterY(), rc.width() / 3.175f, circleLine2);
            //canvas.drawCircle(rc.exactCenterX(), rc.exactCenterY(), rc.width() / 2.85f, circleLine2);

        }


        if (allViews().size() > 0) {
            Rect rcBottom = new Rect(inner.left, inner.bottom - inner.height() / 10, inner.right, inner.bottom);
            int w = rcBottom.width() / allViews().size();
            int index = 0;

            Rect rcTop = new Rect(inner.left, inner.top, inner.right, inner.top + inner.height() / 10);

            Paint p1 = new Paint();
            canvas.drawRect(rcTop, back);
            canvas.drawRect(rcBottom, back);

            p1.setStyle(Paint.Style.STROKE);
            p1.setTextSize(rcTop.height() / 3);
            p1.setColor(Color.DKGRAY);
            p1.setFakeBoldText(true);
            p1.setAntiAlias(true);
            String text = name;
            float wt = p1.measureText(text);
            canvas.drawText(text, rcTop.exactCenterX() - wt / 2, rcTop.exactCenterY(), p1);
            text = "Lap: " + String.valueOf(rounds) + " / " + String.valueOf(level.getMin());
            float wt2 = p1.measureText(text);
            canvas.drawText(text, rcTop.exactCenterX() - wt2 / 2, rcTop.exactCenterY() + p1.getTextSize(), p1);
            for (CircleView v : allViews()) {
                Rect rc = new Rect(rcBottom.left + (index * w), rcBottom.top, rcBottom.left + ((index + 1) * w), rcBottom.bottom);
                hiter.put(v, rc);
                //canvas.drawRect(rc, v.carLine);
                int si = allViews().size() > 3 ? 8 : allViews().size() > 2 ? 12 : 16;
                int w1 = rc.width() / si;
                int h1 = rc.height() / 4;
                if (v.hit && !crashed) {
                    Path pp = new Path();

                    pp.moveTo(rc.centerX() + w1, rc.centerY());
                    pp.lineTo(rc.centerX() - w1, rc.centerY() - h1);
                    pp.lineTo(rc.centerX() - w1, rc.centerY() + h1);
                    pp.moveTo(rc.centerX() + w1, rc.centerY());
                    pp.close();
                    canvas.drawPath(pp, v.carLine);
                } else {
                    Rect rc1 = new Rect(rc.centerX() - w1, rc.centerY() - h1, rc.centerX() - w1 / 4, rc.centerY() + h1);
                    Rect rc2 = new Rect(rc.centerX() + w1 / 4, rc.centerY() - h1, rc.centerX() + w1, rc.centerY() + h1);

                    canvas.drawRect(rc1, v.carLine);
                    canvas.drawRect(rc2, v.carLine);
                }

                Paint p = new Paint();
                p.setStyle(Paint.Style.STROKE);
                p.setTextSize(rc.height() / 4);
                p.setColor(v.carLine.getColor());
                p.setFakeBoldText(true);
                p.setAntiAlias(true);
                String tt = String.valueOf(v.round);
                float tw = p.measureText(tt);
                canvas.drawText(tt, rc.exactCenterX() - tw / 2, rc.top - p.getStrokeWidth() * 8, p);

                index++;
            }

        }

        if (count > 0) {
            String cc = String.valueOf(count);
            Paint p2 = new Paint();
            p2.setStyle(Paint.Style.STROKE);
            p2.setTextSize(inner.height() / 3);
            p2.setColor(Color.argb(75, 50, 50, 50));
            p2.setFakeBoldText(true);
            p2.setAntiAlias(true);

            float cm = p2.measureText(cc);
            canvas.drawText(cc, inner.exactCenterX() - cm / 2, inner.exactCenterY() + cm / 2, p2);
        }

        if (crashed) {

            crashedView.onDraw(canvas);
        } else {
            for (CircleView v : allViews()) {

                v.drawMe(canvas);
            }
        }
    }


    public static void line(CircleView view, Rect rc) {
        lines.put(view, rc);
    }

    public static void circle(CircleView view, Rect rc) {
        if (!flushed) {
            flushViews();
            flushed = true;
        }
        List<Rect> l = new ArrayList<>();
        if (circles.containsKey(view)) {
            l = circles.get(view);
        } else {

            circles.put(view, l);
        }
        l.add(rc);
    }

    public static void flushViews() {
        circles.clear();
    }

    public void start(Level levelItem) {
        for (CircleView v : all)
            v.crashed = false;
        circles.clear();
        lines.clear();
        rounds = 0;
        all.clear();
        flushed = false;
        crashed = false;
        level = levelItem;

    }

    public static void all(CircleView view) {
        all.add(view);
    }

    public void addAll(CircleView view) {
        all.add(view);
    }

    public boolean hasHit() {

        if (circles.size() > 0) {
            for (Map.Entry<CircleView, List<Rect>> item : circles.entrySet()) {

                for (Map.Entry<CircleView, List<Rect>> item2 : circles.entrySet()) {
                    if (item != item2) {
                        for (Rect r : item.getValue()) {
                            for (Rect r1 : item2.getValue()) {
                                if (r1.contains((int) r.exactCenterX(), (int) r.exactCenterY())) {
                                    item.getKey().hit = true;
                                    item2.getKey().hit = true;

                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        flushed = false;
        return false;
    }


    public List<CircleView> allViews() {
        return all;
    }


    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            if (count == 0) {
                if (!crashed) {

                    for (Map.Entry<CircleView, Rect> item : hiter.entrySet()) {
                        if (item.getKey().hit && !item.getValue().contains(x, y))
                            return false;
                    }

                    for (Map.Entry<CircleView, Rect> item : hiter.entrySet()) {
                        if (item.getValue().contains(x, y)) {
                            item.getKey().hitMe();
                        }
                    }
                } else {

                    if (crashedView.isRetry(x, y)) {


                        retryIt();
                    }

                    if (crashedView.isNext(x, y)) {

                        if (level.getScore() >= level.getMin()) {
                            Level next = Levels.getLevel(level.getNext());
                            if (next != null) {
                                LevelChooser.that.openActivity(next);
                            }
                        } else {
                            retryIt();
                        }
                    }

                    clean();

                }
            }
        }
        return false;
    }

    private void clean() {
        if (view != null)
            view.finish();
        start(null);
        count = 3;
    }

    private void retryIt() {
        LevelChooser.that.openActivity(level);
    }
}
