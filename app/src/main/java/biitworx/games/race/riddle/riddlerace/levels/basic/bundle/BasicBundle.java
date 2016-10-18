package biitworx.games.race.riddle.riddlerace.levels.basic.bundle;

import biitworx.games.race.riddle.riddlerace.R;
import biitworx.games.race.riddle.riddlerace.TE;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.Circle;
import biitworx.games.race.riddle.riddlerace.data.helper.poco.Level;
import biitworx.games.race.riddle.riddlerace.levels.basic.*;


/**
 * Created by marcel.weissgerber on 13.10.2016.
 */

public class BasicBundle {


    public static Level setupLevel1(){
        Level level = new Level(TE.get(R.string.bundle_basic_level_1),30,40,50,TE.get(R.string.bundle_basic_level_2));
        level.add(new Circle( 50,
                200,
                100,
                3,
                15,
                0,
                1,
                1,
                1,
                270,
                5,
                2));
        level.add(new Circle( 220,
                90,
                90,
                3,
                15,
                0,
                0,
                1,
                0,
                270,
                10,
                2));

        return level;
    }

    public static Level setupLevel2(){

        Level level = new Level(TE.get(R.string.bundle_basic_level_2),40 ,50 ,60,TE.get(R.string.bundle_basic_level_3));
        level.add(new Circle(   50,
                200,
                100,
                2,
                15,
                0,
                1,
                1,
                1,
                270,
                20,
                2));
        level.add(new Circle( 220,
                90,
                90,
                3,
                15,
                0,
                0,
                1,
                0,
                90,
                20,
                2));
        level.add(new Circle(  90,
                170,
                220,
                3,
                0,
                15,
                1,
                1,
                0,
                0,
                20,
                2));
        return level;
    }
    public static Level setupLevel3(){

        Level level = new Level(TE.get(R.string.bundle_basic_level_3),50 ,60,70,TE.get(R.string.bundle_basic_level_4));
        level.add(new Circle(     50,
                200,
                100,
                2,
                10,
                10,
                1,
                1,
                1,
                270,
                20,
                2));
        level.add(new Circle(  220,
                90,
                90,
                5,
                10,
                10,
                0,
                1,
                0,
                90,
                20,
                2));
        level.add(new Circle(  90,
                170,
                220,
                3,
                0,
                0,
                1,
                1,
                0,
                0,
                20,
                2));
        return level;
    }
    public static Level setupLevel5(){


        Level level = new Level(TE.get(R.string.bundle_basic_level_5),50,60,70,TE.get(R.string.bundle_basic_level_6));
        level.add(new Circle(   50,
                200,
                100,
                2,
                15,
                15,
                1,
                1,
                1,
                270,
                20,
                2));
        level.add(new Circle(      220,
                90,
                90,
                2,
                15,
                15,
                0,
                1,
                0,
                90,
                20,
                2));
        level.add(new Circle(      90,
                170,
                220,
                2,
                15,
                15,
                2,
                1,
                0,
                0,
                20,
                2));
        level.add(new Circle(         240,
                70,
                240,
                2,
                15,
                15,
                3,
                1,
                0,
                0,
                20,
                2));
        return level;
    }
    public static Level setupLevel6(){

        Level level = new Level(TE.get(R.string.bundle_basic_level_6),50,60,70,TE.get(R.string.bundle_basic_level_6));
        level.add(new Circle(   50,
                200,
                100,
                2,
                0,
                10,
                1,
                1,
                1,
                270,
                20,
                2));
        level.add(new Circle(       220,
                90,
                90,
                2,
                0,
                10,
                0,
                1,
                0,
                90,
                20,
                2));
        level.add(new Circle(  90,
                170,
                220,
                2,
                10,
                0,
                2,
                1,
                0,
                0,
                20,
                2));
        level.add(new Circle(  240,
                70,
                240,
                3,
                10,
                0,
                3,
                1,
                0,
                0,
                20,
                2));
        return level;
    }
    public static Level setupLevel7(){

        Level level = new Level(TE.get(R.string.bundle_basic_level_7),50,60,70,TE.get(R.string.bundle_basic_level_1));
        level.add(new Circle(    50,
                200,
                100,
                2,
                0,
                15,
                1,
                1,
                1,
                270,
                20,
                2));
        level.add(new Circle(         220,
                90,
                90,
                2,
                0,
                0,
                0,
                1,
                0,
                90,
                20,
                2));
        level.add(new Circle(    90,
                170,
                220,
                2,
                10,
                10,
                2,
                1,
                0,
                0,
                20,
                2));
        level.add(new Circle(   240,
                70,
                240,
                3,
                10,
                10,
                1,
                1,
                0,
                0,
                20,
                2));
        level.add(new Circle(    240,
                200,
                80,
                3,
                0,
                15,
                0,
                1,
                0,
                0,
                20,
                2));
        return level;
    }
    public static Level setupLevel4(){


        Level level = new Level(TE.get(R.string.bundle_basic_level_4),50 ,60,70,TE.get(R.string.bundle_basic_level_5));
        level.add(new Circle(  50,
                200,
                100,
                2,
                0,
                15,
                1,
                1,
                1,
                270,
                20,
                2));
        level.add(new Circle(   220,
                90,
                90,
                2,
                0,
                15,
                0,
                1,
                0,
                90,
                20,
                2));
        level.add(new Circle(     220,
                220,
                40,
                2,
                0,
                0,
                1,
                1,
                0,
                0,
                20,
                2));
        return level;
    }
}
