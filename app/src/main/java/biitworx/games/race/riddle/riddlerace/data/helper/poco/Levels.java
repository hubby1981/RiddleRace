package biitworx.games.race.riddle.riddlerace.data.helper.poco;

import java.util.ArrayList;
import java.util.List;

import biitworx.games.race.riddle.riddlerace.LevelChooser;
import biitworx.games.race.riddle.riddlerace.levels.basic.bundle.BasicBundle;

/**
 * Created by marce_000 on 12.10.2016.
 */
public class Levels {

    private static List<Level> levels = new ArrayList<>();

    static {
        levels = LevelChooser.DATA.getData(Level.class, LevelChooser.DATA.get(), true);
        if(levels==null || levels.size()==0){
            setup();
        }

    }

    public static Level getLevel(String name) {
        for (Level l : levels)
            if (l.getName().equals(name))
                return l;
        return null;
    }

    public static int indexOf(Level level) {
        return levels.indexOf(level);
    }


    public static Level get(int index) {
        if (index > -1 && index < levels.size()) {
            return levels.get(index);

        }
        return null;
    }


    public static void addLevel(Level level) {
        levels.add(level);
        LevelChooser.DATA.insert(level, true, LevelChooser.DATA.get());
    }

    public static void updateLevel(Level level) {

        LevelChooser.DATA.insert(level, false, LevelChooser.DATA.get());
    }


    private static void setup(){
        levels.add(BasicBundle.setupLevel1());
        levels.add(BasicBundle.setupLevel2());
        levels.add(BasicBundle.setupLevel3());
        levels.add(BasicBundle.setupLevel4());
        levels.add(BasicBundle.setupLevel5());
        levels.add(BasicBundle.setupLevel6());
        levels.add(BasicBundle.setupLevel7());


        for(Level l : levels)
            LevelChooser.DATA.insert(l,true,LevelChooser.DATA.get());
    }
}
