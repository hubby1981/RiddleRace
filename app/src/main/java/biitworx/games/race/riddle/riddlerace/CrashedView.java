package biitworx.games.race.riddle.riddlerace;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by marcel.weissgerber on 13.10.2016.
 */

public class CrashedView {

    private int colorGreen = Color.argb(255, 80, 170, 130);
    private int colorRed = Color.argb(255, 250, 100, 100);
    private int colorBlue = Color.argb(255, 80, 160, 200);
    private int colorRedLight = Color.argb(138, 250, 100, 100);
    Rect retry = null;
    Rect abort = null;
    Rect next = null;

    String crash1 = "Your riddles crashed!";
    String crash2 = "You should try it again!";
    String t1 = "Retry";
    String t2 = "Abort";
    String t3 = "Next";

    Paint text = new Paint();

    public void onDraw(Canvas canvas) {

        Rect inner = canvas.getClipBounds();
        inner = new Rect(inner.left, inner.centerY() - inner.height() / 8, inner.right, inner.centerY() + inner.height() / 8);

        Paint back = new Paint();
        back.setStyle(Paint.Style.FILL);

        back.setColor(Color.argb(140, 255, 255, 255));
        canvas.drawRect(canvas.getClipBounds(), back);

        Rect line1 = new Rect(inner.left, inner.top - inner.height() / 4, inner.right, inner.top);
        Rect line2 = new Rect(inner.left, inner.bottom, inner.right, inner.bottom + inner.height() / 4);

        Rect middle = new Rect(line1.left + line1.height(), line1.bottom + line1.height(), line1.right - line1.height(), line2.top - line1.height());

        int size = middle.width() / 9;
        Rect retry1 = new Rect(middle.left + (size * 1), middle.top, middle.left + (size * 2), middle.bottom);
        Rect abort1 = new Rect(middle.left + (size * 4), middle.top, middle.left + (size * 5), middle.bottom);
        Rect next1 = new Rect(middle.left + (size * 6), middle.top, middle.left + (size * 8), middle.bottom);

        back.setColor(colorGreen);

        canvas.drawCircle(retry1.exactCenterX(), retry1.exactCenterY(), retry1.width() / 2, back);

        back.setTextSize(retry1.height() / 4);
        float wt = back.measureText(t1);
        canvas.drawText(t1, retry1.exactCenterX() - wt / 2, retry1.bottom, back);

        back.setColor(colorRed);

        canvas.drawRoundRect(new RectF(abort1.exactCenterX() - abort1.width() / 2, abort1.exactCenterY() - abort1.height() / 5, abort1.exactCenterX() + abort1.width() / 2, abort1.exactCenterY() + abort1.height() / 5)
                , abort1.width() / 10, abort1.height() / 10, back);
        wt = back.measureText(t2);
        canvas.drawText(t2, abort1.exactCenterX() - wt / 2, abort1.bottom, back);
        back.setColor(colorBlue);
        Path pp = new Path();
        pp.moveTo(next1.right, next1.exactCenterY());
        pp.lineTo(next1.exactCenterX(), next1.bottom - next1.height() / 3.5f);
        pp.lineTo(next1.exactCenterX(), next1.top + next1.height() / 3.5f);
        pp.lineTo(next1.right, next1.exactCenterY());
        pp.close();
        canvas.drawPath(pp, back);

        wt = back.measureText(t3);
        canvas.drawText(t3, next1.exactCenterX() - wt / 4, next1.bottom, back);


        back.setColor(colorRedLight);
        canvas.drawRect(line1, back);
        canvas.drawRect(line2, back);

        text.setStyle(Paint.Style.FILL);
        text.setTextSize(inner.height() / 6);
        text.setColor(colorRedLight);
        float w = text.measureText(crash1);
        canvas.drawText(crash1, line1.centerX() - w / 2, line1.top - line1.height() / 2, text);

        w = text.measureText(crash2);
        canvas.drawText(crash2, line2.centerX() - w / 2, line2.bottom + line2.height(), text);

        retry = retry1;
        abort = abort1;
        next = next1;
    }


    public boolean isRetry(int x, int y) {
        return retry.contains(x, y);
    }

    public boolean isAbort(int x, int y) {
        return abort.contains(x, y);
    }

    public boolean isNext(int x, int y) {
        return next.contains(x, y);
    }
}
