package biitworx.games.race.riddle.riddlerace;

import android.content.Context;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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
import java.util.UUID;

import biitworx.games.race.riddle.riddlerace.data.helper.poco.Level;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.LevelSet;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.Levels;

/**
 * Created by marcel.weissgerber on 13.10.2016.
 */

public class LevelView extends View {

    public String name = "";
    LevelSet set;
    RectF menu;
    RectF prev;
    RectF next;

    public LevelChooser instance;

    public int greenLight = Color.argb(255, 100, 175, 130);
    public int green = Color.argb(255, 50, 130, 70);
    public int blueLight = Color.argb(255, 100, 160, 190);
    public int blue = Color.argb(255, 50, 100, 130);
    public int grayLight = Color.argb(255, 180, 180, 180);
    public int gray = Color.argb(255, 120, 120, 120);
    private HashMap<RectF, Game> games = new HashMap<>();

    private List<Level> all = new ArrayList<>();

    public boolean edit = false;

    private int nn = 0;

    int maxPage = 20;
    int maxLine = 4;
    int pageA = 0;
    int pageN = 0;
    int pageMax = 9;
    private List<Level> subs = new ArrayList<>();

    public LevelView(Context context, AttributeSet attrs) {
        super(context, attrs);


        name = attrs.getAttributeValue(null, "name");

        set = Levels.getSet(name);
    }

    private int getCollected() {
        int result = 0;
        for (Level l : subs) {
            result += l.getScore()>=l.getMax()?3:l.getScore()>=l.getMed()?2:l.getScore()>=l.getMin()?1:0;
        }
        return result;
    }
    private int getStars() {
        return (int)(subs.size()*2.5f);
    }
    @Override
    public void onDraw(Canvas canvas) {
        if (!edit) {
            int mod = set.getLevels().size() % maxPage;
            pageMax = set.getLevels().size() / maxPage;
            if (mod == 0) {
                pageMax -= 1;
            }
        }
        pageN = set.getLevels().size() / maxPage;
        nn = 0;
        games.clear();
        all.clear();
        Rect inner = canvas.getClipBounds();
        Paint back = new Paint();
        back.setStyle(Paint.Style.FILL);

        back.setColor(Color.argb(255, 255, 240, 220));
        canvas.drawRect(inner, back);
        back.setShader(new BitmapShader(MainMenu.back002, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR));
        canvas.drawRect(inner, back);


        int seed = inner.height() / 20;
        Rect topper = new Rect(inner.left, inner.top, inner.right, inner.top + inner.height() / 10);
        Rect bottom = new Rect(inner.left, inner.bottom - inner.height() / 10, inner.right, inner.bottom);

        int s1 = (pageA * maxPage);
        int s2 = s1 + maxPage;
        if (!edit) {
            if (set.getLevels().size() < s2)
                s2 = set.getLevels().size();
            subs = set.getLevels().subList(s1, s2);
        }
        // back.setShader(new RadialGradient(inner.centerX(), inner.centerY(), inner.width(), Color.argb(255, 255, 240, 220), Color.argb(255, 240, 230, 180), Shader.TileMode.MIRROR));

        Paint tp = new Paint();
        tp.setStyle(Paint.Style.FILL_AND_STROKE);
        tp.setTextSize(topper.height() / 3);
        tp.setColor(Color.argb(255, 50, 50, 50));
        tp.setFakeBoldText(true);
        tp.setShadowLayer(4, 0, 0, Color.argb(200, 50, 50, 50));


        String nn = edit?TE.get(R.string.menu_editor): TE.get(R.string.menu_level_view_title) +" "+ String.valueOf(getCollected()) + " / " + String.valueOf(getStars());
        float tw = tp.measureText(nn);

        canvas.drawText(nn, topper.centerX() - tw / 2, topper.centerY() - tw / 20, tp);


        int ne = bottom.height() / 10;
        RectF next = new RectF(bottom.left + ne, bottom.top + ne, (bottom.left + bottom.width() / 2) - ne, bottom.bottom - ne);
        String text = TE.get(R.string.resource_menu_back);
        menu = next;
        Paint ap = new Paint();
        ap.setShader(new RadialGradient(next.centerX(), next.centerY(), next.width(), blueLight, blue, Shader.TileMode.MIRROR));

        ap.setStyle(Paint.Style.FILL_AND_STROKE);
        ap.setColor(Color.argb(255, 50, 50, 50));
        ap.setStrokeWidth(4);
        ap.setAntiAlias(true);
        canvas.drawRoundRect(next, ne, ne, ap);
        ap.setShader(null);

        ap.setShader(new BitmapShader(MainMenu.back001, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR));
        canvas.drawRoundRect(next, ne, ne, ap);
        ap.setShader(null);
        ap.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(next, ne, ne, ap);


        ap.setTextSize(next.height() / 3);
        ap.setFakeBoldText(true);
        float apw = ap.measureText(text);
        ap.setStyle(Paint.Style.FILL);
        ap.setColor(Color.argb(255, 255, 255, 255));

        float py = next.centerY() + apw / 16;
        canvas.drawText(text, next.centerX() - apw / 2, py, ap);

        float ww = next.width() / 2;
        this.prev = next = new RectF((bottom.left + bottom.width() / 2) + ne, bottom.top + ne, (bottom.right - ne) - ww, bottom.bottom - ne);
        doButton(canvas, ne, next, ap, py, R.string.resource_menu_prev);
        this.next = next = new RectF(((bottom.left + bottom.width() / 2) + ne + ne) + ww, bottom.top + ne, (bottom.right - ne), bottom.bottom - ne);

        doButton(canvas, ne, next, ap, py, R.string.resource_menu_next);

        int lv = maxLine;
        int w = inner.width() / lv;
        int top = inner.top + seed;
        int index = 0;

        if (edit) {
            for (int ix = s1; ix < s2; ix++) {
                Rect rc = new Rect(inner.left + (w * index), top, inner.left + (w * (index + 1)), top + w);
                UUID id = null;
                if (set != null && set.getLevels().size() > ix)
                    id = set.getLevels().get(ix).getUID();
                drawTile(canvas, id, "Level " + String.valueOf(ix + 1) + " - " + TE.get(R.string.editor_level_name_std), rc, ix);
                index++;
                if (index == lv) {
                    index = 0;
                    top += w;
                }
                this.nn++;
            }
        } else {
            if (set != null) {
                for (Level item : set.getLevels().subList(s1, s2)) {

                    Rect rc = new Rect(inner.left + (w * index), top, inner.left + (w * (index + 1)), top + w);
                    drawTile(canvas, item.getUID(), item.getName(), rc, set.getLevels().indexOf(item));
                    index++;
                    if (index == lv) {
                        index = 0;
                        top += w;
                    }

                }
            }
        }

    }

