package biitworx.games.race.riddle.riddlerace;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by marce_000 on 10.10.2016.
 */
public class CircleView extends View {
    private Paint carLine = new Paint();
    private int position = 0;
    private int mover = 6;
    private int posx = 0;
    private int posy = 0;
    private int direction = 0;
    private String name = "";

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);


        carLine.setStyle(Paint.Style.FILL_AND_STROKE);
        carLine.setAntiAlias(true);
        carLine.setColor(Color.argb(255,
                Integer.parseInt(attrs.getAttributeValue(null, "red"))
                , Integer.parseInt(attrs.getAttributeValue(null, "green"))
                , Integer.parseInt(attrs.getAttributeValue(null, "blue"))));
        mover = Integer.parseInt(attrs.getAttributeValue(null, "speed"));
        posx = Integer.parseInt(attrs.getAttributeValue(null, "position-x"));
        posy = Integer.parseInt(attrs.getAttributeValue(null, "position-y"));
        direction = Integer.parseInt(attrs.getAttributeValue(null, "direction"));
        name = attrs.getAttributeValue(null, "name");
    }

    @Override
    public void onDraw(Canvas canvas) {
        Rect rc = canvas.getClipBounds();
        if (direction > 0) {
            rc.top += (rc.height() / 100) * posy;

            rc.left += (rc.width() / 100) * posx;
        } else {
            rc.top -= (rc.height() / 100) * posy;

            rc.left -= (rc.width() / 100) * posx;
        }
        int distance = rc.width() / 20;
        int distance2 = rc.width() / 30;

        float rad = 1.65f;
        Rect rc2 = new Rect(rc.left - (int) ((distance) * rad),
                rc.top - (int) ((distance) * rad),
                rc.right + (int) ((distance) * rad),
                rc.bottom + (int) ((distance) * rad));


        Rect rc1 = drawWithDegree(canvas, position, distance2, rc2);
        PlacementCircleView.line(name, rc);

        canvas.drawRoundRect(rc1.left, rc1.top, rc1.right, rc1.bottom, rc1.width() / 3, rc1.height() / 3, carLine);

        PlacementCircleView.circle(name, rc1);

    }

    public void move() {
        position += mover;
        if (position > 360)
            position = 0;
    }


    private Rect drawWithDegree(Canvas canvas, int degree, float size, Rect display) {
        float xc1 = (float) Math.sin(Math.toRadians(degree)) * (float) (display.width() / 3.5);
        float yc1 = (float) Math.cos(Math.toRadians(degree)) * (float) (display.width() / 3.5);
        float x = display.exactCenterX() + xc1;
        float y = display.exactCenterY() - yc1;

        float w = (float) (size / 1.1);
        Rect rc = new Rect((int) (x - w / 2), (int) (y - w / 2), (int) (x + w / 2), (int) (y + w / 2));

        return rc;
    }

}
