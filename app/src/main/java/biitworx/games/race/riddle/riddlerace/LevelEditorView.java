package biitworx.games.race.riddle.riddlerace;

import android.content.Context;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import biitworx.games.race.riddle.riddlerace.data.helper.poco.Circle;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.Level;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.LevelSet;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.Levels;

/**
 * Created by marcel.weissgerber on 18.10.2016.
 */

public class LevelEditorView extends View {


    private HashMap<Point, RectF> clicker = new HashMap<>();

    public Point active = null;
    public LevelEditor view;
    public int tab = 0;
    public ArrayList<Property> properties = new ArrayList<>();
    public boolean stop = false;
    public boolean props = true;
    RectF tab0;
    RectF tab1;
    RectF tab2;
    RectF tab3;
    RectF tab4;

    RectF button0;
    RectF button1;
    RectF button2;
    RectF button3;

    RectF editProp = null;
    PlacementCircleView place = null;
    Level level = MainMenu.levelItem;

    public int max = 10;
    public int mm = 0;
    private OverlayWindow overlay = new OverlayWindow(true);

    public LevelEditorView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas) {


        Rect inner = canvas.getClipBounds();

        if (active == null && level != null && level.getCircles().size() > 0) {
            active = level.getCircles().get(level.getCircles().size() - 1).getPoint();
        }

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

        RectF tabs = new RectF(inner.left + w / 4, inner.top + h * 2.25f, inner.right - w / 4, inner.top + h * 4);
        RectF delete = new RectF(inner.left + w / 4, inner.top + h * 18, inner.right - w / 4, inner.top + h * 19.5f);

        RectF topper = new RectF(inner.left + w / 4, inner.top + h * 0, inner.right - w / 4, inner.top + h * 2);


        float tw = tabs.width() / 12;
        tab0 = new RectF(tabs.left + tw * 0, tabs.top, tabs.left + tw * 2.85f, tabs.bottom);
        tab2 = new RectF(tabs.left + tw * 3f, tabs.top, tabs.left + tw * 5.85f, tabs.bottom);
        tab1 = new RectF(tabs.left + tw * 6f, tabs.top, tabs.left + tw * 8.5f, tabs.bottom);
        tab3 = new RectF(tabs.left + tw * 8.65f, tabs.top, tabs.left + tw * 10.65f, tabs.bottom);
        tab4 = new RectF(tabs.left + tw * 10.8f, tabs.top, tabs.left + tw * 12, tabs.bottom);

        tw = tabs.width() / 13;
        button0 = new RectF(delete.left + tw * 0, delete.top, delete.left + tw * 3, delete.bottom);
        button1 = new RectF(delete.left + tw * 3.25f, delete.top, delete.left + tw * 6.375f, delete.bottom);
        button2 = new RectF(delete.left + tw * 6.575f, delete.top, delete.left + tw * 9.75f, delete.bottom);
        button3 = new RectF(delete.left + tw * 10f, delete.top, delete.left + tw * 13, delete.bottom);


        Paint rc = new Paint();
        rc.setStyle(Paint.Style.FILL);
        rc.setColor(Color.argb(20, 0, 0, 0));
        float cw = position.width() / 30;

        canvas.drawRoundRect(position, 0, 0, rc);
        rc.setColor(Color.argb(40, 25, 90, 90));


           BG.drawPathTab(canvas, tab0, rc);
           BG.drawPathTab(canvas, tab1, rc);
           BG.drawPathTab(canvas, tab2, rc);
           BG.drawPathTab(canvas, tab3, rc);
           BG.drawPathTab(canvas, tab4, rc);

        rc.setColor(Color.argb(128, 255, 255, 255));
        canvas.drawRoundRect(button0, cw, cw, rc);
        canvas.drawRoundRect(button1, cw, cw, rc);
        canvas.drawRoundRect(button2, cw, cw, rc);

        rc.setShader(new RadialGradient(delete.centerX(), delete.centerY(), delete.width(), C.blueLight, C.blue, Shader.TileMode.MIRROR));
        canvas.drawRoundRect(button0, cw, cw, rc);
        canvas.drawRoundRect(button1, cw, cw, rc);
        rc.setShader(new RadialGradient(delete.centerX(), delete.centerY(), delete.width(), C.greenLight, C.green, Shader.TileMode.MIRROR));

        canvas.drawRoundRect(button2, cw, cw, rc);
        rc.setShader(new RadialGradient(delete.centerX(), delete.centerY(), delete.width(), C.redLight, C.red, Shader.TileMode.MIRROR));

        canvas.drawRoundRect(button3, cw, cw, rc);

        rc.setShader(new BitmapShader(MainMenu.back002, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR));
        canvas.drawRoundRect(button0, cw, cw, rc);
        canvas.drawRoundRect(button1, cw, cw, rc);
        canvas.drawRoundRect(button2, cw, cw, rc);
        canvas.drawRoundRect(button3, cw, cw, rc);

        rc.setShader(null);
        rc.setStrokeWidth(6);
        rc.setStyle(Paint.Style.STROKE);

        rc.setColor(Color.argb(255, 50, 50, 50));

        canvas.drawRoundRect(position, 0, 0, rc);
        BG.drawPathTab(canvas, tab0, rc);
        BG.drawPathTab(canvas, tab1, rc);
        BG.drawPathTab(canvas, tab2, rc);
        BG.drawPathTab(canvas, tab3, rc);
        BG.drawPathTab(canvas, tab4, rc);

        canvas.drawRoundRect(button0, cw, cw, rc);
        canvas.drawRoundRect(button1, cw, cw, rc);
        canvas.drawRoundRect(button2, cw, cw, rc);
        canvas.drawRoundRect(button3, cw, cw, rc);

        rc.setStyle(Paint.Style.FILL);


        clicker = getRects(position, 5);


        if (tab == 0) {

            rc.setStyle(Paint.Style.FILL);

            rc.setColor(Color.argb(100, 50, 50, 50));

            for (Circle item : level.getCircles()) {

                rc.setColor(Color.argb(150, 255, 255, 255));
                RectF r = clicker.get(item.getPoint());
                canvas.drawCircle(r.centerX(), r.centerY(), r.width() / 4, rc);
                rc.setColor(Color.argb(175, C.getRedArray()[item.getColor()], C.getGreenArray()[item.getColor()], C.getBlueArray()[item.getColor()]));
                canvas.drawCircle(r.centerX(), r.centerY(), r.width() / 4, rc);

            }
            rc.setStyle(Paint.Style.STROKE);


            rc.setStrokeWidth(6);
            rc.setAntiAlias(true);

            for (RectF r : clicker.values()) {
                rc.setStyle(Paint.Style.FILL);
                rc.setColor(Color.argb(10, 255, 255, 255));
                canvas.drawCircle(r.centerX(), r.centerY(), r.width() / 4, rc);
                rc.setStyle(Paint.Style.STROKE);
                rc.setColor(Color.argb(255, 50, 50, 50));
                canvas.drawCircle(r.centerX(), r.centerY(), r.width() / 4, rc);
            }
        }


        if (active != null) {
            Circle item = level.getActive(active);
            if (item != null) {
                rc.setStyle(Paint.Style.FILL);
                rc.setColor(Color.argb(150, C.getRedArray()[item.getColor()], C.getGreenArray()[item.getColor()], C.getBlueArray()[item.getColor()]));

                BG.drawPathTab(canvas, tab1, rc);
            }

        }


        if (tab == 2 && place != null) {
            for (CircleView circleView : place.allViews()) {
                circleView.move();
            }

            place.drawMe(canvas, new Rect((int) position.left, (int) position.top, (int) position.right, (int) position.bottom));


        }

        rc.setStyle(Paint.Style.FILL);

        rc.setColor(Color.argb(200, 10, 120, 70));

        if (tab == 0) {
            BG.drawPathTab(canvas, tab0, rc);


        }

        if (tab == 1) {
            BG.drawPathTab(canvas, tab1, rc);


        }

        if (tab == 2) {
            BG.drawPathTab(canvas, tab2, rc);


        }


        if (tab == 3) {
            BG.drawPathTab(canvas, tab3, rc);


        }

        if (tab == 4) {
            BG.drawPathTab(canvas, tab4, rc);


        }

        rc.setStyle(Paint.Style.FILL);

        rc.setTextSize(tabs.height() / 3.5f);
        rc.setFakeBoldText(true);
        rc.setAntiAlias(true);

        drawText(canvas, rc, tab0, R.string.menu_editor_board, tab == 0 ? Color.argb(255, 255, 255, 255) : Color.argb(255, 0, 0, 0), true);
        drawText(canvas, rc, tab1, R.string.menu_editor_properties, tab == 1 ? Color.argb(255, 255, 255, 255) : Color.argb(255, 0, 0, 0), true);
        drawText(canvas, rc, tab2, R.string.menu_editor_preview, tab == 2 ? Color.argb(255, 255, 255, 255) : Color.argb(255, 0, 0, 0), true);
        drawText(canvas, rc, tab3, R.string.menu_editor_level, tab == 3 ? Color.argb(255, 255, 255, 255) : Color.argb(255, 0, 0, 0), true);
        drawText(canvas, rc, tab4, R.string.menu_editor_help, tab == 4 ? Color.argb(255, 255, 255, 255) : Color.argb(255, 0, 0, 0), true);


        drawText(canvas, rc, button0, R.string.menu_editor_back, Color.argb(255, 0, 0, 0), true);
        drawText(canvas, rc, button1, R.string.menu_editor_delete, Color.argb(255, 0, 0, 0), true);
        drawText(canvas, rc, button2, R.string.menu_editor_save, Color.argb(255, 0, 0, 0), true);
        drawText(canvas, rc, button3, R.string.menu_editor_del, Color.argb(255, 0, 0, 0), true);

        rc.setTextSize(topper.height() / 3f);
        drawText(canvas, rc, topper, TE.get(R.string.menu_editor_plain) + level != null ? level.getName() : "", Color.argb(255, 0, 0, 0), true);

        if ((tab == 1 || tab == 3)) {
            rc.setTextSize(topper.height() / 3.5f);
            if (active != null && tab == 1) {


                Circle item = level.getActive(active);
                if (item != null) {
                    drawColor(R.string.editor_value_color, new RectF(position.left, position.top + h * 1, position.right, position.top + h * 2.5f), rc, canvas, Color.argb(150, C.getRedArray()[item.getColor()], C.getGreenArray()[item.getColor()], C.getBlueArray()[item.getColor()]));
                    drawValue(R.string.editor_value_speed, new RectF(position.left, position.top + h * 3, position.right, position.top + h * 4.5f), rc, canvas, String.valueOf(item.getMover()), 1, 20, 0, 1);
                    drawValue(R.string.editor_value_length, new RectF(position.left, position.top + h * 4.5f, position.right, position.top + h * 6f), rc, canvas, String.valueOf(item.getLength()), 1, 5, 1, 1);
                    drawValue(R.string.editor_value_postion, new RectF(position.left, position.top + h * 6f, position.right, position.top + h * 7.5f), rc, canvas, String.valueOf(item.getPosition()), 0, 360, 2, 10);
                    drawValue(R.string.editor_value_inverse, new RectF(position.left, position.top + h * 7.5f, position.right, position.top + h * 9f), rc, canvas, String.valueOf(item.getInverse()), 0, 1, 3, 1);
                    drawValue(R.string.editor_value_next, new RectF(position.left, position.top + h * 9f, position.right, position.top + h * 10.5f), rc, canvas, String.valueOf(item.getNext()), 5, 30, 4, 1);
                    drawValue(R.string.editor_value_faktor, new RectF(position.left, position.top + h * 10.5f, position.right, position.top + h * 12f), rc, canvas, String.valueOf(item.getFaktor()), 2, 20, 5, 1);
                    drawValue(R.string.editor_value_freaky, new RectF(position.left, position.top + h * 12f, position.right, position.top + h * 13.5f), rc, canvas, String.valueOf(item.getFreaky()), 1, 99, 11, 1);

                    props = false;
                }
            }

            if (tab == 3) {


                drawEdit(R.string.editor_level_name, new RectF(position.left, position.top + h * 1, position.right, position.top + h * 2.5f), rc, canvas, String.valueOf(level.getName()));
                drawValue(R.string.editor_level_min, new RectF(position.left, position.top + h * 3, position.right, position.top + h * 4.5f), rc, canvas, String.valueOf(level.getMin()), 10, 200, 6, 10);
                drawValue(R.string.editor_level_med, new RectF(position.left, position.top + h * 4.5f, position.right, position.top + h * 6f), rc, canvas, String.valueOf(level.getMed()), level.getMin() + 10, 250, 7, 10);
                drawValue(R.string.editor_level_max, new RectF(position.left, position.top + h * 6f, position.right, position.top + h * 7.5f), rc, canvas, String.valueOf(level.getMax()), level.getMed() + 10, 300, 8, 10);
                props = false;
            }

        }
        if (mm == 10) {
            stop = !stop;
            mm = 0;

        }
        mm++;

        overlay.draw(canvas);
    }

    private void drawColor(int id, RectF rc, Paint p, Canvas canvas, int color) {
        RectF rc1 = new RectF(rc.left, rc.top, rc.left + rc.width() / 3, rc.bottom);
        RectF rc2 = new RectF(rc.left + rc.width() / 4, rc.top, rc.left + (rc.width() / 3) * 2, rc.bottom);
        RectF rc3 = new RectF(rc.right - rc.width() / 3, rc.top + rc.height() / 8, rc.right, rc.bottom - rc.height() / 8);

        float seed = rc.width() / 10;
        rc2 = new RectF(rc2.left + seed, rc2.top - seed / 4, rc2.right - seed, rc2.bottom - seed / 4);


        drawText(canvas, p, rc1, id, Color.argb(255, 50, 50, 50), false);
        int old = p.getColor();
        Paint.Style st = p.getStyle();
        p.setColor(color);
        p.setStyle(Paint.Style.FILL);
        canvas.drawCircle(rc2.centerX() - rc2.width() / 2.5f, rc2.centerY(), rc2.width() / 3f, p);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(6);
        p.setColor(Color.argb(255, 50, 50, 50));
        canvas.drawCircle(rc2.centerX() - rc2.width() / 2.5f, rc2.centerY(), rc2.width() / 3f, p);
        p.setStyle(Paint.Style.FILL);

        p.setStyle(st);
        p.setColor(old);

        int art = 10;
        int min = 0;
        int max = 9;
        if (art >= 0) {

            float w = rc3.width() / 20;
            RectF rcPlus = new RectF(rc3.left + w, rc3.top + w / 4, (rc3.right - rc3.width() / 2) - w, rc3.bottom - w / 4);

            RectF rcMinus = new RectF((rc3.right - rc3.width() / 2) + w, rc3.top + w / 4, rc3.right - w, rc3.bottom - w / 4);
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(6);
            canvas.drawRoundRect(rcPlus, w, w, p);
            canvas.drawRoundRect(rcMinus, w, w, p);
            p.setStyle(Paint.Style.FILL);

            drawText(canvas, p, rcPlus, "+", Color.argb(255, 50, 50, 50), true, 5);
            drawText(canvas, p, rcMinus, "-", Color.argb(255, 50, 50, 50), true, 5);

            if (props)
                properties.add(new IntegerProperty(rcMinus, rcPlus, min, max, art, 1));

        }
    }


    private void drawEdit(int id, RectF rc, Paint p, Canvas canvas, String value) {
        RectF rc1 = new RectF(rc.left, rc.top, rc.left + rc.width() / 3, rc.bottom);
        RectF rc2 = new RectF(rc.left + rc.width() / 3, rc.top + rc.height() / 8, rc.right - rc.width() / 40, rc.bottom - rc.height() / 8);


        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(6);
        p.setPathEffect(new DashPathEffect(new float[]{10f, 10f}, 10f));
        canvas.drawRoundRect(rc2, rc.width() / 40, rc.width() / 40, p);

        if (view.text.getVisibility() == View.VISIBLE && editProp != null && editProp.equals(rc2)) {
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.argb(128, 255, 255, 255));
            canvas.drawRoundRect(rc2, rc2.width() / 20, rc2.width() / 20, p);
            if (!stop) {
                p.setColor(Color.argb(175, 50, 50, 50));

                float o = p.getTextSize();
                p.setTextSize(rc.height() / 3.5f);
                float w1 = p.measureText(value);
                w1 *= 1.36f;
                float h1 = rc2.height() / 10;
                RectF r1 = new RectF((rc2.left + w1*2), rc2.top + h1 * 2, (rc2.left + w1) + h1 / 2, rc2.bottom - h1 * 2);
                canvas.drawRect(r1, p);
                p.setTextSize(o);
            }

        }
        p.setPathEffect(null);

        p.setStyle(Paint.Style.FILL);
        drawText(canvas, p, rc1, id, Color.argb(255, 50, 50, 50), false);
        drawText(canvas, p, rc2, value, Color.argb(255, 50, 50, 50), false);
        if (props)
            properties.add(new StringProperty(value, rc2));


    }

    private void drawValue(int id, RectF rc, Paint p, Canvas canvas, String value, int min, int max, int art, int step) {
        RectF rc1 = new RectF(rc.left, rc.top, rc.left + rc.width() / 3, rc.bottom);
        RectF rc2 = new RectF(rc.left + rc.width() / 3, rc.top, rc.right - rc.width() / 3, rc.bottom);
        RectF rc3 = new RectF(rc.right - rc.width() / 3, rc.top + rc.height() / 8, rc.right, rc.bottom - rc.height() / 8);


        drawText(canvas, p, rc1, id, Color.argb(255, 50, 50, 50), false);
        drawText(canvas, p, rc2, value, Color.argb(255, 50, 50, 50), false);

        if (art >= 0) {

            float w = rc3.width() / 20;
            RectF rcPlus = new RectF(rc3.left + w, rc3.top + w / 4, (rc3.right - rc3.width() / 2) - w, rc3.bottom - w / 4);

            RectF rcMinus = new RectF((rc3.right - rc3.width() / 2) + w, rc3.top + w / 4, rc3.right - w, rc3.bottom - w / 4);
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(6);
            canvas.drawRoundRect(rcPlus, w, w, p);
            canvas.drawRoundRect(rcMinus, w, w, p);
            p.setStyle(Paint.Style.FILL);

            drawText(canvas, p, rcPlus, "+", Color.argb(255, 50, 50, 50), true, 5);
            drawText(canvas, p, rcMinus, "-", Color.argb(255, 50, 50, 50), true, 5);
            if (props)
                properties.add(new IntegerProperty(rcMinus, rcPlus, min, max, art, step));

        }

    }

    private void drawText(Canvas canvas, Paint rc, RectF tab, int res, int color, boolean center) {
        String text = TE.get(res);
        drawText(canvas, rc, tab, text, color, center);
    }

    private void drawText(Canvas canvas, Paint rc, RectF tab, String res, int color, boolean center) {
        drawText(canvas, rc, tab, res, color, center, 10);

    }

    private void drawText(Canvas canvas, Paint rc, RectF tab, String res, int color, boolean center, int seed) {
        String text = res;
        rc.setColor(color);
        float wt = rc.measureText(text);
        canvas.drawText(text, center ? tab.centerX() - (wt / 2) : tab.left + 8, tab.centerY() + tab.height() / seed, rc);
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

        if (overlay.closed) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {

                if (tab0.contains(event.getX(), event.getY())) {
                    propMe();

                    tab = 0;
                }
                if (tab1.contains(event.getX(), event.getY())) {
                    propMe();

                    tab = 1;

                }

                if (tab3.contains(event.getX(), event.getY())) {
                    propMe();

                    tab = 3;

                }

                if (tab4.contains(event.getX(), event.getY())) {
                    propMe();

                    tab = 4;

                }
                if (tab2.contains(event.getX(), event.getY())) {
                    propMe();

                    tab = 2;

                    place = new PlacementCircleView(getContext(), "");
                    place.start(level);
                    place.simulate = true;
                    for (Circle c : level.getCircles()) {
                        int ff = c.getFaktor() + 8;
                        if (ff > 10) {
                            int fk = 10;
                            ff -= fk;
                            fk += ff / 2;
                            ff = fk;
                        }
                        CircleView cc = new CircleView(place, C.getRedArray()[c.getColor()], C.getGreenArray()[c.getColor()], C.getBlueArray()[c.getColor()], c.getMover() * 4, c.getPosx(), c.getPosy(), c.getDirection(), c.getLength(), c.getInverse(), c.getPosition(), c.getNext(), ff, c.getFreaky());
                        cc.simulate = true;
                        place.addAll(cc);
                    }
                }

                if (tab == 2) {
                    place.onTouchEvent(event);
                }

                if (tab == 1 || tab == 3) {
                    for (Property ii : properties) {
                        if (ii.hit(event.getX(), event.getY()))
                            break;
                    }
                }

                if (button1.contains(event.getX(), event.getY())) {
                    tab = 0;
                    if (level.getCircles().size() > 0) {
                        level.getCircles().remove(level.getCircles().get(level.getCircles().size() - 1));
                        active = null;
                    }
                }

                if (button0.contains(event.getX(), event.getY())) {
                    view.finish();
                }


                if (button2.contains(event.getX(), event.getY())) {
                    setLayerType(LAYER_TYPE_SOFTWARE, null);
                    view.update();
                    overlay.activate(new Runnable() {
                        @Override
                        public void run() {
                            LevelSet s = Levels.getSet(TE.get(R.string.bundle_basic));

                            if (!s.getLevels().contains(level))
                                s.add(level);

                            Levels.updateLevel(level, true);
                            if (place != null)
                                place.start(null);
                            view.finish();
                        }
                    }, TE.get(R.string.overlay_editor_store_title), TE.get(R.string.overlay_editor_store_text));

                }

                if (button3.contains(event.getX(), event.getY())) {

                    setLayerType(LAYER_TYPE_SOFTWARE, null);
                    view.update();
                    overlay.activate(new Runnable() {
                        @Override
                        public void run() {
                            LevelSet s = Levels.getSet(TE.get(R.string.bundle_basic));

                            if (s.getLevels().contains(level))
                                s.getLevels().remove(level);

                            Levels.updateSet(s);

                            if (place != null)
                                place.start(null);
                            view.finish();
                        }
                    }, new Runnable() {
                        @Override
                        public void run() {
                            overlay.closed = true;
                            setLayerType(LAYER_TYPE_HARDWARE, null);
                            view.update();
                        }
                    }, TE.get(R.string.overlay_editor_save_yes), TE.get(R.string.overlay_editor_save_no), TE.get(R.string.overlay_editor_save_title), TE.get(R.string.overlay_editor_save_text));

                }
                if (tab == 0) {
                    for (Map.Entry<Point, RectF> item : clicker.entrySet()) {
                        if (item.getValue().contains(event.getX(), event.getY()) && level.getActive(item.getKey()) == null) {
                            if (add(item.getKey(), item.getValue()))
                                active = item.getKey();
                        } else {

                            if (item.getValue().contains(event.getX(), event.getY()) && level.getActive(item.getKey()) != null) {
                                if (active == null || active.hashCode() != item.getKey().hashCode()) {
                                    active = item.getKey();
                                    propMe();

                                } else {
                                    active = null;
                                    propMe();

                                }

                            }
                        }
                    }
                }
            }
        } else {
            overlay.onTouchEvent(event);
        }
        return false;
    }

    private void propMe() {
        editProp = null;
        for (Property p : properties)
            p.handle();
        props = true;
        properties.clear();
    }


    private boolean add(Point p, RectF r) {
        int s = level.getCircles().size();


        if (s < max) {
            Holder h = getHolder(p);
            level.add(new Circle(2, h.x, h.y, h.direction, 1, 0, 0, 10, 2, p.x, p.y, Circle.CircleColorEnum.values()[level.getCircles().size()].ordinal()));
            return true;
        }

        return false;
    }


    public static Holder getHolder(Point p) {

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


    static class Holder {
        public Holder(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        int x;
        int y;
        int direction;
    }

    interface Property<T> {
        boolean hit(float x, float y);

        T getValue();

        void handle();

        void setValue(T value);
    }


    class StringProperty implements LevelEditorView.Property<String> {
        String value = "";
        RectF rc = null;
        boolean show = false;

        public StringProperty(String value, RectF rc) {
            this.value = value;
            this.rc = rc;
        }

        public boolean hit(float x, float y) {
            if (editProp == null && rc.contains(x, y)) {
                editProp = rc;
                view.text.setText(value);
                view.text.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) {

                            view.text.setVisibility(View.INVISIBLE);
                        }
                    }
                });
                view.text.setVisibility(View.VISIBLE);
                view.text.requestFocus();

                final Property<String> that = this;
                view.text.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        that.setValue(s.toString());
                    }
                });

                InputMethodManager keyboard = (InputMethodManager) view.getSystemService(Context.INPUT_METHOD_SERVICE);

                keyboard.toggleSoftInputFromWindow(view.text.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
                show = true;

                return true;
            }
            if (show)

            {
                handle();
            }
            return false;
        }

        @Override
        public String getValue() {
            return level.getName();
        }

        @Override
        public void handle() {

            if (show)

            {
                InputMethodManager keyboard = (InputMethodManager) view.getSystemService(Context.INPUT_METHOD_SERVICE);

                keyboard.toggleSoftInputFromWindow(view.text.getApplicationWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                view.text.setVisibility(View.INVISIBLE);
                show = false;
            }
        }

        @Override
        public void setValue(String value) {
            value = value;
            level.setName(value);
        }


    }

    class IntegerProperty implements Property<Integer> {
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
                } else {
                    v = max;
                }
                setValue(v);
                return true;

            } else {
                if (rcMax.contains(x, y)) {

                    if (v < max) {
                        v += step;
                    } else {
                        v = min;
                    }
                    setValue(v);
                    return true;
                }
            }
            return false;
        }

        public Integer getValue() {
            Circle act = active != null ? level.getActive(active) : null;
            if (property == 0) return act.getMover();
            if (property == 1) return act.getLength();
            if (property == 2) return act.getPosition();
            if (property == 3) return act.getInverse();
            if (property == 4) return act.getNext();
            if (property == 5) return act.getFaktor();

            if (property == 6) return level.getMin();
            if (property == 7) return level.getMed();
            if (property == 8) return level.getMax();
            if (property == 10) return act.getColor();
            if (property == 11) return act.getFreaky();


            return 0;
        }

        @Override
        public void handle() {

        }

        public void setValue(Integer value) {
            Circle act = active != null ? level.getActive(active) : null;
            if (property == 0) act.setMover(value);
            if (property == 1) act.setLength(value);
            if (property == 2) act.setPosition(value);
            if (property == 3) act.setInverse(value);
            if (property == 4) act.setNext(value);
            if (property == 5) act.setFaktor(value);

            if (property == 6) level.setMin(value);
            if (property == 7) level.setMed(value);
            if (property == 8) level.setMax(value);

            if (property == 10) act.setColor(value);
            if (property == 11) act.setFreaky(value);


        }
    }

}
