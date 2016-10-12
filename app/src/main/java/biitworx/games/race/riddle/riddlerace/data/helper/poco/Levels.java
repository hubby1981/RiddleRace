package biitworx.games.race.riddle.riddlerace.data.helper.poco;

import java.util.ArrayList;
import java.util.List;

import biitworx.games.race.riddle.riddlerace.LevelChooser;

/**
 * Created by marce_000 on 12.10.2016.
 */
public class Levels {

    private static List<Level> levels=new ArrayList<>();

    static{
        levels = LevelChooser.DATA.getData(Level.class,LevelChooser.DATA.get(),true);

    }
    public static Level getLevel(String name){
        for(Level l:levels)
            if(l.getName().equals(name))
                return l;
        return null;
    }
    
    public static void addLevel(Level level){
        levels.add(level);
        LevelChooser.DATA.insert(level,true,LevelChooser.DATA.get());
    }

    public static void updateLevel(Level level){

        LevelChooser.DATA.insert(level,false,LevelChooser.DATA.get());
    }
}