    private void doButton(Canvas canvas, int ne, RectF next, Paint ap, float py, int id) {
        String text;
        float apw;
        int col1 = grayLight;
        int col2 = gray;

        if (pageA > 0 && next.equals(this.prev)) {
            col1 = blueLight;
            col2 = blue;
        }
        if (pageA < pageMax && next.equals(this.next)) {
            col1 = blueLight;
            col2 = blue;
        }


        ap.setShader(new RadialGradient(next.centerX(), next.centerY(), next.width(), col1, col2, Shader.TileMode.MIRROR));

        ap.setStyle(Paint.Style.FILL_AND_STROKE);
        ap.setColor(Color.argb(255, 50, 50, 50));
        ap.setStrokeWidth(4);
        ap.setAntiAlias(true);
        canvas.drawRoundRect(next, ne, ne, ap);
        ap.setShader(null);
        ap.setShader(new BitmapShader(MainMenu.back001, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR));
        canvas.drawRoundRect(next, ne, ne, ap);

        ap.setShader(null);

        ap.setStyle(Paint.Style.STROKE);


        canvas.drawRoundRect(next, ne, ne, ap);

        text = TE.get(id);
        ap.setTextSize(next.height() / 3);
        ap.setFakeBoldText(true);
        apw = ap.measureText(text);
        ap.setStyle(Paint.Style.FILL);
        ap.setColor(Color.argb(255, 255, 255, 255));
        canvas.drawText(text, next.centerX() - apw / 2, py, ap);
    }

