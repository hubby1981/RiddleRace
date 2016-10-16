package biitworx.games.race.riddle.riddlerace;

import android.content.Context;
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

import biitworx.games.race.riddle.riddlerace.data.helper.poco.Level;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.LevelSet;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.Levels;

/**
 * Created by marcel.weissgerber on 13.10.2016.
 */

public class LevelView extends View {
    private Paint back = new Paint();
    public String name = "";
    LevelSet set;
    public LevelChooser instance;

    public int greenLight = Color.argb(255, 100, 175, 130);
    public int green = Color.argb(255, 50, 130, 70);
    public int blueLight = Color.argb(255, 100, 160, 190);
    public int blue = Color.argb(255, 50, 100, 130);
    public int grayLight = Color.argb(255, 180, 180, 180);
    public int gray = Color.argb(255, 120, 120, 120);
    private HashMap<RectF, Game> games = new HashMap<>();

    private List<Level> all = new ArrayList<>();

    public LevelView(Context context, AttributeSet attrs) {
        super(context, attrs);

        back.setStyle(Paint.Style.FILL);
        back.setColor(Color.argb(255, 255, 240, 220));

        name = attrs.getAttributeValue(null, "name");

        set = Levels.getSet(name);
    }

    @Override
    public void onDraw(Canvas canvas) {
        games.clear();
        all.clear();
        Rect inner = canvas.getClipBounds();
        canvas.drawRect(inner, back);
        int seed = inner.height() / 20;
        Rect topper = new Rect(inner.left, inner.top, inner.right, inner.top + inner.height() / 10);

        Paint tp = new Paint();
        tp.setStyle(Paint.Style.FILL_AND_STROKE);
        tp.setTextSize(topper.height() / 3);
        tp.setColor(Color.argb(255, 50, 50, 50));
        tp.setFakeBoldText(true);
        String nn = name + " - Stars: " + String.valueOf(set.getCollected()) + " / " + String.valueOf(set.getStars());
        float tw = tp.measureText(nn);

        canvas.drawText(nn, topper.centerX() - tw / 2, topper.centerY()-tw/16, tp);

        int lv = 4;
        int w = inner.width() / lv;
        int top = inner.top + seed;
        int index = 0;
        if (set != null) {
            for (Level item : set.getLevels()) {

                Rect rc = new Rect(inner.left + (w * index), top, inner.left + (w * (index + 1)), top + w);
                drawTile(canvas, item.getName(), rc);
                index++;
                if (index == lv) {
                    index = 0;
                    top += w;
                }
            }
        }
    }

    private void drawTile(Canvas canvas, String name, Rect inner) {

        Level level = Levels.getLevel(name);
        int aa = 12;

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

        Paint tileStroke = new Paint();
        tileStroke.setStyle(Paint.Style.STROKE);
        tileStroke.setColor(Color.argb(255, 50, 50, 50));
        tileStroke.setStrokeWidth(2);

      /* Paint back2 = new Paint();
        back2.setStyle(Paint.Style.FILL);
        back2.setShader(new RadialGradient(inner3.centerX(), inner3.centerY(), inner3.width(), Color.DKGRAY, back.getColor(), Shader.TileMode.MIRROR));

        canvas.drawRoundRect(inner3, inner3.width() / 5, inner3.width() / 5, back2);*/
        //canvas.drawRoundRect(inner3, inner3.width() / 10, inner3.width() / 10, tileStroke);
        canvas.drawRoundRect(inner2, inner2.width() / 10, inner2.width() / 10, tileBack);
        canvas.drawRoundRect(inner2, inner2.width() / 10, inner2.width() / 10, tileStroke);


        tileStroke.setStrokeWidth(0);

        String name2 = name.contains(" ") ? name.split(" ")[0] : name;
        String name3 = name.contains(" ") ? name.split(" ")[1] : "";
        tileStroke.setPathEffect(null);
        tileStroke.setTextSize(inner2.width() / 8);
        tileStroke.setFakeBoldText(true);
        tileStroke.setStyle(Paint.Style.FILL_AND_STROKE);
        if (bAdd) {
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
        canvas.drawText(tt, inner2.centerX() - w / 2, inner2.bottom - (inner2.width() / 10), tileStroke);

        Rect stars = new Rect((int) inner2.left, (int) (inner2.bottom - inner2.height() / 6), (int) inner2.right, (int) inner2.bottom);
        int ws = (int) (stars.width() / 8.8f);
        int score = level != null ? level.getScore() : 0;
        int min = level != null ? level.getMin() : 1000;
        int med = level != null ? level.getMed() : 1000;
        int max = level != null ? level.getMax() : 1000;


        makeStar(canvas, new Rect(stars.left + (int) (ws * 2), stars.top - (int) (1 * ws), stars.left + (int) (3 * ws), stars.bottom - (int) (1 * ws)), score >= min);
        makeStar(canvas, new Rect(stars.left + (int) (ws * 4), stars.top - (int) (2 * ws), stars.left + (int) (5 * ws), stars.bottom - (int) (2 * ws)), score >= med);
        makeStar(canvas, new Rect(stars.left + (int) (ws * 6), stars.top - (int) (1 * ws), stars.left + (int) (7 * ws), stars.bottom - (int) (1 * ws)), score >= max);

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
                    instance.openActivity(item.getValue().level);
            }
        }
        return false;
    }

    public class Game {

        public String name;
        public Level level;
    }
}
