package biitworx.games.race.riddle.riddlerace;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by marcel.weissgerber on 17.10.2016.
 */

public class B {
    public static Bitmap get(int id){
        return BitmapFactory.decodeResource(MainMenu.res,id);
    }
}
