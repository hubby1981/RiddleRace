package biitworx.games.race.riddle.riddlerace;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by marce_000 on 10.10.2016.
 */
public class PlacementCircleView extends View {
    private Paint circleLine = new Paint();
    private static HashMap<CircleView, Rect> lines = new HashMap<>();
    private static HashMap<CircleView, Rect> circles = new HashMap<>();

    public PlacementCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        circleLine.setStyle(Paint.Style.STROKE);
        circleLine.setAntiAlias(true);
        circleLine.setColor(Color.argb(255, 150, 150, 150));

    }

    @Override
    public void onDraw(Canvas canvas) {
        circleLine.setStrokeWidth(canvas.getClipBounds().width() / 20);
        for (Rect rc : lines.values()) {
            canvas.drawCircle(rc.exactCenterX(), rc.exactCenterY(), rc.width() / 3, circleLine);
        }
    }


    public static void line(CircleView name, Rect rc) {
        lines.put(name, rc);
    }

    public static void circle(CircleView name, Rect rc) {
        circles.put(name, rc);
    }


    public boolean hasHit() {

        if (circles.size() > 0) {
            Rect first = null;
            for (Rect rc : circles.values()) {
                if (first == null) {
                    first = rc;
                } else {
                    if (rc.contains(first.centerX(), first.centerY()))
                        return true;
                }
            }
        }
        return false;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            for (Map.Entry<CircleView, Rect> item : lines.entrySet()) {

                int x = (int) event.getX();
                int y = (int) event.getY();

                if (item.getValue().contains(x, y)) {
                    item.getKey().hit = !item.getKey().hit;

                }
            }
        }
        return false;
    }
}
