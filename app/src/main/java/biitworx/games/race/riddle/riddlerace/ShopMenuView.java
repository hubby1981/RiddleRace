package biitworx.games.race.riddle.riddlerace;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
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

        RectF state0 = new RectF(item0.left+item0.width()/2,item0.top,item0.right,item0.bottom);
        RectF state1 = new RectF(item1.left+item1.width()/2,item1.top,item1.right,item1.bottom);
        RectF state2 = new RectF(item2.left+item2.width()/2,item2.top,item2.right,item2.bottom);


        Paint text = new Paint();
        text.setTextSize(title.height() / 1.5f);
        text.setFakeBoldText(true);
        text.setStyle(Paint.Style.FILL);
        BG.drawText(canvas, text, title, TE.get(R.string.menu_shop), Color.argb(255, 50, 50, 50), true, 1);
        text.setTextSize(title.height() / 3.5f);

        Paint back = new Paint();
        back.setColor(Color.argb(128, 50, 50, 50));
        back.setStyle(Paint.Style.FILL);

        canvas.drawRect(item0, back);
        canvas.drawRect(item1, back);
        canvas.drawRect(item2, back);
        back.setColor(Color.argb(255, 50, 50, 50));

        back.setStyle(Paint.Style.STROKE);
        back.setStrokeWidth(6);
        canvas.drawRect(item0, back);
        canvas.drawRect(item1, back);
        canvas.drawRect(item2, back);

        BG.drawText(canvas, text, item0, TE.get(R.string.shop_buy_item_0), Color.argb(255, 255, 255, 255), false, 12);
        BG.drawText(canvas, text, item1, TE.get(R.string.shop_buy_item_1), Color.argb(255, 255,255,255), false, 12);
        BG.drawText(canvas, text, item2, TE.get(R.string.shop_buy_item_2), Color.argb(255, 255,255,255), false, 12);



        BG.drawText(canvas, text, state0,
                MainMenu.user.isEditor()?TE.get(R.string.shop_state_1):TE.get(R.string.shop_state_0),
                MainMenu.user.isEditor()?C.greenLight:C.redLight, true, 12);

        BG.drawText(canvas, text, state1,
                MainMenu.user.isAds()?TE.get(R.string.shop_state_1):TE.get(R.string.shop_state_0),
                MainMenu.user.isAds()?C.greenLight:C.redLight, true, 12);
        BG.drawText(canvas, text, state2,
                MainMenu.user.isCommunity()?TE.get(R.string.shop_state_1):TE.get(R.string.shop_state_0),
                MainMenu.user.isCommunity()?C.greenLight:C.redLight, true, 12);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        shop.finish();
        return false;
    }
}
