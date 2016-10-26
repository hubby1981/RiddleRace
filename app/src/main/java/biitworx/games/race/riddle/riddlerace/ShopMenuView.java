package biitworx.games.race.riddle.riddlerace;

import android.content.Context;
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
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by marcel.weissgerber on 26.10.2016.
 */

public class ShopMenuView extends View {
    public ShopView shop;
    RectF item0;
    RectF item1;
    RectF item2;

    public ShopMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void onDraw(Canvas canvas) {

        int top = BG.buildStdBackground(canvas, canvas.getClipBounds());

        float h = 0;
        int w = 0;
        RectF inner = new RectF(canvas.getClipBounds());
        h = inner.height() / 30;
        inner = new RectF(inner.left + h, inner.top + top + h, inner.right - h, inner.bottom - h);

        float size = inner.height() / 8;
        RectF title = new RectF(inner.left, inner.top - size * 1, inner.right, inner.top - size * 0);
        item0 = new RectF(inner.left, inner.top + size * 1, inner.right, inner.top + size * 2);
        item1 = new RectF(inner.left, inner.top + size * 2.5f, inner.right, inner.top + size * 3.5f);
        item2 = new RectF(inner.left, inner.top + size * 4, inner.right, inner.top + size * 5);
        float cw = item0.height() / 10;

        RectF state0 = new RectF((item0.left + item0.width() / 2) + cw *8, item0.top + cw * 2, item0.right - cw * 2, item0.bottom - cw * 2);
        RectF state1 = new RectF((item1.left + item1.width() / 2) + cw *8, item1.top + cw * 2, item1.right - cw * 2, item1.bottom - cw * 2);
        RectF state2 = new RectF((item2.left + item2.width() / 2) + cw *8, item2.top + cw * 2, item2.right - cw * 2, item2.bottom - cw * 2);

        Paint text = new Paint();
        text.setTextSize(title.height() / 1.5f);
        text.setFakeBoldText(true);
        text.setStyle(Paint.Style.FILL);
        BG.drawText(canvas, text, title, TE.get(R.string.menu_shop), Color.argb(255, 50, 50, 50), true, 1);
        text.setTextSize(title.height() / 3.5f);

        Paint back = new Paint();
        back.setColor(Color.argb(75, 50, 50, 50));
        back.setStyle(Paint.Style.FILL);

        canvas.drawRoundRect(item0, cw, cw, back);
        canvas.drawRoundRect(item1, cw, cw, back);
        canvas.drawRoundRect(item2, cw, cw, back);
        back.setColor(Color.argb(255, 50, 50, 50));

        back.setStyle(Paint.Style.STROKE);
        back.setStrokeWidth(6);
        canvas.drawRoundRect(item0, cw, cw, back);
        canvas.drawRoundRect(item1, cw, cw, back);
        canvas.drawRoundRect(item2, cw, cw, back);

        BG.drawText(canvas, text, item0, TE.get(R.string.shop_buy_item_0), Color.argb(255, 255, 255, 255), false, 12);
        BG.drawText(canvas, text, item1, TE.get(R.string.shop_buy_item_1), Color.argb(255, 255, 255, 255), false, 12);
        BG.drawText(canvas, text, item2, TE.get(R.string.shop_buy_item_2), Color.argb(255, 255, 255, 255), false, 12);


        text.setTextSize(title.height() / 4.5f);

        BG.drawText(canvas, text, item0,
                MainMenu.user.isEditor() ? TE.get(R.string.shop_state_1) : TE.get(R.string.shop_state_0),
                MainMenu.user.isEditor() ? C.green : C.red, false, 2.5f);

        BG.drawText(canvas, text, item1,
                MainMenu.user.isAds() ? TE.get(R.string.shop_state_1) : TE.get(R.string.shop_state_0),
                MainMenu.user.isAds() ? C.green : C.red, false, 2.5f);
        BG.drawText(canvas, text, item2,
                MainMenu.user.isCommunity() ? TE.get(R.string.shop_state_1) : TE.get(R.string.shop_state_0),
                MainMenu.user.isCommunity() ? C.green : C.red, false, 2.5f);
        text.setTextSize(title.height() / 3.5f);

        if (!MainMenu.user.isEditor()) {
            drawBuyButton(canvas, cw, state0, text, back);
        }

        if (!MainMenu.user.isAds()) {
            drawBuyButton(canvas, cw, state1, text, back);
        }

        if (!MainMenu.user.isCommunity()) {
            drawBuyButton(canvas, cw, state2, text, back);
        }
    }

    private void drawBuyButton(Canvas canvas, float cw, RectF state0, Paint text, Paint back) {
        back.setColor(C.greenLight);
        back.setShader(new RadialGradient(state0.centerX(), state0.centerY(), state0.width() / 2, C.greenLight, C.green, Shader.TileMode.MIRROR));
        back.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(state0, cw, cw, back);
        back.setColor(Color.argb(175, 255, 255, 255));

        canvas.drawRoundRect(state0, cw, cw, back);


        back.setColor(Color.argb(255, 50, 50, 50));
        back.setShader(null);
        back.setStyle(Paint.Style.STROKE);
        back.setStrokeWidth(6);
        canvas.drawRoundRect(state0, cw, cw, back);

        BG.drawText(canvas, text, state0, TE.get(R.string.overlay_editor_buy_yes), Color.WHITE, true, 10);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        shop.finish();
        return false;
    }
}
