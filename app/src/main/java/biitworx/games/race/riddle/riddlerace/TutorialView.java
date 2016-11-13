package biitworx.games.race.riddle.riddlerace;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by marce on 12.11.2016.
 */

public class TutorialView extends View {
    public TutorialView(Context context, AttributeSet attrs) {
        super(context, attrs);


        place = new PlacementCircleView(context,"Tutorial");
place.simulate=true;
        first=new CircleView(place,C.getRedArray()[0],C.getGreenArray()[0],C.getBlueArray()[0],1,0,0,0,1,0,270,0,8,0);
        place.addAll(first);

    }

    public Tutorial view;

    private PlacementCircleView place;
    private CircleView first;

    @Override
    public void onDraw(Canvas canvas) {


        int top = BG.buildStdBackground(canvas, canvas.getClipBounds());


        RectF inner = new RectF(canvas.getClipBounds());

        RectF title = new RectF(inner.left,inner.top+inner.height()/10,inner.right,inner.top+(inner.height()/10)*2);
        Paint text = new Paint();
        text.setTextSize(title.height() / 3f);
        text.setFakeBoldText(true);
        text.setStyle(Paint.Style.FILL);
        BG.drawText(canvas, text, title, TE.get(R.string.tutorial_title), Color.argb(255, 50, 50, 50), true, 1.5f);

        Rect content = new Rect((int)(inner.left+inner.width()/20),(int)(inner.top+(inner.height()/10)*3),(int)(inner.right-inner.width()/20),(int)(inner.bottom-(inner.height()/10)*2));

        place.drawMe(canvas,content);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (view != null)
            view.finish();
        return true;
    }

}
