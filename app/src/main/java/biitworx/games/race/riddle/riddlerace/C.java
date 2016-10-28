package biitworx.games.race.riddle.riddlerace;

import android.graphics.Color;

/**
 * Created by marcel.weissgerber on 26.10.2016.
 */

public class C {

    public static int greenLight = Color.argb(255, 100, 175, 130);
    public static int green = Color.argb(255, 50, 130, 70);
    public static int blueLight = Color.argb(255, 100, 160, 190);
    public static int blue = Color.argb(255, 50, 100, 130);
    public static int grayLight = Color.argb(255, 180, 180, 180);
    public static int gray = Color.argb(255, 120, 120, 120);
    public static  int redLight = Color.argb(255, 255, 160, 160);
    public static int red = Color.argb(255, 180, 60, 60);

    public static int[] getRedArray() {
        return new int[]{76, 224, 33, 103, 255, 0, 205, 233, 25, 253};
    }

    public static int[] getGreenArray() {
        return new int[]{175, 67, 150, 58, 87, 150, 220, 30, 25, 216};
    }

    public static int[] getBlueArray() {
        return new int[]{80, 54, 243, 183, 34, 136, 57, 99, 25, 53};
    }
}