    private void drawTile(Canvas canvas, UUID id, String name, Rect inner, int index) {

        Level level = Levels.getLevel(id);

        int aa = 15;

        RectF inner2 = new RectF(inner.left + inner.width() / aa, inner.top + inner.width() / aa, inner.right - inner.width() / aa, inner.bottom - inner.width() / aa);
        RectF inner3 = new RectF(inner.left + inner.width() / 20, inner.top + inner.width() / 20, inner.right - inner.width() / 20, inner.bottom - inner.width() / 20);

        boolean bAdd = false;


        if (level != null && all.size() > 0) {

            Level l1 = all.get(all.size() - 1);
            if (l1.getScore() >= l1.getMin()) {

                bAdd = true;

            }
        }

        if (all.size() == 0) {
            bAdd = true;
        }
        all.add(level);
        Game g = new Game();

        g.level = level;
        g.name = name;
        Paint tileBack = new Paint();
        tileBack.setStyle(Paint.Style.FILL);

        boolean bColor = true;
        if (edit) {

            bAdd = true;

            if (level != null) {
                tileBack.setColor(green);
                tileBack.setShader(new RadialGradient(inner2.centerX(), inner2.centerY(), inner2.width(), greenLight, green, Shader.TileMode.MIRROR));


            } else {
                if (this.nn > set.getLevels().size())
                    bAdd = false;
                else {
                    level = new Level(name, 10, 20, 30, name, true);
                    g.level = level;
                    g.name = name;
                }

                if (bAdd && set.getLevels().size() >= index) {
                    tileBack.setShader(new RadialGradient(inner2.centerX(), inner2.centerY(), inner2.width(), blueLight, blue, Shader.TileMode.MIRROR));
                } else {
                    tileBack.setShader(new RadialGradient(inner2.centerX(), inner2.centerY(), inner2.width(), grayLight, gray, Shader.TileMode.MIRROR));
                    bColor = false;
                    bAdd=false;
                }


            }
        } else {
            bAdd = true;
            if (bAdd) {


                if (level != null && level.getScore() >= level.getMin()) {
                    tileBack.setColor(green);

                    tileBack.setShader(new RadialGradient(inner2.centerX(), inner2.centerY(), inner2.width(), greenLight, green, Shader.TileMode.MIRROR));

                } else {

                    tileBack.setColor(blue);

                    tileBack.setShader(new RadialGradient(inner2.centerX(), inner2.centerY(), inner2.width(), blueLight, blue, Shader.TileMode.MIRROR));

                }
            } else {

                tileBack.setColor(gray);

                tileBack.setShader(new RadialGradient(inner2.centerX(), inner2.centerY(), inner2.width(), grayLight, gray, Shader.TileMode.MIRROR));


            }
        }


        Paint tileStroke = new Paint();
        tileStroke.setStyle(Paint.Style.STROKE);
        tileStroke.setColor(Color.argb(255, 50, 50, 50));
        tileStroke.setAntiAlias(true);
        tileStroke.setStrokeWidth(3);

      /* Paint back2 = new Paint();
        back2.setStyle(Paint.Style.FILL);
        back2.setShader(new RadialGradient(inner3.centerX(), inner3.centerY(), inner3.width(), Color.DKGRAY, back.getColor(), Shader.TileMode.MIRROR));

        canvas.drawRoundRect(inner3, inner3.width() / 5, inner3.width() / 5, back2);*/
        //canvas.drawRoundRect(inner3, inner3.width() / 10, inner3.width() / 10, tileStroke);


        canvas.drawRoundRect(inner2, inner2.width() / 10, inner2.width() / 10, tileBack);
        tileBack.setShader(new BitmapShader(MainMenu.back001, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR));

        canvas.drawRoundRect(inner2, inner2.width() / 10, inner2.width() / 10, tileBack);

        canvas.drawRoundRect(inner2, inner2.width() / 10, inner2.width() / 10, tileStroke);


        tileStroke.setStrokeWidth(0);

        String name2 = name.contains(" ") ? name.split(" ")[0] : name;
        String name3 = name.contains(" ") ? name.split(" ")[1] : "";
        tileStroke.setPathEffect(null);
        tileStroke.setTextSize(inner2.width() / 8);
        tileStroke.setFakeBoldText(true);
        tileStroke.setStyle(Paint.Style.FILL_AND_STROKE);
        if (bAdd && bColor) {
            tileStroke.setColor(Color.argb(255, 255, 255, 255));

        }

        float w = tileStroke.measureText(name2);

        canvas.drawText(name2, inner2.centerX() - w / 2, inner2.top + inner2.width() / 6, tileStroke);
        tileStroke.setTextSize(inner2.width() / 4);

        w = tileStroke.measureText(name3);
        canvas.drawText(name3, inner2.centerX() - w / 2, inner2.top + (inner2.width() / 4) * 2, tileStroke);
        tileStroke.setTextSize(inner2.width() / 8);
        String tt = level != null ? String.valueOf(level.getScore()) : "0";
        w = tileStroke.measureText(tt);
        if (!edit) {
            canvas.drawText(tt, inner2.centerX() - w / 2, inner2.bottom - (inner2.width() / 10), tileStroke);
        } else {

            String nameA = level != null ? level.getName() : name;
            String an = nameA.contains(" - ") ? nameA.split(" - ")[1] : nameA;
            w = tileStroke.measureText(an);
            canvas.drawText(an, inner2.centerX() - w / 2, inner2.bottom - (inner2.width() / 10), tileStroke);

        }

        Rect stars = new Rect((int) inner2.left, (int) (inner2.bottom - inner2.height() / 6), (int) inner2.right, (int) inner2.bottom);
        int ws = (int) (stars.width() / 8.8f);
        int score = level != null ? level.getScore() : 0;
        int min = level != null ? level.getMin() : 1000;
        int med = level != null ? level.getMed() : 1000;
        int max = level != null ? level.getMax() : 1000;

        if (!edit) {
            makeStar(canvas, new Rect(stars.left + (int) (ws * 2), stars.top - (int) (1 * ws), stars.left + (int) (3 * ws), stars.bottom - (int) (1 * ws)), score >= min);
            makeStar(canvas, new Rect(stars.left + (int) (ws * 4), stars.top - (int) (2 * ws), stars.left + (int) (5 * ws), stars.bottom - (int) (2 * ws)), score >= med);
            makeStar(canvas, new Rect(stars.left + (int) (ws * 6), stars.top - (int) (1 * ws), stars.left + (int) (7 * ws), stars.bottom - (int) (1 * ws)), score >= max);
        }
        if (bAdd) {
            games.put(inner2, g);
        }

    }

