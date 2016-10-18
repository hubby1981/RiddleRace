package biitworx.games.race.riddle.riddlerace;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by marcel.weissgerber on 17.10.2016.
 */

public class MainMenuView extends View {
    public int greenLight = Color.argb(255, 100, 175, 130);
    public int green = Color.argb(255, 50, 130, 70);
    public int blueLight = Color.argb(255, 100, 160, 190);
    public int blue = Color.argb(255, 50, 100, 130);
    public int grayLight = Color.argb(255, 180, 180, 180);
    public int gray = Color.argb(255, 120, 120, 120);

    public MainMenu menu;

    public MainMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    RectF setBasic = null;
    RectF options = null;
    RectF tutorial = null;
    RectF shop = null;
    RectF close = null;
    RectF editor = null;

    @Override
    public void onDraw(Canvas canvas) {
        Rect inner = canvas.getClipBounds();

        Paint back = new Paint();
        back.setStyle(Paint.Style.FILL);
        back.setColor(Color.argb(255, 255, 240, 220));

        int h = inner.height() / 12;
        int w = inner.width() / 6;
        Rect img = new Rect(inner.left + w, inner.top + w / 4, inner.right - w, (int) (inner.top + w / 1.5f) + h * 2);
        Bitmap logo = B.get(R.drawable.logo);

        canvas.drawRect(inner, back);

        back.setShader(new BitmapShader(MainMenu.back002, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR));
        canvas.drawRect(inner, back);


        canvas.drawBitmap(logo, new Rect(0, 0, logo.getWidth(), logo.getHeight()), img, null);

        int top = img.bottom + h/2;

        setBasic = new RectF(inner.left + w,top, inner.right - w, top+ h );
        top+=h*1+h/8;
        tutorial = new RectF(inner.left + w, top, inner.right - w, top+h);
        top+=h*1+h/8;

        options = new RectF(inner.left + w, top, inner.right - w,top+h);
        top+=h*1+h/8;

        shop = new RectF(inner.left + w, top, inner.right - w,top+h);
        top+=h*1+h/8;

        editor = new RectF(inner.left + w, top, inner.right - w,top+h);
        top+=h*1+h;


        close = new RectF(inner.left + w, top, inner.right - w,top+h);

        drawButton(canvas, setBasic, TE.get(R.string.menu_play),greenLight, green);
        drawButton(canvas, tutorial, TE.get(R.string.menu_tutorial),blueLight, blue);
        drawButton(canvas, options, TE.get(R.string.menu_options),blueLight, blue);
        drawButton(canvas, shop, TE.get(R.string.menu_shop),blueLight, blue);
        drawButton(canvas, editor, TE.get(R.string.menu_editor),blueLight, blue);

        drawButton(canvas, close, TE.get(R.string.menu_close),blueLight, blue);

    }

    private void drawButton(Canvas canvas, RectF rc, String text,int light,int dark) {
        Paint button = new Paint();
        button.setStyle(Paint.Style.FILL_AND_STROKE);
        button.setColor(Color.argb(255, 50, 50, 50));

        button.setShader(new RadialGradient(rc.centerX(), rc.centerY(), rc.width(), light,dark, Shader.TileMode.MIRROR));
        canvas.drawRoundRect(rc, rc.width() / 20, rc.width() / 20, button);
        button.setShader(new BitmapShader(MainMenu.back001, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR));
        canvas.drawRoundRect(rc, rc.width() / 20, rc.width() / 20, button);
        button.setStrokeWidth(4);
        button.setAntiAlias(true);
        button.setStyle(Paint.Style.STROKE);
        button.setShader(null);

        canvas.drawRoundRect(rc, rc.width() / 20, rc.width() / 20, button);

        button.setStyle(Paint.Style.FILL);

        button.setColor(Color.argb(255, 255, 255, 255));
        button.setTextSize(rc.height() / 2);

        float tw = button.measureText(text);

        canvas.drawText(text, rc.centerX() - tw / 2, rc.centerY()+tw/14, button);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (setBasic.contains(event.getX(), event.getY())) {

                Intent i = new Intent(menu, LevelChooser.class);
                menu.startActivity(i);
            }

            if (close.contains(event.getX(), event.getY())) {

                menu.finish();
            }

            if (editor.contains(event.getX(), event.getY())) {

                Intent i = new Intent(menu, LevelEditor.class);
                menu.startActivity(i);
            }
        }
        return false;
    }
}
