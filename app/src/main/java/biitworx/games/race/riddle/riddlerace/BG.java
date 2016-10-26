package biitworx.games.race.riddle.riddlerace;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;

/**
 * Created by marcel.weissgerber on 26.10.2016.
 */

public class BG {

    public static void drawText(Canvas canvas, Paint rc, RectF tab, String res, int color, boolean center, float seed) {
        String text = res;
        rc.setColor(color);

        float wt = rc.measureText(text);
        canvas.drawText(text, center ? tab.centerX() - (wt / 2) : tab.left + tab.width() / 30, tab.centerY() + tab.height() / seed, rc);
    }

    public static int buildStdBackground(Canvas canvas,Rect inner) {

        Paint back = new Paint();
        back.setStyle(Paint.Style.FILL);
        back.setColor(Color.argb(255, 255, 240, 220));

        int h = inner.height() / 12;
        int w = inner.width() / 12;
        Rect img = new Rect(inner.left + w, inner.top + w / 2, inner.right - w, (int) (inner.top + w / 1.5f) + (int) (h * 1.25f));
        Bitmap logo = B.get(R.drawable.logo);

        canvas.drawRect(inner, back);

        back.setShader(new BitmapShader(MainMenu.back002, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR));
        canvas.drawRect(inner, back);


        canvas.drawBitmap(logo, new Rect(0, 0, logo.getWidth(), logo.getHeight()), img, null);

        return img.bottom + h / 2;
    }
}