    public void makeStar(Canvas canvas, Rect inner, boolean filled) {

        Path path = new Path();
        int w = inner.width() / 4;
        path.moveTo(inner.centerX(), inner.top);
        path.lineTo(inner.centerX() + w, inner.centerY() - w);
        path.lineTo(inner.right + w, inner.centerY() - w);
        path.lineTo(inner.centerX() + w * 1.5f, inner.centerY() + w / 2);
        path.lineTo(inner.right, inner.bottom - w / 2);
        path.lineTo(inner.centerX(), inner.centerY() + w);
        path.lineTo(inner.left, inner.bottom - w / 2);
        path.lineTo(inner.centerX() - w * 1.5f, inner.centerY() + w / 2);
        path.lineTo(inner.left - w, inner.centerY() - w);
        path.lineTo(inner.centerX() - w, inner.centerY() - w);
        path.lineTo(inner.centerX(), inner.top);
        path.close();

        Paint p = new Paint();

        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(2);

        p.setAntiAlias(true);
        p.setColor(Color.argb(255, 255, 255, 255));


        Paint p1 = new Paint();

        p1.setStyle(Paint.Style.FILL);

        if (filled) {
            p1.setColor(Color.argb(255, 255, 255, 255));

            canvas.drawPath(path, p1);

        } else {
            canvas.drawPath(path, p);
        }


        //canvas.drawPath(path, p);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN && instance != null) {
            for (Map.Entry<RectF, Game> item : games.entrySet()) {
                if (item.getKey().contains(event.getX(), event.getY()))
                    if (!edit) {
                        instance.openActivity(item.getValue().level);
                    } else {
                        instance.openEditActivity(item.getValue().level);
                    }

            }
            if (menu != null) {
                if (menu.contains(event.getX(), event.getY()))
                    instance.finish();
            }

            if (next.contains(event.getX(), event.getY())) {
                if (pageA < pageMax)
                    pageA++;
            }
            if (prev.contains(event.getX(), event.getY())) {
                if (pageA > 0)
                    pageA--;
            }

        }
        return false;
    }

    public class Game {

        public String name;
        public Level level;
    }
}