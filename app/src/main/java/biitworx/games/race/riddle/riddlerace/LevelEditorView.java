package biitworx.games.race.riddle.riddlerace;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import biitworx.games.race.riddle.riddlerace.data.helper.poco.Circle;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.Level;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.LevelSet;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.Levels;

/**
 * Created by marcel.weissgerber on 18.10.2016.
 */

public class LevelEditorView extends View {

    private HashMap<Point, Circle> circles = new HashMap<>();
    private HashMap<Point, RectF> clicker = new HashMap<>();
    private ArrayList<Point> added = new ArrayList<>();
    public int greenLight = Color.argb(255, 100, 175, 130);
    public int green = Color.argb(255, 50, 130, 70);
    public int blueLight = Color.argb(255, 100, 160, 190);
    public int blue = Color.argb(255, 50, 100, 130);
    public int grayLight = Color.argb(255, 180, 180, 180);
    public int gray = Color.argb(255, 120, 120, 120);
    public Point active = null;
    public LevelEditor view;
    public int tab = 0;
    public ArrayList<IntegerProperty> properties = new ArrayList<>();
    RectF tab0;
    RectF tab1;
    RectF tab2;

    RectF button0;
    RectF button1;
    RectF button2;
    PlacementCircleView place = null;
    Level level = new Level("unknown", 10, 20, 30, "");

    public int max = 8;

    public LevelEditorView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas) {
        Rect inner = canvas.getClipBounds();

        Paint back = new Paint();
        back.setStyle(Paint.Style.FILL);
        back.setColor(Color.argb(255, 255, 240, 220));

        int h = inner.height() / 20;
        int w = inner.width() / 4;

        canvas.drawRect(inner, back);

        back.setShader(new BitmapShader(MainMenu.back002, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR));
        canvas.drawRect(inner, back);


        RectF position = new RectF(inner.left + w / 4, inner.top + h * 4, inner.right - w / 4, inner.top + h * 17.5f);
        //RectF editor = new RectF(inner.left + w / 4, inner.top + h * 11, inner.right - w / 4, inner.top + h * 19);

        RectF tabs = new RectF(inner.left + w / 4, inner.top + h * 2, inner.right - w / 4, inner.top + h * 4);
        RectF delete = new RectF(inner.left + w / 4, inner.top + h * 18, inner.right - w / 4, inner.top + h * 19.5f);

        RectF topper = new RectF(inner.left + w / 4, inner.top + h * 0, inner.right - w / 4, inner.top + h * 2);


        float tw = tabs.width() / 10;
        tab0 = new RectF(tabs.left + tw * 0, tabs.top, tabs.left + tw * 2.85f, tabs.bottom);
        tab2 = new RectF(tabs.left + tw * 3f, tabs.top, tabs.left + tw * 5.85f, tabs.bottom);
        tab1 = new RectF(tabs.left + tw * 6f, tabs.top, tabs.left + tw * 10, tabs.bottom);

        button0 = new RectF(delete.left + tw * 0, delete.top, delete.left + tw * 3, delete.bottom);
        button1 = new RectF(delete.left + tw * 3.5f, delete.top, delete.left + tw * 6.5f, delete.bottom);
        button2 = new RectF(delete.left + tw * 7, delete.top, delete.left + tw * 10, delete.bottom);


        Paint rc = new Paint();
        rc.setStyle(Paint.Style.FILL);
        rc.setColor(Color.argb(20, 0, 0, 0));
        float cw = position.width() / 30;

        canvas.drawRoundRect(position, 0, 0, rc);
        rc.setColor(Color.argb(40, 25, 90, 90));

        canvas.drawRoundRect(tab0, 0, 0, rc);
        canvas.drawRoundRect(tab1, 0, 0, rc);
        canvas.drawRoundRect(tab2, 0, 0, rc);


        rc.setColor(Color.argb(128, 255, 255, 255));
        canvas.drawRoundRect(button0, cw, cw, rc);
        canvas.drawRoundRect(button1, cw, cw, rc);
        canvas.drawRoundRect(button2, cw, cw, rc);

        rc.setShader(new RadialGradient(delete.centerX(), delete.centerY(), delete.width(), blueLight, blue, Shader.TileMode.MIRROR));
        canvas.drawRoundRect(button0, cw, cw, rc);
        canvas.drawRoundRect(button1, cw, cw, rc);
        rc.setShader(new RadialGradient(delete.centerX(), delete.centerY(), delete.width(), greenLight, green, Shader.TileMode.MIRROR));

        canvas.drawRoundRect(button2, cw, cw, rc);
        rc.setShader(new BitmapShader(MainMenu.back002, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR));
        canvas.drawRoundRect(button0, cw, cw, rc);
        canvas.drawRoundRect(button1, cw, cw, rc);
        canvas.drawRoundRect(button2, cw, cw, rc);

        rc.setShader(null);
        rc.setStrokeWidth(3);
        rc.setStyle(Paint.Style.STROKE);
        rc.setColor(Color.argb(255, 25, 90, 90));

        canvas.drawRoundRect(position, 0, 0, rc);
        canvas.drawRoundRect(tab0, 0, 0, rc);
        canvas.drawRoundRect(tab1, 0, 0, rc);
        canvas.drawRoundRect(tab2, 0, 0, rc);

        canvas.drawRoundRect(button0, cw, cw, rc);
        canvas.drawRoundRect(button1, cw, cw, rc);
        canvas.drawRoundRect(button2, cw, cw, rc);

        rc.setStyle(Paint.Style.FILL);


        clicker = getRects(position, 5);


        if (tab == 0) {
            rc.setStyle(Paint.Style.STROKE);


            rc.setStrokeWidth(2);
            for (RectF r : clicker.values()) {
                rc.setStyle(Paint.Style.FILL);
                rc.setColor(Color.argb(100, 50, 50, 50));
                canvas.drawCircle(r.centerX(), r.centerY(), r.width() / 4, rc);
                rc.setStyle(Paint.Style.STROKE);
                rc.setColor(Color.argb(255, 0, 0, 0));
                canvas.drawCircle(r.centerX(), r.centerY(), r.width() / 4, rc);
            }
            rc.setStyle(Paint.Style.FILL);

            rc.setColor(Color.argb(100, 50, 50, 50));

            for (Map.Entry<Point, Circle> item : circles.entrySet()) {

                rc.setColor(Color.argb(255, item.getValue().getRed(), item.getValue().getGreen(), item.getValue().getBlue()));
                RectF r = clicker.get(item.getKey());
                canvas.drawCircle(r.centerX(), r.centerY(), r.width() / 4, rc);

            }
        }


        if (active != null) {
            Circle item = circles.get(active);
            rc.setStyle(Paint.Style.FILL);
            rc.setColor(Color.argb(150, item.getRed(), item.getGreen(), item.getBlue()));

            canvas.drawRoundRect(tab1, 0, 0, rc);


        }


        if (tab == 2 && place != null) {
            for (CircleView circleView : place.allViews()) {
                circleView.move();
            }
            place.drawMe(canvas, new Rect((int) position.left, (int) position.top, (int) position.right, (int) position.bottom));


        }

        rc.setStyle(Paint.Style.FILL);

        rc.setColor(Color.argb(200, 50, 70, 70));

        if (tab == 0) {
            canvas.drawRoundRect(tab0, 0, 0, rc);

        }

        if (tab == 1) {
            canvas.drawRoundRect(tab1, 0, 0, rc);

        }

        if (tab == 2) {
            canvas.drawRoundRect(tab2, 0, 0, rc);

        }


        rc.setStyle(Paint.Style.FILL);

        rc.setTextSize(tabs.height() / 3);
        rc.setFakeBoldText(true);
        rc.setAntiAlias(true);

        drawText(canvas, rc, tab0, R.string.menu_editor_board, tab == 0 ? Color.argb(255, 255, 255, 255) : Color.argb(255, 0, 0, 0));
        drawText(canvas, rc, tab1, R.string.menu_editor_properties, tab == 1 ? Color.argb(255, 255, 255, 255) : Color.argb(255, 0, 0, 0));
        drawText(canvas, rc, tab2, R.string.menu_editor_preview, tab == 2 ? Color.argb(255, 255, 255, 255) : Color.argb(255, 0, 0, 0));


        drawText(canvas, rc, button0, R.string.menu_editor_back, Color.argb(255, 0, 0, 0));
        drawText(canvas, rc, button1, R.string.menu_editor_delete, Color.argb(255, 0, 0, 0));
        drawText(canvas, rc, button2, R.string.menu_editor_save, Color.argb(255, 0, 0, 0));
        rc.setTextSize(topper.height() / 2);
        drawText(canvas, rc, topper, R.string.menu_editor, Color.argb(255, 0, 0, 0));

        if (tab == 1) {
            rc.setTextSize(topper.height() / 3);

            if (active != null) {

                Circle item = circles.get(active);
                drawColor(R.string.editor_value_color, new RectF(position.left, position.top + h * 1, position.right, position.top + h * 3), rc, canvas, Color.argb(150, item.getRed(), item.getGreen(), item.getBlue()));
                drawValue(R.string.editor_value_speed, new RectF(position.left, position.top + h * 3, position.right, position.top + h * 5), rc, canvas, String.valueOf(item.getMover()), 1, 20, 0, 1);
                drawValue(R.string.editor_value_length, new RectF(position.left, position.top + h * 5, position.right, position.top + h * 7), rc, canvas, String.valueOf(item.getLength()), 1, 5, 1, 1);
                drawValue(R.string.editor_value_postion, new RectF(position.left, position.top + h * 7, position.right, position.top + h * 9), rc, canvas, String.valueOf(item.getPosition()), 0, 360, 2, 10);
                drawValue(R.string.editor_value_inverse, new RectF(position.left, position.top + h * 9, position.right, position.top + h * 11), rc, canvas, String.valueOf(item.getInverse()), 0, 1, 3, 1);
                drawValue(R.string.editor_value_next, new RectF(position.left, position.top + h * 11, position.right, position.top + h * 13), rc, canvas, String.valueOf(item.getNext()), 5, 30, 4, 1);

            } else {

                drawValue(R.string.editor_level_name, new RectF(position.left, position.top + h * 1, position.right, position.top + h * 3), rc, canvas, String.valueOf(level.getName()), 1, 5, -1, 1);
                drawValue(R.string.editor_level_min, new RectF(position.left, position.top + h * 3, position.right, position.top + h * 5), rc, canvas, String.valueOf(level.getMin()), 10, 200, 6, 10);
                drawValue(R.string.editor_level_med, new RectF(position.left, position.top + h * 5, position.right, position.top + h * 7), rc, canvas, String.valueOf(level.getMed()), level.getMin() + 10, 250, 7, 10);
                drawValue(R.string.editor_level_max, new RectF(position.left, position.top + h * 7, position.right, position.top + h * 9), rc, canvas, String.valueOf(level.getMax()), level.getMed() + 10, 300, 8, 10);

            }

        }

    }

    private void drawColor(int id, RectF rc, Paint p, Canvas canvas, int color) {
        RectF rc1 = new RectF(rc.left, rc.top, rc.left + rc.width() / 3, rc.bottom);
        RectF rc2 = new RectF(rc.left + rc.width() / 3, rc.top, rc.right, rc.bottom);

        float seed = rc.width() / 10;
        rc2 = new RectF(rc2.left + seed, rc2.top - seed / 4, rc2.right - seed, rc2.bottom - seed / 4);


        drawText(canvas, p, rc1, id, Color.argb(255, 50, 50, 50));
        int old = p.getColor();
        Paint.Style st = p.getStyle();
        p.setColor(color);
        p.setStyle(Paint.Style.FILL);
        canvas.drawRect(rc2, p);
        p.setStyle(st);
        p.setColor(old);
    }

    private void drawValue(int id, RectF rc, Paint p, Canvas canvas, String value, int min, int max, int art, int step) {
        RectF rc1 = new RectF(rc.left, rc.top, rc.left + rc.width() / 3, rc.bottom);
        RectF rc2 = new RectF(rc.left + rc.width() / 3, rc.top, rc.right - rc.width() / 3, rc.bottom);
        RectF rc3 = new RectF(rc.right - rc.width() / 3, rc.top, rc.right, rc.bottom);


        drawText(canvas, p, rc1, id, Color.argb(255, 50, 50, 50));
        drawText(canvas, p, rc2, value, Color.argb(255, 50, 50, 50));

        if (art >= 0) {

            float w = rc3.width() / 20;
            RectF rcPlus = new RectF(rc3.left + w, rc3.top + w / 4, (rc3.right - rc3.width() / 2) - w, rc3.bottom - w / 4);

            RectF rcMinus = new RectF((rc3.right - rc3.width() / 2) + w, rc3.top + w / 4, rc3.right - w, rc3.bottom - w / 4);
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(2);
            canvas.drawRoundRect(rcPlus, w, w, p);
            canvas.drawRoundRect(rcMinus, w, w, p);
            p.setStyle(Paint.Style.FILL);

            drawText(canvas, p, rcPlus, "+", Color.argb(255, 50, 50, 50));
            drawText(canvas, p, rcMinus, "-", Color.argb(255, 50, 50, 50));

            properties.add(new IntegerProperty(rcMinus, rcPlus, min, max, art, step));

        }

    }

    private void drawText(Canvas canvas, Paint rc, RectF tab, int res, int color) {
        String text = TE.get(res);
        drawText(canvas, rc, tab, text, color);
    }

    private void drawText(Canvas canvas, Paint rc, RectF tab, String res, int color) {
        String text = res;
        rc.setColor(color);
        float wt = rc.measureText(text);
        canvas.drawText(text, tab.centerX() - wt / 2, tab.centerY() + tab.height() / 10, rc);
    }

    private HashMap<Point, RectF> getRects(RectF inner, int size) {
        HashMap<Point, RectF> result = new HashMap<>();
        float left = inner.left;
        float top = inner.top;
        float width = inner.width() / size;
        float height = inner.height() / size;

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                result.put(new Point(x, y), new RectF(left, top, left + width, top + height));
                left += width;

            }
            top += height;
            left = inner.left;
        }
        return result;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            if (tab0.contains(event.getX(), event.getY())) {
                tab = 0;
            }
            if (tab1.contains(event.getX(), event.getY())) {
                if (tab == 2)
                    tab = 0;
                else
                    tab = 1;
            }
            if (tab2.contains(event.getX(), event.getY())) {
                tab = 2;
                place = new PlacementCircleView(getContext(), "");
                place.start(level);
                place.simulate = true;
                for (Circle c : circles.values()) {
                    CircleView cc = new CircleView(place, c.getRed(), c.getGreen(), c.getBlue(), c.getMover() * 4, c.getPosx(), c.getPosy(), c.getDirection(), c.getLength(), c.getInverse(), c.getPosition(), c.getNext(), c.getFaktor() * 5);
                    cc.simulate = true;
                    place.addAll(cc);
                }
            }

            if (tab == 2) {
                place.onTouchEvent(event);
            }

            if (tab == 1) {
                for (IntegerProperty ii : properties) {
                    if (ii.hit(event.getX(), event.getY()))
                        break;
                }
            }

            if (button1.contains(event.getX(), event.getY())) {
                tab = 0;
                if (added.size() > 0) {
                    Point p = added.get(added.size() - 1);
                    added.remove(p);
                    circles.remove(p);
                    active = null;
                }
            }

            if (button0.contains(event.getX(), event.getY())) {
                view.finish();
            }


            if (button2.contains(event.getX(), event.getY())) {
                LevelSet s = Levels.getSet(TE.get(R.string.bundle_basic));

                level.setName("Level " + String.valueOf(s.getLevels().size() + 1) + " - " + level.getName());
                for (Circle c : circles.values()) {
                    level.add(c);
                }
                s.add(level);

                Levels.updateLevel(level, true);
                place.start(null);
                view.finish();
            }
            if (tab == 0) {
                for (Map.Entry<Point, RectF> item : clicker.entrySet()) {
                    if (item.getValue().contains(event.getX(), event.getY()) && !circles.containsKey(item.getKey())) {
                        if (add(item.getKey(), item.getValue()))
                            active = item.getKey();
                    } else {

                        if (item.getValue().contains(event.getX(), event.getY()) && circles.containsKey(item.getKey())) {
                            if (active == null || active.hashCode() != item.getKey().hashCode()) {
                                active = item.getKey();
                                properties.clear();
                            } else {
                                active = null;
                                properties.clear();
                            }

                        }
                    }
                }
            }
        }
        return false;
    }


    private boolean add(Point p, RectF r) {
        int s = circles.size();


        if (s < max) {
            Holder h = getHolder(p);
            circles.put(p, new Circle(getRed(), getGreen(), getBlue(), 2, h.x, h.y, h.direction, 1, 0, 0, 10, 2));
            added.add(p);
            return true;
        }

        return false;
    }

    public int getRed() {
        return getRedArray()[circles.size()];
    }

    public int getGreen() {
        return getGreenArray()[circles.size()];
    }

    public int getBlue() {
        return getBlueArray()[circles.size()];
    }

    public int[] getRedArray() {
        return new int[]{50, 220, 90, 240, 240, 255, 255, 50};
    }

    public int[] getGreenArray() {
        return new int[]{200, 90, 170, 70, 200, 150, 125, 50};
    }

    public int[] getBlueArray() {
        return new int[]{100, 90, 220, 240, 80, 190, 0, 50};
    }


    private Holder getHolder(Point p) {

        //first row
        if (p.x == 0 && p.y == 0) {
            return new Holder(20, 20, 1);

        }
        if (p.x == 1 && p.y == 0) {
            return new Holder(10, 20, 1);

        }
        if (p.x == 2 && p.y == 0) {
            return new Holder(0, 20, 2);

        }
        if (p.x == 3 && p.y == 0) {
            return new Holder(10, 20, 2);

        }
        if (p.x == 4 && p.y == 0) {
            return new Holder(20, 20, 2);

        }
        //second row
        if (p.x == 0 && p.y == 1) {
            return new Holder(20, 10, 1);

        }
        if (p.x == 1 && p.y == 1) {
            return new Holder(10, 10, 1);

        }
        if (p.x == 2 && p.y == 1) {
            return new Holder(0, 10, 2);

        }
        if (p.x == 3 && p.y == 1) {
            return new Holder(10, 10, 2);

        }
        if (p.x == 4 && p.y == 1) {
            return new Holder(20, 10, 2);

        }
        //Third Row
        if (p.x == 0 && p.y == 2) {
            return new Holder(20, 0, 1);

        }
        if (p.x == 1 && p.y == 2) {
            return new Holder(10, 0, 1);

        }
        if (p.x == 2 && p.y == 2) {
            return new Holder(0, 0, 0);
        }
        if (p.x == 3 && p.y == 2) {
            return new Holder(10, 0, 2);
        }
        if (p.x == 4 && p.y == 2) {
            return new Holder(20, 0, 2);

        }
        //Forth Row
        if (p.x == 0 && p.y == 3) {
            return new Holder(20, 10, 3);

        }
        if (p.x == 1 && p.y == 3) {
            return new Holder(10, 10, 3);

        }
        if (p.x == 2 && p.y == 3) {
            return new Holder(0, 10, 3);

        }
        if (p.x == 3 && p.y == 3) {
            return new Holder(10, 10, 0);

        }
        if (p.x == 4 && p.y == 3) {
            return new Holder(20, 10, 0);

        }
        //Fith Row
        if (p.x == 0 && p.y == 4) {
            return new Holder(20, 20, 3);

        }
        if (p.x == 1 && p.y == 4) {
            return new Holder(10, 20, 3);

        }
        if (p.x == 2 && p.y == 4) {
            return new Holder(0, 20, 3);

        }
        if (p.x == 3 && p.y == 4) {
            return new Holder(10, 20, 0);

        }
        if (p.x == 4 && p.y == 4) {
            return new Holder(20, 20, 0);

        }


        return new Holder(0, 0, 0);
    }


    class Holder {
        public Holder(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        int x;
        int y;
        int direction;
    }

    class IntegerProperty {
        RectF rcMin;
        RectF rcMax;
        int property = 0;
        int min;
        int max;
        int step = 1;

        public IntegerProperty(RectF rcMin, RectF rcMax, int min, int max, int art, int step) {
            this.rcMax = rcMax;
            this.rcMin = rcMin;

            this.min = min;
            this.max = max;
            this.property = art;
            this.step = step;
        }


        public boolean hit(float x, float y) {
            int v = getValue();
            if (rcMin.contains(x, y)) {

                if (v > min) {
                    v -= step;
                }
                setValue(v);
                return true;

            } else {
                if (rcMax.contains(x, y)) {

                    if (v < max) {
                        v += step;
                    }
                    setValue(v);
                    return true;
                }
            }
            return false;
        }

        private int getValue() {
            Circle act = active != null ? circles.get(active) : null;
            if (property == 0) return act.getMover();
            if (property == 1) return act.getLength();
            if (property == 2) return act.getPosition();
            if (property == 3) return act.getInverse();
            if (property == 4) return act.getNext();
            if (property == 6) return level.getMin();
            if (property == 7) return level.getMed();
            if (property == 8) return level.getMax();


            return 0;
        }

        private int setValue(int value) {
            Circle act = active != null ? circles.get(active) : null;
            if (property == 0) act.setMover(value);
            if (property == 1) act.setLength(value);
            if (property == 2) act.setPosition(value);
            if (property == 3) act.setInverse(value);
            if (property == 4) act.setNext(value);
            if (property == 6) level.setMin(value);
            if (property == 7) level.setMed(value);
            if (property == 8) level.setMax(value);


            return 0;
        }
    }

}
